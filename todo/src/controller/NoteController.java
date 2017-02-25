package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Note;
import model.NoteDAO;

@WebServlet("/NoteController")
public class NoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteDAO notedao = new NoteDAO();
		ArrayList<Note> notes = notedao.getAllTask();
		
		request.setAttribute("notes", notes);
		
	    RequestDispatcher view = request.getRequestDispatcher("result.jsp");
	    view.forward(request, response);
	}
}
