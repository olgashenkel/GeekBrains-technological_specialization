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

        /**
     * Валидация строгости пароля с помощью регулярного выражения
     */
    public static function validatePasswordStrength(string $password): bool {
        // Регулярное выражение, проверяющее все условия методички:
        // (?=.*[0-9])       - минимум 1 цифра
        // (?=.*[A-Z])       - минимум 1 заглавная буква (латиница)
        // (?=.*[a-z])       - минимум 1 строчная буква (латиница)
        // (?=.*[\W_])       - минимум 1 спецсимвол (знаки препинания, подчеркивания и т.д.)
        // \S{8,16}          - от 8 до 16 символов СТРОГО без пробелов (\S означает non-whitespace)
        $pattern = '/^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[\W_])\S{8,16}$/';

        if (!preg_match($pattern, $password)) {
            throw new \Exception(
                "Пароль не соответствует требованиям безопасности! " .
                "Он должен содержать от 8 до 16 символов без пробелов, " .
                "минимум одну цифру, одну заглавную и одну строчную букву, " .
                "а также минимум один специальный символ (например: @, #, $, %, _)."
            );
        }

        return true;
    }

}
