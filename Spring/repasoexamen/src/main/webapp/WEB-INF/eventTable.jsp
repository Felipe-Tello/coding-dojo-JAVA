<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/Css/eventTable.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
    <a href="/logout">Logout</a>
	<h2>Welcome <c:out value="${usuario.firstName}"></c:out> <c:out value="${usuario.lastName}"></c:out></h2>
    <h4>Create a new event!</h4>    
    <h4><c:out value="${usuario.state}"></c:out></h4>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>Location</th>
                <th>Host</th>
                <th>Action/Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${eventosCercanos}" var="close">
            <tr>
                <td><a href="/events/${close.id}"><c:out value="${close.name}"/></a></td>
                <td><fmt:formatDate pattern="MMMM, dd, yyyy" value="${close.dateEvent}"/></td>
                <td><c:out value="${close.location}"/></td>
                <td><c:out value="${close.host.firstName}"/></td>
                <td>
                	<c:if test="${usuario.id == close.host.id}"><a href="/events/${close.id}/edit">Edit</a></c:if>
                    <c:if test="${usuario.id == close.host.id}">
					<form action="/events/${close.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete"></form></c:if>
               		<c:if test="${usuario.id != close.host.id && !close.users.contains(usuario)}"><a href="/events/${close.id}/join">Join</a></c:if>
               		<c:if test="${usuario.id != close.host.id && close.users.contains(usuario)}"><a href="/events/${close.id}/cancel">Cancel</a></c:if>
               		
               	</td>
               	<td>

               	</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <h4>Here are some of the events in other states</h4>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>Location</th>
                <th>Host</th>
                <th>State</th>
                <th>Action/Status</th>
            </tr>
        </thead>
    	<tbody>
            <c:forEach items="${eventosNoCercanos}" var="close">
            <tr>
                <td><a href="/events/${close.id}"><c:out value="${close.name}"/></a></td>
                <td><fmt:formatDate pattern="MMMM, dd, yyyy" value="${close.dateEvent}"/></td>
                <td><c:out value="${close.location}"/></td>
                <td><c:out value="${close.host.firstName}"/></td>
                <td><c:out value="${close.state}"/></td>
               	<td>
                	<c:if test="${usuario.id == close.host.id}"><a href="/events/${close.id}/edit">Edit</a></c:if>
					<c:if test="${usuario.id == close.host.id}">
					<form action="/events/${close.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete"></form></c:if>
                    <c:if test="${usuario.id != close.host.id && !close.users.contains(usuario)}"><a href="/events/${close.id}/join">Join</a></c:if>
               		<c:if test="${usuario.id != close.host.id && close.users.contains(usuario)}"><a href="/events/${close.id}/cancel">Cancel</a></c:if>
               	</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><form:errors path="modeloEvent.*"/></p>
    <form:form method="POST" action="" modelAttribute="modeloEvent">
        <p>
            <form:label path="name">First Name</form:label>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="dateEvent">Event Date</form:label>
            <form:errors path="dateEvent"/>     
            <form:input type = "date" path="dateEvent"/>
        </p>
        <p>
            <form:label path="location">Location</form:label>
            <form:input path="location"/>
            <form:select path="state"> 
                <form:option value="California">CA</form:option>
                <form:option value="Florida">FL</form:option>
                <form:option value="Maine">ME</form:option>
                <form:option value="Nevada">NV</form:option>
                <form:option value="Virginia">VA</form:option>
                <form:option value="Ohio">OH</form:option>
            </form:select>
        </p>
        <input type="submit" value="Create!"/>
    </form:form>
</body>
</html>