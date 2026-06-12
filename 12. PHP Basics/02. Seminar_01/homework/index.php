<?php
echo "--- Задание 2: Проверка сравнений ---\n";
$a = 5;
$b = '05';
var_dump($a == $b);
var_dump((int)'012345');
var_dump((float)123.0 === (int)123.0);
var_dump(0 == 'hello, world');

echo "\n--- Задание 4: Смена переменных местами ---\n";
$num1 = 1;
$num2 = 2;
echo "До: num1 = $num1, num2 = $num2\n";

// Математический алгоритм без третьей переменной
$num1 = $num1 + $num2; // 1 + 2 = 3
$num2 = $num1 - $num2; // 3 - 2 = 1 (в num2 записалось старое значение num1)
$num1 = $num1 - $num2; // 3 - 1 = 2 (в num1 записалось старое значение num2)

echo "После: num1 = $num1, num2 = $num2\n";

echo "\n--- Дополнительно: Проверка модуля mysqli ---\n";
echo "Модуль mysqli " . (extension_loaded('mysqli') ? "успешно установлен!" : "НЕ установлен.") . "\n";
