/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import DBUtils.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class UserDao {

    public UserDao() {
    }
    
    
 public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user= null;
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs= null;
        try {
            conn= DbConnect.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement("select * from tblUsers where userID = ? AND password = ? ");
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs= ptm.executeQuery();
                if(rs.next()){
                    String fullName= rs.getString("fullName");
                    String roleID= rs.getString("roleID");
                    user= new UserDTO(userID, fullName, roleID, "***");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!= null) rs.close();
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return user;
    }
 
 // login with  boolean 
     public static boolean validate(String name, String pass) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
   

        try {
          
//             DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//
//            String dbURL = "jdbc:sqlserver://DESKTOP-9HSQ90N\\PHAT:1433;encrypt=true;trustServerCertificate=true;databaseName=Employee";
//            String user = "sa";
//            String pasword = "123";
//            conn = DriverManager.getConnection(dbURL, user, pasword); 
            
             conn  = DbConnect.getConnection();
            
            System.out.println("database name : "+conn.getCatalog());

            pst = conn.prepareStatement("SELECT * FROM tblUsers WHERE UserID=? and Password=?");
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
    // lay ra Danh sach cac Nhan Vien 
     public  List<UserDTO> getUser() {
         Connection  conn = null; 
         PreparedStatement pst = null; 
         ResultSet rs = null; 
         
         List<UserDTO> userList = new ArrayList<>();
         try {
             conn = DbConnect.getConnection(); 
             pst = conn.prepareStatement("select * from tblUsers");
             
             rs = pst.executeQuery(); 
             while(rs.next()) {
                 String userID = rs.getString("UserID"); 
                 String  fullName = rs.getString("FullName"); 
                 String  role = rs.getString("RoleID");
                 userList.add(new UserDTO(userID, fullName, role, "***"));
                 
             }
         } catch (SQLException ex) {
             System.out.println("Can't connect DATABASE");
        }
         return userList;
        
     }
     
     // check duplicate 
      public boolean checkDuplicat(String userId) {
          Connection conn= null; 
          PreparedStatement pst = null; 
          ResultSet rs = null; 
          
          boolean status =  false;
          try {
              conn = DbConnect.getConnection(); 
              if  (conn != null) {
                  pst = conn.prepareStatement("select * from tblUsers where UserID = ?");
                  pst.setString(1, userId);
                  rs = pst.executeQuery();
                  
                 status = rs.next();
              }
               
          }catch(SQLException e) {
              e.printStackTrace();
          }
          return status;
      }
      
      // Insert User
      public boolean Insert( UserDTO user) {
          Connection conn =null; 
          PreparedStatement  pst = null; 
          ResultSet rs = null; 
          boolean status = false;
          try {
              conn = DbConnect.getConnection();
              if (conn != null) {
                 pst = conn.prepareStatement("INSERT INTO tblUsers(userId, fullName, roleID, password) VALUES(?,?,?,?)");    
                 pst.setString(1, user.getUserID());
                 pst.setString(2, user.getFullName());
                 pst.setString(3, user.getRoleId());
                 pst.setString(4, user.getPassword());
                 
                 if (pst.executeUpdate() >  0 ) {
                     status  = true;
                 }else {
                     status =false;
                 }
                 
                 
                 
                 
              }
          
          }
          catch (SQLException E) {
              E.printStackTrace();
          }
          return status;
      }
      // Delete 
      public boolean  delete(String userID) {
          boolean status = false; 
          Connection conn = null; 
          PreparedStatement  pst = null; 
          ResultSet rs = null; 
          
          try {
              conn = DbConnect.getConnection(); 
              if (conn != null) {
                  pst = conn.prepareStatement("DELETE tblUsers WHERE userID=?");
                  pst.setString(1 , userID);
                  if(pst.executeUpdate() > 0) {
                      status = true;
                  }else {
                      status = false;
                  }
                  
              }
          }catch  (SQLException e) {
              e.printStackTrace();
          }
          return status;
      }


    private void Log(String userID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static void main(String[] args) {
       UserDao dao = new UserDao();
        boolean status = dao.delete("Nhat"); 
         if (status == true) {
             System.out.println("Delete complete");
         }else {
             System.out.println("not complete");
         }
        
    }
}
