<%-- Document : Cart Created on : May 14, 2024, 11:34:37 PM Author : ADMIN --%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="mobile.CartDTO" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Bootstrap CSS v5.2.1 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous" />
        <link href="
              https://cdn.jsdelivr.net/npm/sweetalert2@11.11.0/dist/sweetalert2.min.css
              " rel="stylesheet">
    </head>

    <body>
        <h1>Your Cart</h1>


        <div class="container">
            <a href="userLoadProduct" class="p-3 btn btn-primary text-center">Click Here to continue
                Shopping</a>
            <table class="table table-striped" border="5">
                <thead>
                    <tr>
                        <th scope="col">No.</th>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Change</th>
                        <th scope="col">Remove</th>
                    </tr>
                </thead>
                <tbody>

                    <% CartDTO cart = (CartDTO) session.getAttribute("CART");
                                    int count = 0;
                                    double total = 0;
                                    if (cart != null) { %>


                    <% for (mobile.MobileDTO p : cart.getCart().values()) {
                            count++; // tinh tong total
                            total += p.getPrice() * p.getQuantity();

                    %>

                <form action="optionCart" method="get">
                    <tr>
                        <th scope="row">
                            <%= count%>
                        </th>
                        <td>
                            <input type="text" name="id" value="<%= p.getMobileId()%>"
                                   readonly="" />
                        </td>
                        <td>
                            <input type="text" name="name" value="<%= p.getMobileName()%>"
                                   readonly="" />
                        </td>
                        <td>
                            <input type="text" name="price" value="<%= p.getPrice()%>"
                                   readonly="" />
                        </td>

                        <th>
                            <input type="text" name="quantity" value="<%=p.getQuantity()%>"
                                   required="">
                        </th>

                        <th>

                            <input name="action" type="submit" value="change"
                                   class="btn btn-secondary text-uppercase">
                        </th>
                </form>
                <th>
                    <a href="removeCart?id=<%= p.getMobileId()%>"
                       class="btn btn-danger btn-remove">
                        remove
                    </a>
                </th>

                </tr>


                <% }%>


                </tbody>
            </table>
            <div class="total ">


                <h1 class="text-danger"> Total : <%= Math.round(total)%>$</h1>

                </<div>

                </div <% }%>



                <!-- Bootstrap JavaScript Libraries -->
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                crossorigin="anonymous"></script>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
                crossorigin="anonymous"></script>

                <script src="
                        https://cdn.jsdelivr.net/npm/sweetalert2@11.11.0/dist/sweetalert2.all.min.js
                "></script>

                <script>
                            document.querySelectorAll('.btn-remove').forEach(button => {
                    button.addEventListener('click', function (event) {
                    event.preventDefault();
                    const url = this.href;
                    Swal.fire({
                    title: "Are you sure?",
                            text: "You won't be able to revert this!",
                            icon: "warning",
                            showCancelButton: true,
                            confirmButtonColor: "#3085d6",
                            cancelButtonColor: "#d33",
                            confirmButtonText: "Yes, delete it!"
                    }).then((result) => {
                    window.location.href = url;
                    if (result.isConfirmed){
                    Swal.fire({
                    title: "Deleted!",
                            text: "Your Product has been deleted.",
                            icon: "success"

                    });
                    } else {
                    window.location.href = "viewCart.jsp";
                    }
                    });
                    });
                    });
                </script>
                </body>

                </html>