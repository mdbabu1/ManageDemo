package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBHandler;
import system.Client;
import system.Quote;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String email=request.getParameter("email");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip");
		String phone=request.getParameter("phone");
		String userType=request.getParameter("userType");
		int numErrors = 0;
		
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
     /*   
     // PHONE VALIDATION
        boolean validPhone = false;
        String phoneError = "";
        
        int j;
        for (j = 0; j < phone.length(); j++) {
            if (!Character.isDigit(phone.charAt(j))) {
                if (j == 3 || j == 7) {
                    if (phone.charAt(j) != '-') {
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
		*/
        if (numErrors == 0) {
        	try {
        		System.out.printf("Zip: %s\n", zip);
        		System.out.printf("State: %s\n", state);
        		Client client = new Client();
        		client.setName(name);
        		client.setAddress(address);
        		client.setCity(city);
        		client.setState(state);
        		client.setZip(zip);
        		client.setEmail(email);
        		client.setPhone(phone);
        		client.setUserType(userType);
        		
        		DBHandler db = new DBHandler();
        		Connection conn = db.getConnection();
        		//DBHandler.queryAddNewClient(conn, client);
        		String sql = String.format("Insert into FuelApp.clientInformation (fullName, address, city, state, zipCode, phone, email, userType) values ('%s','%s','%s','%s','%s','%s','%s','%s');", client.getName(), client.getAddress(), client.getCity(), client.getState(), client.getZip(), client.getPhone(), client.getEmail(), client.getUserType());
        		System.out.println(sql);
        		DBHandler.queryAddNewClient(conn, sql);
        		
        	} catch (Exception e) {
        		e.printStackTrace();
        		System.out.println("Error adding client to DB");
        	}
        }
        request.getRequestDispatcher("signIn.jsp").forward(request, response);
	}
}
