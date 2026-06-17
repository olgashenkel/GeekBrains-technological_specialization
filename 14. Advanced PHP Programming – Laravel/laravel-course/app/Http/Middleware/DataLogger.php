<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Symfony\Component\HttpFoundation\Response;
use App\Models\Log;

class DataLogger
{
    // Логика обработки входящего запроса
    public function handle(Request $request, Closure $next): Response
    {
        // Определяем константу времени старта запроса (если еще не создана фреймворком)
        if (!defined('LARAVEL_START')) {
            define('LARAVEL_START', microtime(true));
        }

        return $next($request);
    }

    // Логика после отправки ответа пользователю
    public function terminate(Request $request, Response $response): void
    {
        // Проверяем, включено ли логирование в .env
        if (env('API_DATALOGGER', true)) {

            $endTime = microtime(true);
            // Считаем длительность в миллисекундах
            $duration = (int)(($endTime - LARAVEL_START) * 1000);

            // Если опция API_DATALOGGER_USE_DB = true, пишем в базу данных
            if (env('API_DATALOGGER_USE_DB', true)) {
                $log = new Log();
                $log->time = date('Y-m-d H:i:s');
                $log->duration = $duration;
                $log->ip = $request->ip();
                $log->url = $request->fullUrl();
                $log->method = $request->method();
                $log->input = json_encode($request->all(), JSON_UNESCAPED_UNICODE);
                $log->save();
            } else {
                // Иначе пишем лог обычным текстом в файл logs/api_datalogger.log
                $filename = 'api_datalogger_' . date('d-m-y') . '.log';
                $data = "Time: " . date('Y-m-d H:i:s') . " | ";
                $data .= "Duration: " . $duration . "ms | ";
                $data .= "IP: " . $request->ip() . " | ";
                $data .= "URL: " . $request->fullUrl() . " | ";
                $data .= "Method: " . $request->method() . " | ";
                $data .= "Input: " . json_encode($request->all(), JSON_UNESCAPED_UNICODE) . "\n";

                \Storage::disk('local')->append($filename, $data);
            }
        }
    }
}
