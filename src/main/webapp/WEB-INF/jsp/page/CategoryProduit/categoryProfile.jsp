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
			aria-expanded="true"><i class="fa fa-file"></i>&nbsp;Fiche Category</a></li>
		<li class=""><a href="#category" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-bars" style=""></i>&nbsp;Liste Produits</a></li>

	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade active in" id="fiche">
			<div class="tab-pane  active" id="fiche-tab">
				<div class="row">
					<div class="col-md-12">
						<div class="category-info"
							style="padding-left: 1%; padding-top: 4%;">
							<div class="global-info">
									<div class=" col-sm-10 table-responsive">
										<table class="table" style="margin-left: 8%;">
											<tbody>
												<tr>
													<th style="width: 50%"><label>Nom:</label></th>
													<td><a class="label label-info"  style="font-size: small;" href="#"><c:out value="${category.name}" /></a></td>
												</tr>
												<tr>
													<th><label>Description:</label></th>
													<td><c:out value="${category.description}" escapeXml="false" /></td>
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
					<th>Rèfèrence</th>
					<th>Libellé</th>
					<th>Code barre</th>
					<th>categorie</th>
					<th>Stock désiré</th>
					<th>Prix en DH</th>
					<th>Vente</th>
					<th>achat</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<th>Rèfèrence</th>
					<th>Libellé</th>
					<th>Code barre</th>
					<th>categorie</th>
					<th>Stock désiré</th>
					<th>Prix en DH</th>
					<th>Vente</th>
					<th>achat</th>
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
                        "url": "${baseURL}/category/getListProduct?id=${category.id}",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },language: {
                        url: '${baseURL}/ajax/fr_FR.json'
                    },
                    "columnDefs":[{
                    	"targets":[0],
                    	"name":"ref",
                    	"data":"ref",
                    
                    },
                    {
                    	"targets":[1],
                    	"name":"libelle",
                    	"data":"libelle",
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"barreCode",
                    	"data":"barreCode",
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"category.name",
                    	"data":"category.name",
                    
                    },
                    {
                    	"targets":[4],
                    	"name":"desieredTreshold",
                    	"data":"desieredTreshold",
                    
                    },
                    {
                    	"targets":[5],
                    	"name":"price",
                    	"data":"price",
                    
                    },
                    {
                    	"targets":[6],
                    	"name":"sellingState",
                    	"data":"sellingState",
                    	"render": function ( data, type, full, meta ) {
                   		 $active='<div id="statut" class="label label-info">en vente</div>';
                   		 $inactive='<div id="statut" class="label label-danger">hors vente</div>';
                   		 if(data==true){
                   			 return $active;
                   		 }
                   	      return $inactive;
                   	    }
                    
                    },
                    {
                    	"targets":[7],
                    	"name":"purchasingState",
                    	"data":"purchasingState",
                    	 "render": function ( data, type, full, meta ) {
                    		 $active='<div id="statut" class="label label-warning">en achat</div>';
                    		 $inactive='<div id="statut" class="label label-danger">hors achat</div>';
                    		 if(data==true){
                    			 return $active;
                    		 }
                    	      return $inactive;
                    	    }
                    
                    }
                    ]
                });});
        </script>
