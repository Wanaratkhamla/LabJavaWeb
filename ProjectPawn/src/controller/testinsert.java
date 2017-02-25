package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.*;

/**
 * Servlet implementation class PawnCtrl
 */
@WebServlet({"/test"})
public class testinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
		/**
		 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
		 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		customersDB customersDB = new customersDB();
		pawnDB pawnDB = new pawnDB();
		productDB productDB = new productDB();
		String action = request.getParameter("action");
		
		//ทำการเพิ่มการจำนำ โดยเพิ่มการจำนำและเพิ่มลูกค้า
		if(action.equals("InsertPawnandcustomer")){
			String CustomersID = new String(request.getParameter("CustomersID"));
			String Name = new String(request.getParameter("Name").getBytes("ISO8859_1"), "utf-8");
			String Address = new String(request.getParameter("Address").getBytes("ISO8859_1"), "utf-8");
			String PhoneNo = new String(request.getParameter("PhoneNo"));
			String ProductID = new String(request.getParameter("ProductID"));
			String ProductName = new String(request.getParameter("ProductName").getBytes("ISO8859_1"), "utf-8");
			double ProductPrice = Double.parseDouble(request.getParameter("ProductPrice"));
			String ProductDescription = new String(request.getParameter("ProductDescription").getBytes("ISO8859_1"), "utf-8");
			String PawnDateEnd = new String(request.getParameter("PawnDateEnd"));
			customers c = customersDB.CheckUser(CustomersID);
			String cid = c.getCustomersID();
			System.out.println(cid);
			System.out.println(CustomersID);
			if (cid.equals(CustomersID)) {
			}else{
				customersDB.insertCustomers(CustomersID, Name, Address, PhoneNo);
			}
			product p = productDB.selectProduct(ProductID);
			String pid = p.getProductID();
			System.out.println(pid);
			if(pid.equals(ProductID))
			{
				response.sendRedirect("Checkproduct.jsp");
			}else{
				productDB.insertProductpawn(ProductID,ProductName, ProductPrice, ProductDescription);
				double Pawninterest = ProductPrice*((double)10/100);
				pawnDB.insertpawn(ProductID, CustomersID, Pawninterest, PawnDateEnd);
				response.sendRedirect("testinesrt.jsp");
			}
			
			
			
		}
	}

}
