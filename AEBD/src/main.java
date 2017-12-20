
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
        t4.join();
        t5.join();
        
        
        
        
        
        
        
        
        
        
        /*
        Connection sys = null;
        Connection work = null;
        try{
            System.out.println("Connection with SYS:");
            sys = ConectionSys.connect();
            Statement stmt1= sys.createStatement();
            ResultSet rs1=stmt1.executeQuery("select * from DBA_USERS");  
            while(rs1.next())
                System.out.println(rs1.getString(1)+"\t"+rs1.getInt(2));
            sys.close();  
  
            
            
            
            
            System.out.println("Connection with WORK:");
            work = ConectionWork.connect();
            Statement stmt2=work.createStatement();  
            ResultSet rs2=stmt2.executeQuery("select * from TABLESPACES");
            while(rs2.next())
                System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2));  
            work.close();
        
        
        }catch(Exception e){
            System.out.println(e);
        }*/
    }
}
