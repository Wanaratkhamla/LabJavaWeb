package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.*;

/**
 * Servlet implementation class UserCtrl
 */
@WebServlet({"/login", "/logout", "/register", "/profile" })
public class UserCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDB userDB = new UserDB();
		CartDB cartDB = new CartDB();
		String action = request.getParameter("action");
		request.setAttribute("Au", "user");
		// หากไม่ส่ง action มาจะเด้งไปหน้า login
		if (action == null) {
			RequestDispatcher login = request.getRequestDispatcher("login.jsp");
			login.forward(request, response);
			// เมื่อกด login
		} else if (action.equals("doLogin")) {
			String username = new String(request.getParameter("username"));
			String password = new String(request.getParameter("password"));
			User check = userDB.loginusers(username);
			Cart check2 = cartDB.CartnoPay(username);
			// เชคว่ามี Username นี้หรือไม่
			if (check.getCheck() == true) {
				// เชค Password
				if (check.getPassword().equals(password)) {
							
					response.sendRedirect("main");
					HttpSession sess = request.getSession();
					// เก็บ Session
					sess.setAttribute("Username", check.getUsername());
					sess.setAttribute("Name", check.getName());
					sess.setAttribute("E-mail", check.getEMail());
					sess.setAttribute("Type", check.getType());
					if(check2.getCartID()>0){
						sess.setAttribute("CartID", check2.getCartID());
					}
				} else {
					RequestDispatcher login = request.getRequestDispatcher("login.jsp");
					request.setAttribute("Auth", "error");
					login.forward(request, response);
				}
				// ไม่พบ username
			} else {
				RequestDispatcher login = request.getRequestDispatcher("login.jsp");
				request.setAttribute("Auth", "error");
				login.forward(request, response);
			}
			// log out Clear Session
		} else if (action.equals("logout")) {
			HttpSession sess = request.getSession();
			sess.setAttribute("Username", null);
			sess.setAttribute("Type", null);
			sess.invalidate();
			response.sendRedirect("main");
			// Register
		} else if (action.equals("register")) {
			UserDB user = new UserDB();
			String Username = request.getParameter("Username");
			String Password = request.getParameter("Password");
			String Name = new String(request.getParameter("Name").getBytes("ISO8859_1"), "utf-8");
			String Type = request.getParameter("Type");
			String IDCard = request.getParameter("IDCard");
			String EMail = request.getParameter("EMail");
			String Address = new String(request.getParameter("Address").getBytes("ISO8859_1"), "utf-8");
			String PhoneNO = request.getParameter("PhoneNO");
			// เชคว่า Password ตรงกันไหม
//			if (Password.equals(Password)) {
				user.InsertUser(Username, Password, Name, "user", IDCard, EMail, Address, PhoneNO);
				User s = new User();
				s = user.loginusers(Username);
				if (s.getCheck()) {
					HttpSession sess = request.getSession();
					sess.setAttribute("Username", s.getUsername());
					response.sendRedirect("login");
				}
//			}
			// //แก้ไขข้อมูล User
			else if (action.equals("edit")) {
				String username = request.getParameter("Username");
				String password = request.getParameter("Password");
				String name = new String(request.getParameter("Name").getBytes("ISO8859_1"), "utf-8");
				String type = request.getParameter("Type");
				String iDCard = request.getParameter("IDCard");
				String eMail = request.getParameter("EMail");
				String address = new String(request.getParameter("Address").getBytes("ISO8859_1"), "utf-8");
				String phoneNO = request.getParameter("PhoneNO");
				userDB.updateUser(password, name, type, iDCard, eMail, address, phoneNO, username);
				RequestDispatcher profile = request.getRequestDispatcher("login.jsp");
				profile.forward(request, response);
			} 
			// นำ Cart มาแสดงหน้า User
			/*else if (action.equals("profile")) {
				HttpSession sess = request.getSession();
				String idno = sess.getAttribute("idno").toString();
				String userid = sess.getAttribute("uid").toString();
				User prof = userDB.doProfile(idno);
				ArrayList<BookingDetail> booklist = bookingDtailDB.getBookingDetail2(userid);
				ArrayList<TicketDetail> tic = new ArrayList<TicketDetail>();
				TicketDetailDB ticketDB = new TicketDetailDB();
				for (int i = 0; i < booklist.size(); i++) {
					TicketDetail a = new TicketDetail();
					a = ticketDB.getOneTicketByBookingID(booklist.get(i).getBookingID());
					tic.add(a);
				}
				request.setAttribute("tic", tic);
				request.setAttribute("profile", prof);
				request.setAttribute("booklist", booklist);
				RequestDispatcher profile = request.getRequestDispatcher("profile.jsp");
				profile.forward(request, response);
			}*/
		}
	}

}
