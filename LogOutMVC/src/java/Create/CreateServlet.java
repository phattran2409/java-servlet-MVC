/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Create;

import User.UserDTO;
import User.UserDao;
import User.UserError;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author ADMIN
 */
@WebServlet(name="CreateUserServlet", urlPatterns={"/CreateServlet"})
public class CreateServlet extends HttpServlet {
     private static final String SUCCESS  = "Login.jsp";
     private static final String ERROR  = "Create.jsp"; 
     
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateUserServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateUserServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
                    String url = "";
        try {
            // cac bien input cua form
            String UserID = request.getParameter("user");
            String FullName = request.getParameter("FullName");
            String[] Role = request.getParameterValues("flexRadioDefault");
            String roleId = "";
            for (int i = 0; i < Role.length; i++) {
                roleId = Role[i];
            }
            System.out.println(roleId);
              
            String Pass = request.getParameter("password");
            // truy van cua SQL 
            UserDao dao = new UserDao();
            // DTO cua error message 
            UserError userErr = new UserError();
            // bien MESSAGE thong bao khi  blank 
            String messageBlank = "";
            
            boolean validate = true;
            request.setAttribute("UserErr", userErr);
            
             if (UserID.isEmpty() || FullName.isEmpty() || roleId.isEmpty() || Pass.isEmpty()) {
                 messageBlank = "your input field is not enough"; 
                 request.setAttribute("messageBlank",messageBlank);
             }
           
                if (!regexUserId(UserID)) {
                    userErr.setUserId("UserID just  3 -> 15 character");
                    validate = false;
                    System.out.println("USER  error : " + userErr.getUserId());
                    url = ERROR;
                }
                if (dao.checkDuplicat(UserID)) {
                    userErr.setUserId("");
                    userErr.setUserId("Duplicate UserName Have Been Used before ");
                    validate = false;
                    System.out.println("User Duplicate :" + userErr.getUserId());
                    url = ERROR;
                }

                if (validate == true) {
                    UserDTO user = new UserDTO(UserID, FullName, roleId, Pass);

                    if (dao.Insert(user)) {
                        url = SUCCESS;
                    } else {
                        url = ERROR;
                    }
                }
            // else cua   isEmpty
          
        }
        catch(Exception  e ) {
            e.printStackTrace();
        }
        
        request.getRequestDispatcher(url).forward(request, response);
        
    }
    
    boolean regexUserId(String user) {
        Pattern pattern = Pattern.compile("[a-z0-9_-]{3,15}");
        Matcher M  = pattern.matcher(user);
        
        if (M.find()) {
            return true;
        }
        return false;
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
