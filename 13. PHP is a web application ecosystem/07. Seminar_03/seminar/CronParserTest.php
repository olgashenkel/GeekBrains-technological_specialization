<?php
use PHPUnit\Framework\TestCase;
use PHPUnit\Framework\Attributes\DataProvider;

require_once __DIR__ . '/CronParser.php';

class CronParserTest extends TestCase {
    
    #[DataProvider('cronTimeProvider')]
    public function testIsTimeMatchWithDataProvider(string $cronValue, int $currentValue, bool $expectedResult): void {
        $parser = new CronParser();
        $actualResult = $parser->isTimeMatch($cronValue, $currentValue);
        static::assertSame($expectedResult, $actualResult);
    }

    public static function cronTimeProvider(): array {
        return [
            'Звездочка всегда совпадает' => ['*', 45, true],
            'Точное совпадение минут'    => ['15', 15, true],
            'Несовпадение минут'         => ['30', 12, false],
            'Совпадение из списка'       => ['5,10,15', 10, true],
            'Отсутствие в списке'        => ['5,10,15', 8, false]
        ];
    }
}
