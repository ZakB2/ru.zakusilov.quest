<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Greeting</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<section>
    <div id="textOnThe2ndPage">
        <h1>Знакомство с экипажем</h1>
        <p>Ты поднялся на борт корабля и сразу же отправился на капитанский мостик. Тебя приветствует
            девушка с чёрной папкой в руках:</p>
        <p>– Здравствуйте, капитан, я лейтенант Нийота Ухура, офицер связи и лингвист. Позвольте я
            представлю членов команды, находящихся на мостике. За тем столом Ваш старший помощник и офицер по науке Спок
            выполняет проверку экспедиционных заданий. Пилот-навигатор лейтенант Хикару Сулу и второй пилот-навигатор
            прапорщик Павел Чехов вычисляют координаты конечной точки перед варп-прыжком. Готовность основных систем
            корабля перед вылетом проверяет главный инженер лейтенант-коммандер Монтгомери Скотт. А там в углу пьёт кофе
            наш медик Леонард Маккой.</p>
        <p>А как обращаться к Вам? </p>
        <form action="quest", method="get">
            <label>
                <input type="text" name="name">
            </label>
        </form>
    </div>
    <div id="firstPerson">
        <img src="images/Нийота_Ухура.jpg" alt="Нийота_Ухура" style="width: 40%;height: 40%">
    </div>
    <div id="persons">
        <img src="images/Спок.jpg" alt="Спок" style="width: 15%;height: 15%">
        <img src="images/Хикару_Сулу.jpg" alt="Хикару_Сулу" style="width: 15%;height: 15%">
        <img src="images/Павел_Чехов.jpg" alt="Павел_Чехов" style="width: 15%;height: 15%">
        <img src="images/Монтгомери_Скотт.jpg" alt="Монтгомери_Скотт" style="width: 15%;height: 15%">
        <img src="images/Леонард_Маккой.jpg" alt="Леонард_Маккой" style="width: 15%;height: 15%">
    </div>
    <div id="buttonPrevious">
        <a href="introduction.jsp">Назад</a>
    </div>
</section>
</body>
</html>