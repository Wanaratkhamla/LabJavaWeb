package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDB {
	private Connection con;

	public OrderDB() {
		con = ConnectDatabase.getConnection();
	}

	// InsertProduct
	public void InsertProductinorder(int CartID, int ProductID, double OrderTotalPrice, int OrderTotalproduct) {
		String sql = "INSERT INTO orders SET  CartID=?,ProductID=?, OrderTotalPrice=?,OrderTotalproduct=? ";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, CartID);
			statement.setInt(2, ProductID);
			statement.setDouble(3, OrderTotalPrice);
			statement.setInt(4, OrderTotalproduct);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}

	// ViewProduct
	public Order SelectOrder(int ProductID, int CartID) {
		Order order = new Order();
		String sql = "SELECT * FROM orders WHERE ProductID = ? AND CartID  = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, ProductID);
			statement.setInt(2, CartID);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				order.setOrderID(result.getInt("OrderID"));
				order.setCartID(result.getInt("CartID"));
				order.setProductID(result.getInt("ProductID"));
				order.setOrderTotalPrice(result.getDouble("OrderTotalPrice"));
				order.setOrderTotalproduct(result.getInt("OrderTotalproduct"));
			}
			// con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return order;
	}

	// updateProduct And price
	public void updateProduct(int OrderID, int OrderTotalproduct, double OrderTotalPrice) {
		String sql = "UPDATE orders SET OrderTotalproduct=?, OrderTotalPrice=? WHERE OrderID=? ";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, OrderTotalproduct);
			statement.setDouble(2, OrderTotalPrice);
			statement.setInt(3, OrderID);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}

	// removeProductinorder
	public void DeleteOrders(int OrderID) {
		String sql = "DELETE FROM orders Where OrderID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, OrderID);
			statement.executeUpdate();
			// con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}

	}

	// ViewAll admin
	public ArrayList<Order> ViewAll() {
		ArrayList<Order> orderlist = new ArrayList<Order>();
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM orders");
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				int OrderID = resultSet.getInt("OrderID");
				int CartID = resultSet.getInt("CartID");
				int ProductID = resultSet.getInt("ProductID");
				int OrderTotalproduct = resultSet.getInt("OrderTotalproduct");

				Order order = new Order();
				order.setOrderID(OrderID);
				order.setCartID(CartID);
				order.setProductID(ProductID);
				order.setOrderTotalproduct(OrderTotalproduct);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return orderlist;
	}

	// ViewOrder In Cart
	public ArrayList<Order> ViewOrderinCart(int CartID, String Username) {
		ArrayList<Order> orderlist = new ArrayList<Order>();
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM orders WHERE CartID = ?");
			pStatement.setInt(1, CartID);
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				int OrderID = resultSet.getInt("OrderID");
				int cartID = resultSet.getInt("CartID");
				int ProductID = resultSet.getInt("ProductID");
				double OrderTotalPrice = resultSet.getDouble("OrderTotalPrice");
				int OrderTotalproduct = resultSet.getInt("OrderTotalproduct");
/*				
				PreparedStatement prodStatement = con.prepareStatement("SELECT * FROM product WHERE ProductID = ?");
				prodStatement.setInt(1, ProductID);
				ResultSet resultSetPro = pStatement.executeQuery();*/
				ProductDB productDB = new ProductDB();
				Product product = productDB.viewProduct(ProductID);

				Order order = new Order();
				order.setOrderID(OrderID);
				order.setCartID(cartID);
				order.setProductID(ProductID);
				order.setOrderTotalPrice(OrderTotalPrice);
				order.setOrderTotalproduct(OrderTotalproduct);
				order.setProduct(product);
				orderlist.add(order);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return orderlist;
	}

	// Delete Order in Cart
	public void DeleteOrderByCartID(int CartID) {

		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT OrderID FROM orders WHERE CartID=?");
			pStatement.setInt(1, CartID);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				int OrderID = resultSet.getInt("OrderID");
				Order order = new Order();
				order.setOrderID(OrderID);

				OrderDB orderDB = new OrderDB();
				orderDB.DeleteOrders(OrderID);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}

	// ¢Õßadmin Õ—æ‡¥µ Cart À≈—ß®“° ®Ë“¬µ—ß
	public ArrayList<Order> ViewOrderinCart(int CartID) {
		ArrayList<Order> orderlist = new ArrayList<Order>();
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM orders WHERE CartID=? ");
			pStatement.setInt(1, CartID);
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				int OrderID = resultSet.getInt("OrderID");
				int cartID = resultSet.getInt("CartID");
				int ProductID = resultSet.getInt("ProductID");
				double OrderTotalPrice = resultSet.getDouble("OrderTotalPrice");
				int OrderTotalproduct = resultSet.getInt("OrderTotalproduct");

				ProductDB productDB = new ProductDB();
				Product product = productDB.viewProduct(ProductID);

				Order order = new Order();
				order.setOrderID(OrderID);
				order.setCartID(cartID);
				order.setProductID(ProductID);
				order.setOrderTotalPrice(OrderTotalPrice);
				order.setOrderTotalproduct(OrderTotalproduct);
				order.setProduct(product);

				orderlist.add(order);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return orderlist;
	}
}