<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="box box-info">
	<div class="box-header">
	
	<h3 class="box-title"><i class="fa fa-fw fa-info-circle"></i>Scanner par code barre</h3>
	</div>
		<div class="box-body">
			<form action="${baseURL}/findByRef" method="POST" >
			<input type="text" id="hello">
			<span id="texto"></span>
			</form>
		</div>
		<script type="text/javascript">
		$( "#hello" ).keydown(function( event ) {
			$("#texto").text(String.fromCharCode(event.which));
			if ( event.which == 13 ) {
				 event.preventDefault();
				var msg = "Entreeee";
				  $("#texto").text( msg+String.fromCharCode(event.which)+"ll");
				  }
			  
			});
			 
		</script>
	</div>