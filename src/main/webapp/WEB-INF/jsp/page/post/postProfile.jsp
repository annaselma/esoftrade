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
				Poste</a></li>
		<li class=""><a href="#perso" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-user" style=""></i>&nbsp;Liste du Personnel</a></li>
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
														value="${poste.ref}" /></strong></u></span>
									</div>
									<table class="table">
										<tbody>
										   <tr>
												<th><label>Jugement:</label></th>
												<td><c:choose>
										<c:when test="${poste.productif}">
											<div id="productif" class="label label-success">Productif</div>
										</c:when>
										<c:otherwise>
											<div id="productif" class="label label-danger">Non productif</div>
										</c:otherwise>
									</c:choose></td>
											</tr>
											<tr>
												<th style="width: 50%"><label>NomduPoste:</label></th>
												<td><span class="text-muted"><c:out
															value="${poste.namePoste}" /></span></td>
											</tr>
											<tr>
												<th><label>personnel:</label></th>
												<td><c:out value="${poste.nbPoste}" /></td>
											</tr>
											<tr>
												<th><label>taux horraire:</label></th>
												<td><c:out value="${poste.price}" /></td>
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
		<div class="tab-pane fade${defaultActive} ${defaultIn} " id="perso" >
		<div class="tab-pane " id="fiche-tab">
			<div class="row">
					<div class="col-md-12">
				<table id="list-personnel" class="table table-bordered table-striped">
			<thead>
				<tr>
				    <th>Ref</th>
				    <th>Nom</th>
				    <th>Prénom</th>
				    <th>Login</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr><th>Ref</th>
				    <th>Nom</th>
				    <th>Prénom</th>
				    <th>Login</th>
					<th>Status</th>
				</tr>
			</tfoot>
		</table>
		</div>
		</div>
			</div>
		</div>
		<div class="tab-pane fade ${fileActive} ${fileIn}" id="fichierjoint">
			<h4>Joindre un nouveau fichier:</h4>
			<form method="POST" action="${baseURL}/poste/upload"
				enctype="multipart/form-data" class="form-inline">

				<div class="fileUpload btn btn-xs btn-primary">
					<span><i class="fa fa-upload"></i> &nbsp;choisissez un
						fichier</span> <input type="file" name="file" id="file" class="upload" />
				</div>
				<input type="hidden" name="id" value="${poste.id}"> <input
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
								"url" : "${baseURL}/file/getList?id=${poste.id}&module=Poste",
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
										"orderuser/profile?id=158able" : false,
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
<script type="text/javascript">
        
            $(function() {
                
            	$("#example33").DataTable({});
               var table= $('#list-personnel').DataTable({
                    "paging": true,
                    "lengthChange": true,
                    "searching": true,
                    "ordering": true,
                    "info": true,
                    "autoWidth": true,
                    "processing": true,
                    "serverSide": true,
                    "ajax": {
                        "url": "${baseURL}/poste/getListUserByPost?id=${poste.id}",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },
                    "columnDefs":[{
                    	"targets":[0],
                    	"name":"ref",
                    	"data":"ref",
                    	"render": function ( data, type, full, meta ) {
                    		$link='<small><a href="${baseURL}/user/profile?id='+full.id+'">'+data+'</a></small>';
                    	
                    	      return $link;
                    	    }
                    
                    },
                    {
                    	"targets":[1],
                    	"name":"name",
                    	"data":"name",
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"lastName",
                    	"data":"lastName",
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"login",
                    	"data":"login",
                    
                    },
                    
                    {
                    	"targets":[4],
                    	"name":"active",
                    	"data":"active",
                    	 "render": function ( data, type, full, meta ) {
                    		 $active='<div id="statut" class="label label-success">Actif</div>';
                    		 $inactive='<div id="statut" class="label label-danger">inactif</div>';
                    		 if(data==true){
                    			 return $active;
                    		 }
                    	      return $inactive;
                    	    }
                    
                    }]
                });

          });
        </script>
