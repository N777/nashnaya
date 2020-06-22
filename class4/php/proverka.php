<?php
    header('Content-Type: text/html; charset=utf-8');
    $name = filter_var(trim($_POST['name']), FILTER_SANITIZE_STRING);
    $surname = filter_var(trim($_POST['surname']), FILTER_SANITIZE_STRING);
    $login = filter_var(trim($_POST['login']), FILTER_SANITIZE_STRING);
    $mail = filter_var(trim($_POST['mail']), FILTER_SANITIZE_STRING);
    $password = filter_var(trim($_POST['password']), FILTER_SANITIZE_STRING);

    
    if(mb_strlen($login) < 5 || mb_strlen($login) > 15) {
        setcookie('wrlog', 15, time() + 250, "/");
        header('location: /');
        exit();
    }
    else if(mb_strlen($password) < 5 || mb_strlen($password) > 32) {
        setcookie('wrpas', 15, time() + 250, "/");
        header('location: /');
        exit();
    }

    $mysql = new mysqli('class4', 'root', '', 'base');
    $mysql->query("INSERT INTO `users` (`name`, `surname`, `login`, `mail`, `password`) VALUES ('$name', '$surname', '$login', '$mail', '$password')");

    $mysql->close();

    header('location: /');

?>