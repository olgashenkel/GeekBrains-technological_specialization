<?php
require_once __DIR__ . '/TelegramApi.php';

echo "[БОТ-ДЕМОН] Интерактивный опросник запущен... Нажмите Ctrl+C для остановки.\n";

$tg = new TelegramApi();
$db = new PDO('sqlite:' . __DIR__ . '/database.sqlite');

$offset = 0;
$userStates = []; // Память состояний конечного автомата (FSM)

while (true) {
    $updates = $tg->getMessages($offset);
    
    foreach ($updates as $update) {
        $offset = $update['update_id'] + 1;
        
        if (!isset($update['message'])) continue;
        
        $chatId = $update['message']['chat']['id'];
        $text = trim($update['message']['text'] ?? '');
        $username = $update['message']['from']['first_name'] ?? 'Пользователь';
        
        echo "[ЛОГ СЕРВЕРА] Получено сообщение от {$username} (ID: {$chatId}): \"{$text}\"\n";

        if ($text === '/start') {
            $userStates[$chatId] = ['step' => 1];
            $tg->sendMessage($chatId, "Укажите название события:");
            continue;
        }
        
        if (!isset($userStates[$chatId])) {
            $tg->sendMessage($chatId, "Для начала планирования введите команду /start");
            continue;
        }
        
        switch ($userStates[$chatId]['step']) {
            case 1:
                $userStates[$chatId]['name'] = $text;
                $userStates[$chatId]['step'] = 2;
                $tg->sendMessage($chatId, "Укажите ID пользователя (получателя):");
                break;
                
            case 2:
                $userStates[$chatId]['receiver'] = $text;
                $userStates[$chatId]['step'] = 3;
                $tg->sendMessage($chatId, "Укажите текст напоминания:");
                break;
                
            case 3:
                $userStates[$chatId]['text'] = $text;
                $userStates[$chatId]['step'] = 4;
                $tg->sendMessage($chatId, "Укажите cron-расписание (например, * * * * *):");
                break;
                
            case 4:
                // Записываем собранные шаги в базу данных SQLite
                $stmt = $db->prepare("INSERT INTO events (name, receiver, text, cron_rule) VALUES (:name, :receiver, :text, :cron)");
                $stmt->execute([
                    ':name'     => $userStates[$chatId]['name'],
                    ':receiver' => $userStates[$chatId]['receiver'],
                    ':text'     => $userStates[$chatId]['text'],
                    ':cron'     => $text
                ]);
                
                $tg->sendMessage($chatId, "Я записал Ваше событие. Для нового события введите /start");
                unset($userStates[$chatId]); // Очищаем сессию пользователя
                break;
        }
    }
    
    sleep(1); // Пауза итерации цикла
}
