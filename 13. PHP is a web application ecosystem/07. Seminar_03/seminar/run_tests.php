<?php
require_once __DIR__ . '/vendor/autoload.php';

// Новый стандарт инициализации консольного приложения PHPUnit
$application = new PHPUnit\TextUI\Application();
$application->run($_SERVER['argv']);
