<?php

class CronParser {
    public function isTimeMatch(string $cronValue, int $currentValue): bool {
        if ($cronValue === '*') {
            return true;
        }
        if (str_contains($cronValue, ',')) {
            $parts = explode(',', $cronValue);
            return in_array((string)$currentValue, $parts, true);
        }
        return (int)$cronValue === $currentValue;
    }
}
