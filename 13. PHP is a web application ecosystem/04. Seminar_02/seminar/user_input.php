<?php
require_once __DIR__ . '/TelegramApi.php';

$options = getopt("t:", ["text:"]);
$text = $options['t'] ?? $options['text'] ?? null;

if (!$text) {
    die("Ошибка: Укажите текст сообщения. Пример: php user_input.php -t '/start'\n");
}

$env = parse_ini_file(__DIR__ . '/.env');
$myId = $env['MY_TELEGRAM_ID'] ?? '123456';

$tg = new TelegramApi();
$tg->simulateUserMessage($myId, 'Игорь', $text);

echo "[ЭМУЛЯТОР ЮЗЕРА] Вы отправили в чат бота фразу: \"{$text}\"\n";
