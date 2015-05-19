<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
	<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
	<section class="content-header">
<%--                               <c:choose> --%>
<%--                    <c:when test="${Product}"><h1> --%>
<!--                         Produit -->
<%--                         <c:set var="pages" value="${fn:split('add,List,Profile,modification}" scope="application"/> --%>
<%--                         <c:forEach var="val" items="${pages}"><small> --%>
<%--                         <c:out value="${val}"/> </small></c:forEach> --%>
                        
<!--                     </h1> -->
<!--                     <ol class="breadcrumb"> -->
<!--                         <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li> -->
<!--                         <li class="active">Produit</li> -->
<%--                     </ol></c:when> --%>
<!--                     Dashboard -->
<%--                    <c:when test="${Dashboard}"><h1> --%>
<!--                         Dashboard -->
<!--                         <small>Control panel</small> -->
<!--                     </h1> -->
<!--                     <ol class="breadcrumb"> -->
<!--                         <li><a href="#"><i class="fa  fa-shopping-cart"></i> Home</a></li> -->
<!--                         <li class="active">Dashboard</li> -->
<%--                     </ol></c:when> --%>
<%--                    <c:when test=""></c:when> --%>
<%--                    <c:when test=""></c:when> --%>
<!--                    Warehouse -->
<%--                    <c:when test="${Warehouse}"><h1> --%>
<!--                         Warehouse -->
<%--                         <c:forEach var="items" begin="1" end="4"><small><c:out value="${items}"/> </small></c:forEach> --%>
                        
<!--                     </h1> -->
<!--                     <ol class="breadcrumb"> -->
<!--                         <li><a href="#"><i class="fa  fa-truck"></i> Home</a></li> -->
<!--                         <li class="active">Warehouse</li> -->
<%--                     </ol></c:when> --%>
<!--                     ProductCategory -->
<%--                     <c:when test="${CategoryProduct}"><h1> --%>
<!--                         Catégorie -->
<%--                         <c:forEach var="items" begin="1" end="4"><small><c:out value="${items}"/> </small></c:forEach> --%>
                        
<!--                     </h1> -->
<!--                     <ol class="breadcrumb"> -->
<!--                         <li><a href="#"><i class="fa fa-list"></i> Home</a></li> -->
<!--                         <li class="active">Catégorie</li> -->
<%--                     </ol></c:when> --%>
<%--                    </c:choose> --%>
                   
                    <h1>
                        Dashboard
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Dashboard</li>
                    </ol>
                </section>