<?php
namespace App\Controllers;

use App\Core\Application;
use Twig\Environment;
use Twig\Loader\FilesystemLoader;

class SiteController {
    private Environment $twig;

    public function __construct() {
        // Достаем путь к шаблонам напрямую из свойства конфигурации приложения!
        $templatesDir = Application::getInstance()->getConfig('templates_dir');
        
        $loader = new FilesystemLoader($templatesDir);
        $this->twig = new Environment($loader);
    }

    public function info(): void {
        // Можно достать любое кастомное свойство из конфига
        $siteName = Application::getInstance()->getConfig('site_name');

        echo $this->twig->render('info.twig', [
            'siteName' => $siteName,
            'serverSoftware' => $_SERVER['SERVER_SOFTWARE'] ?? 'Nginx',
            'phpVersion' => PHP_VERSION,
            'userAgent' => $_SERVER['HTTP_USER_AGENT'] ?? 'Не определен',
            'serverProtocol' => $_SERVER['SERVER_PROTOCOL'] ?? 'HTTP/1.1',
            'currentTime' => time()
        ]);
    }
}
