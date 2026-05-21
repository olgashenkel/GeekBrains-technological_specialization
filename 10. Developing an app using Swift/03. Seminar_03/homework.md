# Урок 6. Семинар: Работа с сетью

## Домашняя работа

1. Необходимо очистить ViewController и добавить на него WKWebView(WKWebView). Для этого необходимо вверху импортировать WebKit, затем добавить WKWebView в качестве subview и сделать контроллер делегатом для webView (для этого ViewController должен соответствовать WKNavigationDelegate).   
Затем необходимо начать загрузку, например, во viewDidLoad(). Для этого вызывается webView.load и передается URLRequest. Подробнее о запросе, который необходимо отправить можно прочитать здесь: https://dev.vk.com/api/oauth-parameters.   
Также предварительно необходимо “Создать приложение”. Сделать это можно кликнув на “Создать приложение” здесь: https://dev.vk.com/.   
Затем необходимо реализовать метод func webView(_ webView: WKWebView, decidePolicyFor navigationResponse: WKNavigationResponse, decisionHandler: @escaping (WKNavigationResponsePolicy) -> Void).   
Token и userID нам еще понадобятся для дальнейших запросов.

2. На следующем контроллере планируется отображение списка друзей. Подумайте и решите, как удобнее: открывать окно авторизации на ViewController и затем переходить к списку друзей или открывать авторизацию на экране списка друзей. Реализуйте свое решение.

3. Получать список друзей. Для этого необходимо изучить документацию, а затем выбрать правильный метод. Результат нужно выводить в консоль. Отображать список не нужно. Место, где можно искать метод: https://dev.vk.com/method/friends.
Запрос должен отправляться только после перехода к экрану списка друзей.

4. Получать список групп. Для этого необходимо изучить документацию, а затем выбрать правильный метод. Результат нужно выводить в консоль. Отображать список не нужно. Место, где можно искать метод: https://dev.vk.com/method/groups.
Запрос должен отправляться только после перехода к экрану списка групп.

5. Получать фотографии со страницы пользователя. Для этого необходимо изучить документацию, а затем выбрать правильный метод. Результат нужно выводить в консоль. Отображать фотографии не нужно. Место, где можно искать метод: https://dev.vk.com/method/photos.
Запрос должен отправляться только после перехода к экрану фотографий.
https://docs.google.com/document/d/1gV_rGGloQj4OlKTMXb2DLjdxbI1ZuiGN/edit

