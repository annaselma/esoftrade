<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="${baseURL}/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="${baseURL}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="${baseURL}/assets/css/editor.css" type="text/css"  rel="stylesheet">
<script src="${baseURL}/assets/js/editor.js"></script>
<div id="page">
	<div class="row-fluid">
		<div class="span12 colums ">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div>
				<form action="#" class="span3">
					<div class="control-group">
						<div class="span4 columns ">
							<label class="control-label"
								style="margin-top: 6px; padding-left: 25px">Type</label>
						</div>
						<div class="span2">
							<div class="input-group">
								<select class="form-control" name="id">
									<option value="0">Produits</option>

									<c:forEach var="cat" items="${categories}">

										<option value="${cat.id}"
											<c:if test="${catN.id==cat.id}" >Services<!--  --></c:if>><c:out
												value="${cat.category}"></c:out></option>
									</c:forEach>
								</select>
							</div>
							<!-- /input-group -->
						</div>
					</div>
				</form>
			</div>
			<div class="span12">
			<div class="widget">
				<div class="widget-title">
					<h4>
						<i class="icon-reorder"></i>Nouveau Produit
					</h4>
					<span class="tools"> <a href="javascript:;"
						class="icon-chevron-down"></a> <a href="#widget-config"
						data-toggle="modal" class="icon-wrench"></a> <a
						href="javascript:;" class="icon-refresh"></a> <a
						href="javascript:;" class="icon-remove"></a>
					</span>
				</div>
				<div class="widget-body form">
					<!-- BEGIN FORM-->
					<form action="#" class="form-horizontal">

						<div class="control-group">
							<label class="control-label" for="input1">Ref</label>
							<div class="controls">
								<input type="text" class="span3" id="input1">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input2">Libellé</label>
							<div class="controls">
								<input type="text" class="span3" id="input2">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input3">Code-barres</label>
							<div class="controls">
								<input type="text" class="span3" id="input3">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input4">limite stock</label>
							<div class="controls">
								<input type="text" class="span3" id="input4">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input5">limite stock Alert</label>
							<div class="controls">
								<input type="text" class="span2" id="input5">
							</div>
						</div>
						<div id="txtEditor"></div>
						
						<div class="form-actions">
							<button type="submit" class="btn btn-primary">Save</button>
							<button type="button" class="btn">Cancel</button>
						</div>
					</form>
					<!-- END FORM-->
				</div>
			</div>
			</div>
			<!-- END SAMPLE FORM PORTLET-->
		</div>
		<div class="span12">
                     <!-- BEGIN PORTLET-->   
                     <div class="widget">
                        <div class="widget-title">
                           <h4><i class="icon-reorder"></i>File Upload</h4>
                           <span class="tools">
                           <a href="javascript:;" class="icon-chevron-down"></a>
                           <a href="#widget-config" data-toggle="modal" class="icon-wrench"></a>
                           <a href="javascript:;" class="icon-refresh"></a>      
                           <a href="javascript:;" class="icon-remove"></a>
                           </span>                    
                        </div>
                        <div class="widget-body form">
                           <!-- BEGIN FORM-->
                           <form action="#" class="form-horizontal">
                              <div class="control-group">
                                 <label class="control-label">Default</label>
                                 <div class="controls">
                                    <input type="file" class="default">
                                 </div>
                              </div>
                              <div class="control-group">
							<label class="control-label" for="input1">poids</label>
							<div class="controls">
								<input type="text" class="span1" id="input4">
							</div>
						</div>
                             </form>
                           <!-- END FORM-->  
                        </div>
                     </div>
                     <!-- END PORTLET-->
                  </div>
		
	</div>
</div>
<script src="${baseURL}/assets/js/editor.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="${baseURL}/assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<!--

//-->
<script>
$(document).ready( function() {
$("#txtEditor").Editor();                    
});
</script>
