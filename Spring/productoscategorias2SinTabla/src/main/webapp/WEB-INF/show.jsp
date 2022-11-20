<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>New Ninja</h1>
    <form:form action="/categories/{id}" method="post" modelAttribute="ninja">
    <input type="hidden" name="_method" value="post">
            <form:label path="dojo">Dojo: </form:label>
            <form:select path="dojo">
                <c:forEach items="${dojos}" var="dojojo">
                <form:option value="${dojojo.id}"><c:out value="${dojojo.name}"/></form:option>
                </c:forEach>
            </form:select>
            <input type="submit" value="Create"/>
    </form:form>
</body>
</html>