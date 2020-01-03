package controllers;

import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginDao
{
	public LoginDao(HttpServletRequest req) {
		super();

	}

	public String validate(LoginBean loginBean, HttpServletRequest req)
	{
		String email = loginBean.getEmail();
		String password = loginBean.getPassword();

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		HttpSession session = req.getSession();

		try {

			con = DBConnection.createConnection();
			statement = con.prepareStatement("SELECT * FROM users WHERE email = ? AND pwd = ?");
			statement.setString(1, email);
			statement.setString(2, password);
			rs = statement.executeQuery();

			while (rs.next()) {

				session.setAttribute("firstname", rs.getString("firstname"));
				session.setAttribute("lastname", rs.getString("lastname"));
				session.setAttribute("email", rs.getString("email"));
				session.setAttribute("password", rs.getString("pwd"));
				session.setAttribute("userid", rs.getString("UserID"));

				if (email.equals(rs.getString("email")) && password.equals(rs.getString("pwd"))) {
					return "valid_user";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Invalid User";

	}

}
