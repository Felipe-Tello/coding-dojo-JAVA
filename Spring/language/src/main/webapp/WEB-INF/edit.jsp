<%@ page isErrorPage="true" %>    
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
    <a href="/language">Return to dashboard</a> 
        <form action="/language/${language.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete">
        </form>  
    <form:form action="/language/${language.id}" method="post" modelAttribute="language">
        <input type="hidden" name="_method" value="put">
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
            <form:label path="version">Pages</form:label>
            <form:errors path="version"/>     
            <form:input type="version" path="version"/>
        </p>    
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>