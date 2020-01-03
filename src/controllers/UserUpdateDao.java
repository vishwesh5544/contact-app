package controllers;

import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUpdateDao
{
	Connection con = null;
	PreparedStatement pstmt = null;
	HttpSession session;

	public UserUpdateDao(HttpServletRequest req) {
		super();
		session = req.getSession();
	}

	public String updateFirstname(UserUpdateBean userUpdateBean)
	{

		try {

			con = DBConnection.createConnection();
			pstmt = con.prepareStatement("UPDATE users SET firstname = ? WHERE UserID = ? AND email = ?");

			pstmt.setString(1, userUpdateBean.getFirstname());
			pstmt.setString(2, userUpdateBean.getUserid());
			pstmt.setString(3, userUpdateBean.getUserEmail());

			int rs = pstmt.executeUpdate();

			if (rs == 1) {
				session.setAttribute("firstname", userUpdateBean.getFirstname());
				return "success";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "failed";
	}

	public String updateLastname(UserUpdateBean userUpdateBean)
	{
		try {
			con = DBConnection.createConnection();
			pstmt = con.prepareStatement("UPDATE users SET lastname = ? WHERE UserID = ? AND email = ?");

			pstmt.setString(1, userUpdateBean.getLastname());
			pstmt.setString(2, userUpdateBean.getUserid());
			pstmt.setString(3, userUpdateBean.getUserEmail());

			int rs = pstmt.executeUpdate();

			if (rs == 1) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failed";
	}

	public String updateEmail(UserUpdateBean userUpdateBean)
	{
		try {
			con = DBConnection.createConnection();
			pstmt = con.prepareStatement("UPDATE users SET email = ? WHERE UserID = ? AND email = ?");

			pstmt.setString(1, userUpdateBean.getEmail());
			pstmt.setString(2, userUpdateBean.getUserid());
			pstmt.setString(3, userUpdateBean.getUserEmail());

			int rs = pstmt.executeUpdate();

			if (rs == 1) {
				session.setAttribute("email", userUpdateBean.getEmail());
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "failed";
	}

	public String updatePassword(UserUpdateBean userUpdateBean)
	{
		try {
			con = DBConnection.createConnection();
			pstmt = con.prepareStatement("UPDATE users SET pwd = ? WHERE UserID = ? AND email = ?");

			pstmt.setString(1, userUpdateBean.getPassword());
			pstmt.setString(2, userUpdateBean.getUserid());
			pstmt.setString(3, userUpdateBean.getUserEmail());

			int rs = pstmt.executeUpdate();

			if (rs == 1) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "failed";
	}

}
