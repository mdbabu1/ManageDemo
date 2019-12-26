<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="system.Quote"%>
<%@page import="system.Client" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*, java.text.*" %>
<%@page import="db.DBHandler"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>TOaG History</title>
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

table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 10px;
}

table#quote_history tr:nth-child(even) {
    background-color: #eee;
}

table#quote_history tr:nth-child(odd) {
   background-color: #fff;
}

table#quote_history th {
    background-color: grey;
    color: white;
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
<h2>Quote History</h2>
</header>

<%
/*
    Quote quote = new Quote();

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    String rDate = "7-Jun-2013";
    String dDate = "15-Jun-2013";
    Date requestDate = formatter.parse(rDate);
    Date deliveryDate = formatter.parse(dDate);

    quote.setRequestDate(requestDate);
    quote.setDeliveryDate(deliveryDate);
    quote.setGallonsRequested(25);
    quote.setSuggestedPrice(3);
    quote.setTotalAmountDue(75);
    quote.setClientId(1);
*/    
%>

<section>
    <nav>
      <ul>
       <li><a href=clientInfo.jsp>Client Information</a></li>
      <li><a href="quoteForm.jsp">Request a Quote</a></li>
      </ul>
    </nav>
    
    <article>

        <h1></h1>
        
        <%
              DBHandler db = new DBHandler();
      		  Connection conn = db.getConnection();
      		  //ArrayList<Quote> list = db.queryQuote(conn); 
      		  int id = (int)session.getAttribute("clientId");
      		  ArrayList<Quote> list = db.queryQuoteWithId(conn, id);
        %>

        <table style="width:100%" id="quote_history">
            <tr>
              <th>Quote #</th>
              <th>Request Date</th> 
              <th>Delivery Date</th>
              <th>Gallons</th>
              <th>Rate</th>
              <th>Total Price</th>
            </tr>
            
              <%for(int i = 0; i < list.size();i++){%>
                  <tr>
                  <td><%out.print(list.get(i).getClientId()); %></td>
                  <td><%out.print(list.get(i).getRequestDate()); %></td>
                  <td><%out.print(list.get(i).getDeliveryDate()); %></td>
                  <td><%out.print(String.format( "%.2f", list.get(i).getGallonsRequested())); %></td>
                  <td><%out.print(String.format( "%.2f", list.get(i).getSuggestedPrice())); %></td>
                  <td><%out.print(String.format( "%.2f", list.get(i).getTotalAmountDue())); %></td>
                  </tr>
              <%}%>
      
          </table>

    </article>

</section>

<footer>
  <h2>All collected information is kept confidential.</h2>
  <p> Client info:<%session.getAttribute("theName"); %>
  </p>
</footer>

</body>
</html>