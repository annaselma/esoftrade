<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="${baseURL}/js/bootstrap-modal.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".btn").click(function(){
		$("#myModal").modal('show');
	});
});
</script>
<!DOCTYPE html>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<div class="nav-tabs-custom">
	<ul id="tabs" class="nav nav-tabs">
		<li class="active"><a href="#fiche" data-toggle="tab"
			aria-expanded="true"><i class="fa fa-file"></i>&nbsp;Fiche entepot</a></li>
		<li class=""><a href="#category" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-bars" style=""></i>&nbsp;Liste Produits</a></li>
			<li class=""><a href="#mouvement" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-bars" style=""></i>&nbsp;Mouvement</a></li>

	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade active in" id="fiche">
			<div class="tab-pane  active" id="fiche-tab">
				<div class="row">
					<div class="col-md-12">
						<div class="warehouse-info"
							style="padding-left: 1%; padding-top: 4%;">
							<div class="global-info">
									<div class=" col-sm-12 table-responsive">
										<table class="table">
											<tbody>
												<tr>
													<th style="width: 50%"><label>Nom:</label></th>
													<td><span class="text-muted"><c:out value="${warehouse.name}" /></span></td>
												</tr>
												<tr>
													<th><label>Adresse:</label></th>
													<td><c:out value="${warehouse.adresse}"/></td>
												</tr>
												
												<tr>
													<th><label>Code Postal:</label></th>
													<td><c:out value="${warehouse.zipCode}"/></td>
												</tr>
												<tr>
													<th><label>Ville:</label></th>
													<td><c:out value="${warehouse.city}"/></td>
												</tr>
												<tr>
													<th><label>Pays:</label></th>
													<td><c:out value="${warehouse.country}"/></td>
												</tr>
												<tr>
													<th><label>Description:</label></th>
													<td><c:out value="${warehouse.description}" escapeXml="false" /></td>
												</tr>
											</tbody>
										</table>
									</div>
							</div>


						</div>
					</div>
					
					<div>
						<form method="POST" name="category" id="categoryF">
							<button type="button" class="btn btn-primary pull-right "
								style="margin-top: 22%; margin-right: 4%;"
								onclick="location.href='${baseURL}/category/update?id=${category.id}'">
								<i class="fa fa-pencil-square-o"></i>&nbsp;Modifier
							</button>
						</form>
					</div>
				</div>

			</div>

		</div>
		<div class="tab-pane fade" id="category">
			
		<div class="box">
	<div class="box-header">
		<h3 class="box-title">la liste des produits</h3>
	</div>
	<!-- /.box-header -->
	<div class="box-body table-responsive">
		<table id="list1" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Produit</th>
					<th>Unité</th>
					<th>prix de vente unitaire</th>
					<th>valorisation</th>
					<th>Transférer</th>
					<th>Coriger</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<th>Produit</th>
					<th>Unité</th>
					<th>prix de vente unitaire</th>
					<th>valorisation</th>
					<th>Transférer</th>
					<th>Coriger</th>
				</tr>
			</tfoot>
		</table>
	</div>
	<!-- /.box-body -->
</div>
<!-- /.box -->
		</div>
		
		<div class="tab-pane fade" id="mouvement">
			
		<div class="box">
	<div class="box-header">
		<h3 class="box-title">la liste des mouvements</h3>
	</div>
	<!-- /.box-header -->
	<div class="box-body table-responsive">
		<table id="list2" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Date</th>
					<th>Libellé du mouvement</th>
					<th>Origine</th>
					<th>Produit</th>
					<th>Entrepot</th>
					<th>Auteur</th>
					<th>Unité</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<th>Date</th>
					<th>Libellé du mouvement</th>
					<th>Origine</th>
					<th>Produit</th>
					<th>Entrepot</th>
					<th>Auteur</th>
					<th>Unité</th>
				</tr>
			</tfoot>
		</table>
	</div>
	<!-- /.box-body -->
</div>
<!-- /.box -->
		</div>

	</div>
</div>


<script type="text/javascript">
    $('#tabs a').click(function (e) {
    	  e.preventDefault()
    	  $(this).tab('show')
    	})
</script>
<!-- DATA TABES SCRIPT -->
<script src="${baseURL}/js/plugins/datatables/jquery.dataTables.js"
	type="text/javascript"></script>
