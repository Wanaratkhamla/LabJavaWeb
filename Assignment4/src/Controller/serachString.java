package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ProductDBS;

/**
 * Servlet implementation class serachString
 */
@WebServlet("/serachString")
public class serachString extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serachString() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String get = new String(request.getParameter("string").getBytes("ISO8859_1"),"utf-8");
		System.out.println(get);
		ProductDBS pros = new ProductDBS();
		pros.showsearchProduct(request, response, get);
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/jsp; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><meta charset='UTF-8'></head><body>");
//		out.println("" + get + "<br>");
//		out.println("</body></html>");
	}

}
