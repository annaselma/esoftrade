<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
       
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button type="submit" name="seach" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
				<ul class="sidebar-menu margin-top: 51 px">
					<li class="active"><a href="${baseURL}/dashboard"> <i
							class="fa fa-dashboard"></i> <span>Tableau de bord</span>
					</a></li>
					<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
							<span>Production</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${baseURL}/manufacturing/list"><i
									class="fa fa-angle-double-right"></i>Ordres de Fabrication</a></li>
							
						</ul></li>
						<!-- Produits -->
						<li class="treeview"><a href="#"> <i class="fa fa-tag"></i>
							<span>Produits</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${baseURL}/product/list"><i
									class="fa fa-angle-double-right"></i> Liste Produits</a></li>
							<li><a href="${baseURL}/category/list"><i
									class="fa fa-angle-double-right"></i> Liste des Catégories</a></li>
						</ul></li>
						<!-- Postes -->
						<li class="treeview"><a href="#"> <i class="fa  fa-users"></i>
							<span>Postes</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${baseURL}/poste/list"><i
									class="fa fa-angle-double-right"></i> Liste Postes</a></li>
						<li><a href="${baseURL}/categoryPost/list"><i
									class="fa fa-angle-double-right"></i> Liste des Catégories</a></li>	
						</ul></li>
						<!-- EndingPoste -->
						
						<li class="treeview"><a href="#"> <i class="fa fa-truck"></i> <span>Stock</span><i class="fa fa-angle-left pull-right"></i>
					</a><ul class="treeview-menu">
							<li><a href="${baseURL}/mouvement/list"><i
									class="fa fa-angle-double-right"></i> Mouvement Stock</a></li>
						<li><a href="${baseURL}/warehouse/list"><i
									class="fa fa-angle-double-right"></i> Liste des Entrepôts</a></li>	
						</ul></li>
						<!-- User -->
						<li class="treeview"><a href="#"> <i class="fa fa-unlock-alt"></i> <span>Paramétrage</span><i class="fa fa-angle-left pull-right"></i>
					</a><ul class="treeview-menu">
							<li><a href="${baseURL}/role/list"><i
									class="fa fa-angle-double-right"></i>Rôles et permissions</a></li>
						<li><a href="${baseURL}/user/list"><i
									class="fa fa-angle-double-right"></i> Liste des utilisateurs</a></li>	
						</ul></li>
						<!-- tiers -->
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
						<!-- tiersend -->
					
						<li class="treeview"><a href="#"> <i class="fa fa-file-text-o"></i>
							<span>Factures</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i
									class="fa fa-angle-double-right"></i> Creer Facture</a></li>
							<li><a href="pages/tables/data.html"><i
									class="fa fa-angle-double-right"></i> Liste des Factures</a></li>
						</ul></li>
					
					<li><a href="#"> <i class="fa fa-users"></i> <span>Statistique</span> <small
							class="badge pull-right bg-red">3</small>
					</a></li>
					
				</ul>
			</section>
			<!-- /.sidebar -->
		

		<!-- Right side column. Contains the navbar and content of the page -->
		
		<!-- /.right-side -->



