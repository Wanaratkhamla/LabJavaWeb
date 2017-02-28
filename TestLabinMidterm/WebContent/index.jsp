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
<title>แสดงความคิดเห็น</title>
</head>
<body>

	<h3 align="center">คุณคิดเห็นอย่างไร ?</h3>
	<br>
	<%
		Connection connect = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/forum?characterEncoding=utf-8" + "&user=root&password=");
			s = connect.createStatement();

			String sql = "SELECT * FROM forum";

			ResultSet forum = s.executeQuery(sql);
			while ((forum != null) && (forum.next())) {
	%>
	<p align="center">
		<i> <%=forum.getString("detail")%></i>
	</p>
	<p align="center">
		<i> โดย <%=forum.getString("author")%> <%=forum.getString("post_date")%></i>
	</p>
	<p align="center">
		<i> <%=forum.getInt("love")%> <a
			href="ForumController?action=updatelove&fid=<%=forum.getInt("fid")%>&update=<%=forum.getInt("love") + 1%>">love</a></i>
	</p>
	<br>
	<br>
	<br>


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

	<br>


	<div align="center">
		<form method="POST" action="ForumController">
			<h2 align="center">แสดงความคิดเห็น</h2>
			<input type="hidden" name="action" value="insertForum">
			<textarea rows="5" cols="50" placeholder="แสดงความคิดเห็น"
				name="detail"></textarea>
			<br> <input type="text" name="username" placeholder="ชื่อ"
				size="50"><br>
			<button type="summit">ส่ง</button>
		</form>
	</div>

</body>
</html>