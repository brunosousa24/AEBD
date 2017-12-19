/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Ricardo
 */
public class ConectionSys {
    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        return DriverManager.getConnection("jdbc:oracle:thin:sys/sys@localhost:1521/orcl","sys as sysdba","oracle");
    }
}