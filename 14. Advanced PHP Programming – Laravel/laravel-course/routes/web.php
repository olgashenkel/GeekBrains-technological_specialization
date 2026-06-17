<?php

use Illuminate\Support\Facades\Route;
use App\Models\Employee;
use App\Models\Log;
use App\Models\News;
use App\Events\NewsHidden;
use App\Http\Controllers\FormProcessor;
use App\Http\Controllers\EmployeeController;
use App\Http\Controllers\BookController;
use App\Http\Controllers\ClientController;
use App\Http\Controllers\PdfGeneratorController;

// Route::get('/', function () {
//     return view('welcome');
// });

// Первый роут — Главная страница
Route::get('/', function () {
    return view('home', [
        'name' => 'Иван',
        'age' => 25, // Попробуйте поменять на 15 для проверки условия @if
        'position' => 'Middle Laravel Developer',
        'address' => 'г. Калининград, ул. Ленина, д. 10'
    ]);
});

// Второй роут — Контакты
Route::get('/contacts', function () {
    return view('contacts', [
        'address' => 'г. Калининград, ул. Ленина, д. 10',
        'post_code' => '236000',
        'email' => '', // Сделайте пустой строкой для проверки задания
        'phone' => '+7 (999) 123-45-67'
    ]);
});

Route::get('/userform', [FormProcessor::class, 'index']);

Route::post('/store_form', [FormProcessor::class, 'store']);

Route::get('/test_database', function () {
    // Создаем экземпляр модели
    $employee = new Employee();

    // Заполняем поля данными
    $employee->name = 'Алексей Иванов';
    $employee->position = 'Backend Developer';
    $employee->salary = 120000;

    // Сохраняем в БД методом save()
    $employee->save();

    return 'Сотрудник успешно сохранен в базу данных! Проверьте phpMyAdmin.';
});

// 1. Показ формы (GET)
Route::get('get-employee-data', [EmployeeController::class, 'index']);

// 2. Обработка формы (POST)
Route::post('store-form', [EmployeeController::class, 'store']);

// 3. Динамический роутинг обновления по ID (PUT)
Route::put('/user/{id}', [EmployeeController::class, 'update']);

// Маршрут для отображения формы (GET)
Route::get('/index', [BookController::class, 'index']);

// Маршрут для обработки формы (POST)
Route::post('/store', [BookController::class, 'store']);

// 1. Показ формы ввода данных
Route::get('/register-client', [ClientController::class, 'create']);

// 2. REST API: Получение всех пользователей из БД
Route::get('/user', [ClientController::class, 'index']);

// 3. REST API: Получение одного пользователя по id
Route::get('/user/{id}', [ClientController::class, 'get']);

// 4. REST API: Запись нового пользователя в базу данных
Route::post('/store-user', [ClientController::class, 'store']);

// 5. Формирование ответа: получение резюме в виде PDF-файла
Route::get('/resume/{id}', [PdfGeneratorController::class, 'index']);

Route::get('/logs', function () {
    // Получаем последние 50 логов из базы данных
    $logs = Log::orderBy('id', 'desc')->take(50)->get();
    return view('logs', compact('logs'));
});


// Создание тестовой новости
Route::get('/news/create-test', function () {
    $news = new News();
    $news->title = 'Test news title';
    $news->body = 'Test news body';
    $news->save(); // Тут сработает Обсервер и заполнит slug

    return $news;
});

// Скрытие новости и вызов события
Route::get('/news/{id}/hide', function ($id) {
    $news = News::findOrFail($id);
    $news->hidden = true;
    $news->save();

    // Вызываем событие скрытия новости
    NewsHidden::dispatch($news);

    return 'News hidden';
});
