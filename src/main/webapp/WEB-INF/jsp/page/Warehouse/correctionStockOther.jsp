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
	<div class="box-header">
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">
		<table class="table">
			<tbody>
				<tr>
					<th style="width: 50%"><label>produit:</label></th>
					<td><span class="text-muted"><c:out
								value="${product.libelle}" /></span></td>
				</tr>
				<tr>
					<th><label>Code barre:</label></th>
					<td><c:out value="${product.barreCode}" /></td>
				</tr>
				<tr>
					<th><label>Catégorie:</label></th>
					<td><span class="label bg-aqua"><c:out
								value="${product.category.name}" /></span></td>
				</tr>
				<tr>
					<th><label>Prix:</label></th>
					<td><c:out value="${product.price}" /><i>&nbsp;<strong>DH</strong></i></td>
				</tr>
				<tr>
					<th><label>Quantité:</label></th>
					<td><c:out value="${qte}" /></td>
				</tr>
				<tr>
					<th><label>Stock désiré:</label></th>
					<td><c:out value="${product.alertTreshold}" /></td>
				</tr>
				<tr>
					<th><label>Limite stock pour alerte:</label></th>
					<td><c:out value="${product.desieredTreshold}" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="box box-solid box-primary">
	<div class="box-header">
		<h3 class="box-title">Corriger le stock du produit:
			${product.libelle}</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">

		<form:form method="POST" commandName="mouvementSecond" id="correctF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group">
				<label for="warehouseField"
					class="col-sm-2 control-label esoft-left">Entrepôt :&nbsp;<span
					class="error">*</span></label>
				<div class="col-sm-4" id="select-war">
					<form:select path="warehouse"
						cssClass="tokenize-sample mono-select " id="warehouse" size="1">
						<c:if test="${mouvementSecond.warehouse.id >0}">
							<form:option value="${mouvementSecond.warehouse.id}"
								selected="selected">
								<c:out value="${mouvementSecond.warehouse.name}" />
							</form:option>
						</c:if>
					</form:select>
					<form:errors path="warehouse" cssClass="error" />
				</div>
				<script type="text/javascript"
					src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
				<script type="text/javascript">
					$('#warehouse').tokenize({
						"newElements" : false,
						maxElements : 1,
						datas : "${baseURL}/warehouse/search",
						valueField : "id",
						textField : "name"
					});
					$("#select-war")
							.on(
									"focus",
									".tokenize-sample ",
									function() {
										console.log($(".Token span").text());
										$text = $(".Token span").text();
										$(".Token").remove();
										$(
												"#select-war select option[selected='selected']")
												.remove();
										$(".TokenSearch input").val($text);
									});
				</script>
			</div>
			<div class="form-group">
				<label for="LibelField" class="col-sm-2 control-label esoft-left">nombre
					de produits:</label>
				<div class="col-sm-10">
					<input type="number" name="quantity" class="form-control "
						value="${mouvementSecond.quantity}"
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
			<form:hidden path="product" />
			<div class="form-group">
				<button type="submit" class="btn btn-danger btn pull-right"
					style="margin-right: 1%;">Annuler</button>
				<button type="submit" class="btn btn-primary btn pull-right"
					style="margin-right: 2%;">Corriger stock</button>
			</div>
		</form:form>
	</div>
</div>

