<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Форма пользователя</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input { padding: 8px; width: 250px; }
        button { padding: 10px 15px; background: #3490dc; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
    <h2>Заполните форму</h2>

    <!-- Сначала параметр action оставляем пустым, как просит задание -->
    <form action="/store_form" method="POST">
        <!-- Директива CSRF добавляет скрытый токен безопасности, без него Laravel выдаст ошибку 419 -->
        @csrf

        <div class="form-group">
            <label for="first_name">Имя:</label>
            <input type="text" id="first_name" name="first_name" required>
        </div>

        <div class="form-group">
            <label for="last_name">Фамилия:</label>
            <input type="text" id="last_name" name="last_name" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>

        <button type="submit">Submit</button>
    </form>
</body>
</html>
