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
		<h3 class="box-title">Nouvelle commande Fournisseur</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">
<span class="error">Veuillez saisir les champs obligatoire (*)</span>
		<form:form method="POST" commandName="order" id="orderF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group">
				<label for="productField" class="col-sm-2 control-label esoft-left">Fournisseur:&nbsp;<span
					class="error">*</span></label>
				<div class="col-sm-4" id="select-company">
					<form:select path="company" cssClass="tokenize-sample mono-select "
						id="company" size="1">
						<c:if test="${company.id >0}">
							<form:option value="${company.id}" selected="selected">
								<c:out value="${company.name}" />
							</form:option>
						</c:if>
					</form:select>
					<form:errors path="company" cssClass="error" />
				</div>
			</div>

			<script type="text/javascript"
				src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
			<script type="text/javascript">
					$('#company').tokenize({
						"newElements" : false,
						maxElements : 1,
						datas : "${baseURL}/third/search?type=supplier",
						valueField : "id",
						textField : "name"
					});
					$("#select-company")
							.on(
									"focus",
									".tokenize-sample ",
									function() {
										console.log($(".Token span").text());
										   $("#select-company .Token").remove();
										   $("#select-company select option[selected='selected']").remove();
										    $("#select-company .TokenSearch input").val();
									});
				</script>
			<div class="form-group">
				<label for="dateField" class="col-sm-2 control-label esoft-left">Date:</label>
				<div class="input-append date col-sm-4" data-date="12-02-2012"
					data-date-format="dd-mm-yyyy">
					<form:input path="validityDueDate" id="dp0" />
					<span class="add-on"><span class="fa fa-calendar" id="cal2"></span></span>
					<form:errors path="validityDueDate" />
				</div>
				</div>
				<div class="form-group">
				<label for="dateField" class="col-sm-2 control-label esoft-left">Date de livraison:</label>
				<div class="input-append date col-sm-4" data-date="12-02-2012"
					data-date-format="dd-mm-yyyy">
					<form:input path="deliveryDate" id="dp1" />
					<span class="add-on"><span class="fa fa-calendar" id="cal2"></span></span>
					<form:errors path="deliveryDate" />
				</div>
				</div>
			<div class="form-group">
				<label for="statusField" class="col-sm-2 control-label esoft-left">mode de règlement:&nbsp;</label>
				<div class="col-sm-4" id="select-cond">
					<form:select path="paymentType" cssClass="form-control ">
					    <form:option value="cheque">chèque</form:option>
						<form:option  value="transfert">virement</form:option>
						<form:option value="creditCard">carte de crédit</form:option>
						<form:option value="TIP">TIP</form:option>
						<form:option value=" cash">espèces</form:option>
						<form:option value="levy">prélèvement</form:option>
					</form:select>
					<form:errors path="paymentType" cssClass="error" />
				</div>
				</div>
				<hr>
            
            
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Note (Publique): </label>
				<div class="col-sm-10">
					<form:textarea id="editor1" path="publicNote" name="editor1"
						rows="4" cols="80" />
				</div>
			</div>
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Note (Privée): </label>
				<div class="col-sm-10">
					<form:textarea id="editor2" path="privateNote" name="editor1"
						rows="4" cols="80" />
				</div>
			</div>	
			<form:hidden path="type"/>	
			<div class="form-group">
			<button type="reset" class="btn-sm btn btn-danger btn pull-right " onclick="location.href='${baseURL}/third/list'" style="margin-right: 2%;">Annuler</button>
			<button type="submit" class="btn-sm btn btn-primary btn pull-right" style="margin-right: 1%;"><i class="fa fa-plus"></i>&nbsp;Créer</button>
			</div>
		</form:form>
	</div>
</div>
<!-- /.box-body -->
<script src="${baseURL}/js/bootstrap-datepicker.js"></script>
<script>
$(document).ready(function() {
	   // instance, using default configuration.
	$('#dp0').datepicker({
		  format: 'dd/mm/yyyy'
	});
	$('#dp1').datepicker({
		  format: 'dd/mm/yyyy'
	});
    CKEDITOR.replace('editor1');
    CKEDITOR.replace('editor2');
});
</script>
<script type="text/javascript">
$('.number').keypress(function(event) {
    if(event.which<46 || event.which>59) {
        event.preventDefault();
    } // prevent if not number/dot

    if(event.which == 46 && $(this).val().indexOf('.') != -1) {
        event.preventDefault();
    } 
});
        </script>
