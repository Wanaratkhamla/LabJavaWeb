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
<title>Insert Product</title>
</head>
<body>
	<form method="post" action="insert">
		<input type='hidden' name='action' value="insert"> ชื่อสินค้า
		: <input type='text' name='pname'><br>
		รายละเอียดสินค้า :
		<textarea rows='4' cols='50' name='pdetail'></textarea>
		<br> ราคา : <input type='text' name='price'><br>
		<button type='submit'>เพิ่มสินค้า</button>
	</form>
</body>
</html>