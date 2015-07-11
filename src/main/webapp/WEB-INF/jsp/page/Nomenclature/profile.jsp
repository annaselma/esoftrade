<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
</style>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<div class="nav-tabs-custom">
	<ul id="tabs" class="nav nav-tabs">
		<li class="active"><a href="#fiche" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-file"></i>&nbsp;Fiche
				Nomenclature</a></li>
		<li class=""><a href="#suivi" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-eye" style=""></i>&nbsp;Traçabilité</a></li>

	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade active in " id="fiche">
			<div class="tab-pane active" id="fiche-tab">
				<div class="row">
					<div class="col-md-12">
						<div class="category-info"
							style="padding-left: 1%; padding-top: 4%;">
							<div class="global-info">
								<button type="button" class="btn-sm btn btn-danger pull-right "
									style="margin-right: 2%;" onclick="location.href='${baseURL}/nomenclature/delete?id=${nomenclature.id}'">
									<i class="fa fa-pencil-square-o "></i> &nbsp;Supprimer
								</button>
								<button type="button" class="btn-sm btn btn-primary pull-right "
									style="margin-right: 2%;"
									onclick="location.href='${baseURL}/nomenclature/update?id=${nomenclature.id}'">
									<i class="fa fa-pencil-square-o "></i> &nbsp;Modifier
								</button>
								<button type="button" class="btn-sm btn btn-success pull-right "
									style="margin-right: 2%;" onclick="">
									<i class="fa fa-pencil-square-o "></i> &nbsp;Importer le
									produit
								</button>
								
								
								<div class=" col-sm-12 table-responsive">

									<div class="" style="margin-bottom: 4%;">
										<label class=""> Nomenclature N°</label> &nbsp;<span
											class="text-warning"><u><strong><c:out
														value="${nomenclature.ref}" /></strong></u></span>
									</div>
									<table class="table">
										<tbody>
											<tr>
												<th style="width: 50%"><label>Produit:</label></th>
												<td><a href="${nomenclature.product.id}"><c:out
															value="${nomenclature.product.libelle}" /></a></td>
											</tr>
											<tr>
												<th><label>Notes:</label></th>
												<td><c:out escapeXml="false"
														value="${nomenclature.description}" /></td>
											</tr>
											<tr>
												<th><label>Quantité nécessaire:</label></th>
												<td><span class="label bg-aqua"><c:out
															value="${nomenclature.requeredQt}" /></span></td>
											</tr>
											<tr>
												<th><label>Quantité utilisée:</label></th>
												<td><c:out value="${nomenclature.usedQt}" /></td>
											</tr>
											<tr>
												<th><label>Quantité manquant</label></th>
												<td><c:out value="${nomenclature.missingQt}"
														escapeXml="false" /></td>
											</tr>
											<tr>
												<th><label>Quantité rébutée:</label></th>
												<td><c:out value="${nomenclature.rejectedQt}" /></td>
											</tr>
											<tr>
												<th><label>Quantité importée vers l'atelier:</label></th>
												<td id="importedQte"></td>
											</tr>
											<tr>
												<th><label>Quantité en stock:</label></th>
												<td id="stockQte"> ${qte}</td>
											</tr>
											<tr>
												<th><label>Cout matiére:</label></th>
												<td><c:out value="${nomenclature.cost}" /></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>





			</div>

		</div>

		<div class="tab-pane fade" id="suivi">
			<div class="">
				<table class="table ">
					<tbody>
						
						<tr class=" box box-solid bg-">
							<th class=""><label class="">Créé par:</label></th>
							<td><img
								src="${baseURL}/file?id=${nomenclature.creator.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-inverse"> <a
									href="<c:out value="${baseURL}/user/profile?id=${nomenclature.creator.id}"/>"><c:out
											value="${nomenclature.creator.lastName} ${nomenclature.creator.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th><label>Date création:</label></th>
							<td>Le:&nbsp;<fmt:formatDate pattern="dd/MM/yyyy"
									value="${nomenclature.createDate}" /></td>
						</tr>
						<tr class=" box box-solid bg-">
							<th><label>Modifié par:</label></th>
							<td><img
								src="${baseURL}/file?id=${nomenclature.modifier.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-important"> <a
									href="<c:out value="${baseURL}/user/profile?id=${nomenclature.modifier.id}"/>"><c:out
											value="${nomenclature.modifier.lastName} ${nomenclature.modifier.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th>Date de modification:</th>
							<td><span class="data-value">Le:&nbsp;<fmt:formatDate
										pattern="dd/MM/yyyy" value="${nomenclature.lastEdit}" /></span></td>
						</tr>

					</tbody>
				</table>
			</div>
		</div>

	</div>


</div>
<script type="text/javascript">
	$('#tabs a').click(function(e) {
		e.preventDefault()
		$(this).tab('show')
	})
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({ // ajax call starts
			url : '${baseURL}/nomenclature/importedQte?id=${nomenclature.id}', // JQuery loads serverside.php
			dataType : 'json', // Choosing a JSON datatype
		}).done(function(data) { // Variable data contains the data we get from serverside
			console.log(data);
			if (data != null) {
				$("#importedQte").text(data);
			}
		});

	});
</script>
