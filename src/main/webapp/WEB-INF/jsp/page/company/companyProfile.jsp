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
		<li class="${defaultActive}"><a href="#fiche" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-file"></i>&nbsp;Fiche
				Produit</a></li>
		<li class=""><a href="#contacts" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-truck" style=""></i>&nbsp;Contacts
				/to</a></li>
		<li class=""><a href="#events" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-truck" style=""></i>&nbsp;Commandes
				/to</a></li>
		<li class="${fileActive}"><a href="#fichierjoint"
			data-toggle="tab" aria-expanded="true"><i class="fa fa-folder"
				style=""></i>&nbsp;Fichiers joints</a></li>
		<li class=""><a href="#suivi" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-eye" style=""></i>&nbsp;Traçabilité</a></li>

	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade ${defaultActive} ${defaultIn} " id="fiche">
			<div class="tab-pane ${defaultActive}" id="fiche-tab">
				<div class="row">
					<div class="col-md-9">
						<div class="product-info-left"
							style="padding-left: 1%; padding-top: 4%;">
							<div class="global-info">
								<div class=" col-sm-12 table-responsive">
									<div class="" style="margin-bottom: 4%;"></div>
									<table class="table">
										<tbody>
											<tr>
												<th style="width: 50%"><label>Code client:</label></th>
												<td><span class="text-muted"><c:out
															value="${company.CustomerCode}" /></span></td>
											</tr>
											<tr>
												<th><label>Code fournisseur:</label></th>
												<td><span class="text-muted"><c:out
															value="${company.supplierCode}" /></span></td>
											</tr>
											<tr>
												<th><label>Nom du tiers:</label></th>
												<td><c:out value="${company.name}" /></td>
											</tr>
											<tr>
												<th><label>Adresse:</label></th>
												<td><c:out value="${company.adresse}" /></td>
											</tr>
											<tr>
												<th><label>Code postal:</label></th>
												<td><c:out value="${company.zipCode}" /></td>
											</tr>
											<tr>
												<th><label>Ville:</label></th>
												<td><c:out value="${company.city}" /></td>
											</tr>
											<tr>
												<th><label>Pays:</label></th>
												<td><c:out value="${company.country}" /></td>
											</tr>
											<tr>
												<th><label>Téléphone:</label></th>
												<td><c:out value="${company.telephone}" /></td>
											</tr>
											<tr>
												<th><label>Fax:</label></th>
												<td><c:out value="${company.fax}" /></td>
											</tr>
											<tr>
												<th><label>Email:</label></th>
												<td><c:out value="${company.email}" /></td>
											</tr>
											<tr>
												<th><label>Web:</label></th>
												<td><c:out value="${company.web}" /></td>
											</tr>
											<tr>
												<th><label>Type du tiers:</label></th>
												<td><c:out value="${company.type}" /></td>
											</tr>
											<tr>
												<th><label>Effectif:</label></th>
												<td><c:out value="${company.effective}" /></td>
											</tr>
											<tr>
												<th><label>Capital:</label></th>
												<td><c:out value="${company.capital}" /></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>


						</div>
					</div>
					<div class="col-md-3">
						<div class="">
							<form method="POST" name="company" id="companyF">
								<button type="button" class="btn btn-primary pull-right "
									style="margin-top: 10%; margin-right: 3%;"
									onclick="location.href='${baseURL}/third/update?id=${company.id}'">
									<i class="fa fa-pencil-square-o"></i>&nbsp;Modifier
								</button>
							</form>
						</div>
						<div class="user-info-right"
							style="text-align: center; padding: 21% 0; margin-top: 22%; margin-right: 7%;">
							<c:choose>
								<c:when test="${empty company.picture }">
									<c:set var="imageURL" value="${baseURL}/img/avatar.png" />
								</c:when>
								<c:when test="${company.picture.id == 0}">
									<c:set var="imageURL" value="${baseURL}/img/avatar.png" />
								</c:when>
								<c:otherwise>
									<c:set var="imageURL"
										value="${baseURL}/file/?id=${company.picture.id}" />
								</c:otherwise>
							</c:choose>
							<img src="${imageURL}" alt="image du tiers" class="img-thumbnail">
							<form id="upload-image" method="POST"
								action="${baseURL}/third/image" enctype="multipart/form-data"
								class="form-inline">

								<div class="fileUpload btn btn-xs btn-primary">
									<span><i class="fa fa-download"></i>changer l'image</span> <input
										type="file" name="file" class="upload" />
								</div>

								<input type="hidden" name="id" value="${company.id}"> <input
									type="submit" value="valider" class="btn btn-xs btn-success"
									style="display: none;">

							</form>
							<span id="image-errors" class="error" style="display: none;"></span>


							<script type="text/javascript">
								$(document)
										.ready(
												function() {
													$(
															' .user-info-right input[type=file]')
															.bind(
																	'change',
																	function(
																			event) {
																		var ext = $(
																				this)
																				.val()
																				.split(
																						'.')
																				.pop()
																				.toLowerCase();
																		$img = ' .user-info-right .img-thumbnail';
																		$image_erreur = '#image-errors';
																		$submit = '.user-info-right input[type=submit]';

																		if ($
																				.inArray(
																						ext,
																						[
																								'gif',
																								'png',
																								'jpg',
																								'jpeg' ]) == -1) {
																			$(
																					$image_erreur)
																					.text(
																							"les types acceptés sont: gif ou png ou jpg ou jpeg ");
																			$(
																					$image_erreur)
																					.show(
																							100);
																			return;
																		}
																		if (this.files[0].size > 10000000) {
																			$(
																					$image_erreur)
																					.text(
																							"la taille de l'image ne doit pas dépasser 10 Mo")
																			$(
																					$image_erreur)
																					.show(
																							100);
																		} else {
																			var reader = new FileReader();
																			reader.onload = function(
																					e) {
																				$(
																						$img)
																						.attr(
																								'src',
																								e.target.result);
																				$(
																						$img)
																						.css(
																								'opacity',
																								'0.5');
																			}
																			reader
																					.readAsDataURL(this.files[0]);
																			$(
																					$image_erreur)
																					.hide(
																							100);
																			$(
																					$submit)
																					.show(
																							100);

																		}

																	});
												});
							</script>

							<div class="">
								<div id="status">
									En vente &nbsp;
									<c:choose>
										<c:when test="${company.status == 'inActivity'}">
											<div id="vente" class="label label-success">
												<label>En Activité</label>
											</div>
										</c:when>
										<c:otherwise>
											<div id="vente" class="label label-danger">
												<label>Clos</label>
											</div>
										</c:otherwise>
									</c:choose>
								</div>

							</div>
							<div class="">
								<div id="client">
									<c:if test="${company.customer}">
										<div id="Customer" class="label label-info">
											<label>Client</label>
										</div>
									</c:if>
									<c:if test="${company.supplier}">
										<div id="Customer" class="label label-info">
											<label>Fournisseur</label>
										</div>
									</c:if>
								</div>

							</div>

						</div>
					</div>

				</div>

			</div>

		</div>
		<div class="tab-pane fade" id="contacts">
		<div class="tab-pane fade" id="events">
		</div>
		<div class="tab-pane fade ${fileActive} ${fileIn}" id="fichierjoint">
			<h4>Joindre un nouveau fichier:</h4>
			<form method="POST" action="${baseURL}/third/upload"
				enctype="multipart/form-data" class="form-inline">

				<div class="fileUpload btn btn-xs btn-primary">
					<span><i class="fa fa-upload"></i> &nbsp;choisissez un
						fichier</span> <input type="file" name="file" id="file" class="upload" />
				</div>
				<input type="hidden" name="id" value="${company.id}"> <input
					type="submit" value="valider" class="btn-xs btn btn-success">
			</form>
			<span id="name-file"></span> <span id="file-errors" class="error"
				style="display: none;">la taille du fichier ne doit pas
				dépasser 10 Mo</span>
			<script type="text/javascript">
				$(document)
						.ready(
								function() {
									$('#file')
											.bind(
													'change',
													function() {

														console
																.log(this.files[0]);
														if (this.files[0].size > 10000000) {
															$(
																	'input[type=submit]')
																	.prop(
																			'disabled',
																			true);
															$('#file-errors')
																	.show(1000);
														} else {
															$('#name-file')
																	.text(
																			"vous avez choisi le fichier: "
																					+ this.files[0].name
																					+ " veuillez valider votre choix");
															$(
																	'input[type=submit]')
																	.prop(
																			'disabled',
																			false);
															$('#file-errors')
																	.hide(1000);
														}

													});
								});
			</script>
			<hr>
			<h4>Fichiers et documents joints</h4>
			<table id="file_table" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Docuement</th>
						<th>taille</th>
						<th>créateur</th>
						<th>date</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
				<tfoot>
					<tr>
						<th>Docuement</th>
						<th>taille</th>
						<th>créateur</th>
						<th>date</th>
						<th></th>
					</tr>
				</tfoot>
			</table>

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
								src="${baseURL}/file?id=${company.creator.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-inverse"> <a
									href="<c:out value="${baseURL}/user/profile?id=${company.creator.id}"/>"><c:out
											value="${company.creator.lastName} ${company.creator.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th><label>Date création:</label></th>
							<td>Le:&nbsp;<fmt:formatDate pattern="dd/MM/yyyy"
									value="${company.createDate}" /></td>
						</tr>
						<tr class=" box box-solid bg-">
							<th><label>Modifié par:</label></th>
							<td><img
								src="${baseURL}/file?id=${company.modifier.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-important"> <a
									href="<c:out value="${baseURL}/user/profile?id=${company.modifier.id}"/>"><c:out
											value="${company.modifier.lastName} ${company.modifier.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th>Date de modification:</th>
							<td><span class="data-value">Le:&nbsp;<fmt:formatDate
										pattern="dd/MM/yyyy" value="${company.lastEdit}" /></span></td>
						</tr>

					</tbody>
				</table>
			</div>
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
<script type="text/javascript">
	$(function() {
		var table = $('#file_table')
				.DataTable(
						{
							"paging" : true,
							"lengthChange" : true,
							"searching" : true,
							"ordering" : true,
							"info" : true,
							"autoWidth" : true,
							"processing" : true,
							"serverSide" : true,
							"ajax" : {
								"url" : "${baseURL}/file/getList?id=${company.id}&module=Company",
								"data" : function(data) {
									planify(data);
								}
							},
							"columnDefs" : [
									{
										"targets" : [ 0 ],
										"name" : "name",
										"data" : "name",
										"render" : function(data, type, full,
												meta) {
											$link = '<a href="${baseURL}/file/?id='
													+ full.id
													+ '">'
													+ data
													+ '</a>';

											return $link;
										}

									},
									{
										"targets" : [ 1 ],
										"name" : "length",
										"data" : "length",
										"render" : function(data, type, full,
												meta) {
											$octet = Math.floor((data)
													/ Math.pow(10, 3));
											$result = $octet + " KO";
											return $result;
										}

									},

									{
										"targets" : [ 2 ],
										"name" : "creator",
										"data" : "creator",
										"orderable" : false,
										"render" : function(data, type, full,
												meta) {
											$link = '<a href="${baseURL}/user/profile?id='
													+ data.id
													+ '">'
													+ data.firstName
													+ ' '
													+ data.lastName + '</a>';

											return $link;
										}

									},
									{
										"targets" : [ 3 ],
										"name" : "createDate",
										"data" : "createDate",
										"render" : function(data, type, full,
												meta) {
											date = new Date(data);
											return date.formatDetail();
										}
									},

									{
										"targets" : [ 4 ],
										"name" : "id",
										"data" : "id",
										"orderable" : false,
										"render" : function(data, type, full,
												meta) {
											$html = '<a href="${baseURL}/company/detachFile?id=${company.id}'
													+ '&file_id='+data+'"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
											return $html;
										}

									} ]
						});
	});
</script>
