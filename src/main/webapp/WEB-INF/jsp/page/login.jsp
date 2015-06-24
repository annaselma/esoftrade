<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
	
	<!DOCTYPE html>
<html class="bg-black">
    <head>
        <meta charset="UTF-8">
        <title>login</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${baseURL}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${baseURL}/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${baseURL}/css/AdminLTE.css" rel="stylesheet" type="text/css" />
        <style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
 
.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
 

</style>
    </head>
    <body class="bg-black">
      
        <div class="form-box" id="login-box">
            <div class="header" style="background: #3BB0DA;">
            <img src="${baseURL}/img/testG.png" class="img-circle" alt="Image" style="width: 100px; height: 100px;"></div>
            <form action="<c:url  value='j_spring_security_check' />" method='POST'>
            <c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="Login"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Mot de passe"/>
                    </div>          
                   
                </div>
                <div class="footer" style="background: #3BB0DA;">                                                               
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Connecter</button>  
                    
                    <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
                </div>
            </form>

        </div>


        <!-- jQuery 2.0.2 -->
        <script src="${baseURL}/js/jquery-2.1.3.js"></script>
        <!-- Bootstrap -->
        <script src="${baseURL}/js/bootstrap.min.js" type="text/javascript"></script>        

    </body>
</html>