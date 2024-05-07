/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
/**
 *
 * @author ADMIN
 */
public class testJDBC {
    public static void main(String[] args) throws ClassNotFoundException {
       Connection conn = null;

        try {

            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            String dbURL = "jdbc:sqlserver://DESKTOP-9HSQ90N\\PHAT:1433;encrypt=true;trustServerCertificate=true;databaseName=Employee";
            String user = "sa";
            String pass = "123";
            conn = DriverManager.getConnection(dbURL, user, pass);
            
            if (conn != null) {
                System.out.println("The connection has been successfully established.");
                System.out.println("Database Name: "+conn.getCatalog());
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

        } catch (SQLException ex) {
            System.out.println("An error occurred while establishing the connection:");
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
