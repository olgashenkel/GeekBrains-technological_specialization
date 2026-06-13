<?php
namespace App\Controllers;

use Twig\Environment;
use Twig\Loader\FilesystemLoader;

class ErrorController {
    private Environment $twig;

    public function __construct() {
        $loader = new FilesystemLoader(__DIR__ . '/../../templates');
        $this->twig = new Environment($loader);
    }

    public function notFound(string $message): void {
        // Устанавливаем HTTP-ответ 404 (Задание 5)
        header($_SERVER["SERVER_PROTOCOL"] . " 404 Not Found");
        
        echo $this->twig->render('error404.twig', [
            'errorMessage' => $message,
            'currentTime' => time() // Передаем время для сайдбара (Задание 3)
        ]);
        exit;
    }
}
