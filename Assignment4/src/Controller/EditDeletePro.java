package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

import Model.ProductDBS;

/**
 * Servlet implementation class EditDeletePro
 */

@WebServlet({"/Edit", "/DeletePro" , "/SelectPid"})
public class EditDeletePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDeletePro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if (action.equals("selectpid")) {
			String get1 = new String(request.getParameter("pid").getBytes("ISO8859_1"),"utf-8");
			int pid = Integer.parseInt(get1);
			ProductDBS pro = new ProductDBS();
			pro.selectPro(request, response, pid);
			
			
			
		}
		if (action.equals("delete")) {
			String get1 = new String(request.getParameter("pid").getBytes("ISO8859_1"),"utf-8");
			int pid = Integer.parseInt(get1);
			ProductDBS pro = new ProductDBS();
			pro.deleteProductBy(pid);
			response.sendRedirect("ProCTRL");
		}
		
		if (action.equals("editpro")) {
			String g1 = new String(request.getParameter("pid").getBytes("ISO8859_1"),"utf-8");
			String g2 = new String(request.getParameter("pname").getBytes("ISO8859_1"),"utf-8");
			String g3 = new String(request.getParameter("pdetail").getBytes("ISO8859_1"),"utf-8");
			String g4 = new String(request.getParameter("price").getBytes("ISO8859_1"),"utf-8");
			int g11 = Integer.parseInt(g1);
			int g44 = Integer.parseInt(g4);
			ProductDBS prod = new ProductDBS();
			prod.editProduct(request, response, g11, g2, g3, g44);
			
		}
	}

}
