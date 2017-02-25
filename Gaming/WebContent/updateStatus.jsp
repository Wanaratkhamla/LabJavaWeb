<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ page import="model.*"%>
<layout:extends name="main.jsp">

	<layout:put block="showThis">
		<ul class="breadcrumb">
			<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
			</li>

			<li><a href="#">Update status Admin.</a></li>

		</ul>
		<!-- /.breadcrumb -->
	</layout:put>

	<layout:put block="body">

		<!-- /section:settings.box -->
		<div class="page-header">
			<h1>
				Admin Page <small> <i
					class="ace-icon fa fa-angle-double-right"></i> You can update
					status in this page.
				</small>
			</h1>
		</div>
		<!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">

				<div id="user-profile-2" class="user-profile">
					<div class="tabbable">
						<ul class="nav nav-tabs padding-18">
							<!-- <li class="active"><a data-toggle="tab" href="#home"> <i
									class="green ace-icon fa fa-user bigger-120"></i> Profile
							</a></li> -->

							<li><a data-toggle="tab" href="#friends"> <i
									class="blue ace-icon fa fa-users bigger-120"></i> Show Carts.
							</a></li>

							<!-- <li><a data-toggle="tab" href="#feed"> <i
									class="orange ace-icon fa fa-rss bigger-120"></i> Ticket
							</a></li> -->

						</ul>

						<br />
						<ul class="nav nav-tabs padding-18">
							<!-- <li class="active"><a data-toggle="tab" href="#home"> <i
									class="green ace-icon fa fa-user bigger-120"></i> Profile
							</a></li> -->
							<div class="row">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>ชื่อผู้สั่ง</th>
											<th>วันที่สั่ง</th>
											<th></th>
											<th>ราคารวม</th>
											<th>สถานะการจ่าย</th>
											<th>อัพเดทสถานะ</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${showCart}" var="list">
											<tr>
												<th>${list.cartID }</th>
												<td>${list.username }</td>
												<td>${list.cartOrderdate }</td>
																																		
												<td></td>
												<td>${list.cartTotalPrice }</td>
												<th><c:if test="${list.cartStatus == 0}">ยังไม่จ่าย</c:if><c:if test="${list.cartStatus == 1}">จ่ายแล้ว</c:if></th>
												<td>
												<c:if test="${list.cartStatus == 0}"><form action="CartOrderCtrl">
														<input type="hidden" name="action" value="UpdatePaystatus" />
														<input type="hidden" name="CartID" value="${list.cartID }" />
														<button class="btn btn-white btn-success"><i class="ace-icon fa fa-floppy-o bigger-120 blue"></i></button>
												</form></c:if>
												</td>
											</tr>
										</c:forEach>
								</table>
								</tbody>

							</div>
							<!-- <li><a data-toggle="tab" href="#feed"> <i
									class="orange ace-icon fa fa-rss bigger-120"></i> Ticket
							</a></li> -->
						</ul>
					</div>
				</div>
			</div>


		</div>
		</div>

	</layout:put>
</layout:extends>