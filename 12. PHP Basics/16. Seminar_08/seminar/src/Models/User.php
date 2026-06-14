<?php
namespace App\Models;

use App\Core\Application;

class User {
    /**
     * Комплексная валидация данных формы
     */
    public static function validate(array $data): bool {
        // 1. Проверка на пустоту полей
        if (empty($data['name']) || empty($data['lastname']) || empty($data['birthday'])) {
            // Записываем предупреждение в журнал Monolog
            Application::$logger->warning("Пользователь отправил пустые поля формы.");
            throw new \Exception("Все поля формы обязательны для заполнения!");
        }

        // 2. Защита от XSS: Проверка на отсутствие HTML-тегов с помощью регулярного выражения
        if (preg_match('/<[^>]*>/', $data['name']) || preg_match('/<[^>]*>/', $data['lastname'])) {
            // Записываем критическую ошибку безопасности в журнал
            Application::$logger->error("Обнаружена XSS-атака! Попытка ввода HTML-тегов: " . json_encode($data));
            throw new \Exception("Ввод HTML-тегов (например, <script>) строго запрещен в целях безопасности!");
        }

        // 3. Проверка формата даты ДД-ММ-ГГГГ
        if (!preg_match('/^(\d{2}-\d{2}-\d{4})$/', $data['birthday'])) {
            throw new \Exception("Неверный формат даты. Используйте ДД-ММ-ГГГГ.");
        }

        // 4. Проверка CSRF токена безопасности для защиты от межсайтовой подделки запросов
        if (!isset($_SESSION['csrf_token']) || $_SESSION['csrf_token'] !== ($data['csrf_token'] ?? '')) {
            Application::$logger->error("Обнаружена CSRF-атака! Невалидный токен формы.");
            throw new \Exception("Ошибка безопасности: невалидный CSRF токен.");
        }

        return true;
    }

    /**
     * Валидация строгости пароля по ТЗ (lookahead регулярное выражение)
     */
    public static function validatePasswordStrength(string $password): bool {
        $pattern = '/^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[\W_])\S{8,16}$/';

        if (!preg_match($pattern, $password)) {
            throw new \Exception(
                "Пароль слишком простой! Требования: от 8 до 16 символов без пробелов, " .
                "минимум одна цифра, одна заглавная, одна строчная буква и один специальный символ (например: @, #, $, %, _)."
            );
        }

        return true;
    }
}
