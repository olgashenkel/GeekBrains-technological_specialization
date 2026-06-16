<?php
namespace App\Queue;

require_once __DIR__ . '/Queue.php';

class RabbitMQ implements Queue
{
    private string $queueFile;
    private ?array $lastPolledMessage = null;

    public function __construct(string $queueName)
    {
        $this->queueFile = __DIR__ . "/queue_{$queueName}.json";
        if (!file_exists($this->queueFile)) {
            file_put_contents($this->queueFile, json_encode([]));
        }
    }

    public function sendMessage($message): void
    {
        $queue = json_decode(file_get_contents($this->queueFile), true);
        $queue[] = [
            'id' => uniqid('msg_', true),
            'body' => is_array($message) ? json_encode($message) : $message
        ];
        file_put_contents($this->queueFile, json_encode($queue, JSON_PRETTY_PRINT));
        echo "[ОЧЕРЕДЬ] Сообщение добавлено в брокер.\n";
    }

    public function getMessage(): ?string
    {
        $queue = json_decode(file_get_contents($this->queueFile), true);
        if (empty($queue)) {
            return null;
        }
        // Берем первый элемент из начала очереди (FIFO)
        $this->lastPolledMessage = array_shift($queue);
        file_put_contents($this->queueFile, json_encode($queue, JSON_PRETTY_PRINT));
        
        return $this->lastPolledMessage['body'];
    }

    public function ackLastMessage(): void
    {
        // Подтверждение прочтения — сообщение безопасно удаляется
        $this->lastPolledMessage = null;
        echo "[ОЧЕРЕДЬ] Подтверждение ACK успешно выполнено.\n";
    }
}
