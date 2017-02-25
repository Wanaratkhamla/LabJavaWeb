<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="thaiShow">
	รับค่าไทย : <input type="text" name="send">
	รับค่าไทย2 : <input type="text" name="send2">
	<input type="submit">
	<p>ภาษาไทบ : <%= request.getAttribute("sum") %> </p>
	<p>ภาษาไทบ : <%= request.getAttribute("sum2") %> </p>
	</form>

</body>
</html>