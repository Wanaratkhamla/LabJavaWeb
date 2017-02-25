package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assignment2
 */
@WebServlet("/Assignment2")
public class Assignment2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assignment2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a[] = request.getParameterValues("a");
		
		double sum = 0;
		double d[] = null;
		PrintWriter out = response.getWriter();
		for(int x=0; x<a.length; x++){
			sum = sum + Double.parseDouble(a[x]);
		}
		out.println("Summation = " + sum);
		sum = (Double)sum/(a.length);
		out.println("<br>Average = " + sum);
	}

}