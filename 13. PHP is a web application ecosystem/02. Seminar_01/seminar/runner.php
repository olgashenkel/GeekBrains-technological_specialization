<?php
// Настройка подключения к SQLite
$db = new PDO('sqlite:' . __DIR__ . '/database.sqlite');
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

// Создаем таблицу, если её нет
$db->exec("CREATE TABLE IF NOT EXISTS events (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    receiver TEXT,
    text TEXT,
    cron_rule TEXT
)");

// Получаем параметры командной строки по ТЗ
$options = getopt("c:", ["name:", "receiver:", "text:", "cron:"]);

if (isset($options['c']) && $options['c'] === 'save_event') {
    $name = $options['name'] ?? 'Без названия';
    $receiver = $options['receiver'] ?? '';
    $text = $options['text'] ?? '';
    $cron = $options['cron'] ?? '* * * * *';

    $stmt = $db->prepare("INSERT INTO events (name, receiver, text, cron_rule) VALUES (:name, :receiver, :text, :cron)");
    $stmt->execute([
        ':name' => $name,
        ':receiver' => $receiver,
        ':text' => $text,
        ':cron' => $cron
    ]);

    echo "[УСПЕХ] Событие '{$name}' успешно сохранено в SQLite.\n";
}

if (isset($options['c']) && $options['c'] === 'handle_events') {
    require_once __DIR__ . '/EventSender.php';
    $sender = new EventSender();

    // Берем текущие параметры времени
    $currentMinute = date('i');
    $currentHour   = date('H');
    $currentDay    = date('d');
    $currentMonth  = date('m');
    $currentWDay   = date('w'); // 0 (вс) - 6 (сб)

    $stmt = $db->query("SELECT * FROM events");
    $events = $stmt->fetchAll(PDO::FETCH_ASSOC);

    foreach ($events as $event) {
        // Простейший парсинг пяти звездочек '* * * * *'
        $cronParts = explode(' ', $event['cron_rule']);
        
        $match = true;
        if ($cronParts[0] !== '*' && (int)$cronParts[0] !== (int)$currentMinute) $match = false;
        if ($cronParts[1] !== '*' && (int)$cronParts[1] !== (int)$currentHour) $match = false;
        if ($cronParts[2] !== '*' && (int)$cronParts[2] !== (int)$currentDay) $match = false;
        if ($cronParts[3] !== '*' && (int)$cronParts[3] !== (int)$currentMonth) $match = false;
        if ($cronParts[4] !== '*' && (int)$cronParts[4] !== (int)$currentWDay) $match = false;

        if ($match) {
            $sender->sendMessage($event['receiver'], $event['text']);
        }
    }
}

if (isset($options['c']) && $options['c'] === 'handle_events_daemon') {
    require_once __DIR__ . '/EventSender.php';
    $sender = new EventSender();

    echo "[DAEMON] Демон запущен под управлением Supervisor.\n";

    // Бесконечный цикл — Supervisor будет следить за его выполнением
    while (true) {
        $currentMinute = date('i');
        $currentHour   = date('H');
        
        $stmt = $db->query("SELECT * FROM events");
        $events = $stmt->fetchAll(PDO::FETCH_ASSOC);

        foreach ($events as $event) {
            $cronParts = explode(' ', $event['cron_rule']);
            
            // Если правило совпадает (упрощенная проверка на каждую минуту '*')
            if ($cronParts[0] === '*') {
                $sender->sendMessage($event['receiver'], $event['text']);
            }
        }

        // Засыпаем на 60 секунд, чтобы цикл срабатывал раз в минуту
        sleep(60);
    }
}
