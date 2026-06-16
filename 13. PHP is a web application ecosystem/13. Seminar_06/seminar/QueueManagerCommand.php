<?php
namespace App\Commands;

use App\Actions\EventSender;
use App\Queue\RabbitMQ;

require_once __DIR__ . '/RabbitMQ.php';
require_once __DIR__ . '/EventSender.php';

class QueueManagerCommand
{
    public function run(): void
    {
        echo "[WORKER] Демон очереди запущен и слушает задачи...\n";
        $queue = new RabbitMQ('eventSender');
        $sender = new EventSender($queue);

        while (true) {
            $messageBody = $queue->getMessage();

            if ($messageBody !== null) {
                echo "[WORKER] Найдена задача в очереди! Начинаем обработку...\n";
                $jobData = json_decode($messageBody, true);
                
                // Передаем данные в обработчик и запускаем его
                $sender->setCurrentJobData($jobData);
                $sender->handle();
                
                // Помечаем сообщение как выполненное
                $queue->ackLastMessage();
            }

            // Проверяем очередь раз в 3 секунды (на слайде 10 секунд для демонстрации)
            sleep(3);
        }
    }
}
