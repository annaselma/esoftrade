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
			aria-expanded="false"><i class="fa fa-file"></i>&nbsp;Fiche OF</a></li>
		<li class=""><a href="#settings" data-toggle="tab"
			aria-expanded="false"><i class="fa  fa-money" style=""></i>&nbsp;Bénéfices</a></li>
		<li class="${fileActive}"><a href="#fichierjoint" data-toggle="tab"
			aria-expanded="true"><i class="fa fa-folder" style=""></i>&nbsp;Fichiers joints</a></li>
		<li class=""><a href="#suivi" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-eye" style=""></i>&nbsp;Traçabilité</a></li>

	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade ${defaultActive} ${defaultIn} " id="fiche">
			<div class="tab-pane ${defaultActive}" id="fiche-tab">
				<div class="row">
					<div class="col-md-9">
						<div class="manufacturing-info-left"
							style="padding-left: 1%; padding-top: 4%;">
							<div class="global-info">
									<div class=" col-sm-12 table-responsive">
										<div class="" style="margin-bottom: 4%;">
											<label class=""> Ordre de fabrication N°</label> &nbsp;<span class="text-warning"><u><strong><c:out
													value="${manufacturing.ref}" /></strong></u></span>
<button type="button" class="btn-sm btn btn-success pull-right "onclick="location.href='${baseURL}/mouvement/correctionProduit?id=${manufacturing.product.id}'">
<i class="fa fa-wrench"></i>&nbsp;Stocké</button>								
										<div style="margin-top:8%">
				                        <label>Statut:</label>&nbsp;<span id="status" class="label label-primary" ><c:out value="${manufacturing.status}"/></span>
										<label style="margin-left:63%;">Priorité:</label>&nbsp;<span id="priority" class="label label-primary" ><c:out value="${manufacturing.priority}"/></span>
										</div>
							            </div>
										<table class="table">
											<tbody>
												<tr>
													<th style="width: 50%"><label>Produit:</label></th>
													<td>
							<a href="<c:out value="${baseURL}/product/profile?id=${manufacturing.product.id}"/>"><c:out value="${manufacturing.product.libelle}" /></a>
						 </span></td>
												</tr>
												<tr>
													<th style="width: 50%"><label>Titre:</label></th>
													<td><span class="text-muted"><c:out value="${manufacturing.title}" /></span></td>
												</tr>
												<tr>
													<th><label>Equipe:</label></th>
													<td><c:out value="${manufacturing.team}"/></td>
												</tr>
											
												<tr>
													<th><label>Responsable:</label></th>
													<td><c:out value="${manufacturing.responsible.name}"/></td>
												</tr>
												<tr>
													<th><label>Date début OF:</label></th>
													<td>Le:&nbsp;<fmt:formatDate pattern="dd/MM/yyyy" value="${manufacturing.startDate}" /></td>
												</tr>
												<tr>
													<th><label>Date fin OF:</label></th>
													<td>Le:&nbsp;<fmt:formatDate pattern="dd/MM/yyyy" value="${manufacturing.endDate}" /></td>
												</tr>
												<tr>
													<th><label>Quantité lancée</label></th>
													<td><c:out value="${manufacturing.lanchedQT}"/></td>
												</tr>
												<tr>
													<th><label>Quantité rélisée</label></th>
													<td><c:out value="${manufacturing.executedQT}"/></td>
												</tr>
												<tr>
													<th><label>Quantité rebutée</label></th>
													<td><c:out value="${manufacturing.rejectQT}"/></td>
												</tr>
												<tr>
													<th><label>Quantité restante</label></th>
													<td><c:out value="${manufacturing.restToDoQT}"/></td>
												</tr>
												<tr>
													<th><label>Quantité necessaire</label></th>
													<td><c:out value="${manufacturing.requeredQT}"/></td>
												</tr>
												<tr>
													<th><label>Description:</label></th>
													<td><c:out value="${manufacturing.description}" escapeXml="false" /></td>
												</tr>
											</tbody>
										</table>
									</div>
							</div>


						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<form method="POST" name="manufacturing" id="orderF">
							<button type="button" class="btn-sm btn btn-primary pull-right "
									style="margin-top: 12%; margin-right: 2%;"
									onclick="location.href='${baseURL}/manufacturing/update?id=${manufacturing.id}'"><i class="fa fa-pencil-square-o "></i> &nbsp;Modifier</button>
							<button type="submit" class="btn-sm btn btn-danger btn pull-right "
					style="margin-top:12%;margin-right:5%;"><i class="fa fa-print"></i> &nbsp;Imprimer PDF</button>	
						
							</form>
						</div>
						<div class="user-info-right"
							style="text-align: center; padding: 21% 0; margin-top: 22%; margin-right: 7%;">
							<c:choose>
							<c:when test="${empty manufacturing.picture }">
							     	<c:set var="imageURL" value="${baseURL}/img/Order.png" />
                                </c:when>
								<c:when test="${manufacturing.picture.id == 0}">
							     	<c:set var="imageURL" value="${baseURL}/img/Order.png" />
                                </c:when>
								<c:otherwise>
								     <c:set var="imageURL" value="${baseURL}/file/?id=${manufacturing.picture.id}" />
								</c:otherwise>
							</c:choose>
							<img src="${imageURL}" alt="imageOF"
								class="img-thumbnail">
							<form id="upload-image" method="POST"
								action="${baseURL}/manufacturing/image"
								enctype="multipart/form-data" class="form-inline">

								<div class="fileUpload btn btn-xs btn-primary">
									<span><i class="fa fa-download"></i>changer l'image</span> <input
										type="file" name="file" class="upload" />
								</div>

								<input type="hidden" name="id" value="${manufacturing.id}"> <input
									type="submit" value="valider" class="btn btn-xs btn-success"
									style="display: none;">

							</form>
							<span id="image-errors" class="error" style="display: none;"></span>


							<script type="text/javascript">
							$(document).ready(function(){
								$(' .user-info-right input[type=file]').bind('change', function(event) {
									var ext = $(this).val().split('.').pop().toLowerCase();
									$img=' .user-info-right .img-thumbnail';
									$image_erreur='#image-errors';
									$submit='.user-info-right input[type=submit]';
									
									if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
										$($image_erreur).text("les types acceptés sont: gif ou png ou jpg ou jpeg ");
										$($image_erreur).show(100);
									    return;
									}
									if (this.files[0].size > 10000000) {
										$($image_erreur).text("la taille de l'image ne doit pas dépasser 10 Mo")
										$($image_erreur).show(100);
									} else {
										var reader = new FileReader();
										reader.onload = function (e) {
								            $($img).attr('src', e.target.result);
								            $($img).css('opacity','0.5');
								        }
								        reader.readAsDataURL(this.files[0]);
										$($image_erreur).hide(100);
										$($submit).show(100);
										
									}

								});
							});

							</script>
						</div>
					</div>

				</div>

			</div>

		</div>
	<div class="tab-pane fade ${fileActive} ${fileIn}" id="settings">
	<div class="tab-pane ${defaultActive}" id="fiche-tab">
