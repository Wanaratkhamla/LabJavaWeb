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
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">สมัคร สมาชิก ใช้งาน E-Learning kku</h1>
	<div align="center">
		<form method="POST" action="Register" id="myform">
			<input type="hidden" name="action" value="register">
			รหัสนักศึกษา : <input type="text" name="SID"
				placeholder="573021111-7" required="required"><br> รหัสผ่าย :<input
				type="password" name="Password" required="required"> <br>ยืนยันรหัสผ่าน : <input
				type="password" name="Password1" required="required"><br> ชื่อ : <input
				type="text" name="fname" placeholder="วนราช" required="required"><br>
			นามสกุล : <input type="text" name="lname" placeholder="คำหล้า" required="required"><br>

			<%
				Connection connect = null;
				Statement s = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					connect = DriverManager.getConnection(
							"jdbc:mysql://localhost/testjoin?characterEncoding=utf-8" + "&user=root&password=");
					s = connect.createStatement();
					String sql = "SELECT * FROM departmant";

					ResultSet depart = s.executeQuery(sql);
			%>
			สาขาเรียน : <select name="department">
				<%
					while ((depart != null) && (depart.next())) {
				%>
				<option value=<%=depart.getInt("departmantID")%>><%=depart.getString("departmantName")%></option>

				<%
					}
				%>
			</select><br>
			<%
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					out.println(e.getMessage());
					e.printStackTrace();
				}
			%>
			<button type="submit">สมัครสมาชิก</button>
			<button type="button" onclick="myFunction()">Reset</button>
		</form>
	</div>
	<script>
		function myFunction() {
			document.getElementById("myForm").reset();
		}
	</script>
</body>
</html>