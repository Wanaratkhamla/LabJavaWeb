package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	private static Connection Com;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost/testjoin?characterEncoding=utf-8";
			Com=DriverManager.getConnection(dbURL,"root","");
		} catch (ClassNotFoundException e) {
			System.err.println("Error Load Driver :" +e);
		}catch (SQLException e) {
			System.err.println("Error To Connect Database :" + e);
		}
		return Com;
	}
}
