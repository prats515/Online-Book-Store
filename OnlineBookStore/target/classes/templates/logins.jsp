<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Admin Login | St Papper</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <!-- Tempusdominus Bbootstrap 4 -->
    <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/layout.css">
    <link href="dist/css/stylesheet.css" rel="stylesheet">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
 </head>
</head>
<body class="h-100 d-flex flex-column outer-page">

      <!--hero-section-->

      <main class="flex-shrink-0">
        <div class="parent-container">
          <div class="right-container">



            <div class="rg-form align-self-center">
              <div class="text-center mb-4"><a href="#"><img src="dist/img/~logo.png" width="250" alt=""></a></div>
             <div class="form-heading"> <strong class="h1"> Login  </strong>
              <div class="divider"></div>
              </div>
              <form class="login-form" action="/home">
                <div class="form-group">
                  <label class="form-label" for="emailField">Username</label>
                  <div class="input-cover"><input type="text" class="form-control" id="emailField" placeholder="info@example.com"/></div>
                </div>
                <div class="form-group">
                  <label class="form-label" for="loginPass">Password</label>
                  <div class="input-cover"><input type="password" class="form-control" id="loginPass" placeholder="********"/></div>
                  <a href="forgotpass.html" class="my-2 d-inline-block">Forgot Password ?</a>
                </div>

                <div class="text-center mt-4">
                  <button class="btn btn-primary w-100"><span> Login <i class="fa fa-long-arrow-alt-right ml-1"></i></span></button>
                </div>

              </form>

            </div>
            <footer class="footer mt-auto py-3 w-100">
              <p>© Copyright ST Paper 2023</p>

          </div>

        </div>
      </main>
      <!--footer-->

      <!--footer-sec-end-->
      </body>
</html>