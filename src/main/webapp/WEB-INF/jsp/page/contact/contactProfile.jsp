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
				Contact</a></li>
		<li class=""><a href="#suivi" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-eye" style=""></i>&nbsp;Traçabilité</a></li>

	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade active ${defaultIn} in" id="fiche">
			<div class="tab-pane active" id="fiche-tab">
			<div class="row">
					<div class="col-md-12">
						<div class="product-info-left"
							style="padding-left: 1%; padding-top: 1%;">
							<div class="global-info">
							   <button type="button" class="btn-sm btn btn-danger pull-right "
									style="margin-right: 2%;" onclick="location.href='${baseURL}/contact/delete?id=${contact.id}'">
									<i class="fa fa-pencil-square-o "></i> &nbsp;Supprimer
								</button>
								<button type="button" class="btn-sm btn btn-primary pull-right "
									style="margin-right: 2%;"
									onclick="location.href='${baseURL}/contact/update?id=${contact.id}'">
									<i class="fa fa-pencil-square-o "></i> &nbsp;Modifier
								</button>
								<div class=" col-sm-12 table-responsive">
									<div style="margin-top:1% ;margin-bottom: 2%;padding-left: 2%">
				                        <label>Statut:</label>&nbsp;
										<c:choose>
											<c:when test="${contact.status == 'inActivity'}">
												<span id="status" class="label label-success">En Activité</span>
											</c:when>
											<c:otherwise>
												<span id="status" class="label label-danger">Clos</span>
											</c:otherwise>
										</c:choose>
									</div>
									<table class="table">
										<tbody>
											<tr>
												<th><label>Nom  Complet:</label></th>
												<td><c:out value="${contact.civility}  ${contact.name} ${contact.lastName}" /></td>
											</tr>
											<tr>
												<th><label>Poste/Fonction:</label></th>
												<td><c:out value="${contact.job}" /></td>
											</tr>
											<tr>
												<th><label>Tiers:</label></th>
												<td><a href="${baseURL}/third/profile?id=${contact.company.id}"> <c:out value="${contact.company.name}" /></a></td>
											</tr>
											<tr>
												<th><label>Adresse:</label></th>
												<td><c:out value="${contact.adresse}" /></td>
											</tr>
											<tr>
												<th><label>Code postal:</label></th>
												<td><c:out value="${contact.zipCode}" /></td>
											</tr>
											<tr>
												<th><label>Ville:</label></th>
												<td><c:out value="${contact.city}" /></td>
											</tr>
											<tr>
												<th><label>Pays:</label></th>
												<td><c:out value="${contact.country}" /></td>
											</tr>
											<tr>
												<th><label>Téléphone perso:</label></th>
												<td><c:out value="${contact.telephone}" /></td>
											</tr>
											<tr>
												<th><label>Téléphone pro:</label></th>
												<td><c:out value="${contact.telephonePro}" /></td>
											</tr>
											<tr>
												<th><label>Fax:</label></th>
												<td><c:out value="${contact.fax}" /></td>
											</tr>
											<tr>
												<th><label>Email:</label></th>
												<td><c:out value="${contact.email}" /></td>
											</tr>
											<tr>
												<th><label>Web:</label></th>
												<td><c:out value="${contact.webSite}" /></td>
											</tr>
											<tr>
												<th><label>Date de naissance:</label></th>
												<td><fmt:formatDate 	pattern="dd/MM/yyyy" value="${contact.birdDay}" /></td>
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
						<tr class=" box box-solid bg-red">
							<th><h5></h5></th>
							<td></td>
						</tr>
						<tr class=" box box-solid bg-">
							<th class=""><label class="">Créé par:</label></th>
							<td><img
								src="${baseURL}/file?id=${contact.creator.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-inverse"> <a
									href="<c:out value="${baseURL}/user/profile?id=${contact.creator.id}"/>"><c:out
											value="${contact.creator.lastName} ${contact.creator.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th><label>Date création:</label></th>
							<td>Le:&nbsp;<fmt:formatDate pattern="dd/MM/yyyy"
									value="${contact.createDate}" /></td>
						</tr>
						<tr class=" box box-solid bg-">
							<th><label>Modifié par:</label></th>
							<td><img
								src="${baseURL}/file?id=${contact.modifier.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-important"> <a
									href="<c:out value="${baseURL}/user/profile?id=${contact.modifier.id}"/>"><c:out
											value="${contact.modifier.lastName} ${contact.modifier.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th>Date de modification:</th>
							<td><span class="data-value">Le:&nbsp;<fmt:formatDate
										pattern="dd/MM/yyyy" value="${contact.lastEdit}" /></span></td>
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
<script src="${baseURL}/js/plugins/datatables/jquery.dataTables.js"
	type="text/javascript"></script>
<script src="${baseURL}/js/plugins/datatables/dataTables.bootstrap.js"
	type="text/javascript"></script>
<script
	src="${baseURL}/js/plugins/datatables/dataTables.ColumnFilter.js"
	type="text/javascript"></script>

