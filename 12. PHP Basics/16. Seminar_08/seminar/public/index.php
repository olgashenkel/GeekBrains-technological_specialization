<?php
// Фиксируем объём памяти на самом старте
$memory_start = memory_get_usage();

require_once __DIR__ . '/../vendor/autoload.php';

$app = null;

try {
    $app = new \App\Core\Application();
    $app->run();
} catch (\Throwable $e) {
    $loader = new \Twig\Loader\FilesystemLoader(__DIR__ . '/../templates');
    $twig = new \Twig\Environment($loader);
    echo $twig->render('error.twig', ['message' => $e->getMessage()]);
}

// Фиксируем память на выходе и вычисляем чистый расход страницы
$memory_end = memory_get_usage();
$total_memory_used = $memory_end - $memory_start;

// Собираем системные данные из $_SERVER для записи в БД
$urlAddress = $_SERVER['REQUEST_URI'] ?? '/';
$clientInfo = $_SERVER['HTTP_USER_AGENT'] ?? 'Unknown Client';

// Передаем собранные данные в систему хранения, если приложение успешно инициализировалось
if ($app) {
    $app->logMemory($urlAddress, $total_memory_used, $clientInfo);
}

// Профилирование для визуального контроля в браузере
echo "<div style='text-align:center; font-family:monospace; color:#7f8c8d; padding:10px; font-size:12px; background:#fafafa; border-top:1px solid #eee;'>";
echo "📊 Лог производительности: адрес '{$urlAddress}' потребил " . $total_memory_used . " байт памяти.";
echo "</div>";
