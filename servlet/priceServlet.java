package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBHandler;
import system.PriceModule;
import system.Quote;

/**
 * Servlet implementation class priceServlet
 */
@WebServlet("/priceServlet")
public class priceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public priceServlet() {
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
		DBHandler db = new DBHandler();
		Connection conn = db.getConnection();
		if (conn != null) {
			Double gallons = Double.parseDouble(request.getParameter("gallons"));
			String state = request.getParameter("state");
			System.out.println("No Errors Detected, preparing to add Quote.");
		    Quote quote = new Quote(); // TODO pass vars above to new quote
		    ArrayList<Quote> list;
		    System.out.println("Initializing pricing module");	
		    PriceModule pm = new PriceModule();
		    try {
		       	HttpSession session = request.getSession();
		       	int id = (int) session.getAttribute("clientId");
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
		}
	}
}
