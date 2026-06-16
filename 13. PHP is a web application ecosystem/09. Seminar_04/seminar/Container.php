<?php

class Container {
    // Массив для хранения правил сборки (замыканий/фабрик)
    private array $bindings = [];
    
    // ДЗ: Массив-кэш для хранения уже созданных одиночек (Singletons)
    private array $instances = [];

    // Метод регистрации службы в контейнере
    public function set(string $id, callable $factory): void {
        $this->bindings[$id] = $factory;
    }

    // Метод получения (сборки) службы из контейнера
    public function get(string $id) {
        // ДЗ (Синглтон): Если объект этой службы уже создавался ранее, возвращаем его из кэша
        if (isset($this->instances[$id])) {
            return $this->instances[$id];
        }

        if (!isset($this->bindings[$id])) {
            throw new Exception("Служба '{$id}' не зарегистрирована в DI-контейнере.");
        }

        // Вызываем фабрику сборки, передавая в неё сам контейнер ($this) для рекурсивной сборки зависимостей
        $object = $this->bindings[$id]($this);

        // ДЗ (Синглтон): Сохраняем созданный объект в кэш одиночек
        $this->instances[$id] = $object;

        return $object;
    }
}
