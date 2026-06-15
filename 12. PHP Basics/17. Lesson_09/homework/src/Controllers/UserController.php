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
        
        // Админом считается Иван (профиль admin)
        $data['is_admin'] = (isset($_SESSION['user_name']) && $_SESSION['user_name'] === 'Иван');
        $data['logged_user_name'] = $_SESSION['user_name'] ?? '';
        $data['page_views'] = $_SESSION['page_views'] ?? 0;
        echo $this->twig->render($template, $data);
    }

    public function index(): void {
        $pdo = Application::getInstance()->getPdo();
        $users = $pdo->query("SELECT * FROM users")->fetchAll();
        
        // Подсчитываем сумму оплат для вывода в таблицу для каждого пользователя
        foreach ($users as &$u) {
            $u['total_paid'] = User::getTotalPayments($u['id_user']);
        }

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

    public function auth(): void { $this->render('login.twig'); }

    public function login(): void {
        $login = $_POST['login'] ?? '';
        $password = $_POST['password'] ?? '';
        $remember = isset($_POST['remember']);

        $stmt = Application::getInstance()->getPdo()->prepare("SELECT * FROM users WHERE login = :login");
        $stmt->execute(['login' => $login]);
        $user = $stmt->fetch();

        if ($user && password_verify($password, $user['password_hash'])) {
            $_SESSION['user_name'] = $user['user_name'];
            if ($remember) {
                $token = bin2hex(random_bytes(32));
                $u = Application::getInstance()->getPdo()->prepare("UPDATE users SET remember_token = :t WHERE id_user = :id");
                $u->execute(['t' => $token, 'id' => $user['id_user']]);
                setcookie('remember_me', $token, time() + 2592000, '/', '', false, true);
            }
            header('Location: /');
            return;
        }
        $this->render('login.twig', ['error' => 'Неверный логин или пароль']);
    }

    public function logout(): void {
        if (isset($_COOKIE['remember_me'])) {
            $u = Application::getInstance()->getPdo()->prepare("UPDATE users SET remember_token = NULL WHERE remember_token = :t");
            $u->execute(['t' => $_COOKIE['remember_me']]);
            setcookie('remember_me', '', time() - 3600, '/');
        }
        session_destroy();
        header('Location: /');
    }

    public function save(): void {
        User::validate($_POST);
        $pdo = Application::getInstance()->getPdo();
        
        $name = htmlspecialchars($_POST['name'] ?? '');
        $lastname = htmlspecialchars($_POST['lastname'] ?? '');
        $ts = strtotime($_POST['birthday'] ?? '');
        $login = htmlspecialchars($_POST['login'] ?? '');
        $password = $_POST['password'] ?? '';

        User::validatePasswordStrength($password);
        $passwordHash = password_hash($password, PASSWORD_BCRYPT);

        if (!empty($_POST['id'])) {
            $stmt = $pdo->prepare("UPDATE users SET user_name = :n, user_lastname = :l, user_birthday_timestamp = :ts, login = :login, password_hash = :hash WHERE id_user = :id");
            $stmt->execute(['n' => $name, 'l' => $lastname, 'ts' => $ts, 'login' => $login, 'hash' => $passwordHash, 'id' => (int)$_POST['id']]);
        } else {
            $stmt = $pdo->prepare("INSERT INTO users (user_name, user_lastname, user_birthday_timestamp, login, password_hash) VALUES (:n, :l, :ts, :login, :hash)");
            $stmt->execute(['n' => $name, 'l' => $lastname, 'ts' => $ts, 'login' => $login, 'hash' => $passwordHash]);
        }
        header('Location: /');
    }

    public function delete(): void {
        $id = (int)($_GET['id'] ?? 0);
        if ($id > 0 && isset($_SESSION['user_name']) && $_SESSION['user_name'] === 'Иван') {
            $stmt = Application::getInstance()->getPdo()->prepare("DELETE FROM users WHERE id_user = :id");
            $stmt->execute(['id' => $id]);
        }
        header('Location: /');
    }

    public function deleteAsync(): void {
        header('Content-Type: application/json');
        if (!isset($_SESSION['user_name']) || $_SESSION['user_name'] !== 'Иван') {
            echo json_encode(['success' => false, 'message' => 'Нет прав администратора.']);
            exit;
        }
        $id = (int)($_POST['id'] ?? 0);
        if ($id > 0) {
            $stmt = Application::getInstance()->getPdo()->prepare("DELETE FROM users WHERE id_user = :id");
            $stmt->execute(['id' => $id]);
            echo json_encode(['success' => true, 'id' => $id]);
            exit;
        }
        echo json_encode(['success' => false, 'message' => 'Неверный ID.']);
        exit;
    }
}
