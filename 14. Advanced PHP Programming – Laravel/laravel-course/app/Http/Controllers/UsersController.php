<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Support\Facades\Gate;

class UsersController extends Controller
{
    public function index()
    {
        // Проверяем право 'viewAny' на модель User с помощью политик
        Gate::authorize('viewAny', User::class);

        // Если проверка пройдена, возвращаем список пользователей
        return response()->json(User::all(), 200, [], JSON_UNESCAPED_UNICODE);
    }
}
