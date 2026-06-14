<?php
require_once __DIR__ . '/../vendor/autoload.php';
require_once __DIR__ . '/../config/config.php';

try {
    $app = new \App\Core\Application(require __DIR__ . '/../config/config.php');
    $app->run();
} catch (\Throwable $e) {
    echo \App\Core\Render::renderExceptionPage($e);
}
