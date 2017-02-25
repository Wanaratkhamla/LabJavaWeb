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

			<li><a href="#">Show Cart for User.</a></li>

		</ul>
		<!-- /.breadcrumb -->
	</layout:put>

	<layout:put block="body">

		<!-- /section:settings.box -->
		<div class="page-header">
			<h1>
				User Page <small> <i
					class="ace-icon fa fa-angle-double-right"></i> you can view Cart in
					this page.
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
						<c:forEach items="${cartDetail}" var="list">
						<br />
						<ul class="nav nav-tabs padding-18">
							<!-- <li class="active"><a data-toggle="tab" href="#home"> <i
									class="green ace-icon fa fa-user bigger-120"></i> Profile
							</a></li> -->
							<div class="row">
								<div class="col-xs-12 col-sm-2 center">
									<span class="profile-picture"> 
									<img class="editable img-responsive" alt="Alex's Avatar" id="avatar2" src="${list.photosrc }" />
									</span>

									<div class="space space-4"></div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<p><h4>${list.productDescription }</h4></p>
								</div>
								<div class="col-xs-12 col-sm-2">
									<p>ราคา/ชิ้น : <h4>${list.productPrice }</h4></p>
								</div>
								<div class="col-xs-12 col-sm-1">
									<p>จำนวน  
									<form action="CartOrderCtrl">
									<input type="hidden" name="action" value="updateorder" />
									<input type="hidden" name="OrderID" value="${list.orderID }" />
									<input type="hidden" name="CartID" value="${list.cartID }" />
									<input type="hidden" name="ProductPrice" value="${list.productPrice }" />
									<input type="hidden" name="OrderTotalproduct" value="${list.orderTotalproduct }" />
									<input type="hidden" name="CartTotalProduct" value="${list.cartTotalProduct }" />
									<input type="hidden" name="CartTotalPrice" value="${list.cartTotalPrice }" />
									<input type="hidden" name="Username" value="${sessionScope.Username }" />
									<input type="number" class="form-control" name="Number" value="${list.orderTotalproduct }" max="10" min="0" />
								
									</form>
									</p>
								</div>
								<div class="col-xs-12 col-sm-2">
									<p>ราคารวม : <h4>${list.orderTotalPrice }</h4></p>
								</div>
								<div class="col-xs-12 col-sm-1">
								<form action="CartOrderCtrl">
									<input type="hidden" name="action" value="DeleteOrder" />
									<input type="hidden" name="OrderID" value="${list.orderID }" />
									<input type="hidden" name="CartID" value="${list.cartID }" />
									<input type="hidden" name="OrderTotalPrice" value="${list.orderTotalPrice }" />
									<input type="hidden" name="OrderTotalproduct" value="${list.orderTotalproduct }" />
									<input type="hidden" name="CartTotalProduct" value="${list.cartTotalProduct }" />
									<input type="hidden" name="CartTotalPrice" value="${list.cartTotalPrice }" />
									<input type="hidden" name="Username" value="${sessionScope.Username }" />
									<button class="btn btn-danger fa fa-trash-o fa-2x"></button>
								</form>
								</div>
								<!-- /.col -->
							</div>
							<!-- <li><a data-toggle="tab" href="#feed"> <i
									class="orange ace-icon fa fa-rss bigger-120"></i> Ticket
							</a></li> -->
						</ul>
						</c:forEach>
						<ul class="">
							<div class="col-xs-12 col-sm-7">
							</div>
							<div class="col-xs-12 col-sm-2">
							<p><h4>รวม : </h4></p>
							</div>
							<div class="col-xs-12 col-sm-2">
									<p><h4>${cartTotalPrice }</h4></p>
							</div>
							<div class="col-xs-12 col-sm-1">
							</div>
						</ul>
					</div>
				</div>
			</div>


		</div>
		</div>

	</layout:put>
</layout:extends>