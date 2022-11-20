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
    <h1>New Question</h1>
    <form:form action="/questions/new" method="post" modelAttribute="question">
        <p>
            <form:label path="lorem">Question: </form:label>
            <form:errors path="lorem"/>
            <form:textarea path="lorem" name="descripcion" cols="30" rows="8"></form:textarea>
        </p>
        <p>
            <label for="tag">Tags: </label>
            <input id="tag" name="tag"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>