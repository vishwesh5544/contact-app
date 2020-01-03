package controllers;

import java.sql.*;

public class FavDao {

	public String fav(FavBean favBean) {

		String contactid = favBean.getContactid();
		String userid = favBean.getUserid();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBConnection.createConnection();
			pstmt = con.prepareStatement(
					"UPDATE contacts SET IsFavourite = '1' WHERE ContactID = ? AND ContactOf = ? AND IsFavourite = 0");
			pstmt.setString(1, contactid);
			pstmt.setString(2, userid);

			int rs = pstmt.executeUpdate();

			if (rs == 1) {
				return "success";
			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

		return "failed";

	}
}
