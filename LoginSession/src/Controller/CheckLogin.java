package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputUsername = request.getParameter("Username");
		String inputPassword = request.getParameter("Password");

		if (inputUsername.equals("bobby") && inputPassword.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("firstname", inputUsername);
			response.sendRedirect("TestExpire");
		} else {
			response.sendRedirect("login.html");
		}
	}

}
