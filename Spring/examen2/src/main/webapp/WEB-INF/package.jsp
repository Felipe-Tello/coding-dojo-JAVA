<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>Subscriptions</title>
</head>
<body>
	<div>
		<header>
			<h1 class="text-center">Admin Dashboard</h1><br>
			<a href="/logout" class="p-3 mb-2 bg-secondary text-white rounded border border-dark">Logout</a>
		</header>
        <br>
		<h1>Customers</h1>
		<table class="table table-sm table-dark">
			<thead>
				<tr>
					<th>Name</th>
					<th>Next Due Date</th>
					<th>Amount Due</th>
					<th>Package Type</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="u">
					<c:if test="${user.rol !=  1}">
						<tr class="table-info">
							<td><c:out value="${u.firstName}"/></td>
							<td><c:out value="${u.entrega}"/></td>
							<td><c:out value="${u.pack.cost}"/></td>
							<td><c:out value="${u.pack.name}"/></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<h2>Packages</h2>
		<table class="table table-sm table-dark">
			<thead>
				<tr>
					 <th>Package Name</th>
					 <th>Package Cost</th>
					 <th>Available</th>
					 <th>Users</th>
					 <th>Actions</th>
				</tr>			
			</thead>
			<tbody>
				<c:forEach items="${packages}" var="p">
				<tr class="table-danger">
					<td><c:out value="${p.name}"/></td>
					<td>$<c:out value="${p.cost}"/></td>
					<td>
						<c:if test="${p.available == true}">available</c:if>
						<c:if test="${p.available == false}">unavailable</c:if>
					</td>
					<td><c:out value="${p.users.size()}"/>
					<td>
						<c:if test="${p.users.size() > 0 && p.available == false}">desactivate</c:if>
						<c:if test="${p.users.size() == 0 && p.available == false}">
							<a href="/packages/${p.id}/valido" class="btn btn-outline-info btn-sm">activate</a>
						</c:if>
						<c:if test="${p.users.size() == 0 && p.available == true}">
							<a href="/packages/${p.id}/valido" class="btn btn-outline-danger btn-sm">desactivate</a>
						</c:if>
						<a href="/packages/${p.id}/edit" class="btn btn-outline-success btn-sm" >edit</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2>Create Package</h2>
		<form:form action="" method="post" modelAttribute="pack">
			<p>
				<form:label path="name">Package Name:</form:label>
				<form:input path="name"/>
				<form:errors path="name"/>
			</p>
			<p>
				<form:label path="cost">Cost:</form:label>
				<form:input path="cost"/>
				<form:errors path="cost"/>
			</p>
			<input type="submit" class="btn btn-primary" value="Create new package">
		</form:form>
	</div>	
</body>
</html>