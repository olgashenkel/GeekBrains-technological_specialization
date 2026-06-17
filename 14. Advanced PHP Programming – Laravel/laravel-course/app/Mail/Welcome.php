<?php

namespace App\Mail;

use App\Models\User;
use Illuminate\Bus\Queueable;
use Illuminate\Mail\Mailable;
use Illuminate\Mail\Mailables\Content;
use Illuminate\Mail\Mailables\Envelope;
use Illuminate\Queue\SerializesModels;

class Welcome extends Mailable
{
    use Queueable, SerializesModels;

    // Объявляем публичное свойство, чтобы оно автоматически было доступно в Blade
    public User $user;

    public function __construct(User $user)
    {
        $this->user = $user;
    }

    public function envelope(): Envelope
    {
        return new Envelope(
            subject: 'Спасибо за регистрацию!',
        );
    }

    public function content(): Content
    {
        return new Content(
            view: 'emails.welcome', // Указываем путь к шаблону
        );
    }
}
