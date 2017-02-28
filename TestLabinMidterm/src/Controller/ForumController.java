package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ForumDAO;

/**
 * Servlet implementation class ForumController
 */
@WebServlet("/ForumController")
public class ForumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForumController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		ForumDAO forum = new ForumDAO();
		if (action.equals("updatelove")) {
			String love = request.getParameter("update");
			String fid = request.getParameter("fid");
			System.out.println(love);
			System.out.println(fid);
			forum.updatelove(Integer.parseInt(love), Integer.parseInt(fid));
			response.sendRedirect("index.jsp");
		}
		if (action.equals("insertForum")) {
			String get = new String(request.getParameter("detail").getBytes("ISO8859_1"), "utf-8");
			String get1 = new String(request.getParameter("username").getBytes("ISO8859_1"), "utf-8");
			forum.insertforum(get, get1);
			response.sendRedirect("index.jsp");
		}
	}

}
