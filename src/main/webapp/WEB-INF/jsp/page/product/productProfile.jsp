<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<div class="nav-tabs-custom">
	<ul id="tabs" class="nav nav-tabs">
		<li class="active"><a href="#fiche" data-toggle="tab"
			aria-expanded="true"><i class="fa fa-file"></i>&nbsp;Fiche Produit</a></li>
		<li class=""><a href="#stock" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-truck" style=""></i>&nbsp;Stock</a></li>
		<li class=""><a href="#fichierjoint" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-folder" style=""></i>&nbsp;Fichiers joints</a></li>
		<li class=""><a href="#category" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-bars" style=""></i>&nbsp;Catégorie</a></li>

	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade active in" id="fiche">
			<div class="tab-pane  active" id="fiche-tab">
				<div class="row">
					<div class="col-md-9">
						<div class="product-info-left"
							style="padding-left: 1%; padding-top: 4%;">
							<div class="global-info">
									<div class=" col-sm-12 table-responsive">
										<div class="" style="margin-bottom: 4%;">
											<label class=""> Produit N°</label> &nbsp;<span class="text-warning"><u><strong><c:out
													value="${product.ref}" /></strong></u></span>
										</div>
										<table class="table">
											<tbody>
												<tr>
													<th style="width: 50%"><label>Libellé:</label></th>
													<td><span class="text-muted"><c:out value="${product.libelle}" /></span></td>
												</tr>
												<tr>
													<th><label>Code barre:</label></th>
													<td><c:out value="${product.barreCode}" /></td>
												</tr>
												<tr>
													<th><label>Catégorie:</label></th>
													<td><span class="label bg-aqua"><c:out value="${product.category.name}" /></span></td>
												</tr>
												<tr>
													<th><label>Nature:</label></th>
													<td><c:out value="${product.nature}" /></td>
												</tr>
																								<tr>
													<th><label>Description:</label></th>
													<td><c:out value="${product.description}" escapeXml="false" /></td>
												</tr>
												<tr>
													<th><label>Longueur:</label></th>
													<td><c:out value="${product.lenght}" /><i>&nbsp;<strong>m</strong></i></td>
												</tr>
												<tr>
													<th><label>Poids:</label></th>
													<td><c:out value="${product.wheight}" /><i>&nbsp;<strong>Kg</strong></i></td>
												</tr>
												<tr>
													<th><label>Surface:</label></th>
													<td><c:out value="${product.surface}" /><i>&nbsp;<strong>m²</strong></i></td>
												</tr>
												<tr>
													<th><label>Volume:</label></th>
													<td><c:out value="${product.volume}" /><i>&nbsp;<strong>mm²</strong></i></td>
												</tr>
												<tr>
													<th><label>Prix:</label></th>
													<td><c:out value="${product.price}" /><i>&nbsp;<strong>DH</strong></i></td>
												</tr>
											</tbody>
										</table>
									</div>
							</div>


						</div>
					</div>
					<div class="col-md-3">
						<div class="user-info-right"
							style="text-align: center; padding: 21% 0">
							<img src="${baseURL}/img/produit.jpg" alt="Profile Picture"
								class="img-thumbnail">
							<div class="">
								<div id="vente">
									En vente &nbsp;
									<c:choose>
										<c:when test="${product.sellingState}">
											<div id="vente" class="label label-success"><label>Oui</label></div>
										</c:when>
										<c:otherwise>
											<div id="vente" class="label label-danger"><label>Non</label></div>
										</c:otherwise>
									</c:choose>
								</div>

							</div>
							<div class="">
								<div id="achat">
									En Achat &nbsp;
									<c:choose>
										<c:when test="${product.purchasingState}">
											<div id="achat" class="label label-success"><label>Oui</label></div>
										</c:when>
										<c:otherwise>
											<div id="achat" class="label label-danger"><label>Non</label></div>
										</c:otherwise>
									</c:choose>
								</div>

							</div>
							
						</div>
					</div>
					<div>
						<form method="POST" name="product" id="productF">
							<button type="button" class="btn btn-primary pull-right "
								style="margin-top: 30%; margin-right: 3%;"
								onclick="location.href='${baseURL}/product/update?id=${product.id}'">
								<i class="fa fa-pencil-square-o"></i>&nbsp;Modifier
							</button>
						</form>
					</div>
				</div>

			</div>

		</div>
	<div class="tab-pane fade" id="stock">
fdjhdhhdd
		</div>
	
		<div class="tab-pane fade" id="fichierjoint">
			<h3>bhalal</h3>
		</div>
		<div class="tab-pane fade" id="category">
			<h3>
				categoriiii<br />catatta
			</h3>
		</div>

	</div>
</div>
<div class="box box-solid box-primary">
	<div class="box-header">
		<h3 class="box-title fa fa-eye">Traçabilité</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">

		<div class="">
			<table class="table">
				<tbody>
					<tr>
						<th><label class="">Créé par:</label></th>
						<td><img src="${baseURL}/img/salma.jpg" class="img-circle" alt="User Image" style="width: 29px; height: 28px;"><span class="data-value label label-inverse">
							<a href="<c:out value="${baseURL}/user/profile?id=${product.creator.id}"/>"><c:out
															value="${product.creator.lastName} ${product.creator.firstName}" /></a>
						 </span></td>
					</tr>
					<tr>
						<th><label>Date création:</label></th>
						<td>Le:&nbsp;<fmt:formatDate
									pattern="dd/MM/yyyy" value="${product.createDate}" /></td>
					</tr>
					<tr>
						<th><label>Modifié par:</label></th>
						<td><img src="${baseURL}/img/salma.jpg" class="img-circle" alt="User Image" style="width: 29px; height: 28px;"><span class="data-value label label-important">
							<a href="<c:out value="${baseURL}/user/profile?id=${product.modifier.id}"/>"><c:out
															value="${product.modifier.lastName} ${product.modifier.firstName}" /></a>
						 </span></td>
					</tr>
					<tr>
						<th>Date de modification:</th>
						<td><span class="data-value">Le:&nbsp;<fmt:formatDate
									pattern="dd/MM/yyyy" value="${product.lastEdit}" /></span></td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>
</div>
<script type="text/javascript">
    $('#tabs a').click(function (e) {
    	  e.preventDefault()
    	  $(this).tab('show')
    	})
</script>
