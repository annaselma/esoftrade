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
		<h3 class="box-title">Nouvel arrivage</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">
<span class="error">Veillez sasir les champs obligatoire (*)</span>
		<form:form method="POST" commandName="product" id="productF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Libéllé:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:input path="libelle" cssClass="form-control" />
					<form:errors path="libelle" cssClass="error" />
				</div>

			</div>
			<div class="form-group form-horizontal">
				<label for="statut" class="col-sm-2 control-label esoft-left">Statut (en vente)&nbsp;<span class="error">*</span></label>
				<div class="col-sm-1" style="margin-top:1%">
					<form:checkbox path="sellingState" />
					<form:errors path="sellingState" cssClass="error" /></div>
				    <label for="achat" class="col-sm-2 control-label">( en achat):&nbsp;<span class="error">*</span></label>
				<div class="col-sm-1"style="margin-top:1%">
					<form:checkbox path="purchasingState" />
					<form:errors path="purchasingState" cssClass="error" />
				</div>
					

			
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
					datas: "${baseURL}/category/search",
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

				<label for="natureField" class="col-sm-2 control-label esoft-left">Nature:
				</label>
				<div class="col-md-4">
					<form:select path="nature" cssClass="form-control ">
                        <option value="" selected></option>
						<option value="manufacturé">manufacturé</option>
						<option value="matière première">matière première</option>
						</form:select>
						<form:errors path="nature" cssClass="error" />
						</div></div>
			<div class="form-group">

				<label for="deptField" class="col-sm-2 control-label esoft-left">Département:
				</label>
				<div class="col-md-4">
					<form:select path="nature" cssClass="form-control ">
                        <option value="" selected></option>
						<option value="achat">Achat</option>
						<option value="importation">Importation</option>
						<option value="fabrication">Fabrication</option>
						</form:select>
						<form:errors path="nature" cssClass="error" />
						</div></div>
			<div class="form-group">
				<label for="wheightField" class="col-sm-2 control-label esoft-left">Poids:</label>
				<div class="col-sm-2">
					<form:input path="wheight" cssClass="form-control" />
					<form:errors path="wheight" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="lenghtField" class="col-sm-2 control-label esoft-left">Longueur:</label>
				<div class="col-sm-2">
					<form:input path="lenght" cssClass="form-control" />
					<form:errors path="lenght" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="surfaceField" class="col-sm-2 control-label esoft-left">Surface:</label>
				<div class="col-sm-2">
					<form:input path="surface" cssClass="form-control" />
					<form:errors path="surface" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="volumeField" class="col-sm-2 control-label esoft-left">volume:</label>
				<div class="col-sm-2">
					<form:input path="volume" cssClass="form-control" />
					<form:errors path="volume" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="priceField" class="col-sm-2 control-label esoft-left">Prix:</label>
				<div class="col-sm-2">
					<form:input path="price" cssClass="form-control" />
					<form:errors path="price" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="stockdField" class="col-sm-2 control-label esoft-left">Stock désiré:</label>
				<div class="col-sm-2">
					<form:input path="desieredTreshold" cssClass="form-control"  onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
					<form:errors path="desieredTreshold" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="stockAField" class="col-sm-2 control-label esoft-left">alert stock:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-2">
					<form:input path="alertTreshold" cssClass="form-control"  onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
					<form:errors path="alertTreshold" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Description:</label>
				<div class="col-sm-10">
					<form:textarea id="editor1" path="description" name="editor1" rows="4" cols="80"/>
				</div>
			</div>
			
			<div class="form-group">
				<button type="reset" class="btn-sm btn btn-danger btn pull-right " onclick="location.href='${baseURL}/product/list'" style="margin-right: 2%;">Annuler</button>
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
