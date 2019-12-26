package db;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// Get connection to db
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "password");
			// Create a statement
			Statement statement = conn.createStatement();
			// Execute sql query
			ResultSet result = statement.executeQuery("select * from ...");
			// Process the result set
			while (result.next()) {
				System.out.println(result.getString("name"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
