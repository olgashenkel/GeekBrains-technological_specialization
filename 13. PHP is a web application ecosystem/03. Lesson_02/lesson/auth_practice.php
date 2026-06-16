<?php
// Имитируем глобальные серверные переменные для CLI-тестирования
$_SERVER['PHP_AUTH_USER'] = 'user';
$_SERVER['PHP_AUTH_PW'] = 'password';

$username = $_SERVER['PHP_AUTH_USER'] ?? null;
$password = $_SERVER['PHP_AUTH_PW'] ?? null;

// Проверка логина и пароля (По примеру со стр. 40)
if ($username === 'user' && $password === 'password') {
    echo json_encode([
        "status" => "success",
        "message" => "Доступ разрешен! Добро пожаловать в защищенный API."
    ]);
} else {
    echo "[ОШИБКА] 401 Unauthorized. Неверные учетные данные\n";
    exit;
}
