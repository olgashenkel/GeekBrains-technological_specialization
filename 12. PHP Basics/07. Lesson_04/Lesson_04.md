# Урок 7. Лекция. ООП

## План урока

- Концепции ООП
- Реализация концепций в PHP
- Общие понятия ООП в PHP

---

## Домашняя работа ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/12.%20PHP%20Basics/07.%20Lesson_04/homework))

**Задание:**

1. Придумайте класс, который описывает любую сущность из предметной области библиотеки: книга, шкаф, комната и т.п.
2. Опишите свойства классов из п.1 (состояние).
3. Опишите поведение классов из п.1 (методы).
4. Придумайте наследников классов из п.1. Чем они будут отличаться?
5. Создайте структуру классов ведения книжной номенклатуры.
    - Есть абстрактная книга.
    - Есть цифровая книга, бумажная книга.
    - У каждой книги есть метод получения на руки.
    - У цифровой книги надо вернуть ссылку на скачивание, а у физической – адрес библиотеки, где ее можно получить. У всех книг формируется в конечном итоге статистика по кол-ву прочтений.

    Что можно вынести в абстрактный класс, а что надо унаследовать?

6. Дан код:
```
class A {
    public function foo() {
        static $x = 0;
        echo ++$x;
    }
}
$a1 = new A();
$a2 = new A();
$a1->foo();
$a2->foo();
$a1->foo();
$a2->foo();
```

Что он выведет на каждом шаге? Почему?

Немного изменим п.5
```
class A {
    public function foo() {
        static $x = 0;
        echo ++$x;
    }
}
class B extends A {
}
$a1 = new A();
$b1 = new B();
$a1->foo();
$b1->foo();
$a1->foo();
$b1->foo();
```
Что он выведет теперь?


***Результат выполнения Домашней работы:***

```
Теоретический часть для Заданий №№ 1, 2, 3, 4.

Сущность: Книга (Book)
    - Свойства (Состояние): Название (title), автор (author), уникальный номер (isbn), доступность (isAvailable).
    - Поведение (Методы): Выдать книгу (borrowBook), вернуть книгу (returnBook), получить информацию (getInfo).
    - Наследники:
        - AudioBook (Аудиокнига) — добавляется свойство "длительность в минутах" (duration) и метод "воспроизвести фрагмент" (playPreview).
        - RareBook (Редкая/Архивная книга) — переопределяется метод borrowBook (ее нельзя выносить из читального зала, доступен только просмотр на месте).
```

