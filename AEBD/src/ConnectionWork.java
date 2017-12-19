/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ricardo
 */
public class ConnectionWork implements Runnable{
    Connection work;
    
    public Connection getConnection() {
        return work;
    }

    @Override
    public void run() {
        System.out.println("Starting Connection With WORK");
        try { 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.work = DriverManager.getConnection("jdbc:oracle:thin:Work/Work@localhost:1521/orcl","Work","work1");
            System.out.println("Successeful Connection With WORK");
        } catch (Exception ex) {
            Logger.getLogger(ConnectionSys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
        
