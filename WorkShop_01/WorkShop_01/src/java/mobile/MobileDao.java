/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobile;

import Dbutils.Dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class MobileDao {
    final static String LOAD ="SELECT mobileId , mobileName , description , price , yearOfProduction , quantity , notSale from tbl_Mobile";
    final static String SEARCH_ID = "SELECT mobileId , mobileName , description , price , yearOfProduction , quantity , notSale from tbl_Mobile where mobileId LIKE ?";
    final static String SEARCH_NAME= "SELECT mobileId , mobileName , description , price , yearOfProduction , quantity , notSale from tbl_Mobile where mobileName LIKE ?";
    final static String CREATE="INSERT INTO tbl_Mobile(mobileId,mobileName,description,price,quantity,notSale,yearOfProduction) VALUES (?,?,?,?,?,?,?)";
    final static String DELETE ="DELETE tbl_Mobile where mobileId = ?";
    final static String UPDATE ="UPDATE tbl_Mobile SET mobileName = ? ,description =  ? ,price = ?, quantity = ? ,notSale = ?  WHERE mobileId = ?";
    public MobileDao() {
    }
    // load all mobile product
    public List<MobileDTO> load() { 
        List<MobileDTO> list = new ArrayList<>(); 
        MobileDTO mobile = new MobileDTO();
        Connection conn = null; 
        PreparedStatement pst  =null; 
        ResultSet rs = null;
        try {
            conn = Dbconnect.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(LOAD);
                rs = pst.executeQuery();
                
                while (rs.next()) {
                    mobile = new MobileDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                    list.add(mobile);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    // searh product by  ID
    public List<MobileDTO> getSearchMobileBY_ID(String mobileID) {
        List<MobileDTO> list = new ArrayList<>();
        MobileDTO mobile = new MobileDTO();
        Connection conn  = null; 
        PreparedStatement pst = null; 
        ResultSet  rs = null; 
        try {
            conn = Dbconnect.getConnection();  
                   
            if (conn != null) {
                pst  = conn.prepareStatement(SEARCH_ID);
                pst.setString(1,"%"+mobileID+"%");
                rs = pst.executeQuery(); 
                while(rs.next()) {
                   mobile = new MobileDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                   list.add(mobile);
                }
                       
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    // search by name
     public List<MobileDTO> getSearchMobileBy_NAME(String mobileName) {
        List<MobileDTO> list = new ArrayList<>();
        MobileDTO mobile = new MobileDTO();
        Connection conn  = null; 
        PreparedStatement pst = null; 
        ResultSet  rs = null; 
        try {
            conn = Dbconnect.getConnection();  
                   
            if (conn != null) {
                pst  = conn.prepareStatement(SEARCH_NAME);
                pst.setString(1,"%"+mobileName+"%");
                rs = pst.executeQuery(); 
                while(rs.next()) {
                   mobile = new MobileDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                   list.add(mobile);
                }
                       
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
     
    // create a  new mobile
     public  boolean CreateNewMobile(MobileDTO mobileDTO) {
         boolean check = false ;
         Connection conn  = null;
         PreparedStatement pst = null; 
         try {
                 conn = Dbconnect.getConnection();  
                 
             pst =  conn.prepareStatement("INSERT INTO tbl_Mobile(mobileId,mobileName,description,price,quantity,notSale,yearOfProduction) VALUES (?,?,?,?,?,?,?)");
             pst.setString(1 , mobileDTO.getMobileId());
              pst.setString(2 , mobileDTO.getMobileName());
              
               pst.setString(3 , mobileDTO.getDescription());
                pst.setFloat(4 , mobileDTO.getPrice());
                
                 pst.setInt(5 , mobileDTO.getQuantity());
                 pst.setInt(6, mobileDTO.getNotSale()); 
                 pst.setInt(7,  mobileDTO.getYear());
                if( pst.executeUpdate() > 0 ) {
                    check  =true;
                }else {
                    check = false;
                }
          
                 
          
         }catch(SQLException e ) {
             e.printStackTrace();
         }
         return check;
     }  
     
    // remove 
   public boolean remove(String mobileID) {
        boolean check =false;
            Connection conn  = null; 
            PreparedStatement pst = null; 
            ResultSet rs = null; 
            try {
                conn = Dbconnect.getConnection();
                if(conn != null) {
                    pst  =conn.prepareStatement(DELETE);
                    pst.setString(1, mobileID);
                    check = pst.executeUpdate()>0?true:false;
                }
            }catch(SQLException e ) {
                e.printStackTrace();
            }
            return check;
   }
   // update 
   // UPDATE tbl_Mobile SET mobileName = ? ,description =  ? ,price = ?, quantity = ? ,notSale = ?  WHERE mobileId = ?
    public boolean update(MobileDTO mobile) {
        boolean check =false;
            Connection conn  = null; 
            PreparedStatement pst = null; 
            ResultSet rs = null; 
            try {
                conn = Dbconnect.getConnection();
                if(conn != null) {
                    pst  =conn.prepareStatement(UPDATE);
                    pst.setString(1, mobile.getMobileName());
                    pst.setString(2, mobile.getDescription());
                    pst.setInt(3, (int) mobile.getPrice());
                    pst.setInt(4, (int) mobile.getQuantity());
                    pst.setInt(5, (int) mobile.getNotSale());
                    pst.setString(6, mobile.getMobileId());
                    
                   
                            
                    check = pst.executeUpdate()>0?true:false;
                }
            }catch(SQLException e ) {
                e.printStackTrace();
            }
            return check;
   }
}
