<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
	<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
	<section class="content-header">
                    <h4><a href="${baseURL}/warehouse/list">Entrepôts</a>
                        <small>Profil</small>
                    </h4>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i>Acceuil</a></li>
                        <li class="active">Stock</li>
                    </ol>
                </section>