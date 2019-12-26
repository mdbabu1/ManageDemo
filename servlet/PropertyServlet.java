package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBHandler;
import system.Property;
/**
 * Servlet implementation class PropertyServlet
 */
@WebServlet("/PropertyServlet")
public class PropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyServlet() {
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
		String buildDate=request.getParameter("buildDate");
		String address=request.getParameter("address");
		Property property = new Property();
		property.setAddress(address);
		property.setBuildDate(buildDate);
		
		DBHandler db = new DBHandler();
		Connection conn = db.getConnection();
		
		String sql = String.format("Insert into FuelApp.property (address, buildDate) values ('%s','%s');", property.getAddress(), property.getDate());
		System.out.println(sql);
		DBHandler.queryAddNewProperty(conn, sql);
		
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("clientId");
		request.setAttribute("clientId", id); 
		request.getRequestDispatcher("owner.jsp").forward(request, response);
	}
	

}
