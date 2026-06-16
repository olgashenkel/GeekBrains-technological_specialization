<?php
use PHPUnit\Framework\TestCase;

require_once __DIR__ . '/NotificationService.php';
require_once __DIR__ . '/TelegramApiInterface.php';

class NotificationServiceTest extends TestCase {
    
    // 1. Тестируем успешный сценарий отправки
    public function testNotifyUserSuccess(): void {
        // Создаем динамический Mock-клон интерфейса
        $tgMock = $this->createMock(TelegramApiInterface::class);
        
        // Настраиваем поведение заглушки: при вызове sendMessage ОНА ВСЕГДА должна вернуть true
        $tgMock->method('sendMessage')->willReturn(true);

        // Внедряем нашу заглушку в тестируемый сервис
        $service = new NotificationService($tgMock);
        $result = $service->notifyUserAboutDeadline('999', 'Сдать ДЗ');

        static::assertSame("Уведомление успешно обработано.", $result);
    }

    // 2. Тестируем негативный сценарий (когда API вернул ошибку)
    public function testNotifyUserFailureThrowsException(): void {
        $tgMock = $this->createMock(TelegramApiInterface::class);
        
        // Настраиваем поведение заглушки: в этот раз она вернет false (симуляция сбоя сети)
        $tgMock->method('sendMessage')->willReturn(false);

        $this->expectException(Exception::class);
        $this->expectExceptionMessage("Не удалось доставить уведомление пользователю 555");

        $service = new NotificationService($tgMock);
        // Этот вызов должен стриггерить исключение
        $service->notifyUserAboutDeadline('555', 'Пройти тест');
    }
}
