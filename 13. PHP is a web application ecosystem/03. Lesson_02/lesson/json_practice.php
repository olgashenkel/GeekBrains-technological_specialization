<?php
// Исходный массив данных (структура взята из примера на стр. 12)
$data = [
    "name" => "Mr. Anderson",
    "age" => 33,
    "isStudent" => false,
    "bag" => ["laptop", "phone", "chocolate"],
    "wife" => null
];

// Сериализация: Превращаем PHP-массив в строку JSON
$jsonString = json_encode($data, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE);
echo "=== 1. Сериализованный JSON ===\n" . $jsonString . "\n\n";

// Десериализация: Превращаем строку JSON обратно в ассоциативный массив PHP
$decodedData = json_decode($jsonString, true);
echo "=== 2. Десериализованные данные (Чтение поля) ===\n";
echo "Имя: " . $decodedData['name'] . "\n";
echo "Предмет в сумке: " . $decodedData['bag'][0] . "\n";
