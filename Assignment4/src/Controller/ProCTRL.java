package Controller;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;

/**
 * Servlet implementation class ProCTRL
 */
@WebServlet("/ProCTRL")
public class ProCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection Com;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProCTRL() {
        super();
        Com = ConnectDatabase.getConnection();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDBS pro = new ProductDBS();
		pro.showproduct(request, response);
	}

}
