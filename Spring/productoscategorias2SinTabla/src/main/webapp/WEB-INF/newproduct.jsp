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
    <!-- <a href="http://localhost:8080/dojos/new">crear nuevo dojo</a> -->
    <h1>New Product</h1>
    <form:form action="/products/new" method="post" modelAttribute="product">
        <p>
            <form:label path="name">Name: </form:label>
            <br>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="description">Description: </form:label>
            <br>
            <form:errors path="description"/>
            <form:textarea path="description" name="descripcion" cols="30" rows="8"></form:textarea>
        </p>
        <p>
            <form:label path="price">Price: </form:label>
            <br>
            <form:errors path="price"/>
            <form:input path="price"/>
        </p>
        <input type="submit" value="Create"/>
    </form:form>
</body>
</html>