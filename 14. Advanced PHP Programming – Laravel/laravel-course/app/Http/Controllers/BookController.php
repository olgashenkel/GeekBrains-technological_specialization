<?php

namespace App\Http\Controllers;

use App\Models\Book;
use Illuminate\Http\Request;

class BookController extends Controller
{
    // Показ формы в браузере (Пункт 6)
    public function index()
    {
        return view('book-form');
    }

    // Валидация и сохранение данных (Пункт 7)
    public function store(Request $request)
    {
        // Выполняем валидацию по правилам из задания (Пункты 7 и 8)
        $validatedData = $request->validate([
            'title' => 'required|string|max:255|unique:books,title',
            'author' => 'required|string|max:100',
            'genre' => 'required|string'
        ], [
            // Кастомные сообщения об ошибках на русском языке
            'title.required' => 'Поле "Название книги" обязательно для заполнения.',
            'title.max' => 'Название книги не должно превышать 255 символов.',
            'title.unique' => 'Книга с таким названием уже существует в каталоге.',
            'author.required' => 'Поле "Автор" обязательно для заполнения.',
            'author.max' => 'Имя автора не должно превышать 100 символов.',
        ]);

        // Сохраняем проверенные данные в базу данных с помощью Eloquent
        \App\Models\Book::create($validatedData);

        // Возвращаем JSON-ответ об успешном сохранении (Пункт 7)
        return response()->json([
            'status' => 'success',
            'message' => 'Book is successfully validated and data has been saved'
        ]);
    }
}
