<?php
// Подключаем автозагрузку Composer
require_once __DIR__ . '/../vendor/autoload.php';

// ПОДКЛЮЧАЕМ КОНФИГУРАЦИЮ
require_once __DIR__ . '/../config/config.php';

use App\Core\Router;

$router = new Router();
$router->dispatch($_SERVER['REQUEST_URI']);
