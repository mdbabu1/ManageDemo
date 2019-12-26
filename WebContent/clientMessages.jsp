<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="system.Message"%>
<%@page import="system.AllMessages"%>
<%@page import="db.DBHandler"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*, java.text.*" %>
<%@page import="db.DBHandler"%>
<%@ page import="java.sql.*" %>
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
	<title>Messages | Simple Property - Property Management System</title>

</head>

		<%            
      		int id = (int)session.getAttribute("clientId");
			System.out.println(id);
		
        %>
        
<body class = "bg-light">

	<nav id = "mainNavbar" class = "navbar bg-dark navbar-dark navbar-expand-md py-0 fixed-top">
		<div class = "container">
			<a href="home.html" class = "navbar-brand"><i class="fas fa-home"></i> Simple Property</a>
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
						<a href="signup.jsp" class = "nav-link" <%session.removeAttribute("clientId"); %>>Signup  <i class="fas fa-user-plus"></i></a>
					</li>
					<li class = "nav-items">
                    	<a href="signIn.jsp" class = "nav-link" <%session.removeAttribute("clientId"); %>> Login  <i class="fa fa-user"></i></a>
                  	</li>
					<!-- <li class = "nav-items">
					<a href="login.html" class = "nav-linkLogin  <i class="fa fa-user"></i></a>
					</li> -->
				</ul>
			</div>
		</div>
	</nav>
	
	<%
			  //int id = (int)session.getAttribute("clientId");
			  System.out.println(id);
              DBHandler db = new DBHandler();
      		  Connection conn = db.getConnection();
      		  ArrayList<Message> list = db.queryMessageWithId(conn, id);
      		  //System.out.println(list.get(0).getSender());
    %>
    <section class = "container">
        <div class = "row align-items-center justify-content-center mt-5">
          <div class = "col-12 mb-3">
            <div class = "card">
              <img id = "card-image-top" class = "card-img-top" src="listing.jpg" alt = "">
                <div class = "card-body">
                  <h5 class = "card-title"> Messages</h5>
                    <p class="card-text">
                    <table>
            <tr>
              <th>Sender ID</th>
              <th>Message</th>
            </tr>
            
              <%for(int i = 0; i < list.size();i++){%>
                  <tr>
                  <td><%out.print(list.get(i).getSender()); %></td>
                  <td><%out.print(list.get(i).getMessage()); %></td>
                  </tr>
              <%}%>
      
          </table>
                </div>    
            </div>
          </div>
        </div>
      </section>
	

</body>
</html>