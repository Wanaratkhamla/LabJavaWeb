package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;


/**
 * Servlet implementation class ProductController
 */
//{"/login", "/logout", "/register", "/profile" }
@WebServlet({"/search","insert","Edit","delete"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		if (action.equals("search")) {
			String get = new String(request.getParameter("string").getBytes("ISO8859_1"), "utf-8");
			System.out.println(get);
			ProductDAO pro = new ProductDAO();
			ArrayList<Product> product = new ArrayList<Product>();
			product = pro.SearchPro(get);
			request.setAttribute("check", "1");
			request.setAttribute("product", product);
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}
		
		if (action.equals("insert")) {
			
		}
		
		if (action.equals("edit")) {
			
		}
		
		if (action.equals("delete")) {
			
		}
		
	}

}
