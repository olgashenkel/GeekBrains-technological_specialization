<?php
namespace App\Core;

use PDO;
use Monolog\Logger;
use Monolog\Handler\StreamHandler;
use Monolog\Level;

class Application {
    private array $config;
    private static ?Application $instance = null;
    private ?PDO $pdo = null;
    public static Logger $logger;

    public function __construct() {
        self::$instance = $this;
        $this->config = require __DIR__ . '/../../config/config.php';
        
        // Настройка Monolog журнала
        self::$logger = new Logger('app_logger');
        self::$logger->pushHandler(new StreamHandler(__DIR__ . '/../../log/debug.log', Level::Debug));
        
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

        // 1. Таблица Пользователей
        $this->pdo->exec("CREATE TABLE IF NOT EXISTS users (
            id_user INT AUTO_INCREMENT PRIMARY KEY,
            user_name VARCHAR(45) NOT NULL,
            user_lastname VARCHAR(45) NOT NULL,
            user_birthday_timestamp INT NULL,
            login VARCHAR(45) NULL UNIQUE,
            password_hash VARCHAR(255) NULL,
            remember_token VARCHAR(64) NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        // Автодобавление Администратора
        $checkAdmin = $this->pdo->query("SELECT 1 FROM users WHERE login = 'admin'");
        if (!$checkAdmin->fetchColumn()) {
            $hash = password_hash('geekbrains', PASSWORD_BCRYPT);
            $this->pdo->exec("INSERT INTO users (user_name, user_lastname, user_birthday_timestamp, login, password_hash) 
                              VALUES ('Иван', 'Администратор', 675820800, 'admin', '{$hash}');");
        }

        // 2. Таблица Оплат (ДЗ по базам данных)
        $this->pdo->exec("CREATE TABLE IF NOT EXISTS payments (
            id_payment INT AUTO_INCREMENT PRIMARY KEY,
            id_user INT NOT NULL,
            amount DECIMAL(10, 2) NOT NULL,
            payment_date DATETIME NOT NULL,
            CONSTRAINT fk_payment_user FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        // Наполнение тестовыми копейками для Ивана (ID 1)
        $checkPayments = $this->pdo->query("SELECT 1 FROM payments WHERE id_user = 1");
        if (!$checkPayments->fetchColumn()) {
            $this->pdo->exec("INSERT INTO payments (id_user, amount, payment_date) VALUES 
                (1, 1500.50, '2026-06-10 10:30:00'),
                (1, 450.75,  '2026-06-12 14:15:00'),
                (1, 3100.00, '2026-06-14 09:00:00');");
        }

        // 3. Таблица Логов Производительности памяти страниц
        $this->pdo->exec("CREATE TABLE IF NOT EXISTS memory_logs (
            id_log INT AUTO_INCREMENT PRIMARY KEY,
            url_address VARCHAR(255) NOT NULL,
            memory_bytes INT NOT NULL,
            request_time DATETIME NOT NULL,
            client_info TEXT NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");
    }

    /**
     * Метод сохранения системных метрик памяти в СУБД
     */
    public function logMemory(string $url, int $memory, string $userAgent): void {
        if ($this->getConfig('memory_logging_enabled') !== true) return;
        $stmt = $this->pdo->prepare("INSERT INTO memory_logs (url_address, memory_bytes, request_time, client_info) VALUES (:url, :mem, NOW(), :client)");
        $stmt->execute(['url' => $url, 'mem' => $memory, 'client' => $userAgent]);
    }

    public function run(): void {
        if (session_status() === PHP_SESSION_NONE) { session_start(); }
        
        // Счетчик страниц сессии
        if (!isset($_SESSION['page_views'])) { $_SESSION['page_views'] = 1; } 
        else { $_SESSION['page_views']++; }

        // Долговечные Cookie автологина
        if (!isset($_SESSION['user_name']) && isset($_COOKIE['remember_me'])) {
            $stmt = $this->pdo->prepare("SELECT * FROM users WHERE remember_token = :t");
            $stmt->execute(['t' => $_COOKIE['remember_me']]);
            $user = $stmt->fetch();
            if ($user) { $_SESSION['user_name'] = $user['user_name']; }
        }

        $router = new Router();
        $router->dispatch($_SERVER['REQUEST_URI'] ?? '/');
    }
}
