<%@ page import="ru.zakusilov.quest.User" %>
<%@ page import="ru.zakusilov.quest.resolvers.Resolver" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Quest</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div id="questionsText">
    <%
        User user = (User) session.getAttribute("user");
        Integer questionNumber = (Integer) session.getAttribute("questionNumber");
        Resolver resolver = (Resolver) session.getAttribute("resolver");
    %>
    <%=
        resolver.getQuestion()
    %>
</div>
<section>
    <a id="buttonYes" href="/quest_war/quest">Да</a>
    <a id="buttonNo" href="/quest_war/questResult">Нет</a>
    <div id="sessionText">
        <p>Имя пользователя: <%=user.getName() %></p>
        <p>ID пользователя: <%=user.getId() %></p>
        <p>Вопрос квест: № <%=questionNumber %></p>
    </div>
</section>
</body>
</html>