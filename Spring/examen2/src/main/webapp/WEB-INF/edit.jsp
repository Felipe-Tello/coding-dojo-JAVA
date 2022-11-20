<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title><c:out value="${pack.name}"/></title>
</head>
<body>
	<h1>Package: <c:out value="${pack.name}"/></h1>
	<form:form method="post" modelAttribute="pack" action="/packages/${idS}/edit">
	<input type="hidden" name="_method" value="PUT">
		<span class="error"><c:out value="${error}"/></span>
		<form:input type="hidden" path="name" value="${pack.name}"/>
		<p>
			<form:label path="cost">Cost:</form:label>
			<form:input path="cost"/>
		</p>
		<input type="submit" class="btn btn-primary" value="Edit">
	</form:form>
	<c:if test="${pack.users.size() == 0}">
		<a href="/packages/${pack.id}/delete" class="btn btn-outline-danger" >Delete</a>	
	</c:if>
</body>
</html>