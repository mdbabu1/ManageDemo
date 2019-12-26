<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="system.Client"%>
<%@page import="system.Quote"%>
<%@page import="db.DBHandler"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*, java.text.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>TOaG Client</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
    box-sizing: border-box;
}

body {
    font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
    background-color: #107795;
    padding: 20px;
    text-align: center;
    font-size: 35px;
    color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
    float: left;
    width: 20%;
    height: 400px;
    background: #ccc;
    padding: 20px;
}

/* Style the list inside the menu */
nav ul {
    list-style-type: none;
    padding: 0;
}

a:link {
    color:#000066;
}

a:visited {
    color:#003366;
}

a:focus {
    color:#FF0000;
}

a:hover {
    color:#0099CC;
}

a:active {
    color:#FF0000;
}

article {
    float: left;
    padding: 20px;
    width: 80%;
    background-color: #f1f1f1;
    height: 400px;
}

/* Clear floats after the columns */
section:after {
    content: "";
    display: table;
    clear: both;
}

/* Style the footer */
footer {
    background-color: #107795;
    padding: 50px;
    text-align: center;
    font-size: 10px;
    color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
    nav, article {
        width: 100%;
        height: auto;
    }
}
</style>
</head>
<body>

<header>
  <h2>Client information</h2>
</header>

<%
    Client client = new Client();

	DBHandler db = new DBHandler();
  	Connection conn = db.getConnection();
  	int id = (int)session.getAttribute("clientId");
  	client = db.queryClientWithId(conn, id);
 
%>

<section>
  <nav>
    <ul>
      <li><a href="quoteForm.jsp">Request a Quote</a></li>
      <li><a href="quoteHistory.jsp">Quote History</a></li>
    </ul>
  </nav>
  
  <article>
    <h1></h1>
    <p>
    <ul class="services">
    <li>Name: <%out.print(client.getName()); %></li>
    <li>Address: <%out.print(client.getAddress());%></li>
    <li>Phone: <%out.print(client.getPhone());%></li>
    <li>Email: <%out.print(client.getEmail());%></li>
    </ul>
  </article>
</section>

<footer>
  <h2>All collected information is kept confidential.</h2>
</footer>

</body>
</html>
