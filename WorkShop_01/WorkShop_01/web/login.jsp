<%-- 
    Document   : login.jsp
    Created on : May 23, 2024, 8:07:20 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<style>
    /* .login {

    
        background: rgba(255, 255, 255, 0.975);
        backdrop-filter: blur(50px);
        border-bottom: 1px solid rgba(255, 255, 255, 0.5);
        border-right: 1px solid rgba(255, 255, 255, 0.5);
        border-radius: 20px;


        box-shadow: 0 25px 50px rgba(0, 0, 0, 0.1);
        transform: translateX(-100px);

    } */
    .login {
        padding: 1em;
        background: rgba(255, 255, 255, 0.773);
        backdrop-filter: blur(15px);
        transform: translateX(-200px);
        border-radius: 20px;
        box-shadow: 0 25px 50px rgba(231, 231, 231, 0.614);
        width: 500px;
        height: 100%;
        z-index: 100;
        display: flex;
        flex-direction: column;

    }

    .login>input {
        width: 100%;
    }

    .card-body-login {
        /* background: rgba(255,255,255,0.25); */
        backdrop-filter: blur(50px);

    }
</style>

<body>
    <header>
        <!-- place navbar here -->
    </header>
    <main>
        <section class="vh-100 " style="background:linear-gradient(to right,#B5FFFC,#ff2970)">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-xl-10">
                        <div class="card" style="border-radius: 1rem;">
                            <div class="row g-0">
                                <div class="col-md-6 col-lg-7  d-none d-md-block">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
                                        alt="login form" class="img-fluid h-100"
                                        style="border-radius: 1rem 0 0 1rem;" />
                                </div>
                                <div class="col-md-6 col-lg-5 d-flex align-items-center ">
                                    <div class="card-body-login p-4 p-lg-5 h-100 w-100"
                                        style="background: #333; border-radius: 10px;">

                                        <form class="login justify-content-center align-items-center" method="post" action="MainController">

                                            <div class="d-flex align-items-center mb-3 pb-1">
                                                <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                                <span class="h1 fw-bold mb-0">Login</span>
                                            </div>

                                            <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">login into your
                                                account
                                            </h5>

                                            <div data-mdb-input-init class="form-outline mb-4 w-100">
                                                <input type="text" name="userID" id="form2Example17"
                                                       class="form-control form-control-lg" required="" />
                                                <label class="form-label" for="form2Example17">User ID</label>
                                            </div>

                                            <div data-mdb-input-init class="form-outline mb-4 w-100">
                                                <input type="password" name="pass" id="form2Example27"
                                                       class="form-control form-control-lg"  required=""/>
                                                <label class="form-label" for="form2Example27">Password</label>
                                            </div>
                                            <div class="text-danger ">
                                                <p>${message}</p>
                                            </div>
                                            <div class="pt-1 mb-4  w-100">
                                                <button data-mdb-button-init data-mdb-ripple-init
                                                    class="btn btn-dark btn-lg btn-block w-100"
                                                    type="submit" name="action" value="login">Login</button>
                                            </div>

                                            <a class="small text-muted" href="#!">Forgot password?</a>
                                            <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account? <a
                                                    href="#!" style="color: #393f81;">Register here</a></p>
                                            <a href="#!" class="small text-muted">Terms of use.</a>
                                            <a href="#!" class="small text-muted">Privacy policy</a>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
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
</body>

</html>