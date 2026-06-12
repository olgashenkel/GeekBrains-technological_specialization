<?php

$address = '/cli/birthdays.txt';

// Создаем файл, если его еще нет в контейнере
if (!file_exists($address)) {
    file_put_contents($address, "Василий Васильев, 05-06-1992\r\nИван Иванов, " . date('d-m') . "-1995\r\n");
}

// Надежная функция валидации даты (Задание 1)
function validateDate(string $date): bool {
    $dateBlocks = explode("-", $date);
    if (count($dateBlocks) !== 3) {
        return false;
    }
    
    // Проверяем, что все элементы состоят строго из цифр
    if (!ctype_digit($dateBlocks[0]) || !ctype_digit($dateBlocks[1]) || !ctype_digit($dateBlocks[2])) {
        return false;
    }

    $day = (int)$dateBlocks[0];
    $month = (int)$dateBlocks[1];
    $year = (int)$dateBlocks[2];

    // Проверяем реальность года (не из будущего и не древнее 1900)
    if ($year > (int)date('Y') || $year < 1900) {
        return false;
    }

    // Встроенная проверка календаря PHP (месяц, день, год)
    return checkdate($month, $day, $year);
}

// Функция поиска именинников на сегодняшний день (Задание 2)
function searchTodayBirthdays(string $filePath): void {
    if (!file_exists($filePath) || filesize($filePath) === 0) {
        echo "Файл базы данных пуст.\n";
        return;
    }

    $today = date('d-m'); // Текущий день и месяц, например "13-06"
    $fileHandler = fopen($filePath, 'r');
    $found = false;

    echo "\n--- СЕГОДНЯ ПРАЗДНУЮТ ДЕНЬ РОЖДЕНИЯ ---\n";
    while (($line = fgets($fileHandler)) !== false) {
        $line = trim($line);
        if (empty($line)) continue;

        $parts = explode(", ", $line);
        if (count($parts) === 2) {
            $name = $parts[0];
            $birthday = $parts[1]; // "ДД-ММ-ГГГГ"
            
            // Выделяем день и месяц из записи в файле
            $birthdayMD = substr($birthday, 0, 5); // Получаем первые 5 символов "ДД-ММ"

            if ($birthdayMD === $today) {
                echo "🎉 Поздравляем: $name ($birthday)!\n";
                $found = true;
            }
        }
    }
    fclose($fileHandler);

    if (!$found) {
        echo "Сегодня именинников не обнаружено.\n";
    }
}

// Функция удаления строки по имени или дате (Задание 3)
function deleteRecord(string $filePath, string $searchQuery): void {
    if (!file_exists($filePath)) return;

    $lines = file($filePath, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    $newLines = [];
    $deleted = false;

    foreach ($lines as $line) {
        // Если в строке содержится поисковый запрос (имя или дата), мы её пропускаем
        if (str_contains($line, $searchQuery)) {
            $deleted = true;
            echo "Строка успешно удалена: \"$line\"\n";
            continue;
        }
        $newLines[] = $line;
    }

    if ($deleted) {
        // Перезаписываем файл обновленным массивом строк
        file_put_contents($filePath, implode("\r\n", $newLines) . "\r\n");
    } else {
        echo "Запись с поисковым запросом \"$searchQuery\" не найдена в файле.\n";
    }
}

// Главный цикл меню консольного приложения (Задание 4)
while (true) {
    echo "\n=== МЕНЮ УПРАВЛЕНИЯ БАЗОЙ ДАННЫХ ===\n";
    echo "1. Добавить новую запись\n";
    echo "2. Найти сегодняшних именинников\n";
    echo "3. Удалить запись по имени или дате\n";
    echo "4. Вывести всю базу на экран\n";
    echo "5. Выйти из приложения\n";
    
    $choice = trim(readline("Выберите действие (1-5): "));

    switch ($choice) {
        case '1':
            $name = trim(readline("Введите имя: "));
            $date = trim(readline("Введите дату рождения (ДД-ММ-ГГГГ): "));
            if (validateDate($date)) {
                $data = $name . ", " . $date . "\r\n";
                file_put_contents($address, $data, FILE_APPEND);
                echo "Успешно: Запись $name добавлена.\n";
            } else {
                echo "Ошибка: Введена некорректная дата!\n";
            }
            break;

        case '2':
            searchTodayBirthdays($address);
            break;

        case '3':
            $query = trim(readline("Введите Имя или Дату для удаления: "));
            if (!empty($query)) {
                deleteRecord($address, $query);
            } else {
                echo "Запрос не может быть пустым.\n";
            }
            break;

        case '4':
            echo "\n--- СОДЕРЖИМОЕ ФАЙЛА ---\n";
            echo file_get_contents($address);
            break;

        case '5':
            echo "Работа завершена. До свидания!\n";
            exit;

        default:
            echo "Неверный выбор, попробуйте снова.\n";
    }
}
