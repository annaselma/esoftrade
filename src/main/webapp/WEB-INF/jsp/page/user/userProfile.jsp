<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />

<style>
.error {
	color: #ff0000;
}
.fileUpload {
    position: relative;
    overflow: hidden;
    margin: 10px;
}
.fileUpload input.upload {
    position: absolute;
    top: 0;
    right: 0;
    margin: 0;
    padding: 0;
    font-size: 20px;
    cursor: pointer;
    opacity: 0;
    filter: alpha(opacity=0);
}
</style>
<div class="nav-tabs-custom">
	<ul id="tabs" class="nav nav-tabs">
		<li class="active"><a href="#profile" data-toggle="tab"
			aria-expanded="true"><i class="fa fa-user"></i>Profile</a></li>
		<li class=""><a href="#permissions" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-bars" style=""></i>Permissions</a></li>
       <li class=""><a href="#suivi" data-toggle="tab"
			aria-expanded="false"><i class="fa fa-eye" style=""></i>Traçabilité</a></li>
       
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade active in" id="profile">
			<div class="tab-pane profile active" id="profile-tab">
				<div class="row">
					<div class="col-md-3">
						<div class="user-info-left"
							style="text-align: center; padding: 21% 0">
														<c:choose>
							<c:when test="${empty user.picture }">
							     	<c:set var="imageURL" value="${baseURL}/img/avatar.png" />
                                </c:when>
								<c:when test="${user.picture.id == 0}">
							     	<c:set var="imageURL" value="${baseURL}/img/avatar.png" />
                                </c:when>
								<c:otherwise>
								     <c:set var="imageURL" value="${baseURL}/file/?id=${user.picture.id}" />
								</c:otherwise>
							</c:choose>
							<img src="${imageURL}" alt="image produit"
								class="img-thumbnail">
							<form id="upload-image" method="POST"
								action="${baseURL}/user/image"
								enctype="multipart/form-data" class="form-inline">

								<div class="fileUpload btn btn-xs btn-primary">
									<span><i class="fa fa-download"></i>changer l'image</span> <input
										type="file" name="file" class="upload" />
								</div>

								<input type="hidden" name="id" value="${user.id}"> <input
									type="submit" value="valider" class="btn btn-xs btn-success"
									style="display: none;">

							</form>
							<span id="image-errors" class="error" style="display: none;"></span>


							<script type="text/javascript">
							$(document).ready(function(){
								$(' .user-info-left input[type=file]').bind('change', function(event) {
									var ext = $(this).val().split('.').pop().toLowerCase();
									$img=' .user-info-left .img-thumbnail';
									$image_erreur='#image-errors';
									$submit='.user-info-left input[type=submit]';
									
									if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
										$($image_erreur).text("les types acceptés sont: gif ou png ou jpg ou jpeg ");
										$($image_erreur).show(100);
									    return;
									}
									if (this.files[0].size > 10000000) {
										$($image_erreur).text("la taille de l'image ne doit pas dépasser 10 Mo")
										$($image_erreur).show(100);
									} else {
										var reader = new FileReader();
										reader.onload = function (e) {
								            $($img).attr('src', e.target.result);
								            $($img).css('opacity','0.5');
								        }
								        reader.readAsDataURL(this.files[0]);
										$($image_erreur).hide(100);
										$($submit).show(100);
										
									}

								});
							});

							</script>
							
							<h4>
								<c:out value="${user.name} ${user.lastName}" />
							</h4>
							<div class="">
								<div id="statut">
									Statut &nbsp;
									<c:choose>
										<c:when test="${user.active}">
											<div id="statut" class="label label-success">Actif</div>
										</c:when>
										<c:otherwise>
											<div id="statut" class="label label-danger">désactivé</div>
										</c:otherwise>
									</c:choose>
								</div>

							</div>

						</div>
					</div>
					<div class="col-md-9">
						<div class="user-info-right"
							style="padding-left: 6%; padding-top: 4%;">
							<div class="global-info">
								<h4>
									<i class="fa fa-user" style="margin-right: 2%"></i>Informations
									personnelle
								</h4>

								<div class=" col-sm-12 table-responsive">
									<table class="table">
										<tbody>
											<tr>
												<th style="width: 50%"><label class=" ">Num
														Compte:</label></th>
												<td><span class="data-value text-red"><c:out
															value="${user.ref}" /> </span></td>
											</tr>
											<tr>
												<th><label class="">Identifiant</label></th>
												<td><span class="data-value label label-default"><c:out
															value="${user.login}" /> </span></td>
											</tr>
											<tr>
												<th><label>Adresse Email:</label></th>
												<td><a href="mailto:<c:out value="${user.email}"/>"><c:out
															value="${user.email}" /></a></td>
											</tr>
											<tr>
												<th><label>Fonction</label></th>
												<td><span class="data-value"><c:out
															value="${user.fonction}" /></span></td>
											</tr>
											<tr>
												<th>Date de naissance:</th>
												<td><span class="data-value"> <fmt:formatDate
															pattern="dd/MM/yyyy" value="${user.birdDay}" /></span></td>
											</tr>
											<tr>
												<th>Telephone:</th>
												<td><c:out value="${user.telephone}" /></td>
											</tr>
											<tr>
												<th>adresse:</th>
												<td><c:out value="${user.adresse1}" /></td>
											</tr>

											<tr>
												<th>Code Postal:</th>
												<td><c:out value="${user.zipCode}" /></td>
											</tr>
											<tr>
												<th>Ville:</th>
												<td><c:out value="${user.city}" /></td>
											</tr>
											<tr>
												<th>Pays:</th>
												<td><c:out value="${user.country}" /></td>
											</tr>
										</tbody>
									</table>
								</div>

								<div>
									<form method="POST" name="user" id="userF">
										<button type="button" class="btn btn-primary pull-right "
											style="margin-top: 9%"
											onclick="location.href='${baseURL}/user/update?id=${user.id}'">
											<i class="fa fa-pencil-square-o"></i>&nbsp;Modifier
										</button>
									</form>
								</div>

							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="permissions">
			<h3>bhalal</h3>
		</div>
		<div class="tab-pane fade" id="suivi">
			<table class="table">
				<tbody>
					<tr>
						<th><label class="">Créé par:</label></th>
						<td><img src="${baseURL}/file?id=${user.creator.picture.id}" class="img-circle" alt="User Image" style="width: 29px; height: 28px;"><span class="data-value label label-inverse">
							<a href="<c:out value="${baseURL}/user/profile?id=${user.creator.id}"/>"><c:out
															value="${user.creator.lastName} ${user.creator.firstName}" /></a>
						 </span></td>
					</tr>
					<tr>
						<th><label>Date création:</label></th>
						<td><fmt:formatDate
									pattern="dd/MM/yyyy" value="${user.createDate}" /></td>
					</tr>
					<tr>
						<th><label>Modifié par:</label></th>
						<td><img src="${baseURL}/file?id=${user.modifier.picture.id}" class="img-circle" alt="User Image" style="width: 29px; height: 28px;"><span class="data-value label label-important">
							<a href="<c:out value="${baseURL}/user/profile?id=${user.modifier.id}"/>"><c:out
															value="${user.modifier.lastName} ${user.modifier.firstName}" /></a>
						 </span></td>
					</tr>
					<tr>
						<th>Date de modification:</th>
						<td><span class="data-value"><fmt:formatDate
									pattern="dd/MM/yyyy" value="${user.lastEdit}" /></span></td>
					</tr>

				</tbody>
			</table>
		</div>

	</div>
</div>



<script type="text/javascript">
    $('#tabs a').click(function (e) {
    	  e.preventDefault()
    	  $(this).tab('show')
    	})
</script>
