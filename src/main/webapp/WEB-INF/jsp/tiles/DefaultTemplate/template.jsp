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
	<link href="${baseURL}/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${baseURL}/assets/css/font-awesome.css" rel="stylesheet" />
	<link href="${baseURL}/assets/css/ionicons.min.css" rel="stylesheet" type="text/css" />
	<link href="${baseURL}/assets/css/morris/morris.css" rel="stylesheet" type="text/css" />
	<link href="${baseURL}/assets/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
	<link href="${baseURL}/assets/css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
	<link href="${baseURL}/assets/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
     <link href="${baseURL}/assets/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
    <link href="${baseURL}/assets/css/AdminLTE.css" rel="stylesheet" type="text/css" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- <body class="fixed-top"> -->
<body>
	<!-- BEGIN HEADER -->
<!-- 	<div id="header" class="navbar navbar-inverse navbar-fixed-top"> -->
	<div id="header">
	<tiles:insertAttribute name="header"/>
	</div>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div id="container" class="row-fluid">
		<!-- BEGIN SIDEBAR -->
<!-- 		<div id="sidebar" class="nav-collapse collapse"> -->
<%-- 			<tiles:insertAttribute name="sidebar"/> --%>
<!-- 		</div> -->
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
<!-- 		<div id="body"> -->
			
<!-- 						BEGIN PAGE TITLE & BREADCRUMB		 -->
<%-- 						<tiles:insertAttribute name="titlepage"/> --%>
<!-- 						END PAGE TITLE & BREADCRUMB -->
					
				
<!-- 				END PAGE HEADER -->
<!-- 				<div id="page" class="dashboard"> -->
<!-- 				BEGIN PAGE CONTENT -->
<%-- 				<tiles:insertAttribute name="page"/> --%>
<!-- 				END PAGE CONTENT -->
<!-- 				</div> -->
				
<!-- 			<!-- END PAGE CONTAINER-->
<!-- 		</div> -->
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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="${baseURL}/assets/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
	<script src="${baseURL}/assets/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${baseURL}/assets/js/plugins/morris/morris.min.js" type="text/javascript"></script>	
	<script type="text/javascript" src="${baseURL}/assets/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript" src="${baseURL}/assets/bootstrap-daterangepicker/daterangepicker.js"></script>	
	<script src="${baseURL}/assets/fancybox/source/jquery.fancybox.pack.js"></script>
	<script src="js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
        <script src="${baseURL}/assets/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
        <script src="${baseURL}/assets/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
        <script src="${baseURL}/assets/js/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
        <!-- jQuery Knob Chart -->
        <script src="${baseURL}/assets/js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
        <!-- daterangepicker -->
        <script src="${baseURL}/assets/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
        <script src="${baseURL}/assets/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
        <!-- iCheck -->
        <script src="${baseURL}/assets/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>

        <!-- AdminLTE App -->
        <script src="${baseURL}/assets/js/AdminLTE/app.js" type="text/javascript"></script>
        
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="${baseURL}/assets/js/AdminLTE/dashboard.js" type="text/javascript"></script> 
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