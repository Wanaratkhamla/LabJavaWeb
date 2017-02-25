

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assign1
 */
@WebServlet("/Assign1")
public class Assign1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assign1() {
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
		String S[] = request.getParameterValues("Sum");

		double sum = 0;
		PrintWriter out = response.getWriter();
		for (int i = 0; i < S.length; i++) {
			sum = sum + Double.parseDouble(S[i]);
		}
		out.println("Summation = " + sum);
		sum = (Double) sum / (S.length);
		out.println("<br>Average = " + sum);
	}

}
