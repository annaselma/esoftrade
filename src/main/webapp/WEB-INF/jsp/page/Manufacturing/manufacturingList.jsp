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
		<h3 class="box-title">la liste des OF</h3>
		<div class="box-tools pull-right">
			<a class="btn btn-primary btn-sm" href="${baseURL}/manufacturing/create"
				style="color: white;">+new Order</a> &nbsp;
		</div>
	</div>
	<!-- /.box-header -->
	<div class="box-body table-responsive">
		<table id="list1" class="table table-bordered table-striped">
			<thead>
				<tr>
				    <th>Ref.</th>
					<th>Titre</th>
					<th>Date début</th>
					<th>Date fin</th>
					<th>Deadline</th>
					<th>Progress</th>
					<th>Priorité</th>
					<th>Leader</th>
					<th>Statut</th>
					<th>Opération</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
				    <th>Ref.</th>
					<th>Titre</th>
					<th>Date début</th>
					<th>Date fin</th>
					<th>Deadline</th>
					<th>Progress</th>
					<th>Priorité</th>
					<th>Leader</th>
					<th>Statut</th>
					<th>Opération</th>
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
                        "url": "${baseURL}/manufacturing/getList",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },
                    "columnDefs":[{
                    	"targets":[0],
                    	"name":"ref",
                    	"data":"ref",
                    
                    },
                    {
                    	"targets":[1],
                    	"name":"title",
                    	"data":"title",
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"startDate",
                    	"data":"startDate",
                    	"render": function ( data, type, full, meta ) {
                   	      date = new Date(data);
                   	      return date.formatDetail();
                   	    }
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"endDate",
                    	"data":"endDate",
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
                    	"name":"ref",
                    	"data":"ref",
                    
                    },
                    {
                    	"targets":[6],
                    	"name":"title",
                    	"data":"title",
                    	"render": function ( data, type, full, meta ) {
                   		 $obj='<div id="title" class="label label-success">Low</div>';
                   		
                   	      return $obj;
                   	    }
                    
                    },
                    {
                    	"targets":[7],
                    	"name":"responsible",
                    	"data":"responsible",
                    	"render": function ( data, type, full, meta ) {
                    		$link='<a href="${baseURL}/user/profile?id='+data.id+'">'+data.firstName+' '+data.lastName+'</a>';
                    	
                    	      return $link;
                    	    }
                    },
                    {
                    	"targets":[8],
                    	"name":"title",
                    	"data":"title",
                    	"render": function ( data, type, full, meta ) {
                   		 $active='<div id="title" class="label label-success">Low</div>';
                   		
                   	      return $inactive;
                   	    }
                    
                    },
                    {
                    	"targets":[9],
                    	"name":"id",
                    	"data":"id",
                    	"orderable": false,
                    	 "render": function ( data, type, full, meta ) {
                    		 $html='<a href="${baseURL}/manufacturing/profile?id='+data+'"  class="btn btn-info btn-xs"><i class="fa   fa-search"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/manufacturing/update?id='+data+'"  class="btn btn-default btn-xs"><i class="fa   fa-edit"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/manufacturing/delete?id='+data+'"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
                    		 return $html;
                    	    }
                    
                    }]
                });
                
          });
        </script>