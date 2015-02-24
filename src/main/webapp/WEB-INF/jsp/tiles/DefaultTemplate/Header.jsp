<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<title>AdminLTE | Dashboard</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<link href="${baseURL}/assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- font Awesome -->
<link href="${baseURL}/assets/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<!-- Ionicons -->
<link href="${baseURL}/assets/css/ionicons.min.css" rel="stylesheet"
	type="text/css" />
<!-- Theme style -->
<link href="${baseURL}/assets/css/AdminLTE.css" rel="stylesheet"
	type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
</head>
<body class="skin-blue">
	<!-- header logo: style can be found in header.less -->
	<header class="header">
		<!--             <a href="#" class="logo"> -->
		<!--                 LOGO -->
		<!--             </a> -->
		<nav class="navbar navbar-static-top" role="navigation">
			<!-- Sidebar toggle button-->
			<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas"
				role="button"> <span class="sr-only">Toggle navigation</span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
			</a>
			<div class="navbar-right">
				<ul class="nav navbar-nav">
					<!-- Notifications: style can be found in dropdown.less -->
					<li class="dropdown notifications-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="fa fa-warning"></i> <span class="label label-warning">10</span>
					</a>
						<ul class="dropdown-menu">
							<li class="header">You have 10 notifications</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<ul class="menu">
									<li><a href="#"> <i class="ion ion-ios7-people info"></i>
											5 new members joined today
									</a></li>
									<li><a href="#"> <i class="fa fa-warning danger"></i>
											Very long description here that may not fit into the page and
											may cause design problems
									</a></li>
									<li><a href="#"> <i class="fa fa-users warning"></i> 5
											new members joined
									</a></li>

									<li><a href="#"> <i class="ion ion-ios7-cart success"></i>
											25 sales made
									</a></li>
									<li><a href="#"> <i class="ion ion-ios7-person danger"></i>
											You changed your username
									</a></li>
								</ul>
							</li>
							<li class="footer"><a href="#">View all</a></li>
						</ul></li>
					<!-- Tasks: style can be found in dropdown.less -->
					<li class="dropdown tasks-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="fa fa-tasks"></i> <span class="label label-danger">9</span>
					</a>
						<ul class="dropdown-menu">
							<li class="header">You have 9 tasks</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<ul class="menu">
									<li>
										<!-- Task item --> <a href="#">
											<h3>
												Design some buttons <small class="pull-right">20%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-aqua"
													style="width: 20%" role="progressbar" aria-valuenow="20"
													aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">20% Complete</span>
												</div>
											</div>
									</a>
									</li>
									<!-- end task item -->
									<li>
										<!-- Task item --> <a href="#">
											<h3>
												Create a nice theme <small class="pull-right">40%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-green"
													style="width: 40%" role="progressbar" aria-valuenow="20"
													aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">40% Complete</span>
												</div>
											</div>
									</a>
									</li>
									<!-- end task item -->
									<li>
										<!-- Task item --> <a href="#">
											<h3>
												Some task I need to do <small class="pull-right">60%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-red"
													style="width: 60%" role="progressbar" aria-valuenow="20"
													aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">60% Complete</span>
												</div>
											</div>
									</a>
									</li>
									<!-- end task item -->
									<li>
										<!-- Task item --> <a href="#">
											<h3>
												Make beautiful transitions <small class="pull-right">80%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-yellow"
													style="width: 80%" role="progressbar" aria-valuenow="20"
													aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">80% Complete</span>
												</div>
											</div>
									</a>
									</li>
									<!-- end task item -->
								</ul>
							</li>
							<li class="footer"><a href="#">View all tasks</a></li>
						</ul></li>
					<!-- User Account: style can be found in dropdown.less -->
					<li class="dropdown user user-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="glyphicon glyphicon-user"></i> <span>Jane Doe <i
								class="caret"></i></span>
					</a>
						<ul class="dropdown-menu">
							<!-- User image -->
							<li class="user-header bg-light-blue"><img
								src="${baseURL}/assets/img/avatar3.png" class="img-circle"
								alt="User Image" />
								<p>
									Jane Doe - Web Developer <small>Member since Nov. 2012</small>
								</p></li>
							<!-- Menu Body -->
							<li class="user-body">
								<div class="col-xs-4 text-center">
									<a href="#">Followers</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Sales</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Friends</a>
								</div>
							</li>
							<!-- Menu Footer-->
							<li class="user-footer">
								<div class="pull-left">
									<a href="#" class="btn btn-default btn-flat">Profile</a>
								</div>
								<div class="pull-right">
									<a href="#" class="btn btn-default btn-flat">Sign out</a>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="left-side sidebar-offcanvas">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="active"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Tableau de bord</span>
					</a></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-user"></i> <span>Tiers</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i
									class="fa fa-angle-double-right"></i> Nouveau Client</a></li>
							<li><a href="pages/charts/flot.html"><i
									class="fa fa-angle-double-right"></i> Liste des Clients</a></li>
							<li><a href="pages/charts/inline.html"><i
									class="fa fa-angle-double-right"></i> Creer Fournisseur</a></li>
									<li><a href="pages/charts/inline.html"><i
									class="fa fa-angle-double-right"></i> Liste des Fournisseurs</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-shopping-cart"></i>
							<span>Produits & Services</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i
									class="fa fa-angle-double-right"></i> Creer Produit/Service</a></li>
							<li><a href="pages/UI/icons.html"><i
									class="fa fa-angle-double-right"></i> Liste Produits/Services</a></li>
							
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-edit"></i>
							<span>Devis</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i
									class="fa fa-angle-double-right"></i> Creer Devis</a></li>
							<li><a href="pages/forms/advanced.html"><i
									class="fa fa-angle-double-right"></i> Liste des devis</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-tag"></i>
							<span>Commandes</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i
									class="fa fa-angle-double-right"></i> Creer Commande</a></li>
							<li><a href="pages/tables/data.html"><i
									class="fa fa-angle-double-right"></i> Liste des Commandes</a></li>
						</ul></li>
						<li class="treeview"><a href="#"> <i class="fa fa-file-text"></i>
							<span>Bons de Livraison</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i
									class="fa fa-angle-double-right"></i> Creer Bon de Livraison</a></li>
							<li><a href="pages/tables/data.html"><i
									class="fa fa-angle-double-right"></i> Liste Bons Livraison</a></li>
						</ul></li>
						<li class="treeview"><a href="#"> <i class="fa fa-file-text-o"></i>
							<span>Factures</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i
									class="fa fa-angle-double-right"></i> Creer Facture</a></li>
							<li><a href="pages/tables/data.html"><i
									class="fa fa-angle-double-right"></i> Liste des Factures</a></li>
						</ul></li>
					<li><a href="#"> <i class="fa fa-truck"></i> <span>Stock</span> <small
							class="badge pull-right bg-green">10</small>
					</a></li>
					<li><a href="#"> <i class="fa fa-users"></i> <span>GRH</span> <small
							class="badge pull-right bg-red">3</small>
					</a></li>
					
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Right side column. Contains the navbar and content of the page -->
		<aside class="right-side">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					variable <small>la page en actu</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">page actu</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content"></section>
			<!-- /.content -->
		</aside>
		<!-- /.right-side -->
	</div>
	<!-- ./wrapper -->


	<!-- jQuery 2.0.2 -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="${baseURL}/assets/js/plugins/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="${baseURL}/assets/js/plugins/AdminLTE/app.js"
		type="text/javascript"></script>

</body>
</html>