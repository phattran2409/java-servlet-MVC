<%-- Document : User Created on : May 23, 2024, 9:42:39 PM Author : ADMIN --%>

    <%@page import="Pagination.PaginationDAO"%>
<%@page import="mobile.MobileDao" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@page import="User.UserDTO" %>
                <%@page import="java.util.List" %>
                    <%@page import="mobile.MobileDTO" %>
                        <%@page contentType="text/html" pageEncoding="UTF-8" %>
                            <!DOCTYPE html>
                            <html>

                            <head>
                                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                                <title>JSP Page</title>
                                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
                                    rel="stylesheet"
                                    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                                    crossorigin="anonymous" />
                                <link rel="stylesheet" href="./css/ADstyle.css">
                                <link rel="stylesheet"
                                    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                                <script
                                    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                                <link rel="stylesheet"
                                    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
                                <link rel="stylesheet" href="./css/styleStaff.css">

                            </head>
                            <style>
                                .fade-out {
                                    animation: fadeOut 1s forwards;
                                }

                                @keyframes fadeOut {
                                    from {
                                        opacity: 1;
                                    }

                                    to {
                                        opacity: 0;
                                    }
                                }

                                body {
                                    posittion: relative;
                                }

                                .container-alert {
                                    position: absolute;
                                    top: 0;
                                    bottom: 0;
                                    margin: auto;
                                    width: 500px;
                                    height: 50px;
                                }

                                .alert-success-wishList {
                                    width: 100%;
                                    height: 100%;




                                }
                            </style>

                            <body>
                                <% UserDTO user=(UserDTO) session.getAttribute("user"); if (user==null) {
                                    response.sendRedirect("login.jsp"); return; } %>

                                    <div class="alert alert-success alert-dismissible" id="alert-box">
                                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                        <strong>Successfull Login!</strong>

                                        <span> Hello User </span> <span class="text-danger"> <strong>
                                                ${user.getFullName()}
                                            </strong>
                                        </span>
                                    </div>
                                    <div class="container my-5">
                                        <div class="image-admin">
                                            <div class="image">
                                                <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png"
                                                    alt="">
                                            </div>
                                            <div class="greeting-admin">
                                                Welcome Back User : <Span
                                                    class="NameAdmin">${sessionScope.user.getFullName()}</Span>
                                            </div>

                                            <!-- button LogOut -->
                                            <a href="logOut">
                                                <button class="btn btn-danger mt-2 mb-3 px-4 py-2">LogOut</button>
                                            </a>
                                            <div class="view-wishList">
                                                <div
                                                    class="row d-flex justify-content-between align-items-center container-imgWL">
                                                    <div
                                                        class="col-6 d-flex w-100 justify-content-center align-items-center">
                                                        <a href="viewWishList.jsp" class="img-WL ">
                                                            <img src="https://cdn-icons-png.flaticon.com/512/2332/2332042.png"
                                                                alt="alt" />
                                                        </a>
                                                    </div>
                                                    <div class="col-6 title-WL">
                                                        <p class="text-center">wish list</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- search by price -->

                                        <p>
                                            <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample"
                                                role="button" aria-expanded="false" aria-controls="collapseExample">
                                                search by price
                                            </a>

                                        </p>
                                    <div class="collapse" id="collapseExample">
