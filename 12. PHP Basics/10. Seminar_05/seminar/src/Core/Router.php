<?php
namespace App\Core;

class Router {
    public function dispatch(string $uri): void {
        $urlPath = parse_url($uri, PHP_URL_PATH);
        $urlPath = rtrim($urlPath, '/');

        if ($urlPath === '/site/info') {
            $controller = new \App\Controllers\SiteController();
            $controller->info();
            return;
        }

        if ($urlPath === '' || $urlPath === '/') {
            echo "<h2>Добро пожаловать!</h2><p>Перейдите на маршрут <a href='/site/info/'>/site/info/</a> для просмотра сборки.</p>";
            return;
        }

        header($_SERVER["SERVER_PROTOCOL"] . " 404 Not Found");
        echo "<h1>Ошибка 404. Страница не найдена.</h1>";
    }
}
