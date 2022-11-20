<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
   		<a href="/tasks">Volver al menu</a>
        <h1>Task: <c:out value="${taskuno.taskName}"></c:out></h1>
        <br>
        <h3>Creator: <c:out value="${taskuno.userCreator.name}"></c:out></h3>
        <h3>Assignee: <c:out value="${taskuno.userAssignee.name}"></c:out></h3>
        <h3>Priority: <c:out value="${taskuno.priority}"></c:out></h3>
        <p>	
            <c:if test="${actual.id == taskuno.userCreator.id}"><a href="/tasks/${taskuno.id}/edit">Editar Evento</a></c:if>
            <c:if test="${actual.id == taskuno.userCreator.id}">
            	<form action="/tasks/${taskuno.id}" method="post">
               	<input type="hidden" name="_method" value="delete">
               	<input type="submit" value="Delete"></form>
            </c:if>
            <c:if test="${actual.id == taskuno.userAssignee.id}">
            	<form action="/tasks/${taskuno.id}" method="post">
               	<input type="hidden" name="_method" value="delete">
               	<input type="submit" value="Complete"></form>
            </c:if>
        </p>
        
   </div>
</body>
</html>