package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CheckCookie
 */
@WebServlet("/CheckCookie")
public class CheckCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckCookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("lang")) {
					String userName = cookie.getValue();
					switch(cookie.getValue()){
					case "en"
						: showhtml(request,response,"Welcome");
						break;
					case "th"
						: showhtml(request,response,"ยินดีต้อนรับ");
						break;
					default
						: response.sendRedirect("GetCookie.jsp");
						break;
					}
				}
			}
		}
		
	}
	protected void showhtml(HttpServletRequest request, HttpServletResponse response , String ck)
			throws ServletException, IOException {
		System.out.println(ck);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/jsp; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'></head><body>");
		out.println(ck);
		out.println("</body></html>");
		
	}


}
