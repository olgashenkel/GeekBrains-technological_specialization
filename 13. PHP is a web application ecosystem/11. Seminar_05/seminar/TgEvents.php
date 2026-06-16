<?php
require_once __DIR__ . '/TelegramApi.php';

class TgEvents {
    private TelegramApi $tgApi;

    public function __construct(TelegramApi $tgApi) {
        $this->tgApi = $tgApi;
    }

    public function handle(): bool {
        $response = $this->tgApi->getMessages();
        return isset($response['offset']);
    }
}
