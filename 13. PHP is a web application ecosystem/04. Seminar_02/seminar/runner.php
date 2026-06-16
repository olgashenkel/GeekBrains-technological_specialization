<?php
// Инициализация базы данных SQLite
$db = new PDO('sqlite:' . __DIR__ . '/database.sqlite');
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$db->exec("CREATE TABLE IF NOT EXISTS events (
    id INTEGER PRIMARY KEY AUTOINCREMENT, 
    name TEXT, 
    receiver TEXT, 
    text TEXT, 
    cron_rule TEXT
)");

$options = getopt("c:", ["name:", "receiver:", "text:", "cron:"]);
$command = $options['c'] ?? null;

// Команда сохранения нового напоминания в базу через CLI
if ($command === 'save_event') {
    $stmt = $db->prepare("INSERT INTO events (name, receiver, text, cron_rule) VALUES (:name, :receiver, :text, :cron)");
    $stmt->execute([
        ':name' => $options['name'] ?? 'Без названия',
        ':receiver' => $options['receiver'] ?? '',
        ':text' => $options['text'] ?? '',
        ':cron' => $options['cron'] ?? '* * * * *'
    ]);
    echo "[БАЗА ДАННЫХ] Событие успешно сохранено в SQLite.\n";
}

// Команда обработки и отправки накопленных событий (Имитация работы crontab)
if ($command === 'handle_events') {
    require_once __DIR__ . '/EventSender.php';
    $sender = new EventSender();
    
    $stmt = $db->query("SELECT * FROM events");
    $events = $stmt->fetchAll(PDO::FETCH_ASSOC);
    
    if (empty($events)) {
        echo "[ПЛАНИРОВЩИК] В базе данных пока нет событий для отправки.\n";
    } else {
        foreach ($events as $event) {
            $sender->sendMessage($event['receiver'], $event['text']);
        }
    }
}
