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
<div class="box box-solid box-primary">
	<div class="box-header">
		<h3 class="box-title">Modifier Gamme N°:<strong><c:out value="${gamme.ref}" /></strong></h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">
		<span class="error" style="margin-left: 69%;">Veillez saisir les champs obligatoire (*)</span>
		<hr>
		<form:form method="POST" commandName="gamme" id="gammeF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group">
				<label for="desField" class="col-sm-2 control-label esoft-left">Designation:&nbsp;<span
					class="error">*</span></label>
				<div class="col-sm-4">
				    <form:input path="designation" cssClass="form-control " />
					<form:errors path="designation" cssClass="error" />
				</div>
				<label for="postenbField" class="col-sm-2 control-label esoft-left">Nombre de Postes:&nbsp;<span
					class="error">*</span></label>
				<div class="col-sm-2">
				    <form:input path="nbposte" cssClass="form-control " />
					<form:errors path="nbposte" cssClass="error" />
				</div>
				
			</div>
			<div class="form-group">
				<label for="categoryField" class="col-sm-2 control-label esoft-left">Poste:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4" id="select-cat">
					<form:select path="poste" cssClass="tokenize-sample mono-select" id="poste"  size="1">
						<form:options items="${postItems}" itemLabel="namePoste"
							itemValue="id" />
					</form:select>
					<form:errors path="poste" cssClass="error" />
				</div>
                <script type="text/javascript" src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
				<script type="text/javascript">
				$('#poste').tokenize({
					"newElements":false,
					maxElements:1,
					datas: "${baseURL}/poste/search",
					valueField:"id",
					textField:"namePoste"
					});
				$("#select-cat").on("focus", ".tokenize-sample ", function() {
				    console.log($(".Token span").text());
				   $text= $(".Token span").text();
				   $(".Token").remove();
				   $("#select-cat select option[selected='selected']").remove();
				    $(".TokenSearch input").val($text);
				});
				
				</script>
				</div>
			<div class="form-group">
				<label for="priority"class="col-sm-2 control-label esoft-left">Type&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:select path="type" cssClass="form-control">
                   <form:option value="Gamme assemblage">Gamme assemblage</form:option>
                   <form:option value="Gamme outillage">Gamme outillage</form:option>
                   </form:select>
                    <form:errors path="type" cssClass="error" />
                   </div>
				<label for="end" class="col-sm-2 control-label esoft-left">Terminé:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:checkbox path="end" />
					<form:errors path="end" cssClass="error" />
				</div>			
                   </div>
                   <div class="form-group">
				
				<label for="postenbField" class="col-sm-2 control-label esoft-left">Temps passé(H):&nbsp;<span
					class="error">*</span></label>
				<div class="col-sm-2">
				    <form:input path="time" cssClass="form-control " />
					<form:errors path="time" cssClass="error" />
				</div>
				
			</div>
                   <hr>
			<div class="form-group">
				<label for="dateField" class="col-sm-2 control-label esoft-left">Date Début:&nbsp;<span class="error">*</span></label>

				<div class="input-append date col-sm-4" data-date="12-02-2012"
					data-date-format="dd-mm-yyyy">
					<form:input path="startDate" id="dp3" />
					<form:errors path="startDate" />
				</div>
				<label for="dateFField" class="col-sm-2 control-label esoft-left">Date Fin:&nbsp;<span class="error">*</span></label>

				<div class="input-append date col-sm-4 " data-date="12-02-2012"
					data-date-format="dd-mm-yyyy">
					<form:input path="endDate" id="dp2" />
					<form:errors path="endDate" />
				</div>
			</div>
			<div class="form-group">
				
			</div>
			<div class="form-group">
			    <label for="dateField" class="col-sm-2 control-label esoft-left">DateDébut prévu:</label>
				<div class="input-append date col-sm-4" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
					<form:input path="provisionalStartDate" id="dp0" />
					<form:errors path="provisionalStartDate"/>
				</div>
				<label for="dField" class="col-sm-2 control-label esoft-left">DateFin prévu:</label>
				<div class="input-append date col-sm-4 " data-date="12-02-2012"
					data-date-format="dd-mm-yyyy">
					<form:input path="provisionalEndDate" id="dp1" />
					<form:errors path="provisionalEndDate" />
				</div>
			</div>
			<div class="form-group">

				<label for="natureField" class="col-sm-2 control-label esoft-left">Quantité créé: </label>
				<div class="col-md-2">
					<form:input path="createdQt" cssClass="form-control " />
					<form:errors path="createdQt" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="theocticalField" class="col-sm-2 control-label esoft-left">Pièce en attente:</label>
				<div class="col-sm-2">
					<form:input path="waitingPrieces" cssClass="form-control" />
					<form:errors path="waitingPrieces" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="descField" class="col-sm-2 control-label esoft-left">Description:</label>
				<div class="col-sm-10">
					<form:textarea id="editor1" path="description" 
						rows="4" cols="80" />
				</div>
			</div>
			<hr>
			<h2  class="page-header" style="margin-left: 2%;"><i class="fa fa-exclamation-triangle" ></i>&nbsp;Dysfonctionnement <small class="pull-right"><i class="fa fa-cogs" style="margin-left: -42%;"></i></small> </h2>
			<div class="form-group">

				<label for="natureField" class="col-sm-2 control-label esoft-left">Quantité rebuté: </label>
				<div class="col-md-2">
					<form:input path="rejectedQt" cssClass="form-control " />
					<form:errors path="rejectedQt" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Cause rebut:</label>
				<div class="col-sm-10">
					<form:textarea id="editor2" path="observation" 
						rows="4" cols="80" />
				</div>
			</div>
				
			<input type="hidden" name="manufacturing" value="${manufacturing}">
			<div class="form-group">
				<button type="reset" class="btn-sm btn btn-danger btn pull-right "
					onclick="location.href='${baseURL}/gamme/profile?id=${gamme.id}'"
					style="margin-right: 2%;">Annuler</button>
				<button type="submit" class="btn-sm btn btn-success btn pull-right"
					style="margin-right: 2%;"><i class="fa fa-pencil-square-o"></i>&nbsp;Modifier</button>
			</div>
		</form:form>
	</div>
</div>
<!-- /.box-body -->
<script src="${baseURL}/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
            $(function() {
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace('editor1');
                CKEDITOR.replace('editor2');
                //bootstrap WYSIHTML5 - text editor
                $(".textarea").wysihtml5();
            });
        </script>
        <script>
        $(document).ready(function() {
    		$('#dp3').datepicker({
    			  format: 'dd/mm/yyyy'
    		});
    		$('#dp2').datepicker({
    			format: 'dd/mm/yyyy'
    		});
    		$('#dp1').datepicker({
    			format: 'dd/mm/yyyy'
    		});
    		$('#dp0').datepicker({
    			format: 'dd/mm/yyyy'
    		});
    	});

</script>
