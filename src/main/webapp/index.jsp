<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Start Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<section>
    <div id="textOnTheStartPage">
        Ты готов принять участие в самом сложном квесте в твоей жизни?
    </div>
    <div id="button">
        <script>
            document.addEventListener("DOMContentLoaded", () => {
                setTimeout(() => {
                    document.getElementById("button").innerHTML
                        = '<div id="buttonYes"><a href="introduction.jsp" class="c1">Да</a></div>' +
                        '<div id="buttonNo"><a href="introduction.jsp" class="c2">Нет</a></div>';
                }, 2500);
            });
        </script>
    </div>
</section>
</body>
</html>