package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Product;

/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/ListProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Product> list = (ArrayList<Product>)session.getAttribute("prolist");
		if (list!=null) {
			int sum = 0;	
			
			out.println("<table border='1'><td>Name</td><td>Score</td></tr>");
			for(int i=0; i<list.size(); i++) {
				Product pro = list.get(i);
				out.println("<tr><td>" + pro.getPname() + "</td>");
				out.println("<td>" + pro.getPrice() + "</td></tr>");
				sum = sum + pro.getPrice();
			}
			out.println("</table>");
			out.println("<br>Total price : " + sum + " Bath");
			out.println("<br><a href='productList.html'>Add Product</a>");

		} else {
			out.println("No any athlete<br>");
			out.println("<br><a href='productList.html'>Add Product</a>");
		}
	}

}
