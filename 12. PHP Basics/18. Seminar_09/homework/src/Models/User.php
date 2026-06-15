<?php
namespace App\Models;

use App\Core\Application;

class User {
    public static function validate(array $data): bool {
        if (empty($data['name']) || empty($data['lastname']) || empty($data['birthday']) || empty($data['login'])) {
            Application::$logger->warning("Пользователь отправил пустые поля формы.");
            throw new \Exception("Все поля формы обязательны для заполнения.");
        }
        // Anti-XSS регулярное выражение
        if (preg_match('/<[^>]*>/', $data['name']) || preg_match('/<[^>]*>/', $data['lastname'])) {
            Application::$logger->error("Обнаружена XSS-атака через форму: " . json_encode($data));
            throw new \Exception("Ввод HTML-тегов строго запрещен!");
        }
        if (!preg_match('/^(\d{2}-\d{2}-\d{4})$/', $data['birthday'])) {
            throw new \Exception("Формат даты должен быть ДД-ММ-ГГГГ.");
        }
        if (!isset($_SESSION['csrf_token']) || $_SESSION['csrf_token'] !== ($data['csrf_token'] ?? '')) {
            throw new \Exception("Ошибка безопасности: невалидный CSRF токен.");
        }
        return true;
    }

    public static function validatePasswordStrength(string $password): void {
        $pattern = '/^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[\W_])\S{8,16}$/';
        if (!preg_match($pattern, $password)) {
            throw new \Exception("Пароль слишком простой! Нужна 1 цифра, 1 заглавная, 1 строчная, 1 спецсимвол, длина 8-16.");
        }
    }

    /**
     * Агрегатный SQL подсчет суммы оплат пользователя с копейками (ДЗ)
     */
    public static function getTotalPayments(int $id): float {
        $stmt = Application::getInstance()->getPdo()->prepare("SELECT SUM(amount) FROM payments WHERE id_user = :id");
        $stmt->execute(['id' => $id]);
        $total = $stmt->fetchColumn();
        return $total ? (float)$total : 0.0;
    }
}
