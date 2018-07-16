<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.07.2018
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.Date" %>
<%--можно все это писать в одну строчку, а можно во много--%>
<%-- Дохерища настроек--%>
<%@ include file = "hello.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%--Ебать пиздец,смотри,что можно делать--%>
        <%--<jsp:include page="/temp" />--%>
        <%--При вызове сервлета он выполнится-->
        <%--это уже expression.Он должен возвращать String.тут уже =,а не ! --%>
        <%= "\nhello world\n" %>
        <%! int i =5; %>
        <%! private void doJob(){
        System.out.println("Hello");
        //типо так объявляются переменные и методы в jsp.Это задание аналогично тому же коду в классе сервлета.
        //этот код называется ddeclaration.
        }
        %>
        <%= new Date()%>
        <%--можно так же создавать классы,только без ! или = в тегах.
        Это будут внутренние классы,поэтому на них будут накладываться ограничения.Теги без ! и = называются скреплеты.
        А потом можешь в declaration создавать объект этого класса --%>
        <% if(10>5){ %>
        <b> Greater than 5</b>
        <% } %>
        <h1>Hello world</h1>
        <%--<jsp:forward page="hello.jsp"/>&lt;%&ndash;Переход на другую страницу.Немого отличается от redirect,т.к. тут ты ничего не--%>
        <%--отправляешь браузеру&ndash;%&gt;--%>

</body>
</html>