```
// ************** Файл index.php **************

<?php

// БЛОК ОПРЕДЕЛЕНИЯ СРЕДЫ И ФОРМАТИРОВАНИЯ

$isCli = (php_sapi_name() === 'cli');

function printHeader(): void {
    global $isCli;
    if ($isCli) {
        echo "=== РЕЗУЛЬТАТЫ ВЫПОЛНЕНИЯ ООП ЗАДАНИЯ ===\n\n";
    } else {
        echo "<!DOCTYPE html><html lang='ru'><head><meta charset='UTF-8'><title>ООП Задание</title></head>";
        echo "<body style='font-family: Arial, sans-serif; background: #2c3e50; color: #ecf0f1; padding: 30px;'>";
        echo "<div style='max-width: 800px; margin: 0 auto; background: #34495e; padding: 25px; border-radius: 8px; box-shadow: 0 4px 15px rgba(0,0,0,0.3);'>";
        echo "<h1 style='color: #f1c40f; border-bottom: 2px solid #2c3e50; padding-bottom: 10px; margin-top: 0;'>📚 Результаты выполнения ООП задания</h1>";
    }
}

function printSectionTitle(string $title): void {
    global $isCli;
    if ($isCli) {
        echo "\n[ $title ]\n";
    } else {
        echo "<h2 style='color: #3498db; margin-top: 25px;'>$title</h2>";
    }
}

function printContentBlock(string $cliText, string $htmlText, string $type = 'green'): void {
    global $isCli;
    if ($isCli) {
        echo $cliText . "\n";
    } else {
        $borderColor = ($type === 'green') ? '#2ecc71' : '#e74c3c';
        echo "<div style='background: #1a252f; padding: 15px; border-left: 5px solid $borderColor; border-radius: 4px; font-family: monospace; color: #ecf0f1; line-height: 1.6;'>$htmlText</div>";
    }
}

function printFooter(): void {
    global $isCli;
    if (!$isCli) {
        echo "</div></body></html>";
    }
}

// СТРУКТУРА КЛАССОВ (Объявлены строго один раз)

abstract class AbstractBook {
    protected string $title;
    protected string $author;
    protected int $readCount = 0;

    public function __construct(string $title, string $author) {
        $this->title = $title;
        $this->author = $author;
    }

    public function incrementReadCount(): void {
        $this->readCount++;
    }

    public function getStatistics(): string {
        return "Книгу '{$this->title}' читали раз: {$this->readCount}";
    }

    abstract public function getAccessMethod(): string;
}

class DigitalBook extends AbstractBook {
    private string $downloadUrl;

    public function __construct(string $title, string $author, string $downloadUrl) {
        parent::__construct($title, $author);
        $this->downloadUrl = $downloadUrl;
    }

    public function getAccessMethod(): string {
        $this->incrementReadCount();
        return "Ссылка для скачивания цифровой книги: {$this->downloadUrl}";
    }
}

class PaperBook extends AbstractBook {
    private string $libraryAddress;

    public function __construct(string $title, string $author, string $libraryAddress) {
        parent::__construct($title, $author);
        $this->libraryAddress = $libraryAddress;
    }

    public function getAccessMethod(): string {
        $this->incrementReadCount();
        return "Адрес библиотеки для получения бумажной книги: {$this->libraryAddress}";
    }
}

class A {
    public function foo() {
        static $x = 0;
        echo ++$x . " ";
    }
}

class B extends A {}

// ИСПОЛНЕНИЕ И ВЫВОД

printHeader();

// ---- Задание 5 ----
printSectionTitle("Задание 5: Книжная номенклатура");

$eBook = new DigitalBook("Чистый код", "Роберт Мартин", "http://example.com");
$pBook = new PaperBook("Совершенный код", "Стив Макконнелл", "ул. Пушкина, д. 10, зал 3");

$m1 = $eBook->getAccessMethod();
$m2 = $eBook->getAccessMethod();
$m3 = $pBook->getAccessMethod();
$s1 = $eBook->getStatistics();
$s2 = $pBook->getStatistics();

$cli5 = "$m1\n$m2\n$m3\n\nСтатистика:\n$s1\n$s2";
$html5 = "$m1<br>$m2<br>$m3<br><br><strong>Статистика:</strong><br>$s1<br>$s2";

printContentBlock($cli5, $html5, 'green');

// ---- Задание 6 ----
printSectionTitle("Задание 6: Тест статических переменных");

// Выполняем тесты и перехватываем вывод foo()
ob_start();
$a1 = new A(); $a2 = new A();
$a1->foo(); $a2->foo(); $a1->foo(); $a2->foo();
$resA = ob_get_clean();

ob_start();
$a1_new = new A(); $b1 = new B();
$a1_new->foo(); $b1->foo(); $a1_new->foo(); $b1->foo();
$resB = ob_get_clean();

$cli6 = "Вызов цепочки для одного класса A:\n$resA\n\nВызов цепочки при наследовании класса B:\n$resB";
$html6 = "<strong>Вызов цепочки для одного класса A:</strong><br>$resA<br><br><strong>Вызов цепочки при наследовании класса B:</strong><br>$resB";

printContentBlock($cli6, $html6, 'red');

printFooter();
```


```
Разбор Задания № 6 (Почему такой вывод?)
Анализ Части 1: 
    Вывод: 1 2 3 4

Ключевое слово static внутри метода объявляет статическую переменную, которая принадлежит самому методу класса, а не конкретному объекту ($a1 или $a2). Память под $x выделяется один раз для класса A. Сколько бы объектов мы ни создавали, они вызывают один и тот же метод A::foo(), изменяя одну и subdivision общую переменную $x.

Анализ Части 2:
    Вывод: 5 1 6 2

В PHP при наследовании (class B extends A), если дочерний класс вызывает статический контекст родителя, компилятор динамически связывает область видимости статических переменных.Для класса A существует своя переменная $x (она продолжила увеличиваться: 5, 6).Для класса B создается своя изолированная копия статической переменной $x, которая начинает свой отсчет с нуля (1, 2).
```

![Домашняя работа](image/homework.jpg)



## Практическая работа на лекции ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/12.%20PHP%20Basics/07.%20Lesson_04/lesson))
