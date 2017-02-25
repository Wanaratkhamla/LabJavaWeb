package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDB {
	private Connection con;

	public UserDB() {
		con = ConnectDatabase.getConnection();
	}

	// InsertUsername
	public void InsertUser(String Username, String Password, String Name, String Type, String IDCard, String EMail,
			String Address, String PhoneNO) {
		try {
			PreparedStatement pStatement = con.prepareStatement(
					"INSERT INTO users ( Username, Password, Name, Type, IDCard, EMail, Address, PhoneNO) VALUES (?,?,?,?,?,?,?,?)");
			pStatement.setString(1, Username);
			pStatement.setString(2, Password);
			pStatement.setString(3, Name);
			pStatement.setString(4, Type);
			pStatement.setString(5, IDCard);
			pStatement.setString(6, EMail);
			pStatement.setString(7, Address);
			pStatement.setString(8, PhoneNO);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}

	// โชว์ User ทั้งหมดที่มี
	public ArrayList<User> ViewAll() {
		ArrayList<User> userlist = new ArrayList<User>();
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM users");
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				String username = resultSet.getString("Username");
				String password = resultSet.getString("Password");
				String name = resultSet.getString("Name");
				String idcard = resultSet.getString("IDCard");
				String type = resultSet.getString("Type");
				String email = resultSet.getString("Email");
				String address = resultSet.getString("Address");
				String phoneno = resultSet.getString("PhoneNO");

				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setName(name);
				user.setID_Card(idcard);
				user.setType(type);
				user.setEMail(email);
				user.setAddress(address);
				user.setPhoneNO(phoneno);
				userlist.add(user);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return userlist;
	}

	// Show โปรไฟล์ ของ User นั้นๆ
	public User viewUser(String Username) {
		User user = new User();
		String sql = "SELECT * FROM users WHERE Username=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				user.setUsername(result.getString("Username"));
				user.setPassword(result.getString("Password"));
				user.setName(result.getString("Name"));
				user.setID_Card(result.getString("IDCard"));
				user.setType(result.getString("Type"));
				user.setEMail(result.getString("Email"));
				user.setAddress(result.getString("Address"));
				user.setPhoneNO(result.getString("PhoneNO"));
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return user;
	}

	// ลบ User สำหรับ admin
	public void DeleteUser(String Username) {
		String sql = "DELETE FROM users Where Username=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Username);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}

	// updateUser
	public void updateUser(String Password, String Name, String IDCard, String Type, String Email, String Address,
			String PhoneNO, String Username) {
		String sql = "UPDATE users SET  Password=?,Name=?,IDCard=?,Type=?,Email=?,Address=?,PhoneNO=? WHERE Username=? ";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Password);
			statement.setString(2, Name);
			statement.setString(3, IDCard);
			statement.setString(4, Type);
			statement.setString(5, Email);
			statement.setString(6, Address);
			statement.setString(7, PhoneNO);
			statement.setString(8, Username);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}

	// loginuser
	public User loginusers(String Username) {
		User user = new User();
		String sql = "SELECT * FROM users WHERE Username=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				user.setCheck(true);
				user.setUsername(result.getString("Username"));
				user.setPassword(result.getString("Password"));
				user.setName(result.getString("Name"));
				user.setID_Card(result.getString("IDCard"));
				user.setType(result.getString("Type"));
				user.setEMail(result.getString("Email"));
				user.setAddress(result.getString("Address"));
				user.setPhoneNO(result.getString("PhoneNO"));
			}else {
				user.setCheck(false);
				}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return user;
	}
}
