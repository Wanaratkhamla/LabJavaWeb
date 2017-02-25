<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />

<title>Gaming Gear - gaming for you</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="bootstrap/_assets/css/bootstrap.css" />
<link rel="stylesheet" href="bootstrap/_assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="bootstrap/_assets/css/font-awesome.css" />
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css" /> -->
<!-- Custom CSS -->
<link rel="stylesheet" href="bootstrap/_assets/css/shop-homepage.css" />
<!-- text fonts -->
<link rel="stylesheet" href="bootstrap/_assets/css/ace-fonts.css" />
<link rel="stylesheet" href="bootstrap/_assets/css/jquery-ui.custom.css" />
<!-- <link rel="stylesheet" href="bootstrap/_assets/css/datepicker.css" /> -->
<!-- ace styles -->
<!-- ace styles -->
<link rel="stylesheet" href="bootstrap/_assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
<!-- ace settings handler -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="bootstrap/_assets/js/ace-extra.js"></script>
</head>

<body class="no-skin">

	<!-- Navigation -->
	<!-- <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"> -->
<div id="navbar" class="navbar navbar-fixed-top">
  <script type="text/javascript">
      try{ace.settings.check('navbar' , 'fixed')}catch(e){}
</script>
  <div class="container" id="navbar-container">
  <!-- Brand and toggle get grouped for better mobile display -->
          <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
        <span class="sr-only">Toggle sidebar</span>

        <span class="icon-bar"></span>

        <span class="icon-bar"></span>

        <span class="icon-bar"></span>
      </button>

      <!-- /section:basics/sidebar.mobile.toggle -->
      <div class="navbar-header pull-left">
        <!-- #section:basics/navbar.layout.brand -->
        <a href="main" class="navbar-brand">
          <small>
            <i class="fa fa-leaf"></i>
            GG gaming
          </small>
        </a>

        <!-- /section:basics/navbar.layout.brand -->

        <!-- #section:basics/navbar.toggle -->

        <!-- /section:basics/navbar.toggle -->
      </div>
		<!-- Collect the nav links, forms, and other content for toggling -->
	<!-- 	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> -->
			<div class="navbar-buttons navbar-header pull-right" role="navigation">
				<c:if test="${sessionScope.Username==null }">
				<ul class="nav ace-nav">
						<!-- #section:basics/navbar.user_menu -->					
						<li class="light-blue">
							<a href="login">
									Sign In
								<i class="ace-icon fa fa-user-circle-o"></i>
							</a>
						</li>
						<!-- /section:basics/navbar.user_menu -->
					</ul>
					</c:if>
					<c:if test="${sessionScope.Username!=null }">
					<ul class="nav ace-nav">
						<%-- <c:if test="${sessionScope.Type == 'user'}">
						<li class="grey">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-shopping-cart icon-animated-vertical"></i>
								<span class="badge badge-danger">3</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-envelope-o"></i>
									3 list in cart
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar">

										<li>
											<a href="#" class="clearfix">
												<img src="bootstrap/_assets/avatars/avatar1.png" class="msg-photo" alt="Fred's Avatar" />
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">Fred:</span>
														Vestibulum id penatibus et auctor  ...
													</span>

													<span class="msg-time">
														<i class="ace-icon fa fa-clock-o"></i>
														<span>10:09 am</span>
													</span>
												</span>
											</a>
										</li>
										
									</ul>
								</li>

							</ul>
						</li>
						</c:if> --%>
						<!-- #section:basics/navbar.user_menu -->					
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="bootstrap/_assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									${sessionScope.Username}
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								
								<!-- <li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										Settings
									</a>
								</li>-->			
 								<c:if test="${sessionScope.Type == 'admin'}">
									<li>
										<a href="insertProduct.jsp">
											<i class="ace-icon fa fa-cloud-upload"></i>
											Insert Products
										</a>
									</li>
									<li>
										<a href="CartOrderCtrl?action=ShowAllCart">
											<i class="ace-icon fa fa-cloud-upload"></i>
											Update Status
										</a>
									</li>

								</c:if>
								<c:if test="${sessionScope.Type == 'user'}">
									<li>
										<a href="CartOrderCtrl?action=ShowOrderinCart&Username=${sessionScope.Username }">
											<i class="ace-icon fa fa-shopping-basket"></i>
											Your Cart
										</a>
									</li>

								</c:if>
								<li class="divider"></li>

								<li>
									<a href="logout?action=logout">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>

						<!-- /section:basics/navbar.user_menu -->
					</ul>
					</c:if>
				</div>
