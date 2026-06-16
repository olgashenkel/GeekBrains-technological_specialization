<?php
require_once __DIR__ . '/TelegramApiInterface.php';

class NotificationService {
    private TelegramApiInterface $tgApi;

    public function __construct(TelegramApiInterface $tgApi) {
        $this->tgApi = $tgApi;
    }

    public function notifyUserAboutDeadline(string $userId, string $taskName): string {
        $message = "Внимание! Дедлайн по задаче '{$taskName}' близко.";
        
        // Вызываем внешний метод. Если он успешен — возвращаем один статус, если нет — другой.
        $isSent = $this->tgApi->sendMessage($userId, $message);
        
        if (!$isSent) {
            throw new Exception("Не удалось доставить уведомление пользователю {$userId}");
        }

        return "Уведомление успешно обработано.";
    }
}
