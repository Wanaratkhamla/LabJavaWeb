package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Testredi2
 */
@WebServlet("/Testredi")
public class Testredi2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testredi2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String inputUsername = request.getParameter("Username");
		String inputPassword = request.getParameter("Password");
		
		if (inputUsername.equals("bobby") && inputPassword.equals("1234")) {
			response.sendRedirect("main");
		}else{
			response.sendRedirect("Testredi.jsp");
		}
	}

}