*
		<table class="table">
											<tbody>
											
												<tr>
													<th><label>Coût total réel calculé:</label></th>
													<td>23.00 DH</td>
												</tr>
												<tr>
													<th><label>Coût total théorique calculé:</label></th>
													<td>234.00 DH</td>
												</tr>
												<tr>
													<th><label>Coût unitaire:</label></th>
													<td>12.540 DH</td>
												</tr>
												
							             </tbody>
							             </table>
		</div>
</div>
		<div class="tab-pane fade ${fileActive} ${fileIn}" id="fichierjoint">
			<h4>Joindre un nouveau fichier:</h4>
			<form method="POST" action="${baseURL}/manufacturing/upload"
				enctype="multipart/form-data" class="form-inline">

				<div class="fileUpload btn btn-xs btn-primary">
					<span><i class="fa fa-upload"></i> &nbsp;choisissez un fichier</span> <input
						type="file" name="file" id="file" class="upload" />
				</div>
				<input type="hidden" name="id" value="${manufacturing.id}"> <input
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
				
					<tr class=" box box-solid bg-">
						<th class=""><label class="">Créé par:</label></th>
						<td><img src="${baseURL}/file?id=${manufacturing.creator.picture.id}" class="img-circle" alt="User Image" style="width: 29px; height: 28px;"><span class="data-value label label-inverse">
							<a href="<c:out value="${baseURL}/user/profile?id=${manufacturing.creator.id}"/>"><c:out
															value="${manufacturing.creator.lastName} ${manufacturing.creator.firstName}" /></a>
						 </span></td>
					</tr>
					<tr>
						<th><label>Date création:</label></th>
						<td>Le:&nbsp;<fmt:formatDate
									pattern="dd/MM/yyyy" value="${manufacturing.createDate}" /></td>
					</tr>
					<tr class=" box box-solid bg-">
						<th><label>Modifié par:</label></th>
						<td><img src="${baseURL}/file?id=${manufacturing.modifier.picture.id}" class="img-circle" alt="User Image" style="width: 29px; height: 28px;"><span class="data-value label label-important">
							<a href="<c:out value="${baseURL}/user/profile?id=${manufacturing.modifier.id}"/>"><c:out
															value="${manufacturing.modifier.lastName} ${manufacturing.modifier.firstName}" /></a>
						 </span></td>
					</tr>
					<tr>
						<th>Date de modification:</th>
						<td><span class="data-value">Le:&nbsp;<fmt:formatDate
									pattern="dd/MM/yyyy" value="${manufacturing.lastEdit}" /></span></td>
					</tr>

				</tbody>
			</table>
		</div>
		</div>

		</div>
	
		
	</div>
