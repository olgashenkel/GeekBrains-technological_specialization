<?php
namespace App\Core;

use App\Controllers\ErrorController;

class Router {
    public function dispatch(string $uri): void {
        // Очищаем URI от GET-параметров (например, /user/save/?name=... -> /user/save/)
        $urlPath = parse_url($uri, PHP_URL_PATH);
        $urlPath = rtrim($urlPath, '/');

        // Роутинг для сохранения пользователя
        if ($urlPath === '/user/save') {
            $controller = new \App\Controllers\UserController();
            $controller->save();
            return;
        }

        // ДОБАВЛЯЕМ: Если пользователь зашел на главную страницу
                // Если пользователь зашел на главную страницу
        if ($urlPath === '' || $urlPath === '/') {
            $loader = new \Twig\Loader\FilesystemLoader(__DIR__ . '/../../templates');
            $twig = new \Twig\Environment($loader);
            
            // Читаем пользователей из файла
            $users = [];
            $storageFile = __DIR__ . '/../../birthdays.txt';
            
            if (file_exists($storageFile) && filesize($storageFile) > 0) {
                $lines = file($storageFile, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
                foreach ($lines as $line) {
                    $parts = explode(", ", $line);
                    if (count($parts) === 2) {
                        $users[] = [
                            'name' => htmlspecialchars($parts[0]),
                            'birthday' => htmlspecialchars($parts[1])
                        ];
                    }
                }
            }
            
            // Передаем массив $users в шаблон
            echo $twig->render('main.twig', [
                'currentTime' => time(),
                'users' => $users
            ]);
            return;
        }


        // Если контроллер не найден — вызываем ошибку 404 (Задание 4)
        $errorController = new ErrorController();
        $errorController->notFound("Запрошенный адрес '{$urlPath}' не зарегистрирован в системе.");
    }
}
