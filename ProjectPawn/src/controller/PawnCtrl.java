package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.*;

/**
 * Servlet implementation class PawnCtrl
 */
@WebServlet({"/PawnInsert", "/UnPawn", "/Listpawn", "/Buypawn", "/Showreport", "/Updatestatus"})
public class PawnCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
		/**
		 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
		 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		customersDB customersDB = new customersDB();
		pawnDB pawnDB = new pawnDB();
		productDB productDB = new productDB();
		reportDB reportDB = new reportDB();
		String action = request.getParameter("action");
		
		//ทำการเพิ่มการจำนำ โดยเพิ่มการจำนำและเพิ่มลูกค้า
		if(action.equals("InsertPawnandcustomer")){
			String CustomersID = new String(request.getParameter("CustomersID"));
			String Name = new String(request.getParameter("Name").getBytes("ISO8859_1"), "utf-8");
			String Address = new String(request.getParameter("Address").getBytes("ISO8859_1"), "utf-8");
			String PhoneNo = new String(request.getParameter("PhoneNo"));
			String ProductID = new String(request.getParameter("ProductID"));
			String ProductName = new String(request.getParameter("ProductName").getBytes("ISO8859_1"), "utf-8");
			double ProductPrice = Double.parseDouble(request.getParameter("ProductPrice"));
			String ProductDescription = new String(request.getParameter("ProductDescription").getBytes("ISO8859_1"), "utf-8");
			String PawnDateEnd = new String(request.getParameter("PawnDateEnd"));
			customers c = customersDB.CheckUser(CustomersID);
			String cid = c.getCustomersID();

			if (cid.equals(CustomersID)) {
			}else{
				customersDB.insertCustomers(CustomersID, Name, Address, PhoneNo);
			}
			product p = productDB.selectProduct(ProductID);
			String pid = p.getProductID();
			System.out.println(pid);
			if(pid.equals(ProductID))
			{
				response.sendRedirect("Checkproduct.jsp");
			}else{
				productDB.insertProductpawn(ProductID,ProductName, ProductPrice, ProductDescription);
				double Pawninterest = ProductPrice*((double)10/100);
				double PawnTotal = ProductPrice + Pawninterest;
				System.out.println(PawnTotal);
				pawnDB.insertpawn(ProductID, CustomersID, Pawninterest, PawnDateEnd);
				pawn q = pawnDB.selectpawnID(ProductID);
				System.out.println(q.getPawnID());
				pawnDB.updatepawntotal(q.getPawnID(), PawnTotal);
				response.sendRedirect("adminpawn.jsp");
			}
		}
		// เรียก สินค้าที่หลุดจำนำ
		else if (action.equals("ShowproductUnPawn")) {
			ArrayList<pawn> unpawn = new ArrayList<pawn>();
			unpawn = pawnDB.ViewproductUnpawn();

			ArrayList<pawnDetail> productUnpawn = new ArrayList<pawnDetail>();
			for (int i = 0; i < unpawn.size(); i++) {
				pawn o = unpawn.get(i);
				pawnDetail cd = new pawnDetail();
				cd.setPawnID(o.getPawnID());
				cd.setProductID(o.getProductID());
				cd.setCustomersID(o.getCustomersID());
				
				product a = productDB.selectProduct(o.getProductID());
				cd.setProductName(a.getProductName());
				cd.setProductDescription(a.getProductDescription());
				cd.setProductPrice(a.getProductPrice());
				productUnpawn.add(cd);

			}

			request.setAttribute("productUnpawn", productUnpawn);
			RequestDispatcher view = request.getRequestDispatcher("adminunpawn.jsp");
			view.forward(request, response);
			System.out.println(unpawn);
		}
		// เรียกlist การจำนำ
				else if (action.equals("Showpawn")) {
					ArrayList<pawn> pawnlist = new ArrayList<pawn>();
					pawnlist = pawnDB.Viewpawn();
					ArrayList<pawnDetail> listpawn = new ArrayList<pawnDetail>();
					for (int i = 0; i < pawnlist.size(); i++) {
						pawn o = pawnlist.get(i);
						pawnDetail cd = new pawnDetail();
						cd.setPawnID(o.getPawnID());
						cd.setProductID(o.getProductID());
						cd.setCustomersID(o.getCustomersID());
						cd.setPawnDate(o.getPawnDate());
						cd.setPawninterest(o.getPawninterest());
						cd.setPawnDateEnd(o.getPawnDateEnd());
						cd.setPawnstatus(o.getPawnstatus());
						cd.setPawnTotal(o.getPawnTotal());
						cd.setPawnpaid(o.getPawnpaid());
						
						customers u = customersDB.viewUser(o.getCustomersID());
						product a = productDB.selectProduct(o.getProductID());
						cd.setProductName(a.getProductName());
						cd.setProductDescription(a.getProductDescription());
						cd.setProductPrice(a.getProductPrice());
						cd.setName(u.getName());
						listpawn.add(cd);

					}

					request.setAttribute("listpawn", listpawn);
					RequestDispatcher view = request.getRequestDispatcher("adminlistpawn.jsp");
					view.forward(request, response);
				}
			//ไถ่ถอนการจำนำ
				else if(action.equals("Buypawn")){
					int PawnID = Integer.parseInt(request.getParameter("PawnID"));
					double reportpawnBuy = Double.parseDouble(request.getParameter("reportpawnBuy"));
					String reportpawnUserbuy = new String(request.getParameter("reportpawnUserbuy").getBytes("ISO8859_1"), "utf-8");
					String reportpawnAdmin = new String(request.getParameter("reportpawnAdmin").getBytes("ISO8859_1"), "utf-8");
					reportDB.insertreport(PawnID, reportpawnBuy, reportpawnUserbuy, reportpawnAdmin);
					pawn w = pawnDB.selectAlltablepawn(PawnID);
					double sum = w.getPawnpaid() + reportpawnBuy;
					pawnDB.updatepawnpaid(PawnID, sum);
					if(sum >= w.getPawnTotal()){
						pawnDB.updatePawnstatus(PawnID, 2);
					}else{
						pawnDB.updatePawnstatus(PawnID, 1);
					}
					response.sendRedirect("adminbuypawn.jsp");
				}
			//เรียกReport pawn
				else if (action.equals("Showreport")) {
					ArrayList<reportpawn> reportlist = new ArrayList<reportpawn>();
					reportlist = pawnDB.Viewreport();
					ArrayList<pawnDetail> listreport = new ArrayList<pawnDetail>();
					for (int i = 0; i < reportlist.size(); i++) {
						reportpawn o = reportlist.get(i);
						pawnDetail cd = new pawnDetail();
						cd.setReportID(o.getReportID());
						cd.setPawnID(o.getPawnID());
						cd.setReportpawnDate(o.getReportpawnDate());
						cd.setReportpawnBuy(o.getReportpawnBuy());
						cd.setReportpawnUserbuy(o.getReportpawnUserbuy());
						cd.setReportpawnAdmin(o.getReportpawnAdmin());
						listreport.add(cd);
					}
					request.setAttribute("listreport", listreport);
					RequestDispatcher view = request.getRequestDispatcher("adminreportpawn.jsp");
					view.forward(request, response);
				}
		//ใช้งานปุ่ม Update status
				else if(action.equals("Updatestatus")){
					int PawnID = Integer.parseInt(request.getParameter("pawnID"));
					int Pawnstatus = Integer.parseInt(request.getParameter("Pawnstatus"));
					
					System.out.println(Pawnstatus);
					pawnDB.updatePawnstatus(PawnID, Pawnstatus);
					
					ArrayList<pawn> pawnlist = new ArrayList<pawn>();
					pawnlist = pawnDB.Viewpawn();
					ArrayList<pawnDetail> listpawn = new ArrayList<pawnDetail>();
					for (int i = 0; i < pawnlist.size(); i++) {
						pawn o = pawnlist.get(i);
						pawnDetail cd = new pawnDetail();
						cd.setPawnID(o.getPawnID());
						cd.setProductID(o.getProductID());
						cd.setCustomersID(o.getCustomersID());
						cd.setPawnDate(o.getPawnDate());
						cd.setPawninterest(o.getPawninterest());
						cd.setPawnDateEnd(o.getPawnDateEnd());
						cd.setPawnstatus(o.getPawnstatus());
						cd.setPawnTotal(o.getPawnTotal());
						cd.setPawnpaid(o.getPawnpaid());
						
						customers u = customersDB.viewUser(o.getCustomersID());
						product a = productDB.selectProduct(o.getProductID());
						cd.setProductName(a.getProductName());
						cd.setProductDescription(a.getProductDescription());
						cd.setProductPrice(a.getProductPrice());
						cd.setName(u.getName());
						listpawn.add(cd);

					}

					request.setAttribute("listpawn", listpawn);
					RequestDispatcher view = request.getRequestDispatcher("adminlistpawn.jsp");
					view.forward(request, response);
				}
	}

}
