

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ListAthlete")
public class ListAthlete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Athlete> list = (ArrayList<Athlete>)session.getAttribute("aList");
		if (list!=null) {
			int sum = 0;	
			
			out.println("<table border='1'><td>Name</td><td>Score</td></tr>");
			for(int i=0; i<list.size(); i++) {
				Athlete athlete = list.get(i);
				out.println("<tr><td>" + athlete.getName() + "</td>");
				out.println("<td>" + athlete.getScore() + "</td></tr>");
				sum = sum + athlete.getScore();
			}
			out.println("</table>");
			out.println("<br>Total score : " + sum);
			out.println("<br><a href='athlete.html'>Add Athlete</a>");

		} else {
			out.println("No any athlete<br>");
			out.println("<br><a href='athlete.html'>Add Athlete</a>");
		}
	}
}
