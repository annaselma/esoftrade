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
		<h3 class="box-title">Modifier Nomenclature</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">
		<span class="error">Veillez sasir les champs obligatoire (*)</span>
		<form:form method="POST" commandName="nomenclature" id="nomenclatureF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group">
				<label for="productField" class="col-sm-2 control-label esoft-left">Produit:&nbsp;<span
					class="error">*</span></label>
				<div class="col-sm-4" id="select-prod">
					<form:select path="product" cssClass="tokenize-sample mono-select "
						id="product" size="1">
						<c:if
							test="${not empty nomenclature.product && nomenclature.product.id >0}">
							<form:option value="${nomenclature.product.id}"
								selected="selected">
								<c:out value="${nomenclature.product.libelle}" />
							</form:option>
						</c:if>
					</form:select>
					<form:errors path="product" cssClass="error" />
				</div>
				<script type="text/javascript"
					src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
				<script type="text/javascript">
				$('#product').tokenize({
					"newElements":false,
					maxElements:1,
					datas: "${baseURL}/product/search",
					valueField:"id",
					textField:"libelle"
					});
				$("#select-prod").on("focus", ".tokenize-sample ", function() {
				    console.log($(".Token span").text());
				   $text= $(".Token span").text();
				   $(".Token").remove();
				   $("#select-prod select option[selected='selected']").remove();
				    $(".TokenSearch input").val($text);
				});
				</script>
			</div>
			<div class="form-group">

				<label for="natureField" class="col-sm-2 control-label esoft-left">Quantité
					nécessaire: </label>
				<div class="col-md-4">
					<form:input path="requeredQt" cssClass="form-control " />

					<form:errors path="requeredQt" cssClass="error" />
				</div>
			</div>
			<div class="form-group">

				<label for="natureField" class="col-sm-2 control-label esoft-left">Quantité
					utilisée: </label>
				<div class="col-md-4">
					<form:input path="usedQt" cssClass="form-control " />

					<form:errors path="usedQt" cssClass="error" />
				</div>
			</div>
			<div class="form-group">

				<label for="natureField" class="col-sm-2 control-label esoft-left">Quantité
					manquant: </label>
				<div class="col-md-4">
					<form:input path="missingQt" cssClass="form-control " />

					<form:errors path="missingQt" cssClass="error" />
				</div>
			</div>
			<div class="form-group">

				<label for="natureField" class="col-sm-2 control-label esoft-left">Quantité
					rébutée:: </label>
				<div class="col-md-4">
					<form:input path="rejectedQt" cssClass="form-control " />

					<form:errors path="rejectedQt" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="priceField" class="col-sm-2 control-label esoft-left">Cout
					matiére:</label>
				<div class="col-sm-2">
					<form:input path="cost" cssClass="form-control" />
					<form:errors path="cost" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Description:</label>
				<div class="col-sm-10">
					<form:textarea id="editor1" path="description" name="editor1"
						rows="4" cols="80" />
				</div>
			</div>
			<form:hidden path="id"/>
			<div class="form-group">
				<button type="reset" class="btn-sm btn btn-danger btn pull-right "
					onclick="location.href='${baseURL}/nomenclature/profile?id=${nomenclature.id}'"
					style="margin-right: 2%;">Annuler</button>
				<button type="submit" class="btn-sm btn btn-primary btn pull-right"
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
