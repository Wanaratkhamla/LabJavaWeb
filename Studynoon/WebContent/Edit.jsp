<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta charset="utf-8" />
<title>Edit Product</title>
</head>
<body>
	<h1>แก้ไขสินค้า</h1>
	<%
		String pid = request.getParameter("pid");
		Connection connect = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/blueshop?characterEncoding=utf-8" + "&user=root&password=");
			s = connect.createStatement();

			String sql = "SELECT * FROM product WHERE pid = " + pid;

			ResultSet pro = s.executeQuery(sql);

			while ((pro != null) && (pro.next())) {
	%>
	<form method="POST" action="ProductCtrl">
		<input type="hidden" name="action" value="edit"> <input
			type="hidden" name="pid" value=<%=pro.getInt("pid")%>>
		ชื่อสินค้า : <input type="text" name="pname"
			value=<%=pro.getString("pname")%>> <br> รายละเอียดสินค้า
		:
		<textarea name="pdetail"><%=pro.getString("pdetail")%></textarea>
		<br> ราคาสินค้า : <input type="text" name="price"
			value=<%=pro.getInt("price")%>><br>
		<button type="submit">บันทึกข้อมูล</button>
	</form>
	<%
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			if (s != null) {
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