<?php
namespace App\Models;

use App\Core\Application;

class User {
    public static function exists(int $id): bool {
        $stmt = Application::getInstance()->getPdo()->prepare("SELECT 1 FROM users WHERE id_user = :id");
        $stmt->execute(['id' => $id]);
        return (bool)$stmt->fetchColumn();
    }

    public static function getTotalPayments(int $id): float {
        // Вычисляем сумму оплат через SQL агрегацию SUM
        $stmt = Application::getInstance()->getPdo()->prepare("SELECT SUM(amount) FROM payments WHERE id_user = :id");
        $stmt->execute(['id' => $id]);
        $total = $stmt->fetchColumn();
        return $total ? (float)$total : 0.0;
    }

        /**
     * Задание 2: Получение списка пользователей и их суммарных трат
     */
    public static function getUsersSpendingReport(): array {
        $pdo = \App\Core\Application::getInstance()->getPdo();
        
        // Берём только имя u.user_name и сумму оплат, заменяя NULL на 0
        $sql = "SELECT u.id_user, u.user_name, COALESCE(SUM(p.amount), 0) AS total_spent 
                FROM users AS u 
                LEFT JOIN payments AS p ON u.id_user = p.id_user 
                GROUP BY u.id_user;";
                
        return $pdo->query($sql)->fetchAll();
    }

        /**
     * Задание 3: Поиск пользователей с составными именами (2 и более слов)
     */
    public static function getCompositeNames(): array {
        $pdo = \App\Core\Application::getInstance()->getPdo();
        
        $stmt = $pdo->prepare("SELECT id_user, user_name, user_lastname FROM users WHERE user_name LIKE :pattern");
        $stmt->execute(['pattern' => '% %']);
        
        return $stmt->fetchAll();
    }

}
