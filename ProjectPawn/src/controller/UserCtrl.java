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
@WebServlet({"/login", "/logout"})
public class UserCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		adminDB adminDB = new adminDB();
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
			admin check = adminDB.adminlogin(username);
			// เชคว่ามี Username นี้หรือไม่
			if (check.getCheck() == true) {
				// เชค Password
				if (check.getPassword().equals(password)) {
							
					response.sendRedirect("adminpawn.jsp");
					HttpSession sess = request.getSession();
					// เก็บ Session
					sess.setAttribute("Username", check.getUsername());
					sess.setAttribute("Name", check.getName());
				} else {
					RequestDispatcher login = request.getRequestDispatcher("loginadmin.jsp");
					request.setAttribute("Auth", "error");
					login.forward(request, response);
				}
				// ไม่พบ username
			} else {
				RequestDispatcher login = request.getRequestDispatcher("loginadmin.jsp");
				request.setAttribute("Auth", "error");
				login.forward(request, response);
			}
			// log out Clear Session
		} else if (action.equals("logout")) {
			HttpSession sess = request.getSession();
			sess.setAttribute("Username", null);
			sess.setAttribute("Name", null);
			sess.invalidate();
			response.sendRedirect("loginadmin.jsp");
		}
	}

}
