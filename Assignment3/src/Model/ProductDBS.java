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
			out.print("<button type='submit' >ค้นหา</button></form>");
			
			out.print("&nbsp<a href='Print?action=printall'>Export file</a>");
			
			
			
			out.println("<table border='1'><td>รหัส</td><td>ชื่อสินค้า</td><td>รายละเอียด</td><td>ราคา</td></tr>");
			while (resultSet.next()) {
				int pid = resultSet.getInt("pid");
				String pname = resultSet.getString("pname");
				String pdetail = resultSet.getString("pdetail");
				int price = resultSet.getInt("price");
				out.println("<tr><td>" + pid + "</td>");
				out.println("<td>" + pname + "</td>");
				out.println("<td>" + pdetail + "</td>");
				out.println("<td>" + price + "</td></tr>");
				System.out.println(pid + " " + pname + " " + pdetail + " "+ price);
			}
			out.println("</body></html>");
			Com.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}
	
	public void showsearchProduct(HttpServletRequest request, HttpServletResponse response, String thai)throws ServletException, IOException{
		String sql = "SELECT * FROM product WHERE pname LIKE ?";
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			PreparedStatement statement = Com.prepareStatement(sql);
			statement.setString(1,"%" + thai + "%");
			ResultSet result = statement.executeQuery();
			out.println("<html><head><meta charset='UTF-8'></head><body>");
			out.println("<form method='POST' action='serachString'>");
			out.println("<input type='text' name='string'>");
			out.print("<button type='submit' >ค้นหา</button></form>");
			
			
			out.print("&nbsp<a href='Print?action=printdetail&name=" + thai + "'>Export file</a>");
			
			
			out.println("<table border='1'><td>รหัส</td><td>ชื่อสินค้า</td><td>รายละเอียด</td><td>ราคา</td></tr>");
			while (result.next()) {
				int pid = result.getInt("pid");
				String pname = result.getString("pname");
				String pdetail = result.getString("pdetail");
				int price = result.getInt("price");
				out.println("<tr><td>" + pid + "</td>");
				out.println("<td>" + pname + "</td>");
				out.println("<td>" + pdetail + "</td>");
				out.println("<td>" + price + "</td></tr>");
				System.out.println(pid + " " + pname + " " + pdetail + " "+ price);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void printallProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String sql = "SELECT * FROM product ";
		try {
			java.sql.Statement statement = Com.createStatement();
			ResultSet result = statement.executeQuery(sql);
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
	
	public void printdetailProduct(HttpServletRequest request, HttpServletResponse response,String thai)throws ServletException, IOException{
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
}
