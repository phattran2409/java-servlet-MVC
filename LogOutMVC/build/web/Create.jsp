<%-- 
    Document   : Create
    Created on : May 12, 2024, 4:36:48 PM
    Author     : ADMIN
--%>

<%@page import="User.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <style>
        body {
            width: 100%;
            height: 100vh;
            border: 1px solid red;
            display: flex;
            justify-content: center;
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
</head>

<body>
    <header>
        <!-- place navbar here -->
    </header>
    <main>
        <%  UserError userE  = (UserError) request.getAttribute("UserErr"); %>
        <button class="btn btn-primary btn-collapse" type="button" data-bs-toggle="collapse"
            data-bs-target="#createUser" aria-expanded="false" aria-controls="createUser"> Create </button>
        <div class="container collapse" id="createUser">
            <div class="d-flex justify-content-center align-items-center formCenter">
                <form action="CreateServlet" method="post" class="formInput">
                    <label for="User">UserId</label>
                    <input class="form-control" type="text" name="user" id="User">
                    <!--  show error  message  with userName-->
                    <p class="text-danger">  <%= userE.getUserId() %> </p>
                    <label for="">Fullname</label>
                    <input type="text" name="FullName">
                    <label for="">role ID</label>
                    <div class="CheckBox">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1"
                                name="User" value="User">
                            <label class="form-check-label " for="flexRadioDefault1">
                                User
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"
                                name="Admin" value="Admin" checked>
                            <label class="form-check-label text-danger " for="flexRadioDefault2">
                                Admin
                            </label>
                        </div>
                    </div>
                    <label for="">Password</label>
                    <input type="text" name="password">
                    <input type="submit" value="submit">
                </form> 
                    <h1 class="text-danger"> ${messageBlank} </h1>
            </div>
        </div>

        <p>
            <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#contentId"
                aria-controls="contentId">
                Show
            </button>


        </p>



    </main>
    <footer>
        <!-- place footer here -->
    </footer>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
    <script>
        const formCreate = document.getElementById("createUser");
        console.log(formCreate);
        function ShowCreate() {
            if (formCreate.style.display === "none") {
                formCreate.style.display = "block";
            }
        }
    </script>
</body>

</html>