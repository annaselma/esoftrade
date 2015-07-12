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
		<h3 class="box-title">la liste des catégories</h3>
		<div class="box-tools pull-right">
			<a class="btn btn-primary btn-sm" href="${baseURL}/category/create"
				style="color: white;">+ Ajouter categorie</a> &nbsp;
		</div>
	</div>
	<!-- /.box-header -->
	<div class="box-body table-responsive">
		<table id="list1" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Description</th>
					<th>Date modification</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Description</th>
					<th>Date modification</th>
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
                        "url": "${baseURL}/category/getList",
                        "data": function(data) {
                            planify(data);  
                        } 
                    }, language: {
                        url: '${baseURL}/ajax/fr_FR.json'
                    },
                    "columnDefs":[{
                    	"targets":[0],
                    	"name":"id",
                    	"data":"id",
                    
                    },
                    {
                    	"targets":[1],
                    	"name":"name",
                    	"data":"name",
                    
                    },
                    {
                    	"targets":[2],
                    	"name":"description",
                    	"data":"description",
                    
                    },
                    {
                    	"targets":[3],
                    	"name":"lastEdit",
                    	"data":"lastEdit",
                    	"render":function ( data, type, full, meta ) {
                    		date= new Date(data);
                          return date.format();
                    	}
                    
                    },
                    
                    {
                    	"targets":[4],
                    	"name":"id",
                    	"data":"id",
                    	"orderable": false,
                    	 "render": function ( data, type, full, meta ) {
                    		 $html='<a href="${baseURL}/category/profile?id='+data+'"  class="btn btn-info btn-xs"><i class="fa   fa-search"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/category/update?id='+data+'"  class="btn btn-default btn-xs"><i class="fa   fa-edit"></i></a>&nbsp;';
                    		 $html+='<a href="${baseURL}/category/delete?id='+data+'"  class="btn btn-danger btn-xs"><i class="fa   fa-trash-o"></i></a>';
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