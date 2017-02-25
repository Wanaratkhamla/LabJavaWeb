

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class thaiShow
 */
@WebServlet("/thaiShow")
public class thaiShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thaiShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String get = new String(request.getParameter("send").getBytes("ISO8859_1"),"utf-8");
		String get2 = new String(request.getParameter("send2").getBytes("ISO8859_1"),"utf-8");
		
		System.out.println(get);
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/jsp; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><meta charset='UTF-8'></head><body>");
//		out.println("" + get + "<br>");
//		out.println("</body></html>");
		
		
		
		
		request.setAttribute("sum", get);
		request.setAttribute("sum2", get2);
		RequestDispatcher view = request.getRequestDispatcher("thai.jsp");
		view.forward(request, response);
	}

}
