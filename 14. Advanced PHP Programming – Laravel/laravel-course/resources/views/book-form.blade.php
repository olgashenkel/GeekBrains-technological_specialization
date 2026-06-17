<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавление книги</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f4f7f6; }
        .form-wrapper { max-width: 500px; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); margin: 0 auto; }
        .form-section { margin-bottom: 20px; }
        label { display: block; margin-bottom: 8px; font-weight: bold; }
        input[type="text"], select { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        button { width: 100%; padding: 12px; background: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
        button:hover { background: #0056b3; }
        .alert-danger { background: #ffebeb; color: #b90000; padding: 15px; border: 1px solid #b90000; border-radius: 4px; margin-bottom: 20px; }
        .alert-danger ul { margin: 0; padding-left: 20px; }
    </style>
</head>
<body>

<div class="form-wrapper">
    <h2>Добавить книгу в каталог</h2>

    <!-- Блок вывода ошибок валидации (Пункт 8) -->
    @if ($errors->any())
        <div class="alert-danger">
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif

    <form name="add-new-book" id="add-new-book" method="POST" action="{{ url('/store') }}">
        @csrf <!-- Токен защиты (Пункт 2) -->

        <div class="form-section">
            <label for="title">Title</label>
            <input type="text" id="title" name="title" value="{{ old('title') }}" class="form-control" required>
        </div>

        <div class="form-section">
            <label for="author">Author</label>
            <input type="text" id="author" name="author" value="{{ old('author') }}" class="form-control" required>
        </div>

        <div class="form-section">
            <label for="genre">Choose Genre:</label>
            <select name="genre" id="genre">
                <option value="Fantasy" {{ old('genre') == 'Fantasy' ? 'selected' : '' }}>Fantasy</option>
                <option value="Sci-Fi" {{ old('genre') == 'Sci-Fi' ? 'selected' : '' }}>Sci-Fi</option>
                <option value="Mystery" {{ old('genre') == 'Mystery' ? 'selected' : '' }}>Mystery</option>
                <option value="Drama" {{ old('genre') == 'Drama' ? 'selected' : '' }}>Drama</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
