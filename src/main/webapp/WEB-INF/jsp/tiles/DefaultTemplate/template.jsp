<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />

<html>
    <head>
        <meta charset="UTF-8">
        <title>KelmoSoft</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${baseURL}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${baseURL}/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="${baseURL}/css/esoft.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${baseURL}/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="${baseURL}/css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="${baseURL}/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- fullCalendar -->
        <link href="${baseURL}/css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="${baseURL}/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- datepicker -->
        <link href="${baseURL}/css/datepicker.css" rel="stylesheet" type="text/css" />
         <!-- DATA TABLES -->
        <link href="${baseURL}/css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="${baseURL}/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${baseURL}/css/AdminLTE.css" rel="stylesheet" type="text/css" />
         <!-- bootstrap-switch -->
         <link href="${baseURL}/css/bootstrap-switch.css" rel="stylesheet" type="text/css" />
         <!--  tokenize style-->
         <link rel="stylesheet" type="text/css" href="${baseURL}/css/tokenize/jquery.tokenize.css" />
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script src="${baseURL}/js/jquery-2.1.3.js" type="text/javascript"></script>
        <script src="${baseURL}/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        <script src="${baseURL}/js/bootstrap-datepicker.js"></script>
        <!-- Bootstrap -->
        <script src="${baseURL}/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- KelmoSoft -->
        <script src="${baseURL}/js/KelmoSoft/App.js" type="text/javascript"></script>
        <!-- Morris.js charts -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="${baseURL}/js/plugins/morris/morris.min.js" type="text/javascript"></script>
        <!-- Sparkline -->
        <script src="${baseURL}/js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
        <!-- jvectormap -->
        <script src="${baseURL}/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
        <script src="${baseURL}/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
        <!-- fullCalendar -->
        <script src="${baseURL}/js/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
        <!-- jQuery Knob Chart -->
        <script src="${baseURL}/js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
        <script src="${baseURL}/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
        <!-- iCheck -->
        <script src="${baseURL}/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
        <!-- ckeditor -->
        <script src="${baseURL}/js/plugins/ckeditor/ckeditor.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="${baseURL}/js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- dateranpicker -->
        <script src="${baseURL}/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
         <!-- switch-button -->
         <script src="${baseURL}/js/bootstrap-switch.js" type="text/javascript" ></script>
         <!-- bootstrap-modal -->
<%--          <script src="${baseURL}/js/bootstrap-modal.js" type="text/javascript"></script> --%>
        
   </head>
    <body class="skin-blue">
        <!-- header logo: style can be found in header.less -->
        <tiles:insertAttribute name="header"/>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
            <tiles:insertAttribute name="sidebar"/>
</aside>
            <!-- -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <tiles:insertAttribute name="titlepage"/>

                <!-- Main content -->
                <section class="content">
<tiles:insertAttribute name="page"/> 

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->
        <!-- BEGIN FOOTER -->
	<div id="footer">
<tiles:insertAttribute name="footer"/>
	</div>
	<!-- END FOOTER -->
    </body>
</html>