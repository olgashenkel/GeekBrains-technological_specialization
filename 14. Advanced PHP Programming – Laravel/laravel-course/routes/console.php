<?php

use Illuminate\Foundation\Inspiring;
use Illuminate\Support\Facades\Artisan;
use Illuminate\Support\Facades\Schedule;
use App\Jobs\ClearCache;


Artisan::command('inspire', function () {
    $this->comment(Inspiring::quote());
})->purpose('Display an inspiring quote');


// Помещаем вызов фоновой задачи в планировщик на каждый час (Пункт 8)
Schedule::job(new ClearCache)->everyMinute();
