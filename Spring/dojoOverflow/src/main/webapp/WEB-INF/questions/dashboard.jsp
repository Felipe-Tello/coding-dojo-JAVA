<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Questions Dashboard</h1>
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${questions}" var="question">
				<tr>
					<td><a href="/questions/${question.id}"><c:out value="${question.questionText}"/></a>
					</td>
					<td>
						<c:forEach items="${question.tags}" var="tag">
							<c:out value="${tag.subject}"/>
						</c:forEach>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/questions/new">New Question</a>
	</div>
</body>
</html>