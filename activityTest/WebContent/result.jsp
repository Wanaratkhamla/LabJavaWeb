<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta charset="utf-8" />
<title>Insert title here</title>
</head>
<body>
	<h1>THING TO DO</h1>
	<%
		Connection connect = null;
		Statement s = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/note?characterEncoding=utf-8" + "&user=root&password=");
			s = connect.createStatement();

			String sql = "SELECT * FROM note";

			ResultSet rec = s.executeQuery(sql);

			while ((rec != null) && (rec.next())) {
	%>
	<p>
		<b>* <%=rec.getString("task")%></b> <a
			href='NoteController?nid=<%=rec.getInt("nid")%>&action=delete'>ลบ</a>
	</p>

	<%
		}
	%>
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




	<%-- <sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/note?characterEncoding=utf-8" user="root"
		password="" />

	<sql:query var="listtask" dataSource="${myDS}">
        SELECT * FROM note;
        </sql:query>

	<div>
	
		<c:forEach var="task" items="${listtask.rows}">
			<p>
				<b>* ${task.task}</b> <a
					href='NoteController?nid=${task.nid}&action=delete'>ลบ</a>
			</p>
		</c:forEach>--%>


	<%-- <%
		ArrayList<Note> list = (ArrayList<Note>) request.getAttribute("notes");//request from NoteController
		for (int i = 0; i < list.size(); i++) {
			Note note = list.get(i);
			out.println(note.getNid());
			out.println(note.getTask());
			
			out.println("<a href='deletecontroller?nid="+ note.getNid() +"'>ลบ</a><br>");
			
		
		}
	%> --%>
	<form method='POST' action="NoteController">
		<input type='hidden' name='action' value='insert'> <input
			type='text' name='string'>
		<button type='submit'>note</button>
	</form>
	</div>
</body>
</html>