<script src="${baseURL}/js/plugins/datatables/dataTables.bootstrap.js"
	type="text/javascript"></script>
<script
	src="${baseURL}/js/plugins/datatables/dataTables.ColumnFilter.js"
	type="text/javascript"></script>
<script type="text/javascript">
        
            $(function() {
//             	   $('#example1 thead th').each( function () {
//                        var title = $('#example1 thead th').eq( $(this).index() ).text();
//                        $(this).prepend( '<input  id="me" type="text" placeholder="Search '+title+'" /><br>' );
//                    } );
                
            	$("#example33").DataTable({});
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
                        "url": "${baseURL}/mouvement/getProductListByWarehouse?id=${warehouse.id}",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },
                    "columnDefs":[{
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
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"product.price",
                    	"data":"product.price",
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"product.price",
                    	"data":"product.price",
                    	"orderable":false,
                    	"render": function ( data, type, full, meta ) {
                    		$priceValorisation=data*full.quantity;
                      	      return $priceValorisation;
                      	    }
                    
                    },
                    
                    {
                    	"targets":[4],
                    	"name":"product.id",
                    	"data":"product.id",
                    	"orderable":false,
                    	"render": function ( data, type, full, meta ) {
                      		 $link='<a href="#">corrigerStock</a>';
                      	
                      	      return $link;
                      	    }
                    	
                    },
                    {
                    	"targets":[5],
                    	"name":"product.id",
                    	"data":"product.id",
                    	"orderable":false,
                    	"render": function ( data, type, full, meta ) {
                      		 $link='<a href="#">transférer Stock</a>';
                      	
                      	      return $link;
                      	    }
                    }
               
   
                    ]
                });});
        </script>
        <script type="text/javascript">
        
            $(function() {
               var table= $('#list2').DataTable({
                    "paging": true,
                    "lengthChange": true,
                    "searching": true,
                    "ordering": true,
                    "info": true,
                    "autoWidth": true,
                    "processing": true,
                    "serverSide": true,
                    "ajax": {
                        "url": "${baseURL}/mouvement/getListByWarehouse?id=${warehouse.id}",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },
                    "columnDefs":[{
                    	"targets":[0],
                    	"name":"createDate",
                    	"data":"createDate",
                    	"render": function ( data, type, full, meta ) {
                   	      date = new Date(data);
                   	      return date.formatDetail();
                   	    }
                   
                   },
                    {
                    	"targets":[1],
                    	"name":"motif",
                    	"data":"motif",
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"type",
                    	"data":"type",
                    	"render": function ( data, type, full, meta ) {
                    		$link="";
                     	     switch (data){
                     	     case  "invoice":
                     	    	$link='<a href="#">invoice</a>';
                     	    	 break;
                     	    case  "shipping":
                     	    	$link='<a href="#">Bon de Livraison</a>';
                    	    	 break;
                     	   case  "supplierOrder":
                     		  $link='<a href="#">commande fournisseur</a>';
                  	    	 break;
                     	  case  "manufacturing":
                     		 $link='<a href="#">Ordre de fabrication</a>';
                 	    	 break;
                 	      default:
                 	    	  
                     	     }
                     	     return $link;
                     	    }
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"product",
                    	"data":"product",
                    	"render": function ( data, type, full, meta ) {
                      		 $link='<a href="${baseURL}/product/profile?id='+data.id+'">'+data.libelle+'</a>';
                      	
                      	      return $link;
                      	    }
                    
                    },
                    
                    {
                    	"targets":[4],
                    	"name":"warehouse",
                    	"data":"warehouse",
                    	"orderable":false,
                    	"render": function ( data, type, full, meta ) {
                     		 $link='<a href="${baseURL}/warehouse/profile?id='+data.id+'">'+data.name+'</a>';
                     	
                     	      return $link;
                     	    }
                    },
                    {
                    	"targets":[5],
                    	"name":"creator",
                    	"data":"creator",
                    	"orderable":false,
                    	"render": function ( data, type, full, meta ) {
                    		$link='<a href="${baseURL}/user/profile?id='+data.id+'">'+data.firstName+' '+data.lastName+'</a>';
                      	
                      	      return $link;
                      	    }
                    },
                    {
                    	"targets":[6],
                    	"name":"quantity",
                    	"data":"quantity",
                    
                    },
                    ]
                });});
        </script>
        
        
        
