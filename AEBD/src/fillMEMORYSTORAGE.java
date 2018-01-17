
import java.sql.Connection;
import java.sql.ResultSet;
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
public class fillMEMORYSTORAGE implements Runnable {
    Connection sys, work;

    public fillMEMORYSTORAGE(Connection sys, Connection work) {
        this.sys = sys;
        this.work = work;
    }
    
    @Override
    public void run() {
        System.out.println("MEMORY_STORAGE :: START");
        try {Statement stmt1 = sys.createStatement();
            Statement stmt2 = work.createStatement();
            ResultSet rs1= stmt1.executeQuery("SELECT V.NAME, V.VALUE "
                                            + "FROM V_$SGA V");
            System.out.println("MEMORY_STORAGE :: FILLING");
            int i = 0;
            while(rs1.next()) {
                stmt2.executeUpdate("INSERT INTO MEMORY_STORAGE "
                                   + "VALUES ("+(i++)+", '"+rs1.getString(1)+"', "+rs1.getInt(2)+")");
            }
            System.out.println("MEMORY_STORAGE :: COMPLETED");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
