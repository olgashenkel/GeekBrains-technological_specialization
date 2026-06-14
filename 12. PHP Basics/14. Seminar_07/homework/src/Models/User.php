<?php
namespace App\Models;

class User {
    public static function validate(array $data): bool {
        if (empty($data['name']) || empty($data['lastname']) || empty($data['birthday'])) {
            throw new \Exception("Все поля формы обязательны для заполнения.");
        }

        // Задание 1: Проверка на отсутствие HTML-тегов с помощью регулярных выражений
        if (preg_match('/<[^>]*>/', $data['name']) || preg_match('/<[^>]*>/', $data['lastname'])) {
            throw new \Exception("Ввод HTML-тегов (например, <script>) строго запрещен в целях безопасности!");
        }

        // Проверка формата даты ДД-ММ-ГГГГ
        if (!preg_match('/^(\d{2}-\d{2}-\d{4})$/', $data['birthday'])) {
            throw new \Exception("Неверный формат даты. Используйте ДД-ММ-ГГГГ.");
        }

        // Проверка CSRF токена безопасности
        if (!isset($_SESSION['csrf_token']) || $_SESSION['csrf_token'] !== ($data['csrf_token'] ?? '')) {
            throw new \Exception("Ошибка безопасности: невалидный CSRF токен.");
        }

        return true;
    }
}
