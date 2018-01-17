
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
public class fillCPU implements Runnable {
    Connection sys, work;

    public fillCPU(Connection sys, Connection work) {
        this.sys = sys;
        this.work = work;
    }
    
    @Override
    public void run() {
        System.out.println("CPU :: START");
        try {Statement stmt1 = sys.createStatement();
            Statement stmt2 = work.createStatement();
            ResultSet rs1= stmt1.executeQuery("SELECT DBA_HIST_SQLSTAT.DBID, DBA_HIST_SQLSTAT.SQL_ID, DBA_HIST_SQLSTAT.EXECUTIONS_DELTA, DBA_HIST_SQLSTAT.BUFFER_GETS_DELTA, DBA_HIST_SQLSTAT.DISK_READS_DELTA, DBA_HIST_SQLSTAT.IOWAIT_DELTA, DBA_HIST_SQLSTAT.APWAIT_DELTA, DBA_HIST_SQLSTAT.CPU_TIME_DELTA, DBA_HIST_SQLSTAT.ELAPSED_TIME_DELTA "
                                            + "FROM DBA_HIST_SQLSTAT");
            System.out.println("CPU :: FILLING");
            int i = 0;
            while(rs1.next()) {
                stmt2.executeUpdate("INSERT INTO CPU "
                                   + "VALUES ("+(i++)+", "+rs1.getInt(1)+", '"+rs1.getString(2)+"', "+rs1.getInt(3)+", "+rs1.getInt(4)+", "+rs1.getInt(5)+", "+rs1.getInt(6)+", "+rs1.getInt(7)+", "+rs1.getInt(8)+", "+rs1.getInt(9)+")");
            }
            System.out.println("CPU :: COMPLETED");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
