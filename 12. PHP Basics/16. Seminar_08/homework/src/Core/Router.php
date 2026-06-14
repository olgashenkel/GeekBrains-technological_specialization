<?php
namespace App\Core;

class Router {
    public function dispatch(string $uri): void {
        $urlPath = rtrim(parse_url($uri, PHP_URL_PATH), '/');
        $controller = new \App\Controllers\UserController();

        if ($urlPath === '' || $urlPath === '/') { $controller->index(); return; }
        if ($urlPath === '/user/auth') { $controller->auth(); return; }
        if ($urlPath === '/user/login') { $controller->login(); return; }
        if ($urlPath === '/user/logout') { $controller->logout(); return; }
        if ($urlPath === '/user/save') { $controller->save(); return; }
        if ($urlPath === '/user/delete') { $controller->delete(); return; }

        // --- ЛОГИРОВАНИЕ НЕКОРРЕКТНОГО МАРШРУТА (стр. 9 методички) ---
        $logMessage = "Попытка вызова несуществующего адреса: " . $_SERVER['REQUEST_URI'] . " | IP: " . $_SERVER['REMOTE_ADDR'];
        Application::$logger->error($logMessage);

        throw new \Exception("Страница не найдена.");
    }
}
