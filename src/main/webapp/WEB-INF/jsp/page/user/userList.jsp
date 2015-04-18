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
                                    <h3 class="box-title">la liste des utilisateurs</h3>                                    
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="list1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Rèfèrence</th>
                                                <th>Nom</th>
                                                <th>Prènom</th>
                                                <th>Login</th>
                                                <th>fonction</th>
                                                <th>statut</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                               <th>Rèfèrence</th>
                                                <th>Nom</th>
                                                <th>Prènom</th>
                                                <th>Login</th>
                                                <th>fonction</th>
                                                <th>statut</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
  <!-- DATA TABES SCRIPT -->
        <script src="${baseURL}/js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="${baseURL}/js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
         <script src="${baseURL}/js/plugins/datatables/dataTables.ColumnFilter.js" type="text/javascript"></script>
        <script type="text/javascript">
        
            $(function() {
//             	   $('#example1 thead th').each( function () {
//                        var title = $('#example1 thead th').eq( $(this).index() ).text();
//                        $(this).prepend( '<input  id="me" type="text" placeholder="Search '+title+'" /><br>' );
//                    } );
                
            	$("#example33").DataTable({});
               var table= $('#example1').DataTable({
                    "paging": true,
                    "lengthChange": true,
                    "searching": true,
                    "ordering": true,
                    "info": true,
                    "autoWidth": true,
                    "processing": true,
                    "serverSide": true,
                    "ajax": {
                        "url": "${baseURL}/user/getList",
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
                    	"name":"ac+tive",
                    	"data":"active",
                    	 "render": function ( data, type, full, meta ) {
                    	      return '<a href="'+data+'">active '+data+'</a>';
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