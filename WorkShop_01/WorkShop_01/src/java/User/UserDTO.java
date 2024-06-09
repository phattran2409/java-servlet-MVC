/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

/**
 *
 * @author ADMIN
 */
public class UserDTO {
   private String UserID; 
   private String fullName; 
   private int password;
   private int role ;

    public UserDTO() {
    }

    public UserDTO(String UserID, String fullName, int password, int role) {
        this.UserID = UserID;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
    }
   
   
    public String getUserID() {
        return UserID;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    
   
   
 }
