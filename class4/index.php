<?php
            if ($_COOKIE['wrlog'] == ''){
                $wrlog = true;
                setcookie('wrlog', 15, time() - 250, "/");
            }
            if ($_COOKIE['wrpas'] == ''){
                $wrpas = true;
                setcookie('wrpas', 15, time() - 250, "/");
            }
        ?>
<!DOCTYPE html>
<html lang="ru">
<head>
    
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/script.js"></script>
    <link rel="stylesheet" href="css/style.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
</head>
<body>
    <div class="container">
        <?php
            if ($_COOKIE['user'] == ''):
        ?>
        <form action="/php/proverka.php" method="post">
            <h1>Присоединись к нам</h1>
            <input type="text" class="form-control" name="name" placeholder="Введите имя"><br>
            <input type="text" class="form-control" name="surname" placeholder="Введите фамилию"><br>
            <input type="text" class="form-control" name="login" placeholder="Введите логин"><br>
            <?php
            if ($wrlog == true){
                echo("<p>Недопустимая длина логина (от 6 до 15)</p>");
            }
            ?>
            <input type="text" class="form-control" name="mail" placeholder="Введите почту"><br>
            <input type="text" class="form-control" name="password" placeholder="Введите пароль"><br>
            <?php
            if ($wrpas == true){
                echo("<p>Недопустимая длина пароля (от 6 до 32)</p>");
            }
            ?>
            <button type="submit" class="btn btn-outline-success">Зарегистрироваться</button>
            <h6> Уже являетесь зарегистрированным пользователем? <a href="log.php">Войдите на сайт</a>
        </form>
            <?php else:?>
                <p>Вы успешно авторизовались и можете использовать весь функционал сайта.<p>
                <p>Чтобы выйти нажмите <a href="php/exit.php">здесь</a><p>
        <?php endif;?>
    </div>
</body>
</html>