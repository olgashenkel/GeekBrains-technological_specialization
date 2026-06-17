<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Логи запросов</title>
    <style>
        body { font-family: sans-serif; margin: 30px; background: #2c3e50; color: #fff; }
        .table-box { width: 100%; overflow-x: auto; background: #34495e; padding: 20px; border-radius: 8px; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #4f5d73; }
        th { background: #1abc9c; }
        tr:nth-child(even) { background: #2c3e50; }
    </style>
</head>
<body>
    <h2>Журнал HTTP-запросов (Реальное время)</h2>
    <div class="table-box">
        <table>
            <thead>
                <tr>
                    <th>ID</th><th>Время</th><th>Длительность (мс)</th><th>IP</th><th>URL</th><th>Метод</th><th>Параметры</th>
                </tr>
            </thead>
            <tbody>
                @foreach($logs as $log)
                    <tr>
                        <td>{{ $log->id }}</td>
                        <td>{{ $log->time }}</td>
                        <td>{{ $log->duration }}</td>
                        <td>{{ $log->ip }}</td>
                        <td>{{ $log->url }}</td>
                        <td>{{ $log->method }}</td>
                        <td><code>{{ $log->input }}</code></td>
                    </tr>
                @endforeach
            </tbody>
        </table>
    </div>
</body>
</html>
