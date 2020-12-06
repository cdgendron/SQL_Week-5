package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private final static String URL ="jdbc:mysql://localhost:3306/trees";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "sL@5x88yR";
	private static Connection con; 
	private static DBConnection insta; 
	
	private DBConnection (Connection con) {
		this.con = con;
	}

	public static Connection getCon() {
		if(insta == null) {
			try {
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				insta = new DBConnection(con); 
				System.out.println("Connection Successful!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return DBConnection.con; 
	}
	
}
