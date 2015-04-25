<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<div class="nav-tabs-custom">
<ul id="tabs" class="nav nav-tabs">
	<li class="active"><a href="#fiche" data-toggle="tab"
		aria-expanded="true"><i class=""></i>Fiche Produit</a></li>
	<li class=""><a href="#stock" data-toggle="tab"
		aria-expanded="false"><i class="" style=""></i>Stock</a></li>
		<li class=""><a href="#fichierjoint" data-toggle="tab"
		aria-expanded="false"><i class="" style=""></i>Fichiers joint</a></li>
		<li class=""><a href="#category" data-toggle="tab"
		aria-expanded="false"><i class="" style=""></i>Catégorie</a></li>

</ul>
<div id="myTabContent" class="tab-content">
	<div class="tab-pane fade active in" id="fiche">
		<div class="tab-pane  active" id="fiche-tab">
			<div class="row">
			<div class="col-md-9">
					<div class="user-info-left"
						style="border-right: 1px solid #ddd; padding-left: 6%; padding-top: 4%;">
						<div class="global-info">
							<h4>
								<i class=" fa fa-shopping-cart"></i>Ref:PR24567-435
							</h4>
							<form method="POST" name="product" id="productF">
							<button type="button" class="btn btn-primary pull-right" style="margin-right: 3%;" onclick="location.href='${baseURL}/product/update?id=${user.id}'">Modifier</button>
							</form>
							<p class="data-row">
								<label class="col-sm-2 ">Libellé:</label>
								<span class="data-value text-red">Machine agricole </span>
							</p>
							<p class="data-row">
								<label class="col-sm-2">Code barres<i class="fa fa-barcode"></i></label>
								<span class="">3457758939 </span>
							</p>
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2">Nature:</label><span class="data-value">
									Manufacturé</span>
							</p>
							
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2 ">Quantité:</label><span
									class="data-value">250 unités</span>
							</p>
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2 ">Quantité:</label><span
									class="data-value">250 unités</span>
							</p>
							<p class="data-row">
								<label class="col-sm-2">Poids:</label><span
									class="data-value">25 Kg</span>
							</p>
							<hr class="bs-docs-separator ">
							<p>
								<label class="col-sm-2 ">Longueur:</label><span
									class="data-value">125cm</span>
							</p>
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2">Surface</label> <span
									class="data-value">25 m</span>
							</p>
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2">Volume:</label><span
									class="data-value">2 m3</span>
							</p>
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2">Prix:</label><span
									class="data-value"> 23.000 DH</span>
							</p>
							<hr class="bs-docs-separator ">
							<p>
								<label class="col-sm-2">Description:</label> <span
									class="data-value">Mandhhgffsytfdhfjfklshdtfkkfk</span>
							</p>

						</div>


					</div>
				</div>
				<div class="col-md-3">
					<div class="user-info-right"
						style="text-align: center; padding: 21% 0">
						<img src="${baseURL}/img/produit.jpg" alt="Profile Picture"
							class="img-thumbnail">
						<h3>
							<c:out value="${user.name} ${user.lastName}" />
						</h3>
						<div class="">
							<div id="statut">
								Statut &nbsp;
								<c:choose>
									<c:when test="${user.active}">
										<div id="statut" class="label label-success">Active</div>
									</c:when>
									<c:otherwise>
										<div id="statut" class="label label-danger">innactive</div>
									</c:otherwise>
								</c:choose>
							</div>

						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<div class="tab-pane fade" id="stock"> <h3>bhalal</h3></div>
	<div class="tab-pane fade" id="fichierjoint"> <h3>bhalal</h3></div>
	<div class="tab-pane fade" id="category"> <h3>categoriiii<br/>catatta</h3></div>
	
</div>
</div>


<script type="text/javascript">
    $('#tabs a').click(function (e) {
    	  e.preventDefault()
    	  $(this).tab('show')
    	})
</script> 