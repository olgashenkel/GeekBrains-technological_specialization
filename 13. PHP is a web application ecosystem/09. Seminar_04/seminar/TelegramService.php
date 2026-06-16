<?php

class TelegramService {
    public function send(string $receiver, string $text): void {
        // Симуляция отправки (наш mock из прошлых уроков)
        echo "[MOCK TG] Сообщение ушло пользователю {$receiver}: \"{$text}\"\n";
    }
}
