import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class test {

	public static void main(String[] args) {
		String sql = "SELECT * FROM product WHERE pid = 2";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL="jdbc:mysql://localhost/blueshop?characterEncoding=utf-8";
			Connection con=DriverManager.getConnection(dbURL,"root","");
			java.sql.Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int pid = resultSet.getInt("pid");
				String pname = resultSet.getString("pname");
				String pdetail = resultSet.getString("pdetail");
				int price = resultSet.getInt("price");
				System.out.println(pid + " " + pname + " " + pdetail + " "+ price);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
