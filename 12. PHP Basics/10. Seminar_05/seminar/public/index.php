<?php
require_once __DIR__ . '/../vendor/autoload.php';

// 1. Считываем массив конфигурации из файла
$config = require_once __DIR__ . '/../config/config.php';

// 2. Инициализируем приложение, передавая настройки в конструктор
$app = new \App\Core\Application($config);

// 3. Запускаем приложение
$app->run();
