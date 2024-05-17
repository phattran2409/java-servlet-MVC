<%-- 
    Document   : User
    Created on : May 7, 2024, 11:08:27 PM
    Author     : ADMIN
--%>

<%@page import="User.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <% 
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER"); 

         %>
        
         <h1> User ID : <%= user.getUserID() %> </h1>
        
         <h1> Use Name : <%=  user.getFullName() %></h1>
 
         <h1> Role User : <%= user.getRoleId() %> </h1>
         
         <button type="submit" > 
             <a href="LogoutController" name="action" value="logout">Logout</a>
         </button>
         
    </body>
</html>
