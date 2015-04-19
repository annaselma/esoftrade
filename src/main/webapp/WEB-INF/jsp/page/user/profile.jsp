<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />

<ul class="nav nav-tabs">
	<li class="active"><a href="#profile" data-toggle="tab"
		aria-expanded="true"><i class="fa fa-user"></i>Profile</a></li>
	<li class=""><a href="#permissions" data-toggle="tab"
		aria-expanded="false"><i class="fa fa-bars" style=""></i>Permissions</a></li>

</ul>
<div id="myTabContent" class="tab-content">
	<div class="tab-pane fade active in" id="home">
		<div class="tab-pane profile active" id="profile-tab">
			<div class="row">
				<div class="col-md-3">
					<div class="user-info-left"
						style="text-align: center; padding: 21% 0">
						<img src="${baseURL}/img/avatar3.png" alt="Profile Picture"
							class="img-thumbnail">
						<h3>
							<c:out value="${user.name}" />
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
								<i class="fa fa-square" style="margin-right: 2%"></i>Contact
								Information
							</h4>
							<p class="data-row">
								<span id="identifiant" class="label label-default">référence</span>
								<span class="data-value"><c:out value="${user.ref}"/> </span>
							</p>
							<p class="data-row">
								<span id="identifiant" class="label label-default">Identifiant</span>
								<span class="data-value"><c:out value="${user.login}"/> </span>
							</p>
							<p class="data-row">
								<span id="prenom" class="label label-default">Prenom</span> <span
									class="data-value"><c:out value="${user.lastName}"/></span>
							</p>
							<p class="data-row">
								<span id="nom" class="label label-default">Nom</span> <span
									class="data-value"><c:out value="${user.name}"/></span>
							</p>
							<p class="data-row">
								<span id="dateN" class="label label-default">Date
									Naissance</span> <span class="data-value">
									<fmt:formatDate pattern="dd/MM/yyyy" value="${user.birdDay}" /></span>
							</p>
							<p class="data-row">
								<span id="tel" class="label label-default">Telephone</span> <span
									class="data-value"><c:out value="${user.telephone}"/></span>
							</p>
							<p class="data-row">
								<span id="adresse" class="label label-default">Adresse</span> <span
									class="data-value"><c:out value="${user.adresse1}"/> </span>
							</p>
							<p>
								<span id="CP" class="label label-default">Code Postal</span> <span
									class="data-value"><c:out value="${user.zipCode}"/></span>
							</p>
							<p class="data-row">
								<span id="ville" class="label label-default">Ville</span> <span
									class="data-value"><c:out value="${user.city}"/></span>
							</p>
							<p>
								<span id="pays" class="label label-default">pays</span> <span
									class="data-value"><c:out value="${user.country}"/></span>
							</p>

						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="tab-pane fade" id="profile">
		<p></p>
	</div>

</div>