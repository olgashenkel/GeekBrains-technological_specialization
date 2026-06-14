<?php
namespace App\Core;

class Router {
    public function dispatch(string $uri): void {
        $urlPath = rtrim(parse_url($uri, PHP_URL_PATH), '/');

        if ($urlPath === '/user/payments') {
            $controller = new \App\Controllers\UserController();
            $controller->payments();
            return;
        }

        if ($urlPath === '' || $urlPath === '/') {
            echo "<h2>База данных успешно инициализирована!</h2>";
            echo "<p>Для вывода оплат перейдите по ссылке: <a href='/user/payments/?id=42'>Проверить оплаты пользователя 42</a></p>";
            return;
        }

                if ($urlPath === '/user/report') {
            $controller = new \App\Controllers\UserController();
            $controller->spendingReport();
            return;
        }

        if ($urlPath === '/user/search') {
            $controller = new \App\Controllers\UserController();
            $controller->searchCompositeNames();
            return;
        }


        header($_SERVER["SERVER_PROTOCOL"] . " 404 Not Found");
        echo "<h1>Ошибка 404. Страница не найдена.</h1>";
    }


}
