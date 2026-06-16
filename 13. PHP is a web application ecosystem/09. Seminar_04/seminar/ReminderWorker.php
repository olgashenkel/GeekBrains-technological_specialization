<?php
require_once __DIR__ . '/DbProvider.php';
require_once __DIR__ . '/TelegramService.php';

class ReminderWorker {
    private DbProvider $db;
    private TelegramService $tg;

    public function __construct(DbProvider $db, TelegramService $tg) {
        $this->db = $db;
        $this->tg = $tg;
    }

    public function run(): void {
        echo "[ВОРКЕР] Проверка задач из базы данных...\n";
        // Симуляция успешной работы с внедренными зависимостями
        $this->tg->send('999888777', 'Автоматическое напоминание через DI-контейнер!');
    }
}
