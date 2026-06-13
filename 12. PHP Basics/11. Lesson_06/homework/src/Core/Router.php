<?php

namespace App\Core;

class Router
{
    public function dispatch(string $uri): void
    {
        $urlPath = rtrim(parse_url($uri, PHP_URL_PATH), '/');
        $controller = new \App\Controllers\UserController();

        if ($urlPath === '/user/update') {
            $controller->update();
            return;
        }
        if ($urlPath === '/user/delete') {
            $controller->delete();
            return;
        }

        if ($urlPath === '' || $urlPath === '/') {
            echo "<h2>Добро пожаловать в систему управления БД!</h2><p>Для проверки работы перейдите по пути: <a href='/user/update/?id=42&name=Pavel'>/user/update</a></p>";
            return;
        }

        throw new \Exception("Запрошенный маршрут '{$urlPath}' не поддерживается системой.");
    }
}
