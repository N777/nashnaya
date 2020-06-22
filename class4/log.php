<?php
            if ($_COOKIE['wrong'] != ''){
                $wrong = true;
                setcookie('wrong', 15, time() - 250, "/");

            }
        ?>
        <script>document.getElementById("Form").reset();</script>
<!DOCTYPE html>
<html lang="ru">
<head>
    
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/script.js"></script>
    <link rel="stylesheet" href="css/style.css">

    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вход</title>
</head>
<body>
    <div class="container">
        <form id="Form" action="php/auth.php" method="post">
            <h1>Зайди под своим именем</h1>
            <input type="text" class="form-control" name="login" placeholder="Введите логин"><br>
            <input type="password" class="form-control" name="password" placeholder="Введите пароль"><br>
            <button type="submit" class="btn btn-outline-success">Войти</button>
        </form>
        <?php
            if ($wrong == true){
                echo("<h1>Неправильный логин или пароль</h1>");
            }
        ?>
    </div>
    
</body>
</html>