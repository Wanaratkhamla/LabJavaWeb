package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestExpire")
public class TestExpire extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		if (session.getAttribute("firstname")!=null) {
			out.print("<h1>Welcome " + session.getAttribute("firstname") + "</h1>");
		} else {
			out.println("คุณไม่ทำรายการตามที่กำหนด โปรด Login ใหม่<br>");
			out.println("<a href='login.html'>Login</a>");		
		}
	}


}
