<?php
use PHPUnit\Framework\TestCase;
use PHPUnit\Framework\Attributes\DataProvider;

require_once __DIR__ . '/FreelanceMoneyCollector.php';

class FreelanceMoneyCollectorTest extends TestCase
{
    // Позитивный тест по методу AAA
    public function testEarnMoney(): void
    {
        $collector = new FreelanceMoneyCollector('Александр');
        $collector->earnMoney(11000);
        $result = $collector->withdrawMoney();
        
        static::assertSame('Александр заработал 11000 руб. на фрилансе.', $result);
    }

    // Негативный тест: проверка выброса исключения
    public function testEarnNegativeMoneyThrowsException(): void
    {
        $this->expectException(Exception::class);
        $this->expectExceptionMessage("Заработок не может быть отрицательным.");

        $collector = new FreelanceMoneyCollector('Иван');
        $collector->earnMoney(-500);
    }

    // Сложный тест с использованием Data Provider
    #[DataProvider('moneyDataProvider')]
    public function testEarnMoneyWithDataProvider(string $name, array $collected, float $expectedAmount): void
    {
        $collector = new FreelanceMoneyCollector($name);
        foreach ($collected as $amount) {
            $collector->earnMoney($amount);
        }
        $result = $collector->withdrawMoney();
        
        static::assertSame("$name заработал $expectedAmount руб. на фрилансе.", $result);
    }

    public static function moneyDataProvider(): array
    {
        return [
            'Василий' => ['Василий', [20000, 4400], 24400],
            'Михаил'  => ['Михаил', [15000, 0], 15000],
            'Алексей' => ['Алексей', [15000, 3300, 50000], 68300],
        ];
    }

}
