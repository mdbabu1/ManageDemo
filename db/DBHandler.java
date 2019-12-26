package db;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import system.Client;
import system.Message;
import system.Quote;
import system.Lease;

public class DBHandler {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/FuelApp?allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "password");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	// Method to execute a query where results are needed (i.e. select query)
	public ResultSet executeQueryWithResults(String query) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "password");
		if (conn != null) {
			System.out.println("Connection successfull");
		}
		try {
			Statement statement = conn.createStatement();
			try {
			    ResultSet result = statement.executeQuery(query);
			    if (result != null) {
			    	System.out.println("Grabbed from db successfully");
			    }
			    return result;
			} finally {
				statement.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//Method to execute a query where no results are needed (i.e. insert query)
	public void executeQuery(String query) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "password");
		try {
		    Statement statement = conn.createStatement();
		    try {
		        statement.executeQuery(query);
		    } finally {
		        statement.close();
		    }
		} finally {
		    if (conn != null)
		    	conn.close();
		}
	}
	
	/*
	 * Returns clientId if name and email entered already exist in the DB.
	 * Returns -1 if name and email were not found.
	 */
	public static int queryForUser(Connection conn, String name, String email) throws SQLException{
		String sql = String.format("Select clientId from FuelApp.clientInformation where fullName='%s' and email='%s';", name, email);
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		
		if (rs.next()) {
			return rs.getInt("clientId");
		}
		return -1;
	}
	/*
	 * Returns client type if name and email entered already exist in the DB.
	 * Returns "" if name and email were not found.
	 */
	public static String queryForUserType(Connection conn, int clientId) throws SQLException{
		String sql = String.format("select * from FuelApp.clientInformation where clientId='%d'", clientId);
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			return rs.getString(9);
		}
		else {
			return "";
		}
		
		
	}
	
	/*
	 * Returns a String email address of the person receiving the email
	 * 
	 */
	public static String queryForMessageReciever(Connection conn, int clientId) throws SQLException{
		String sql = String.format("select * from FuelApp.clientInformation where clientId='%d'", clientId);
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			return rs.getString(8);
		}
		else {
			return "";
		}
		
		
	}
	
	/*
	 * Takes strings for updated client info and updates corresponding information
	 */
	public static void queryUpdateClientInfo(Connection conn, int id, String name, String email, String address, String phone) throws SQLException {
		String sql = String.format("Update FuelApp.clientInformation set fullName='%s', address='%s', phone='%s', email='%s' where clientId='%d'", name, address, phone, email, id);
		try {
		    PreparedStatement pstm = conn.prepareStatement(sql);
		    pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Adds new client to the DB
	 */
	public static void queryAddNewClient(Connection conn, String sql) {
		System.out.println("Made it to query");
		System.out.print(sql);
		try {
		    PreparedStatement pstm = conn.prepareStatement(sql);
		    pstm.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Adds new property to the DB
	 */
	public static void queryAddNewProperty(Connection conn, String sql) {
		System.out.println("Made it to query");
		System.out.print(sql);
		try {
		    PreparedStatement pstm = conn.prepareStatement(sql);
		    pstm.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Adds new message to the DB
	 */
	public static void queryAddNewMessage(Connection conn, String sql) {
		System.out.println("Made it to query");
		System.out.print(sql);
		try {
		    PreparedStatement pstm = conn.prepareStatement(sql);
		    pstm.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Adds new Quote to the DB
	 */
	public static void queryAddNewQuote(Connection conn, Quote quote) throws SQLException {
		System.out.println("In query");
		String sql = String.format("INSERT INTO FuelApp.fuelQuote (clientId, gallonsRequested, requestDate, deliveryDate, deliveryAddress, deliveryCity, deliveryState, deliveryZipCode, deliveryContactName, deliveryContactPhone, deliveryContactEmail, suggestedPrice, totalAmountDue)\n" + 
				"VALUES (%d, %f, CURDATE(), '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %f, %f);", quote.getClientId(), quote.getGallonsRequested(), quote.getDeliveryDate().toString(), quote.getDeliveryLocation(), 
				quote.getCity(), quote.getState(), quote.getZip(), quote.getDeliveryContactName(), quote.getDeliveryContactPhone(), quote.getDeliveryContactEmail(),
				quote.getSuggestedPrice(), quote.getTotalAmountDue());
		
		try {
		    PreparedStatement pstm = conn.prepareStatement(sql);
		    pstm.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Quote> queryQuoteWithId(Connection conn, int clientId) throws SQLException{
		String sql = String.format("select * from FuelApp.fuelQuote where clientId='%d'", clientId);
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		 
        ResultSet rs = pstm.executeQuery();
        ArrayList<Quote> list = new ArrayList<Quote>();
        while (rs.next()) {
            int id = rs.getInt("quoteId");
            Date request = rs.getDate("requestDate");
            Date delivery = rs.getDate("deliveryDate");
            double gallons = rs.getDouble("gallonsRequested");
            float price = rs.getFloat("suggestedPrice");
            float total = rs.getFloat("totalAmountDue");
            Quote quote = new Quote();
            quote.setClientId(id);
            quote.setRequestDate(request);
            quote.setDeliveryDate(delivery);
            quote.setGallonsRequested(gallons);
            quote.setSuggestedPrice(price);
            quote.setTotalAmountDue(total);
          
            list.add(quote);
        }
        return list;
	}
	//For getting all messages with certain user ID
	public static ArrayList<Message> queryMessageWithId(Connection conn, int clientId) throws SQLException{
		String recipient = queryForMessageReciever(conn, clientId);
		System.out.println(recipient);
		String sql = String.format("select * from FuelApp.messages where recipient='%s'", recipient);
	
		PreparedStatement pstm = conn.prepareStatement(sql);
		 
        ResultSet rs = pstm.executeQuery();
        ArrayList<Message> list = new ArrayList<Message>();
        while (rs.next()) {
            String sentMessage = rs.getString("message");
            String senderID = rs.getString("senderID");
           
            Message message = new Message();
            message.setReviever(recipient);
            message.setMessage(sentMessage);
            message.setSenderID(senderID);
          
            list.add(message);
        }
        return list;
	}
	
	public static Client queryClientWithId(Connection conn, int clientId) throws SQLException{
		String sql = String.format("select * from FuelApp.clientInformation where clientId = '%d';", clientId);
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		 
        ResultSet rs = pstm.executeQuery();
        
        Client client = new Client();
        
        if (rs.next()) {
        	int id = rs.getInt("clientId");
        	String name = rs.getString("fullName");
        	String address = rs.getString("address");
        	String phone = rs.getString("phone");
        	String email = rs.getString("email");
        	String userType = rs.getString("userType");
        	client.setClientId(id);
        	client.setName(name);
        	client.setAddress(address);
        	client.setPhone(phone);
        	client.setEmail(email);
        	client.setUserType(userType);
        }
        return client;
	}
	//Returns lease with client Id
	public static Lease queryLeaseWithClientId(Connection conn, int clientId) throws SQLException{
		String sql = String.format("select * from FuelApp.lease where tenantId = '%d';", clientId);
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		 
        ResultSet rs = pstm.executeQuery();
        
        Lease lease = new Lease();
        
        if (rs.next()) {
        	int tenantId = rs.getInt("tenantId");
        	int landLordId = rs.getInt("landLordId");
        	String address = rs.getString("address");
        	String leaseStart = rs.getString("leaseStart");
        	String leaseEnd= rs.getString("leaseEnd");
        	double rentPrice = rs.getDouble("rentPrice");
        	lease.setTenant(tenantId);
        	lease.setLandLord(landLordId);
        	lease.setAddress(address);
        	lease.setLeaseStart(leaseStart);
        	lease.setLeaseEnd(leaseEnd);
        	lease.setRentPrice(rentPrice);
        }
        return lease;
	}

}
