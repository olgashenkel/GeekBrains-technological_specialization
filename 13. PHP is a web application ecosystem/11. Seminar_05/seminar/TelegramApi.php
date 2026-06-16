<?php
class TelegramApi {
    public function getMessages(): array {
        // Имитируем сетевой HTTP-запрос к Telegram
        return ['offset' => 1, 'result' => []];
    }
}
