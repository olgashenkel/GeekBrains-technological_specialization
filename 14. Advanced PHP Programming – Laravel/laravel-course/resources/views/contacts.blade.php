@extends('layouts.default')

@section('content')
    <h1>Контакты</h1>
    <p><strong>Адрес:</strong> {{ $address }}</p>
    <p><strong>Почтовый индекс:</strong> {{ $post_code }}</p>
    <p><strong>Телефон:</strong> {{ $phone }}</p>

    <p><strong>Email:</strong>
        @if(!empty($email))
            {{ $email }}
        @else
            <span class="error-box">Адрес электронной почты не указан.</span>
        @endif
    </p>
@stop
