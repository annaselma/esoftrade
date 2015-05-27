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
                    	"render": function ( data, type, full, meta ) {
                    		$link='<small><a href="${baseURL}/manufacturing/profile?id='+full.id+'">'+data+'</a></small>';
                    	
                    	      return $link;
                    	    }
                    
                    },
                    {
                    	"targets":[1],
                    	"name":"startDate",
                    	"data":"startDate",
                    	"render": function ( data, type, full, meta ) {
                   	      date = new Date(data);
                   	      return date.formatDetail();
                   	    }
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"endDate",
                    	"data":"endDate",
                    	"render": function ( data, type, full, meta ) {
                   	      date = new Date(data);
                   	      return date.formatDetail();
                   	    }
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"deadline",
                    	"data":"deadline",
                    	"render": function ( data, type, full, meta ) {
                   	     if(data<0){
                   	    	 return '<span class="label label-warning">En retard de '+(data*-1)+' jour(s)</span>';
                   	     }
                   	     if(data==0){
                   	    	 return "dernier jour";
                   	     }
                   	      return data+" jour(s)";
                   	    }
                    
                    },
                    {
                    	"targets":[4],
                    	"name":"progress",
                    	"data":"progress",
                    	"render": function ( data, type, full, meta ) {
                   		 $dta='<small class="pull-right">'+data+'%</small>'+'<div class="progress xs">'+
         					'<div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">'+
 						'<span class="sr-only">'+data+'</span>';
 					'</div>';
                   		 return $dta;
                    	}
                    },
                    {
                    	"targets":[5],
                    	"name":"priority",
                    	"data":"priority",
                    	"render": function ( data, type, full, meta ) {
                    		$link="";
                     	     switch (data){
                     	     case  "Critical":
                     	    	$link='<span class="label label-danger">critique</span>';
                     	    	 break;
                     	    case  "High":
                     	    	$link='<span class="label label-success">élevé</span>';
                    	    	 break;
                     	   case  "Medium":
                     		  $link='<span class="label label-info">moyen</span>';
                  	    	 break;
                     	 case  "Low":
                     		 $link='<span class="label label-default">faible</span>';
                 	    	 break;
                     	case  "Urgent":
                    		 $link='<span class="label label-warning">urgent</span>';
                	    	 break;
                 	      default:
                 	    	  
                     	     }
                     	     return $link;
                     	    }
                    
                    },
                    {
                    	"targets":[6],
                    	"name":"responsible",
                    	"data":"responsible",
                    	"render": function ( data, type, full, meta ) {
                    		$link='<a href="${baseURL}/user/profile?id='+data.id+'"><i class="fa fa-user"></i>&nbsp;'+data.name+' '+data.lastName+'</a>';
                    	
                    	      return $link;
                    	    }
                    },
                    {
                    	"targets":[7],
                    	"name":"status",
                    	"data":"status",
                    	"render": function ( data, type, full, meta ) {
                    		$link="";
                     	     switch (data){
                     	     case  "canceled":
                     	    	$link='<small class="badge bg-yellow">annulé</small>';
                     	    	 break;
                     	    case  "waiting":
                     	    	$link='<small class="badge bg-aqua">attente</small>';
                    	    	 break;
                     	   case  "onProduction":
                     		  $link='<small class="badge bg-purple">En prod</small>';
                  	    	 break;
                     	 case  "charged":
                     		 $link='<small class="badge bg-teal">chargé</small>';
                 	    	 break;
                     	case  "notcharged":
                    		 $link='<small class="badge bg-navy">pas chargé</small>';
                	    	 break;
                     	case  "end":
                   		 $link='<small class="badge bg-red">fini</small>';
               	    	 break;
                     	case  "blocked":
                   		 $link='<small class="badge bg-orange">blocké</small>';
               	    	 break;
                     	case  "inpreparation":
                      		 $link='<small class="badge bg-olive">en prépa</small>';
                  	    	 break;
                 	      default:
                 	    	  
                     	     }
                     	     return $link;
                     	    }
                    },
                    {
                    	"targets":[8],
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