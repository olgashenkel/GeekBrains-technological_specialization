<?php
namespace App\Actions;

use App\Queue\Queue;
use App\Queue\Queueable;

require_once __DIR__ . '/Queueable.php';

class EventSender implements Queueable
{
    private Queue $queue;
    private array $currentJobData = [];

    public function __construct(Queue $queue)
    {
        $this->queue = $queue;
    }

    // Сохранение параметров задачи в очередь (Слайд 23)
    public function toQueue(...$args): void
    {
        $jobData = [
            'receiver' => $args[0] ?? '',
            'text' => $args[1] ?? ''
        ];
        $this->queue->sendMessage($jobData);
    }

    // Реальное выполнение отправки (вызывается воркером из фона)
    public function handle(): void
    {
        if (!empty($this->currentJobData)) {
            echo "[TELEGRAM API] Фоновая отправка сообщения для {$this->currentJobData['receiver']}: \"{$this->currentJobData['text']}\"\n";
        }
    }

    public function setCurrentJobData(array $data): void
    {
        $this->currentJobData = $data;
    }
}
