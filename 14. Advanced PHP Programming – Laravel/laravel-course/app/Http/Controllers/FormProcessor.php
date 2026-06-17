<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class FormProcessor extends Controller
{
    // Метод для отображения формы
    public function index()
    {
        return view('form');
    }

    // Метод для обработки данных формы
    public function store(Request $request)
    {
        // // Собираем данные из полей формы
        // $userData = [
        //     'first_name' => $request->input('first_name'),
        //     'last_name'  => $request->input('last_name'),
        //     'email'      => $request->input('email'),
        // ];

        // // Пункт 7: Сначала возвращаем данные в виде JSON-объекта
        // return response()->json($userData);

        
        // Получаем данные из запроса
        $firstName = $request->input('first_name');
        $lastName  = $request->input('last_name');
        $email     = $request->input('email');

        // Пункт 12: Возвращаем шаблон, передавая в него переменные
        return view('welcome_user', compact('firstName', 'lastName', 'email'));
    }
}
