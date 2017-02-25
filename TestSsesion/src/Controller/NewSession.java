package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewSession
 */
@WebServlet("/NewSession")
public class NewSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputUsername = request.getParameter("Username");
		String inputPassword = request.getParameter("Password");
		response.setContentType("text/jsp");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		
		if (inputUsername.equals("bobby") && inputPassword.equals("1234")) {
			session.setAttribute("firstname", inputUsername);
			session.setMaxInactiveInterval(5);
			out.println("Waiting 1 minute");
			String name = (String)session.getAttribute("firstname");
			System.out.println(name);
		}else{
			response.sendRedirect("Testssesion.jsp");
		}
		System.out.println(session.isNew());
		
		if (session.isNew()) {
			out.println("1");
		}else{
			response.sendRedirect("Testssesion.jsp");
		}
//		} else {
//			out.println("Welcome back!");
//			String name = (String)session.getAttribute("firstname");
//			System.out.println(name);
//		}
	}

}
