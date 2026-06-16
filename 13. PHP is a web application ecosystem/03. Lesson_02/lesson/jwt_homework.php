<?php
require 'vendor/autoload.php';

use Firebase\JWT\JWT;
use Firebase\JWT\Key;

// Секретный ключ сервера (Должен храниться в .env)
$secretKey = "super_secret_key_32_characters!!";
 

// 1. Имитируем генерацию токена для пользователя (Сериализация данных)
$payload = [
    "user_id" => 123,
    "username" => "geekbrains_student",
    "role" => "admin",
    "exp" => time() + 3600 // Токен сгорит через 1 час
];

$generatedToken = JWT::encode($payload, $secretKey, 'HS256');
echo "=== Сгенерированный JWT Токен ===\n" . $generatedToken . "\n\n";

// 2. Имитируем ПРОВЕРКУ (валидацию) токена при входящем запросе
$tokenToVerify = $generatedToken; // В реальности берется из заголовка Authorization Bearer

try {
    // Декодируем и проверяем подпись токена
    $decoded = JWT::decode($tokenToVerify, new Key($secretKey, 'HS256'));
    
    // Преобразуем объект в массив для удобства
    $userData = (array)$decoded;
    
    echo "=== [УСПЕХ] Токен успешно валидирован! ===\n";
    echo "ID Пользователя: " . $userData['user_id'] . "\n";
    echo "Роль в системе: " . $userData['role'] . "\n";

} catch (Exception $e) {
    echo "=== [ОШИБКА АУТЕНТИФИКАЦИИ] ===\n";
    echo "Причина: " . $e->getMessage() . "\n";
}
