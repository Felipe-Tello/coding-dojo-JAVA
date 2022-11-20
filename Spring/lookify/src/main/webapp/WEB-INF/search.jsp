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
    <a href="/dashboard">Dashboard</a>
    <form action="/search">
        <input type="search" name="artist">
        <input type="submit" value="Search">
    </form>
    <h1>Song by artist: <c:out value="${artist}"/></h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Rating</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${searchword}" var="lookify">
            <tr>
                <td><a href="/song/${lookify.id}"><c:out value="${lookify.title}"/></a></td>
                <td><c:out value="${lookify.rating}"/></td>
                <td>
                    <form action="/song/${lookify.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete"></form>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>