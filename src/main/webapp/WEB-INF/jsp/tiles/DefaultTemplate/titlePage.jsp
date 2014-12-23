<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
	<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
	
<h3 class="page-title">
	Dashboard <small>statistics and more</small>
</h3>
<ul class="breadcrumb">
	<li><i class="icon-home"></i> <a href="#">Home</a> <span
		class="divider">/</span></li>
	<li><a href="#">Dashboard</a></li>
	<li class="pull-right dashboard-report-li">
		<div id="dashboard-report-range"
			class="dashboard-report-range-container no-text-shadow tooltips"
			data-placement="top"
			data-original-title="Change dashboard date range">
			<i class="icon-calendar icon-large"></i><span></span> <b
				class="caret"></b>
		</div>
	</li>
</ul>
</div>
</div>
</div>