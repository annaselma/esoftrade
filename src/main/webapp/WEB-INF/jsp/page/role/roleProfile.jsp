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
		<li class="active"><a href="#fiche" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-file"></i>&nbsp;Fiche Role</a></li>
		<li><a href="#user" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-file"></i>&nbsp;Groupe des utilisateurs associés</a></li>	
		<li class=""><a href="#suivi" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-eye" style=""></i>&nbsp;Traçabilité</a></li>


	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade active in " id="fiche">
			<div class="tab-pane active" id="fiche-tab">
				<div class="row">
					<div class="col-md-12">
					<button type="button" class="btn-sm btn btn-danger pull-right "
									style="margin-right: 2%;"
									onclick="location.href='/esoftrade/role/delete?id=${role.id}'">
									<i class="fa fa-pencil-square-o "></i> &nbsp;Supprimer
								</button>
								<button type="button" class="btn-sm btn btn-success pull-right "
									style="margin-right: 2%;"
									onclick="location.href='/esoftrade/role/update?id=${role.id}'">
									<i class="fa fa-pencil-square-o "></i> &nbsp;Modifier
								</button>
						<div class="category-info"
							style="padding-left: 1%; padding-top: 4%;">
							<div class="global-info">
								
								<div class=" col-sm-12 table-responsive">
									<table class="table">
										<tbody>
											<tr>
												<th><label>Role:</label></th>
												<td><c:out value="${role.role}" /></td>
											</tr>
											<tr>
												<th><label>Permissions:</label></th>
												<td><c:forEach var="item"
														items="${role.permissions}" varStatus="status">
													    <span class="label label-info"><c:out value="${item.label}" /></span>
													</c:forEach></td>
											</tr>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="box box-info">
	<div class="box-header">
	
	<h3 class="box-title"><i class="fa fa-fw fa-info-circle"></i>Permissions détaillées</h3>
	</div>
		<div class="box-body">
			<table id="list2" class="table table-bordered table-striped">
				<thead>
					<tr>
					    <th>Module</th>
						<th>Permission</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${role.permissions}" var="perm">
						<tr>
							<td><c:out value="${perm.module}" /></td>
							<td><c:out value="${perm.label}" /> &nbsp; &nbsp; <i class="fa fa-check" style="color: #00E500 "></i></td>
							<td><c:out value="${perm.description}" /></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
				     	<th>Module</th>
						<th>Permission</th>
						<th>Description</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>





			</div>

		</div>
		<div class="tab-pane fade" id="user">
		<table id="list1" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Réfèrence</th>
					<th>Nom</th>
					<th>Prènom</th>
					<th>Login</th>
					<th>fonction</th>
					<th>statut</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<th>Réfèrence</th>
					<th>Nom</th>
					<th>Prènom</th>
					<th>Login</th>
					<th>fonction</th>
					<th>statut</th>
					<th>Actions</th>
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
							<td><img src="${baseURL}/file?id=${role.creator.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-inverse"> <a
									href="<c:out value="${baseURL}/user/profile?id=${role.creator.id}"/>"><c:out
											value="${role.creator.lastName} ${role.creator.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th><label>Date création:</label></th>
							<td>Le:&nbsp;<fmt:formatDate pattern="dd/MM/yyyy"
									value="${role.createDate}" /></td>
						</tr>
						<tr class=" box box-solid bg-">
							<th><label>Modifié par:</label></th>
							<td><img
								src="${baseURL}/file?id=${role.modifier.picture.id}"
								class="img-circle" alt="User Image"
								style="width: 29px; height: 28px;"><span
								class="data-value label label-important"> <a
									href="<c:out value="${baseURL}/user/profile?id=${role.modifier.id}"/>"><c:out
											value="${role.modifier.lastName} ${role.modifier.firstName}" /></a>
							</span></td>
						</tr>
						<tr>
							<th>Date de modification:</th>
							<td><span class="data-value">Le:&nbsp;<fmt:formatDate
										pattern="dd/MM/yyyy" value="${role.lastEdit}" /></span></td>
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
                        "url": "${baseURL}/user/getListWhereRole?id=${role.id}",
                        		                
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
                    	"name":"name",
                    	"data":"name",
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"lastName",
                    	"data":"lastName",
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"login",
                    	"data":"login",
                    
                    },
                    {
                    	"targets":[4],
                    	"name":"fonction",
                    	"data":"fonction",
                    
                    },
                    {
                    	"targets":[5],
                    	"name":"active",
                    	"data":"active",
                    	 "render": function ( data, type, full, meta ) {
                    		 $active='<div id="statut" class="label label-success">Actif</div>';
                    		 $inactive='<div id="statut" class="label label-danger">inactif</div>';
                    		 if(data==true){
                    			 return $active;
                    		 }
                    	      return $inactive;
                    	    }
                    
                    },
                    {
                    	"targets":[6],
                    	"name":"id",
                    	"data":"id",
                    	"orderable": false,
                    	 "render": function ( data, type, full, meta ) {
                    		 $html='<a href="${baseURL}/user/profile?id='+data+'"  class="btn btn-info btn-xs"><i class="fa   fa-search"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/user/update?id='+data+'"  class="btn btn-default btn-xs"><i class="fa   fa-edit"></i></a>&nbsp;'
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
        <script type="text/javascript">
	$(document).ready(function() {
    $('#list2').DataTable({
    		"paging":   false,});
     } );
</script>
