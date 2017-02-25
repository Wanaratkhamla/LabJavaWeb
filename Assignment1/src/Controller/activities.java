package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class activities
 */
@WebServlet("/activities")
public class activities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public activities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputUsername = request.getParameter("Username");
		String inputPassword = request.getParameter("Password");
		PrintWriter out = response.getWriter();
		
		if (inputUsername.equals("bobby") && inputPassword.equals("1234")) {
			out.println("<div style ='color:green'>Success^^</div>");
		}else{
			out.println("<div style ='color:red'>Incorect !!</div>");
		}
		
		
		
	}

}
