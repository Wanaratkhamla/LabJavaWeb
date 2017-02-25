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
	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/blueshop?characterEncoding=utf-8"
		user="root" password="" />

	<%
		String get = new String(request.getParameter("pid").getBytes("ISO8859_1"), "utf-8");
		int get2 = Integer.parseInt(get);
	%>

	<sql:query var="listproduct" dataSource="${myDS}">
        SELECT * FROM product WHERE pid=<%=get2%>;
        </sql:query>
        
	<c:forEach var="pro" items="${listproduct.rows}">
		<form method='POST' action="./EditDB.jsp">
			<input type='hidden' name='pid' value="${pro.pid}" /> ชื่อสินค้า : <input
				type='text' name='pname' value="${pro.pname}"><br>
			รายละเอียดสินค้า :
			<textarea rows='4' cols='50' name='pdetail'>${pro.pdetail}</textarea>
			<br> ราคา : <input type='text' name='price' value="${pro.price}"><br>
			<button type='submit'>แก้ไขสินค้า</button>
		</form>
	</c:forEach>
</body>
</html>