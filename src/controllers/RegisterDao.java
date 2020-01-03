package controllers;

import java.sql.*;

public class RegisterDao
{
	public String register(RegisterBean registerbean)
	{

		String firstname = registerbean.getFirstname();
		String lastname = registerbean.getLastname();
		String email = registerbean.getEmail();
		String password = registerbean.getPassword();

		Connection con = null;
		PreparedStatement sql = null;

		try {

			con = DBConnection.createConnection();
			sql = con.prepareStatement("INSERT INTO users(firstname,lastname,email,pwd) VALUES(?,?,?,?)");
			sql.setString(1, firstname);
			sql.setString(2, lastname);
			sql.setString(3, email);
			sql.setString(4, password);

			int rs = sql.executeUpdate();

			if (rs == 1) {
				return "register_successful";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "register_failed";

	}

}