<script type="text/javascript">
    $('#tabs a').click(function (e) {
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
                        "url": "${baseURL}/file/getList?id=${manufacturing.id}&module=OrderManufacturing",
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
                    		 $html='<a href="${baseURL}/manufacturing/deleteFile?id='+data+'"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
                    		 return $html;
                    	    }
                    
                    }
                    ]
                });});
        </script>
        <script type="text/javascript">
        $(document).ready(function() {
        	switch ($("#priority").text()){
    	     case  "Urgent":
    	    	 $("#priority").css("background-color","indigo");
    	    	 $("#priority").text("urgent");
    	    	 break;
    	     case  "Low":
    	    	 $("#priority").css("background-color","dimgrey");
    	    	 $("#priority").text("faible");
   	    	 break;
    	   case  "Medium":
    		   $("#priority").css("background-colorr","steelblue");
  	    	 $("#priority").text("faible");
 	    	 break;
    	  case  "High":
    		  $("#priority").css("background-color","blue");
 	    	 $("#priority").text("élevé");
	    	 break;
    	  case  "Critical":
    		  $("#priority").css("background-color","crimson");
 	    	 $("#priority").text("critique");
	    	 break;
	      default:
	    	  }
	    	  switch ($("#status").text()){
	    	     case  "end":
	    	    	 $("#status").css("background-color","indigo");
	    	    	 $("#status").text("fini");
	    	    	 break;
	    	     case  "inpreparation":
	    	    	 $("#status").css("background-color","teal");
	    	    	 $("#status").text("en préparation");
	   	    	 break;
	    	   case  "blocked":
	    		   $("#status").css("background-colorr","tomato");
	  	    	 $("#status").text("bloqué");
	 	    	 break;
	    	  case  "notcharged":
	    		  $("#status").css("background-color","blue");
	 	    	 $("#status").text("non chargé");
		    	 break;
	    	  case  "charged":
	    		  $("#status").css("background-color","crimson");
	 	    	 $("#status").text("chargé");
		    	 break;
	    	  case  "onProduction":
	    		  $("#status").css("background-color","dark");
	 	    	 $("#status").text("en production");
		    	 break;
	    	  case  "waiting":
	    		  $("#status").css("background-color","rebeccapurple");
	 	    	 $("#status").text("en attente");
		    	 break;
	    	  case  "canceled":
	    		  $("#status").css("background-color","darkblue");
	 	    	 $("#status").text("annulé");
		    	 break;
		      default:
		    	  }
    	});
</script>
