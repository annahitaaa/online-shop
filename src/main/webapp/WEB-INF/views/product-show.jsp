<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: a.aalipour
  Date: 11/12/2024
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add product</title>
</head>
<body>

<%--<form action="/product/save" method="post">--%>
<%--    Name: <input name="name" type="text"/> <br/><br/>--%>
<%--    Price: <input name="price" type="text"/> <br/><br/>--%>
<%--    Type: <select>--%>
<%--    <option>${productDTO.validTypes[1]}</option>--%>
<%--</select>--%>
<%--    <input type="submit" value="add product"/>--%>
<%--</form>--%>
<h2> <mvc:message code="product.add"/></h2><br/><br/>

<a href="?lang=en">En</a>
<a href="?lang=fa">Fa</a>

<form:form action="/product/save" method="post" modelAttribute="dto">
    Name: <form:input path="name"></form:input><br/><br/>
    <form:errors path="name" cssStyle="color: red"></form:errors>
    <br/>
    Price: <form:input path="price"></form:input><br/><br/>

    <form:errors path="price" cssStyle="color: red"></form:errors>
    <br/>
    Type: <form:select path="type" cssStyle="width: fit-content">
            <form:option value="---Please Select One Item---"/>
          <form:options items="${dto.validTypes}"></form:options>
            </form:select>
    <br/>
    <br/>
    Color:
    Black <form:radiobutton path="color" value="black"/>
    Green <form:radiobutton path="color" value="green"/>
    Blue <form:radiobutton path="color" value="blue"/>
    <br/>
    <br/>
    sizes:
    XL: <form:checkbox path="sizes" value="4"/>
    L: <form:checkbox path="sizes" value="3"/>
    M: <form:checkbox path="sizes" value="2"/>
    S: <form:checkbox path="sizes" value="1"/>

    <input type="submit" value="add product"/>
</form:form>

</body>
</html>
