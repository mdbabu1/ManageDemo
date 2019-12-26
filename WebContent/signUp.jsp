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
    }
    
</script>


<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="signup.css">

    <title>Signup | Simple Property - Property Management System</title>
</head>
 
<body>

   <!-- Navbar -->
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
                     <a href="signIn.jsp" class = "nav-link"> Login  <i class="fa fa-user"></i></a>
                    </li>
               </ul>
            </div>
         </div>
      </nav>

    <div class="container-fluid bg-light py-5">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-6 mx-auto">
                    <div class="card card-body">
                        <h3 class="text-center mb-4">Sign-up</h3>
                        <form name="signUpForm" action="${pageContext.request.contextPath}/SignUpServlet" 
        method="post">
          <fieldset>
            <legend>Please fill out the following:</legend>
            <label for="name">Full Name:</label>                        
            <input id="name" type="text" step="0.01" min=0 name="name" required>
            <br>
            <label for="address">Street Address:</label>
            <input type="text" name="address" maxlength="100" required>
            <br>
            <label for="city">City:</label>
            <input type="text" name="city" maxlength="25" required>
            <br>
            <label for="state">State (Abbreviation):</label>
            <input type="text" name="state" maxlength="2" required>
            <br>
            <label for="zip">Zip Code:</label> 
            <input type="text" name="zip" maxlength="12" required>
            <br>
            <label for="email">Email:</label>
            <input type="text" name="email" maxlength="30" required>
            <br>
            <label for="phone">Phone Number:</label>
            <input type="text" name="phone" maxlength="30" required>
            <br>
            <label for="userType">Type of User:</label>
            <select name="userType">
    			<option value="tenant">Tenant</option>
    			<option value="broker">Broker</option>
    			<option value="maintenance">Maintenance</option>
  			</select>
            <br><br>
            <input id="button" type="submit" value="Submit">
          </fieldset>
        </form>

                    </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
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
