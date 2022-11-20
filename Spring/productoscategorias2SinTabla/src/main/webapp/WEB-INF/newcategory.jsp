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
    <h1>New Category</h1>
    <form:form action="/categories/new" method="post" modelAttribute="categories">
        <p>
            <form:label path="name">Name: </form:label>
            <br>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <input type="submit" value="Create"/>
    </form:form>
</body>
</html>