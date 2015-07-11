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
		<span class="error" style="margin-left:3%;">Veillez saisir les champs obligatoire (*)</span>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">

		<form:form method="POST" commandName="manufacturing" id="OF"
			data-toggle="validator" cssClass="form-horizontal">
			<form:errors path="*"/>
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Titre:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:input path="title" cssClass="form-control" />
					<form:errors path="title" cssClass="error" />
				</div>
           
			</div>
			<div class="form-group"><label for="productField" class="col-sm-2 control-label esoft-left">product:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4" id="select-product">
					<form:select path="product"
						cssClass="tokenize-sample mono-select " id="product" size="1">
						<c:if test="${manufacturing.product.id >0}">
							<form:option value="${manufacturing.product.id}"
								selected="selected">
								<c:out value="${manufacturing.product.libelle}" />
							</form:option>
						</c:if>
					</form:select>
					<form:errors path="product" cssClass="error" />
				</div></div>
				<script type="text/javascript"
					src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
				<script type="text/javascript">
					$('#product').tokenize({
						"newElements" : false,
						maxElements : 1,
						datas : "${baseURL}/product/search",
						valueField : "id",
						textField : "libelle"
					});
					$("#select-product")
							.on(
									"focus",
									".tokenize-sample ",
									function() {
										console.log($("#select-product .Token span").text());
										$text = $("#select-product .Token span").text();
										$("#select-product .Token").remove();
										$(
												"#select-product select option[selected='selected']")
												.remove();
										$(".TokenSearch input").val($text);
									});
				</script>
				
				
			<div class="form-group">
				<label for="caegoryField" class="col-sm-2 control-label esoft-left">responsables:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4" id="select-user">
					<form:select path="responsible" cssClass="tokenize-sample mono-select "
						id="user" size="1">
						<c:if test="${manufacturing.product.id >0}">
							<form:option value="${manufacturing.responsible.id}" selected="selected">
								<c:out value="${manufacturing.responsible.name} ${manufacturing.responsible.lastName}" />
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
				<div class="form-group">
				<label for="centerField" class="col-sm-2 control-label esoft-left">centre:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4" id="select-center">
					<form:select path="center" cssClass="tokenize-sample mono-select "
						id="center" size="1">
						<c:if test="${manufacturing.center.id >0}">
							<form:option value="${manufacturing.center.id}" selected="selected">
								<c:out value="${manufacturing.center.name} " />
							</form:option>
						</c:if>
					</form:select>
					<form:errors path="center" cssClass="error" />
				</div>
				<script type="text/javascript"
					src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
				<script type="text/javascript">
				$('#center').tokenize({
					"newElements":false,
					maxElements:1,
					datas: "${baseURL}/manufacturing/search",
					valueField:"id",
					textField:"name"
					});
				$("#select-center").on("focus", ".tokenize-sample ", function() {
				    console.log($("#select-center .Token span").text());
				   $text= $("#select-center .Token span").text();
				   $(" #select-center .Token").remove();
				   $("#select-center select option[selected='selected']").remove();
				    $("#select-center .TokenSearch input").val($text);
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
			<hr>
			<div class="form-group">
				<label for="traitant"class="col-sm-2 control-label esoft-left">Sous-Traitant&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:checkbox path="type" />
					<form:errors path="type" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="priority"class="col-sm-2 control-label esoft-left">Priority&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:select path="priority" cssClass="form-control">
                   <form:option value="Low">faible</form:option>
                   <form:option value="Medium">moyen</form:option>
                    <form:option value="Urgent">urgent</form:option>
                   <form:option value="Critical">critique</form:option>

                    </form:select>
                    <form:errors path="priority" cssClass="error" />
				</div>
				<label for="staus"class="col-sm-2 control-label esoft-left">Status&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:select path="status" cssClass="form-control">
						<form:option value="inpreparation">en préparation</form:option>
						<form:option value="waiting">en attente</form:option>
						<form:option value="onProduction">en production</form:option>
						<form:option value="charged">chagé</form:option>
						<form:option value="blocked">bloqué</form:option>
						<form:option value="canceled">annulé</form:option>
						<form:option value="end">Terminé</form:option>
                    </form:select>
                    <form:errors path="status" cssClass="error" />
				</div>
			</div>
<!-- 			<div class="callout callout-info"> -->
<!--                                         <table class="table"><tbody> -->
<!--                                         </tbody></table> -->
<!--                                     </div> -->
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
			<hr>
			
			<div class="form-group">
				<label for="qtlaField" class="col-sm-2 control-label esoft-left">QTlancée:</label>
				<div class="col-sm-2">
					<form:input path="lanchedQT" cssClass="form-control" />
					<form:errors path="lanchedQT" cssClass="error" />
				</div>
				
			</div>
			<div class="form-group">
			<label for="qtlaField" class="col-sm-2 control-label esoft-left">QTréalisée:</label>
				<div class="col-sm-2">
					<form:input path="executedQT" cssClass="form-control" />
					<form:errors path="executedQT" cssClass="error" />
					
				</div>
			</div>
			<div class="form-group">
			<label for="nameField" class="col-sm-2 control-label esoft-left">QTrestante:</label>
				<div class="col-sm-2">
					<form:input path="restToDoQT" cssClass="form-control" />
					<form:errors path="restToDoQT" cssClass="error" />
				</div></div>
				<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">QTnecessaire:</label>
				<div class="col-sm-2">
					<form:input path="requeredQT" cssClass="form-control" />
					<form:errors path="requeredQT" cssClass="error" />
				</div>
				</div>
				
			<div class="form-group">
				<label for="testsField" class="col-sm-2 control-label esoft-left">QTrebutée:</label>
				<div class="col-sm-2">
					<form:input path="rejectQT" cssClass="form-control" />
					<form:errors path="rejectQT" cssClass="error" />
				</div>
				
			</div>
			
			
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Description:</label>
				<div class="col-sm-10">
					<form:textarea id="editor1" path="description" name="editor1" rows="4" cols="80"/>
				</div>
			</div>
			
			<div class="form-group">
				<button type="reset" class="btn-sm btn btn-danger btn pull-right " onclick="location.href='${baseURL}/manufacturing/list'" style="margin-right: 2%;">Annuler</button>on>
				<button type="submit" class="btn-sm btn btn-success btn pull-right "
					style="margin-right: 2%;"><i class="fa  fa-pencil-square-o "></i> &nbsp;Modifier</button>
			</div>
		</form:form>
		
	</div>
</div>
<!-- /.box-body -->
<script src="${baseURL}/js/bootstrap-datepicker.js"></script>
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
<script type="text/javascript">
            $(function() {
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace('editor1');
                //bootstrap WYSIHTML5 - text editor
                $(".textarea").wysihtml5();
            });
        </script>
