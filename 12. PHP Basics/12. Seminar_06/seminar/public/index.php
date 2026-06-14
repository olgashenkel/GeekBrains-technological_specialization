<?php
require_once __DIR__ . '/../vendor/autoload.php';
$config = require_once __DIR__ . '/../config/config.php';

$app = new \App\Core\Application($config);

// Если запуск осуществлен не из консоли — запускаем веб-маршрутизацию
if (php_sapi_name() !== 'cli') {
    $app->run();
}
