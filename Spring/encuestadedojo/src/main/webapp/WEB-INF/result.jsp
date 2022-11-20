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
    <h1><u>Submitted Info</u></h1>
    <h1>Name:<c:out value="${name}"/></h1>
    <h1>Location:<c:out value="${location}"/></h1>
    <h1>Favorite Language:<c:out value="${favorite_language}"/></h1>
    <h1>Commment:<c:out value="${comment}"/></h1>
</body>
</html>