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
    <p class="error"><form:errors path="task.*"/></p>
        <form:form method="POST" action="/tasks/${taskId}/edit" modelAttribute="taskEdit">
        <input type="hidden" name="_method" value="put">
            <p>
                <form:label path="taskName">Task</form:label>
                <form:input path="taskName"/>
            </p>
            <p>
                <form:label path="priority">Priority</form:label>
                <form:select path="priority"> 
                    <form:option value="3">High</form:option>
                    <form:option value="2">Medium</form:option>
                    <form:option value="1">Low</form:option>
                </form:select>
            </p>
            <p>
                <form:label path="userAssignee">Assignee</form:label>
                <form:select path="userAssignee"> 
                    <c:forEach items="${listaUsuarios}" var="cates">
                        <form:option value="${cates.id}">
                            <c:out value="${cates.name}"></c:out>
                        </form:option>
                    </c:forEach>
                </form:select>
            </p>
            <input class="btn btn-primary moveButton" type="submit" value="Create!"/>
        </form:form>
    </div>
</body>
</html>