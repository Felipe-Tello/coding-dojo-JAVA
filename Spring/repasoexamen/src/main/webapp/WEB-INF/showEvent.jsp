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
<body class="container	">
 	<h1><c:out value="${eventoPorId.name}"/></h1>
 	<h3>Host: <c:out value="${eventoPorId.host.firstName}"/></h3>
 	<h3>Date: <fmt:formatDate pattern="MMMM, dd, yyyy" value="${eventoPorId.dateEvent}"/></h3>
    <h3>Location: <c:out value="${eventoPorId.location}"/>, <c:out value="${eventoPorId.state}"/></h3>
    <h3>People who attending this event: <c:out value="${eventoPorId.users.size()}"/></h3>
    
        <h1>Message Wall</h1>
       	<p>
            <textarea readonly rows="10" cols="40"><c:out value="${data}"/></textarea>
        </p>
        <h4>Add comment:</h4>
        <form:form action="" method="post" modelAttribute="modeloMessage">
        <p>
            <form:label path="messageContent"></form:label>
            <form:errors path="messageContent"/>
            <form:textarea path="messageContent" name="content" cols="20" rows="1"></form:textarea>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
    <table>
    	<thead>
    		<tr>
    			<th>Name</th>
    			<th>Location</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${listadeUsers}" var="asistentes">
    		<tr>	
    			<td><c:out value="${asistentes.firstName}"/></td>
    			<td><c:out value="${asistentes.state}"/></td>
    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
    
</body>
</html>