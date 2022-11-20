<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>lambo</h1>
    <form:form action="/licenses/new" method="post" modelAttribute="license">
            <form:select path="person">
                <c:forEach items="${persons}" var="persona">
                <form:option value="${persona.id}"><c:out value="${persona.firstName}"/> <c:out value="${persona.lastName}"/></form:option>
                </c:forEach>
            </form:select>
        <p>
            <form:label path="state">State</form:label>
            <form:errors path="state"/>
            <form:input path="state"/>
        </p>
        <p>
            <form:label path="expirationDate">Exporation Data</form:label>
            <form:errors path="expirationDate"/>     
            <form:input type = "date" path="expirationDate"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>