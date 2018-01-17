
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brunosousa
 */
public class main {
    
    public static void main(String[] argv) throws SQLException, ClassNotFoundException, InterruptedException{
        ConnectionDB con = new ConnectionDB();
        /*Criar conexões com BD's*/
        Connection sys = con.getSys();
        Connection work = con.getWork();
        
        
        System.out.println("::::START CLEANING OUR DB::::");
        clearTables(work);
        System.out.println("::::END CLEANING OUR DB::::");
        
        System.out.println("::::START FILLING OUR DB::::");
        
        //Fills Independent tables
        
        Thread t6 = new Thread(new fillCPU(sys,work));
        t6.start();
        Thread t7 = new Thread(new fillSQLCOMMANDS(sys,work));
        t7.start();/*
        Thread t8 = new Thread(new fillMEMORYSTORAGE(sys,work));
        t8.start();
        Thread t9 = new Thread(new fillSESSION(sys,work));
        t9.start();*/
        
        
        //Fills Tablespaces
        Thread t1 = new Thread(new fillTABLESPACES(sys,work));
        t1.start();
        
        //Fills Roles
        Thread t2 = new Thread(new fillROLES(sys,work));
        t2.start();
        
        //waits until tablespaces are filled and fills users and datafiles
        t1.join();
        Thread t3 = new Thread(new fillUSERS(sys,work));
        t3.start();
        Thread t4 = new Thread(new fillDATAFILES(sys,work));
        t4.start();
        
        //waits until roles and users are filled and fills user_roles
        t2.join();
        t3.join();
        Thread t5 = new Thread(new fillUSERROLES(sys,work));
        t5.start();
        
        //waits until user_roles and datafiles are filled | END
        t6.join();
        t7.join();/*
        t8.join();
        t9.join();*/
        t4.join();
        t5.join();
        
        System.out.println("::::END FILLING OUR DB::::");
       
        sys.close();
        work.close();
        System.out.println("Connection :: CLOSED");
    }

    private static void clearTables(Connection work) throws SQLException {
        Statement stmt = work.createStatement();
        stmt.executeUpdate("DELETE FROM USERS_ROLES");
        stmt.executeUpdate("DELETE FROM USERS");
        stmt.executeUpdate("DELETE FROM DATAFILES");
        stmt.executeUpdate("DELETE FROM ROLES");
        stmt.executeUpdate("DELETE FROM TABLESPACES");
        
        stmt.executeUpdate("DELETE FROM CPU");
        stmt.executeUpdate("DELETE FROM SQL_COMMANDS");
        stmt.executeUpdate("DELETE FROM MEMORY_STORAGE");
        stmt.executeUpdate("DELETE FROM SESSIONS");
    }
}
