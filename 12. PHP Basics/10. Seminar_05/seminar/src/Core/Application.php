<?php
namespace App\Core;

class Application {
    // Свойство для хранения конфигурации приложения
    private array $config;
    
    // Статическое свойство для реализации паттерна Singleton
    private static ?Application $instance = null;

    public function __construct(array $config) {
        $this->config = $config;
        self::$instance = $this; // Запоминаем инстанс приложения
    }

    // Статический метод для получения доступа к приложению из любой точки кода
    public static function getInstance(): Application {
        return self::$instance;
    }

    // Геттер для получения всей конфигурации или конкретного ключа
    public function getConfig(?string $key = null) {
        if ($key) {
            return $this->config[$key] ?? null;
        }
        return $this->config;
    }

    // Запуск приложения
    public function run(): void {
        $router = new Router();
        $router->dispatch($_SERVER['REQUEST_URI']);
    }
}
