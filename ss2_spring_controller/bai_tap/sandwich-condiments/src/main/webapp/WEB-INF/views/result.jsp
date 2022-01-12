<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments:</h1>
<c:forEach items="${condiments}" var="condiment">
    <h2>${condiment}</h2>
</c:forEach>
</body>
</html>
