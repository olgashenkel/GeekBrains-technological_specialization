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

    public function getConfig(string $key) {
        return $this->config[$key] ?? null;
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

        $this->pdo->exec("CREATE TABLE IF NOT EXISTS users (
            id_user INT AUTO_INCREMENT PRIMARY KEY,
            user_name VARCHAR(45) NOT NULL,
            user_lastname VARCHAR(45) NOT NULL,
            user_birthday_timestamp INT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        $check = $this->pdo->query("SELECT 1 FROM users WHERE id_user = 42");
        if (!$check->fetchColumn()) {
            $this->pdo->exec("INSERT INTO users (id_user, user_name, user_lastname, user_birthday_timestamp) 
                              VALUES (42, 'Иван', 'Петров', 794102400);");
        }
    }

    public function run(): void {
        $router = new Router();
        $router->dispatch($_SERVER['REQUEST_URI']);
    }
}
