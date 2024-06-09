/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import User.UserDTO;
import User.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
       String UserId = request.getParameter("userID"); 
       String pass = request.getParameter("pass"); 
       
       //
       UserDao dao = new UserDao();
       UserDTO user = new UserDTO(); 
       // url and message 
       String url =""; 
       String message ="";
       //
       user = dao.login(UserId, pass);
       // create session 
       HttpSession session = request.getSession(); 
       boolean valid = true;
       
       if (user != null) {
           // phan quyen 
           // 1. manager  || 2.staff || 0.User
           if (user.getRole() == 1) {
               valid = true;
               url="loadProduct";
               session.setAttribute("user", user);
               
           }else if (user.getRole() == 2) {
               url ="loadProduct";
               session.setAttribute("user", user);
           }else {
               // if user it will run through servlet get list form database
               url="userLoadProduct";
               session.setAttribute("user", user);
           }
       }else {
           url="login.jsp";
           message ="UserID or  Password is not Correct !";
       }
       // 
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
