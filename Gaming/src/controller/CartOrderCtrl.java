package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class CartOrderCtrl
 */
@WebServlet("/CartOrderCtrl")
public class CartOrderCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	public CartOrderCtrl() {
		con = ConnectDatabase.getConnection();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDB orderDB = new OrderDB();
		CartDB cartDB = new CartDB();
		ProductDB productDB = new ProductDB();
		double sum;

		String action = request.getParameter("action");
		// เรียกการดู Cart ทั้งหมด admin
		if (action.equals("ShowAllCart")) {
			ArrayList<Cart> showcart = new ArrayList<Cart>();
			showcart = cartDB.ViewAllCart();
			request.setAttribute("showCart", showcart);
			RequestDispatcher view = request.getRequestDispatcher("updateStatus.jsp");
			view.forward(request, response);
		}
		// เรียก ดู Order ผ่าน Cart ของUser นั้นๆ *
		else if (action.equals("ShowOrderinCart")) {

			String Username = request.getParameter("Username"); // รับจาก	
			// Session.
			Cart c = cartDB.CartnoPay(Username);
			ArrayList<Order> showorderbycart = new ArrayList<Order>();
			showorderbycart = orderDB.ViewOrderinCart(c.getCartID(), Username);

			ArrayList<CartDetail> cartDetail = new ArrayList<CartDetail>();
			for (int i = 0; i < showorderbycart.size(); i++) {
				CartDetail cd = new CartDetail();
				cd.setCartID(c.getCartID());
				cd.setUsername(Username);
				cd.setCartOrderdate(c.getCartOrderdate());
				cd.setCartTotalProduct(c.getCartTotalProduct());
				cd.setCartPaydate(c.getCartPaydate());
				cd.setCartStatus(c.getCartStatus());
				cd.setCartTotalPrice(c.getCartTotalPrice());
				
				
				Order o = showorderbycart.get(i);
				Product p = new Product();
				ProductDB pdb = new ProductDB();
				p = pdb.viewProduct(o.getProductID());
				
				
				cd.setOrderID(o.getOrderID());
				cd.setProductID(o.getProductID());
				cd.setOrderTotalPrice(o.getOrderTotalPrice());
				cd.setOrderTotalproduct(o.getOrderTotalproduct());
				cd.setProductName(p.getProductName());
				cd.setPhotosrc(p.getPhotosrc());
				cd.setProductPrice(p.getProductPrice());
				cd.setProductDescription(p.getProductDescription());
				cartDetail.add(cd);
			}
			request.setAttribute("cartID", c.getCartID());
			request.setAttribute("cartTotalPrice", c.getCartTotalPrice());
			request.setAttribute("cartDetail", cartDetail);
			RequestDispatcher view = request.getRequestDispatcher("showCart.jsp");
			view.forward(request, response);
		}

		// user ทำการเพิ่ม Order ถ้าไม่มี Cart จะทำการเพิ่มCart ก่อน
		else if (action.equals("InsertCartANDorder")) {
			String Username = new String(request.getParameter("Username"));
			int productID = Integer.parseInt(request.getParameter("productID"));
			double price = Double.parseDouble(request.getParameter("price"));
			Cart c = cartDB.CartnoPay(Username);
			int cid = c.getCartID();
			if (cid != 0) {
				Product p = productDB.viewProduct(productID);
				Order or = orderDB.SelectOrder(productID, c.getCartID());
				if (or.getProductID() == productID) // สินค้าตัวเดิมหรือไม่
				{
					orderDB.updateProduct(or.getOrderID(), or.getOrderTotalproduct() + 1,
							or.getOrderTotalPrice() + p.getProductPrice());
				} else {
					orderDB.InsertProductinorder(c.getCartID(), productID, price, 1);
				}
				cartDB.UpdatePriceAndtotalinCart(c.getCartID(), c.getCartTotalProduct() + 1,
						c.getCartTotalPrice() + price);
				// กรณีinsert ครั้งแรก
			} else {
				cartDB.InsertCart(Username);
				Cart c2 = cartDB.CartnoPay(Username);
				orderDB.InsertProductinorder(c2.getCartID(), productID, price, 1);
				cartDB.UpdatePriceAndtotalinCart(c2.getCartID(), 1, price);
			}
			response.sendRedirect("main");
		}

