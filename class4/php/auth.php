<?php
    header('Content-Type: text/html; charset=utf-8');
    $login = filter_var(trim($_POST['login']), FILTER_SANITIZE_STRING);
    $mail = filter_var(trim($_POST['mail']), FILTER_SANITIZE_STRING);
    $password = filter_var(trim($_POST['password']), FILTER_SANITIZE_STRING);

    $mysql = new mysqli('class4', 'root', '', 'base');
    $result = $mysql->query("SELECT * FROM `users` WHERE `login` = '$login' AND `password` = '$password'");
    $user = $result->fetch_assoc();
    if(count($user) == 0) {
        setcookie('wrong', 15, time() + 250, "/");
        header('location: ../log.php');
        exit;
    }
    setcookie('user', $user['name'], time() + 3600, "/");

    $mysql->close();

    header('location: /');

?>