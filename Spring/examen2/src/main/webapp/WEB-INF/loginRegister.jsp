<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
    <div>
	    <h1>Register</h1>
	    
	    <p><form:errors path="user.*"/></p>
	    
	    <form:form method="POST" action="/" modelAttribute="user">
	        <p>
	            <form:label path="firstName">First name: </form:label>
	            <form:input path="firstName"/>
	        </p>
            <p>
	            <form:label path="lastName">Last Name: </form:label>
	            <form:input path="lastName"/>
	        </p>
	        <p>
	            <form:label path="email">Email: </form:label>
	            <form:input type="email" path="email"/>
	        </p>
	        <p>
	            <form:label path="password">Password: </form:label>
	            <form:password path="password"/>
	        </p>
	        <p>
	            <form:label path="passwordConfirmation">Password Confirmation: </form:label>
	            <form:password path="passwordConfirmation"/>
	        </p>
	        <input type="submit" class="btn btn-primary" value="Register"/>
	    </form:form>
    </div>
	<div >
		<h1>Login</h1>
		<p><c:out value="${error}"></c:out></p>
		<form action="/login" method="post">
			<p>
				<label for="email">Email</label>
				<input type="email" name="email"/>
			</p>
			<p>
				<label for="password">Password</label>
				<input type="password" name="password"/>
			</p>
			<input type="submit" class="btn btn-primary" value="Login"/>
		</form>
	</div>
</body>
</html>