<?php

namespace App\Providers;

use Illuminate\Support\ServiceProvider;
use App\Models\News;
use App\Observers\NewsObserver;
use App\Events\NewsHidden;
use App\Listeners\NewsHiddenListener;
use Illuminate\Support\Facades\Event;

class AppServiceProvider extends ServiceProvider
{
    /**
     * Register any application services.
     */
    public function register(): void
    {
        //
    }

    /**
     * Bootstrap any application services.
     */
    public function boot(): void
    {
        // Регистрация события и слушателя (Пункт 7)
        Event::listen(NewsHidden::class, NewsHiddenListener::class);

        // Регистрация наблюдателя (Пункт 12)
        News::observe(NewsObserver::class);
    }
}
