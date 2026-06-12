<?php

echo "--- Проверка модулей PHP ---\n";

if (extension_loaded('mysqli')) {
    echo "Модуль mysqli успешно установлен и готов к работе!";
} else {
    echo "Ошибка: модуль mysqli НЕ найден.";
}
