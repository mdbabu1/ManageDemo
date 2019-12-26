package system;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formServlet
 */
@WebServlet(description = "Handles form input from user.", urlPatterns = { "/form" })
public class formServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	    Quote quote = new Quote();
	    
	    // Handle Date
	    Date requestDate = null;
	    Date deliveryDate = null;
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	    String rDate = request.getParameter("");
	    String dDate = request.getParameter("date");
	    try {
			requestDate = formatter.parse(rDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			deliveryDate = formatter.parse(dDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //Handle integers and floats
	    int clientId = 1;  // TODO don't hardcode this!
	    double gallonsRequested = Float.parseFloat(request.getParameter("gallons"));
	    double suggestedPrice = Float.parseFloat(request.getParameter("price"));
	    double totalCost = Float.parseFloat(request.getParameter("cost"));
	    
	    quote.setClientId(clientId);
	    quote.setDeliveryContactEmail(request.getParameter("email"));
	    quote.setDeliveryContactName(request.getParameter("name"));
	    quote.setDeliveryContactPhone(request.getParameter("phone"));
	    quote.setDeliveryDate(deliveryDate);
	    quote.setDeliveryLocation(request.getParameter("location"));
	    quote.setGallonsRequested(gallonsRequested);
	    quote.setRequestDate(requestDate);
	    quote.setSuggestedPrice(suggestedPrice);
	    quote.setTotalAmountDue(totalCost);
	    
	    request.getRequestDispatcher("/WEB-INF/views/quoteForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// When the user enters info. for quote, and click Submit.
	// This method will be executed.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
	    Quote quote = new Quote();
	    
	    // Handle Date
	    Date requestDate = null, deliveryDate = null;
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	    String rDate = request.getParameter("");
	    String dDate = request.getParameter("date");
	    try {
			requestDate = formatter.parse(rDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			deliveryDate = formatter.parse(dDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //Handle integers and floats
	    int clientId = 1;  // TODO don't hardcode this!
	    double gallonsRequested = Float.parseFloat(request.getParameter("gallons"));
	    double suggestedPrice = Float.parseFloat(request.getParameter("price"));
	    double totalCost = Float.parseFloat(request.getParameter("cost"));
	    
	    quote.setClientId(clientId);
	    quote.setDeliveryContactEmail(request.getParameter("email"));
	    quote.setDeliveryContactName(request.getParameter("name"));
	    quote.setDeliveryContactPhone(request.getParameter("phone"));
	    quote.setDeliveryDate(deliveryDate);
	    quote.setDeliveryLocation(request.getParameter("location"));
	    quote.setGallonsRequested(gallonsRequested);
	    quote.setRequestDate(requestDate);
	    quote.setSuggestedPrice(suggestedPrice);
	    quote.setTotalAmountDue(totalCost);
   
	    request.setAttribute("quote", quote);
	    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/quoteForm.jsp");
	    dispatcher.forward(request, response);
	}

}
