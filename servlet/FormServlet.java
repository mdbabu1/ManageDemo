package servlet;

import db.DBHandler;
import system.PriceModule;
import system.Quote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Made it to servlet");
		
		// TODO Change suggestedPrice and TotalCost to be read only, we should not get these values from request
		// TODO Until above change is made, simply print values to jsp page to test that new price module works
		
		//double gallons = 0.00, price = 0.00, cost = 0.00;
        Double gallons = Double.parseDouble(request.getParameter("gallons"));
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		System.out.printf("Date entered: %s\n", date);
		int numErrors = 0;
		
		// VALIDATE NUMBERS
		
		// GALLONS -- WORKS
		// if string is not a number, error
		String g = request.getParameter("gallons");
		boolean validGallons = false;
		String gallonError = "";
		
		try {
		    if (Double.isNaN(Double.parseDouble(g))) {
			    gallonError += "Gallons entered is not a number. ";
		    }
        } catch(Exception e) {
            gallonError += "Gallons entered is not a number. ";
        }
		if (g.contains(".")) {
			int index = g.indexOf(".");
			// if no number preceding decimal, error
			if (index == 0) {
				gallonError += "No number preceding decimal for gallons. ";
			}
			// if not two numbers following decimal, error
			if (g.length() - 1 != index + 2) {
				gallonError += "Gallon input does not contain two decimal places. ";
			}
			if (gallonError.isEmpty()) {
                validGallons = true;
			}
		}
		// if no decimal found, error
		else {
			gallonError += "No decimal found in gallons. ";
		}
		if (gallonError.isEmpty()) {
            validGallons = true;
        }
        if (validGallons) {
            System.out.printf("Valid number of gallons entered:%s.\n", g);
        }
        else {
            System.out.printf("Invalid number of gallons entered:%s.\n", g);
            System.out.println("Gallon Error: " + gallonError);
            numErrors++;
        }
		
		
		
		
		String dDate = request.getParameter("date");
		Date deliveryDate = null;
		try {
			deliveryDate=new SimpleDateFormat("MM-dd-yyyy").parse(dDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// VALIDATE DATE
        boolean validDate = false;
        String dateError = "";
        
        int k;
        if (date.length() != 10) {
            dateError += "Invalid date format, correct format is mm-dd-yyyy. ";
        }
        else {
            for (k = 0; k < date.length(); k++) {
                if (k == 2 || k == 5) {
                        if (date.charAt(k) != '-') {
                            dateError += "Missing date number separator(s), '-'."
                                    + " Correct format is mm-dd-yyyy. ";
                            break;
                        } 
                }
                if (!Character.isDigit(date.charAt(k))) {
                    if (k == 2 || k == 5) {
                        if (date.charAt(k) == '-') {
                            continue;
                        } 
                    }
                    else {
                        dateError += "Non-digit characters present in date. ";
                        break;
                    }
                }
            }
        }
        if (dateError.isEmpty()) {
            //String dateArr[] = date.split("/");
        	String dateArr[] = date.split("-");
            if ((Integer.parseInt(dateArr[0]) < 1) || (Integer.parseInt(dateArr[0]) > 12)){
        	dateError += "Month of date entered must be between 1 and 12. ";
            }
        	
            // CHECK IF DAY IS VALID
            if ((Integer.parseInt(dateArr[0]) == 1) || 
                (Integer.parseInt(dateArr[0]) == 3) ||
        	(Integer.parseInt(dateArr[0]) == 5)	|| 
                (Integer.parseInt(dateArr[0]) == 7) ||
        	(Integer.parseInt(dateArr[0]) == 8) || 
                (Integer.parseInt(dateArr[0]) == 10) ||
        	(Integer.parseInt(dateArr[0]) == 12)) {
                if ((Integer.parseInt(dateArr[1]) < 1) || 
                            (Integer.parseInt(dateArr[1]) > 31)) {
        			dateError += "Invalid day entered, for given month it should be between 1 and 31. ";
        	}
            }
            else {
    		if ((Integer.parseInt(dateArr[0]) == 2)) {
    		    if ((Integer.parseInt(dateArr[1]) < 1) || 
                        (Integer.parseInt(dateArr[1]) > 28)) {
    			dateError += "It is not leap year, enter a day between 1 and 28. ";
    		    }
    		}
                else if (Integer.parseInt(dateArr[0]) > 12) {
                    // DO NOTHING
                }
    		else {
    		    if ((Integer.parseInt(dateArr[1]) < 1) || 
                        (Integer.parseInt(dateArr[1]) > 30)) {
    			dateError += "Invalid day entered, for given month it should be between 1 and 30.";
    		    }
    		}
    	    }
            // CHECK IF YEAR IS VALID
            if ((Integer.parseInt(dateArr[2]) < 2018) || 
                (Integer.parseInt(dateArr[2]) > 2099)) {
        	dateError += "Invalid year entered, it should be between 2018 and 2099.";
            }
            if (dateError.isEmpty()) {
                validDate = true;
            }
        }
        if (validDate) {
            System.out.printf("Valid date entered:%s.\n", date);
        }
        else {
            System.out.printf("Invalid date entered:%s.\n", date);
            System.out.println("Date Error: " + dateError);
            numErrors++;
        }
		
		// NAME VALIDATION
		boolean validName = false;
        String nameError = "";
        
        int i;
        for (i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                if (i == 0) {
                    if (name.charAt(i) == ' ') {
                        nameError += "Name must not start with a space. ";
                    }
                   
                }
                else if (i == name.length() - 1) {
                    if (name.charAt(i) == ' ') {
                        nameError += "Name must not end with a space. ";
                    }
                }
                else {
                    if (name.charAt(i) == ' ') {
                        continue;
                    }
                    nameError += "Invalid characters present in the name. ";
                }
            }
        }
        if (nameError.isEmpty()) {
            validName = true;
        }
        if (validName) {
            System.out.printf("Valid name entered:%s.\n", name);
        }
        else {
            System.out.printf("Invalid name entered:%s.\n", name);
            System.out.println("Name Error: " + nameError);
            numErrors++;
        }
        
        // EMAIL VALIDATION
        boolean validEmail = false;
        String emailError = "";
        
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(email);
        if (match.find()) {
        	validEmail = true;
        }
        else {
        	emailError += "Invalid email entered, correct format: "
                    + "example_email99@service.tld ";
        }
        if (validEmail) {
        	System.out.printf("Valid email entered:%s\n",email);
        }
        else {
            System.out.printf("Invalid email entered: %s\nEmail Error: %s\n", email, emailError);
            numErrors++;
        }
		
		// PHONE VALIDATION
        boolean validPhone = false;
        String phoneError = "";
        
        int j;
        for (j = 0; j < phone.length(); j++) {
            if (!Character.isDigit(phone.charAt(i))) {
                if (j == 3 || j == 7) {
                    if (name.charAt(i) != '-') {
                        phoneError += "Missing phone number separator, '-'. ";
                    }
                   
                }
                else {
                    phoneError += "Non-digit characters present in number. ";
                }
            }
        }
        if (phoneError.isEmpty()) {
            validPhone = true;
        }
        if (validPhone) {
            System.out.printf("Valid phone number entered:%s.\n", phone);
        }
        else {
            System.out.printf("Invalid phone number entered:%s.\n", phone);
            System.out.println("Phone Error: " + phoneError);
            numErrors++;
        }
		
		DBHandler db = new DBHandler();
		Connection conn = db.getConnection();
		if (conn != null) {
			try {
				if (numErrors == 0) {
					System.out.println("No Errors Detected, preparing to add Quote.");
		        	Quote quote = new Quote(); // TODO pass vars above to new quote
		        	ArrayList<Quote> list;
		        	System.out.println("Initializing pricing module");	
		        	PriceModule pm = new PriceModule();
		        	try {
		        		HttpSession session = request.getSession();
		        		int id = (int) session.getAttribute("clientId");
		        	    //String id = request.getParameter("clientId").toString();
		        	    System.out.printf("Id is: %d\n", id);
		                quote.setClientId(id);
		                list = db.queryQuoteWithId(conn, id);
		                boolean historyExists = false;
		                if (!list.isEmpty()) {
		                	historyExists = true;
		                }
		                double suggestedPrice = pm.calculatePrice(state, historyExists, gallons);
		                double totalCost = gallons * suggestedPrice;
		                request.setAttribute("suggestedPrice", suggestedPrice);
		                request.setAttribute("totalCost", totalCost);
		                quote.setSuggestedPrice(suggestedPrice);
		                quote.setTotalAmountDue(totalCost);
		        	} catch (Exception e) {
		        		System.out.println("Unable to collect id");
		        		e.printStackTrace();
		        	}
		        	
		            quote.setGallonsRequested(gallons);
		            //Date delDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
		            System.out.printf("date: %s\n", date);
		            java.sql.Date dt = null;
		            try {
		            	String newDate = null;
		            	DateFormat userDateFormat = new SimpleDateFormat("MM-dd-yyyy");
		            	DateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-MM-dd");
		            	java.util.Date NewDate = userDateFormat.parse(date);
		            	String convertedDate = dateFormatNeeded.format(NewDate);
		            	System.out.println(convertedDate);
		            	
		            	java.sql.Date neededDate = java.sql.Date.valueOf(convertedDate);
		            	System.out.println(neededDate.toString());
		            	
		            	quote.setDeliveryDate(neededDate);
		            } catch (Exception e) {
		            	System.out.println("Unable to convert date");
		            	e.printStackTrace();
		            }
		      
		            //quote.setDeliveryDate(delDate);
		            quote.setDeliveryLocation(address);
		            quote.setCity(city);
		            quote.setState(state);
		            quote.setZip(zip);
		            quote.setDeliveryContactName(name);
		            quote.setDeliveryContactPhone(phone);
		            quote.setDeliveryContactEmail(email);
		            //quote.setSuggestedPrice(price);
		            //quote.setTotalAmountDue(cost);
		            db.queryAddNewQuote(conn, quote);
		        }
			} catch (Exception e) {
				System.out.println("Unable to add quote to DB");
				e.printStackTrace();
				
			}
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Unable to close connection");
			}
			//msg += " Closed connection successfully.";
		}
		else {
			System.out.println("Failure in connecting to the DB!");
		}
	    
		request.getRequestDispatcher("quoteForm.jsp").forward(request, response);
	}
}

