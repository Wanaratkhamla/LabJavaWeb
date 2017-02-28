<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="utf-8">
<title>Assignment5</title>
</head>
<body>
	<%
		Connection connect = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/blueshop?characterEncoding=utf-8" + "&user=root&password=");
			s = connect.createStatement();

			String sql = "SELECT * FROM product";

			ResultSet pro = s.executeQuery(sql);
	%>

	<form method="POST" action="ProductCtrl">
		<input type="hidden" name="action" value="search"> <input
			type="text" name="string">
		<button type="summit">ค้นหา</button>
	</form>
	<a href='Insert.jsp'>เพิ่มสินค้า</a>
	<br>

	<table border="1" cellpadding="5">
		<tr>
			<td>รหัส</td>
			<td>ชื่อ</td>
			<td>รายละเอียด</td>
			<td>ราคา</td>
		</tr>

		<%
			while ((pro != null) && (pro.next())) {
		%>
		<tr>
			<td align="center"><%=pro.getInt("pid")%></td>
			<td align="center"><%=pro.getString("pname")%></td>
			<td align="center"><%=pro.getString("pdetail")%></td>
			<td align="center"><%=pro.getInt("price")%></td>
			<td><a
				href="ProductCtrl?pid=<%=pro.getInt("pid")%>&action=delete">ลบ</a></td>
			<td><a href="Edit.jsp?pid=<%=pro.getInt("pid")%>">แก้ไข</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
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