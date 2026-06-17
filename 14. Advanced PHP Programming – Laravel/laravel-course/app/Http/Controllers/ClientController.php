<?php

namespace App\Http\Controllers;

use App\Models\Client;
use Illuminate\Http\Request;

class ClientController extends Controller
{
    // Показ формы
    public function create()
    {
        return view('client-form');
    }

    // Получение всех записей в JSON (Пункт 6)
    public function index()
    {
        return response()->json(Client::all(), 200, [], JSON_UNESCAPED_UNICODE);
    }

    // Получение одной записи по ID (Пункт 6)
    public function get(Request $request, $id)
    {
        $client = Client::find($id);
        if (!$client) {
            return response()->json(['error' => 'Client not found'], 404);
        }
        return response()->json($client, 200, [], JSON_UNESCAPED_UNICODE);
    }

    // Сохранение записи с валидацией (Пункт 5)
    public function store(Request $request)
    {
        $validated = $request->validate([
            'name' => 'required|string|max:50',
            'surname' => 'required|string|max:50',
            // Регулярное выражение строго проверяет формат example@mail.com
            'email' => ['required', 'string', 'regex:/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/', 'unique:clients,email']
        ]);

        Client::create($validated);

        return response()->json([
            'status' => 'success',
            'message' => 'Данные успешно сохранены в БД API.'
        ], 201, [], JSON_UNESCAPED_UNICODE);
    }
}
