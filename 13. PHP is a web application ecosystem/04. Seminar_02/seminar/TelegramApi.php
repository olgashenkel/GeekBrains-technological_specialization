<?php

class TelegramApi {
    private string $mockFile;

    public function __construct() {
        $this->mockFile = __DIR__ . '/TelegramMockServer.json';
        if (!file_exists($this->mockFile)) {
            file_put_contents($this->mockFile, json_encode(["updates" => [], "sent_messages" => []]));
        }
    }

    // Симуляция отправки сообщения (Задание 2)
    public function sendMessage(string $chatId, string $text): bool {
        $serverData = json_decode(file_get_contents($this->mockFile), true);
        
        $serverData['sent_messages'][] = [
            'chat_id' => $chatId,
            'text' => $text,
            'timestamp' => date('Y-m-d H:i:s')
        ];
        
        file_put_contents($this->mockFile, json_encode($serverData, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE));
        
        echo "[MOCK TELEGRAM API] Отправлено пользователю {$chatId}: \"{$text}\"\n";
        return true;
    }

    // Симуляция получения обновлений (Задание 3)
    public function getMessages(int $offset = 0): array {
        $serverData = json_decode(file_get_contents($this->mockFile), true);
        
        $result = [];
        foreach ($serverData['updates'] as $update) {
            if ($update['update_id'] >= $offset) {
                $result[] = $update;
            }
        }
        return $result;
    }

    // Метод для симуляции действий пользователя (ввод текста в чат)
    public function simulateUserMessage(string $chatId, string $username, string $text): void {
        $serverData = json_decode(file_get_contents($this->mockFile), true);
        $lastUpdateId = count($serverData['updates']) > 0 ? end($serverData['updates'])['update_id'] : 100000;
        
        $serverData['updates'][] = [
            'update_id' => $lastUpdateId + 1,
            'message' => [
                'chat' => ['id' => $chatId],
                'from' => ['first_name' => $username],
                'text' => $text
            ]
        ];
        file_put_contents($this->mockFile, json_encode($serverData, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE));
    }
}
