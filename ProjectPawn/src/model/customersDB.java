package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class customersDB {
	
	private Connection con;

	public customersDB() {
		con = ConnectDatabase.getConnection();
	}
	
	//insertCustomersDB
	public void insertCustomers (String CustomersID,String Name,String Address,String PhoneNO)
	{
		try {
			PreparedStatement pStatement = con.prepareStatement(
					"INSERT INTO customers (CustomersID, Name, Address, PhoneNO) VALUES (?,?,?,?)");
			pStatement.setString(1, CustomersID);
			pStatement.setString(2, Name);
			pStatement.setString(3, Address);
			pStatement.setString(4, PhoneNO);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	
	//SelectUser
	public customers viewUser(String CustomersID) {
		customers customers = new customers();
		String sql = "SELECT * FROM customers WHERE CustomersID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, CustomersID);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				customers.setCustomersID(result.getString("CustomersID"));
				customers.setName(result.getString("Name"));
				customers.setAddress(result.getString("Address"));
				customers.setPhoneNo(result.getString("PhoneNO"));
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return customers;
	}
	
	// เช็คว่ามี User หรือไม่
		public customers CheckUser(String CustomersID) {
			customers customers = new customers();
			String sql = "SELECT * FROM customers WHERE CustomersID=?";
			try {
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, CustomersID);
				ResultSet result = statement.executeQuery();
				if (result.next()) {
					customers.setCustomersID(result.getString("CustomersID"));
					customers.setName(result.getString("Name"));
					customers.setAddress(result.getString("Address"));
					customers.setPhoneNo(result.getString("PhoneNO"));
				} else {
					customers.setCustomersID("0");
					customers.setName("0");
					customers.setAddress("0");
					customers.setPhoneNo("0");
				}
				// con.close();
			} catch (SQLException e) {
				System.err.println("Error Select data :" + e);
			}
			return customers;
		}
}
