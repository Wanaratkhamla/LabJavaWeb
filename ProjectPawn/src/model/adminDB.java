package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class adminDB {
	private Connection con;

	public adminDB() {
		con = ConnectDatabase.getConnection();
	}
	
	// loginuser
		public admin adminlogin(String Username) {
			admin admin = new admin();
			String sql = "SELECT * FROM admin WHERE Username=?";
			try {
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, Username);
				ResultSet result = statement.executeQuery();
				if (result.next()) {
					admin.setCheck(true);
					admin.setUsername(result.getString("Username"));
					admin.setPassword(result.getString("Password"));
					admin.setName(result.getString("Name"));
					admin.setIDCard(result.getString("IDCard"));
					admin.setAddress(result.getString("Address"));
					admin.setPhoneNO(result.getString("PhoneNO"));
				}else {
					admin.setCheck(false);
					}
			} catch (SQLException e) {
				System.err.println("Error Select data :" + e);
			}
			return admin;
		}
}
