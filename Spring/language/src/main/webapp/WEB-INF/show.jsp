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
    <a href="/language">Return to dashboard</a>
    <p>Name: <c:out value="${language.name}"/></p>
    <p>Creator: <c:out value="${language.creator}"/></p>
    <p>Version: <c:out value="${language.version}"/></p>
    <a href="/language/${language.id}/edit">Edit</a>
    <form action="/language/${language.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form>
    
</body>
</html>