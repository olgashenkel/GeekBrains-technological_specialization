<?php
namespace App\Controllers;

use Twig\Environment;
use Twig\Loader\FilesystemLoader;

class UserController {
    private Environment $twig;
    private string $storageFile = __DIR__ . '/../../birthdays.txt';

    public function __construct() {
        $loader = new FilesystemLoader(__DIR__ . '/../../templates');
        $this->twig = new Environment($loader);
    }

    public function save(): void {
        // Получаем параметры из GET-запроса
        $name = $_GET['name'] ?? null;
        $birthday = $_GET['birthday'] ?? null;

        // Базовая валидация присутствия параметров
        if (!$name || !$birthday) {
            $error = new ErrorController();
            $error->notFound("Ошибка сохранения: Не переданы обязательные параметры 'name' или 'birthday'.");
        }

        // Формируем строку и сохраняем в файл (Задание 6)
        $userData = $name . ", " . $birthday . "\r\n";
        file_put_contents($this->storageFile, $userData, FILE_APPEND);

        // Рендерим успешный ответ
        echo $this->twig->render('user_saved.twig', [
            'name' => htmlspecialchars($name),
            'birthday' => htmlspecialchars($birthday),
            'currentTime' => time()
        ]);
    }
}
