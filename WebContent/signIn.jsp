<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <!-- Required meta tags -->
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
   <link rel="stylesheet" type="text/css" href="login.css">
	<title>Login | Simple Property - Property Management System</title>

</head>
<body class = "bg-light">

	<nav id = "mainNavbar" class = "navbar bg-dark navbar-dark navbar-expand-md py-0 fixed-top">
		<div class = "container">
			<a href="home.jsp" class = "navbar-brand"><i class="fas fa-home"></i> Simple Property</a>
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
					<a href="signUp.jsp" class = "nav-link">Signup  <i class="fas fa-user-plus"></i></a>
					</li>
					<!-- <li class = "nav-items">
					<a href="login.html" class = "nav-linkLogin  <i class="fa fa-user"></i></a>
					</li> -->
				</ul>
			</div>
		</div>
	</nav>

	<div class = "container pt-4 px-0">
		<div class = "row align-items-center justify-content-center">
			<!-- <div class = "col-4"></div> -->
			<div id = "login-div" class = "col-md-4 col-lg-4 mx-auto border rounded bg-white">
				<h3 class="text-center mb-4">Login</h3>
					<form name="loginForm" method="post" action="${pageContext.request.contextPath}/LoginServlet">
            <table>
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" required/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Login" />
                            &nbsp;&nbsp;
                            <input type="reset" value="Reset" />
                        </td>                        
                    </tr>                    
                </tbody>
            </table>
        </form>

			</div>
			<!-- <div class = "col-4"></div> -->
		</div>
	</div>



<!-- <section>
  
  <article>
		<h1></h1>
		<form name="loginForm" method="post" action="${pageContext.request.contextPath}/LoginServlet">
            <table>
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" required/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Login" />
                            &nbsp;&nbsp;
                            <input type="reset" value="Reset" />
                        </td>                        
                    </tr>                    
                </tbody>
            </table>
        </form>

	</article>
</section> -->

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"        crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

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