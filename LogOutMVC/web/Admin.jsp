<%-- 
    Document   : Admin
    Created on : May 8, 2024, 3:43:57 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="User.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS v5.2.1 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
        <style>
            body {
                width: 100%;
                height: 100vh;
                border: 1px solid red;
                position: relative;
        
            }
        
            #createUser {
                width: 100cqmax;
                height: 100vh;
        
        
        
            }
        
            .formCenter {
                width: 100%;
                height: 100%;
            }
        
            .formInput {
                width: fit-content;
                height: auto;
                display: flex;
                flex-direction: column;
        
        
            }
        
            .formInput>input {
                width: 400px;
        
                margin-bottom: 20px;
            }
        
            .btn-collapse {
                position: absolute;
                left: 0;
        
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <%  UserDTO user = (UserDTO)  session.getAttribute("LOGIN_USER"); 
           
        %>
        <% List<UserDTO> listUser =  (List) request.getAttribute("List"); 
        %>
      
        <h1> Welcome Admin : <%= user.getFullName() %> </h1>
        <table border="2">
            <thead>
                <tr>
                    <th class="border border-primary"> UserID</th>
                    <th class="border border-primary">FullName</th>
                    <th class="border border-primary">RoleId</th>
                    <th class="border border-primary"> Delete</th>
                </tr>
            </thead>
            <tbody>
                  <% 
                          for (UserDTO list : listUser)  { 
                          
                   %>
                <tr>
                    <td class="border border-primary p-2">  <%= list.getUserID() %> </td>
                    <td class="border border-primary p-2">  <%= list.getFullName() %></td>
                    <td class="border border-primary p-2">  <%= list.getRoleId()%></td>
                    <td class="border border-primary p-2">  
                        <a href="DeleteController?userID=<%= list.getUserID()%>">Delete</a>
                    </td>
                </tr>
                
                
            </tbody>
            <% } %>
        </table>
            <h1> ${DelErr} </h1>
        <a href="Create.html">  <button class="btn btn-primary btn-collapse" type="button" data-bs-toggle="collapse" data-bs-target="#createUser"
                                      aria-expanded="false" aria-controls="createUser"> Create</button> </a>  
<!--        <div class="container collapse" id="createUser">
            <div class="d-flex justify-content-center align-items-center formCenter">
                <form action="CreateServlet" method="post" class="formInput">
                    <label for="User">UserId</label>
                    <input class="form-control" type="text" name="user" id="User">
                    <label for="">Fullname</label>
                    <input type="text" name="FullName">
                    <label for="">role ID</label>
                    <div class="CheckBox">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1"
                              >
                            <label class="form-check-label " for="flexRadioDefault1">
                                User
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"
                                checked>
                            <label class="form-check-label text-danger " for="flexRadioDefault2">
                                Admin
                            </label>
                        </div>
                    </div>
                    <label for="">Password</label>
                    <input type="text" name="password">
                    <input type="submit" value="submit">
                </form>
            </div>
        </div>-->


        <a href="LogoutController">Logout</a>
        <table border="2">
            <thead>
                <tr>
                    <th class="border border-primary"> UserID</th>
                    <th class="border border-primary">FullName</th>
                    <th class="border border-primary">RoleId</th>
                    <th class="border border-primary"> Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="" var="x" >
                <tr>
                    <td class="border border-primary p-2">  ${x.userID} </td>
                    <td class="border border-primary p-2">  ${x.getFullName()}</td>
                    <td class="border border-primary p-2">  ${x.getRoleId()}</td>
                    <td class="border border-primary p-2">  
                        <a href="DeleteController?userID= ${x.getUserID()}">Delete</a>
                    </td>
                </tr>
                </c:forEach>
                
            </tbody>
     
        </table>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"></script>
    </body>
</html>
