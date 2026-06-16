<?php
require_once __DIR__ . '/QueueManagerCommand.php';
require_once __DIR__ . '/RabbitMQ.php';
require_once __DIR__ . '/EventSender.php';

$options = getopt("c:", ["receiver:", "text:"]);
$command = $options['c'] ?? null;

// Сценарий А: Пользователь / Планировщик добавляет задачу в очередь
if ($command === 'push_event') {
    $queue = new App\Queue\RabbitMQ('eventSender');
    $sender = new App\Actions\EventSender($queue);
    
    $receiver = $options['receiver'] ?? '12345';
    $text = $options['text'] ?? 'Дефолтный дедлайн!';
    
    $sender->toQueue($receiver, $text);
}

// Сценарий Б: Запуск демона обработки из ТЗ (Слайд 24)
if ($command === 'queue_manager') {
    $manager = new App\Commands\QueueManagerCommand();
    $manager->run();
}
