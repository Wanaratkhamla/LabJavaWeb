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

			<li><a href="#">Edit product for Admin.</a></li>

		</ul>
		<!-- /.breadcrumb -->
	</layout:put>

	<layout:put block="body">

		<!-- /section:settings.box -->
		<div class="page-header">
			<h1>
				Admin Profile Page <small> <i
					class="ace-icon fa fa-angle-double-right"></i> you can edit product in this page.
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
									class="blue ace-icon fa fa-users bigger-120"></i> Edit Profile
							</a></li>

							<!-- <li><a data-toggle="tab" href="#feed"> <i
									class="orange ace-icon fa fa-rss bigger-120"></i> Ticket
							</a></li> -->

						</ul>

						<div class="tab-content no-border padding-24">

							<div id="friends" class="tab-pane in active">
								<!-- #section:pages/profile.friends -->
								<div class="row">
									<div class="col-xs-12 col-sm-3 center">
										<span class="profile-picture"> <img
											class="editable img-responsive" alt="Alex's Avatar"
											id="avatar2" src="bootstrap/avatars/profile-pic.jpg" />
										</span>

										<div class="space space-4"></div>

										<button class="btn btn-sm btn-block btn-success">
											<i class="ace-icon fa fa-plus-circle bigger-120"></i> <span
												class="bigger-110">Hello ${sessionScope.Name}</span>
										</button>

										<a href="mailto://${sessionScope.E-mail }"
											class="btn btn-sm btn-block btn-primary"> <i
											class="ace-icon fa fa-envelope-o bigger-110"></i> <span
											class="bigger-110">Send a message</span>
										</a>
									</div>
									<!-- /.col -->

									<div class="col-xs-12 col-sm-9">
										<h2 class="blue">
											<span class="middle">Edit Product</span>

										</h2>
										<form action="Product" method="GET"">
											<input type="hidden" name="action" value="editPro" />
											<input type="hidden" name="productID" value="${productID }" />
										
											<div class="profile-user-info">
												<div class="profile-info-row">
													<div class="profile-info-name">BrandName</div>
													<div class="profile-info-value">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <select
																name='brandid'>
																	<option>"'--กรุณาเลือก--'"</option>
																	<option value="1">CMStorm</option>
																	<option value="22">SteelSeries</option>
																	<option value="3">Cougar</option>
																	<option value="4">Ducky</option>
																	<option value="5">E-Blue</option>
																	<option value="6">Filco</option>
																	<option value="9">Logitech</option>
																	<option value="11">microsoft</option>
																	<option value="17">pentagonz-banner</option>
																	<option value="18">rapoo</option>
																	<option value="19">Razer</option>
																	<option value="21">Sennheiser</option>
																	<option value="24">Thrustmaster</option>
																	<option value="25">Ttesports</option>
															</select>

														</span>
														</label>
													</div>
												</div>



												<div class="profile-info-row">
													<div class="profile-info-name">Type</div>
													<div class="profile-info-value">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <select
																name='typeid'>
																	<option >"'--กรุณาเลือก--'"</option>
																	<option value="1">accessaries</option>
																	<option value="2">Earphone</option>
																	<option value="3">joy strick</option>
																	<option value="4">keyboard</option>
																	<option value="5">mouse</option>
																	<option value="6">over ear</option>
																	<option value="7">speaker</option>
																	<option value="8">webcam</option>
															</select>

														</span>
														</label>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Product-Name</div>
													<div class="profile-info-value">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <input
																type="text" name="productName" class="form-control"
																value="${productName }" required /> <i
																class="ace-icon fa  fa-cloud-download"></i>
														</span>
														</label>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Price</div>

													<div class="profile-info-value">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <input
																type="text" name="productPrice" class="form-control"
																value="${productPrice }" required /> <i
																class="ace-icon fa fa-cloud-upload"></i>
														</span>
														</label>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Number</div>

													<div class="profile-info-value">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <input
																type="text" name="productNumber" class="form-control"
																value="${productNumber }" required /> <i
																class="ace-icon fa fa-map-marker"></i>
														</span>
														</label>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Description</div>

													<div class="profile-info-value">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <input
																type="text" name="productDescription"
																class="form-control" value="${productDescription }" required /> <i
																class="ace-icon fa fa-comments"></i>
														</span>
														</label>
													</div>
												</div>

												<%-- <div class="profile-info-row">
													<div class="profile-info-name">Photo</div>
													<div class="profile-info-value">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <input
																type="file" name="ProductPhoto" class="form-control"
																value="${profile.tel }"/> <i
																class="ace-icon fa fa-comments"></i>
														</span>
														</label>
													</div>
												</div> --%>

												<div class="profile-info-row">
													<div class="profile-info-name"></div>
													<div class="profile-info-value">
														<button type="submit" action="register"
															class="width-65 pull-right btn btn-sm btn-success">
															<span class="bigger-110">Edit Product</span> <i
																class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
													</div>

												</div>
											</div>
										</form>

										<div class="hr hr-8 dotted"></div>

									</div>
									<!-- /.col -->
								</div>
								<!-- /.row -->
							</div>
							<!-- /#friends -->

						
					</div>
				</div>
			</div>


		</div>
		</div>

	</layout:put>
</layout:extends>