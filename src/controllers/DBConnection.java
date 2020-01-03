package controllers;

import java.sql.*;

public class DBConnection
{

	public static Connection createConnection() throws SQLException
	{

		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/contactsapp";
		String username = "root";
		String password = "root";

		try {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			con = DriverManager.getConnection(url, username, password);

			System.out.println("Post establishing a DB Connection - " + con);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
