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
		<h3 class="box-title">Informations </h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">
<span class="error">Veillez sasir les champs obligatoire (*)</span>
		<form:form method="POST" commandName="poste" id="postF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">NomduPoste:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:input path="namePoste" cssClass="form-control" />
					<form:errors path="namePoste" cssClass="error" />
				</div>

			</div>
			<div class="form-group form-horizontal">
				<label for="prriceField" class="col-sm-2 control-label esoft-left">Taux horraire:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-1">
					<form:input path="price" cssClass="form-control" />
					<form:errors path="price" cssClass="error" />
					
				</div>
				<div class="" style="padding-top: 1%;"><code>TauxHoraire=salaire/heure de travail</code></div>		
											
			</div>
			<div class="form-group">
			<label for="productive" class="col-sm-2 control-label esoft-left">Jugé productif&nbsp;<span class="error">*</span></label>
				<div class="col-sm-1" style="margin-top:1%">
					<form:checkbox path="productif" />
					<form:errors path="productif" cssClass="error" /></div>
			</div>
			<div class="form-group">
				<label for="caegoryField" class="col-sm-2 control-label esoft-left">Catégorie:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4" id="select-cat">
					<form:select path="category" cssClass="tokenize-sample mono-select " id="category"  size="1">
						<form:options items="${categoryItems}" itemLabel="name"
							itemValue="id" />
					</form:select>
					<form:errors path="category" cssClass="error" />
				</div>
                <script type="text/javascript" src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
				<script type="text/javascript">
				$('#category').tokenize({
					"newElements":false,
					maxElements:1,
					datas: "${baseURL}/categoryPost/search",
					valueField:"id",
					textField:"name"
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
				<label for="nbField" class="col-sm-2 control-label esoft-left">Nombre de Personnelle:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-1">
					<form:input path="nbPoste" cssClass="form-control" />
					<form:errors path="nbPoste" cssClass="error" />
					
				</div>															
			</div>
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Description:</label>
				<div class="col-sm-10">
					<form:textarea id="editor1" path="comment" name="editor1" rows="4" cols="80"/>
				</div>
			</div>
			
			<div class="form-group">
				<button type="reset" class="btn-sm btn btn-danger btn pull-right " onclick="location.href='${baseURL}/post/list'" style="margin-right: 2%;">Annuler</button>
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
