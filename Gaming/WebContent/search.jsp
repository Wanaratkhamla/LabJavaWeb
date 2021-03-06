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

			<li><a href="#">Search</a></li>

		</ul>
		<!-- /.breadcrumb -->
	</layout:put>

	<layout:put block="body">

		<div class="row">
			<c:forEach items="${producttype}" var="list">
				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="${list.photosrc}" alt="" height="600" width="600" />
						<div class="caption">
							<h4 class="pull-right">฿${list.productPrice }</h4>
							<h4>
								<a href="#">${list.productName }</a>
							</h4>
							<p>${list.productDescription }</p>
						</div>
						<div class="ratings">
							<c:if test="${sessionScope.Type == 'admin'}">
								
								<form action="Product">
									<p class="pull-right">จำนวน : ${list.productNumber }</p>
									<input type="hidden" name="action" value="ShowProEdit" /> 
									<input type="hidden" name="Username" value="${sessionScope.Username }" />
									<input type="hidden" name="productID" value="${list.productID }" />  
									<input type="hidden" name="brandID" value="${list.brandID }" />
									<input type="hidden" name="typeID" value="${list.typeID }" />
									<input type="hidden" name="productName" value="${list.productName }" />
									<input type="hidden" name="productPrice" value="${list.productPrice }" />
									<input type="hidden" name="productNumber" value="${list.productNumber }" />
									<input type="hidden" name="productDescription" value="${list.productDescription }" />
									<%-- <input type="hidden" name="photosrc" value="${list.photosrc }" />  --%>
									<p>
									<button type="submit" class="btn btn-white btn-warning btn-sm">
										<span class="fa fa-cogs fa-2x"></span>
									</button>
									</p>
								</form>
								
								
							</c:if>
							<c:if test="${sessionScope.Type == 'user'}">
								<form action="CartOrderCtrl">
								<p class="pull-right">
									<input type="hidden" name="action" value="InsertCartANDorder" /> <input
										type="hidden" name="Username"
										value="${sessionScope.Username }" /> <input type="hidden"
										name="productID" value="${list.productID }" /> <input
										type="hidden" name="price" value="${list.productPrice }" />

									<button type="submit"
										class="btn btn-white btn-warning btn-sm">
										<span class="fa fa-shopping-cart fa-2x"></span>
									</button>
								</p>
									<p>
									<span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
										<%-- <input type="number" name="number" value="1" min="1"
											max="${list.productNumber }"> --%>
									</p>
								</form>
							</c:if>
							<!-- /.CartOrderCtrl -->
						</div>
					</div>
				</div>
			</c:forEach>

		</div>


	</layout:put>
</layout:extends>