		// update วันจ่ายตัง และอัพเตตัสไปพร้อมกัน
		else if (action.equals("UpdatePaystatus")) {
			int CartID = Integer.parseInt(request.getParameter("CartID"));
			/*String Username = request.getParameter("Username");*/
			cartDB.Updatepayandstatus(CartID);

			ArrayList<Order> showorderbycart = new ArrayList<Order>();
			showorderbycart = orderDB.ViewOrderinCart(CartID);
			for (int i = 0; i < showorderbycart.size(); i++) {
				Order o = showorderbycart.get(i);
				ProductDB pdb = new ProductDB();
				Product pp = pdb.viewProduct(o.getProductID());
				productDB.updatenumberproduct(o.getProductID(), pp.getProductNumber() - o.getOrderTotalproduct());
			}
			
			String set = "CartOrderCtrl?action=ShowAllCart";
			response.sendRedirect(set);

		}

		// user delete order ****
		else if (action.equals("DeleteOrder")) { // ลบOrder
			int OrderID = Integer.parseInt(request.getParameter("OrderID"));
			int CartID = Integer.parseInt(request.getParameter("CartID"));
			double OrderTotalPrice = Double.parseDouble(request.getParameter("OrderTotalPrice"));
			int OrderTotalproduct = Integer.parseInt(request.getParameter("OrderTotalproduct"));
			int CartTotalProduct = Integer.parseInt(request.getParameter("CartTotalProduct"));
			double 	CartTotalPrice = Double.parseDouble(request.getParameter("CartTotalPrice"));
			String Username = request.getParameter("Username");
			String set = "CartOrderCtrl?action=ShowOrderinCart&Username="+Username;
			orderDB.DeleteOrders(OrderID);
			cartDB.UpdatePriceAndtotalinCart(CartID, CartTotalProduct-OrderTotalproduct, CartTotalPrice-OrderTotalPrice);
			response.sendRedirect(set);
		}
		// Delete Cart
		else if (action.equals("DeleteCart")) { // ลบสินค้า
			int CartID = Integer.parseInt(request.getParameter("CartID"));
			cartDB.DeleteCart(CartID);
			response.sendRedirect("........");

		}
		if (action.equals("updateProduct")) { // อัพเดตสินค้าในตระกร้า
			String Username = new String(request.getParameter("Username"));
			int CartID = Integer.parseInt(request.getParameter("CartID"));
			int OrderID = Integer.parseInt(request.getParameter("OrderID"));
			int productID = Integer.parseInt(request.getParameter("productID"));
			int productNumber = Integer.parseInt(request.getParameter("OrderTotalproduct"));
			Product p = productDB.viewProduct(productID);
			orderDB.updateProduct(OrderID, productNumber, p.getProductPrice() * productNumber);
			ArrayList<Order> showorderbycart = new ArrayList<Order>();
			showorderbycart = orderDB.ViewOrderinCart(CartID, Username);
			int pnum = 0;
			double pprice = 0;
			for (int i = 0; i < showorderbycart.size(); i++) {
				Order o = showorderbycart.get(i);
				pnum = pnum + o.getOrderTotalproduct();
				pprice = pprice + o.getOrderTotalPrice();
			}
			cartDB.UpdatePriceAndtotalinCart(CartID, pnum, pprice);
			response.sendRedirect("........");
		}
		// Userupdateorder ****
		if (action.equals("updateorder")){
			int Number = Integer.parseInt(request.getParameter("Number"));
			String Username = new String(request.getParameter("Username"));
			int OrderID = Integer.parseInt(request.getParameter("OrderID"));
			int CartID = Integer.parseInt(request.getParameter("CartID"));
			double ProductPrice = Double.parseDouble(request.getParameter("ProductPrice"));

			orderDB.updateProduct(OrderID, Number, ProductPrice*Number);
			
			ArrayList<Order> showorderbycart = new ArrayList<Order>();
			showorderbycart = orderDB.ViewOrderinCart(CartID, Username);
			int pnum = 0;
			double pprice = 0;
			for (int i = 0; i < showorderbycart.size(); i++) {
				Order o = showorderbycart.get(i);
				pnum = pnum + o.getOrderTotalproduct();
				pprice = pprice + o.getOrderTotalPrice();
			}
			
			cartDB.UpdatePriceAndtotalinCart(CartID, pnum, pprice);

//		}
			String set = "CartOrderCtrl?action=ShowOrderinCart&Username="+Username;
			response.sendRedirect(set);
			
		}
	}

}
