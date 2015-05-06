<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
       
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu margin-top: 51 px">
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
							<span>Production</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i
									class="fa fa-angle-double-right"></i> Creer Ordre de Fabrication</a></li>
							<li><a href="pages/forms/advanced.html"><i
									class="fa fa-angle-double-right"></i> Liste des Ordres de fabrication</a></li>
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
					<li><a href="#"> <i class="fa fa-users"></i> <span>Statistique</span> <small
							class="badge pull-right bg-red">3</small>
					</a></li>
					
				</ul>
			</section>
			<!-- /.sidebar -->
		

		<!-- Right side column. Contains the navbar and content of the page -->
		
		<!-- /.right-side -->



