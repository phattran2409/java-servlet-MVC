<%-- Document : Staff Created on : May 23, 2024, 9:42:48 PM Author : Duc Phat --%>

<%@page import="mobile.MobileDao" %>
<%@page import="mobile.MobileDTO" %>
<%@page import="java.util.List" %>
<%@page import="User.UserDTO" %>
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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
    </style>

    <body>

        <% UserDTO user = (UserDTO) session.getAttribute("user");
                                if (user == null) {
                                    response.sendRedirect("login.jsp");
                                    return;
                                } %>


        <div class="alert alert-success alert-dismissible" id="alert-box">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Successfull Login!</strong>
            <span> Hello Staff </span> <span class="text-danger"> <strong> ${user.getFullName()}
                </strong>
            </span>
        </div>
        <div class="container">
            <div class="image-admin">
                <div class="image">
                    <img src="https://cdn-icons-png.flaticon.com/512/6024/6024190.png" alt="">
                </div>
                <div class="greeting-admin">
                    Welcome Back Staff : <Span
                        class="NameAdmin">${sessionScope.user.getFullName()}</Span>
                </div>
                <!-- button LogOut -->
                <a href="logOut">
                    <button class="btn btn-danger mt-2 mb-3 px-4 py-2">LogOut</button>
                </a>
            </div>



            <div class="input-group">

                <form action="MainController" method="get">


                    <div class="row d-flex justify-content-center align-items-center">
                        <div class="col-2">
                            <select name="searchType" id="" class="px-3 py-3 my-2 bg-warning rounded-pill" style="color: rgb(46, 47, 47); background: #e19f04;">
                                <option value="id">Search by ID</option>
                                <option value="name">Search By Name</option>
                            </select>
                        </div>
                        <div class="col-6 form-outline" data-mdb-input-init>
                            <input type="search" id="form1" class="form-control" placeholder="SEARCH" name="search" />



                        </div>

                        <button type="submit" name="action" value="search" class="col-2 btn btn-primary" data-mdb-ripple-init>
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </form>

            </div>
            <% List<MobileDTO> list = null;
                MobileDao dao = new MobileDao();

                if (request.getAttribute("list") != null) {
                    list = (List<MobileDTO>) request.getAttribute("list");
                } else {
                    list = dao.load();
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
                        <th scope="col">Sale</th>
                        <th scope="col"> Remove</th>
                        <th scope="col"> Update</th>

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
                               value="<%= listMobile.getMobileId()%>"
                               class="form-control" readonly="">
                    </td>
                    <td>
                        <input type="text" name="fullName"
                               value="<%= listMobile.getMobileName()%>"
                               class="form-control">
                    </td>

                    <td>
                        <input type="text" name="description"
                               value="<%= listMobile.getDescription()%>"
                               class="form-control w-100">
                    </td>

                    <td>
                        <input type="text" name="price"
                               value="<%= listMobile.getPrice()%> "
                               class="form-control">
                    </td>

                    <td>
                        <%= listMobile.getYear()%>
                    </td>


                    <td>
                        <input type="number" name="quantity"
                               value="<%= listMobile.getQuantity()%>"
                               class="w-50">
                    </td>
                    <td>
                        <input type="number" name="sale"
                               value="<%= listMobile.getNotSale()%>"
                               class="form-control w-50">
                    </td>
                    <th>
                        <input type="submit" name="action" value="remove"
                               class="btn btn-danger">

                    </th>
                    <th>
                        <input type="submit" name="action" value="update"
                               class="btn btn-secondary">
                    </th>
                </form>
                </tr>
                <% }%>
                </tbody>

            </table>

        </div>
        <!-- create new mobile product  -->
        <div class="container">
            <p>
                <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample"
                   role="button" aria-expanded="false" aria-controls="collapseExample">
                    create new mobile device
                </a>

            </p>
            <div class="collapse" id="collapseExample">
                <div class="container">
                    <div class="card card-body">
                        <div class="title w-100">
                            <h1 class="title-create text-center text-bg-success p-5 w-100">
                                Create A
                                New Product</h1>
                        </div>
                        <form action="createMobile" method="post">
                            <!-- mobile ID -->
                            <div class="row " style="padding: 0 1rem 0 1rem;">
                                <div class="col-6">
                                    <div class="mb-3">
                                        <label for="" class="form-label">MobileID</label>
                                        <input type="text" class="form-control rounded-pill"
                                               name="mobileID" id="" aria-describedby="helpId"
                                               placeholder="MobileID" />

                                    </div>
                                    <p class="text-danger"> ${message_DUPLICATE}</p>
                                </div>
                                <div class="col-6">
                                    <!-- Name -->
                                    <div class="mb-3">
                                        <label for="" class="form-label">Mobile Name</label>
                                        <input type="text" class="form-control rounded-pill"
                                               name="mobileName" id="" aria-describedby="helpId"
                                               placeholder="Mobile Name" />

                                    </div>
                                </div>
                            </div>
                            <!-- Description -->

                            <div class="mb-3">
                                <label for="" class="form-label">Description</label>
                                <input type="text" class="form-control rounded-pill"
                                       name="Description" id="" aria-describedby="helpId"
                                       placeholder="Description" />

                            </div>

                            <div class="row d-flex justify-content-between">
                                <div class="col-3">
                                    <!-- price  -->
                                    <div class="mb-3">
                                        <label for="" class="form-label">Price</label>
                                        <input type="number" class="form-control rounded-pill"
                                               name="price" id="" aria-describedby="helpId"
                                               placeholder="Price" />

                                    </div>
                                </div>
                                <!-- yearOfNumber -->
                                <div class="col-3">
                                    <div class="mb-3">
                                        <label for="" class="form-label">year Of Product</label>
                                        <input type="number" class="form-control rounded-pill"
                                               name="yearOfProduct" id="" aria-describedby="helpId"
                                               placeholder="Year Of Number" />

                                    </div>
                                </div>
                                <div class="col-3">
                                    <!-- quantity -->
                                    <div class="mb-3">
                                        <label for="" class="form-label">Quantity</label>
                                        <input type="number" class="form-control rounded-pill"
                                               name="quantity" id="" aria-describedby="helpId"
                                               placeholder="Quantity" />

                                    </div>
                                </div>
                                <!--  NotSale-->
                                <div class="col-2">
                                    <div class="mb-3">
                                        <label for="" class="form-label">Not Sale</label>
                                        <input type="number" class="form-control rounded-pill"
                                               name="notSale" id="" aria-describedby="helpId"
                                               placeholder="Not Sale" />

                                    </div>
                                </div>
                            </div>

                            <!-- SUBMIT -->
                            <input type="submit" name="action" value="createMoible"
                                   class="btn btn-primary my-3 px-3 py-3">

                        </form>
                    </div>
                </div>
            </div>
        </div>




        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
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
            }, 2000);
        </script>
    </body>

</html>