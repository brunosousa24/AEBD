
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
public class fillSQLCOMMANDS implements Runnable {
    Connection sys, work;

    public fillSQLCOMMANDS(Connection sys, Connection work) {
        this.sys = sys;
        this.work = work;
    }
    
    @Override
    public void run() {
        System.out.println("SQL_COMMANDS :: START");
        try {Statement stmt1 = sys.createStatement();
            Statement stmt2 = work.createStatement();
            ResultSet rs1= stmt1.executeQuery("SELECT DBA_HIST_SQLTEXT.DBID, DBA_HIST_SQLTEXT.SQL_ID, DBA_HIST_SQLTEXT.SQL_TEXT "
                                            + "FROM DBA_HIST_SQLTEXT");
            System.out.println("SQL_COMMANDS :: FILLING");
            int i = 0;
            while(rs1.next()) {
                String sqltext = rs1.getString(3);
                String sqlT = sqltext.replaceAll("'","''");
                stmt2.executeUpdate("INSERT INTO SQL_COMMANDS "
                                   + "VALUES ("+(i++)+", "+rs1.getInt(1)+", '"+rs1.getString(2)+"', '"+sqlT+"')");
            }
            System.out.println("SQL_COMMANDS :: COMPLETED");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
