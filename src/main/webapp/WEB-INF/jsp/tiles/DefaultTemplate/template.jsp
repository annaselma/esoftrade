<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />


<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if IE 10]> <html lang="en" class="ie10"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>Conquer Admin Dashboard Template</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<link href="${baseURL}/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${baseURL}/assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="${baseURL}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="${baseURL}/assets/css/style.css" rel="stylesheet" />
	<link href="${baseURL}/assets/css/style_responsive.css" rel="stylesheet" />
	<link href="${baseURL}/assets/css/style_default.css" rel="stylesheet" id="style_color" />
	<link href="#" rel="stylesheet" id="style_metro" />
	<link href="${baseURL}/assets/fancybox/source/jquery.fancybox.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${baseURL}/assets/gritter/css/jquery.gritter.css" />
	<link rel="stylesheet" type="text/css" href="${baseURL}/assets/uniform/css/uniform.default.css" />
	<link rel="stylesheet" type="text/css" href="${baseURL}/assets/bootstrap-daterangepicker/daterangepicker.css" />
	<link href="${baseURL}/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
	<link href="${baseURL}/assets/jqvmap/jqvmap/jqvmap.css" media="screen" rel="stylesheet" type="text/css" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">
	<!-- BEGIN HEADER -->
	<div id="header" class="navbar navbar-inverse navbar-fixed-top">
	<tiles:insertAttribute name="header"/>
	</div>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div id="container" class="row-fluid">
		<!-- BEGIN SIDEBAR -->
		<div id="sidebar" class="nav-collapse collapse">
			<tiles:insertAttribute name="sidebar"/>
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div id="body">
			
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->		
						<tiles:insertAttribute name="titlepage"/>
						<!-- END PAGE TITLE & BREADCRUMB-->
					
				
				<!-- END PAGE HEADER-->
				<div id="page" class="dashboard">
				<!-- BEGIN PAGE CONTENT-->
				<tiles:insertAttribute name="page"/>
				<!-- END PAGE CONTENT-->
				</div>
				
			<!-- END PAGE CONTAINER-->		
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div id="footer">
<tiles:insertAttribute name="footer"/>
	</div>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS -->
	<!-- Load javascripts at bottom, this will reduce page load time -->
	<script src="${baseURL}/assets/js/jquery-1.8.2.min.js"></script>	
	<script src="${baseURL}/assets/jQuery-slimScroll/jquery-ui-1.9.2.custom.min.js"></script>	
	<script src="${baseURL}/assets/jQuery-slimScroll/slimScroll.min.js"></script>		
	<script src="${baseURL}/assets/fullcalendar/fullcalendar/fullcalendar.min.js"></script>
	<script src="${baseURL}/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="${baseURL}/assets/js/jquery.blockui.js"></script>	
	<script src="${baseURL}/assets/js/jquery.cookie.js"></script>	
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="${baseURL}/assets/js/excanvas.js"></script>	
	<script src="${baseURL}/assets/js/respond.js"></script>
	<![endif]-->	
	<script type="text/javascript" src="${baseURL}/assets/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript" src="${baseURL}/assets/bootstrap-daterangepicker/daterangepicker.js"></script>	
	<script src="${baseURL}/assets/fancybox/source/jquery.fancybox.pack.js"></script>
	<script src="${baseURL}/assets/js/app.js"></script>		
	<script>
		jQuery(document).ready(function() {		
			// initiate layout and plugins
			App.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>