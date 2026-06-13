<?php

// ************* АБСТРАКТНЫЙ КЛАСС ТОВАР *************

abstract class AbstractProduct {
    protected string $title;
    protected float $price; // Базовая цена товара
    protected float $totalRevenue = 0; // Доход с продаж этого товара

    public function __construct(string $title, float $price) {
        $this->title = $title;
        $this->price = $price;
    }

    public function getTitle(): string { return $this->title; }
    public function getRevenue(): float { return $this->totalRevenue; }

    // Универсальный метод фиксации продажи товара
    public function sell(float $quantity): void {
        $cost = $this->calculateFinalCost($quantity);
        $this->totalRevenue += $cost;
    }

    // Абстрактный метод: каждый наследник реализует его сам
    abstract public function calculateFinalCost(float $quantity): float;
}

// ************* КЛАССЫ-НАСЛЕДНИКИ *************

/**
 * Цифровой товар (цена в 2 раза дешевле физического поштучно)
 */
class DigitalProduct extends AbstractProduct {
    public function calculateFinalCost(float $quantity): float {
        // Стоимость фиксированная за единицу, но дешевле базовой в 2 раза
        return ($this->price / 2) * $quantity;
    }
}

/**
 * Штучный физический товар (обычная цена за штуку)
 */
class PhysicalProduct extends AbstractProduct {
    public function calculateFinalCost(float $quantity): float {
        return $this->price * $quantity;
    }
}

/**
 * Товар на вес (цена зависит от дробного количества кг)
 */
class WeightProduct extends AbstractProduct {
    public function calculateFinalCost(float $quantity): float {
        // $quantity здесь выступает как вес в килограммах (например, 1.5 кг)
        return $this->price * $quantity;
    }
}

// ************* ТЕСТИРОВАНИЕ И ВЫВОД РЕЗУЛЬТАТОВ *************

// Создаем три разных типа товара с базовой ценой 100 у.е.
$eBook  = new DigitalProduct("Электронная книга PHP", 100); // Цена со скидкой будет 50
$chair  = new PhysicalProduct("Офисный стул", 100);        // Цена 100
$apples = new WeightProduct("Яблоки Голден", 100);         // Цена 100 за кг

// Симулируем продажи
$eBook->sell(2);   // Продали 2 цифровые копии: 2 * 50 = 100
$chair->sell(3);   // Продали 3 стула: 3 * 100 = 300
$apples->sell(1.5); // Продали 1.5 кг яблок: 1.5 * 100 = 150

// Форматируем текст отчета
$report = "--- Результаты расчета стоимости и доходов ---\n";
$report .= "Финальная стоимость 1 шт цифрового товара '{$eBook->getTitle()}': " . $eBook->calculateFinalCost(1) . " у.е.\n";
$report .= "Финальная стоимость 1 шт штучного товара '{$chair->getTitle()}': " . $chair->calculateFinalCost(1) . " у.е.\n";
$report .= "Финальная стоимость 1.5 кг весового товара '{$apples->getTitle()}': " . $apples->calculateFinalCost(1.5) . " у.е.\n\n";

$report .= "Доход с продаж '{$eBook->getTitle()}': " . $eBook->getRevenue() . " у.е.\n";
$report .= "Доход с продаж '{$chair->getTitle()}': " . $chair->getRevenue() . " у.е.\n";
$report .= "Доход с продаж '{$apples->getTitle()}': " . $apples->getRevenue() . " у.е.\n";

// Проверяем среду для вывода (консоль или браузер)
if (php_sapi_name() === 'cli') {
    echo $report;
} else {
    echo "<pre style='font-size:16px; background:#2c3e50; color:#ecf0f1; padding:20px; border-radius:5px; max-width:700px; margin:20px auto;'>";
    echo htmlspecialchars($report);
    echo "</pre>";
}
