<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<div class="box box-info">
	<div class="box-header">

		<h3 class="box-title">
			<i class="fa fa-fw fa-barcode"></i>Scanner par code barre
		</h3>
	</div>
	<div class="box-body">
		<form action="${baseURL}/manufacturing/findByRef" method="POST" id="find-by-id">
			<input type="hidden" id="codebar" name="ref"> <span
				id="show-codebar"></span>
		</form>
		<div class="row">
			<div class="col-sm-1 image">
				<img alt="" src="/esoftrade/img/barcode.png" class="img-circle"
					style="width: 50px; height: 50px">
			</div>
			<div class="col-sm-offset-4 col-sm-2">
				<button class="btn btn-success btn-sm" id="activate">Activer
					le scan</button>
			</div>
			<div class=" col-sm-offset-4 col-sm-1 image">
				<img alt="" src="/esoftrade/img/barcode.png" class="img-circle"
					style="width: 50px; height: 50px">
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var barcode = "";
		var activateScan = false;
		$("#activate").on("click", function(event) {
			if (!activateScan) {
				$(this).text("Désactiver le scan");
				$(this).addClass("btn-danger");
				$(this).removeClass("btn-success");
				activateScan = true;
			} else {
				$(this).text("Activer le scan");
				$(this).addClass("btn-success");
				$(this).removeClass("btn-danger");
				activateScan = false;
			}
		});
		$("body").keydown(function(event) {
			if (activateScan) {
				var code = (event.keyCode ? event.keyCode : event.which);
				if (code == 13)// Enter key hit
				{
					event.preventDefault();
					$("#codebar").val(barcode);
					$("#find-by-id").submit();

				} else if (code == 9)// Tab key hit
				{
					event.preventDefault();
					$("#codebar").val(barcode);
					$("#find-by-id").submit();
				} else {
					barcode = barcode + String.fromCharCode(code);
				}
			}
		});
	</script>
</div>
<div class="box">
	<div class="box-header">
		<h3 class="box-title">la liste des OF</h3>
		<div class="box-tools pull-right">
			<a class="btn btn-primary btn-sm"
				href="${baseURL}/manufacturing/create" style="color: white;">+
				Ordre de fabriquation</a> &nbsp;
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
<<<<<<< HEAD
        
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
                   	      return date.format();
                   	    }
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"endDate",
                    	"data":"endDate",
                    	"render": function ( data, type, full, meta ) {
                   	      date = new Date(data);
                   	      return date.format();
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
         					'<div class="progress-bar progress-bar-aqua" style="width:'+data+'%" role="progressbar" aria-valuenow="'+data+'" aria-valuemin="0" aria-valuemax="100">'+
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
=======
	$(function() {
		//             	   $('#example1 thead th').each( function () {
		//                        var title = $('#example1 thead th').eq( $(this).index() ).text();
		//                        $(this).prepend( '<input  id="me" type="text" placeholder="Search '+title+'" /><br>' );
		//                    } );

		$("#example33").DataTable({});
		var table = $('#list1')
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
								"url" : "${baseURL}/manufacturing/getList",
								"data" : function(data) {
									planify(data);
								}
							},
							"columnDefs" : [
									{
										"targets" : [ 0 ],
										"name" : "ref",
										"data" : "ref",
										"render" : function(data, type, full,
												meta) {
											$link = '<small><a href="${baseURL}/manufacturing/profile?id='
													+ full.id
													+ '">'
													+ data
													+ '</a></small>';

											return $link;
										}

									},
									{
										"targets" : [ 1 ],
										"name" : "startDate",
										"data" : "startDate",
										"render" : function(data, type, full,
												meta) {
											date = new Date(data);
											return date.formatDetail();
										}

									},
									{
										"targets" : [ 2 ],
										"name" : "endDate",
										"data" : "endDate",
										"render" : function(data, type, full,
												meta) {
											date = new Date(data);
											return date.formatDetail();
										}

									},
									{
										"targets" : [ 3 ],
										"name" : "deadline",
										"data" : "deadline",
										"render" : function(data, type, full,
												meta) {
											if (data < 0) {
												return '<span class="label label-warning">En retard de '
														+ (data * -1)
														+ ' jour(s)</span>';
											}
											if (data == 0) {
												return "dernier jour";
											}
											return data + " jour(s)";
										}

									},
									{
										"targets" : [ 4 ],
										"name" : "progress",
										"data" : "progress",
										"render" : function(data, type, full,
												meta) {
											$dta = '<small class="pull-right">'
													+ data
													+ '%</small>'
													+ '<div class="progress xs">'
													+ '<div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">'
													+ '<span class="sr-only">'
													+ data + '</span>';
											'</div>';
											return $dta;
										}
									},
									{
										"targets" : [ 5 ],
										"name" : "priority",
										"data" : "priority",
										"render" : function(data, type, full,
												meta) {
											$link = "";
											switch (data) {
											case "Critical":
												$link = '<span class="label label-danger">critique</span>';
												break;
											case "High":
												$link = '<span class="label label-success">élevé</span>';
												break;
											case "Medium":
												$link = '<span class="label label-info">moyen</span>';
												break;
											case "Low":
												$link = '<span class="label label-default">faible</span>';
												break;
											case "Urgent":
												$link = '<span class="label label-warning">urgent</span>';
												break;
											default:

											}
											return $link;
										}

									},
									{
										"targets" : [ 6 ],
										"name" : "responsible",
										"data" : "responsible",
										"render" : function(data, type, full,
												meta) {
											$link = '<a href="${baseURL}/user/profile?id='
													+ data.id
													+ '"><i class="fa fa-user"></i>&nbsp;'
													+ data.name
													+ ' '
													+ data.lastName + '</a>';

											return $link;
										}
									},
									{
										"targets" : [ 7 ],
										"name" : "status",
										"data" : "status",
										"render" : function(data, type, full,
												meta) {
											$link = "";
											switch (data) {
											case "canceled":
												$link = '<small class="badge bg-yellow">annulé</small>';
												break;
											case "waiting":
												$link = '<small class="badge bg-aqua">attente</small>';
												break;
											case "onProduction":
												$link = '<small class="badge bg-purple">En prod</small>';
												break;
											case "charged":
												$link = '<small class="badge bg-teal">chargé</small>';
												break;
											case "notcharged":
												$link = '<small class="badge bg-navy">pas chargé</small>';
												break;
											case "end":
												$link = '<small class="badge bg-red">fini</small>';
												break;
											case "blocked":
												$link = '<small class="badge bg-orange">blocké</small>';
												break;
											case "inpreparation":
												$link = '<small class="badge bg-olive">en prépa</small>';
												break;
											default:

											}
											return $link;
										}
									},
									{
										"targets" : [ 8 ],
										"name" : "id",
										"data" : "id",
										"orderable" : false,
										"render" : function(data, type, full,
												meta) {
											$html = '<a href="${baseURL}/manufacturing/profile?id='
													+ data
													+ '"  class="btn btn-info btn-xs"><i class="fa   fa-search"></i></a>&nbsp;';
											$html += '<a href="${baseURL}/manufacturing/update?id='
													+ data
													+ '"  class="btn btn-default btn-xs"><i class="fa   fa-edit"></i></a>&nbsp;';
											$html += '<a href="${baseURL}/manufacturing/delete?id='
													+ data
													+ '"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
											return $html;
										}

									} ]
						});

	});
</script>

>>>>>>> 13c238c6a3187e25213f62be676b3465c36cf8fe
