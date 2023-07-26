<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Quest result</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div id="questionsText">
    <%=(String) session.getAttribute("result")%>
</div>
<section>
    <a id="buttonNext" href="/quest_war/restart">Перезапустить квест</a>
</section>
</body>
</html>