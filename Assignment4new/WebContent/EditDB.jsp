<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%	
	Connection connect = null;
	Statement s = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connect =  DriverManager.getConnection("jdbc:mysql://localhost/blueshop?characterEncoding=utf-8" +
				"&user=root&password=");
		s = connect.createStatement();
		
		String pids = request.getParameter("pid");
		int get = Integer.parseInt(pids);
		String get1 = new String(request.getParameter("pname").getBytes("ISO8859_1"), "utf-8");
		String get2 = new String(request.getParameter("pdetail").getBytes("ISO8859_1"), "utf-8");
		String get3 = new String(request.getParameter("price").getBytes("ISO8859_1"), "utf-8");
		String sql1 = "UPDATE product " + "SET pname = '"+ get1 + "' " + ", pdetail = '"+ get2 + "' " + ", price = '"+ get3 + "' " + " WHERE pid = '" + get + "' ";
		
         s.execute(sql1);
         response.sendRedirect("Main.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			if(s!=null){
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	%>
</body>
</html>