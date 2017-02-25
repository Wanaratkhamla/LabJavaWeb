package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.*;

/**
 * Servlet implementation class ProductCtrl
 */
@WebServlet("/Product")
@MultipartConfig
public class ProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDB productDB = new ProductDB();
		ProductDetailDB productDetailDB = new ProductDetailDB();
		String action = request.getParameter("action");
		
		//เรียกใช้การแสดง product ทั้งหมด
		if (action.equals("ShowAllproduct")){
			ArrayList<Product> showpro = new ArrayList<Product>();
			showpro = productDB.viewAllProduct();
			request.setAttribute("product", showpro);
			RequestDispatcher view = request.getRequestDispatcher(".......jsp");
			view.forward(request, response);
		} 
		//เรียกใช้การแสดง product โดยตาม Brand
		else if(action.equals("ShowProByBrand")){
			int BrandID = Integer.parseInt(request.getParameter("brandid"));
			ArrayList<Product> showprobyBrand = new ArrayList<Product>();
			showprobyBrand = productDetailDB.viewProductByBrand(BrandID);
			request.setAttribute("producttype", showprobyBrand);
			RequestDispatcher view = request.getRequestDispatcher("search.jsp");
			view.forward(request, response);
		}
		//เรียกใช้การแสดง product โดยตาม Type
		else if(action.equals("ShowProByType")){
			int TypeID = Integer.parseInt(request.getParameter("typeid"));
			ArrayList<Product> showprobyType = new ArrayList<Product>();
			showprobyType = productDetailDB.viewProductByType(TypeID);
			request.setAttribute("producttype", showprobyType);
			RequestDispatcher view = request.getRequestDispatcher("search.jsp");
			view.forward(request, response);
		}
		//เรียกใช้การแสดง product โดยตาม Type
		else if(action.equals("viewProductAll")){
			String ProductAll = new String(request.getParameter("search").getBytes("ISO8859_1"), "utf-8");
			ArrayList<Product> showAllProduct = new ArrayList<Product>();
			showAllProduct = productDetailDB.viewProductAll(ProductAll);
			request.setAttribute("producttype", showAllProduct);
			RequestDispatcher view = request.getRequestDispatcher("search.jsp");
			view.forward(request, response);
		}
		//เรียกใช้การแสดง product ตาม Type and Brand ที่เลือกโดยมีหลายตัวเลือก
		else if(action.equals("ShowProByBrandTypeS")){
			
			String BrandId[] = (request.getParameterValues("brandid"));
			String Typeid[] = (request.getParameterValues("typeid"));
			ArrayList<Product> showprobyBrandAndType = new ArrayList<Product>();
			showprobyBrandAndType = productDetailDB.viewProductByBrandAndType(BrandId, Typeid);
			request.setAttribute("productbrandandtype", showprobyBrandAndType);
			RequestDispatcher view = request.getRequestDispatcher(".......jsp");
			response.sendRedirect("........");
		}
		//ทำการเพิ่ม product
		else if(action.equals("InsertPro")){
			int BrandID = Integer.parseInt(request.getParameter("brandid"));
			int TypeID = Integer.parseInt(request.getParameter("typeid"));
			String ProductName = new String(request.getParameter("productname").getBytes("ISO8859_1"), "utf-8");
			double ProductPrice = Double.parseDouble(request.getParameter("productprice"));
			int ProductNumber = Integer.parseInt(request.getParameter("productnumber"));
			String ProductDescription = new String(request.getParameter("productdescription").getBytes("ISO8859_1"), "utf-8");
			Part filePart = request.getPart("ProductPhoto");
			InputStream	ProductPhoto = filePart.getInputStream();
			productDB.insertProduct(BrandID, TypeID, ProductName, ProductPrice, ProductNumber, ProductDescription,ProductPhoto);
			response.sendRedirect("insertProduct.jsp");
		}
		//ทำการแก้ไข Product
		else if(action.equals("ShowProEdit")){
			int productID = Integer.parseInt(request.getParameter("productID"));
			int brandID = Integer.parseInt(request.getParameter("brandID"));
			int typeID = Integer.parseInt(request.getParameter("typeID"));
			String productName = new String(request.getParameter("productName").getBytes("ISO8859_1"), "utf-8");
			double productPrice = Double.parseDouble(request.getParameter("productPrice"));
			int productNumber = Integer.parseInt(request.getParameter("productNumber"));
			String productDescription = new String(request.getParameter("productDescription").getBytes("ISO8859_1"), "utf-8");
			request.setAttribute("productID", productID);
			request.setAttribute("brandID", brandID);
			request.setAttribute("typeID", typeID);
			request.setAttribute("productName", productName);
			request.setAttribute("productPrice", productPrice);
			request.setAttribute("productNumber", productNumber);
			request.setAttribute("productDescription", productDescription);
			RequestDispatcher view = request.getRequestDispatcher("editProduct.jsp");
			view.forward(request, response);
		}
		else if(action.equals("editPro")){
			
			int productID = Integer.parseInt(request.getParameter("productID"));
//			int brandID = Integer.parseInt(request.getParameter("brandID"));
//			int typeID = Integer.parseInt(request.getParameter("typeID"));
			String productName = new String(request.getParameter("productName").getBytes("ISO8859_1"), "utf-8");
			double productPrice = Double.parseDouble(request.getParameter("productPrice"));
			int productNumber = Integer.parseInt(request.getParameter("productNumber"));
			String productDescription = new String(request.getParameter("productDescription").getBytes("ISO8859_1"), "utf-8");
/*			Part filePart = request.getPart("ProductPhoto");
			InputStream	ProductPhoto = filePart.getInputStream();*/
			productDB.editProduct(productID, productName, productPrice, productNumber, productDescription);
			response.sendRedirect("main");
		}
		//ทำการลบ product
		else if(action.equals("deletepro")){
			int ProductID = Integer.parseInt(request.getParameter("productid"));
			productDB.deleteProductBy(ProductID);
		}
	}

}
