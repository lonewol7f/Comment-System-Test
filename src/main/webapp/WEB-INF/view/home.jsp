<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  
  User: lonewol7f
  Date: 14/07/2021
  Time: 18:54
  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="display: flex; align-content: center;justify-content: center">
    <h1 style="font-family: 'Ubuntu Mono'">It's Working Baby</h1>
</div>
<hr>
<div>
    <p>User: <security:authentication property="principal.username"/></p>
</div>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>

</body>
</html>
