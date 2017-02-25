package model;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDB {
	private Connection con;

	public CartDB() {
		con = ConnectDatabase.getConnection();
	}

	// InsertCart
	public void InsertCart(String Username) {
		String insertSql = "INSERT INTO cart ( Username, CartOrderdate, CartTotalProduct, CartPaydate, CartStatus, CartTotalPrice) VALUES (?,NOW(),0,NULL,0,0)";
		try {
			PreparedStatement pStatement = con.prepareStatement(insertSql);
			pStatement.setString(1, Username);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}

	// updatestatus and paydate
	public void Updatepayandstatus(int CartID) {
		String sql = "UPDATE cart SET  CartPaydate=NOW() , CartStatus=1 WHERE CartID=? ";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, CartID);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}

	// viewstatus
	public ArrayList<Cart> Viewstatus() {
		ArrayList<Cart> Cartlist = new ArrayList<Cart>();
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM cart");
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				int CartID = resultSet.getInt("CartID");
				String Username = resultSet.getString("Username");
				String CartOrderdate = resultSet.getString("CartOrderdate");
				int CartTotalProduct = resultSet.getInt("CartTotalProduct");
				String CartPaydate = resultSet.getString("CartPaydate");
				int CartStatus = resultSet.getInt("CartStatus");
				double CartTotalPrice = resultSet.getDouble("CartTotalPrice");

				Cart cart = new Cart();
				cart.setCartID(CartID);
				cart.setUsername(Username);
				cart.setCartOrderdate(CartOrderdate);
				cart.setCartTotalProduct(CartTotalProduct);
				cart.setCartPaydate(CartPaydate);
				cart.setCartStatus(CartStatus);
				cart.setCartTotalPrice(CartTotalPrice);
				Cartlist.add(cart);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return Cartlist;
	}

	// removeCart
	public void DeleteCart(int CartID) {
		OrderDB orderDB = new OrderDB();
		orderDB.DeleteOrderByCartID(CartID);
		String sql = "DELETE FROM cart Where CartID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, CartID);
			statement.executeUpdate();
			// con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}

	}

	// viewall ที่เป็นของ admin
	public ArrayList<Cart> ViewAllCart() {
		ArrayList<Cart> Cartlist = new ArrayList<Cart>();
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM cart");
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				int CartID = resultSet.getInt("CartID");
				String Username = resultSet.getString("Username");
				String CartOrderdate = resultSet.getString("CartOrderdate");
				int CartTotalProduct = resultSet.getInt("CartTotalProduct");
				String CartPaydate = resultSet.getString("CartPaydate");
				int CartStatus = resultSet.getInt("CartStatus");
				double CartTotalPrice = resultSet.getDouble("CartTotalPrice");

				Cart cart = new Cart();
				cart.setCartID(CartID);
				cart.setUsername(Username);
				cart.setCartOrderdate(CartOrderdate);
				cart.setCartTotalProduct(CartTotalProduct);
				cart.setCartPaydate(CartPaydate);
				cart.setCartStatus(CartStatus);
				cart.setCartTotalPrice(CartTotalPrice);
				Cartlist.add(cart);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return Cartlist;
	}

	// View All Cart ของ User
	public ArrayList<Cart> ViewAllCartuser(String Username) {
		ArrayList<Cart> Cartlist = new ArrayList<Cart>();
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM cart WHERE Username=?");
			pStatement.setString(1, Username);
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				int CartID = resultSet.getInt("CartID");
				String username = resultSet.getString("Username");
				String CartOrderdate = resultSet.getString("CartOrderdate");
				int CartTotalProduct = resultSet.getInt("CartTotalProduct");
				String CartPaydate = resultSet.getString("CartPaydate");
				int CartStatus = resultSet.getInt("CartStatus");
				double CartTotalPrice = resultSet.getDouble("CartTotalPrice");

				Cart cart = new Cart();
				cart.setCartID(CartID);
				cart.setUsername(username);
				cart.setCartOrderdate(CartOrderdate);
				cart.setCartTotalProduct(CartTotalProduct);
				cart.setCartPaydate(CartPaydate);
				cart.setCartStatus(CartStatus);
				cart.setCartTotalPrice(CartTotalPrice);
				Cartlist.add(cart);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return Cartlist;
	}

	// เช็คค่าล่าสุดที่ยังไม่จ่ายตัง
	public Cart CartnoPay(String Username) {
		Cart cart = new Cart();
		String sql = "SELECT * FROM cart WHERE Username=? AND CartStatus=0";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				cart.setCartID(result.getInt("CartID"));
				cart.setUsername(result.getString("Username"));
				cart.setCartOrderdate(result.getString("CartOrderDate"));
				cart.setCartTotalProduct(result.getInt("CartTotalProduct"));
				cart.setCartPaydate(result.getString("CartPaydate"));
				cart.setCartStatus(result.getInt("CartStatus"));
				cart.setCartTotalPrice(result.getDouble("CartTotalPrice"));
			} else {
				cart.setCartID(0);
				cart.setUsername("0");
				cart.setCartOrderdate("0");
				cart.setCartTotalProduct(0);
				cart.setCartPaydate("0");
				cart.setCartStatus(0);
				cart.setCartTotalPrice(0);
			}
			// con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return cart;
	}

	// อัพเดต ราคา และ จำนวนสินค้าใน cart
	public void UpdatePriceAndtotalinCart(int CartID, int CartTotalProduct, double CartTotalPrice) {
		String sql = "UPDATE cart SET  CartTotalProduct=? , CartTotalPrice=? WHERE CartID=? ";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, CartTotalProduct);
			statement.setDouble(2, CartTotalPrice);
			statement.setInt(3, CartID);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}
}
