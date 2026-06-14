<?php
require_once __DIR__ . '/../vendor/autoload.php';

try {
    $app = new \App\Core\Application();
    $app->run();
} catch (\Throwable $e) {
    // В случае ошибки (например, XSS или CSRF атак) рендерим шаблон ошибки
    $loader = new \Twig\Loader\FilesystemLoader(__DIR__ . '/../templates');
    $twig = new \Twig\Environment($loader);
    echo $twig->render('error.twig', ['message' => $e->getMessage()]);
}
