<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="db.DBHandler"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>



<script type="text/javascript">
    function validate(){
    	
    	// =========================================
    	// VALIDATE DATE -- WORKS
    	// - month must be between 1 and 12
    	// - day depends on month
    	// - year must be between 2018 and 2099
    	// =========================================
    	//var re = /^\d{2}\/\d{2}\/\d{4}$/;
    	var re = /^\d{2}\-\d{2}\-\d{4}$/;
        if(quoteForm.date.value == '') {
        	alert("Delivery Date must be entered.")
        	quoteForm.date.focus();
        	return false;
        }
        else if(!quoteForm.date.value.match(re)) {
          alert("Invalid date format: " + quoteForm.date.value + 
        		"\nCorrect format is MM-DD-YYYY.");
          quoteForm.date.focus();
          return false;
        }
        else {
        	var dateStr = quoteForm.date.value;
        	//var dateArr = dateStr.split("/");
        	var dateArr = dateStr.split("-");
        	// CHECK IF MONTH IS VALID
        	if ((parseInt(dateArr[0]) < 1) || (parseInt(dateArr[0]) > 12)){
        		alert("Month of date entered must be between 1 and 12.");
        		quoteForm.date.focus();
        		return false;
        	}
        	
        	// CHECK IF DAY IS VALID
        	if ((parseInt(dateArr[0]) == 1) || (parseInt(dateArr[0]) == 3) ||
        		(parseInt(dateArr[0]) == 5)	|| (parseInt(dateArr[0]) == 7) ||
        		(parseInt(dateArr[0]) == 8) || (parseInt(dateArr[0]) == 10) ||
        		(parseInt(dateArr[0]) == 12)) {
        		if ((parseInt(dateArr[1]) < 1) || (parseInt(dateArr[1]) > 31)) {
        			alert("Invalid day entered, for given month it should be between 1 and 31.");
        			quoteForm.date.focus();
        			return false;
        		}
        	}
        	else {
    			if ((parseInt(dateArr[0]) == 2)) {
    				if ((parseInt(dateArr[1]) < 1) || (parseInt(dateArr[1]) > 28)) {
    					alert("It is not leap year, enter a day between 1 and 28.");
    					quoteForm.date.focus();
    					return false;
    				}
    			}
    			else {
    				if ((parseInt(dateArr[1]) < 1) || (parseInt(dateArr[1]) > 30)) {
    					alert("Invalid day entered, for given month it should be between 1 and 30.");
    					quoteForm.date.focus();
    					return false;
    				}
    			}
    		}
        	// CHECK IF YEAR IS VALID
        	if ((parseInt(dateArr[2]) < 2018) || (parseInt(dateArr[2]) > 2099)) {
        		alert("Invalid year entered, it should be between 2018 and 2099.");
        		quoteForm.date.focus();
        		return false;
        	}
        }
        
        // =========================================
        // VALIDATE EMAIL -- WORKS
        // - email must must be in format xxx@xxx.xxx
        // =========================================
        var vEmail = /\S+@\S+\.\S+/;
        if(quoteForm.email.value == ''){
        	alert("Email must be entered.");
        	quoteForm.email.focus();
        	return false;
        }
        else if(!quoteForm.email.value.match(vEmail)) {
        	alert("Invalid email format: " + quoteForm.email.value +
        		  "\nCorrect format is example@example.com");
        	quoteForm.email.focus();
        	return false;
        }
        else {} // DO NOTHING, CONTINUE
        
        /*
        // =========================================
        // VALIDATE PHONE
        // - phone number must must be in format xxx-xxx-xxxx
        // =========================================
        var vPhone = /^\d{3}\-\d{3}\-\d{4}$/;
        if (quoteForm.phone.value == ''){
        	alert("Phone number must be entered.");
        	quoteForm.phone.focus();
        	return false;
        }
        else if(!quoteForm.phone.value.match(vPhone)){
        	alert("Invalid phone number format: " + quoteForm.phone.value +
        		  "\nCorrect format is XXX-XXX-XXXX");
        	quoteForm.phone.focus();
        	return false;
        }
        
        	
        // =========================================
        // VALIDATE NAME -- WORKS
        // - name must not start with space
        // - name must not end with space
        // - name must contain only letters
        // =========================================
        //var vName = /^[a-zA-Z]+$/;
        //var vName = /^([a-zA-Z0-9][a-zA-Z0-9 ]*[a-zA-Z0-9]$/;
        if(quoteForm.name.value == ''){
        	alert("Name must be entered.");
        	quoteForm.name.focus();
        	return false;
        }
        else if(!quoteForm.name.value.match("^[a-zA-z]+[(?<=ds]([a-zA-Z ])*[a-zA-Z]+$")){
        	alert("Invalid name: " + quoteForm.name.value +
        		  "\nName must not contain special characters or numbers.");
        	quoteForm.name.focus();
        	return false;
        }
        */
        // =========================================
        // VALIDATE GALLONS -- WORKS
        // - gallons must be a two-decimal number
        // =========================================
        if(quoteForm.gallons.value == '') {
        	alert("Must enter a number for the amount of gallons desired.");
        	quoteForm.gallons.focus();
        	return false;
        }
        else if(!quoteForm.gallons.value.match("^[0-9]+\\.?[0-9]{2}$")){
        	alert("Invalid number entered for gallons: " + quoteForm.gallons.value + 
        		  "\nGallons must be a number with exactly 2 decimal places.");
        	quoteForm.gallons.focus();
        	return false;
        }
        
        // =========================================
        // VALIDATE PRICE/GALLON -- WORKS
        // - price per gallon must be a two-decimal number
        // =========================================
        if(quoteForm.price.value == '') {
        	alert("Must enter a price per gallon.");
        	quoteForm.price.focus();
        	return false;
        }
        else if(!quoteForm.price.value.match("^[0-9]+\\.?[0-9]{2}$")){
        	alert("Invalid number entered for price per gallon: " + quoteForm.price.value + 
        		  "\nPrice must be a number with exactly 2 decimal places.");
        	quoteForm.price.focus();
        	return false;
        }
    	
        // =========================================
        // VALIDATE TOTAL COST -- WORKS
        // - total cost must be a two-decimal number
        // =========================================
        if(quoteForm.cost.value == '') {
        	alert("Must enter a total cost for this order.");
        	quoteForm.cost.focus();
        	return false;
        }
        else if(!quoteForm.cost.value.match("^[0-9]+\\.?[0-9]{2}$")){
        	alert("Invalid number entered for total cost: " + quoteForm.cost.value + 
        		  "\nTotal cost must be a number with exactly 2 decimal places.");
        	quoteForm.cost.focus();
        	return false;
        } 	
    }
    
