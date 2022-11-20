<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        img{
            width: 40px;
            height: 40px;
        }
    </style>
</head>
<body>
    <form action="" method="POST" enctype="multipart/form-data">
        <input type="file" name="cosa" id="">
        <input type="submit" value="">
    </form>
    <c:forEach items="${archivos}" var="archivo">
        <img src="/images/1/${archivo}" alt="">
    </c:forEach>
</body>
</html>