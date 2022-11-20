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
    <h1><c:out value="${book.title}"/></h1>
    <p>Description: <c:out value="${book.description}"/></p>
    <p>Language: <c:out value="${book.language}"/></p>
    <p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
    <a href="/books/${book.id}/edit">Edit Book</a>
    <form action="/books/${book.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form>
    
</body>
</html>