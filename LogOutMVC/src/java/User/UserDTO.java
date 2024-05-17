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
    public String userID; 
    private String fullName; 
    private String roleId;
    private String password; 

    public UserDTO() {
    }

    public UserDTO(String userID, String fullName, String roleId, String password) {
        this.userID = userID;
        this.fullName = fullName;
        this.roleId = roleId;
        this.password = password;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
    
}
