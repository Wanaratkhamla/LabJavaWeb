package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
/**
 * Servlet implementation class MainController
 */
@WebServlet({"","/main"})
@MultipartConfig
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductDB productDB = new ProductDB();
		ProductDetailDB productDetailDB = new ProductDetailDB();
		ArrayList<Product> showpro = new ArrayList<Product>();
		/*Product showpro = new Product();
		showpro = productDB.viewProduct(3);*/
		
		showpro = productDB.viewAllProduct();
		/*System.out.println(showpro.get(0).getProductID());
		System.out.println(showpro.get(0).getPhotosrc());*/
		request.setAttribute("product", showpro);
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html; charset=utf-8");
//		out.println("<html><head><meta charset=\"UTF-8\"></head><body>");
//		out.println("Student name: " + name + "<br>");
//		out.println("Age: " + age);
//		out.println("</body></html>");
		
	}

}
