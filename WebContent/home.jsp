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
   <link rel="stylesheet" type="text/css" href="home.css">
    <title>Simple Property | Property Management System</title>

</head>

<body>

   <!-- Navbar -->
      <nav id = "mainNavbar" class = "navbar bg-white navbar-light navbar-expand-md py-0 fixed-top">
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
                     <a href="signUp.jsp" class = "nav-link" <%session.removeAttribute("clientId"); %>>Signup  <i class="fas fa-user-plus"></i></a>
                  </li>
                  <li class = "nav-items">
                     <a href="signIn.jsp" class = "nav-link" <%session.removeAttribute("clientId"); %>> Login  <i class="fa fa-user"></i></a>
                  </li>
               </ul>
            </div>
         </div>
      </nav>
      
      <!-- Information about what user can do (Cards system used) -->
      <section class="jumbotron jumbotron-fluid" id = "jumbotron-background">
        <div class="container container-fluid text-center">
          <h1 class="display-4 mx-3">Manage Your Property</h1>
          <p class="lead">Now manage your property from one place.</p>
        </div>
      </section>

      <section class = "container-fluid px-0">
         <div class = "row align-items-center content">
           <div class = "col-md-6 order-2 order-md-1">
             <img class = "img-fluid" src="Owner.jpg">
           </div>
           <div class = "col-md-6 text-center order-1 order-md-2">
             <div class = "row justify-content-center">
               <div class = "col-10 col-lg-8 blurb mb-5 mb-md-0">
                 <h2>OWNER</h2>
                 <p><i class="fas fa-home home-logo"></i></p>
                 <p class = "lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque, iste molestiae beatae, maiores deserunt in voluptatibus aspernatur architecto excepturi delectus soluta? Ipsa, deleniti dolorem hic consequatur repellat eveniet quidem voluptate necessitatibus dolorum delectus minus vitae, ut, veritatis sint ipsum magnam autem nam ex deserunt debitis eaque ratione! Nobis, quidem assumenda.</p>
               </div>
             </div>
           </div>
         </div>
         <div class = "row align-items-center content">
           <div class = "col-md-6 text-center">
             <div class = "row justify-content-center">
               <div class = "col-10 col-lg-8 blurb mb-5 mb-md-0">
                 <h2>TENANT</h2>
                 <p><i class="fas fa-home home-logo"></i></p>
                 <p class = "lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque, iste molestiae beatae, maiores deserunt in voluptatibus aspernatur architecto excepturi delectus soluta? Ipsa, deleniti dolorem hic consequatur repellat eveniet quidem voluptate necessitatibus dolorum delectus minus vitae, ut, veritatis sint ipsum magnam autem nam ex deserunt debitis eaque ratione! Nobis, quidem assumenda.</p>
               </div>
             </div>
           </div>
           <div class = "col-md-6">
             <img class = "img-fluid" src="Tenant.jpg">
           </div>
         </div>
         <div class = "row align-items-center content">
           <div class = "col-md-6 order-2 order-md-1">
             <img class = "img-fluid" src="Broker.jpg">
           </div>
           <div class = "col-md-6 text-center order-1 order-md-2">
             <div class = "row justify-content-center">
               <div class = "col-10 col-lg-8 blurb mb-5 mb-md-0">
                 <h2>BROKER</h2>
                 <p><i class="fas fa-home home-logo"></i></p>
                 <p class = "lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque, iste molestiae beatae, maiores deserunt in voluptatibus aspernatur architecto excepturi delectus soluta? Ipsa, deleniti dolorem hic consequatur repellat eveniet quidem voluptate necessitatibus dolorum delectus minus vitae, ut, veritatis sint ipsum magnam autem nam ex deserunt debitis eaque ratione! Nobis, quidem assumenda.</p>
               </div>
             </div>
           </div>
         </div> 
         <div class = "row align-items-center content">
           <div class = "col-md-6 text-center">
             <div class = "row justify-content-center">
               <div class = "col-10 col-lg-8 blurb mb-5 mb-md-0">
                 <h2>MAINTENANCE CREW</h2>
                 <p><i class="fas fa-home home-logo"></i></p>
                 <p class = "lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque, iste molestiae beatae, maiores deserunt in voluptatibus aspernatur architecto excepturi delectus soluta? Ipsa, deleniti dolorem hic consequatur repellat eveniet quidem voluptate necessitatibus dolorum delectus minus vitae, ut, veritatis sint ipsum magnam autem nam ex deserunt debitis eaque ratione! Nobis, quidem assumenda.</p>
               </div>
             </div>
           </div>
           <div class = "col-md-6">
             <img class = "img-fluid" src="Maintenance.jpg">
           </div>
         </div>
    </section>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

	<% 
  
  	//int id = (int)request.getAttribute("clientId"); 
  	//session.setAttribute("clientId", id);
  
  	%>
   <script>
      $(function () {
         $(document).scroll(function(){
          var $nav = $("#mainNavbar");
          $nav.toggleClass("scrolled", $(this).scrollTop() > $nav.height());
         });
      });
   </script>

</body>

</html>
