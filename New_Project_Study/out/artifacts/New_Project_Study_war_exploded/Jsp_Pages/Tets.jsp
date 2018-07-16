<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.07.2018
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${requestScope.size()}
${Arrays.toString(requestScope.values().toArray())}
<h1>No</h1>
${Arrays.toString(requestScope.keySet().toArray())}
${mySecondBeanExpression.getS()}
${newName.s}
${newName.getS()}
</body>
</html>
