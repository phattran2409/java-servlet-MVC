/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllerUser;

import User.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobile.MobileDTO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "searchByPrice", urlPatterns = {"/searchByPrice"})
public class searchByPrice extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String price = request.getParameter("price");
        //
      
       
        String url = ""; 
        UserDao dao = new UserDao(); 
        List<MobileDTO> list = new ArrayList<>(); 
        // create variable min Price and Max price in range EX : 200-400
            String minPrice = "";
            String maxPrice = ""; 
               // Message 
        String message =""; 
       boolean valid = true;
            
              if (price.equals("all")){ 
                  System.out.println("thuc hien if search all ");
                 list = dao.getAllProduct();
                url = "User.jsp"; 
                request.setAttribute("list", list);
                valid = false;
            }
       if(valid == true) {
        if (checkRegexPrice(price)) {
            String[] priceRange = price.split("-");
         
            for (int i = 0; i < priceRange.length; i++) {
                minPrice = priceRange[0];
                maxPrice = priceRange[1];
                
            }
        }
        else  { 
           
        }
     
        list = dao.getSearchByPrice(minPrice, maxPrice); 
     
      
        
        if (!list.isEmpty()) {
            url = "User.jsp"; 
            
        }else {
            message = "Dont Found Any thing  !"; 
            url="User.jsp";
            
        }
       }
      
        
        request.setAttribute("message", message);
        request.setAttribute("list", list);
        request.getRequestDispatcher(url).forward(request, response);
        
    }
    public boolean checkRegexPrice(String price) {
        Pattern  p =  Pattern.compile("[-]");
        Matcher  m = p.matcher(price);
        if (m.find()) {
            return true;
        }
        return false;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
