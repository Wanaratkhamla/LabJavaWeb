package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;


@WebServlet("/BrandCtrl")
public class BrandCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String) request.getParameter("action");
		//เป็นการดึงชื่อรายการขบวนรถไฟมาก่อนเพือไปแสดงในหน้า insertCar
		if (action.equals("insert")) {
			BrandDB db = new BrandDB();
			String BrandName = request.getParameter("BrandName");
			db.insertBrand(BrandName);
			response.sendRedirect("NewFile.jsp");
		}
	}

}
