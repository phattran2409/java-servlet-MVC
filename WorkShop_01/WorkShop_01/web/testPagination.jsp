<%-- 
    Document   : testPagination
    Created on : Jun 1, 2024, 3:18:02 PM
    Author     : ADMIN
--%>

<%@page import="java.util.List"%>
<%@page import="mobile.MobileDTO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<MobileDTO> list = (List<MobileDTO>) request.getAttribute("list");  %> 
        <p class="text-danger"> ${message} </p>
        <table class="table table-striped" border="1">
            <thead>
                <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Mobile ID</th>
                    <th scope="col">Mobile Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Price</th>
                    <th scope="col">Year Of Production</th>
                    <th scope="col">Quantity</th>
                    <th scope="col"> Status </th>
                    <th scope="col"> add to cart</th>
                    <th scope="col">Wish List </th> 

                </tr>
            </thead>
            <tbody>


                <% int count = 0;
                                            for (MobileDTO listMobile : list) {
                                                count++;%>

                <tr>
            <form action="MainController" method="get">
                <th scope="row">
                    <%= count%>
                </th>
                <td>
                    <input type="text" name="ID"
                           value="<%= listMobile.getMobileId()%>" class="form-control"
                           readonly="">
                </td>
                <td>
                    <input type="text" name="name "
                           value="<%= listMobile.getMobileName()%>" class="form-control"
                           readonly="">

                </td>

                <td>
                    <%= listMobile.getDescription()%>
                </td>

                <td>
                    <%= listMobile.getPrice()%> 

                </td>

                <td>
                    <%= listMobile.getYear()%>
                </td>


                <td>
                    <%= listMobile.getQuantity()%>
                </td>
                <th>


                    <% if (listMobile.getNotSale() == 1) { %>
                    <span class="badge bg-success p-3">Sale</span>
                    <% } else { %>
                    <span class="badge bg-danger p-3">Not Sale</span>
                    <% } %>
                </th>

                <th>
                    <!--                                                        <input type="submit" name="action" value="addToCart"
                                                                                class="btn btn-primary">-->
                    <% if (listMobile.getNotSale() == 1) { %>
                    <button class="btn btn-success" name="action" value="addToCart">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </button>
                    <% } else { %> 
                    <button class="btn btn-secondary btn-NonShopCart" type="button">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </button>
                    <% }%>
                </th>
                <th> 
                    <button class="btn btn-danger" name="action" value="wishList">
                        <i class="fa-solid fa-heart"></i>
                    </button>

                </th>
            </form>
        </tr>
        <% } %>





        <% int endPage = (int) request.getAttribute("endPage");
            for (int i = 1; i <= endPage; i++) {
        %>
        <a href="?pageId=<%=i%>"> <%= i%></a>
        <% }%>
</body>
</html>
