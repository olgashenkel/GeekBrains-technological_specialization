<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавление работника</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background: #f4f7f6; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input, textarea { width: 100%; max-width: 400px; padding: 8px; border: 1px solid #ccc; border-radius: 4px; }
        textarea { height: 100px; }
        button { padding: 10px 15px; background: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; }
    </style>
</head>
<body>
    <h2>Форма добавления работника</h2>

    <form name="employee-form" id="employee-form" method="POST" action="{{ url('store-form') }}">
        @csrf

        <div class="form-group">
            <label for="name">Имя работника:</label>
            <input type="text" id="name" name="name" required="true">
        </div>

        <div class="form-group">
            <label for="last_name">Фамилия работника:</label>
            <input type="text" id="last_name" name="last_name" required="true">
        </div>

        <div class="form-group">
            <label for="position">Занимаемая должность:</label>
            <input type="text" id="position" name="position" required="true">
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required="true">
        </div>

        <div class="form-group">
            <label for="workData">Служебные данные (JSON-формат):</label>
            <textarea id="workData" name="workData" required="true">[{"address": {"street": "Kulas Light", "city": "Gwenborough"}}]</textarea>
        </div>

        <button type="submit">Submit</button>
    </form>
</body>
</html>
