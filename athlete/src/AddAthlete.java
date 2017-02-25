import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddAthlete")
public class AddAthlete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aname = request.getParameter("aname");
		int score = Integer.parseInt(request.getParameter("score"));
		Athlete athlete = new Athlete();
		athlete.setName(aname);
		athlete.setScore(score);
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Athlete> list = (ArrayList<Athlete>)session.getAttribute("aList");
		
		if (list==null) {
			list = new ArrayList<Athlete>();
			list.add(athlete);			
		} else {
			list.add(athlete);
		}	
		
		session.setAttribute("aList", list);
		response.sendRedirect("ListAthlete");
		
	}
}
