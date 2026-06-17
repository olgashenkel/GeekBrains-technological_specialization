<?php

namespace App\Listeners;

use App\Events\NewsHidden;
use Illuminate\Support\Facades\Log;
use Illuminate\Contracts\Queue\ShouldQueue;
use Illuminate\Queue\InteractsWithQueue;

class NewsHiddenListener
{
    /**
     * Create the event listener.
     */
    public function __construct()
    {
        //
    }

    /**
     * Handle the event.
     */
    public function handle(NewsHidden $event): void
    {
        // Записываем лог, используя публичное свойство события
        Log::info('News ' . $event->news->id . ' hidden');
    }
}
