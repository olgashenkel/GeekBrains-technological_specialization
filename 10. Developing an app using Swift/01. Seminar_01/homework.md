
# Урок 2. Семинар: Знакомство с приложением


## Домашняя работа

1. Создать два проекта.   
В первом удалить все упоминания сториборд (проект 1).   
Во втором оставить (проект 2).

2. Реализовать экран без использования сториборд (проект 1).   
Это форма реализации.   
Цвета на усмотрение, экран должен быть приближен к схеме (расположение элементов).   
В поля «Логин» и «Пароль» можно вводить текст.

3. Реализовать экран с использованием сториборд (проект 2).   
Это форма реализации.   
Цвета на усмотрение, экран должен быть приближен к схеме (расположение элементов).   
В поля «Логин» и «Пароль» можно вводить текст.


***Результат выполнения Домашней работы:***

Шаг 1. Удаление Storyboard из проекта
```
1.	Создание нового проекта iOS -> App.
2.	В файле Info.plist (или вкладке Info в настройках таргета) удаляем строку Storyboard Name (внутри Application Scene Manifest -> Scene Configuration).
3.	В настройках проекта (вкладка General) в разделе Deployment Info очищаем поле Main Interface.
4.	Удаляем файл Main.storyboard в корзину.
```

Шаг 2. Настройка запуска в SceneDelegate.swift
```
В файле SceneDelegate.swift изменяем метод scene(_:willConnectTo:options:):
func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
    guard let windowScene = (scene as? UIWindowScene) else { return }
    
    let window = UIWindow(windowScene: windowScene)
    window.rootViewController = ViewController() 
    window.makeKeyAndVisible()
    self.window = window
}
```

Шаг 3. Код для ViewController.swift
```
Замена содержимого файла кодом для создания элементов интерфейса через Auto Layout Constraints:
import UIKit

class ViewController: UIViewController {

    // Создаем элементы интерфейса
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.text = "Авторизация"
        label.font = .systemFont(ofSize: 24, weight: .bold)
        label.textAlignment = .center
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let loginTextField: UITextField = {
        let tf = UITextField()
        let paddingView = UIView(frame: CGRect(x: 0, y: 0, width: 10, height: 1))
        tf.placeholder = "Логин"
        tf.borderStyle = .roundedRect
        tf.leftView = paddingView
        tf.leftViewMode = .always
        tf.autocapitalizationType = .none
        tf.translatesAutoresizingMaskIntoConstraints = false
        return tf
    }()
    
    private let passwordTextField: UITextField = {
        let tf = UITextField()
        let paddingView = UIView(frame: CGRect(x: 0, y: 0, width: 10, height: 1))
        tf.placeholder = "Пароль"
        tf.borderStyle = .roundedRect
        tf.isSecureTextEntry = true
        tf.leftView = paddingView
        tf.leftViewMode = .always
        tf.translatesAutoresizingMaskIntoConstraints = false
        return tf
    }()
    
    private let loginButton: UIButton = {
        let button = UIButton(type: .system)
        button.setTitle("Войти", size: 18)
        button.backgroundColor = .systemBlue
        button.setTitleColor(.white, for: .normal)
        button.layer.cornerRadius = 8
        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .systemBackground // Автоматический белый/черный цвет
        
        setupViews()
        setupConstraints()
    }

    private func setupViews() {
        view.addSubview(titleLabel)
        view.addSubview(loginTextField)
        view.addSubview(passwordTextField)
        view.addSubview(loginButton)
    }

    private func setupConstraints() {
        NSLayoutConstraint.activate([
            // Заголовок
            titleLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 80),
            titleLabel.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            titleLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -20),
            
            // Поле логина
            loginTextField.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: 40),
            loginTextField.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 40),
            loginTextField.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -40),
            loginTextField.heightAnchor.constraint(equalTo: 44),
            
            // Поле пароля
            passwordTextField.topAnchor.constraint(equalTo: loginTextField.bottomAnchor, constant: 16),
            passwordTextField.leadingAnchor.constraint(equalTo: loginTextField.leadingAnchor),
            passwordTextField.trailingAnchor.constraint(equalTo: loginTextField.trailingAnchor),
            passwordTextField.heightAnchor.constraint(equalTo: 44),
            
            // Кнопка входа
            loginButton.topAnchor.constraint(equalTo: passwordTextField.bottomAnchor, constant: 32),
            loginButton.leadingAnchor.constraint(equalTo: loginTextField.leadingAnchor),
            loginButton.trailingAnchor.constraint(equalTo: loginTextField.trailingAnchor),
            loginButton.heightAnchor.constraint(equalTo: 50)
        ])
    }
}

// Вспомогательное расширение для удобной настройки шрифта кнопки
extension UIButton {
    func setTitle(_ title: String, size: CGFloat) {
        self.setTitle(title, for: .normal)
        self.titleLabel?.font = .systemFont(ofSize: size, weight: .medium)
    }
}
```
________________________________________
Проект 2: Экран с использованием Storyboard
```
// Пример получившегося класса в ViewController.swift для второго проекта:

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var loginTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var loginButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loginButton.layer.cornerRadius = 8
    }
}
```
