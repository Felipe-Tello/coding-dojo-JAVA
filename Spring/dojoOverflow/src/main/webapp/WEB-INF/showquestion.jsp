<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/Css/eventTable.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
    <h1><c:out value="${question.lorem}"/></h1>
    <tbody>
        <c:forEach items="${tags}" var="loo">
        <tr>
            <td><c:out value="${loo.subject}"/></td>
        </tr>
        </c:forEach>
    </tbody>
    <h3>Answers</h3>
    <ul>
        <c:forEach items="${question.answers}" var="ca">
            <li><c:out value="${ca.answerLorem}"></c:out></li>
        </c:forEach>
    </ul>
    <h1>Add your answer</h1>
    <form:form action="" method="post" modelAttribute="answer">
        <p>
            <form:label path="answerLorem">Answer: </form:label>
            <form:errors path="answerLorem"/>
            <form:textarea path="answerLorem" name="descripcion" cols="30" rows="8"></form:textarea>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>