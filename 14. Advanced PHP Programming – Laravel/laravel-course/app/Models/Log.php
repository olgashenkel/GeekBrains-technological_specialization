<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Log extends Model
{
    // Отключаем автоматические timestamp-поля Laravel
    public $timestamps = false;

    // Разрешаем массовое заполнение полей
    protected $fillable = ['time', 'duration', 'ip', 'url', 'method', 'input'];
}
