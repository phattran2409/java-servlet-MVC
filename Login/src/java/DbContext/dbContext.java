/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DbContext;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class dbContext {
  private static Connection connection = null; 
    
	public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            String dbURL = "jdbc:sqlserver://DESKTOP-9HSQ90N\\PHAT:1433;encrypt=true;trustServerCertificate=true;databaseName=Employee";
            String user = "sa";
            String pass = "123";
            connection = DriverManager.getConnection(dbURL, user, pass);
            
            
            
            } catch (SQLException e) {
               e.printStackTrace();
            } 
            return connection;
        }
    }


}
