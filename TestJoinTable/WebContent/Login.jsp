<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form method="POST" action="login" id="myForm">
			<h1>E learning KKU</h1>
			<input type="hidden" name="action" value="dologin">
			รหัสนักศึกษา : <input size="20" type="text" name="SID"
				placeholder="573021111-7" pattern="[0-9]{10}" title="5730211117"> <br> รหัสผ่าน : <input
				size="20" type="password" name="Password"> <br>
			<button type="submit">Login</button>
			<button type="button" onclick="window.location.href='Register.jsp'">Register</button>
			<input type="button" onclick="myFunction()" value="Reset form">
		</form>
	</div>
	<script>
		function myFunction() {
			document.getElementById("myForm").reset();
		}
	</script>
</body>
</html>