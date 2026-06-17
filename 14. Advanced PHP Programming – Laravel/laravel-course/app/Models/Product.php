<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory; // 1. Импортируем трейт
use Illuminate\Database\Eloquent\Model;

class Product extends Model
{
    use HasFactory; // 2. Подключаем трейт внутри класса

    protected $fillable = ['sku', 'name', 'price']; // Разрешенные поля
}
