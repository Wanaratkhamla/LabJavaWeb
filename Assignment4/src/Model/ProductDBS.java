package Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductDBS {
	private Connection Com;
	public ProductDBS() {
		Com = ConnectDatabase.getConnection();
	}
	
	public void showproduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			String sql = "SELECT * FROM product";
			java.sql.Statement statement = Com.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			out.println("<html><head><meta charset='UTF-8'></head><body>");
			out.println("<form method='POST' action='serachString'>");
			out.println("<input type='text' name='string'>");
			out.println("<button type='submit' >ค้นหา</button></form>");
			
			
			
			out.println("<table border='1'><td>รหัส</td><td>ชื่อสินค้า</td><td>รายละเอียด</td><td>ราคา</td></tr>");
			while (resultSet.next()) {
				int pid = resultSet.getInt("pid");
				String pname = resultSet.getString("pname");
				String pdetail = resultSet.getString("pdetail");
				int price = resultSet.getInt("price");
				out.println("<tr><td>" + pid + "</td>");
				out.println("<td>" + pname + "</td>");
				out.println("<td>" + pdetail + "</td>");
				out.println("<td>" + price + "</td>");
								
				out.println("<td>" + "<a href='SelectPid?action=selectpid&pid=" + pid + "'>แก้ไข</a></td>");
				out.println("<td>" + "<a href='DeletePro?action=delete&pid=" + pid + "'>ลบ</a></td>");
				
				
				System.out.println(pid + " " + pname + " " + pdetail + " "+ price);
			}
			out.println("</body></html>");
			Com.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}
	
	public void selectPro(HttpServletRequest request, HttpServletResponse response, int pid)throws ServletException, IOException{
		String sql = "SELECT * FROM product WHERE pid=?";
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			PreparedStatement statement = Com.prepareStatement(sql);
			statement.setInt(1,pid);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
			int pids = result.getInt("pid");
			String pname = result.getString("pname");
			String pdetail = result.getString("pdetail");
			int price = result.getInt("price");
			

			out.println("<html><head><meta charset='UTF-8'></head><body>");
			out.println("<form method='POST' action='Edit'>");
			out.println("<input type='hidden' name='action' value='editpro' /> ");
			out.println("<input type='hidden' name='pid' value= "+ pids +" /> ");
			out.println("ชื่อสินค้า : <input type='text' name='pname' value="+ pname +"><br>");
			out.println("รายละเอียดสินค้า : <textarea rows='4' cols='50' name='pdetail'>" + pdetail + "</textarea><br>");
			out.println("ราคา : <input type='text' name='price' value=" + price+ "><br>");
			out.println("<button type='submit' >แก้ไขสินค้า</button></form>");
			out.println("</body></html>");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void showsearchProduct(HttpServletRequest request, HttpServletResponse response, String thai)throws ServletException, IOException{
		String sql = "SELECT * FROM product WHERE pname LIKE ?";
		try {
			PreparedStatement statement = Com.prepareStatement(sql);
			statement.setString(1,"%" + thai + "%");
			ResultSet result = statement.executeQuery();
			response.setHeader("Content-Disposition", "attachment;filename='product.csv'");
			response.setContentType("text/csv; charset=tis-620");
			PrintWriter out = response.getWriter();
			out.println("รหัส,ชื่อสินค้า,รายละเอียด,ราคา");
			while (result.next()) {
				int pid = result.getInt("pid");
				String pname = result.getString("pname");
				String pdetail = result.getString("pdetail");
				int price = result.getInt("price");
				out.println(pid+","+ pname + "," + pdetail + "," + price);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void editProduct (HttpServletRequest request, HttpServletResponse response,int pid,String pname,String pdetail,int price)
			throws ServletException, IOException {		
		try {
			PreparedStatement pStatement = Com.
					prepareStatement("UPDATE product SET pname = ? , pdetail = ?, price = ?  WHERE pid = ?");
			pStatement.setString(1,pname);
			pStatement.setString(2,pdetail);
			pStatement.setInt(3,price);
			pStatement.setInt(4,pid);
			pStatement.executeUpdate();
			Com.close();
			response.sendRedirect("ProCTRL");
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	
	
	
	public void deleteProductBy(int pid) {
		String sql = "DELETE FROM product Where pid=?";
		try {
			PreparedStatement statement = Com.prepareStatement(sql);
			statement.setInt(1, pid);
			statement.executeUpdate();
			Com.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}
}
