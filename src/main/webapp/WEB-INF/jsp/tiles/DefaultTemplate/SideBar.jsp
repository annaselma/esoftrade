<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
					<sec:authorize access="hasAnyRole('READ_MANUFACTURING','WRITE_MANUFACTURING')">
					<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
							<span>Production</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${baseURL}/manufacturing/list"><i
									class="fa fa-angle-double-right"></i>Ordres de Fabrication</a></li>
							
						</ul></li>
						</sec:authorize>
						<!-- Produits -->
						<sec:authorize access="hasAnyRole('READ_PRODUCT','WRITE_PRODUCT')">
						<li class="treeview"><a href="#"> <i class="fa fa-tag"></i>
							<span>Produits</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${baseURL}/product/list"><i
									class="fa fa-angle-double-right"></i> Liste Produits</a></li>
									<li><a href="${baseURL}/product/create"><i
									class="fa fa-angle-double-right"></i> créer produit</a></li>
							<li><a href="${baseURL}/category/list"><i
									class="fa fa-angle-double-right"></i> Liste des Catégories</a></li>
									<li><a href="${baseURL}/category/create"><i
									class="fa fa-angle-double-right"></i> créer une catégorie</a></li>
						</ul></li>
						</sec:authorize>
						<!-- Postes -->
						<sec:authorize access="hasAnyRole('READ_POSTE','WRITE_POSTE')">
						<li class="treeview"><a href="#"> <i class="fa  fa-users"></i>
							<span>Postes</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${baseURL}/poste/list"><i
									class="fa fa-angle-double-right"></i> Liste Postes</a></li>
									<li><a href="${baseURL}/poste/create"><i
									class="fa fa-angle-double-right"></i> créer Poste</a></li>
						<li><a href="${baseURL}/categoryPost/list"><i
									class="fa fa-angle-double-right"></i> Liste des Catégories</a></li>	
									<li><a href="${baseURL}/categoryPost/create"><i
									class="fa fa-angle-double-right"></i> créer catégorie</a></li>
						</ul></li>
						</sec:authorize>
						<!-- EndingPoste -->
						<sec:authorize access="hasAnyRole('READ_WAREHOUSE','WRITE_WAREHOUSE')">
						<li class="treeview"><a href="#"> <i class="fa fa-truck"></i> <span>Stock</span><i class="fa fa-angle-left pull-right"></i>
					</a><ul class="treeview-menu">
					
							<li><a href="${baseURL}/mouvement/list"><i
									class="fa fa-angle-double-right"></i> Mouvement Stock</a></li>
						<li><a href="${baseURL}/warehouse/list"><i
									class="fa fa-angle-double-right"></i> Liste des Entrepôts</a></li>
							<li><a href="${baseURL}/warehouse/create"><i
									class="fa fa-angle-double-right"></i> créer un entrepôt</a></li>			
						</ul></li></sec:authorize>
						<!-- User -->
						<sec:authorize access="hasAnyRole('READ_ROLE','WRITE_ROLE')">
						<li class="treeview"><a href="#"> <i class="fa fa-unlock-alt"></i> <span>Paramétrage</span><i class="fa fa-angle-left pull-right"></i>
					</a><ul class="treeview-menu">
							<li><a href="${baseURL}/role/list"><i
									class="fa fa-angle-double-right"></i>Rôles et permissions</a></li>
									<li><a href="${baseURL}/role/create"><i
									class="fa fa-angle-double-right"></i> créer un rôle</a></li>
						<li><a href="${baseURL}/user/list"><i
									class="fa fa-angle-double-right"></i> Liste des utilisateurs</a></li>
									<li><a href="${baseURL}/user/create"><i
									class="fa fa-angle-double-right"></i> créer utilisateur</a></li>	
						</ul></li>
						</sec:authorize>
						<sec:authorize access="hasRole('READ_USER')">
						<li class=""><a href="${baseURL}/user/list"> <i
							class="fa fa-user"></i> <span>Liste des utilisateurs</span>
					</a></li></sec:authorize>
						<!-- tiers -->
					<li class="treeview"><a href="#"> <i
							class="fa fa-users"></i> <span>Tiers</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${baseURL}/third/create?type=customer"><i
									class="fa fa-angle-double-right"></i> Nouveau Client</a></li>
							<li><a href="${baseURL}/third/list?type=customer"><i
									class="fa fa-angle-double-right"></i> Liste des Clients</a></li>
							<li><a href="${baseURL}/third/create?type=supplier"><i
									class="fa fa-angle-double-right"></i> Creer Fournisseur</a></li>
									<li><a href="${baseURL}/third/list?type=supplier"><i
									class="fa fa-angle-double-right"></i> Liste des Fournisseurs</a></li>
						</ul></li>
						<!-- tiersend -->
					<li class="treeview"><a href="#"> <i
							class=" fa fa-shopping-cart"></i> <span>Commandes</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${baseURL}/order/create?type=supplierOrder"><i
									class="fa fa-angle-double-right"></i> créer une Cmd_Fournisseur</a></li>
							<li><a href="${baseURL}/order/list?type=supplierOrder"><i
									class="fa fa-angle-double-right"></i> Liste des Cmd_fournisseur</a></li>
							<li><a href="${baseURL}/order/create?type=customerOrder"><i
									class="fa fa-angle-double-right"></i> créer une Cmd_Client</a></li>
									<li><a href="${baseURL}/order/list?type=customerOrder"><i
									class="fa fa-angle-double-right"></i> Liste des Cmd_client</a></li>
						</ul></li>
						
					
			
					
				</ul>
			</section>
			<!-- /.sidebar -->
		

		<!-- Right side column. Contains the navbar and content of the page -->
		
		<!-- /.right-side -->


