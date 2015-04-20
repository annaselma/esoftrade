<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<div class="nav-tabs-custom">
<ul id="tabs" class="nav nav-tabs">
	<li class="active"><a href="#profile" data-toggle="tab"
		aria-expanded="true"><i class="fa fa-user"></i>Profile</a></li>
	<li class=""><a href="#permissions" data-toggle="tab"
		aria-expanded="false"><i class="fa fa-bars" style=""></i>Permissions</a></li>

</ul>
<div id="myTabContent" class="tab-content">
	<div class="tab-pane fade active in" id="profile">
		<div class="tab-pane profile active" id="profile-tab">
			<div class="row">
				<div class="col-md-3">
					<div class="user-info-left"
						style="text-align: center; padding: 21% 0">
						<img src="${baseURL}/img/avatar3.png" alt="Profile Picture"
							class="img-thumbnail">
						<h3>
							<c:out value="${user.name} ${user.lastName}" />
						</h3>
						<div class="">
							<div id="statut">
								Statut &nbsp;
								<c:choose>
									<c:when test="${user.active}">
										<div id="statut" class="label label-success">Active</div>
									</c:when>
									<c:otherwise>
										<div id="statut" class="label label-danger">innactive</div>
									</c:otherwise>
								</c:choose>
							</div>

						</div>
					</div>
				</div>
				<div class="col-md-9">
					<div class="user-info-right"
						style="border-left: 1px solid #ddd; padding-left: 6%; padding-top: 4%;">
						<div class="global-info">
							<h4>
								<i class="fa fa-user" style="margin-right: 2%"></i>Information personnelle
							</h4>
							<form method="POST" name="user" id="userF">
							<button type="button" class="btn btn-primary pull-right" style="margin-right: 3%;" onclick="location.href='http://localhost:8080/esoftrade/user/update?id=${user.id}'">Modifier</button>
							</form>
							<p class="data-row">
								<label class="col-sm-2 ">Num Compte:</label>
								<span class="data-value text-red"><c:out value="${user.ref}"/> </span>
							</p>
							<p class="data-row">
								<label class="col-sm-2">Identifiant :</label>
								<span class="data-value label label-default"><c:out value="${user.login}"/> </span>
							</p>
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2">Fonction:</label><span
									class="data-value"><c:out value="${user.fonction}"/></span>
							</p>
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2">Né le:</label><span class="data-value">
									<fmt:formatDate pattern="dd/MM/yyyy" value="${user.birdDay}" /></span>
							</p>
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2 ">Telephone:</label><span
									class="data-value"><c:out value="${user.telephone}"/></span>
							</p>
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2">Adresse:</label><span
									class="data-value"><c:out value="${user.adresse1}"/> </span>
							</p>
							<hr class="bs-docs-separator ">
							<p>
								<label class="col-sm-2 ">Code Postal:</label><span
									class="data-value"><c:out value="${user.zipCode}"/></span>
							</p>
							<hr class="bs-docs-separator ">
							<p class="data-row">
								<label class="col-sm-2">Ville:</label> <span
									class="data-value"><c:out value="${user.city}"/></span>
							</p>
							<hr class="bs-docs-separator ">
							<p>
								<label class="col-sm-2">Pays:</label> <span
									class="data-value"><c:out value="${user.country}"/></span>
							</p>

						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="tab-pane fade" id="permissions"> <h3>bhalal</h3></div>
	
</div>
</div>


<script type="text/javascript">
    $('#tabs a').click(function (e) {
    	  e.preventDefault()
    	  $(this).tab('show')
    	})
</script> 