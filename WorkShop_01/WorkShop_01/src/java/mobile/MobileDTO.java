/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobile;

/**
 *
 * @author ADMIN
 */
public class MobileDTO {
    private  String mobileId ;
    private  String mobileName;
    private String description; 
    private float price;
    private int year; 
    private int quantity; 
    private int notSale;

    public MobileDTO() {
    }

    public MobileDTO(String mobileId, String mobileName, String description, float price, int year, int quantity, int notSale) {
        this.mobileId = mobileId;
        this.mobileName = mobileName;
        this.description = description;
        this.price = price;
        this.year = year;
        this.quantity = quantity;
        this.notSale = notSale;
    }

    public String getMobileId() {
        return mobileId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getNotSale() {
        return notSale;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNotSale(int notSale) {
        this.notSale = notSale;
    }
    
    
    
    
    
    

}
