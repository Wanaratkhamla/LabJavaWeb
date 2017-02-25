package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class productDB {
	private Connection con;
	public productDB() {
		con = ConnectDatabase.getConnection();
	}
	
	//insertProduct
	public void insertProductpawn(String ProductID, String ProductName,double ProductPrice,String ProductDescription)
	{
		try {
			PreparedStatement pStatement = con.prepareStatement(
					"INSERT INTO product (ProductID, ProductName, ProductPrice,ProductDescription) VALUES (?,?,?,?)");
			pStatement.setString(1, ProductID);
			pStatement.setString(2, ProductName);
			pStatement.setDouble(3, ProductPrice);
			pStatement.setString(4, ProductDescription);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	
	//selectProduct
	public product selectProduct(String ProductID) {
		product product = new product();
		String sql = "SELECT * FROM product WHERE ProductID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ProductID);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				product.setProductID(result.getString("ProductID"));
				product.setProductName(result.getString("ProductName"));
				product.setProductPrice(result.getDouble("ProductPrice"));
				product.setProductDescription(result.getString("ProductDescription"));
			}else{
				product.setProductID("0");
				product.setProductName("0");
				product.setProductPrice(0.0);
				product.setProductDescription("0");
			}
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return product;
	}
	
	//selectProduct
		public product selectProductByname(String ProductName) {
			product product = new product();
			String sql = "SELECT * FROM product WHERE ProductName=?";
			try {
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, ProductName);
				ResultSet result = statement.executeQuery();
				if (result.next()) {
					product.setProductID(result.getString("ProductID"));
					product.setProductName(result.getString("ProductName"));
					product.setProductPrice(result.getInt("ProductPrice"));
					product.setProductDescription(result.getString("ProductDescription"));
				}
			} catch (SQLException e) {
				System.err.println("Error Select data :" + e);
			}
			return product;
		}
}
