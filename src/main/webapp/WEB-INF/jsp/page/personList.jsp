<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div style="margin: 10px;">
	<h4>List of Persons</h4>
	<table style="width: 600px" class="reference">
		<tbody>
		<tr>
			<th>Sr. No.</th>
			<th>Name</th>
			<th>Age</th>
			<th>Email</th>
		</tr>
		<c:forEach var="person" items="${requestScope.persons}"
			varStatus="loopCounter">
		<tr>
			<td><c:out value="${loopCounter.count}" /></td>
			<td><c:out value="${person.name}" /></td>
			<td><c:out value="${person.email}" /></td>
			<td><c:out value="${person.age}" /></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>