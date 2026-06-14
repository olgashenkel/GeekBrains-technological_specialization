<?php
// config/config.php

return [
    'db' => [
        'dsn'  => 'mysql:host=database;dbname=application1;charset=utf8',
        'user' => 'application_user',
        'pass' => 'geekbrains123',
    ],
    'templates_dir' => dirname(__DIR__) . '/templates',
    
    // КРИТИЧЕСКИЙ ФЛАГ ИЗ ЗАДАНИЯ: Включение (true) / Выключение (false) логирования памяти в БД
    'memory_logging_enabled' => false
];
