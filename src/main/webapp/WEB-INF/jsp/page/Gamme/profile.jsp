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
				Gamme</a></li>
		<li class=""><a href="#suivi" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-eye" style=""></i>&nbsp;Traçabilité</a></li>
			<li class="${fileActive}"><a href="#fichierjoint" data-toggle="tab"
			aria-expanded="true"><i class="fa fa-folder" style=""></i>&nbsp;Fichiers joints</a></li>

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
									style="margin-right: 2%;" onclick="location.href='/esoftrade/gamme/delete?id=${gamme.id}'">
									<i class="fa fa-pencil-square-o "></i> &nbsp;Supprimer
								</button>
								<button type="button" class="btn-sm btn btn-success pull-right "
									style="margin-right: 2%;"
									onclick="location.href='/esoftrade/gamme/update?id=${gamme.id}'">
									<i class="fa fa-pencil-square-o "></i> &nbsp;Modifier
								</button>
								<div class=" col-sm-12 table-responsive">

									<div class="" style="margin-bottom: 4%;"> Gamme N° &nbsp;<strong class="text-warning"><c:out value="${gamme.ref}"/></strong>
									</div>
									<table class="table">
										<tbody>
										<tr>
												<th><label>Désignation:</label></th>
												<td><c:out value="${gamme.designation}" /></td>
											</tr>
											<tr>
												<th><label>Poste associé:</label></th>
												<td><c:out value="${gamme.poste}" /></td>
											</tr>
											<tr>
												<th><label>Nombre de poste:</label></th>
												<td><c:out value="${gamme.nbposte}" /></td>
											</tr>
											<tr>
												<th>Date début </th>
												<td><span class="data-value"> <fmt:formatDate
															pattern="dd/MM/yyyy" value="${gamme.startDate}" /></span></td>
											</tr>
											<tr>
												<th><label>Côut Réél:</label></th>
												<td><c:out value="${gamme.realCost}" /></td>
											</tr>
											<tr>
												<th><label>Côut théorique:</label></th>
												<td><c:out value="${gamme.theocticalCost}" /></td>
											</tr>
											
											
											<tr>
												<th><label>Quantité nécessaire:</label></th>
												<td><span class="label bg-aqua"><c:out
															value="${gamme.realCost}" /></span></td>
											</tr>
											<tr>
												<th><label>Quantité rébutée:</label></th>
												<td><c:out value="${nomenclature.rejectedQt}" /></td>
											</tr>
											<tr>
												<th><label>Description:</label></th>
												<td><c:out escapeXml="false"
														value="${gamme.description}" /></td>
											</tr>
											<tr>
												<th><label>Observation:</label></th>
												<td><c:out escapeXml="false"
														value="${gamme.description}" /></td>
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
		<div class="tab-pane fade ${fileActive} ${fileIn}" id="fichierjoint">
			<h4>Joindre un nouveau fichier:</h4>
			<form method="POST" action="${baseURL}/gamme/upload"
				enctype="multipart/form-data" class="form-inline">

				<div class="fileUpload btn btn-xs btn-primary">
					<span><i class="fa fa-upload"></i> &nbsp;choisissez un fichier</span> <input
						type="file" name="file" id="file" class="upload" />
				</div>
				<input type="hidden" name="id" value="${gamme.id}"> <input
					type="submit" value="valider" class="btn-xs btn btn-success">
			</form>
			<span id="name-file"></span>
			<span id="file-errors" class="error" style="display: none;">la
						taille du fichier ne doit pas dépasser 10 Mo</span>
			<script type="text/javascript">
			$(document).ready(function(){
				$('#file').bind('change', function() {

					console.log(this.files[0]);
					if (this.files[0].size > 10000000) {
						$('input[type=submit]').prop('disabled', true);
						$('#file-errors').show(1000);
					} else {
						$('#name-file').text("vous avez choisi le fichier: "+this.files[0].name+" veuillez valider votre choix");
						$('input[type=submit]').prop('disabled', false);
						$('#file-errors').hide(1000);
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
						<th>date Création</th>
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
						<th>date Création</th>
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
								src="${baseURL}/file?id=${nomenclature.creator.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-inverse"> <a
									href="<c:out value="${baseURL}/user/profile?id=${gamme.creator.id}"/>"><c:out
											value="${gamme.creator.lastName} ${gamme.creator.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th><label>Date création:</label></th>
							<td>Le:&nbsp;<fmt:formatDate pattern="dd/MM/yyyy"
									value="${gamme.createDate}" /></td>
						</tr>
						<tr class=" box box-solid bg-">
							<th><label>Modifié par:</label></th>
							<td><img
								src="${baseURL}/file?id=${gamme.modifier.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-important"> <a
									href="<c:out value="${baseURL}/user/profile?id=${gamme.modifier.id}"/>"><c:out
											value="${gamme.modifier.lastName} ${gamme.modifier.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th>Date de modification:</th>
							<td><span class="data-value">Le:&nbsp;<fmt:formatDate
										pattern="dd/MM/yyyy" value="${gamme.lastEdit}" /></span></td>
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
               var table= $('#file_table').DataTable({
                    "paging": true,
                    "lengthChange": true,
                    "searching": true,
                    "ordering": true,
                    "info": true,
                    "autoWidth": true,
                    "processing": true,
                    "serverSide": true,
                    "ajax": {
                        "url": "${baseURL}/file/getList?id=${gamme.id}&module=Gamme",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },
                    "columnDefs":[{
                    	"targets":[0],
                    	"name":"name",
                    	"data":"name",
                    	"render": function ( data, type, full, meta ) {
                    		$link='<a href="${baseURL}/file/?id='+full.id+'">'+data+'</a>';
                          	
                    	      return $link;
                    	    }
                   
                   },
                    {
                    	"targets":[1],
                    	"name":"length",
                    	"data":"length",
                    	"render": function ( data, type, full, meta ) {
                     		 $octet=Math.floor((data)/Math.pow(10, 3));
                     	     $result=$octet+" KO";
                     	      return $result;
                     	    }
                    
                    },
                    
                    {
                    	"targets":[2],
                    	"name":"creator",
                    	"data":"creator",
                    	"orderable":false,
                    	"render": function ( data, type, full, meta ) {
                    		$link='<a href="${baseURL}/user/profile?id='+data.id+'">'+data.firstName+' '+data.lastName+'</a>';
                      	
                      	      return $link;
                      	    }
                      	    
                    },
                    {
                    	"targets":[3],
                    	"name":"createDate",
                    	"data":"createDate",
                    	"render": function ( data, type, full, meta ) {
                     	      date = new Date(data);
                     	      return date.formatDetail();
                     	    }
                    },
                    
                    {
                    	"targets":[4],
                    	"name":"id",
                    	"data":"id",
                    	"orderable": false,
                    	 "render": function ( data, type, full, meta ) {
                    		 $html='<a href="${baseURL}/gamme/deleteFile?id='+data+'"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
                    		 return $html;
                    	    }
                    
                    }
                    ]
                });});
        </script>

