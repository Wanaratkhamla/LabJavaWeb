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
			PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE pname LIKE ? ");
			ps.setString(1, "%" + pname + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product pro = new Product();
				int pid = rs.getInt("pid");
				String pnames = rs.getString("pname");
				String pdetail = rs.getString("pdetail");
				int price = rs.getInt("price");

				pro.setPid(pid);
				pro.setPname(pnames);
				pro.setPdetail(pdetail);
				pro.setPrice(price);
				Prolist.add(pro);

			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return Prolist;
	}

	public void updateProduct(int pid, String pname, String pdetail, String price) {
		String Sql = "UPDATE product SET pname = ? , pdetail = ? , price = ? WHERE pid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setString(1, pname);
			ps.setString(2, pdetail);
			ps.setString(3, price);
			ps.setInt(4, pid);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void deleteproduct(int pid){
		String sql = "DELETE FROM product WHERE pid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void insertpro (String pname , String pdetail , String pirce){
		String sql = "INSERT INTO product (pname, pdetail, price) VALUE (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setString(2, pdetail);
			ps.setString(3, pirce);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
