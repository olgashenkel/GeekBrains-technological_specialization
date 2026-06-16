<?php
require_once __DIR__ . '/TelegramApi.php';

class EventSender {
    private TelegramApi $tg;

    public function __construct() {
        $this->tg = new TelegramApi();
    }

    public function sendMessage(string $receiver, string $message): void {
        $this->tg->sendMessage($receiver, $message);
    }
}
