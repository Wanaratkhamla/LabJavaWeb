<%@page import="java.util.ArrayList"%>
<%@page import="Model.StudentDapart"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Profile Student</h1>
	<% StudentDapart studentDapart = new StudentDapart();
	StudentDapart ob2 = (StudentDapart)request.getAttribute("nos");%>
		<h1><%=ob2.getSID() %></h1><br>
		<h1><%=ob2.getFname() %></h1><br>
		<h1><%=ob2.getLname() %></h1><br>
		<h1><%=ob2.getDepartmantName() %></h1><br>
		
		<button type="button" onclick="window.location.href='logout?action=logout'">Register</button>
</body>
</html>