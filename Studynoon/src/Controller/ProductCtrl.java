package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import Model.ProductDAO;

/**
 * Servlet implementation class ProductCtrl
 */
@WebServlet("/ProductCtrl")
public class ProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		ProductDAO product = new ProductDAO();
		
		if (action.equals("search")) {
			String get = new String(request.getParameter("string").getBytes("ISO8859_1"), "utf-8");
			ArrayList<Product> pro = new ArrayList<Product>();
			pro = product.SearchPro(get);
			request.setAttribute("product", pro);
			RequestDispatcher view = request.getRequestDispatcher("search.jsp");
			view.forward(request, response);
		}
		
		if (action.equals("edit")) {
			String pid = request.getParameter("pid");
			int pids = Integer.parseInt(pid);
			String pname = new String(request.getParameter("pname").getBytes("ISO8859_1"), "utf-8");
			String pdetail = new String(request.getParameter("pdetail").getBytes("ISO8859_1"), "utf-8");
			String price = new String(request.getParameter("price").getBytes("ISO8859_1"), "utf-8");
			product.updateProduct(pids, pname, pdetail, price);
			response.sendRedirect("index.jsp");
			
		}
		
		if (action.equals("delete")) {
			String pid = request.getParameter("pid");
			product.deleteproduct(Integer.parseInt(pid));
			response.sendRedirect("index.jsp");
		}
		if (action.equals("insert")) {
			String pname = new String(request.getParameter("pname").getBytes("ISO8859_1"), "utf-8");
			String pdetail = new String(request.getParameter("pdetail").getBytes("ISO8859_1"), "utf-8");
			String price = new String(request.getParameter("price").getBytes("ISO8859_1"), "utf-8");
			product.insertpro(pname, pdetail, price);
			response.sendRedirect("index.jsp");
		}
	}

}
