<?php

interface CacheInterface {
    public function get(string $key, mixed $default = null): mixed;
    public function set(string $key, mixed $value, int $ttl = null): bool;
    public function delete(string $key): bool;
}
