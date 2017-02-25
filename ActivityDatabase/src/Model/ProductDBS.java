package Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
			response.setContentType("text/jsp; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			
			String sql = "SELECT * FROM product";
			java.sql.Statement statement = Com.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			out.println("<html><body>");
			out.println("<html><head><meta charset='UTF-8'></head><body>");
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
}
