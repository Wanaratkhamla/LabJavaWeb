package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.NoteDAO;

/**
 * Servlet implementation class NoteController
 */
@WebServlet("/NoteController")
public class NoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String check = request.getParameter("action");
		NoteDAO note = new NoteDAO();
		if(check.equals("delete")){
			String get = new String(request.getParameter("nid").getBytes("ISO8859_1"), "utf-8");
			note.Deletetask(get);
			response.sendRedirect("result.jsp");
		}
		if(check.equals("insert")){
			String get = new String(request.getParameter("string").getBytes("ISO8859_1"), "utf-8");
			note.inserttask(get);
			response.sendRedirect("result.jsp");
		}
	}

}
