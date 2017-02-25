<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<title>Assignment1</title>
</head>
<body>
	<form action="Assignment1">
		ความยาวฐาน : <input type="text" name="height">
		
		&nbsp ส่วนสูง : <input type="text" name="base"><br> 
		<input type="submit">
		<br>
		<p>พื้นที่สามเหลี่ยม คือ  <%= request.getAttribute("sum") %> </p>
	</form>
</body>
</html>