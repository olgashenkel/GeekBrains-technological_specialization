<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Приветствие</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f4f7f6; text-align: center; }
        .card { background: white; padding: 30px; border-radius: 8px; display: inline-block; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        h1 { color: #2d3748; }
        p { color: #718096; }
    </style>
</head>
<body>
    <div class="card">
        <!-- Выводим переданные переменные -->
        <h1>Привет, {{ $firstName }} {{ $lastName }}!</h1>
        <p>Ваш Email: {{ $email }}</p>
    </div>
</body>
</html>