<%-- 		<div class="form-group">
					<c:if test="${sessionScope.Username==null }">
					<a href="login" class="navbar-form navbar-right"><button type="submit" class="btn btn-inverse">
					<i class="ace-icon fa fa-user bigger-125"></i>SIGN IN</button></a>
					</c:if>
					<c:if test="${sessionScope.Username!=null }">
					<a href="logout?action=logout" class="navbar-form navbar-right"><button type="submit" class="btn btn-danger">
					<i class="ace-icon fa fa-user bigger-125"></i>LOG OUT</button></a>
					<div class="btn-group navbar-form navbar-right">
												<button data-toggle="dropdown" class="btn btn-primary btn-white dropdown-toggle">
													Action
													<i class="ace-icon fa fa-angle-down icon-on-right"></i>
												</button>

												<ul class="dropdown-menu">
													<li>
														<a href="#">Action</a>
													</li>

													<li>
														<a href="#">Another action</a>
													</li>

													<li>
														<a href="#">Something else here</a>
													</li>

													<li class="divider"></li>

													<li>
														<a href="#">Separated link</a>
													</li>
												</ul>
											</div><!-- /.btn-group -->

					</c:if> 
			</div> --%>
			
			<!-- </form> -->
		</div>
		<!-- /.navbar-collapse -->

	</div>
	<!-- /.container --> 
	</div>
	<!-- </nav> -->

	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<div class="col-md-3">
				<p class="lead"><b>Types</b></p>
				<div class="list-group">
					<a href="Product?action=ShowProByType&typeid=4" class="list-group-item">คีย์บอร์ด</a>
					<a href="Product?action=ShowProByType&typeid=5" class="list-group-item">เมาส์</a>
					<a href="Product?action=ShowProByType&typeid=6" class="list-group-item">หูฟัง</a>
					<a href="Product?action=ShowProByType&typeid=2" class="list-group-item">หูฟัง in-ear</a>
					<a href="Product?action=ShowProByType&typeid=7" class="list-group-item">ลำโพง</a>
					<a href="Product?action=ShowProByType&typeid=3" class="list-group-item">จอยสติ๊ก</a>
					<a href="Product?action=ShowProByType&typeid=8" class="list-group-item">เว็บแคม</a>
					<a href="Product?action=ShowProByType&typeid=1" class="list-group-item">อุปกรณ์เสริม</a>
				</div>
				<p class="lead"><b>Brands</b></p>
				<div class="list-group">
					<a href="Product?action=ShowProByBrand&brandid=1" class="list-group-item"><img alt="CM-STORM" src="images/CMStorm.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=22" class="list-group-item"><img alt="CM-STORM" src="images/SteelSeries.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=3" class="list-group-item"><img alt="CM-STORM" src="images/Cougar.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=4" class="list-group-item"><img alt="CM-STORM" src="images/Ducky.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=5" class="list-group-item"><img alt="CM-STORM" src="images/E-Blue.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=6" class="list-group-item"><img alt="CM-STORM" src="images/Filco.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=9" class="list-group-item"><img alt="CM-STORM" src="images/Logitech.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=11" class="list-group-item"><img alt="CM-STORM" src="images/microsoft.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=17" class="list-group-item"><img alt="CM-STORM" src="images/pentagonz-banner.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=18" class="list-group-item"><img alt="CM-STORM" src="images/rapoo.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=19" class="list-group-item"><img alt="CM-STORM" src="images/Razer.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=21" class="list-group-item"><img alt="CM-STORM" src="images/Sennheiser.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=24" class="list-group-item"><img alt="CM-STORM" src="images/Thrustmaster.png" title="ขาย CM Storm"></a>
					<a href="Product?action=ShowProByBrand&brandid=25" class="list-group-item"><img alt="CM-STORM" src="images/Ttesports.png" title="ขาย CM Storm"></a>
				</div>
			</div>

			<div class="col-md-9">
			<div class="row carousel-holder">
			<div class="col-md-12">
					<div class="" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
						
						<layout:block name="showThis">

						</layout:block> <!-- show This -->
						
						<!-- #section:basics/content.searchbox -->
						<div class="breadcrumb nav-search" id="nav-search">
							<form class="form-search" action="Product">
								<input type="hidden" name="action" value="viewProductAll"/>
								<span class="input-icon">
									<input type="text" name="search" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- /.nav-search -->
						<!-- /section:basics/content.searchbox -->
					</div>
				</div>
			</div>
					
					
				<layout:block name="body">

       			</layout:block>

			</div>


		</div>

	</div>
	<!-- /.container -->

	<div class="container">

		<hr>

		<!-- Footer -->
		<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; Your Website Nov-2016</p>
			</div>
		</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="bootstrap/_assets/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bootstrap/_assets/js/bootstrap.min.js"></script>

		<script src="bootstrap/_assets/js/ace/elements.scroller.js"></script>
		<script src="bootstrap/_assets/js/ace/elements.colorpicker.js"></script>
		<script src="bootstrap/_assets/js/ace/elements.fileinput.js"></script>
		<script src="bootstrap/_assets/js/ace/elements.typeahead.js"></script>
		<script src="bootstrap/_assets/js/ace/elements.wysiwyg.js"></script>
		<script src="bootstrap/_assets/js/ace/elements.spinner.js"></script>
		<script src="bootstrap/_assets/js/ace/elements.treeview.js"></script>
		<script src="bootstrap/_assets/js/ace/elements.wizard.js"></script>
		<script src="bootstrap/_assets/js/ace/elements.aside.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.ajax-content.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.touch-drag.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.sidebar.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.sidebar-scroll-1.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.submenu-hover.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.widget-box.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.settings.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.settings-rtl.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.settings-skin.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.widget-on-reload.js"></script>
		<script src="bootstrap/_assets/js/ace/ace.searchbox-autocomplete.js"></script>

</body>

</html>
