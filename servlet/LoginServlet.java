package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBHandler;
import system.Client;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private String name;
	private String email;
	private String URL;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		this.name=request.getParameter("name");
		this.email=request.getParameter("email");
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
		
	
	    if (numErrors == 0) {
    	    try {
    		    DBHandler db = new DBHandler();
    		    Connection conn = db.getConnection();
    		    int clientId = DBHandler.queryForUser(conn, name, email);
    		    String clientType = DBHandler.queryForUserType(conn, clientId);
    		    
    		    
    		    
    		    if (clientId != -1) {
    		    	switch(clientType) {
    		    	case ("tenant"):
    		    		request.setAttribute("clientId", clientId); 
    		    		request.getRequestDispatcher("tenantHome.jsp").forward(request, response);
    		    		break;
    		    	case ("maintenance"):
    		    		request.setAttribute("clientId", clientId); 
    		    		request.getRequestDispatcher("maintenanceHome.jsp").forward(request, response);
    		    		break;
    		    	case ("broker"):
    		    		request.setAttribute("clientId", clientId); 
    		    		request.getRequestDispatcher("broker.jsp").forward(request, response);
    		    		break;
    		    	case ("owner"):
    		    		request.setAttribute("clientId", clientId); 
		    			request.getRequestDispatcher("owner.jsp").forward(request, response);
		    			break;
    		    	}
    		    		
    		    }
    		    else {
    		    	request.setAttribute("errorMessage", "Invalid user or password");
                    request.getRequestDispatcher("signIn.jsp").forward(request, response);
    		    }
    	    } catch (Exception e) {
    		    e.printStackTrace();
    		    System.out.println("Error adding client to DB");
    	    }
        }
	}
}
