<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<link rel="stylesheet" type="text/css" href="/css/loginRegister.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
	<div class="bg-image" 
	     style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/76.jpg');
	            height: 150vh">
	
	<div class="contenedor" >
        <header>
            <h1>Welcome</h1>
        </header>
        <div class="flex">
            <div class="alinear recuadro">
                <h1>Register</h1>
                <p class="error"><form:errors  path="user.*"/></p>
                
                <form:form method="POST" action="/" modelAttribute="user">
                    <p>
                        <form:label path="firstName">First Name</form:label>
                        <form:input path="firstName"/>
                    </p>
                    <p>
                        <form:label path="lastName">Last Name</form:label>
                        <form:input path="lastName"/>
                    </p>
                    <p>
                        <form:label path="email">Email:</form:label>
                        <form:input type="email" path="email"/>
                    </p>
                    <p>
                        <form:label path="location">Location</form:label>
                        <form:input path="location"/>
                    </p>
                    <p>
                        <form:label path="state">Region</form:label>
                        <form:select path="state">
                            <option value="CA">CA</option>
                            <option value="ID">ID</option>
                        </form:select>
                    </p>
                    <p>
                        <form:label path="password">Password:</form:label>
                        <form:password path="password"/>
                    </p>
                    <p>
                        <form:label path="passwordConfirmation">PW Conf:</form:label>
                        <form:password path="passwordConfirmation"/>
                    </p>
                    <input class="btn btn-primary moveButton" type="submit" value="Register!"/>
                </form:form>
            </div>
            <div class="alinear recuadro">
                <h1>Login</h1>
                <p class="error"><c:out value="${error}"/></p>
                <form method="post" action="/login">
                    <p>
                        <label for="email">Email</label>
                        <input type="text" id="email" name="email"/>
                    </p>
                    <p>
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password"/>
                    </p>
                    <input class="btn btn-primary moveButton" type="submit" value="Login!"/>
                </form>
            </div>
        </div>
    </div>
    </div>
</body>
</html>