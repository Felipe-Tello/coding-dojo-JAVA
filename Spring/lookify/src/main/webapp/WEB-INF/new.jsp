<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
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
    <form:form action="/songs/new" method="post" modelAttribute="lookify">
        <input type="hidden" name="_method" value="post">
        <p>
            <form:label path="title">Title</form:label>
            <form:errors path="title"/>
            <form:input path="title"/>
        </p>
        <p>
            <form:label path="artist">Artist</form:label>
            <form:errors path="artist"/>
            <form:input path="artist"/>
        </p>
        <p>
            <form:label path="rating"> Rating ( 1 - 10 )</form:label>
            <form:errors path="rating"/>
            <form:input type="number" min="1" max="10" path="rating"/>
        </p>    
        <input type="submit" value="Submit"/>
    </form:form>  
</body>
</html>