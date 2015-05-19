<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet" type="text/css" href="${baseURL}/css/tokenize/jquery.tokenize.css" />
<script type="text/javascript" src="${baseURL}/js/plugins/tokenize/jquery.tokenize.js"></script>
<div id="hello">
<select id="tokenize" class="tokenize-sample">
<option selected="selected" value="ad">ayoubddddddddddddddddddd</option>
</select>
</div>
<script type="text/javascript">
$('#tokenize').tokenize({
	"newElements":false,
	maxElements:3,
	datas: "${baseURL}/data.json",
	});
$("#hello").on("focus", ".tokenize-sample ", function() {
    console.log($(".Token span").text());
   $text= $(".Token span").text();
   $(".Token").remove();
    $(".TokenSearch input").val($text);
});
</script>
