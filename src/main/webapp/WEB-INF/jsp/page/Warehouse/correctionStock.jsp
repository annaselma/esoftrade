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
<div class="box box-success">
	<div class="box-header"></div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">
		<table class="table">
			<tbody>
				<tr>
					<th style="width: 50%"><label>L'entrepot:</label></th>
					<td><span class="text-muted"><c:out
								value="${warehouse.name}" /></span></td>
				</tr>
				<tr>
					<th><label>Adresse:</label></th>
					<td><c:out value="${warehouse.adresse}" /></td>
				</tr>

				<tr>
					<th><label>Code Postal:</label></th>
					<td><c:out value="${warehouse.zipCode}" /></td>
				</tr>
				<tr>
					<th><label>Ville:</label></th>
					<td><c:out value="${warehouse.city}" /></td>
				</tr>
				<tr>
					<th><label>Pays:</label></th>
					<td><c:out value="${warehouse.country}" /></td>
				</tr>
				<tr>
					<th><label>Description:</label></th>
					<td><c:out value="${warehouse.description}" escapeXml="false" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="box box-solid box-primary">
	<div class="box-header">
		<h3 class="box-title">Corriger le stock</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">

		<form:form method="POST" commandName="mouvement" id="correctF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group">
				<label for="productField" class="col-sm-2 control-label esoft-left">Produit:&nbsp;<span
					class="error">*</span></label>
				<div class="col-sm-4" id="select-pro">
					<form:select path="product" cssClass="tokenize-sample mono-select "
						id="product" size="1">
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
				$("#select-pro").on("focus", ".tokenize-sample ", function() {
				    console.log($(".Token span").text());
				   $text= $(".Token span").text();
				   $(".Token").remove();
				   $("#select-pro select option[selected='selected']").remove();
				    $(".TokenSearch input").val($text);
				});
				</script>
			</div>
			<div class="form-group">
				<label for="LibelField" class="col-sm-2 control-label esoft-left">unité
					a modifié: </label>
				<div class="col-sm-10">
					<input type="number" name="quantity" class="form-control "
						value="${mouvement.quantity}"
						onkeypress='return event.charCode >= 48 && event.charCode <= 57' />
					<form:errors path="quantity" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="LibelField" class="col-sm-2 control-label esoft-left">Libelle:</label>
				<div class="col-sm-10">
					<form:input path="motif" cssClass="form-control " />
					<form:errors path="motif" cssClass="error" />
				</div>
			</div>
			<form:hidden path="warehouse" />
			<div class="form-group">
				<button type="submit" class="btn btn-danger btn pull-right"
					style="margin-right: 1%;">Annuler</button>
				<button type="submit" class="btn btn-primary btn pull-right"
					style="margin-right: 2%;">Corriger le stock</button>
			</div>
		</form:form>
	</div>
</div>


