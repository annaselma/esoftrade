<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Small boxes (Stat box) -->
<h1><spring:message code="label.title"/></h1>
<div class="row">
	<div class="col-lg-3 col-xs-6">
		<!-- small box -->
		<div class="small-box bg-aqua">
			<div class="inner">
				<h3>150</h3>
				<p>Produits</p>
			</div>
			<div class="icon">
				<i class="ion ion-bag"></i>
			</div>
			<a href="#" class="small-box-footer"> plus <i
				class="fa fa-arrow-circle-right"></i>
			</a>
		</div>
	</div>
	<!-- ./col -->
	<div class="col-lg-3 col-xs-6">
		<!-- small box -->
		<div class="small-box bg-green">
			<div class="inner">
				<h3>
					63<sup style="font-size: 20px">%</sup>
				</h3>
				<p>Ventes</p>
			</div>
			<div class="icon">
				<i class="ion ion-stats-bars"></i>
			</div>
			<a href="#" class="small-box-footer"> plus <i
				class="fa fa-arrow-circle-right"></i>
			</a>
		</div>
	</div>
	<!-- ./col -->
	<div class="col-lg-3 col-xs-6">
		<!-- small box -->
		<div class="small-box bg-yellow">
			<div class="inner">
				<h3>44</h3>
				<p>Factures Impayés</p>
			</div>
			<div class="icon">
				<i class="ion ion-document"></i>
			</div>
			<a href="#" class="small-box-footer"> plus<i
				class="fa fa-arrow-circle-right"></i>
			</a>
		</div>
	</div>
	<!-- ./col -->
	<div class="col-lg-3 col-xs-6">
		<!-- small box -->
		<div class="small-box bg-red">
			<div class="inner">
				<h3>650</h3>
				<p>Commande Client</p>
			</div>
			<div class="icon">
				<i class="ion ion-pie-graph"></i>
			</div>
			<a href="#" class="small-box-footer"> plus <i
				class="fa fa-arrow-circle-right"></i>
			</a>
		</div>
	</div>
	<!-- ./col -->
</div>
<!-- /.row -->
<!-- testerrr -->
<div class="col-md-6">
	<!-- Bar chart -->
	<div class="box box-primary">
		<div class="box-header">
			<i class="fa fa-bar-chart-o"></i>
			<h3 class="box-title">Bar Chart</h3>
		</div>
		<div class="box-body">
			<div id="bar-chart"
				style="height: 300px; padding: 0px; position: relative;">
				<canvas class="flot-base" width="483" height="300"
					style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 483px; height: 300px;"></canvas>
				<div class="flot-text"
					style="position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px; font-size: smaller; color: rgb(84, 84, 84);">
					<div class="flot-x-axis flot-x1-axis xAxis x1Axis"
						style="position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px; display: block;">
						<div class="flot-tick-label tickLabel"
							style="position: absolute; max-width: 80px; top: 282px; left: 22px; text-align: center;">January</div>
						<div class="flot-tick-label tickLabel"
							style="position: absolute; max-width: 80px; top: 282px; left: 100px; text-align: center;">February</div>
						<div class="flot-tick-label tickLabel"
							style="position: absolute; max-width: 80px; top: 282px; left: 187px; text-align: center;">March</div>
						<div class="flot-tick-label tickLabel"
							style="position: absolute; max-width: 80px; top: 282px; left: 270px; text-align: center;">April</div>
						<div class="flot-tick-label tickLabel"
							style="position: absolute; max-width: 80px; top: 282px; left: 351px; text-align: center;">May</div>
						<div class="flot-tick-label tickLabel"
							style="position: absolute; max-width: 80px; top: 282px; left: 429px; text-align: center;">June</div>
					</div>
					<div class="flot-y-axis flot-y1-axis yAxis y1Axis"
						style="position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px; display: block;">
						<div class="flot-tick-label tickLabel"
							style="position: absolute; top: 269px; left: 7px; text-align: right;">0</div>
						<div class="flot-tick-label tickLabel"
							style="position: absolute; top: 202px; left: 7px; text-align: right;">5</div>
						<div class="flot-tick-label tickLabel"
							style="position: absolute; top: 135px; left: 1px; text-align: right;">10</div>
						<div class="flot-tick-label tickLabel"
							style="position: absolute; top: 68px; left: 1px; text-align: right;">15</div>
						<div class="flot-tick-label tickLabel"
							style="position: absolute; top: 1px; left: 1px; text-align: right;">20</div>
					</div>
				</div>
				<canvas class="flot-overlay" width="483" height="300"
					style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 483px; height: 300px;"></canvas>
			</div>
		</div>
		<!-- /.box-body-->
	</div>
	<!-- /.box -->

	<!-- Donut chart -->
	<!--                             <div class="box box-primary"> -->
	<!--                                 <div class="box-header"> -->
	<!--                                     <i class="fa fa-bar-chart-o"></i> -->
	<!--                                     <h3 class="box-title">Donut Chart</h3> -->
	<!--                                 </div> -->
	<!--                                 <div class="box-body"> -->
	<%--                                     <div id="donut-chart" style="height: 300px; padding: 0px; position: relative;"><canvas class="flot-base" width="483" height="300" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 483px; height: 300px;"></canvas><canvas class="flot-overlay" width="483" height="300" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 483px; height: 300px;"></canvas><span class="pieLabel" id="pieLabel0" style="position: absolute; top: 71px; left: 300.5px;"><div style="font-size:13px; text-align:center; padding:2px; color: #fff; font-weight: 600;">Series2<br>30%</div></span><span class="pieLabel" id="pieLabel1" style="position: absolute; top: 211px; left: 278.5px;"><div style="font-size:13px; text-align:center; padding:2px; color: #fff; font-weight: 600;">Series3<br>20%</div></span><span class="pieLabel" id="pieLabel2" style="position: absolute; top: 130px; left: 119.5px;"><div style="font-size:13px; text-align:center; padding:2px; color: #fff; font-weight: 600;">Series4<br>50%</div></span></div> --%>
	<!--                                 </div>/.box-body -->
	<!--                             </div>/.box -->
</div>


<script type="text/javascript" src="${baseURL}/js/flot/jquery.flot.js"></script>
<script src="${baseURL}/js/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
<script src="${baseURL}/js/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="${baseURL}/js/plugins/flot/jquery.flot.pie.min.js" type="text/javascript"></script>
<script src="${baseURL}/js/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>

