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
/**
 *
 * @author Ricardo
 */
public class ConectionSys {
    
    public static void main(String[] argv){
       
        
        try{  
            //step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
            //step2 create  the connection object  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:sys/sys@localhost:1521/orcl","sys as sysdba","oracle");  
  
            //step3 create the statement object  
            
            Statement stmt=con.createStatement();  
  
            //step4 execute query  
            ResultSet rs=stmt.executeQuery("select * from DBA_USERS");  
            System.out.println("DBA_USERS:");
            
            while(rs.next())
                System.out.println(rs.getString(1)+"\t"+rs.getInt(2));  
  
            //step5 close the connection object  
            con.close();  
  
            }catch(Exception e){ 
                System.out.println(e);
            }  
  
       }  
        
        
    }
        
