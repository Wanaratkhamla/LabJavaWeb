package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.*;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = request.getParameter("pname");
		String prices = request.getParameter("price");
		int price = Integer.parseInt(prices);
		Product pro = new Product();
		pro.setPname(pname);
		pro.setPrice(price);
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Product> list = (ArrayList<Product>)session.getAttribute("prolist");
		
		if (list==null) {
			list = new ArrayList<Product>();
			list.add(pro);			
		} else {
			list.add(pro);
		}	
		
		session.setAttribute("prolist", list);
		response.sendRedirect("ListProduct");
	}

}
