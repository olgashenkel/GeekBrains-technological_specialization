<?php
namespace App\Controllers;

use App\Models\User;

class UserController {
    public function payments(?int $cliId = null): void {
        $id = $cliId ?? (isset($_GET['id']) ? (int)$_GET['id'] : 42);
        $isCli = (php_sapi_name() === 'cli');

        if ($id <= 0) {
            echo "Ошибка: Неверный ID пользователя.\n";
            return;
        }

        if (!User::exists($id)) {
            echo "Ошибка: Пользователь с ID {$id} не найден.\n";
            return;
        }

        $totalSum = User::getTotalPayments($id);

        if ($isCli) {
            // Оформление вывода в консоль
            echo "\n=========================================\n";
            echo "💰 СУММА ОПЛАТ ПОЛЬЗОВАТЕЛЯ (ТЕРМИНАЛ CLI)\n";
            echo "=========================================\n";
            echo "Пользователь ID {$id} суммарно оплатил: {$totalSum} руб.\n\n";
        } else {
            // Оформление вывода в браузер на localhost
            echo "<div style='font-family: sans-serif; max-width: 500px; margin: 40px auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; background: #fafafa; box-shadow: 0 2px 5px rgba(0,0,0,0.05);'>";
            echo "<h3 style='color: #2c3e50; margin-top: 0;'>💰 Результат расчета оплат</h3>";
            echo "<p>Общая сумма оплат для пользователя <strong>ID {$id}</strong>:</p>";
            echo "<div style='font-size: 24px; font-weight: bold; color: #27ae60; background: #eef9f1; padding: 10px; border-radius: 3px; text-align: center;'>{$totalSum} руб.</div>";
            echo "</div>";
        }
    }


        /**
     * Контроллер Задания 2 (Отчет по JOIN)
     */
    public function spendingReport(): void {
        $report = \App\Models\User::getUsersSpendingReport();
        $isCli = (php_sapi_name() === 'cli');

        if ($isCli) {
            echo "\n=========================================\n";
            echo "📊 ФИНАНСОВЫЙ ОТЧЕТ ПО ВСЕМУ САЙТУ (JOIN)\n";
            echo "=========================================\n";
            foreach ($report as $row) {
                echo "ID {$row['id_user']} | {$row['user_name']} -> Потрачено: {$row['total_spent']} руб.\n";
            }
            echo "\n";
        } else {
            echo "<div style='font-family: sans-serif; max-width: 600px; margin: 30px auto; padding: 20px; background: white; border-radius: 6px; box-shadow: 0 4px 10px rgba(0,0,0,0.1);'>";
            echo "<h3>📊 Финансовый отчет по пользователям (LEFT JOIN)</h3><table border='1' cellpadding='10' style='border-collapse:collapse; width:100%; text-align:left;'>";
            echo "<tr style='background:#f4f6f9;'><th>ID</th><th>Имя</th><th>Всего трат</th></tr>";
            foreach ($report as $row) {
                echo "<tr><td>{$row['id_user']}</td><td>{$row['user_name']}</td><td><strong>{$row['total_spent']} руб.</strong></td></tr>";
            }
            echo "</table></div>";
        }
    }

    /**
     * Контроллер Задания 3 (Поиск LIKE)
     */
    public function searchCompositeNames(): void {
        $users = \App\Models\User::getCompositeNames();
        $isCli = (php_sapi_name() === 'cli');

        if ($isCli) {
            echo "\n=========================================\n";
            echo "🔍 ПОЛЬЗОВАТЕЛИ С ДВОЙНЫМИ ИМЕНАМИ (LIKE)\n";
            echo "=========================================\n";
            if (empty($users)) echo "Совпадений не найдено.\n";
            foreach ($users as $user) {
                echo "ID {$user['id_user']} | {$user['user_name']} {$user['user_lastname']}\n";
            }
            echo "\n";
        } else {
            echo "<div style='font-family: sans-serif; max-width: 600px; margin: 30px auto; padding: 20px; background: white; border-radius: 6px; box-shadow: 0 4px 10px rgba(0,0,0,0.1);'>";
            echo "<h3>🔍 Результаты поиска имен из 2+ слов (LIKE '% %')</h3><ul>";
            if (empty($users)) echo "<li>Пользователи с двойными именами отсутствуют.</li>";
            foreach ($users as $user) {
                echo "<li><strong>ID {$user['id_user']}:</strong> {$user['user_name']} {$user['user_lastname']}</li>";
            }
            echo "</ul></div>";
        }
    }

}
