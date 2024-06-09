/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User.wishList;

import Dbutils.Dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import mobile.MobileDTO;

/**
 *
 * @author ADMIN
 */
public class wishListDAO {

    public wishListDAO() {
    }
    public boolean Insert(String userID , String mobileID) {
        boolean  check  = false;
        Connection conn = null; 
        PreparedStatement pst = null;
         
        try {
            conn = Dbutils.Dbconnect.getConnection();
            if (conn != null) {
               pst =conn.prepareStatement("INSERT INTO tbl_wishList(userID,mobileID) VALUES ( ? , ? );");
               pst.setString(1,userID); 
               pst.setString(2, mobileID);
               if(pst.executeUpdate() > 0 ) {
                   check = true;
               }else {
                   check =false;
               }
            }   
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
    public  List<MobileDTO> getallProduct(String userID) {
        List<MobileDTO> list = new ArrayList<>();
       Connection conn = null; 
        PreparedStatement pst = null; 
        ResultSet rs = null; 
        
        try {
            conn = Dbutils.Dbconnect.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement("SELECT M.mobileId , M.mobileName , M.description ,M.yearOfProduction , M.quantity , M.price    from tbl_wishList  W  join tbl_Mobile  M  ON W.mobileID = M.mobileId  WHERE w.userID =  ? ");
                pst.setString(1, userID);
                rs = pst.executeQuery(); 
                while(rs.next()){
                    String mobileId = rs.getString("mobileId"); 
                    String mobileName = rs.getString("mobileName");
                    String descrip = rs.getString("description");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity"); 
                    float price = rs.getFloat("price");
                    list.add(new MobileDTO(mobileId, mobileName, descrip,price,yearOfProduction, quantity,0));
                }
            }
        }catch (SQLException e) {
           e.printStackTrace();
        }
       return list;         
    }
    
    // check if product was added in wish list return true
    public  boolean exsist(String mobileID){
        boolean check  = false;
        Connection conn = null; 
        PreparedStatement pst = null; 
        ResultSet rs = null; 
        try {
            conn = Dbutils.Dbconnect.getConnection();
            if (conn != null) {
               pst = conn.prepareStatement("SELECT * FROM  tbl_wishList where mobileID= ? ");
               pst.setString(1, mobileID);
               rs  = pst.executeQuery();
               if (rs.next()) {
                    check = true;
               } 
            }
        }catch(SQLException ex) {
             System.out.println(ex.toString()); 
        }
       return check; 
    }
    // remove wish List 
    public boolean removed(String userID , String mobileID) {
        boolean check  = false;
        Connection  conn = null; 
        PreparedStatement pst = null; 
        try {
            conn = Dbconnect.getConnection(); 
            if(conn != null) {
                pst = conn.prepareStatement("DELETE from  tbl_wishList where userID =? AND mobileID = ? ");
                pst.setString(1, userID);
                pst.setString(2, mobileID);
                
                if(pst.executeUpdate() > 0 )  {
                    check = true;
                }else {
                    check = false;
                }
            }
    
            
        }catch(SQLException ex) {
            ex.printStackTrace();
            
        }
        return check;
    }
    
    
   
}
