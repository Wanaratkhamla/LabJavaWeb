<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
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
								<strong>
									<?php echo $_SESSION["user"]?>
								</strong>
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
					<div class="col-lg-12">
						<div class="panel panel-primary" align="center">
							<div class="panel-heading">
								<i class="fa fa-bar-chart-o fa-fw"></i>สินค้าหลุดจำนำ

							</div>
						</div>
					</div>

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<div class="table-responsive">
									<table class="table table-bordered table-hover table-striped">
										<thead>
											<tr>
												<th>เลขที่ใบจำนำ</th>
												<!-- PawnID-->
												<th>รหัสสินค้า</th>
												<!-- ProductID-->
												<th>รหัสลูกค้า</th>
												<!-- CustomersID-->
												<th>ชื่อสินค้า</th>
												<!-- ProductName-->
												<th>รายละเอียดสินค้า</th>
												<!-- ProductDescription-->
												<th>ราคาสินค้า</th>
												<!-- ProductPrice-->
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${productUnpawn}" var="list">
												<tr>
													<td>${list.pawnID }</td>
													<td>${list.productID }</td>
													<td>${list.customersID }</td>
													<td>${list.productName }</td>
													<td>${list.productDescription }</td>
													<td>${list.productPrice }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
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
