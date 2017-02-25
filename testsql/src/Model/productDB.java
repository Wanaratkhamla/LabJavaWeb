package Model;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.annotation.MultipartConfig;

import com.mysql.jdbc.Blob;


public class productDB {
	private Connection con;
	public productDB() {
		con = ConnectDatabase.getConnection();
	}
	
	public void showproduct(){
		try {
			String sql = "SELECT * FROM product WHERE pid = 2";
			java.sql.Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int pid = resultSet.getInt("pid");
				String pname = resultSet.getString("pname");
				String pdetail = resultSet.getString("pdetail");
				int price = resultSet.getInt("price");
				System.out.println(pid + " " + pname + " " + pdetail + " "+ price);
			}
			
			
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}
}
