/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobile;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class CartDTO {
    private Map<String , MobileDTO >  cart;

    public CartDTO() {
    }
    
    public CartDTO(Map< String , MobileDTO> cart) {
        this.cart = cart;
    }

    public Map<String, MobileDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, MobileDTO> cart) {
        this.cart = cart;
    }
    
   public boolean add(MobileDTO mobile) {
       boolean check = false; 
       try {
           if (this.cart == null) {
               this.cart = new HashMap<>(); 
               
           }
           
           if (this.cart.containsKey(mobile.getMobileId())) {
              int currentQuantity = this.cart.get(mobile.getMobileId()).getQuantity(); 
              mobile.setQuantity(currentQuantity + mobile.getQuantity());
           }
          this.cart.put(mobile.getMobileId(),mobile);
          check = true;
       }catch (Exception e) {
           e.printStackTrace();
           
       }
       return check; 
   }
    // remove mobile in cart 
   public boolean change(String id, MobileDTO product) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.replace(id, product);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
    public boolean remove(String id) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

  
}
