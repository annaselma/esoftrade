<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<style>
</style>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<c:if test="${not empty stock}">
<div class="alert alert-success alert-message" role="alert">Le produit fabriqué a été correctement stocké </div>
</c:if>
<div class="nav-tabs-custom">
	<ul id="tabs" class="nav nav-tabs">
		<li class="${defaultActive}"><a href="#fiche" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-file"></i>&nbsp;Fiche OF</a></li>
		<li class=""><a href="#settings" data-toggle="tab"
			aria-expanded="false"><i class="fa  fa-money" style=""></i>&nbsp;Coûts de fabrication</a></li>
		<li class=""><a href="#nomenclatures" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-fw fa-bars" style=""></i>&nbsp;Nomenclatures</a></li>
			<li class=""><a href="#gammes" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-fw fa-bars" style=""></i>&nbsp;Gamme</a></li>
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
										<sec:authorize access="hasRole('WRITE_MANUFACTURING')">
										<button type="button"
											class="btn-sm btn btn-danger pull-right "
											onclick="location.href='${baseURL}/mouvement/transfertStockFromOF?id=${manufacturing.id}'">
											<i class="fa fa-wrench"></i>&nbsp;Stocké
										</button>
										<c:if test="${! manufacturing.valid}">
                                        <button type="button"
											class="btn-sm btn btn-info pull-right "
											onclick="location.href='${baseURL}/manufacturing/valid?id=${manufacturing.id}'" style="margin-right: 2%;">
											<i class="fa fa-thumbs-up"></i>&nbsp;Valider
										</button>
										</c:if>	
										<button type="button"
											class="btn-sm btn btn-warning pull-right "
											onclick="location.href='${baseURL}/manufacturing/delete?id=${manufacturing.id}'" style="margin-right: 2%;">
											<i class="fa fa-times"></i>&nbsp;Supprimer
										</button>
										</sec:authorize>
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
											<c:if test="${not empty manufacturing.orderDocument}">
												<tr>
													<th style="width: 50%"><label>Commande Client:</label></th>
													<td><c:out value="${manufacturing.orderDocument.customerReference}" /></td>
												</tr>
											</c:if>	
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
						<sec:authorize access="hasRole('WRITE_MANUFACTURING')">
							<form method="POST" name="manufacturing" id="orderF">
							<button type="button" class="btn-sm btn btn-primary pull-right "
									style="margin-top: 12%; margin-right: 2%;"
									onclick="location.href='${baseURL}/manufacturing/update?id=${manufacturing.id}'"><i class="fa fa-pencil-square-o "></i> &nbsp;Modifier</button>
							<button type="button" class="btn-sm btn btn-success btn pull-right "
					style="margin-top:12%;margin-right:5%;" 
					onclick="location.href='${baseURL}/manufacturing/pdf?id=${manufacturing.id}'"><i class="fa fa-print"></i> &nbsp;Imprimer PDF</button>	
						
							</form>
							</sec:authorize>
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
								<sec:authorize access="hasRole('WRITE_MANUFACTURING')">
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
							</sec:authorize>
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
		<div class="tab-pane fade " id="nomenclatures">
			<div class="tab-pane " id="fiche-tab">
			<div class="row">
			<div  class="col-md-12">
			<sec:authorize access="hasRole('WRITE_NOMENCLATURES')">
			<button type="button" class="btn-sm btn btn-success pull-right "
									style="margin-right: 2%; margin-bottom: 2%"
									 onclick="location.href='${baseURL}/nomenclature/create?of_id=${manufacturing.id}'">
									<i class="fa fa-plus-square "></i> &nbsp;ajouter
								</button>
								</sec:authorize>
								</div> 
								</div>
			<div class="row">
					<div class="col-md-12">
				<table id="list-nom" class="table table-bordered table-striped">
			<thead>
				<tr>
				    <th>Article</th>
					<th>centre</th>
					<th>Quantité nécessaire</th>
					<th>Quantité  Rébutée</th>
					<th>Quantité utilisée</th>
					<th>Quantité manquant</th>
					<th>Cout matière</th>
					<th>Cout matière rèel</th>
					<th>Opération</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
				    <th>Article</th>
					<th>centre</th>
					<th>Quantité nécessaire</th>
					<th>Quantité  Rébutée</th>
					<th>Quantité utilisée</th>
					<th>Quantité manquant</th>
					<th>Cout matière</th>
					<th>Cout matière rèel</th>
					<th>Opération</th>
				</tr>
			</tfoot>
		</table>
		</div>
		</div>
			</div>
		</div>
		<div class="tab-pane fade " id="gammes">
			<div class="tab-pane " id="fiche-tab">
			<div class="row">
			<div  class="col-md-12">
			<sec:authorize access="hasRole('WRITE_GAMME')">
			<button type="button" class="btn-sm btn btn-success pull-right "
									style="margin-right: 2%; margin-bottom: 2%"
									 onclick="location.href='/esoftrade/gamme/create?of_id=${manufacturing.id}'">
									<i class="fa fa-plus-square "></i> &nbsp;ajouter
								</button>
								</sec:authorize>
								</div> 
								</div>
			<div class="row">
					<div class="col-md-12">
				<table id="list-gamme" class="table table-bordered table-striped">
			<thead>
				<tr>
				    <th>Ref</th>
				    <th>Nombre de postes</th>
				    <th>Type</th>
					<th>Date début</th>
					<th>Date Fin</th>
					<th>createdQT</th>
					<th>status</th>
					<th>Opérations</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr><th>Ref</th>
				    <th>Nombre de postes</th>
				    <th>Type</th>
					<th>Date début</th>
					<th>Date Fin</th>
					<th>createdQT</th>
					<th>status</th>
					<th>Opérations</th>
				</tr>
			</tfoot>
		</table>
		</div>
		</div>
			</div>
		</div>
		<div class="tab-pane fade " id="settings">
			<div class="tab-pane " id="fiche-tab">
				<table class="table">
					<tbody>

						<tr>
							<th><label>Coût total réel calculé:</label></th>
							<td><c:out value="${realCost }"/>&nbsp;DH</td>
						</tr>
						<tr>
							<th><label>Coût total théorique calculé:</label></th>
							<td><c:out value="${thCost }"/>&nbsp;DH</td>
						</tr>
							<tr>
							<th><label>Coût unitaire théorique :</label></th>
							<td><c:out value="${thUnitCost}" />&nbsp;DH</td>
						</tr>
						<tr>
							<th><label>Coût unitaire réél:</label></th>
							<td><c:out value="${realUnitCost}" />&nbsp;DH</td>
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
                    }, language: {
                        url: '${baseURL}/ajax/fr_FR.json'
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
 <script type="text/javascript">
        
            $(function() {
//             	   $('#example1 thead th').each( function () {
//                        var title = $('#example1 thead th').eq( $(this).index() ).text();
//                        $(this).prepend( '<input  id="me" type="text" placeholder="Search '+title+'" /><br>' );
//                    } );
                
            	$("#example33").DataTable({});
               var table= $('#list-nom').DataTable({
                    "paging": true,
                    "lengthChange": true,
                    "searching": true,
                    "ordering": true,
                    "info": true,
                    "autoWidth": true,
                    "processing": true,
                    "serverSide": true,
                    "ajax": {
                        "url": "${baseURL}/nomenclature/getList?of_id=${manufacturing.id}",
                        "data": function(data) {
                            planify(data);  
                        } 
                    }, language: {
                        url: '${baseURL}/ajax/fr_FR.json'
                    },
                    "columnDefs":[{
                    	"targets":[0],
                    	"name":"product",
                    	"data":"product",
                    	"render": function ( data, type, full, meta ) {
                    		$link='<small><a href="${baseURL}/product/profile?id='+data.id+'">'+data.libelle+'</a></small>';
                    	
                    	      return $link;
                    	    }
                    
                    },
                    {
                    	"targets":[1],
                    	"name":"product",
                    	"data":"product",
                    	"orderable": false,
                    	"render": function ( data, type, full, meta ) {
                    		$link='<small><a href="${baseURL}/warehouse/profile?id=${manufacturing.center.id}">${manufacturing.center.name}</a></small>';
                    	
                    	      return $link;
                    	    }
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"requeredQt",
                    	"data":"requeredQt",
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"rejectedQt",
                    	"data":"rejectedQt",
                    
                    },
                    {
                    	"targets":[4],
                    	"name":"usedQt",
                    	"data":"usedQt",
                    },
                    {
                    	"targets":[5],
                    	"name":"missingQt",
                    	"data":"missingQt",
                    
                    },
                    {
                    	"targets":[6],
                    	"name":"product",
                    	"data":"product",
                    	"render": function ( data, type, full, meta ) {
                    		$res=data.price*full.requeredQt;
                    	      return $res;
                    	    }
                    },
                    {
                    	"targets":[7],
                    	"name":"cost",
                    	"data":"cost",
                    },
                    {
                    	"targets":[8],
                    	"name":"id",
                    	"data":"id",
                    	"orderable": false,
                    	 "render": function ( data, type, full, meta ) {
                    		 $html='<a href="${baseURL}/nomenclature/profile?id='+data+'"  class="btn btn-info btn-xs"><i class="fa   fa-search"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/nomenclature/update?id='+data+'"  class="btn btn-default btn-xs"><i class="fa   fa-edit"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/nomenclature/delete?id='+data+'&of_id=${manufacturing.id}"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
                    		 return $html;
                    	    }
                    
                    }]
                });
                
          });
        </script>

         <script type="text/javascript">
        
            $(function() {
            	$("#example33").DataTable({});
               var table= $('#list-gamme').DataTable({
                    "paging": true,
                    "lengthChange": true,
                    "searching": true,
                    "ordering": true,
                    "info": true,
                    "autoWidth": true,
                    "processing": true,
                    "serverSide": true,
                    "ajax": {
                        "url": "${baseURL}/gamme/getList?of_id=${manufacturing.id}",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },
                    "columnDefs":[{
                    	"targets":[0],
                    	"name":"ref",
                    	"data":"ref",
                    	"render": function ( data, type, full, meta ) {
                    		$link='<a href="${baseURL}/gamme/profile?id='+full.id+'">'+full.ref+'</a>';
                    	
                    	      return $link;
                    	    }
                    
                    },
                    {
                    	"targets":[1],
                    	"name":"nbposte",
                    	"data":"nbposte",
                    	
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"type",
                    	"data":"type",
                    	"render": function ( data, type, full, meta ) {
                      		 $active='<div id="type" class="label label-success">'+full.type+'</div>';
                      		 $inactive='<div id="type" class="label label-danger">'+full.type+'</div>';
                      		 if(data==true){
                      			 return $active;
                      		 }
                      	      return $inactive;
                      	    }
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"startDate",
                    	"data":"startDate",
                    	"render": function ( data, type, full, meta ) {
                   	      date = new Date(data);
                   	      return date.formatDetail();
                   	    }
                    
                    
                    },
                    {
                    	"targets":[4],
                    	"name":"endDate",
                    	"data":"endDate",
                    	"render": function ( data, type, full, meta ) {
                   	      date = new Date(data);
                   	      return date.formatDetail();
                   	    }
                    },
                    {
                    	"targets":[5],
                    	"name":"createdQt",
                    	"data":"createdQt",
                    
                    },
                    {
                    	"targets":[6],
                    	"name":"end",
                    	"data":"end",
                    	"render": function ( data, type, full, meta ) {
                   		 $active='<div id="end" class="label label-primary">En cours</div>';
                   		 $inactive='<div id="end" class="label label-default">Terminé</div>';
                   		 if(data==false){
                   			 return $active;
                   		 }
                   	      return $inactive;
                   	    }
                    	
                    },
              
                    {
                    	"targets":[7],
                    	"name":"id",
                    	"data":"id",
                    	"orderable": false,
                    	 "render": function ( data, type, full, meta ) {
                    		 $html='<a href="${baseURL}/gamme/profile?id='+data+'"  class="btn btn-info btn-xs"><i class="fa   fa-search"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/gamme/update?id='+data+'"  class="btn btn-default btn-xs"><i class="fa   fa-edit"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/gamme/delete?id='+data+'&of_id=${manufacturing.id}"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
                    		 return $html;
                    	    }
                    
                    }]
                });
                
          });
        </script>