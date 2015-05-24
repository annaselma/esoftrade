<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />

<div class="box box-primary">
	<div class="box-header">
		<h3 class="box-title"> Nouveau Ordre de Fabrication</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">
<span class="error" style="margin-left:3%;">Veillez sasir les champs obligatoire (*)</span>
		<form:form method="POST" commandName="manufacturing" id="OF"
			data-toggle="validator" cssClass="form-horizontal">
			
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Titre:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:input path="title" cssClass="form-control" />
					<form:errors path="title" cssClass="error" />
				</div>
           
			</div>
			<div class="form-group">
				<label for="caegoryField" class="col-sm-2 control-label esoft-left">responsableS:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4" id="select-user">
					<form:select path="responsible" cssClass="tokenize-sample mono-select "
						id="user" size="1">
						<c:if test="${responsible.id >0}">
							<form:option value="${responsible.id}" selected="selected">
								<c:out value="${responsible.name} ${responsible.lastName}" />
							</form:option>
						</c:if>
					</form:select>
					<form:errors path="responsible" cssClass="error" />
				</div>
				<script type="text/javascript"
					src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
				<script type="text/javascript">
				$('#user').tokenize({
					"newElements":false,
					maxElements:1,
					datas: "${baseURL}/manufacturing/searchResponsable",
					valueField:"id",
					textField:"name"
					});
				$("#select-user").on("focus", ".tokenize-sample ", function() {
				    console.log($("#select-user .Token span").text());
				   $text= $("#select-user .Token span").text();
				   $(" #select-user .Token").remove();
				   $("#select-user select option[selected='selected']").remove();
				    $("#select-user .TokenSearch input").val($text);
				});
				</script>
				</div>
			<div class="form-group form-horizontal">
				<label for="type" class="col-sm-2 control-label esoft-left">Sous Traitant:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:select path="center" cssClass="form-control ">
						<form:options items="${warehouseItems}" itemLabel="name"
							itemValue="id" />
					</form:select>
					<form:errors path="center" cssClass="error" />
				</div>
				<div class="col-sm-4">
					<form:checkbox path="type" />
					<form:errors path="type" cssClass="error" />
				</div>
                
			</div>
			
			<div class="form-group">
				<label for="caegoryField" class="col-sm-2 control-label esoft-left">Warehouse:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4" id="select-war">
					<form:select path="center" cssClass="tokenize-sample mono-select "
						id="warehouse" size="1">
						<c:if test="${center.id >0}">
							<form:option value="${center.id}" selected="selected">
								<c:out value="${center.name}" />
							</form:option>
						</c:if>
					</form:select>
					<form:errors path="center" cssClass="error" />
				</div>
				<script type="text/javascript"
					src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
				<script type="text/javascript">
				$('#warehouse').tokenize({
					"newElements":false,
					maxElements:1,
					datas: "${baseURL}/warehouse/search",
					valueField:"id",
					textField:"name"
					});
				$("#select-war").on("focus", ".tokenize-sample ", function() {
				    console.log($("#select-war .Token span").text());
				   $text= $("#select-war .Token span").text();
				   $(" #select-war .Token").remove();
				   $("#select-war select option[selected='selected']").remove();
				    $("#select-war .TokenSearch input").val($text);
				});
				</script>
				</div>
				
				
				
			<div class="form-group">
				<label for="lenghtField" class="col-sm-2 control-label esoft-left">Team:</label>
				<div class="col-sm-4">
					<form:input path="team" cssClass="form-control" />
					<form:errors path="team" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="dateField" class="col-sm-2 control-label esoft-left">Date Début:&nbsp;<span class="error">*</span></label>

				<div class="input-append date col-sm-4" data-date="12-02-2012"
					data-date-format="dd-mm-yyyy">
					<form:input path="startDate" id="dp3" />
					<span class="add-on"><span class="fa fa-calendar" id="cal2"></span></span>
					<form:errors path="startDate" />
				</div>
			</div>
			<div class="form-group">
				<label for="dateFField" class="col-sm-2 control-label esoft-left">Date Fin:&nbsp;<span class="error">*</span></label>

				<div class="input-append date col-sm-4 " data-date="12-02-2012"
					data-date-format="dd-mm-yyyy">
					<form:input path="endDate" id="dp2" />
					<span class="add-on"><span class="fa fa-calendar" id="cal2"></span></span>
					<form:errors path="endDate" />
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Description:</label>
				<div class="col-sm-10">
					<form:textarea id="editor1" path="description" name="editor1" rows="4" cols="80"/>
				</div>
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-danger btn pull-right"
					style="margin-right: 2%;"><span>Annuler</span></button>
				<button type="submit" class="btn btn-success btn pull-right "
					style="margin-right: 2%;"><span class="fa fa-plus">&nbsp;Ajouter</span></button>
			</div>
		</form:form>
		
	</div>
</div>
<!-- /.box-body -->
<script src="${baseURL}/js/bootstrap-datepicker.js"></script>
<script>
	$(document).ready(function() {
		$('#dp3').datepicker();
		$('#dp2').datepicker();
	});
</script>
<script type="text/javascript">
            $(function() {
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace('editor1');
                //bootstrap WYSIHTML5 - text editor
                $(".textarea").wysihtml5();
            });
        </script>
