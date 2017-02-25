package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testcsv2
 */
@WebServlet("/testcsv2")
public class testcsv2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testcsv2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Disposition", "attachment;filename='product.csv'");
		response.setContentType("text/csv; charset=tis-620");
		
		PrintWriter out = response.getWriter();
		out.println("emp_id,emp_name,salary");
		out.println("e01,มานี,30000");
		out.println("e02,ชูใจ,15000");
		out.println("e03,ปิติ,43000");
	}

}
