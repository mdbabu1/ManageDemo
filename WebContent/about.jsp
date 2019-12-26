<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
   <!-- Required meta tags -->
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
   <link rel="stylesheet" type="text/css" href="about.css">
    <title>Simple Property | Property Management System</title>

</head>

<body>

   <!-- Navbar -->
      <nav id = "main-navbar" class = "navbar bg-dark navbar-dark navbar-expand-md py-0 fixed-top">
         <div class = "container">
            <a href="#" class = "navbar-brand"><i class="fas fa-home"></i> Simple Property</a>
            <button class = "navbar-toggler" data-toggle = "collapse" data-target = "#navLinks">
            <span class = "navbar-toggler-icon"></span>
            </button>
            <div class = "collapse navbar-collapse" id = "navLinks">
               <ul class = "navbar-nav">
                  <li class = "nav-items">
                     <a href="home.jsp" class = "nav-link active">HOME</a>
                  </li>
                  <li class = "nav-items">
                     <a href="about.jsp" class = "nav-link">ABOUT US</a>
                  </li>
                  <li class = "nav-items">
                     <a href="contact.jsp" class = "nav-link">CONTACT US</a>
                  </li>
               </ul>
               <ul class = "navbar-nav ml-auto">
                  <li class = "nav-items">
                     <a href="signup.html" class = "nav-link">Signup  <i class="fas fa-user-plus"></i></a>
                  </li>
                  <li class = "nav-items">
                     <a href="login.html" class = "nav-link"> Login  <i class="fa fa-user"></i></a>
                  </li>
               </ul>
            </div>
         </div>
      </nav>

      <section>
        <div class = "container text-center py-5">
          <h1>About Us</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
      </section>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

 <script>
    $(function () {
      $(document).scroll(function(){
         var $nav = $("#main-navbar");
         $nav.toggleClass("scrolled", $(this).scrollTop() > $nav.height());
      });
    });
 </script>

</body>

</html>