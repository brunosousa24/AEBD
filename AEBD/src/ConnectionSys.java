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
public class ConnectionSys implements Runnable{
    
    Connection sys;
    
    public Connection getConnection() {
        return sys;
    }

    @Override
    public void run() {
        System.out.println("Starting Connection With SYS");
        try { 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.sys = DriverManager.getConnection("jdbc:oracle:thin:sys/sys@localhost:1521/orcl","sys as sysdba","oracle");
            System.out.println("Successeful Connection With SYS");
        } catch (Exception ex) {
            Logger.getLogger(ConnectionSys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}