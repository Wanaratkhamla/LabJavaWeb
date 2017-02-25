package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assignment1
 */
@WebServlet("/Assignment1")
public class Assignment1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assignment1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputheight = request.getParameter("height");
		String inputbase = request.getParameter("base");
		
		double high = Double.parseDouble(inputheight);
		double base = Double.parseDouble(inputbase);
		double sum = high*base*(0.5);
		request.setAttribute("sum", sum);
		RequestDispatcher view = request.getRequestDispatcher("Assignment1.jsp");
		view.forward(request, response);
	}

}
