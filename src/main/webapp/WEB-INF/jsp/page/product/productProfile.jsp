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
			aria-expanded="false"><i class="fa fa-file"></i>&nbsp;Fiche Produit</a></li>
		<li class=""><a href="#stock" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-truck" style=""></i>&nbsp;Stock</a></li>
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
						<div class="">
							<form method="POST" name="product" id="productF">
								<button type="button" class="btn btn-primary pull-right "
									style="margin-top: 10%; margin-right: 3%;"
									onclick="location.href='${baseURL}/product/update?id=${product.id}'">
									<i class="fa fa-pencil-square-o"></i>&nbsp;Modifier
								</button>
							</form>
						</div>
						<div class="user-info-right"
							style="text-align: center; padding: 21% 0; margin-top: 22%; margin-right: 7%;">
							<c:choose>
							<c:when test="${empty product.picture }">
							     	<c:set var="imageURL" value="${baseURL}/img/product.png" />
                                </c:when>
								<c:when test="${product.picture.id == 0}">
							     	<c:set var="imageURL" value="${baseURL}/img/product.png" />
                                </c:when>
								<c:otherwise>
								     <c:set var="imageURL" value="${baseURL}/file/?id=${product.picture.id}" />
								</c:otherwise>
							</c:choose>
							<img src="${imageURL}" alt="image produit"
								class="img-thumbnail">
							<form id="upload-image" method="POST"
								action="${baseURL}/product/image"
								enctype="multipart/form-data" class="form-inline">

								<div class="fileUpload btn btn-xs btn-primary">
									<span><i class="fa fa-download"></i>changer l'image</span> <input
										type="file" name="file" class="upload" />
								</div>

								<input type="hidden" name="id" value="${product.id}"> <input
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

							<div class="">
								<div id="vente">
									En vente &nbsp;
									<c:choose>
										<c:when test="${product.sellingState}">
											<div id="vente" class="label label-success">
												<label>Oui</label>
											</div>
										</c:when>
										<c:otherwise>
											<div id="vente" class="label label-danger">
												<label>Non</label>
											</div>
										</c:otherwise>
									</c:choose>
								</div>

							</div>
							<div class="">
								<div id="achat">
									En Achat &nbsp;
									<c:choose>
										<c:when test="${product.purchasingState}">
											<div id="achat" class="label label-success">
												<label>Oui</label>
											</div>
										</c:when>
										<c:otherwise>
											<div id="achat" class="label label-danger">
												<label>Non</label>
											</div>
										</c:otherwise>
									</c:choose>
								</div>

							</div>

						</div>
					</div>

				</div>

			</div>

		</div>
	<div class="tab-pane fade" id="stock">
	<div class="">
		<table id="list1" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Entrepot</th>
					<th>Unités</th>
					<th>corriger Stock</th>
					<th>Transfert</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<th>Entrepot</th>
					<th>Unités</th>
					<th>corriger Stock</th>
					<th>Transfert</th>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
		<div class="tab-pane fade ${fileActive} ${fileIn}" id="fichierjoint">
			<h4>Joindre un nouveau fichier:</h4>
			<form method="POST" action="${baseURL}/product/upload"
				enctype="multipart/form-data" class="form-inline">

				<div class="fileUpload btn btn-xs btn-primary">
					<span><i class="fa fa-upload"></i> &nbsp;choisissez un fichier</span> <input
						type="file" name="file" id="file" class="upload" />
				</div>
				<input type="hidden" name="id" value="${product.id}"> <input
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
				<tr class=" box box-solid bg-red"><th><h5></h5></th><td></td></tr>
					<tr class=" box box-solid bg-">
						<th class=""><label class="">Créé par:</label></th>
						<td><img src="${baseURL}/file?id=${product.creator.picture.id}" class="img-circle" alt="User Image" style="width: 29px; height: 28px;"><span class="data-value label label-inverse">
							<a href="<c:out value="${baseURL}/user/profile?id=${product.creator.id}"/>"><c:out
															value="${product.creator.lastName} ${product.creator.firstName}" /></a>
						 </span></td>
					</tr>
					<tr>
						<th><label>Date création:</label></th>
						<td>Le:&nbsp;<fmt:formatDate
									pattern="dd/MM/yyyy" value="${product.createDate}" /></td>
					</tr>
					<tr class=" box box-solid bg-">
						<th><label>Modifié par:</label></th>
						<td><img src="${baseURL}/file?id=${product.modifier.picture.id}" class="img-circle" alt="User Image" style="width: 29px; height: 28px;"><span class="data-value label label-important">
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
               var table= $('#list1').DataTable({
                    "paging": true,
                    "lengthChange": true,
                    "searching": true,
                    "ordering": true,
                    "info": true,
                    "autoWidth": true,
                    "processing": true,
                    "serverSide": true,
                    "ajax": {
                        "url": "${baseURL}/mouvement/getListWarehouseByP?id=${product.id}",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },
                    "columnDefs":[{
                    	"targets":[0],
                    	"name":"warehouse",
                    	"data":"warehouse",
                    	"render": function ( data, type, full, meta ) {
                    		$link='<a href="${baseURL}/product/profile?id='+data.id+'">'+data.name+'</a>';
                           	
                     	      return $link;
                   	    }
                   
                   },
                    {
                    	"targets":[1],
                    	"name":"quantity",
                    	"data":"quantity",
                    
                    },
                    
                    {
                    	"targets":[2],
                    	"name":"product.id",
                    	"data":"product.id",
                    	"orderable":false,
                    	"render": function ( data, type, full, meta ) {
                      		 $link='<a href="${baseURL}/mouvement/correctionProduit?id='+data+'">corrigerStock</a>';
                      	
                      	      return $link;
                      	    }
                    },
                    {
                    	"targets":[3],
                    	"name":"product.id",
                    	"data":"product.id",
                    	"orderable":false,
                    	"render": function ( data, type, full, meta ) {
                      		 $link='<a href="${baseURL}/mouvement/transfertStock?id='+data+'">transférer Stock</a>';
                      	
                      	      return $link;
                      	    }
                    },
                    ]
                });});
        </script>
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
                        "url": "${baseURL}/file/getList?id=${product.id}&module=Product",
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
                    		 $html='<a href="${baseURL}/product/deleteFile?id='+data+'"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
                    		 return $html;
                    	    }
                    
                    }
                    ]
                });});
        </script>
