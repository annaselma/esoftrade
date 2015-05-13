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
		<h3 class="box-title">Corriger le stock</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">

		<form:form method="POST" commandName="mouvement" id="correctF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Ref. Produit:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:select path="product" cssClass="form-control ">
						<form:options items="${productItems}" itemLabel="libelle"
							itemValue="id" />
					</form:select>
					<form:errors path="product" cssClass="error" />
				</div>

			</div>
            <div class="form-group">
				<label for="LibelField" class="col-sm-2 control-label esoft-left">unité a modifié:</label>
				<div class="col-sm-10">
					<input  type="number" name="quantity"   class="form-control " 
					value="${movement.quantity}" />
				    <form:errors path="quantity" cssClass="error" />
				</div>
			</div>
            
			<div class="form-group">
				<label for="LibelField" class="col-sm-2 control-label esoft-left">Libelle:</label>
				<div class="col-sm-10">
					<form:input path="motif"  cssClass="form-control " />
					<form:errors path="motif" cssClass="error" />
				</div>
			</div>
			<form:hidden path="warehouse"/>
			<div class="form-group">
				<button type="submit" class="btn btn-danger btn pull-right"
					style="margin-right: 1%;">Annuler</button>
				<button type="submit" class="btn btn-primary btn pull-right"
					style="margin-right: 2%;">Corriger le stock</button>
			</div>
		</form:form>
	</div>
</div>


