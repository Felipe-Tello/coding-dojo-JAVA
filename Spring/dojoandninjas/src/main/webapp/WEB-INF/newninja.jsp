<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <a href="http://localhost:8080/dojos/new">crear nuevo dojo</a>
    <h1>New Ninja</h1>
    <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
    <input type="hidden" name="_method" value="post">
            <form:label path="dojo">Dojo: </form:label>
            <form:select path="dojo">
                <c:forEach items="${dojos}" var="dojojo">
                <form:option value="${dojojo.id}"><c:out value="${dojojo.name}"/></form:option>
                </c:forEach>
            </form:select>
        <p>
            <form:label path="firstName">First Name: </form:label>
            <form:errors path="firstName"/>
            <form:input path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name: </form:label>
            <form:errors path="lastName"/>
            <form:input path="lastName"/>
        </p>
        <p>
            <form:label path="age">Age: </form:label>
            <form:errors path="age"/>
            <form:input type="number" path="age" min="1" max="99"/>
        </p>      
        <input type="submit" value="Create"/>
    </form:form>
</body>
</html>