
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
public class fillUSERS implements Runnable {
    Connection sys, work;

    public fillUSERS(Connection sys, Connection work) {
        this.sys = sys;
        this.work = work;
    }

    @Override
    public void run() {
        System.out.println("USERS :: START");
        try {Statement stmt1 = sys.createStatement();
            Statement stmt2 = work.createStatement();
            Statement stmt3 = work.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT DBA_USERS.USER_ID, DBA_USERS.USERNAME, DBA_USERS.ACCOUNT_STATUS, DBA_USERS.EXPIRY_DATE, DBA_USERS.TEMPORARY_TABLESPACE, DBA_USERS.CREATED, DBA_USERS.DEFAULT_TABLESPACE "
                                             + "FROM DBA_USERS");
            System.out.println("USERS :: FILLING");
            while(rs1.next()) {
                ResultSet rs2 = stmt2.executeQuery("SELECT TABLESPACES.ID_TABLESPACE "
                                                 + "FROM TABLESPACES "
                                                 + "WHERE TABLESPACES.NAME = '"+rs1.getString(7)+"'");
                while(rs2.next())
                    stmt3.executeUpdate("INSERT INTO USERS "
                                      + "VALUES ("+rs1.getInt(1)+", '"+rs1.getString(2)+"', '"+rs1.getString(3)+"', "+(rs1.getDate(4)!=null ? ("'"+rs1.getDate(4)+"'") : null)+", '"+rs1.getString(5)+"', "+(rs1.getDate(6)!=null ? ("'"+rs1.getDate(6)+"'") : null)+", null, "+rs2.getInt(1)+")");
            }
            System.out.println("USERS :: COMPLETED");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
