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
		<h3 class="box-title">Nouveeau Role</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">

		<form:form method="POST" commandName="role" id="roleF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">nom
					de role:&nbsp;<span class="error">*</span>
				</label>
				<div class="col-sm-4">
					<form:input path="role" cssClass="form-control" />
					<form:errors path="role" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="DescriptionField"
					class="col-sm-2 control-label esoft-left">Permissions:</label>
				<div class="col-sm-4">

					<form:select path="permissions" multiple="multiple"
						cssClass="tokenize-sample  " id="permissions">
						<form:options items="${permissions}" itemLabel="label"
							itemValue="id" />
					</form:select>

					<%-- 					<form:checkboxes element="p" path="permissions" --%>
					<%-- 						items="${permissions}" itemLabel="label" itemValue="id" /> --%>
				</div>
				<script type="text/javascript"
					src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
				<script type="text/javascript">
					$('#permissions').tokenize({
						"newElements" : false,
						datas : "${baseURL}/role/search",
						valueField : "id",
						textField : "label"
					});
				</script>
			</div>
			<div class="form-group">
				<button type="reset" class="btn-sm btn btn-danger btn pull-right "
					onclick="location.href='${baseURL}/role/list'"
					style="margin-right: 2%;">Annuler</button>
				<button type="submit" class="btn-sm btn btn-primary btn pull-right"
					style="margin-right: 2%;">
					<i class="fa fa-plus"></i>&nbsp;Ajouter
				</button>
			</div>
		</form:form>
	</div>
	
</div>
<div class="box box-info">
	<div class="box-header">
	
	<h3 class="box-title"><i class="fa fa-fw fa-info-circle"></i>Légende des permissions</h3>
	</div>
		<div class="box-body">
			<table id="list1" class="table table-bordered table-striped">
				<thead>
					<tr>
					    <th>Module</th>
						<th>Permission</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${permissions}" var="perm">
						<tr>
							<td><c:out value="${perm.module}" /></td>
							<td><c:out value="${perm.label}" /></td>
							<td><c:out value="${perm.description}" /></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
				     	<th>Module</th>
						<th>Permission</th>
						<th>Description</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
<!-- /.box-body -->
<script src="${baseURL}/js/bootstrap-datepicker.js"></script>
<script src="${baseURL}/js/plugins/datatables/jquery.dataTables.js"
	type="text/javascript"></script>
<script src="${baseURL}/js/plugins/datatables/dataTables.bootstrap.js"
	type="text/javascript"></script>
<script
	src="${baseURL}/js/plugins/datatables/dataTables.ColumnFilter.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
    $('#list1').DataTable({
    		"paging":   false,});
     } );
</script>
