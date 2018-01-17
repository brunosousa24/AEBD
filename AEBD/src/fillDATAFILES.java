
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
public class fillDATAFILES implements Runnable {
    Connection sys, work;

    public fillDATAFILES(Connection sys, Connection work) {
        this.sys = sys;
        this.work = work;
    }

    @Override
    public void run() {
        System.out.println("DATAFILES :: START");
        try {Statement stmt1 = sys.createStatement();
            Statement stmt2 = work.createStatement();
            Statement stmt3 = work.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT DBA_DATA_FILES.FILE_ID, DBA_DATA_FILES.FILE_NAME, DBA_DATA_FILES.BLOCKS, DBA_DATA_FILES.STATUS, DBA_DATA_FILES.TABLESPACE_NAME, DBA_DATA_FILES.MAXBYTES "
                                             + "FROM DBA_DATA_FILES");
            System.out.println("DATAFILES :: FILLING");
            while(rs1.next()) {
                ResultSet rs2 = stmt2.executeQuery("SELECT TABLESPACES.ID_TABLESPACE "
                                                 + "FROM TABLESPACES "
                                                 + "WHERE TABLESPACES.NAME = '"+rs1.getString(5)+"'");
                while(rs2.next())
                    stmt3.executeUpdate("INSERT INTO DATAFILES "
                                      + "VALUES ("+rs1.getInt(1)+", '"+rs1.getString(2)+"', '"+rs1.getString(3)+"', '"+rs1.getString(4)+"', "+rs2.getInt(1)+", "+rs1.getString(6)+")");
            }
            System.out.println("DATAFILES :: COMPLETED");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
