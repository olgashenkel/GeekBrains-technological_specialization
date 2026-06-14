<?php
namespace App\Core;

use PDO;

class Application {
    private array $config;
    private static ?Application $instance = null;
    private ?PDO $pdo = null;

    public function __construct(array $config) {
        $this->config = $config;
        self::$instance = $this;
        $this->initDatabase();
    }

    public static function getInstance(): Application {
        return self::$instance;
    }

    public function getPdo(): PDO {
        return $this->pdo;
    }

    private function initDatabase(): void {
        $dbConfig = $this->config['db'];
        $this->pdo = new PDO($dbConfig['dsn'], $dbConfig['user'], $dbConfig['pass'], [
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
            PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
        ]);

        // 1. Создаем таблицу пользователей, если её нет
        $this->pdo->exec("CREATE TABLE IF NOT EXISTS users (
            id_user INT AUTO_INCREMENT PRIMARY KEY,
            user_name VARCHAR(45) NOT NULL,
            user_lastname VARCHAR(45) NOT NULL,
            user_birthday_timestamp INT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        // Проверяем и добавляем тестового пользователя ID 42
        $checkUser = $this->pdo->query("SELECT 1 FROM users WHERE id_user = 42");
        if (!$checkUser->fetchColumn()) {
            $this->pdo->exec("INSERT INTO users (id_user, user_name, user_lastname, user_birthday_timestamp) VALUES (42, 'Иван', 'Петров', 794102400);");
        }

        // Добавляем пользователя с двойным именем для проверки Задания 3
        $checkDoubleName = $this->pdo->query("SELECT 1 FROM users WHERE id_user = 77");
        if (!$checkDoubleName->fetchColumn()) {
            $this->pdo->exec("INSERT INTO users (id_user, user_name, user_lastname, user_birthday_timestamp) VALUES (77, 'Анна Мария', 'Шульц', 855102400);");
        }


        // 2. Создаем связанную таблицу ОПЛАТ с типом DECIMAL для копеек
        $this->pdo->exec("CREATE TABLE IF NOT EXISTS payments (
            id_payment INT AUTO_INCREMENT PRIMARY KEY,
            id_user INT NOT NULL,
            amount DECIMAL(10, 2) NOT NULL,
            payment_date DATETIME NOT NULL,
            CONSTRAINT fk_payment_user FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        // Заводим для пользователя несколько оплат, если записей еще нет
        $checkPayments = $this->pdo->query("SELECT 1 FROM payments WHERE id_user = 42");
        if (!$checkPayments->fetchColumn()) {
            $this->pdo->exec("INSERT INTO payments (id_user, amount, payment_date) VALUES 
                (42, 1500.50, '2026-06-10 10:30:00'),
                (42, 450.75,  '2026-06-12 14:15:00'),
                (42, 3100.00, '2026-06-14 09:00:00');");
        }
    }

    public function run(): void {
        $router = new Router();
        $router->dispatch($_SERVER['REQUEST_URI'] ?? '/');
    }
}