</script>
<title>TOaG Quote</title>
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

input:hover {
    background-color: #0099CC;
}

a:active {
    color:#FF0000;
}

input:focus {
    background-color: lightblue;
}

#button:hover {
    background-color: #0099CC;
}

article {
    float: left;
    padding: 20px;
    width: 80%;
    background-color: #f1f1f1;
    height: 400px;
}

label {
    display: inline-block;
    width:250px;
    text-align: right;
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
  <h2>Request a Quote</h2>
</header>

<section>
    <nav>
      <ul>
        <li><a href=clientInfo.jsp>Client Information</a></li>
      	<li><a href="quoteHistory.jsp">Quote History</a></li>
      </ul>
    </nav>
    
    <article>
        <h1></h1>
        <form name="quoteForm" onSubmit="return validate()" 
        action="${pageContext.request.contextPath}/FormServlet" 
        method="post">
          <fieldset>
            <legend>Please fill out the following:</legend>
            <label for="gallons">Gallons Requested:</label>                        
            <input id="gallons" type="text" step="0.01" min=0 name="gallons" required>
            <br>
            <label for="date">Delivery Date:</label>
            <input type="text" name="date" maxlength="25" required>
            <br>
            <label for="address">Delivery Address:</label>
            <input type="text" name="address" maxlength="25" required>
            <br>
            <label for="city">Delivery City:</label>
            <input type="text" name="city" maxlength="25" required>
            <br>
            <label for="state">Delivery State:</label>
            <input type="text" name="state" maxlength="2" required>
            <br>
            <label for="zip">Zip Code:</label>
            <input type="text" name="zip" maxlength="30" required>
            <br>
            <label for="name">Delivery Contact Person Name:</label>
            <input type="text" name="name" maxlength="25" required>
            <br>
            <label for="phone">Delivery Contact Person Phone:</label> 
            <input type="text" name="phone" maxlength="30" required>
            <br>
            <label for="email">Delivery Contact Person Email:</label>
            <input type="text" name="email" maxlength="30" required>
            <br><br>
            <!-- <input type="hidden" name="clientId" value="<%session.getAttribute("clientId").toString(); %>"/> -->
            <input id="button" type="submit" value="Submit">
          </fieldset>
        </form>
        
        <form name="quoteForm" onSubmit="return validate()" 
        action="${pageContext.request.contextPath}/priceServlet" 
        method="post">
          <fieldset>
            <legend>Price information:</legend>
            <p>Suggested Price: ${suggestedPrice}</p>                    
            <p>Total Cost: ${totalCost}</p>   
            <!-- <input type="hidden" name="clientId" value="<%session.getAttribute("clientId").toString(); %>"/> -->
            <button onclick="submitFunc()">Get price</button>
            <script src="jQuery.js"></script>
            <script>
            function submitFunc(){
            	$(document).ready(function() {                       
                	$('#button1').click(function() {               
                 	   $.get('priceServlet', function(responseText) { 
                	        $('#output').text(responseText);        
                 	   });
               	 });
           	 });
           	 $("#button1").click(function(){
          	  $.ajax
          	  (
           	 {
           	     url:'priceServlet',
           	     data:{gallons: quoteForm.gallons.value,
           	    	   state: quoteForm.state.value},
                 type:'get',
              	 cache:false,
              	 success:function(data){alert(data);},
              	 error:function(){alert('error');}
             }
        );
    }
    );
            }
            </script>
          </fieldset>
        </form>
        
    </article>
</section>

<footer>
  <h2>All collected information is kept confidential.</h2>
</footer>

</body>
</html>