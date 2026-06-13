<?php
$address = 'birthdays.txt'; // Внутри контейнера FPM корень папки привязан к /var/www/html
$today = date('d-m');
?>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>База дней рождения</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f9; margin: 40px; color: #333; }
        h1 { color: #2c3e50; }
        table { width: 100%; border-collapse: collapse; background: white; box-shadow: 0 4px 6px rgba(0,0,0,0.1); border-radius: 8px; overflow: hidden; }
        th, td { padding: 12px 15px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background: #34495e; color: white; }
        tr:hover { background: #f1f2f6; }
        .birthday-today { background: #ffeaa7 !important; font-weight: bold; }
        .badge { background: #e74c3c; color: white; padding: 4px 8px; border-radius: 4px; font-size: 12px; }
    </style>
</head>
<body>

    <h1>🎂 Локальная база дней рождения</h1>
    <p>Сегодняшняя дата: <strong><?= date('d.m.Y'); ?></strong></p>

    <table>
        <thead>
            <tr>
                <th>Имя пользователя</th>
                <th>Дата рождения</th>
                <th>Статус</th>
            </tr>
        </thead>
        <tbody>
            <?php
            if (file_exists($address) && filesize($address) > 0) {
                $lines = file($address, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
                foreach ($lines as $line) {
                    $parts = explode(", ", $line);
                    if (count($parts) === 2) {
                        $name = htmlspecialchars($parts[0]);
                        $birthday = htmlspecialchars($parts[1]);
                        $birthdayMD = substr($birthday, 0, 5);

                        // Проверяем, сегодня ли день рождения
                        $isToday = ($birthdayMD === $today);
                        $rowClass = $isToday ? 'class="birthday-today"' : '';
                        
                        echo "<tr $rowClass>";
                        echo "<td>$name</td>";
                        echo "<td>$birthday</td>";
                        echo "<td>" . ($isToday ? "<span class='badge'>🎉 Сегодня праздник!</span>" : "Ожидание") . "</td>";
                        echo "</tr>";
                    }
                }
            } else {
                echo "<tr><td colspan='3'>База данных пуста или файл не найден.</td></tr>";
            }
            ?>
        </tbody>
    </table>

</body>
</html>
