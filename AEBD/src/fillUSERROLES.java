
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
public class fillUSERROLES implements Runnable {
    Connection sys, work;

    public fillUSERROLES(Connection sys, Connection work) {
        this.sys = sys;
        this.work = work;
    }

    @Override
    public void run() {
        System.out.println("USER_ROLES :: START");
        try {Statement stmt1 = sys.createStatement();
            Statement stmt2 = work.createStatement();
            Statement stmt3 = work.createStatement();
            Statement stmt4 = work.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT DBA_ROLE_PRIVS.GRANTEE, DBA_ROLE_PRIVS.GRANTED_ROLE "
                                             + "FROM DBA_ROLE_PRIVS");
            System.out.println("USER_ROLES :: FILLING");
            int i=0;
            while(rs1.next()) {
                ResultSet rs2 = stmt2.executeQuery("SELECT USERS.ID_USER "
                                                 + "FROM USERS "
                                                 + "WHERE USERS.NAME = '"+rs1.getString(1)+"'");
                ResultSet rs3 = stmt3.executeQuery("SELECT ROLES.ID_ROLE "
                                                 + "FROM ROLES "
                                                 + "WHERE ROLES.NAME = '"+rs1.getString(2)+"'");
                while(rs2.next() && rs3.next())
                    stmt4.executeUpdate("INSERT INTO USERS_ROLES "
                                      + "VALUES ("+(i++)+", "+rs2.getInt(1)+", "+rs3.getInt(1)+")");
            }
            System.out.println("USER_ROLES :: COMPLETED");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
