<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
<link rel="stylesheet" type="text/css" href="/css/question.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>What is your question?</h1>
		<form:form action="/questions/new" method="post" modelAttribute="question">
			<div>
				<form:label class="alinear" path="questionText">Question</form:label>
		        <form:errors class="error" path="questionText"/>
		        <form:textarea cols="100" rows="5" path="questionText"/>
		   </div>
		   <div>
				<label for="tag">Tags</label>
		        <input type="text" name="tag">
		   </div>
				<input class="btn btn-secondary" type="submit" value="Create">
		</form:form>
	</div>
</body>
</html>