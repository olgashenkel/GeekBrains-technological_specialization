<?php
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

$memory_end = memory_get_usage();
$total_memory = $memory_end - $memory_start;

if ($app) {
    $app->logMemory($_SERVER['REQUEST_URI'] ?? '/', $total_memory, $_SERVER['HTTP_USER_AGENT'] ?? 'Unknown');
}

// Защита: Блокируем вывод HTML-текста профилировщика на любые асинхронные AJAX вызовы
if (strpos($_SERVER['REQUEST_URI'], 'delete-async') === false && strpos($_SERVER['REQUEST_URI'], 'user/time') === false) {
    echo "<div style='text-align:center; font-family:monospace; color:#7f8c8d; padding:10px; font-size:12px; background:#fafafa; border-top:1px solid #eee;'>";
    echo "📊 Профилирование производительности: адрес '" . htmlspecialchars($_SERVER['REQUEST_URI']) . "' потребил " . $total_memory . " байт памяти.";
    echo "</div>";
}

