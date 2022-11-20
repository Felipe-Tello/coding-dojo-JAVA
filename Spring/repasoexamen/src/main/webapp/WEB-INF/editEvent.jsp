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
</head>
<body>
<h1>HOLA</h1>
	<p><form:errors path="modeloEvent.*"/></p>
    <form:form method="POST" action="" modelAttribute="modeloEvent">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="name">First Name</form:label>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="dateEvent">Exporation Data</form:label>
            <form:errors path="dateEvent"/>     
            <form:input path="dateEvent" type ="date"/>
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