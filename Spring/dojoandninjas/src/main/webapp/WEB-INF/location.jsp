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
    <h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
    <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dojo.ninjas}" var="dojojo">
            <tr>
                <td><c:out value="${dojojo.firstName}"/></td>
                <td><c:out value="${dojojo.lastName}"/></td>
                <td><c:out value="${dojojo.age}"/></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>