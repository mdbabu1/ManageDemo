<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="system.Quote"%>
<%@page import="system.Client" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*, java.text.*" %>
<%@page import="db.DBHandler"%>
<%@ page import="java.sql.*" %>

<%
    try{
        String email = request.getParameter("email");   
        String name = request.getParameter("name");
        DBHandler db = new DBHandler();
		Connection conn = db.getConnection();
        int id = db.queryForUser(conn, name, email);
		if (id != -1) {
			response.sendRedirect("mainAfterLogin.html");
		}
		else
			out.println("Error");     
   }
   catch(Exception e){       
       out.println("Something went wrong !! Please try again");
       e.printStackTrace();
   }      
%>
</body>
</html>