/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.Account;
import DbContext.dbContext;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.tomcat.dbcp.dbcp2.cpdsadapter.DriverAdapterCPDS;
/**
 *
 * @author ADMIN
 */
public class loginDao {
  Connection connection =null;
  PreparedStatement ps = null; 
  ResultSet rs = null;
   
   
//    public Account checkLogin(String user, String password) {
//        try {
//            String querry = "select * from  account ac where ac.userName = ?   AND ac.passwords = ?";
//            connection = new 
//     
//        } catch () {
//        }
//        return null;
//    }
   public static boolean validate(String name, String pass) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

   

        try {
          
             DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            String dbURL = "jdbc:sqlserver://DESKTOP-9HSQ90N\\PHAT:1433;encrypt=true;trustServerCertificate=true;databaseName=Employee";
            String user = "sa";
            String pasword = "123";
            conn = DriverManager.getConnection(dbURL, user, pasword); 
            
            System.out.println("database name : "+conn.getCatalog());
            
            

            pst = conn.prepareStatement("SELECT * FROM Account WHERE userName=? and passwords=?");
            pst.setString(1, name);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            status = rs.next();
        }

        catch (Exception e) {
            System.out.println(e);
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }
	
}
