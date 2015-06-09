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
		<li class=""><a href="#perso" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-truck" style=""></i>&nbsp;Liste du Personnel</a></li>
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
									<div class="" style="margin-bottom: 4%;">
										<label class=""> Poste N°</label> &nbsp;<span
											class="text-warning"><u><strong><c:out
														value="${post.ref}" /></strong></u></span>
									</div>
									<table class="table">
										<tbody>
											<tr>
												<th style="width: 50%"><label>NomduPoste:</label></th>
												<td><span class="text-muted"><c:out
															value="${post.namePoste}" /></span></td>
											</tr>
											<tr>
												<th><label>personnels:</label></th>
												<td><c:out value="${poste.nbPoste}" /></td>
											</tr>
											<tr>
												<th><label>Catégorie:</label></th>
												<td><span class="label bg-aqua"><c:out
															value="${poste.category.name}" /></span></td>
											</tr>
											
											<tr>
												<th><label>Description:</label></th>
												<td><c:out value="${poste.comment}"
														escapeXml="false" /></td>
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
		<div clas="tab-pane fade${defaultActive} ${defaultIn} " id="perso" >teste</div>
		<div class="tab-pane fade ${fileActive} ${fileIn}" id="fichierjoint">
			<h4>Joindre un nouveau fichier:</h4>
			<form method="POST" action="${baseURL}/poste/upload"
				enctype="multipart/form-data" class="form-inline">

				<div class="fileUpload btn btn-xs btn-primary">
					<span><i class="fa fa-upload"></i> &nbsp;choisissez un
						fichier</span> <input type="file" name="file" id="file" class="upload" />
				</div>
				<input type="hidden" name="id" value="${product.id}"> <input
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
								src="${baseURL}/file?id=${poste.creator.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-inverse"> <a
									href="<c:out value="${baseURL}/user/profile?id=${poste.creator.id}"/>"><c:out
											value="${poste.creator.lastName} ${poste.creator.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th><label>Date création:</label></th>
							<td>Le:&nbsp;<fmt:formatDate pattern="dd/MM/yyyy"
									value="${poste.createDate}" /></td>
						</tr>
						<tr class=" box box-solid bg-">
							<th><label>Modifié par:</label></th>
							<td><img
								src="${baseURL}/file?id=${poste.modifier.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-important"> <a
									href="<c:out value="${baseURL}/user/profile?id=${poste.modifier.id}"/>"><c:out
											value="${poste.modifier.lastName} ${poste.modifier.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th>Date de modification:</th>
							<td><span class="data-value">Le:&nbsp;<fmt:formatDate
										pattern="dd/MM/yyyy" value="${poste.lastEdit}" /></span></td>
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
<script type="text/javascript">
	$(function() {
		var table = $('#list1')
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
								"url" : "${baseURL}/mouvement/getListWarehouseByP?id=${product.id}",
								"data" : function(data) {
									planify(data);
								}
							},
							"columnDefs" : [
									{
										"targets" : [ 0 ],
										"name" : "warehouse",
										"data" : "warehouse",
										"render" : function(data, type, full,
												meta) {
											$link = '<a href="${baseURL}/warehouse/profile?id='
													+ data.id
													+ '">'
													+ data.name + '</a>';

											return $link;
										}

									},
									{
										"targets" : [ 1 ],
										"name" : "quantity",
										"data" : "quantity",

									},

									{
										"targets" : [ 2 ],
										"name" : "product.price",
										"data" : "product.price",

									},
									{
										"targets" : [ 3 ],
										"name" : "product.price",
										"data" : "product.price",
										"orderable" : false,
										"render" : function(data, type, full,
												meta) {
											$priceValorisation = data
													* full.quantity;
											return $priceValorisation;
										}

									},

							]
						});
	});
</script>
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
								"url" : "${baseURL}/file/getList?id=${product.id}&module=Product",
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
											$html = '<a href="${baseURL}/product/deleteFile?id='
													+ data
													+ '"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
											return $html;
										}

									} ]
						});
	});
</script>
