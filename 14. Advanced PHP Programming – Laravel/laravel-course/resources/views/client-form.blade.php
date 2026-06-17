<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавить клиента</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f4f7f6; }
        .form-box { max-width: 400px; margin: 0 auto; background: white; padding: 25px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        button { width: 100%; padding: 10px; background: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; }
        .errors { background: #ffebeb; color: #b90000; padding: 10px; margin-bottom: 15px; border-radius: 4px; }
    </style>
</head>
<body>
<div class="form-box">
    <h2>Регистрация сотрудника</h2>
    @if ($errors->any())
        <div class="errors">
            @foreach ($errors->all() as $error) <p style="margin:0;">{{ $error }}</p> @endforeach
        </div>
    @endif
    <form method="POST" action="/store-user">
        @csrf
        <div class="form-group">
            <label>Name:</label>
            <input type="text" name="name" required value="{{ old('name') }}">
        </div>
        <div class="form-group">
            <label>Surname:</label>
            <input type="text" name="surname" required value="{{ old('surname') }}">
        </div>
        <div class="form-group">
            <label>Email:</label>
            <input type="email" name="email" required value="{{ old('email') }}">
        </div>
        <button type="submit">Отправить</button>
    </form>
</div>
</body>
</html>
