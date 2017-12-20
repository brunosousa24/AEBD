/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ricardo
 */
public class ConnectionDB{
    
    Connection sys, work;
    
    public ConnectionDB () {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Connection :: START");
            this.sys = DriverManager.getConnection("jdbc:oracle:thin:sys/sys@localhost:1521/orcl","sys as sysdba","oracle");
            System.out.println("Connection :: SYS");
            this.work = DriverManager.getConnection("jdbc:oracle:thin:Work/Work@localhost:1521/orcl","Work","work1");
            System.out.println("Connection :: WORK");
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public Connection getSys() {
        return sys;
    }

    public Connection getWork() {
        return work;
    }
}