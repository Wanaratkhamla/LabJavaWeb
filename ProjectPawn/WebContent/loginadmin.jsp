<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<title>Login Admin</title>
<link rel="stylesheet" href="css/style.css">
</head>
<STYLE TYPE="TEXT/CSS">
<!--
A:link {
	text-decoration: none;
}

A:visited {
	text-decoration: none;
}
//
-->
</STYLE>
<body>

	<div class="wrapper">
		<div class="container">
			<h1>ADMIN LOGIN</h1>

			<form class="form" action="login" method="post">
				<input type="hidden" name="action" value="doLogin" />
				<label class="block clearfix"> <span
					class="block input-icon input-icon-right"> <input
						type="text" name="username" class="form-control"
						placeholder="Username" required /> <i class="ace-icon fa fa-user"></i>
				</span></label> 
				<label class="block clearfix"> <span
					class="block input-icon input-icon-right"> <input
						type="password" name="password" class="form-control"
						placeholder="Password" required /> <i class="ace-icon fa fa-lock"></i>
				</span>
				</label>
				
				<button type="submit" id="login-button">Login</button>
				<br><br>
				<button>
					<a id="login-button" href="Main.jsp">Back</a>
				</button>
			</form>

			<form></form>
		</div>

		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>





</body>
</html>