<!--                                      <form action="searchByPrice" method="get">
                                                <input class="form-check-input" type="radio" name="price" value="all"
                                                    id="flexRadioDefault1" checked>
                                                <label class="form-check-label" for="flexRadioDefault1"> Search
                                                    All</label> <br>


                                                <input class="form-check-input" type="radio" name="price"
                                                    value="100-200" id="flexRadioDefault2">
                                                <label class="form-check-label" for="flexRadioDefault2">100 to
                                                    200</label> <br>

                                                <input class="form-check-input" type="radio" name="price"
                                                    value="200-400" id="flexRadioDefault3">
                                                <label class="form-check-label" for="flexRadioDefault3"> 200 to
                                                    400</label> <br>

                                                <input class="form-check-input" type="radio" name="price"
                                                    value="400-800" id="flexRadioDefault4">
                                                <label class="form-check-label" for="flexRadioDefault4"> 400 to
                                                    800</label> <br>

                                                <input class="form-check-input" type="radio" name="price"
                                                    value="800-1000" id="flexRadioDefault5">
                                                <label class="form-check-label" for="flexRadioDefault5"> 800 to
                                                    1000</label> <br>

                                                <button type="submit" class="btn btn-success"
                                                    style="border-color: #01f747;">
                                                    <i class="fa-solid fa-magnifying-glass">

                                                    </i>
                                                    search
                                                </button>
                                            </form>-->

                                            <form action="MainController" method="get">
                                                <div class="row">
                                                    <div class="col-2" style="width: 100px">
                                                        <lable class="badge badge-pill badge-warning p-3 my-2">From price</lable> 
                                                        <input type="text" name="Fprice" class="form-control " placeholder="form price"> 
                                                    </div> 
                                                    <div class="col-2" style="width: 100px">
                                                        <lable class="badge badge-pill badge-warning p-3 my-2"> To Price</lable> 
                                                        <input type="text" name="Tprice" placeholder="to price" class="form-control">
                                                    </div>
                                                    <div class="col-3 d-flex align-items-end" style="width: 100px">
                                                        <button type="submit" name="action" value="searchPrice" class="btn btn-success">
                                                          Search
                                                         <i class="fa-solid fa-magnifying-glass"> </i>  
                                                        </button>   
                                                    </div>
                                                </div>
                                                
                                            </form>
                                        </div>



                                        <div class="input-group">

                                            <form action="MainController" method="get">

                                        </div>

                                        <% List<MobileDTO> list = null;

                                            if (request.getAttribute("list") != null) {
                                                list = (List<MobileDTO>) request.getAttribute("list");
                                            } else {
                                                list = PaginationDAO.getLimitProduct(0);

                                            }
                                        %>
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


                                                        <% int count=0; for (MobileDTO listMobile : list) { count++; %>

                                                            <tr>
                                                                <form action="MainController" method="get">
                                                                    <th scope="row">
                                                                        <%= count%>
                                                                    </th>
                                                                    <td>
                                                                        <input type="text" name="ID"
                                                                            value="<%= listMobile.getMobileId()%>"
                                                                            class="form-control" readonly="">
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="name "
                                                                            value="<%= listMobile.getMobileName() %>"
                                                                            class="form-control" readonly="">

                                                                    </td>

                                                                    <td>
                                                                        <%= listMobile.getDescription()%>
                                                                    </td>

                                                                    <td>
                                                                        <%= listMobile.getPrice() %>

                                                                    </td>

                                                                    <td>
                                                                        <%= listMobile.getYear() %>
                                                                    </td>


                                                                    <td>
                                                                        <%= listMobile.getQuantity()%>
                                                                    </td>
                                                                    <th>


                                                                        <% if (listMobile.getNotSale()==1) { %>
                                                                            <span
                                                                                class="badge bg-success p-3">Sale</span>
                                                                            <% } else { %>
                                                                                <span class="badge bg-danger p-3">Not
                                                                                    Sale</span>
                                                                                <% } %>
                                                                    </th>

                                                                    <th>
                                                                        <!--                                                        <input type="submit" name="action" value="addToCart"
                                                            class="btn btn-primary">-->
                                                                        <% if (listMobile.getNotSale()==1) { %>
                                                                            <button class="btn btn-success"
                                                                                name="action" value="addToCart">
                                                                                <i
                                                                                    class="fa-solid fa-cart-shopping"></i>
                                                                            </button>
                                                                            <% } else { %>
                                                                                <button
                                                                                    class="btn btn-secondary btn-NonShopCart"
                                                                                    type="button">
                                                                                    <i
                                                                                        class="fa-solid fa-cart-shopping"></i>
                                                                                </button>
                                                                                <% }%>
                                                                    </th>
                                                                    <th>
                                                                        <button class="btn btn-danger" name="action"
                                                                            value="wishList">
                                                                            <i class="fa-solid fa-heart"></i>
                                                                        </button>

                                                                    </th>
                                                                </form>
                                                            </tr>
                                                            <% } %>
                                                    </tbody>

                                                </table>
                                                <!--  Pagination -->
                                                <div class="pagination">
                                                    <ul class="pagination">
                                                        <% int index=0; %>
                                                            <li class="page-item">
                                                                <a class="page-link"
                                                                    href="MainController?pageId=<%= index-- %>&action=pagination"
                                                                    aria-label="Previous">
                                                                    <span aria-hidden="true">&laquo;</span>
                                                                    <span class="sr-only">Previous</span>
                                                                </a>
                                                            </li>
                                                            <!-- part pagination number page -->
                                                            <% int endPage = 0;
                                                                endPage = Pagination.PaginationDAO.getCount();
                                                                endPage = (endPage / 3);
                                                                if (endPage % 3 != 0) {
                                                                    endPage++;
                                                                }
                                                                for (int i = 1; i <= endPage; i++) {
                                                                    index = i;%>

                                                                <li class="page-item">
                                                                    <a href="MainController?pageId=<%= i%>&action=pagination"
                                                                        class="page-link">

                                                                        <%= i %>

                                                                    </a>
                                                                    <input type="hidden" name="pageNumber"
                                                                        value="<%= i %>"></input>
                                                                </li>
                                                                <% } %>
                                                                    <li class="page-item">
                                                                        <a class="page-link" href="MainController?pageId=<%= (index+ 1)%>&action=pagination" aria-label="Next">
                                                                            <span aria-hidden="true">&raquo;</span>
                                                                            <span class="sr-only">Next</span>
                                                                        </a>
                                                                    </li>

                                                    </ul>
                                                </div>

                                                <div class="view-cart">
                                                    <a href="viewCart.jsp">
                                                        <button class="btn btn-primary"> view Cart </button>
                                                    </a>
                                                </div>


                                    </div>

                                    <div class="container-alert">
                                        <% String message="" ; if (request.getAttribute("message") !=null) {
                                            message=(String)request.getAttribute("message"); %>
                                            <div class="alert alert-success alert-success-wishList alert-box fade-out"
                                                role="alert">
                                                <p>
                                                    <%= message %>
                                                </p>
                                            </div>
                                            <% } else { message="" ; }%>
                                    </div>

                                    <script
                                        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                                        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                                        crossorigin="anonymous"></script>

                                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                                        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
                                        crossorigin="anonymous"></script>
                                    <script>
                                        setTimeout(function () {
                                            const alertBox = document.getElementById('alert-box');
                                            alertBox.classList.add('fade-out');
                                            // Remove the alert box from the DOM after the fade-out animation
                                            alertBox.addEventListener('animationend', function () {
                                                alertBox.remove();
                                            });
                                        }, 1000);
                                        // 
                                        setTimeout(function () {
                                            const alertBox = document.getElementById('alert-success-wishList');
                                            alertBox.classList.add('fade-out');
                                            // Remove the alert box from the DOM after the fade-out animation
                                            alertBox.addEventListener('animationend', function () {
                                                alertBox.remove();
                                            });
                                        }, 2000);
                                        //  btn  not add to cart
                                        document.querySelectorAll('.btn-NonShopCart').forEach(button => {
                                            button.addEventListener('click', function (event) {
                                                window.alert('Product Not Sales');
                                            })
                                        })


                                        console.log(document.querySelectorAll(".pageNumber").value)

                                    </script>
                            </body>

                            </html>