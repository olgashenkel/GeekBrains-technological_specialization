<?php
declare(ticks = 1);

// Флаг работы демона
$running = true;

// По ТЗ: при сигналах сохраняем состояние, чтобы новый запуск его подхватил
function shutdownHandler($signal) {
    global $running;
    echo "\n[WORKER] Получен сигнал {$signal}. Сохраняем состояние времени и завершаем итерацию...\n";
    
    $state = [
        'minute' => date('i'),
        'hour'   => date('H'),
        'day'    => date('d'),
        'interrupted_at' => date('Y-m-d H:i:s')
    ];
    file_put_contents(__DIR__ . '/interrupted_state.json', json_encode($state));
    
    $running = false; 
}

pcntl_signal(SIGTERM, "shutdownHandler");
pcntl_signal(SIGINT, "shutdownHandler");
pcntl_signal(SIGHUP, "shutdownHandler");

echo "[WORKER] Демон успешно запущен под PID: " . getmypid() . "\n";

while ($running) {
    // Вызываем логику проверки событий из runner.php
    passthru('php "' . __DIR__ . '/runner.php" -c handle_events');
    
    // Спим до начала следующей минуты, чтобы не перегружать процессор
    sleep(60); 
}

echo "[WORKER] Демон безопасно остановлен.\n";
