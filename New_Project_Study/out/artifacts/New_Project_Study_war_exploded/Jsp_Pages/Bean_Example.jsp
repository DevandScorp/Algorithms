<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.07.2018
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--И тогда вопрос,а зачем bin? А у bin'a есть скоуп--%>
    <jsp:useBean id="person" class = "jsp.Person" /><%--Почему-то работает только так--%>
    <%--scope = "request".Эта штука будет давать тебе доступ к бину даже если ты переведешь--%>
    <%--scope = "session".Аналогично видимость для сессии bin--%>
    <%--scope = "applictaion".Самый мощный скоуп-для всего.--%>
    <%--Еще есть type.т.е. например ты можешь взять класс,унаследованный от Runnable в типе написать "java.lang.Runnable"--%>
    <%--А можешь не делать useBean в один тег,а сделать закрывающийся,и тогда все setter'ы просто внутри--%>
    <jsp:useBean id="person1" class = "jsp.Person">
        <jsp:setProperty name="person1" property="name" value="Max"/>
        <jsp:setProperty name="person1" property="age" value="16"/>
    </jsp:useBean>
    <%--По сути эти две записи аналогичны--%>
    <jsp:setProperty name="person" property="name" value="Artem"/>
    <jsp:setProperty name="person" property="age" value="17"/>
    <%--<% person1.setName("Max");%>--%>
    <%--<% person1.setAge(16);%>--%>
    <jsp:getProperty name="person" property="name"/>
    <%="<br>"%>
    <jsp:getProperty name="person" property="age"/>
    <%="<br>"%>
    <%= person1.getAge()%>
    <%= person1.getName()%>
    <h1>EE</h1>
    <br>

</body>
</html>
