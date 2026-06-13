<?php
namespace App\Core;

class Render {
    public static function renderExceptionPage(\Throwable $e): string {
        $templatesDir = Application::getInstance()->getConfig('templates_dir');
        $loader = new \Twig\Loader\FilesystemLoader($templatesDir);
        $twig = new \Twig\Environment($loader);

        return $twig->render('error.twig', [
            'errorClass' => get_class($e),
            'errorMessage' => $e->getMessage(),
            'errorFile' => $e->getFile(),
            'errorLine' => $e->getLine()
        ]);
    }
}
