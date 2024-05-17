/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import User.UserDTO;
import User.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.AEADBadTagException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="LoginController", urlPatterns={"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR="Login.jsp";
    private static final String AD="AD";
    private static final String ADMIN_PAGE="Admin.jsp";
    private static final String US="US";
    private static final String USER_PAGE="User.jsp";
    private static final String CUSTOMER_PAGE ="Customer.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url= ERROR;
        String ErrorMes = "";
        List<UserDTO> userList ;
        try {
            String userID= request.getParameter("username");
            String password= request.getParameter("password");
            UserDao dao = new UserDao(); 
                
            UserDTO user = dao.checkLogin(userID, password); 
            if (!userID.isEmpty() && !password.isEmpty()) {
                if (user != null) {
                    url = USER_PAGE;

                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", user);
                    String roleID = user.getRoleId();
                    userList   = dao.getUser();
//                     phan quyen 
                        if (AD.equals(roleID)) {
                            url = ADMIN_PAGE;
                            request.setAttribute("List", userList);
                            session.setAttribute("auAD", true);
                            
                        }else if (US.equals(roleID)) {
                            url = USER_PAGE;
                            session.setAttribute("au_USER", true);
                        }else {
                           // neu khonng co Role  thi minh se cho role la khach
                           url = CUSTOMER_PAGE;
                        }
                      // tao  ra session Logout 
                      
                } else {
                    ErrorMes = "Password or UserName is not Correct";
                }
            }else{
                ErrorMes = "username or password is empty ? ";
                 request.setAttribute("Error", ErrorMes);
            }
            
           
        } catch (Exception e) {
            log("Error at LoginController: "+ e.toString());
        }    

            request.setAttribute("Error", ErrorMes);
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
    