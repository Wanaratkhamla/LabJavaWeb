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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ADMINS</title>
<!-- Core CSS - Include with every page -->
<link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="assets/plugins/pace/pace-theme-big-counter.css"
	rel="stylesheet" />
<link href="assets/css/style.css" rel="stylesheet" />
<link href="assets/css/main-style.css" rel="stylesheet" />
<!-- Page-Level CSS -->
<link href="assets/plugins/morris/morris-0.4.3.min.css" rel="stylesheet" />
</head>
<body>
	<!--  wrapper -->
	<div id="wrapper">
		<!-- navbar top -->

		<!-- end navbar top -->

		<!-- navbar side -->
		<nav class="navbar-default navbar-static-side" role="navigation">
		<!-- sidebar-collapse -->
		<div class="sidebar-collapse">
			<!-- side-menu -->
			<ul class="nav" id="side-menu">
				<li>
					<!-- user image section-->
					<div class="user-section">
						<div class="user-section-inner">
							<img src="assets/img/user.jpg" alt="">
						</div>
						<div class="user-info">
							<div>
								
							</div>
							<div class="user-text-online">
								<a class='btn-sm btn-danger' href="logout?action=logout" width='50px'>Logout</a>
								<br><br> 	
								${sessionScope.Username}
							</div>
						</div>
					</div> <!--end user image section-->
				</li>
				<li class="sidebar-search">
					<!-- search section--> <!--end search section-->
				</li>
				<li class="selected"><c:choose>
						<c:when test="${sessionScope.Username==null }">
							<a href="loginadmin.jsp">
						</c:when>
						<c:otherwise>
							<a href="adminpawn.jsp">
						</c:otherwise>
					</c:choose><i class="fa fa-dashboard fa-fw"></i>รับจำนำสินค้า</a></li>
				<li class="selected"><c:choose>
						<c:when test="${sessionScope.Username==null }">
							<a href="loginadmin.jsp">
						</c:when>
						<c:otherwise>
							<a href="adminbuypawn.jsp">
						</c:otherwise>
					</c:choose><i
						class="fa fa-dashboard fa-fw"></i>ไถ่ถอนการจำนำ</a></li>
				<li class="selected"><c:choose>
						<c:when test="${sessionScope.Username==null }">
							<a href="loginadmin.jsp">
						</c:when>
						<c:otherwise>
							<a href="UnPawn?action=ShowproductUnPawn">
						</c:otherwise>
					</c:choose><i
						class="fa fa-dashboard fa-fw"></i>สินค้าหลุดจำนำ</a></li>
				<li class="selected"><c:choose>
						<c:when test="${sessionScope.Username==null }">
							<a href="loginadmin.jsp">
						</c:when>
						<c:otherwise>
							<a href="Showreport?action=Showreport">
						</c:otherwise>
					</c:choose><i
						class="fa fa-dashboard fa-fw"></i>Report Pawn</a></li>
				<li class="selected"><c:choose>
						<c:when test="${sessionScope.Username==null }">
							<a href="loginadmin.jsp">
						</c:when>
						<c:otherwise>
							<a href="Listpawn?action=Showpawn">
						</c:otherwise>
					</c:choose><i
						class="fa fa-dashboard fa-fw"></i>list Pawn</a></li>


			</ul>
			<!-- end side-menu -->
		</div>
		<!-- end sidebar-collapse --> </nav>
		<!-- end navbar side -->
		<!--  page-wrapper -->
		<div id="page-wrapper">

			<div class="row">
				<!-- Page Header -->
				<div class="col-lg-12">
					<h1 class="page-header">รับจำนำสินค้า</h1>
				</div>
				<!--End Page Header -->
			</div>
			<div class="row">
				<div class="col-lg-10">
					<!--Area chart example -->
					<div class="panel panel-primary">
						<div class="panel-heading">
							<i class="fa fa-bar-chart-o fa-fw"></i>กรุณากรอกข้อมูลให้ครบ

						</div>
						<form action="PawnInsert" method="post">
							<input type="hidden" name="action" value="InsertPawnandcustomer" />
							<div class="col-lg-4">

								<div class="form-group">
									<label for="disabledTextInput">บัตรประชาชน 13 หลัก</label> <input
										type="text" id="disabledTextInput" class="form-control"
										placeholder="1111111111111" name="CustomersID"
										required="required" pattern=".{13,13}">
								</div>

								<div class="form-group">
									<label for="disabledTextInput">ชื่อ - สกุล</label> <input
										type="text" id="disabledTextInput" class="form-control"
										placeholder="นายบิว มีชัย" name="Name" pattern=".{1,50}"
										required="required">
								</div>

								<div class="form-group">
									<label for="disabledTextInput">ที่อยู่ที่ติดต่อได้</label> <input
										type="text" id="disabledTextInput" class="form-control"
										placeholder="118 ถ.มิตรภาพ" name="Address" required="required">
								</div>

								<div class="form-group">
									<label for="disabledTextInput">เบอร์โทรศัพท์</label> <input
										type="text" id="disabledTextInput" class="form-control"
										placeholder="0827894561" name="PhoneNo" required="required">
								</div>

								<div class="form-group">
									<label for="disabledTextInput">เลขรหัสสินค้า เช่น
										บาโค้ด หรือ เลขตัวเครื่อง</label> <input type="text"
										id="disabledTextInput" class="form-control"
										placeholder="8850000111112" name="ProductID"
										required="required">
								</div>

								<div class="form-group">
									<label for="disabledTextInput">สินค้าที่นำมาจำนำ</label> <input
										type="text" id="disabledTextInput" class="form-control"
										placeholder="มือถือ" name="ProductName" required="required">
								</div>

								<div class="form-group">
									<label for="disabledTextInput">ราคาสินค้า</label> <input
										type="text" id="disabledTextInput" class="form-control"
										placeholder="590(บาท)" name="ProductPrice" required="required">
								</div>

								<div class="form-group">
									<label for="disabledTextInput">รายละเอียดสินค้า</label> <input
										type="text" id="disabledTextInput" class="form-control"
										placeholder="Samsung J7" name="ProductDescription"
										required="required">
								</div>

								<div class="form-group">
									<label for="disabledTextInput">ระยะเวลาการจำนำ</label> <input
										type="date" id="disabledTextInput" class="form-control"
										name="PawnDateEnd" required="required">
								</div>

								<button type="submit" class="btn btn-primary">Submit</button>
						</form>
						<br>
						<div class="panel-heading">
							<br> <i class="fa fa-bar-chart-o fa-fw"></i>ดอกเบี้ย 10 %
							ของราคาสินค้า
						</div>
					</div>
				</div>


			</div>

		</div>

	</div>

	</div>
	</div>

	<!--End simple table example -->

	</div>


	</div>
	<!--End Chat Panel Example-->
	</div>
	</div>





	</div>
	<!-- end page-wrapper -->

	</div>
	<!-- end wrapper -->

	<!-- Core Scripts - Include with every page -->
	<script src="assets/plugins/jquery-1.10.2.js"></script>
	<script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
	<script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="assets/plugins/pace/pace.js"></script>
	<script src="assets/scripts/siminta.js"></script>
	<!-- Page-Level Plugin Scripts-->
	<script src="assets/plugins/morris/raphael-2.1.0.min.js"></script>
	<script src="assets/plugins/morris/morris.js"></script>
	<script src="assets/scripts/dashboard-demo.js"></script>

</body>

</html>
