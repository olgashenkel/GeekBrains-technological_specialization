<?php

namespace App\Core;

use PDO;

class Application
{
    private static ?Application $instance = null;
    private ?PDO $pdo = null;

    public function __construct()
    {
        self::$instance = $this;
        $this->initDatabase();
    }

    public static function getInstance(): Application
    {
        return self::$instance;
    }
    public function getPdo(): PDO
    {
        return $this->pdo;
    }

    private function initDatabase(): void
    {
        $this->pdo = new PDO('mysql:host=database;dbname=application1;charset=utf8', 'application_user', 'geekbrains123', [
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
            PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
        ]);

        $this->pdo->exec("CREATE TABLE IF NOT EXISTS users (
            id_user INT AUTO_INCREMENT PRIMARY KEY,
            user_name VARCHAR(45) NOT NULL,
            user_lastname VARCHAR(45) NOT NULL,
            user_birthday_timestamp INT NULL,
            login VARCHAR(45) NULL UNIQUE,
            password_hash VARCHAR(255) NULL,
            remember_token VARCHAR(64) NULL -- ДОБАВИЛИ ПОЛЕ ДЛЯ COOKIE ТОКЕНА
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");


        $check = $this->pdo->query("SELECT 1 FROM users WHERE login = 'admin'");
        if (!$check->fetchColumn()) {
            $hash = password_hash('geekbrains', PASSWORD_BCRYPT);
            $this->pdo->exec("INSERT INTO users (user_name, user_lastname, user_birthday_timestamp, login, password_hash) 
                              VALUES ('Иван', 'Администратор', 675820800, 'admin', '{$hash}');");
        }
    }

    public function run(): void
    {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }

        // ЗАДАНИЕ 4: Автоматический вход по Cookie, если сессия пуста
        if (!isset($_SESSION['user_name']) && isset($_COOKIE['remember_me'])) {
            $token = $_COOKIE['remember_me'];

            $stmt = $this->pdo->prepare("SELECT * FROM users WHERE remember_token = :token");
            $stmt->execute(['token' => $token]);
            $user = $stmt->fetch();

            if ($user) {
                // Автоматически восстанавливаем сессию
                $_SESSION['user_name'] = $user['user_name'];
            }
        }

        $router = new Router();
        $router->dispatch($_SERVER['REQUEST_URI'] ?? '/');
    }
}
