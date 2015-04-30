<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<div class="nav-tabs-custom">
	<ul id="tabs" class="nav nav-tabs">
		<li class="active"><a href="#fiche" data-toggle="tab"
			aria-expanded="true"><i class="fa fa-file"></i>&nbsp;Fiche Category</a></li>
		<li class=""><a href="#category" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-bars" style=""></i>&nbsp;Catégorie</a></li>

	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade active in" id="fiche">
			<div class="tab-pane  active" id="fiche-tab">
				<div class="row">
					<div class="col-md-12">
						<div class="category-info"
							style="padding-left: 1%; padding-top: 4%;">
							<div class="global-info">
									<div class=" col-sm-12 table-responsive">
										<table class="table">
											<tbody>
												<tr>
													<th style="width: 50%"><label>Nom:</label></th>
													<td><span class="text-muted"><c:out value="${category.name}" /></span></td>
												</tr>
												<tr>
													<th><label>Description:</label></th>
													<td><c:out value="${category.description}" escapeXml="false" /></td>
												</tr>
											</tbody>
										</table>
									</div>
							</div>


						</div>
					</div>
					<div>
						<form method="POST" name="category" id="categoryF">
							<button type="button" class="btn btn-primary pull-right "
								style="margin-top: 22%; margin-right: 4%;"
								onclick="location.href='${baseURL}/category/update?id=${category.id}'">
								<i class="fa fa-pencil-square-o"></i>&nbsp;Modifier
							</button>
						</form>
					</div>
				</div>

			</div>

		</div>
		<div class="tab-pane fade" id="category">
			<h3>
				categoriiii<br />catatta
			</h3>
		</div>

	</div>
</div>

<div class="box box-solid box-primary">
	<div class="box-header">
		<h3 class="box-title">Liste Produits appartenant à cette catégorie</h3>
		<div class="box-tools pull-right">
			<button class="btn btn-primary btn-sm" data-widget="collapse">
				<i class="fa fa-minus"></i>
			</button>
			<button class="btn btn-primary btn-sm" data-widget="remove">
				<i class="fa fa-times"></i>
			</button>
		</div>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">
	<div class="form-group"> <table class="table">
											<tbody>
												<tr>
													<th style="width: 50%"><label>Nom:</label></th>
													<td><span class="text-muted"><c:out value="${category.name}" /></span></td>
												</tr>
												<tr>
													<th><label>Description:</label></th>
													<td><c:out value="${category.description}" escapeXml="false" /></td>
												</tr>
											</tbody>
										</table></div>
					</div>
				</div>
<script type="text/javascript">
    $('#tabs a').click(function (e) {
    	  e.preventDefault()
    	  $(this).tab('show')
    	})
</script>
