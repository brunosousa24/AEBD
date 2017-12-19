
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
public class main {
    
    public static void main(String[] argv){
        Connection sys = null;
        Connection work = null;
        try{
            System.out.println("Connection with SYS:");
            sys = ConectionSys.connect();
            Statement stmt1= sys.createStatement();
            ResultSet rs1=stmt1.executeQuery("select * from DBA_USERS");  
            while(rs1.next())
                System.out.println(rs1.getString(1)+"\t"+rs1.getInt(2));
            sys.close();  
  
            
            
            
            
            System.out.println("Connection with WORK:");
            work = ConectionWork.connect();
            Statement stmt2=work.createStatement();  
            ResultSet rs2=stmt2.executeQuery("select * from TABLESPACES");
            while(rs2.next())
                System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2));  
            work.close();
            
            
            
            
            }catch(Exception e){ 
                System.out.println(e);
            }
    }
}
