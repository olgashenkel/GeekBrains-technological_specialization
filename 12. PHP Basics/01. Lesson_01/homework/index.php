<?php
echo "--- Задание 2: Проверка сравнений в PHP 8.2 ---\n";
$a = 5;
$b = '05';
var_dump($a == $b);
var_dump((int)'012345');
var_dump((float)123.0 === (int)123.0);
var_dump(0 == 'hello, world');

echo "\n--- Задание 4: Перестановка переменных ---\n";
$num1 = 1;
$num2 = 2;
echo "До: num1 = $num1, num2 = $num2\n";

// Алгоритм без третьей переменной
$num1 = $num1 + $num2; // 1 + 2 = 3
$num2 = $num1 - $num2; // 3 - 2 = 1 (в num2 теперь старое значение num1)
$num1 = $num1 - $num2; // 3 - 1 = 2 (в num1 теперь старое значение num2)

echo "После: num1 = $num1, num2 = $num2\n";
