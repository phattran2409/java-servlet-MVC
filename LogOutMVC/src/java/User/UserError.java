/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

/**
 *
 * @author ADMIN
 */
public class UserError {
     String UserId; 
     String FullName; 
     String Password ; 

    public UserError(){ 
        UserId = ""; 
        FullName = ""; 
        Password = "";
                
    }
    
    
    public UserError(String UserId, String FullName, String Password) {
        this.UserId = UserId;
        this.FullName = FullName;
        this.Password = Password;
    }

    public String getUserId() {
        return UserId;
    }

    public String getFullName() {
        return FullName;
    }

    public String getPassword() {
        return Password;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
