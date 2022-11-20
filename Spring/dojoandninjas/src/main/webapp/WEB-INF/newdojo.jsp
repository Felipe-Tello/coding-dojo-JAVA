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
    <form:form action="/dojos/new" method="post" modelAttribute="dojo">
    <input type="hidden" name="_method" value="post">
    <h1>New Dojo</h1>
        <p>
            <form:label path="name">Name: </form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p> 
        <input type="submit" value="Create"/>
    </form:form>       
</body>
</html>