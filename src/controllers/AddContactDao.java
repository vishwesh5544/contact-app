package controllers;

import java.sql.*;

public class AddContactDao
{
	public String addContact(AddContactBean addconbean)
	{

		String contactName = addconbean.getContactName();
		String contactEmail = addconbean.getContactEmail();
		String contactPhone = addconbean.getContactPhone();
		String contactOf = addconbean.getContactOf();
		String isFavourite = addconbean.getIsFavourite();

		Connection con = null;
		PreparedStatement sql = null;

		try {

			con = DBConnection.createConnection();

			sql = con.prepareStatement(
					"INSERT INTO contacts(ContactName,ContactEmail,ContactPhone,ContactOf,IsFavourite) "
							+ "VALUES(?,?,?,?,?)");
			sql.setString(1, contactName);
			sql.setString(2, contactEmail);
			sql.setString(3, contactPhone);
			sql.setString(4, contactOf);
			sql.setString(5, isFavourite);

			int rs = sql.executeUpdate();

			if (rs == 1) {
				return "contact_added";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "failed";

	}

}
