
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brunosousa
 */
public class fillTABLESPACES implements Runnable {
    Connection sys, work;

    public fillTABLESPACES(Connection sys, Connection work) {
        this.sys = sys;
        this.work = work;
    }

    @Override
    public void run() {
        System.out.println("TABLESPACES :: START");
        try {
            Statement stmt1 = sys.createStatement();
            Statement stmt2 = work.createStatement();
            ResultSet rs1= stmt1.executeQuery("SELECT DBA_TABLESPACES.TABLESPACE_NAME, DBA_TABLESPACE_USAGE_METRICS.TABLESPACE_SIZE, DBA_TABLESPACE_USAGE_METRICS.USED_SPACE, DBA_TABLESPACES.CONTENTS "
                                            + "FROM DBA_TABLESPACES, DBA_TABLESPACE_USAGE_METRICS "
                                            + "WHERE DBA_TABLESPACES.TABLESPACE_NAME = DBA_TABLESPACE_USAGE_METRICS.TABLESPACE_NAME");
            System.out.println("TABLESPACES :: FILLING");
            int i=0;
            while(rs1.next()) {
                stmt2.executeUpdate("INSERT INTO TABLESPACES "
                                   + "VALUES ("+(i++)+", '"+rs1.getString(1)+"', "+rs1.getInt(2)+", "+(rs1.getInt(2)-rs1.getInt(3))+", "+rs1.getInt(3)+", '"+rs1.getString(4)+"')");
            }
            System.out.println("TABLESPACES :: COMPLETED");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
