package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBHandler;
import system.Message;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
		System.out.println("Made it to servlet");
		String recipient=request.getParameter("recipient");
		System.out.println(recipient);
		String userMessage=request.getParameter("message");
		String senderID=request.getParameter("senderID");
		System.out.println(senderID);
		String userType = "";
		
		
		
		try {
    		Message message = new Message();
    		message.setMessage(userMessage);
    		message.setReviever(recipient);
    		message.setSenderID(senderID);
    		
    		DBHandler db = new DBHandler();
    		Connection conn = db.getConnection();
    		//DBHandler.queryAddNewClient(conn, client);
    		HttpSession session = request.getSession();
    		int id = (int) session.getAttribute("clientId");
    		System.out.println(id);
    		userType = DBHandler.queryForUserType(conn, id);
    		
    		System.out.println(userType);
    		String sql = String.format("Insert into FuelApp.messages (recipient, message, senderID) values ('%s','%s','%s');", message.getReciever(), message.getMessage(), message.getSender());
    		System.out.println(sql);
    		DBHandler.queryAddNewMessage(conn, sql);
    		
    		switch(userType) {
	    	case ("tenant"):
	    		request.setAttribute("clientId", id); 
	    		request.getRequestDispatcher("tenantHome.jsp").forward(request, response);
	    		break;
	    	case ("maintenance"):
	    		request.setAttribute("clientId", id); 
	    		request.getRequestDispatcher("maintenanceHome.jsp").forward(request, response);
	    		break;
	    	case ("broker"):
	    		request.setAttribute("clientId", id); 
	    		request.getRequestDispatcher("broker.jsp").forward(request, response);
	    		break;
	    	case ("owner"):
	    		request.setAttribute("clientId", id); 
    			request.getRequestDispatcher("owner.jsp").forward(request, response);
    			break;
	    	}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("Error adding message to DB");
    	}	
	}
}
