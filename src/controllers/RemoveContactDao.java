package controllers;

import java.sql.*;

public class RemoveContactDao
{

	public String removeContact(RemoveContactBean removeContactBean)
	{

		String contactid = removeContactBean.getContactid();
		String userid = removeContactBean.getUserid();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBConnection.createConnection();

			pstmt = con.prepareStatement("DELETE FROM contacts WHERE ContactID = ? AND ContactOf = ?");
			pstmt.setString(1, contactid);
			pstmt.setString(2, userid);

			int rs = pstmt.executeUpdate();

			if (rs == 1) {
				return "success";
			}

		} catch (Exception e) {

		}

		return "failed";

	}
}
