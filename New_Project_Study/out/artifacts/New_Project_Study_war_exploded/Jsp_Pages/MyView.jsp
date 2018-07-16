<%@ page import="jsp.Person" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.07.2018
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--эти штуки называются expression.Как видишь,юзать их намного удобнее,чем обычные вызовы бинов.--%>
    <%--Также они могут получать доступ к скоупам request,session,application--%>
    <%--Аналогично ебошишь все логические операторы,арифметику,короче все,что угодно--%>
    <%--Можно также прямо в параметр бина (в value)--%>
    <%--Expression также имеет доступ к cookies--%>
    ${cookie.JSESSIONID}
    <br>
    ${list.toString()}
    <br>
    ${list[0]}
    <br>
    ${requestScope.person.name}
    <br>
    ${requestScope.get("person").name}
    <br>
    ${person.name}
    <br>
    ${person["age"]}
    <%--Я не совсем понимаю, как оно получает доступ к приватным полям,но походу из-за импорта такое возмсжно--%>
    <br>
    ${person.getName()}
    ${person.getAge()}
    <br>
    <%--Если собрался делать через jsp, то обязательно предварительно объяви useBean--%>
    <jsp:useBean id="person" class = "jsp.Person" scope = "request"></jsp:useBean>
    <%-- отсюда уже выгребаем все,что мы запихнули в контроллере--%>
    <%= ((Person)request.getAttribute("person")).getName()%>
    <%= ((Person)request.getAttribute("person")).getAge()%>
    <jsp:getProperty name="person" property="name"/>

</body>
</html>
