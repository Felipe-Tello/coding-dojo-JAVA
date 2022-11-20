<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Profile</title>
<link rel="stylesheet" type="text/css" href="/css/answer.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1><c:out value="${question.questionText}"/></h1>
		<div>
			<h2 class="alinear">Tags:</h2>
			<c:forEach items="${question.tags}" var="tag">
				<h3 class="alinear"><c:out  value="${tag.subject}"/></h3>
			</c:forEach>
		</div>
		<div class="alinear" id="tabla">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Answers</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${question.answers}" var="answer">
						<tr>
							<td><c:out value="${answer.answerText}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="alinear">
			<h2>Add your Answer</h2>
			<form:form action="/questions/${question.id}" method="POST" modelAttribute="answer">
				<form:label class="alinear" path="answerText">Answer</form:label>
				<form:errors class="error" path="answerText"/>
	        	<form:textarea cols="35" rows="5" path="answerText"/>
	       		<input class="btn btn-primary" type="submit" value="Answer it!">
	       	</form:form>
	       	<a href="/questions/new">New Question</a>
		</div>
	</div>
</body>
</html>