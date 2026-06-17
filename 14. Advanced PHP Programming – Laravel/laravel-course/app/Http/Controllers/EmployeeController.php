<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class EmployeeController extends Controller
{
    // Отображение формы (Пункт 4)
    public function index()
    {
        return view('get-employee-data');
    }

    // Служебные методы получения путей (Пункт 8)
    private function getPath(Request $request)
    {
        return $request->path();
    }

    private function getUrl(Request $request)
    {
        return $request->url();
    }

    // Обработка создания формы (Пункты 4, 8, 10, 11)
    public function store(Request $request)
    {
        // 1. Получаем обычные поля
        $name = $request->input('name');
        $lastName = $request->input('last_name');
        $position = $request->input('position');
        $email = $request->input('email');

        // 2. Получаем служебные данные
        $requestPath = $this->getPath($request);
        $requestUrl = $this->getUrl($request);

        // 3. Декодируем и обрабатываем JSON из textarea
        $rawJson = $request->input('workData');
        $decodedData = json_decode($rawJson, true);

        // Извлекаем вложенное поле из массива
        $city = $decodedData[0]['address']['city'] ?? 'Не указан';

        // Выводим результат в браузер для проверки
        return response()->json([
            'message' => 'Данные успешно обработаны в методе STORE',
            'meta' => [
                'path' => $requestPath,
                'url' => $requestUrl,
            ],
            'employee' => [
                'full_name' => $lastName . ' ' . $name,
                'position' => $position,
                'email' => $email,
                'city_from_json' => $city,
            ]
        ]);
    }

    // Эмуляция обновления по ID (Пункты 7, 8, 10)
    public function update(Request $request, $id)
    {
        $requestPath = $this->getPath($request);

        $rawJson = $request->input('workData');
        $decodedData = json_decode($rawJson, true);
        $street = $decodedData[0]['address']['street'] ?? 'Не указана';

        return response()->json([
            'message' => 'Данные успешно обновлены в методе UPDATE',
            'target_id' => $id,
            'meta' => [
                'path' => $requestPath,
            ],
            'updated_fields' => [
                'name' => $request->input('name'),
                'email' => $request->input('email'),
                'street_from_json' => $street
            ]
        ]);
    }
}
