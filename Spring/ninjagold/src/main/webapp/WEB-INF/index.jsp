<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="places" method="post">
    <h1><c:out value="${oro}"/></h1>
    <label for="farm"> entre 5 y 10 de oro </label>
    <button name="places" value="farm">farm</button>
    <br>
    <label for="cave"> entre 5 y 10 de oro </label>
    <button name="places" value="cave">cave</button>
    <br>
    <label for="house"> entre 5 y 10 de oro </label>
    <button name="places" value="house">house</button>
    <br>
    <label for="casino"> entre 5 y 10 de oro </label>
    <button name="places" value="casino">casino</button>
    </form>
    <textarea cols="80" rows="10">
        <c:out value="${historial}"/>
    </textarea>
</body>
</html>