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
    <a href="/dashboard">Dashboard</a>
    <h1>Title : <c:out value="${lookify.title}"/></h1>
    <h1>Artist : <c:out value="${lookify.artist}"/></h1>
    <h1>Rating (1-10) : <c:out value="${lookify.rating}"/></h1>
    <form action="/song/${lookify.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form>
</body>
</html>