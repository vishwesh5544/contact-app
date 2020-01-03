package controllers;

import java.sql.*;

public class NotFavDao {

	public String notFav(NotFavBean notFavBean) {

		String contactid = notFavBean.getContactid();
		String userid = notFavBean.getUserid();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBConnection.createConnection();

			pstmt = con.prepareStatement(
					"UPDATE contacts SET IsFavourite = '0' WHERE ContactID = ? AND ContactOf = ? AND IsFavourite = 1");
			pstmt.setString(1, contactid);
			pstmt.setString(2, userid);

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
