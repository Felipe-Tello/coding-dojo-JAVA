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
    <!-- <h1>All Books</h1> -->
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Creator</th>
                <th>Version</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${languages}" var="language">
            <tr>
                <td><a href="/language/${language.id}"><c:out value="${language.name}"/></a></td>
                <td><c:out value="${language.creator}"/></td>
                <td><c:out value="${language.version}"/></td>
                <td><form action="/language/${language.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete">
                </form>
                </td>
                <td>
                    <a href="/language/${language.id}/edit">Edit</a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <form:form action="/language" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="post">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:input path="creator"/>
        </p>
        <p>
            <form:label path="version">Version</form:label>
            <form:errors path="version"/>     
            <form:input type="version" path="version"/>
        </p>    
        <input type="submit" value="Submit"/>
    </form:form>    
    

    <!-- <a href="/language/new">New language</a> -->
</body>
</html>