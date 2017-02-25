package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductDAO {
	private Connection con;

	public ProductDAO() {
		con = ConnectDatabase.getConnection();
	}

	public ArrayList<Product> SearchPro(String pname) {
		ArrayList<Product> Prolist = new ArrayList<Product>();
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM product WHERE pname LIKE ? ");
			pStatement.setString(1,"%" + pname + "%");
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				int pid = resultSet.getInt("pid");
				String pnames = resultSet.getString("pname");
				String pdetail = resultSet.getString("pdetail");
				int price = resultSet.getInt("price");

				Product product = new Product();
				product.setPid(pid);
				product.setPname(pnames);
				product.setPdetail(pdetail);
				product.setPrice(price);
				Prolist.add(product);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return Prolist;
	}

}
