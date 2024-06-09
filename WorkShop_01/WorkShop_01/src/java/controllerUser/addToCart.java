/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllerUser;

import User.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mobile.CartDTO;
import mobile.MobileDTO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "addToCart", urlPatterns = {"/addToCart"})
public class addToCart extends HttpServlet {

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
       
        String mobileID = request.getParameter("ID"); 
        
        // create a session  
        HttpSession session = request.getSession();
        session.getAttribute("CART"); 
        // CarDTO 
        
       CartDTO cart = (CartDTO) session.getAttribute("CART");
      
       // 
       UserDao dao = new UserDao(); 
        MobileDTO mobileDTO = new MobileDTO(); 
       String url = "";
        mobileDTO = dao.getMobileForCart(mobileID);
       
       // String message 
       String message  ="";
       
        
       if (cart == null) {
           cart = new CartDTO();
       }
       
       if ( mobileDTO != null) {
         boolean  check = cart.add(mobileDTO);
         if (check) {
             url ="userLoadProduct"; 
             message = "success"; 
             session.setAttribute("CART", cart);
             
         }else {
             url = "userLoadProduct"; 
             message = "fail";
         }
       }
       
        request.setAttribute("message", message);
        
        request.getRequestDispatcher(url).forward(request, response);
       
      
    
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
