package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieSet
 */
@WebServlet("/SetLanguage")
public class CookieSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String getc = new String(request.getParameter("lang").getBytes("ISO8859_1"),"utf-8");
		
		System.out.println(getc);
		Cookie cookie = new Cookie("lang", getc);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
		response.sendRedirect("CheckCookie");
		
	}

}
