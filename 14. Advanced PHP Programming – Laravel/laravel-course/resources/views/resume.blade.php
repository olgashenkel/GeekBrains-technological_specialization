<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Резюме</title>
    <style>
        body { font-family: DejaVu Sans, sans-serif; padding: 30px; } /* DejaVu Sans обязателен для поддержки кириллицы в dompdf */
        .header { text-align: center; border-bottom: 2px solid #333; padding-bottom: 10px; }
        .content { margin-top: 20px; font-size: 16px; line-height: 1.6; }
    </style>
</head>
<body>
    <div class="header">
        <h2>Официальное резюме сотрудника</h2>
    </div>
    <div class="content">
        <p><strong>Имя:</strong> {{ $name }}</p>
        <p><strong>Фамилия:</strong> {{ $surname }}</p>
        <p><strong>Электронная почта:</strong> {{ $email }}</p>
        <p><strong>Дата регистрации:</strong> {{ $created_at }}</p>
    </div>
</body>
</html>
