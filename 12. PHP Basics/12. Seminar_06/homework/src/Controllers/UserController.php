<?php
namespace App\Controllers;

use App\Models\User;

class UserController {
    public function update(): void {
        $id = isset($_GET['id']) ? (int)$_GET['id'] : 0;
        $name = $_GET['name'] ?? null;

        if ($id <= 0 || !$name) {
            throw new \Exception("Некорректные параметры запроса. Укажите ?id= и &name=");
        }
        if (!User::exists($id)) {
            throw new \Exception("Пользователь с ID {$id} отсутствует в базе данных.");
        }

        User::updateName($id, $name);
        echo "<h2>Пользователь с ID {$id} успешно переименован в '{$name}'.</h2>";
    }

    public function delete(): void {
        $id = isset($_GET['id']) ? (int)$_GET['id'] : 0;

        if ($id <= 0) {
            throw new \Exception("Некорректные параметры запроса. Укажите числовой ?id=");
        }
        if (!User::exists($id)) {
            throw new \Exception("Невозможно удалить пользователя. ID {$id} не найден.");
        }

        User::deleteById($id);
        echo "<h2>Пользователь с ID {$id} был успешно удален из базы данных.</h2>";
    }
}
