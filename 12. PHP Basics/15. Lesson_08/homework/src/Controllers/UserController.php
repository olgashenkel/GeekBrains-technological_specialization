<?php
namespace App\Controllers;

use App\Core\Application;
use App\Models\User;
use Twig\Loader\FilesystemLoader;
use Twig\Environment;

class UserController {
    private Environment $twig;

    public function __construct() {
        $loader = new FilesystemLoader(__DIR__ . '/../../templates');
        $this->twig = new Environment($loader);
    }

    private function render(string $template, array $data = []): void {
        if (empty($_SESSION['csrf_token'])) {
            $_SESSION['csrf_token'] = bin2hex(random_bytes(32));
        }
        $data['csrf_token'] = $_SESSION['csrf_token'];
        $data['user_authorized'] = isset($_SESSION['user_name']);
        // Задание 2: Передаем имя авторизованного пользователя в шаблон
        $data['logged_user_name'] = $_SESSION['user_name'] ?? '';
        
        echo $this->twig->render($template, $data);
    }

    public function index(): void {
        $pdo = Application::getInstance()->getPdo();
        $users = $pdo->query("SELECT * FROM users")->fetchAll();
        
        // Задание 3: Если передан ID для обновления, подгружаем его данные прямо в форму на главной
        $editUser = null;
        $birthdayStr = '';
        if (isset($_GET['edit_id'])) {
            $stmt = $pdo->prepare("SELECT * FROM users WHERE id_user = :id");
            $stmt->execute(['id' => (int)$_GET['edit_id']]);
            $editUser = $stmt->fetch();
            if ($editUser && $editUser['user_birthday_timestamp']) {
                $birthdayStr = date('d-m-Y', $editUser['user_birthday_timestamp']);
            }
        }

        $this->render('main.twig', ['users' => $users, 'edit_user' => $editUser, 'birthday_str' => $birthdayStr]);
    }

    public function auth(): void {
        $this->render('login.twig');
    }

    public function login(): void {
        $login = $_POST['login'] ?? '';
        $password = $_POST['password'] ?? '';
        $remember = isset($_POST['remember']); // Проверяем, нажат ли чекбокс

        $pdo = Application::getInstance()->getPdo();
        $stmt = $pdo->prepare("SELECT * FROM users WHERE login = :login");
        $stmt->execute(['login' => $login]);
        $user = $stmt->fetch();

        if ($user && password_verify($password, $user['password_hash'])) {
            $_SESSION['user_name'] = $user['user_name'];

            // ЗАДАНИЕ 4: Реализация логики "Запомнить меня"
            if ($remember) {
                // Генерируем случайный безопасный токен
                $token = bin2hex(random_bytes(32));
                
                // Сохраняем токен в базу данных пользователю
                $updateStmt = $pdo->prepare("UPDATE users SET remember_token = :token WHERE id_user = :id");
                $updateStmt->execute(['token' => $token, 'id' => $user['id_user']]);
                
                // Записываем Cookie в браузер на 30 дней (30 * 24 * 60 * 60 секунд)
                setcookie('remember_me', $token, time() + 2592000, '/', '', false, true);
            }

            header('Location: /');
            return;
        }
        $this->render('login.twig', ['error' => 'Неверный логин или пароль']);
    }

    public function logout(): void {
        $pdo = Application::getInstance()->getPdo();
        
        // ЗАДАНИЕ 4: Очищаем токен в базе данных и стираем Cookie при выходе
        if (isset($_COOKIE['remember_me'])) {
            $updateStmt = $pdo->prepare("UPDATE users SET remember_token = NULL WHERE remember_token = :token");
            $updateStmt->execute(['token' => $_COOKIE['remember_me']]);
            
            // Стираем Cookie из браузера, ставя время в прошлое
            setcookie('remember_me', '', time() - 3600, '/');
        }

        session_destroy();
        header('Location: /');
    }


    // Задание 3: Универсальное сохранение/обновление через форму
    public function save(): void {
        User::validate($_POST);
        $pdo = Application::getInstance()->getPdo();
        
        $name = htmlspecialchars($_POST['name']);
        $lastname = htmlspecialchars($_POST['lastname']);
        $ts = strtotime($_POST['birthday']);

        if (!empty($_POST['id'])) {
            $stmt = $pdo->prepare("UPDATE users SET user_name = :n, user_lastname = :l, user_birthday_timestamp = :ts WHERE id_user = :id");
            $stmt->execute(['n' => $name, 'l' => $lastname, 'ts' => $ts, 'id' => (int)$_POST['id']]);
        } else {
            $stmt = $pdo->prepare("INSERT INTO users (user_name, user_lastname, user_birthday_timestamp) VALUES (:n, :l, :ts)");
            $stmt->execute(['n' => $name, 'l' => $lastname, 'ts' => $ts]);
        }
        header('Location: /');
    }

    // Задание 3: Удаление через форму/ссылку
    public function delete(): void {
        $id = (int)($_GET['id'] ?? 0);
        if ($id > 0) {
            $stmt = Application::getInstance()->getPdo()->prepare("DELETE FROM users WHERE id_user = :id");
            $stmt->execute(['id' => $id]);
        }
        header('Location: /');
    }
}
