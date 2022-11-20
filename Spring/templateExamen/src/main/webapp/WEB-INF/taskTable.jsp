<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/css/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
    <div class="container">
    <h1>Welcome: <c:out value="${userActual.name}"/></h1>
        <h4><a href="/logout">Logout</a></h4>
        <a href="/tasks/asc">Priority High-Low</a>
        <a href="/tasks/desc">Priority Low-High</a>
        <table class="table table-striped">
        <thead>
            <tr>
                <th>Task</th>
                <th>Creator</th>
                <th>Assignee</th>
                <th>Priority</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaT}" var="tarea">
            <tr>
                <td><a href="/tasks/${tarea.id}"><c:out value="${tarea.taskName}"/></a></td>
                <td><c:out value="${tarea.userCreator.name}"/></td>
                <td><c:out value="${tarea.userAssignee.name}"/></td>
                <td><c:out value="${tarea.priority}"/></td>
            </tr>
            </c:forEach>
        </tbody>
        </table>
        <a href="/tasks/new">Create a new task</a>
    </div>
</body>
</html>