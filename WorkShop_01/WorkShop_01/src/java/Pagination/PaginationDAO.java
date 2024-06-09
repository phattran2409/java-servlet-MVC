/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pagination;

import Dbutils.Dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mobile.MobileDTO;
import sun.rmi.runtime.Log;

/**
 *
 * @author ADMIN
 */
public class PaginationDAO {

    public PaginationDAO() {
    }
    public static int  getCount() {
        Connection conn  =null; 
        PreparedStatement pst  = null; 
        ResultSet rs  =null; 
        
        try {
            conn  = Dbconnect.getConnection(); 
            if (conn != null) {
                pst  = conn.prepareStatement("select count(*) from tbl_Mobile");
                rs = pst.executeQuery();
                if(rs.next()) {
                    return rs.getInt(1);
                }
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    // 
    public  static List<MobileDTO> getLimitProduct(int index) {
        List<MobileDTO> list = new ArrayList<>();
        Connection conn  =null; 
        PreparedStatement pst = null; 
        ResultSet rs = null; 
        
        try {
            conn  = Dbconnect.getConnection();
            pst = conn.prepareStatement("SELECT mobileId , mobileName , description , price , yearOfProduction , quantity , notSale   from tbl_Mobile \n"
                    + "ORDER BY mobileId\n"
                    + "OFFSET ? ROWS FETCH  NEXT 3 ROWS ONLY;");
             //  1  ->  offset  0  ( 0 -1 ) * 3
             //  2 ->  offset 3 
             // 3 -> offset  6
            pst.setInt(1, (index-1)*3);
            rs = pst.executeQuery();
            while (rs.next()) {     
                list.add(new MobileDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
         
        List<MobileDTO> list = new ArrayList<>(); 
        list = PaginationDAO.getLimitProduct(1); 
        for  (MobileDTO x : list) {
            System.out.println(x.getMobileName());
        }
    }
}
