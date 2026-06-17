<?php

namespace App\Http\Controllers;

use App\Models\Client;
use Barryvdh\DomPDF\Facade\Pdf;

class PdfGeneratorController extends Controller
{
    // Генерация PDF на основе ID пользователя из базы (Пункт 10)
    public function index($id)
    {
        $client = Client::find($id);

        if (!$client) {
            return response('Пользователь не найден', 404);
        }

        // Превращаем модель в массив для передачи в шаблон
        $data = [
            'name' => $client->name,
            'surname' => $client->surname,
            'email' => $client->email,
            'created_at' => $client->created_at->format('d.m.Y H:i')
        ];

        // Загружаем блейд-шаблон резюме и передаем данные
        $pdf = Pdf::loadView('resume', $data);

        // Возвращаем файл в браузер в виде ответа (Response)
        return $pdf->stream('resume_' . $id . '.pdf');
    }
}
