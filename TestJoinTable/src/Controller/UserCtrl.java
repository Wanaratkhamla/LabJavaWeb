package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Model.Student;
import Model.StudentDAO;
import Model.StudentDapart;

/**
 * Servlet implementation class UserCtrl
 */
@WebServlet({ "/login", "/Register", "/logout", "/Profile" })
public class UserCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		StudentDAO std = new StudentDAO();
		if (action.equals("register")) {
			String Sid = request.getParameter("SID");
			String Password = request.getParameter("Password");
			String Password1 = request.getParameter("Password1");
			String fname = new String(request.getParameter("fname").getBytes("ISO8859_1"), "utf-8");
			String lname = new String(request.getParameter("lname").getBytes("ISO8859_1"), "utf-8");
			String department = request.getParameter("department");
			if (Password.equals(Password1)) {
				std.InsertStudent(Sid, Password, Integer.parseInt(department), fname, lname);
				response.sendRedirect("Login.jsp");
			} else {
				response.sendRedirect("Login.jsp");
			}

		}

		if (action.equals("dologin")) {
			String Sid = request.getParameter("SID");
			String Password = request.getParameter("Password");
			Student student = std.login(Sid, Password);
			if (student.isCheck() == true) {
				response.sendRedirect("Profile?action=Profile");
				HttpSession sess = request.getSession();
				// เก็บ Session
				sess.setAttribute("SID", student.getSID());
			} else {
				// เงื่อนไขเมื่อผิด
				response.sendRedirect("Login.jsp");
			}
		}
		
		if(action.equals("logout")){
			HttpSession sess = request.getSession();
			sess.setAttribute("Username", null);
			sess.invalidate();
			response.sendRedirect("Login.jsp");
		}
		
		if (action.equals("Profile")) {
			HttpSession sess = request.getSession();
			StudentDapart a = std.showProfile((String) sess.getAttribute("SID"));
			request.setAttribute("nos", a);
			RequestDispatcher view = request.getRequestDispatcher("Profile.jsp");
			view.forward(request, response);
		}
	}

}
