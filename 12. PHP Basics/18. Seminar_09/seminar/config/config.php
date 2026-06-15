<?php
return [
    'db' => [
        'dsn'  => 'mysql:host=database;dbname=application1;charset=utf8',
        'user' => 'application_user',
        'pass' => 'geekbrains123',
    ],
    'templates_dir' => dirname(__DIR__) . '/templates',
    // ТУМБЛЕР ПРОФИЛИРОВАНИЯ: true - писать логи памяти в БД, false - выключить
    'memory_logging_enabled' => true
];
