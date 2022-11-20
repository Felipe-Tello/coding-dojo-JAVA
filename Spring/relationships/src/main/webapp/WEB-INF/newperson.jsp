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
    <form:form action="/persons/new" method="post" modelAttribute="person">
    <input type="hidden" name="_method" value="post">
        <p>
            <form:label path="firstName">First Name</form:label>
            <form:errors path="firstName"/>
            <form:input path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name</form:label>
            <form:errors path="lastName"/>
            <form:input path="lastName"/>
        </p>   
        <input type="submit" value="Submit"/>
    </form:form>   
</body>
</html>