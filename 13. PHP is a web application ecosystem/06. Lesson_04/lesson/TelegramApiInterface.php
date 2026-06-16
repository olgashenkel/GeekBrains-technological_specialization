<?php
interface TelegramApiInterface {
    public function sendMessage(string $chatId, string $text): bool;
}
