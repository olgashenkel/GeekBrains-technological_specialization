<?php
// Замеряем память на старте (стр. 11 методички)
$memory_start = memory_get_usage();

require_once __DIR__ . '/../vendor/autoload.php';

try {
    $app = new \App\Core\Application();
    $app->run();
} catch (\Throwable $e) {
    // В случае ошибок рендерим аварийный шаблон
    $loader = new \Twig\Loader\FilesystemLoader(__DIR__ . '/../templates');
    $twig = new \Twig\Environment($loader);
    echo $twig->render('error.twig', ['message' => $e->getMessage()]);
}

// Замеряем память на финише и выводим разницу (стр. 11 методички)
$memory_end = memory_get_usage();
$total_memory = $memory_end - $memory_start;

// Выводим профилирование в виде аккуратной скрытой HTML-заметки в самом низу страницы
echo "<div style='text-align:center; font-family:monospace; color:#7f8c8d; padding:10px; font-size:12px;'>";
echo "⏱️ Профилирование производительности: скрипт потребил " . $total_memory . " байт памяти.";
echo "</div>";
