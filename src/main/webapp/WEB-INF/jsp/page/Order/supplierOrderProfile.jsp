<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
</style>

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<script type="text/javascript" src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
<div class="nav-tabs-custom">
	<ul id="tabs" class="nav nav-tabs">
		<li class="${defaultActive}"><a href="#fiche" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-file"></i>&nbsp;Fiche
				Commande </a></li>
		<li class="${expActive}"><a href="#shipping" data-toggle="tab"
			aria-expanded="false"><i class="fa  fa-truck" style=""></i>&nbsp;Réception vers stock</a></li>
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
					<div class="col-md-12">
						<div class="product-info-left"
							style="padding-left: 1%; padding-top: 0.5%; overflow: hidden">
							<div class="global-info">
								<div class=" col-sm-12 table-responsive">
									<table class="table">
										<tbody>
											<tr>
												<th style="width: 50%"><label>Status:</label></th>
												<td><c:choose>
														<c:when test="${order.status=='draft'}">
															<span class="label label-primary"><fmt:message
																	key="${order.status}" /></span>

														</c:when>
														<c:when test="${order.status=='denied' }">
															<span class="label label-danger"><fmt:message
																	key="${order.status}" /></span>

														</c:when>
														<c:otherwise>
															<span class="label label-success"><fmt:message
																	key="${order.status}" /></span>
														</c:otherwise>
													</c:choose></td>
											</tr>
											<tr>
												<th style="width: 50%"><label>Code Fournisseur:</label></th>
												<td><span class="text-muted"><c:out
															value="${order.supplierReference}" /></span></td>
											</tr>
											<tr>
												<th><label>Société:</label></th>
												<td> <a href="${baseURL}/third/profile?id=${order.company.id}"><c:out
															value="${order.company.name}" /></a></td>
											</tr>
											<tr>
												<th><label>Date:</label></th>
												<td>
												<fmt:formatDate
										pattern="dd/MM/yyyy" value="${order.validityDueDate}" /></tr>
											<tr>
												<th><label>Date Livraison:</label></th>
												<td><fmt:formatDate
										pattern="dd/MM/yyyy" value="${order.deliveryDate}" /></td>
											</tr>
											<tr>
												<th><label>Mode de règlement:</label></th>
												<td><fmt:message key="${order.paymentType}" /></td>
											</tr>
											<tr>
												<th><label>Montant Net:</label></th>
												<td><c:out value="${order.netAmount}" />&nbsp;<b>DHs</b></td>
											</tr>
											<tr>
												<th><label>Montant TTC:</label></th>
												<td><c:out value="${order.totalAmount}" />&nbsp; <b>DHs</b> </td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>


						</div>
						<c:if test="${order.status=='draft'}">
						<div class="box box-success" style="background-color: #f3f4f5; padding-bottom: 0.5%;margin-bottom: 0.5%;">
							<div class="box-header">
								<h3 class="box-title">Ajouter une ligne</h3>
							</div>
							<div class="box-body ">
							<form:form method="POST" commandName="orderLine" action="${baseURL}/order/addOrderLine?order_id=${order.id}"
								id="orderLineF" cssClass="form-inline">
								<div class="form-group  select-product "
									style="vertical-align: top;">
									<label for="product">Produit</label>

									<form:select path="product"
										cssClass="tokenize-sample mono-select  " id="product" size="3">
										<c:if test="${orderLine.product.id >0}">
											<form:option value="${orderLine.product.id}"
												selected="selected">
												<c:out value="${orderLine.product.libelle}" />
											</form:option>
										</c:if>
									</form:select>
									<form:errors path="product" cssClass="error" />
									<form:textarea path="summary" cssClass="form-control" />
									<form:errors path="summary" cssClass="error" />
								</div>

								<div class="form-group "
									style="vertical-align: top; margin-left: 2%">
									<label for="exampleInputName2">TVA</label>
									<form:select path="taxRate" cssClass="form-control"
										style=" width: 100%;">
										<form:option value="0">0%</form:option>
										<form:option value="4">4%</form:option>
										<form:option value="10">10%</form:option>
										<form:option value="15">15%</form:option>
										<form:option value="21">21%</form:option>
									</form:select>
									<form:errors path="taxRate" cssClass="error" />
								</div>
								<div class="form-group "
									style="vertical-align: top; width: 6%; margin-left: 2%">
									<label for="exampleInputName2">P.U. HT</label>
									<form:input id="price" path="unitPrice" cssClass="form-control number" />
									<form:errors path="unitPrice" cssClass="error" />
								</div>
								<div class="form-group "
									style="vertical-align: top; width: 6%; margin-left: 2%">
									<label for="exampleInputName2">Qté</label>
									<form:input path="quantity" cssClass="form-control "
										onkeypress="return  CheckNumber(event);" />
									<form:errors path="quantity" cssClass="error" />
								</div>
								<div class="form-group "
									style="vertical-align: middle; width: 8%; margin-left: 2%">
									<label for="exampleInputName2">Reduction</label>
									<div class="input-group">
									<form:input path="reductionRate" cssClass="form-control number"
										 />
										 <span class="input-group-addon">%</span>
										 </div>
									<form:errors path="reductionRate" cssClass="error" />
								</div>
								<button type="submit" class="btn btn-success"
									style="margin-left: 28%; margin-top: 2.2%">Ajouter</button>

								<script type="text/javascript">
									$('#product').tokenize({
										"newElements" : false,
										maxElements : 1,
										datas : "${baseURL}/product/search",
										valueField : "id",
										textField : "libelle",
									});
									$("#select-product")
											.on(
													"focus",
													".tokenize-sample ",
													function() {
														console.log($(
																".Token span")
																.text());
														$(
																"#select-product .Token")
																.remove();
														$(
																"#select-product select option[selected='selected']")
																.remove();
														$(
																"#select-product .TokenSearch input")
																.val();
													});
								</script>

							</form:form>
							</div>
						</div>
						</c:if>


						<table id="list3" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Description</th>
					<th>TVA</th>
					<th>P.U. HT</th>
					<th>Qte</th>
					<th>Réduction</th>
					<th>Total HT</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${order.lines}" var="line" >
			      <tr>  
			        <td>
			        <a href="${baseURL}/product/profile?id=${line.product.id}"  ><b><c:out value="${line.product.libelle}"/></b> </a>
			         - <c:out value="${line.summary}"/>
			        </td>
					<td><c:out value="${line.taxRate}"/> </td>
					<td><c:out value="${line.unitPrice}"/></td>
					<td><c:out value="${line.quantity}"/></td>
					<td><c:out value="${line.reductionRate}"/></td>
					<td><c:out value="${line.unitPrice- ((line.unitPrice*line.reductionRate)/100)}"/></td>
					<td><a href="${baseURL}/order/detachOrderLine?order_id=${order.id}&id=${line.id}"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a></td>
			</tr>
			
			</c:forEach>
			</tbody>
		</table>

						<div class="" style="margin-top: 1%;">
							<c:choose>
								<c:when test="${order.status=='draft'  }">
									<button type="button"
										class="btn btn-sm btn-primary pull-right "
										style="margin-right: 3%;"
										onclick="location.href='${baseURL}/order/update?id=${order.id}'">
										<i class="fa fa-pencil-square-o"></i>&nbsp;Modifier
									</button>
									<button type="button"
										class="btn btn-sm btn-success pull-right "
										style="margin-right: 3%;"
										onclick="location.href='${baseURL}/order/save?id=${order.id}'">
										<i class="fa  fa-thumbs-o-up"></i>&nbsp;Classer Validé/Envoyé
									</button>
									<button type="button" class="btn btn-sm btn-danger pull-right "
										style="margin-right: 3%;"
										onclick="location.href='${baseURL}/order/denied?id=${order.id}'">
										<i class="fa  fa-thumbs-o-down"></i>&nbsp;Classer Réfusé
									</button>
								</c:when>
								<c:when
									test="${order.status=='sentOrSaved' || order.status=='notified'  || order.status=='notified' }">
									<button type="button"
										class="btn btn-sm btn-primary pull-right "
										style="margin-right: 3%;"
										onclick="location.href='${baseURL}/order/delivred?id=${order.id}'">
										<i class="fa fa-truck"></i>&nbsp;Classer délivré
									</button>
									<button type="button"
										class="btn btn-sm btn-success pull-right "
										style="margin-right: 3%;"
										onclick="location.href='${baseURL}/order/billed?id=${order.id}'">
										<i class="fa   fa-file"></i>&nbsp;Classer Facturé
									</button>
									<button type="button"
										class="btn btn-sm btn-warning pull-right "
										style="margin-right: 3%;"
										onclick="location.href='${baseURL}/order/draft?id=${order.id}'">
										<i class="fa fa-reply"></i>&nbsp; Brouillon
									</button>

								</c:when>
								<c:when test="${order.status=='denied' }">
									<button type="button"
										class="btn btn-sm btn-warning pull-right "
										style="margin-right: 3%;"
										onclick="location.href='${baseURL}/order/draft?id=${order.id}'">
										<i class="fa fa-reply"></i>&nbsp; Brouillon
									</button>
								</c:when>
								<c:otherwise>
									<button type="button"
										class="btn btn-sm btn-warning pull-right "
										style="margin-right: 3%;"
										onclick="location.href='${baseURL}/order/draft?id=${order.id}'">
										<i class="fa fa-reply"></i>&nbsp; Brouillon
									</button>
								</c:otherwise>
							</c:choose>
						</div>
					</div>

				</div>

			</div>

		</div>
		<div class="tab-pane fade ${expActive} ${expIn}" id="shipping" style="overflow: hidden">
          <form:form method="POST" commandName="expedition" action="${baseURL}/order/import"
								id="expeditionF" cssClass="form-inline" style="overflow:hidden;"  >
									<form:errors path="*" cssClass="error" element="div" />
									<form:hidden path="order"/>
											<table id="list4" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Produit</th>
					<th>Quantitée à commandeé</th>
					<th>Quantitée à Ventilée (remplir)</th>
					<th>Entrepot</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${expedition.expeditions}" var="exp" varStatus="i" >
			      <tr>  
			        <td>
			        <a href="${baseURL}/product/profile?id=${exp.product.id}"  ><c:out value="${exp.product.libelle}"/>xz</a>
			        <form:hidden path="expeditions[${ i.index}].product"/>
			        </td>
			        <td><c:out value="${exp.qte}"/></td>
					<td><form:input path="expeditions[${ i.index}].qte" onkeypress="return  CheckNumber(event);"/> 
					<form:hidden path="expeditions[${ i.index}].price"/>
					</td>
					<td id="select_warehouse_${i.index}">
					<form:select path="expeditions[${ i.index}].warehouse"
										cssClass="tokenize-sample mono-select  " id="warehouse_${i.index}" size="3">
										<c:if test="${exp.warehouse.id >0}">
											<form:option value="${exp.warehouse.id}"
												selected="selected">
												<c:out value="${exp.warehouse.name}" />
											</form:option>
										</c:if>
									</form:select>
					<form:hidden path="expeditions[${ i.index}].price"/>
					<script type="text/javascript">
									$('#warehouse_${i.index}').tokenize({
										"newElements" : false,
										maxElements : 1,
										datas : "${baseURL}/warehouse/search",
										valueField : "id",
										textField : "name",
									});
									$("#select-warehouse_${i.index}")
											.on(
													"focus",
													".tokenize-sample ",
													function() {
														console.log($(
																".Token span")
																.text());
														$(
																"#select-warehouse_${i.index} .Token")
																.remove();
														$(
																"#select_warehouse_${i.index} select option[selected='selected']")
																.remove();
														$(
																"#select-warehouse_${i.index} .TokenSearch input")
																.val();
													});
								</script>
					
					</td>
					</tr>
			
			</c:forEach>
			</tbody>
		</table>
								
					<button type="submit" class="btn btn-success"
									style="float: right;">Ventiler</button>			
								
	    </form:form>
	    <hr>
	    <h4>Liste des Expéditions Réalisées</h4>
	    <table id="list5" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Produit</th>
					<th>Quantité Ventilé</th>
					<th>Entrepot</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	    
		</div>
		<div class="tab-pane fade ${fileActive} ${fileIn}" id="fichierjoint">
			<h4>Joindre un nouveau fichier:</h4>
			<form method="POST" action="${baseURL}/order/upload"
				enctype="multipart/form-data" class="form-inline">

				<div class="fileUpload btn btn-xs btn-primary">
					<span><i class="fa fa-upload"></i> &nbsp;choisissez un
						fichier</span> <input type="file" name="file" id="file" class="upload" />
				</div>
				<input type="hidden" name="id" value="${order.id}"> <input
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
								src="${baseURL}/file?id=${order.creator.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-inverse"> <a
									href="<c:out value="${baseURL}/user/profile?id=${order.creator.id}"/>"><c:out
											value="${order.creator.lastName} ${order.creator.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th><label>Date création:</label></th>
							<td>Le:&nbsp;<fmt:formatDate pattern="dd/MM/yyyy"
									value="${order.createDate}" /></td>
						</tr>
						<tr class=" box box-solid bg-">
							<th><label>Modifié par:</label></th>
							<td><img
								src="${baseURL}/file?id=${order.modifier.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-important"> <a
									href="<c:out value="${baseURL}/user/profile?id=${order.modifier.id}"/>"><c:out
											value="${order.modifier.lastName} ${order.modifier.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th>Date de modification:</th>
							<td><span class="data-value">Le:&nbsp;<fmt:formatDate
										pattern="dd/MM/yyyy" value="${order.lastEdit}" /></span></td>
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
            	    $('#list3').DataTable({
            	    	  "searching": false,
            	    	  "ordering" : false,
            	    	  "autoWidth" : false,
            	    	  "paging" : false,
						  "lengthChange" : false,
						  "info":false,
            	    	
            	    });
            	} );
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
								"url" : "${baseURL}/file/getList?id=${order.id}&module=OrderDocument",
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
											$html = '<a href="${baseURL}/order/detachFile?id=${order.id}'
													+ '&file_id='+data+'"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
											return $html;
										}

									} ]
						});
	});
