<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />

                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Data Table With Full Features</h3>                                    
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Rendering engine</th>
                                                <th>Browser</th>
                                                <th>Platform(s)</th>
                                                <th>Engine version</th>
                                                <th>CSS grade</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Rendering engine</th>
                                                <th>Browser</th>
                                                <th>Platform(s)</th>
                                                <th>Engine version</th>
                                                <th>CSS grade</th>
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
            	   $('#example1 thead th').each( function () {
                       var title = $('#example1 thead th').eq( $(this).index() ).text();
                       $(this).prepend( '<input  id="me" type="text" placeholder="Search '+title+'" /><br>' );
                   } );
                
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
                        "url": "${baseURL}/table/getList.html",
                        "data": function(data) {
                            planify(data);  
                        } 
                    },
                    "columnDefs":[{
                    	"targets":[0],
                    	"name":"hello"
                    
                    }]
                });
              table.columns( ).every( function (i) {
            	    console.log("index:"+this.index());
               });
                
               $('#example1 tfoot th ').on( 'keyup',"#me", function () {
            	   console.log("hello");
            	    table
            	        .columns( 3 )
            	        .search( this.value )
            	        .draw();
            	} );
                
            });
        </script>