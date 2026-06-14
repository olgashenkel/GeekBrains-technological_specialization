<?php
namespace App\Models;

use App\Core\Application;

class User {
    public static function exists(int $id): bool {
        $stmt = Application::getInstance()->getPdo()->prepare("SELECT 1 FROM users WHERE id_user = :id");
        $stmt->execute(['id' => $id]);
        return (bool)$stmt->fetchColumn();
    }

    public static function updateName(int $id, string $newName): void {
        $stmt = Application::getInstance()->getPdo()->prepare("UPDATE users SET user_name = :name WHERE id_user = :id");
        $stmt->execute(['name' => $newName, 'id' => $id]);
    }

    public static function deleteById(int $id): void {
        $stmt = Application::getInstance()->getPdo()->prepare("DELETE FROM users WHERE id_user = :id");
        $stmt->execute(['id' => $id]);
    }
}
