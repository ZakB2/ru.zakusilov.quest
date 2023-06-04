<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Introduction</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<section>
    <div id="titles">
        <div id="titlecontent">
            <p>Ты стоишь в космическом порту и готов подняться на борт своего корабля USS Enterprise (NCC-1701).
                Разве ты не об этом мечтал: стать капитаном галактического судна с экипажем, который будет
                совершать подвиги под твоим командованием?</p>
            <p>Космос. Последний рубеж…</p>
        </div>
    </div>
    <div id="buttonNext">
        <script>
            document.addEventListener("DOMContentLoaded", () => {
                setTimeout(() => {
                    document.getElementById("buttonNext").innerHTML
                        = '<a href="2ndPage.jsp">Далее</a>';
                }, 17000);
            });
        </script>
    </div>
</section>
</body>
</html>