<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<div class="box">
	<div class="box-header">
		<h3 class="box-title">Mouvement</h3>
		
	</div>
	<!-- /.box-header -->
	<div class="box-body table-responsive">
		<table id="list1" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Date</th>
					<th>Motif des mouvements</th>
					<th>Origine</th>
					<th>Produit</th>
					<th>Entrepôt</th>
					<th>Auteur</th>
					<th>Unités</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<th>Date</th>
					<th>Motif des mouvements</th>
					<th>Origine</th>
					<th>Produit</th>
					<th>Entrepôt</th>
					<th>Auteur</th>
					<th>Unités</th>
				</tr>
			</tfoot>
		</table>
	</div>
	<!-- /.box-body -->
</div>
<!-- /.box -->
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
                        "url": "${baseURL}/mouvement/getList",
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
                     		 $link='<a href="${baseURL}/manufacturing/profile?id='+full.ofabrication.id+'">'+full.ofabrication.ref+'</a>';
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
                     		 $link='<a href="${baseURL}/warehouse/profile?id='+data.id+'" class=" fa fa-th-large">&nbsp;'+data.name+'</a>';
                     	
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