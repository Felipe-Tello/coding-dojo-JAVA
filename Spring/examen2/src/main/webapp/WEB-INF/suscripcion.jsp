<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <div>
		<header>
			<h1>Welcome: <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></h1><br>
			<a href="/logout"class="p-3 mb-2 bg-secondary text-white rounded border border-dark">Logout</a>
		</header><br>
		<h2>Your Current Package: <c:out value="${user.pack.name}"/></h2>
		<h2>Package Cost: $<c:out value="${user.pack.cost}"/></h2>
		<h2>Switch Package</h2>
        <!-- <form:errors path="user.*"></form:errors>
		<form:form action="/users/${user.id}" modelAttribute="user" method="post">
			<form:select path="pack">
				<c:forEach items="${packages}" var="p">
					<c:if test="${p.available == true && user.pack.name != p.name}">
						<form:option value="${p.id}"><c:out value="${p.name}"/></form:option>
					</c:if>
				</c:forEach>
			</form:select>
			<input type="submit" class="btn btn-primary" value="Switch"> 
		</form:form> -->
        <form action="/users/${user.id}/cambiar" >
        <select name="pack">
            <c:forEach items="${paquetes}" var="p">
                <option value="${p.id}"><c:out value="${p.name}"></c:out></option>
            </c:forEach>
        </select>
        <input type="submit" class="btn btn-primary" value="Switch">
        </form>
	</div>
</body>
</html>