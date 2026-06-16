<?php

class DbProvider {
    private PDO $pdo;

    public function __construct() {
        // Подключаемся к нашей SQLite базе данных
        $this->pdo = new PDO('sqlite:' . __DIR__ . '/database.sqlite');
        $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    }

    public function getPdo(): PDO {
        return $this->pdo;
    }
}
