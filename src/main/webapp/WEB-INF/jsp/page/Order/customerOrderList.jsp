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
		<h3 class="box-title">Liste des Commandes clients</h3>
		<div class="box-tools pull-right">
			<a class="btn btn-primary btn-sm" href="${baseURL}order/create?type=customerOrder"
				style="color: white;">+ Ajouter Commande Client</a> &nbsp;
		</div>
	</div>
	<!-- /.box-header -->
	<div class="box-body table-responsive">
		<table id="list1" class="table table-bordered table-striped">
			<thead>
				<tr>
				    <th>Référence Client</th>
					<th>Société</th>
					<th>Auteur</th>
					<th>Montant TTC</th>
					<th>Date de commande</th>
					<th>état</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<th>Référence Fournisseur</th>
					<th>Société</th>
					<th>Auteur</th>
					<th>Montant TTC</th>
					<th>Date de commande</th>
					<th>état</th>
					<th>Actions</th>
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
                        "url": "${baseURL}/order/getList?type=customerOrder",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },
                    language: {
                        url: '${baseURL}/ajax/fr_FR.json'
                    },
                    
                    "columnDefs":[{
                    	
                    	
                    	"targets":[0],
                    	"name":"customerReference",
                    	"data":"customerReference",
                    
                    },
                    {
                    	"targets":[1],
                    	"name":"company",
                    	"data":"company",
                    	"render": function ( data, type, full, meta ) {
                    		$link='<a href="${baseURL}/third/profile?id='+data.id+'">'+data.name+'</a>';
                      	
                      	      return $link;
                      	    }
                    },
                    {
                    	"targets":[2],
                    	"name":"creator",
                    	"data":"creator",
                    	"render": function ( data, type, full, meta ) {
                    		$link='<a href="${baseURL}/third/profile?id='+data.id+'">'+data.firstName+' '+data.lastName+'</a>';
                      	
                      	      return $link;
                      	    }
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"totalAmount",
                    	"data":"totalAmount",
                    	"render": function ( data, type, full, meta ) {
                    		$res=data.toFixed(3);
                      	      return $res;
                      	    }
                    	
                    },
                    {
                    	"targets":[4],
                    	"name":"validityDueDate",
                    	"data":"validityDueDate",
                    	"render": function ( data, type, full, meta ) {
                     	      date = new Date(data);
                     	      return date.format();
                     	    }
                    
                    },
                    {
                    	"targets":[5],
                    	"name":"status",
                    	"data":"status",
                    	"render" : function(data, type, full,
								meta) {
                    		//draft, billed, sentOrSaved, notified, denied, delivred, notBilled
							$link = "";
							switch (data) {
							case "draft":
								$link = '<span class="label label-default">Brouillon</span>';
								break;
							case "sentOrSaved":
								$link = '<span class="label label-primary">Envoyé/enregistré</span>';
								break;
							case "notified":
								$link = '<span class="label label-info">notifié</span>';
								break;
							case "denied":
								$link = '<span class="label label-danger">Réfusé</span>';
								break;
							case "delivred":
								$link = '<span class="label label-success">Livré</span>';
								break;
							case "notBilled":
								$link = '<span class="label label-warning">Non facturé</span>';
								break;
							case "billed":
								$link = '<span class="label label-success">Facturé</span>';
								break;
							default:

							}
							return $link;
						}
                    
                    },
                    {
                    	"targets":[6],
                    	"name":"id",
                    	"data":"id",
                    	"orderable": false,
                    	 "render": function ( data, type, full, meta ) {
                    		 $html='<a href="${baseURL}/order/profile?id='+data+'"  class="btn btn-info btn-xs"><i class="fa   fa-search"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/order/update?id='+data+'"  class="btn btn-default btn-xs"><i class="fa   fa-edit"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/order/delete?id='+data+'"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
                    		 return $html;
                    	    }
                    
                    }]
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