/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import Dbutils.Dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mobile.MobileDTO;

/**
 *
 * @author ADMIN
 */
public class UserDao {
    final static String LOGIN  = "SELECT userID , fullName , password , role  FROM  tbl_User where userID = ? AND password = ?";
    final static String LOADALL = "SELECT mobileId , mobileName , description , price , yearOfProduction , quantity , notSale from tbl_Mobile where notSale = 1";
    final static String SEARCH_PRICE ="SELECT mobileId , mobileName , description , price , yearOfProduction , quantity , notSale from tbl_Mobile where price BETWEEN  ? AND ?";
    final static String GET_MOBILE_CART = "SELECT mobileId , mobileName , description , price , yearOfProduction , quantity , notSale from tbl_Mobile where notSale = 1 AND  mobileId = ?";
    public UserDao() {
    }
   
   public UserDTO login(String userID , String pass) {
       Connection conn = null; 
       PreparedStatement pst = null; 
       ResultSet rs = null;
       UserDTO user = null;
       try {
           conn = Dbconnect.getConnection();
           if (conn != null) {
               pst = conn.prepareStatement(LOGIN);
               pst.setString(1, userID);
               pst.setString(2,pass);
               rs = pst.executeQuery();
               if(rs.next()) {
                   user = new UserDTO(rs.getString(1),rs.getString(2),0,rs.getInt(4));
               }
           }
       }catch (SQLException e) {
           e.printStackTrace();
       }
       
       return user;
       
   }
   
   // view  mobile prodcut 
   public List<MobileDTO> getAllProduct() {
       List<MobileDTO> list = new ArrayList<>(); 
       Connection conn = null;
       PreparedStatement pst = null; 
       ResultSet rs = null; 
       MobileDTO mobile = new MobileDTO();
               
       try  {
            conn = Dbconnect.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(LOADALL); 
                rs = pst.executeQuery(); 
                while (rs.next()) {
                      mobile = new MobileDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                    list.add(mobile);
                }
            }
       }catch(SQLException e) {
           e.printStackTrace();
       }
       return list;
   }
   
   // search by price 
   public List<MobileDTO> getSearchByPrice(String min  , String max) {
       List<MobileDTO> list = new ArrayList<>();
       Connection  conn = null; 
       PreparedStatement pst = null;
       ResultSet rs = null;
       MobileDTO   mobile = new MobileDTO();
       try 
       {
         conn =  Dbconnect.getConnection(); 
         if (conn != null) {
             pst = conn.prepareStatement(SEARCH_PRICE); 
             pst.setString(1,min);
             pst.setString(2,max);
             rs = pst.executeQuery();
             while (rs.next()) {
                  mobile = new MobileDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                    list.add(mobile);
             }
         }
       }catch (SQLException e ) {
           e.printStackTrace();
       }
       return list;
   }
   // cart 
    public MobileDTO getMobileForCart(String mobileID) {
        
       Connection conn = null;
       PreparedStatement pst = null; 
       ResultSet rs = null; 
       MobileDTO mobile = new MobileDTO();
               
       try  {
            conn = Dbconnect.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(GET_MOBILE_CART); 
                pst.setString(1, mobileID);
                rs = pst.executeQuery(); 
                if (rs.next()) {
                      mobile = new MobileDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5),1, rs.getInt(7));
                    
                }
            }
       }catch(SQLException e) {
           e.printStackTrace();
       }
       return mobile;
   }
  
}
