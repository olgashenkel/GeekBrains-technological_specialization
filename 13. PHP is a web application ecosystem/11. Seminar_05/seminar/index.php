<?php
require_once __DIR__ . '/vendor/autoload.php';
require_once __DIR__ . '/RedisCacheAdapter.php';

$cache = new RedisCacheAdapter();

echo "=== Тестирование кэширования в Redis ===\n";

// 1. Пытаемся взять данные по тяжелому запросу
$cacheKey = 'user_999_data';
$userData = $cache->get($cacheKey);

if ($userData === null) {
    echo "[ПРОМАХ КЭША] Имитируем тяжелый запрос к базе данных...\n";
    $userData = ['id' => 999, 'name' => 'Игорь', 'role' => 'admin'];
    
    // Сохраняем в кэш на 30 секунд
    $cache->set($cacheKey, $userData, 30);
} else {
    echo "[ХИТ КЭША] Данные мгновенно извлечены из оперативной памяти Redis!\n";
}

print_or_dump($userData);

function print_or_dump($data) {
    echo "Данные пользователя: " . $data['name'] . " (" . $data['role'] . ")\n";
}
