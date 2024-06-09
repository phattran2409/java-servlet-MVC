/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User.wishList;

/**
 *
 * @author ADMIN
 */
public class wishListDTO {
    private int wId; 
    private String userID; 
    private String mobileID; 

    public wishListDTO() {
    }
    
    
    

    public wishListDTO(int wId, String userID, String mobileID) {
        this.wId = wId;
        this.userID = userID;
        this.mobileID = mobileID;
    }

    public int getwId() {
        return wId;
    }

    public String getUserID() {
        return userID;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }
    
    
    
}
