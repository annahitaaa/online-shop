<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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


<form:form action="/product/save" method="post" modelAttribute="dto">
    Name: <form:input path="name"></form:input><br/><br/>
    Price: <form:input path="price"></form:input><br/><br/>
    Type: <form:select path="type">
          <form:options items="${dto.validTypes}"></form:options>
            </form:select>
    <input type="submit" value="add product"/>
</form:form>

</body>
</html>
