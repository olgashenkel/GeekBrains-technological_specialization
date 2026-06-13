<?php

// ****************** ЗАДАНИЕ № 1 ******************

// 1-ый вариант
// function mergeSortedArrays(array $arr1, array $arr2): array {
//     $result = [];
//     $i = 0; 
//     $j = 0; 
    
//     $count1 = count($arr1);
//     $count2 = count($arr2);

//     while ($i < $count1 && $j < $count2) {
//         if ($arr1[$i] <= $arr2[$j]) {
//             $result[] = $arr1[$i];
//             $i++;
//         } else {
//             $result[] = $arr2[$j];
//             $j++;
//         }
//     }

//     while ($i < $count1) {
//         $result[] = $arr1[$i];
//         $i++;
//     }

//     while ($j < $count2) {
//         $result[] = $arr2[$j];
//         $j++;
//     }

//     return $result;
// }

// // ТЕСТОВЫЕ ДАННЫЕ ЗАПОЛНЕНЫ
// $array1 =[1, 4, 6, 6, 8];
// $array2 =[2, 5, 7, 9];

// echo "--- Результат слияния массивов ---\n";
// $finalArray = mergeSortedArrays($array1, $array2);

// echo "[" . implode(", ", $finalArray) . "]\n";



// // 2-ой вариант
// function mergeSortedArraysNative(array $arr1, array $arr2): array {
//     // 1. Сливаем два массива в один общий
//     $merged = array_merge($arr1, $arr2);
    
//     // 2. Сортируем по возрастанию (сохраняя дубликаты)
//     sort($merged);
    
//     return $merged;
// }

// echo "--- Результат слияния (Встроенный) ---\n";
// print_r(mergeSortedArraysNative($array1, $array2));



// ****************** ЗАДАНИЕ № 2 ******************

/**
 * Функция проверки: является ли число простым
 */
// function isPrime(int $number): bool {
//     // Числа меньше или равные 1 не являются простыми
//     if ($number <= 1) {
//         return false;
//     }

//     // Проверяем делители от 2 до квадратного корня из числа.
//     // Это математически оптимизирует поиск (не нужно проверять все числа до $number).
//     for ($i = 2; $i * $i <= $number; $i++) {
//         // Если число делится без остатка, то оно составное
//         if ($number % $i === 0) {
//             return false;
//         }
//     }

//     // Если делителей не нашлось — число простое
//     return true;
// }


// echo "--- Проверка чисел от 1 до 10 ---\n";

// for ($i = 1; $i <= 10; $i++) {
//     if (isPrime($i)) {
//         echo "Число $i — ПРОСТОЕ\n";
//     } else {
//         echo "Число $i — составное (или <= 1)\n";
//     }
// }



// ****************** ЗАДАНИЕ № 3 ******************

/**
 * Функция проверки корректности скобочной последовательности
 */
function isBracketsCorrect(string $string): bool {
    $counter = 0;
    $length = strlen($string);

    for ($i = 0; $i < $length; $i++) {
        $char = $string[$i];

        if ($char === '(') {
            $counter++;
        } elseif ($char === ')') {
            $counter--;
        }

        // Если счётчик стал меньше нуля, значит закрывающая скобка 
        // появилась раньше открывающей (например, ")(")
        if ($counter < 0) {
            $returnCode = false;
            return false;
        }
    }

    // Если все скобки закрылись вовремя, счётчик равен 0
    return $counter === 0;
}


$testCases = [
    "()()(())", // Корректная
    ")(",       // Некорректная
    "())(",     // Некорректная
    "(()())",   // Корректная
    "((())"     // Некорректная (не закрыта одна скобка)
];

echo "--- Проверка скобочных последовательностей ---\n";

foreach ($testCases as $case) {
    $status = isBracketsCorrect($case) ? "КОРРЕКТНА" : "НЕКОРРЕКТНА";
    echo "Строка: \"$case\" -> $status\n";
}
