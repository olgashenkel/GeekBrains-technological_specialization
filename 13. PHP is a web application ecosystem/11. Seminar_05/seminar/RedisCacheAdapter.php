<?php
require_once __DIR__ . '/CacheInterface.php';

class RedisCacheAdapter implements CacheInterface {
    private Predis\Client $client;

    public function __construct() {
        // Подключаемся к локальному серверу Redis
        $this->client = new Predis\Client([
            'scheme' => 'tcp',
            'host'   => '127.0.0.1',
            'port'   => 6379,
        ]);
    }

    public function get(string $key, mixed $default = null): mixed {
        $value = $this->client->get($key);
        return $value !== null ? json_decode($value, true) : $default;
    }

    public function set(string $key, mixed $value, int $ttl = null): bool {
        $serializedValue = json_encode($value, JSON_UNESCAPED_UNICODE);
        if ($ttl) {
            $this->client->setex($key, $ttl, $serializedValue);
        } else {
            $this->client->set($key, $serializedValue);
        }
        return true;
    }

    public function delete(string $key): bool {
        return (bool)$this->client->del($key);
    }
}
