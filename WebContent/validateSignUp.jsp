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
	String name=request.getParameter("name");
	String address=request.getParameter("address");
	String city=request.getParameter("city");
	String email=request.getParameter("email");
	String state=request.getParameter("state");
	String zip=request.getParameter("zip");
	String phone=request.getParameter("phone");
	DBHandler db = new DBHandler();
	Connection conn = db.getConnection();
	Client client = new Client();
	client.setName(name);
	client.setAddress(address);
	client.setCity(city);
	client.setState(state);
	client.setZip(zip);
	client.setEmail(email);
	client.setPhone(phone);
    

	String sql = String.format("Insert into FuelApp.clientInformation (fullName, address, city, state, zipCode, phone, email) values (%s,%s,%s,%s,%s,%s,%s);", name, address, city, state, zip, phone, email);
	
	try {
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.executeQuery();
	} catch(Exception e) {
		e.printStackTrace();
	}      
%>

</body>
</html>