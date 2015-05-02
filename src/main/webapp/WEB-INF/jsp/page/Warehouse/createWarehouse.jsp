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
		<h3 class="box-title">Nouvelle Catégorie</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">

		<form:form method="POST" commandName="warehouse" id="warehouseF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">name:</label>
				<div class="col-sm-4">
					<form:input path="name" cssClass="form-control" />
					<form:errors path="name" cssClass="error" />
				</div>

			</div>
            
			<div class="form-group">
				<label for="DescriptionField" class="col-sm-2 control-label esoft-left">Description:</label>
				<div class="col-sm-10">
					<form:textarea id="editor1" path="description" name="editor1" rows="4" cols="80"/>
				</div>
			</div>
			<div class="form-group">
				<label for="adresseField" class="col-sm-2 control-label esoft-left">Adresse:</label>
				<div class="col-sm-4">
					<form:textarea path="adresse1" rows="2" cols="50" />
					<form:errors path="adresse1" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="CPField" class="col-sm-2 control-label esoft-left">code
					Postal:</label>
				<div class="col-sm-4">
					<form:input path="zipCode" cssClass="form-control input-lg" />
					<form:errors path="zipCode" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="cityField" class="col-sm-2 control-label esoft-left">Ville:</label>
				<div class="col-sm-4">
					<form:input path="city" cssClass="form-control" />
					<form:errors path="city" cssClass="error" />
				</div>

			</div>

			<div class="form-group">

				<label for="paysField" class="col-sm-2 control-label esoft-left">Pays:
				</label>
				<div class="col-md-4">
					<form:select path="country" cssClass="form-control  bfh-countries">

						<option value="Maroc">Maroc</option>
						<option value="France(F)">France (F))</option>
						<option value="Tunisie">Tunisie (T)</option>
						</form:select></div></div>
			<div class="form-group">
				<button type="submit" class="btn btn-danger btn pull-right"
					style="margin-right: 1%;">Annuler</button>
				<button type="submit" class="btn btn-primary btn pull-right"
					style="margin-right: 2%;">Ajouter</button>
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
                //bootstrap WYSIHTML5 - text editor
                $(".textarea").wysihtml5();
            });
        </script>
