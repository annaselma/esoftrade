<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />

<div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">                
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/avatar3.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, Jane</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="index.html">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li>
                            <a href="pages/widgets.html">
                                <i class="fa fa-th"></i> <span>Widgets</span> <small class="badge pull-right bg-green">new</small>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-bar-chart-o"></i>
                                <span>Charts</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/charts/morris.html"><i class="fa fa-angle-double-right"></i> Morris</a></li>
                                <li><a href="pages/charts/flot.html"><i class="fa fa-angle-double-right"></i> Flot</a></li>
                                <li><a href="pages/charts/inline.html"><i class="fa fa-angle-double-right"></i> Inline charts</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-laptop"></i>
                                <span>UI Elements</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/UI/general.html"><i class="fa fa-angle-double-right"></i> General</a></li>
                                <li><a href="pages/UI/icons.html"><i class="fa fa-angle-double-right"></i> Icons</a></li>
                                <li><a href="pages/UI/buttons.html"><i class="fa fa-angle-double-right"></i> Buttons</a></li>
                                <li><a href="pages/UI/sliders.html"><i class="fa fa-angle-double-right"></i> Sliders</a></li>
                                <li><a href="pages/UI/timeline.html"><i class="fa fa-angle-double-right"></i> Timeline</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Forms</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/forms/general.html"><i class="fa fa-angle-double-right"></i> General Elements</a></li>
                                <li><a href="pages/forms/advanced.html"><i class="fa fa-angle-double-right"></i> Advanced Elements</a></li>
                                <li><a href="pages/forms/editors.html"><i class="fa fa-angle-double-right"></i> Editors</a></li>                                
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>Tables</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/tables/simple.html"><i class="fa fa-angle-double-right"></i> Simple tables</a></li>
                                <li><a href="pages/tables/data.html"><i class="fa fa-angle-double-right"></i> Data tables</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="pages/calendar.html">
                                <i class="fa fa-calendar"></i> <span>Calendar</span>
                                <small class="badge pull-right bg-red">3</small>
                            </a>
                        </li>
                        <li>
                            <a href="pages/mailbox.html">
                                <i class="fa fa-envelope"></i> <span>Mailbox</span>
                                <small class="badge pull-right bg-yellow">12</small>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-folder"></i> <span>Examples</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/examples/invoice.html"><i class="fa fa-angle-double-right"></i> Invoice</a></li>
                                <li><a href="pages/examples/login.html"><i class="fa fa-angle-double-right"></i> Login</a></li>
                                <li><a href="pages/examples/register.html"><i class="fa fa-angle-double-right"></i> Register</a></li>
                                <li><a href="pages/examples/lockscreen.html"><i class="fa fa-angle-double-right"></i> Lockscreen</a></li>
                                <li><a href="pages/examples/404.html"><i class="fa fa-angle-double-right"></i> 404 Error</a></li>
                                <li><a href="pages/examples/500.html"><i class="fa fa-angle-double-right"></i> 500 Error</a></li>                                
                                <li><a href="pages/examples/blank.html"><i class="fa fa-angle-double-right"></i> Blank Page</a></li>
                            </ul>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">                
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Blank page
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Blank page</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">


                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->


<!-- <!-- BEGIN RESPONSIVE QUICK SEARCH FORM --> -->
<!-- <div class="navbar-inverse"> -->
<!-- 	<form class="navbar-search visible-phone"> -->
<!-- 		<input type="text" class="search-query" placeholder="Search" /> -->
<!-- 	</form> -->
<!-- </div> -->
<!-- <!-- END RESPONSIVE QUICK SEARCH FORM --> -->
<!-- <!-- BEGIN SIDEBAR MENU --> -->
<!-- <ul> -->

<%-- 	<li <c:if test="${ labelSide=='dash'}">class="active"</c:if>><a --%>
<!-- 		href="#"> <i class="icon-home"></i> Tableau de bord -->
<!-- 	</a></li> -->
<%-- 	<li class="has-sub<c:if test="${ labelSide=='ui'}"> active</c:if>"> --%>
<!-- 		<a href="javascript:;" class=""> <i class="icon-user"></i> Tiers <span -->
<!-- 			class="arrow"></span> -->
<!-- 	</a> -->
<!-- 		<ul class="sub"> -->
<!-- 			<li><a class="" href="#">Nouveau Client</a></li> -->
<!-- 			<li><a class="" href="#">Liste des clients</a></li> -->
<!-- 			<li><a class="" href="#">Liste des fournisseurs</a></li> -->
<!-- 		</ul> -->
<!-- 	</li> -->
<!-- 	<li class="has-sub"> -->
<!-- 		<a href="javascript:;" class=""><i class=" icon-shopping-cart"></i> -->
<!-- 			Produits & services<span class="arrow"></span></a> -->
<!-- 		<ul class="sub"> -->
<!-- 			<li><a class="" href="#">Nouveau Produit</a></li> -->
<!-- 			<li><a class="" href="#">Liste des Produits</a></li> -->
<!-- 		</ul> -->
<!-- 	</li> -->
<!-- 	<li class="has-sub"> -->
<!-- 		<a href="javascript:;" class=""><i class=" icon-th"></i>Devis<span -->
<!-- 			class="arrow"></span></a> -->
<!-- 		<ul class="sub"> -->
<!-- 			<li><a class="" href="#">Creer Devis</a></li> -->
<!-- 			<li><a class="" href="#">Liste des Devis</a></li> -->
<!-- 		</ul> -->
<!-- 	</li> -->
<!-- 	<li class="has-sub"> -->
<!-- 		<a href="javascript:;" class=""><i class="icon-barcode"></i> -->
<!-- 			Commandes<span class="arrow"></span></a> -->
<!-- 		<ul class="sub"> -->
<!-- 			<li><a class="" href="#">Creer Commande</a></li> -->
<!-- 			<li><a class="" href="#">Liste des Commandes</a></li> -->
<!-- 		</ul> -->
<!-- 	</li> -->
<!-- 	<li class="has-sub"> -->
<!-- 		<a href="javascript:;" class=""><i class="icon-th"></i> Bons de -->
<!-- 			livraison<span class="arrow"></span></a> -->
<!-- 		<ul class="sub"> -->
<!-- 			<li><a class="" href="#">Creer Bon Livraison</a></li> -->
<!-- 			<li><a class="" href="#">Liste des Bons de livraison</a></li> -->
<!-- 		</ul> -->
<!-- 	</li> -->
<!-- 	<li class="has-sub"> -->
<!-- 		<a href="javascript:;" class=""><i class="icon-file"></i> Factures<span -->
<!-- 			class="arrow"></span></a> -->
<!-- 		<ul class="sub"> -->
<!-- 			<li><a class="" href="#">Creer une Facture</a></li> -->
<!-- 			<li><a class="" href="#">Liste des Factures</a></li> -->
<!-- 		</ul> -->
<!-- 	</li> -->
<!-- 	<li class="has-sub"> -->
<!-- 		<a href="javascript:;" class=""><i class="icon-truck"></i> Stock<span -->
<!-- 			class="arrow"></span></a> -->
<!-- 		<ul class="sub"> -->
<!-- 			<li><a class="" href="#">Creer une Facture</a></li> -->
<!-- 			<li><a class="" href="#">Liste des Factures</a></li> -->
<!-- 		</ul> -->
<!-- 	</li> -->
<!-- 	<li><a class="" href="#"><i class="icon-group"></i> GRH</a></li> -->

<!-- </ul> -->
<!-- <!-- END SIDEBAR MENU --> -->
