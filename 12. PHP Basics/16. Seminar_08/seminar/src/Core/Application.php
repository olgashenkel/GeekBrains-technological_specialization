<?php
namespace App\Core;

use PDO;

class Application {
    private array $config; // Изменим на хранение конфига
    private static ?Application $instance = null;
    private ?PDO $pdo = null;

    public function __construct() {
        self::$instance = $this;
        // Загрузим конфиг внутрь ядра
        $this->config = require __DIR__ . '/../../config/config.php';
        $this->initDatabase();
    }

    public static function getInstance(): Application { return self::$instance; }
    public function getPdo(): PDO { return $this->pdo; }
    public function getConfig(string $key) { return $this->config[$key] ?? null; }

    private function initDatabase(): void {
        $dbConfig = $this->config['db'];
        $this->pdo = new PDO($dbConfig['dsn'], $dbConfig['user'], $dbConfig['pass'], [
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
            PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
        ]);

        // 1. Существующая таблица пользователей
        $this->pdo->exec("CREATE TABLE IF NOT EXISTS users (
            id_user INT AUTO_INCREMENT PRIMARY KEY,
            user_name VARCHAR(45) NOT NULL,
            user_lastname VARCHAR(45) NOT NULL,
            user_birthday_timestamp INT NULL,
            login VARCHAR(45) NULL UNIQUE,
            password_hash VARCHAR(255) NULL,
            remember_token VARCHAR(64) NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        // 2. СИСТЕМНОЕ ЗАДАНИЕ: Создание таблицы логирования памяти страницы
        $this->pdo->exec("CREATE TABLE IF NOT EXISTS memory_logs (
            id_log INT AUTO_INCREMENT PRIMARY KEY,
            url_address VARCHAR(255) NOT NULL,
            memory_bytes INT NOT NULL,
            request_time DATETIME NOT NULL,
            client_info TEXT NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");
    }

    /**
     * Метод безопасного сохранения лога производительности в БД
     */
    public function logMemory(string $url, int $memory, string $userAgent): void {
        // Проверяем флаг в настройках перед отправкой запроса (Задание, стр. 2)
        if ($this->getConfig('memory_logging_enabled') !== true) {
            return; 
        }

        $stmt = $this->pdo->prepare("INSERT INTO memory_logs (url_address, memory_bytes, request_time, client_info) VALUES (:url, :mem, NOW(), :client)");
        $stmt->execute([
            'url' => $url,
            'mem' => $memory,
            'client' => $userAgent
        ]);
    }

    public function run(): void {
        if (session_status() === PHP_SESSION_NONE) { session_start(); }
        $router = new Router();
        $router->dispatch($_SERVER['REQUEST_URI'] ?? '/');
    }
}
