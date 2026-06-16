<?php
use PHPUnit\Framework\TestCase;

require_once __DIR__ . '/TgEvents.php';
require_once __DIR__ . '/TelegramApi.php';

class TgEventsTest extends TestCase {
    
    // Тест-кейс симуляции метода getMessages() со слайда 27
    public function testHandleCallGetMessages(): void {
        // Создаем Mock-заглушку для TelegramApi
        $telegramApiMock = $this->createMock(TelegramApi::class);
        
        // Настраиваем: метод getMessages должен вызваться ровно 1 раз и вернуть массив
        $telegramApiMock->expects($this->once())
            ->method('getMessages')
            ->willReturn(['offset' => 500, 'result' => []]);

        $tgEvents = new TgEvents($telegramApiMock);
        $result = $tgEvents->handle();

        static::assertTrue($result);
    }
}
