/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerStaff;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobile.MobileDTO;
import mobile.MobileDao;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "createMobile", urlPatterns = {"/createMobile"})
public class createMobile extends HttpServlet {

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
        String mobileID = request.getParameter("mobileID");
        String mobileName = request.getParameter("mobileName");
        String Description = request.getParameter("Description");
        float price = Float.parseFloat(request.getParameter("price")); 
        int  yearOfProduct = Integer.parseInt(request.getParameter("yearOfProduct"));
        int quantity = Integer.parseInt(request.getParameter("quantity")); 
        int notSale = Integer.parseInt(request.getParameter("notSale")); 
        MobileDTO mobileDTO = new MobileDTO(mobileID, mobileName, Description, price, yearOfProduct, quantity, notSale);
        System.out.println(mobileDTO.toString());
     
        // dao 
        MobileDao dao  = new MobileDao(); 
        //
        String url = "";
        String message = "";
        String message_DUPLICATE ="";
        boolean check = dao.CreateNewMobile(mobileDTO);
        if(check) {
           
            url = "Staff.jsp"; 
            
        }else{
            url ="Staff.jsp";
            message = "Can't Add new product ! ";
            message_DUPLICATE = "Duplicate ID " + " mobileID";
        }
       request.setAttribute("message", message);
       request.setAttribute("message_DUPLICATE", message_DUPLICATE);
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
