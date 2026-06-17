@extends('layouts.default')

@section('content')
    <h1>Главная страница</h1>
    <p><strong>Имя:</strong> {{ $name }}</p>
    <p><strong>Должность:</strong> {{ $position }}</p>
    <p><strong>Адрес:</strong> {{ $address }}</p>

    <p><strong>Возраст:</strong>
        @if($age > 18)
            {{ $age }}
        @else
            <span class="error-box">Указанный человек слишком молод!</span>
        @endif
    </p>
@stop
