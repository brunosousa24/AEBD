
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
public class fillSESSION implements Runnable {
    Connection sys, work;

    public fillSESSION(Connection sys, Connection work) {
        this.sys = sys;
        this.work = work;
    }
    
    @Override
    public void run() {
        System.out.println("SESSIONS :: START");
        try {Statement stmt1 = sys.createStatement();
            Statement stmt2 = work.createStatement();
            ResultSet rs1= stmt1.executeQuery("SELECT V.SESSION_ID, V.SAMPLE_TIME_UTC, V.SQL_PLAN_OPERATION, V.SESSION_TYPE, V.SESSION_STATE, V.USER_ID, V.SQL_ID, V.WAIT_TIME, V.TIME_WAITED "
                                            + "FROM V_$ACTIVE_SESSION_HISTORY V");
            System.out.println("SESSIONS :: FILLING");
            int i=0;
            while(rs1.next()) {
                stmt2.executeUpdate("INSERT INTO SESSIONS "
                                   + "VALUES ("+(i++)+", "+rs1.getInt(1)+", "+(rs1.getDate(2)!=null ? ("'"+rs1.getDate(2)+"'") : null)+", '"+rs1.getString(3)+"', '"+rs1.getString(4)+"', '"+rs1.getString(5)+"', "+rs1.getInt(6)+", '"+rs1.getString(7)+"', "+rs1.getInt(8)+", "+rs1.getInt(9)+")");
            }
            System.out.println("SESSIONS :: COMPLETED");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