</script>
<script type="text/javascript">
$('.number').keypress(function(event) {
    if(event.which<46 || event.which>59) {
        event.preventDefault();
    } // prevent if not number/dot

    if(event.which == 46 && $(this).val().indexOf('.') != -1) {
        event.preventDefault();
    } 
});
        </script>
<script type="text/javascript">
        
            $(function() {

               var table= $('#list5').DataTable({
                    "paging": true,
                    "lengthChange": true,
                    "searching": false,
                    "ordering": true,
                    "info": false,
                    "autoWidth": true,
                    "processing": true,
                    "serverSide": true,
                    "ajax": {
                        "url": "${baseURL}/mouvement/getListByOrder?order_id=${order.id}",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },
                    "columnDefs":[  {
                    	"targets":[0],
                    	"name":"product",
                    	"data":"product",
                    	"render": function ( data, type, full, meta ) {
                      		 $link='<a href="${baseURL}/product/profile?id='+data.id+'">'+data.libelle+'</a>';
                      	
                      	      return $link;
                      	    }
                    
                    },
                    {
                    	"targets":[1],
                    	"name":"quantity",
                    	"data":"quantity",
                    	"render": function ( data, type, full, meta ) {
                    	      return data;
                    	    }
                    
                    },
                                  
                    {
                    	"targets":[2],
                    	"name":"warehouse",
                    	"data":"warehouse",
                    	"orderable":false,
                    	"render": function ( data, type, full, meta ) {
                     		 $link='<a href="${baseURL}/warehouse/profile?id='+data.id+'" class=" fa fa-th-large">&nbsp;'+data.name+'</a>';
                     	
                     	      return $link;
                     	    }
                    },
                    ]
                });
//               table.columns( ).every( function (i) {
//             	    console.log("index:"+this.index());
//                });
                
//                $('#example1 tfoot th ').on( 'keyup',"#me", function () {
//             	   console.log("hello");
//             	    table
//             	        .columns( 3 )
//             	        .search( this.value )
//             	        .draw();
//             	} );
                
          });
        </script>