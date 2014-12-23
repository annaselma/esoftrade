<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
			<div class="navbar-inverse">
				<form class="navbar-search visible-phone">
					<input type="text" class="search-query" placeholder="Search" />
				</form>
			</div>
			<!-- END RESPONSIVE QUICK SEARCH FORM -->
			<!-- BEGIN SIDEBAR MENU -->
			<ul>
			
				<li <c:if test="${ labelSide=='dash'}">class="active"</c:if> >

					<a href="index.html">
					<i class="icon-home"></i> Dashboard
					</a>					
				</li>
				<li class="has-sub<c:if test="${ labelSide=='ui'}"> active</c:if>">
					<a href="javascript:;" class="">
					<i class="icon-bookmark-empty"></i> UI Elements
					<span class="arrow"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="ui_elements_general.html">General</a></li>
						<li><a class="" href="ui_elements_buttons.html">Buttons</a></li>
						<li><a class="" href="ui_elements_tabs_accordions.html">Tabs & Accordions</a></li>
						<li><a class="" href="ui_elements_typography.html">Typography</a></li>
					</ul>
				</li>
				<li><a class="" href="forms.html"><i class="icon-table"></i> Form Stuff</a></li>
				<li><a class="" href="tables.html"><i class="icon-table"></i> Data Tables</a></li>
				<li><a class="" href="grids.html"><i class="icon-th"></i> Grids & Portlets</a></li>
				<li><a class="" href="charts.html"><i class="icon-bar-chart"></i> Visual Charts</a></li>
				<li class="has-sub">
					<a href="javascript:;" class="">
					<i class="icon-map-marker"></i> Maps
					<span class="arrow"></span>
					</a>
					<ul class="sub">
						<li><a class="" href="maps_google.html"> Google Maps</a></li>
						<li><a class="" href="maps_vector.html"> Vector Maps</a></li>
					</ul>
				</li>
				<li><a class="" href="calendar.html"><i class="icon-ok"></i> Calendar</a></li>
				<li><a class="" href="gallery.html"><i class="icon-camera"></i> Gallery</a></li>
				<li><a class="" href="login.html"><i class="icon-user"></i> Login Page</a></li>
			</ul>
			<!-- END SIDEBAR MENU -->
