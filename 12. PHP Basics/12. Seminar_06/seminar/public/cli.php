<?php
// public/cli.php

// 1. Подключаем зависимости
require_once __DIR__ . '/../vendor/autoload.php';

// 2. Инициализируем приложение
$config = require __DIR__ . '/../config/config.php';
$app = new \App\Core\Application($config);

// 3. Вызываем контроллер оплат для ID 42 напрямую
$controller = new \App\Controllers\UserController();
// $controller->payments(42);
$controller->spendingReport();