Примеры в файле ["Домашнее задание"](https://gbcdn.mrgcdn.ru/uploads/asset/5384872/attachment/5ef78943e5d5e4f96dc1735ce27a7289.pdf)

---

***Результат выполнения Домашней работы:***

1. Хранилище данных авторизации (Session)
    - Синглтон для глобального доступа к сохраненному токену и ID пользователя
```
import Foundation

final class Session {
    static let shared = Session()
    private init() {}
    
    var token: String?
    var userId: String?
    var version: String = "5.131" 
}
```

2. Задача 1 и 2: Экран авторизации (AuthViewController)
   - Здесь настраивается WKWebView, перехватывается URL с токеном, и происходит переход на основной интерфейс приложения

```
import UIKit
import WebKit

final class AuthViewController: UIViewController, WKNavigationDelegate {
    
    private lazy var webView: WKWebView = {
        let webView = WKWebView()
        webView.navigationDelegate = self
        return webView
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupViews()
        loadAuthPage()
    }
    
    private func setupViews() {
        view.addSubview(webView)
        webView.frame = view.bounds
    }
    
    private func loadAuthPage() {        
        var urlComponents = URLComponents(string: "https://vk.com")
        urlComponents?.queryItems = [
            URLQueryItem(name: "client_id", value: ""),
            URLQueryItem(name: "redirect_uri", value: "https://vk.com"),
            URLQueryItem(name: "display", value: "mobile"),
            URLQueryItem(name: "scope", value: "friends,groups,photos"),
            URLQueryItem(name: "response_type", value: "token"),
            URLQueryItem(name: "v", value: Session.shared.version)
        ]
        
        guard let url = urlComponents?.url else { return }
        webView.load(URLRequest(url: url))
    }
    
    func webView(_ webView: WKWebView, decidePolicyFor navigationResponse: WKNavigationResponse, decisionHandler: @escaping (WKNavigationResponsePolicy) -> Void) {
        
        guard let url = navigationResponse.response.url, url.path == "/blank.html", let fragment = url.fragment else {
            decisionHandler(.allow)
            return
        }
        
        let params = fragment
            .components(separatedBy: "&")
            .map { $0.components(separatedBy: "=") }
            .reduce(into: [String: String]()) { dict, param in
                if param.count == 2 { dict[param[0]] = param[1] }
            }
        
        if let token = params["access_token"], let userId = params["user_id"] {
            Session.shared.token = token
            Session.shared.userId = userId
            
            print("Авторизация успешна!")
            print("Token: \(token)")
            print("User ID: \(userId)")
            
            decisionHandler(.cancel)
            navigateToMainApp()
        } else {
            decisionHandler(.allow)
        }
    }
    
    private func navigateToMainApp() {
        DispatchQueue.main.async {
            let tabBarVC = MainTabBarController()
            tabBarVC.modalPresentationStyle = .fullScreen
            self.present(tabBarVC, animated: true)
        }
    }
}
```

3. Навигация: Главный Таб-Бар (MainTabBarController) 
   - Контроллер объединяет три требуемых экрана в удобную вкладку.
```
import UIKit

final class MainTabBarController: UITabBarController {
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let friendsVC = FriendsViewController()
        friendsVC.tabBarItem = UITabBarItem(title: "Друзья", image: UIImage(systemName: "person.2"), tag: 0)
        
        let groupsVC = GroupsViewController()
        groupsVC.tabBarItem = UITabBarItem(title: "Группы", image: UIImage(systemName: "person.3"), tag: 1)
        
        let photosVC = PhotosViewController()
        photosVC.tabBarItem = UITabBarItem(title: "Фото", image: UIImage(systemName: "photo"), tag: 2)
        
        viewControllers = [friendsVC, groupsVC, photosVC]
    }
}
```

4. Задача 3: Экран друзей (FriendsViewController)
    - Запрос к методу friends.get. Результат выводится в консоль

```
import UIKit

final class FriendsViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .systemBackground
        title = "Друзья"
        fetchFriends()
    }
    
    private func fetchFriends() {
        guard let token = Session.shared.token else { return }
        
        var urlComponents = URLComponents(string: "https://api.vk.com/method/friends.get")
        urlComponents?.queryItems = [
            URLQueryItem(name: "access_token", value: token),
            URLQueryItem(name: "fields", value: "nickname"),
            URLQueryItem(name: "v", value: Session.shared.version)
        ]
        
        guard let url = urlComponents?.url else { return }
        
        URLSession.shared.dataTask(with: url) { data, _, error in
            if let error = error { print("Ошибка: \(error)"); return }
            guard let data = data else { return }
            
            if let jsonString = String(data: data, encoding: .utf8) {
                print("\n --- СПИСОК ДРУЗЕЙ ---")
                print(jsonString)
            }
        }.resume()
    }
}
```

5. Задача 4: Экран сообществ (GroupsViewController)
   - Запрос к методу groups.get. Результат выводится в консоль
```
import UIKit

final class GroupsViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .systemBackground
        title = "Группы"
        fetchGroups()
    }
    
    private func fetchGroups() {
        guard let token = Session.shared.token else { return }
        
        var urlComponents = URLComponents(string: "https://vk.com")
        urlComponents?.queryItems = [
            URLQueryItem(name: "access_token", value: token),
            URLQueryItem(name: "extended", value: "1"),
            URLQueryItem(name: "v", value: Session.shared.version)
        ]
        
        guard let url = urlComponents?.url else { return }
        
        URLSession.shared.dataTask(with: url) { data, _, error in
            if let error = error { print("Ошибка: \(error)"); return }
            guard let data = data else { return }
            
            if let jsonString = String(data: data, encoding: .utf8) {
                print("\n --- СПИСОК ГРУПП ---")
                print(jsonString)
            }
        }.resume()
    }
}
```

6. Задача 5: Экран фотографий (PhotosViewController)
    - Запрос к методу photos.getAll. Результат выводится в консоль
```
import UIKit

final class PhotosViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .systemBackground
        title = "Фотографии"
        fetchPhotos()
    }
    
    private func fetchPhotos() {
        guard let token = Session.shared.token, let ownerId = Session.shared.userId else { return }
        
        var urlComponents = URLComponents(string: "https://vk.com")
        urlComponents?.queryItems = [
            URLQueryItem(name: "access_token", value: token),
            URLQueryItem(name: "owner_id", value: ownerId),
            URLQueryItem(name: "v", value: Session.shared.version)
        ]
        
        guard let url = urlComponents?.url else { return }
        
        URLSession.shared.dataTask(with: url) { data, _, error in
            if let error = error { print("Ошибка: \(error)"); return }
            guard let data = data else { return }
            
            if let jsonString = String(data: data, encoding: .utf8) {
                print("\n📸 --- СПИСОК ФОТОГРАФИЙ ---")
                print(jsonString)
            }
        }.resume()
    }
}
```
