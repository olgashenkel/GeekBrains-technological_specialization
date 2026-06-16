<?php
require_once __DIR__ . '/Container.php';
require_once __DIR__ . '/DbProvider.php';
require_once __DIR__ . '/TelegramService.php';
require_once __DIR__ . '/ReminderWorker.php';

// 1. Инициализируем наш DI-контейнер
$container = new Container();

// 2. Регистрируем правила сборки компонентов
$container->set(DbProvider::class, function() {
    return new DbProvider();
});

$container->set(TelegramService::class, function() {
    return new TelegramService();
});

// 3. Автоматическая сборка сложной зависимости:
// Контейнер сам залезет внутрь себя, вытащит DbProvider, вытащит TelegramService и передаст их в ReminderWorker!
$container->set(ReminderWorker::class, function(Container $c) {
    return new ReminderWorker(
        $c->get(DbProvider::class),
        $c->get(TelegramService::class)
    );
});

// === ТЕСТИРОВАНИЕ И ПРОВЕРКА ДЗ ===

echo "=== Проверка работы DI ===\n";
// Извлекаем полностью готовый и собранный воркер одной командой
$worker = $container->get(ReminderWorker::class);
$worker->run();

echo "\n=== Проверка домашнего задания (Singleton) ===\n";
// Запрашиваем подключение к базе данных два раза подряд
$db1 = $container->get(DbProvider::class);
$db2 = $container->get(DbProvider::class);

// Проверяем, ссылаются ли переменные на один и тот же объект в памяти
if ($db1 === $db2) {
    echo "[УСПЕХ ДЗ] Паттерн Синглтон работает! Контейнер выдал один и тот же экземпляр DbProvider в памяти.\n";
} else {
    echo "[ОШИБКА] Контейнер создал два разных объекта подключения.\n";
}
