
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class FirstPage
 */
@WebServlet("/FirstPage")
public class FirstPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection Com;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstPage() {
		super();
		Com = ConnectDatabase.getConnection();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// query + export csv

		String get = request.getParameter("action");
		if (get == null) {
			try {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				Statement statement = (Statement) Com.createStatement();

				String query = "SELECT * FROM product";
				PrintWriter out = response.getWriter();
				ResultSet resultset = statement.executeQuery(query);

				out.println("<html>");
				out.println("<head><meta charset='UTF-8'></head>");
				out.println("<body>");

				out.println("<form method='POST' action='FirstPage'>"); // check
																		// into
																		// the
																		// servlet
				out.println("<input type='hidden' name='action' value='search'/>"); // check
																					// for
																					// go
																					// to
																					// Loop
				out.println("<input type='text' name='pname'>");// check of use
																// the "Search"
																// Condition
				out.print("<button type='submit' >Search</button></form>");

				out.print("&nbsp<a href='FirstPage?action=printall'>Export file</a>");

				out.println("<table border='1'><td>No</td><td>Name</td><td>Detail</td><td>Price</td></tr>");
				while (resultset.next()) {

					int pid = resultset.getInt("pid");
					String pname = resultset.getString("pname");
					String pdetail = resultset.getString("pdetail");
					int price = resultset.getInt("price");

					// tag for table

					out.println("<tr><td>" + pid + "</td>");
					out.println("<td>" + pname + "</td>");
					out.println("<td>" + pdetail + "</td>");
					out.println("<td>" + price + "</td></tr></body></html>");
				}

			} catch (SQLException e) {
				System.err.println("Error database connection: " + e);
				System.exit(0);
			}
		} else {
			if (get.equals("printall")) {
				response.setHeader("Content-Disposition", "attachment;filename='product.csv'");
				response.setContentType("text/csv; charset=tis-620;");
				try {
					String query = "SELECT * FROM product";
					Statement statement = (Statement) Com.createStatement();
					PrintWriter out = response.getWriter();
					ResultSet resultset = statement.executeQuery(query);

					out.println("No" + "," + "Name" + "," + "Detail" + "," + "Price");
					while (resultset.next()) {

						int pid = resultset.getInt("pid");
						String pname = resultset.getString("pname");
						String pdetail = resultset.getString("pdetail");
						int price = resultset.getInt("price");
						out.println(pid + "," + pname + "," + pdetail + "," + price);
					}

				} catch (SQLException e) {
					System.err.println("Error database connection: " + e);
					System.exit(0);
				}
			}
			if (get.equals("search")) {
				String name = request.getParameter("pname");
				try {
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html; charset=utf-8");

					PrintWriter out = response.getWriter();
					String query = "SELECT * FROM product where pname LIKE ?";

					PreparedStatement state11 = Com.prepareStatement(query);
					state11.setString(1, "%" + name + "%");
					ResultSet resultset = state11.executeQuery();

					out.println("<html>");
					out.println("<head><meta charset='UTF-8'></head>");
					out.println("<body>");

					out.println("<form method='POST' action='FirstPage'>");
					out.println("<input type='hidden' name='action' value='search'/>");
					out.println("<input type='text' name='pname'>");
					out.print("<button type='submit' >Search</button></form>");
					System.out.println(name);
					out.print("&nbsp<a href='FirstPage?action=printdetail&pname=" + name + "'>Export file</a>");

					out.println("<table border='1'><td>No</td><td>Name</td><td>Detail</td><td>Price</td></tr>");
					while (resultset.next()) {

						int pid = resultset.getInt("pid");
						String pname = resultset.getString("pname");
						String pdetail = resultset.getString("pdetail");
						int price = resultset.getInt("price");
						// tag for table
						out.println("<tr><td>" + pid + "</td>");
						out.println("<td>" + pname + "</td>");
						out.println("<td>" + pdetail + "</td>");
						out.println("<td>" + price + "</td></tr></body></html>");
					}
				} catch (SQLException e) {
					System.err.println("Error database connection: " + e);
					System.exit(0);
				}
			}
			if (get.equals("printdetail")) {
				System.out.println(get);
				String name1 = request.getParameter("pname");
				response.setHeader("Content-Disposition", "attachment;filename='product.csv'");
				response.setContentType("text/csv; charset=tis-620;");
				try {

					String query = "SELECT * FROM product where pname LIKE ?";
					PreparedStatement statement = Com.prepareStatement(query);
					statement.setString(1, "%" + name1 + "%");
					ResultSet resultset = statement.executeQuery();
					PrintWriter out = response.getWriter();

					out.println("No" + "," + "Name" + "," + "Detail" + "," + "Price");
					while (resultset.next()) {

						int pid = resultset.getInt("pid");
						String pname = resultset.getString("pname");
						String pdetail = resultset.getString("pdetail");
						int price = resultset.getInt("price");
						out.println(pid + "," + pname + "," + pdetail + "," + price);
					}

				} catch (SQLException e) {
					System.err.println("Error database connection: " + e);
					System.exit(0);
				}
			}

		}

	}
}
