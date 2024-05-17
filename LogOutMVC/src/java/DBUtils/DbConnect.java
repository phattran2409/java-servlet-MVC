/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ADMIN
 */
public class DbConnect {
    
    public static Connection getConnection() {
         Connection conn =null; 
          try {
                
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            String dbURL = "jdbc:sqlserver://DESKTOP-9HSQ90N\\PHAT:1433;encrypt=true;trustServerCertificate=true;databaseName=UserManagement";
            String user = "sa";
            String pass = "123";
             conn = DriverManager.getConnection(dbURL, user, pass);
     
           
                  
            
            
            } catch (SQLException e) {
                System.out.println("Errors connec to database");
            } 
      return conn;
   }
    public static void main(String[] args) {
         try {
             Connection  conn = getConnection(); 
             if (conn != null) {
                 System.out.println("established");
             }else {
                 System.out.println("cant connect");
             }
         }catch (Exception e) {
             e.printStackTrace();
         }
    }
    

}
