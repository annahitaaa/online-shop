<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a.aalipour
  Date: 11/12/2024
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product list</title>
</head>
<body>

<table style="border: black 1px solid">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Detail</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${list}" var="productDTO">
        <tr>
            <td>${productDTO.name}</td>
            <td>${productDTO.price}</td>
<%--            <td><a href="/product/detail?id=${productDTO.id}"><img style="width:25px; height: 25px" src="/resource/img/product-detail.png"/></a></td>--%>
            <td><a href="/product/detail/${productDTO.id}"><img style="width:25px; height: 25px" src="/resource/img/product-detail.png"/></a></td>
            <td><a href="/product/delete?id=${productDTO.id}"><img style="width:25px; height: 25px" src="/resource/img/delete.png"/></a></td>
            <td>E</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
