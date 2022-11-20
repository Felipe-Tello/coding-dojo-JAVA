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
    <h1><c:out value="${category.name}"/></h1>
    <!-- si el action esta vacion el postmapping va a la misma ruta donde se encuentra el usuario(tenemos el postmapping y getmapping en la misma ruta)(/products/${products.id}) -->
    <form action="" method="post">
        <select name="platillaProduct"> 
            <c:forEach items="${productos}" var="cates">
                <option value="${cates.id}">
                    <c:out value="${cates.name}"></c:out>
                </option>
            </c:forEach>
        </select>
        <input type="submit" value="Create"/>
    </form>
    <h4>Products:</h4>
    <ul>
        <c:forEach items="${category.products}" var="categoria">
            <li><c:out value="${categoria.name}"></c:out></li>
        </c:forEach>
    </ul>
</body>
</html>