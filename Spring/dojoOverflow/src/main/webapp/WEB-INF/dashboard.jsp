<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body class=container>
    <h1>Question Dashboard</h1>
    <table>
        <thead>
            <tr>
                <th>Questions</th>
                <th>Tags</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="loo" items="${questions}">
            <tr>
                <td><a href="/questions/${loo.id}"><c:out value="${loo.lorem}"/></a></td>
                <td>
                    <c:forEach var="tag" items="${loo.tags}">
                        <c:out value="${tag.subject}"/>
                    </c:forEach>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>