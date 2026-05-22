# Урок 12. Семинар: Хранение данных

## Домашняя работа

1. Добавить темы в свое приложение. У пользователя должен быть доступен выбор темы, сделать это он может в профиле (там где сейчас отображается имя и аватарка). у пользователя должен быть выбор минимум между 3 темами, причем при смене темы должен меняться не только фон в приложении, но и цвет текста, цвет фона, цвет ячеек и так далее.

2. Добавить в приложение Core Data. Теперь необходимо сохранять друзей и группы. Когда пользователь переходит к списку друзей или групп - ему сначала должны показываться данные из Core Data, затем, когда придет ответ на запрос - отображаются новые данные, а также эти данные обновляются в Core Data. Если в ответ на запрос приходит ошибка, то необходимо отобразить ее пользователю (например, используя UIAlertController) и показать данные из Core Data с пометкой, на какой момент времени эти данные актуальны.

3. Добавить возможность обновить список друзей. Например, добавить кнопку, по нажатию на которую происходит запрос в сеть на получение списка друзей или отправлять запрос, если пользователь “потянет” за таблицу (то есть беседы листаем движением пальца снизу вверх, а запрос будет отправляться при движении сверху вниз, находясь на самом верху таблицы). После получения данных необходимо их отобразить. а также обновить в Core Data.

4. Если обновление списка друзей инициировано пользователем, то необходимо на время получения данных показать пользователю, что данные обновляются (посмотрите в сторону UIActivityIndicatorView или UIRefreshControl).

5. Необходимо добавить возможность перейти в профиль друга. То есть по клику на ячейку друга необходимо переходить в его профиль. Выглядеть он должен точно так же, как и профиль пользователя, но без возможности сменить тему.

Подробности в файле ["Домашнее задание"](https://gbcdn.mrgcdn.ru/uploads/asset/5384942/attachment/c1e462d9f68060c20f1cb8447172deb1.pdf)

---

***Результат выполнения Домашней работы:***

1. Реализация динамических тем (Задача 1)
   - Создадим менеджер тем на основе NotificationCenter. Это позволит мгновенно обновлять все экраны без перезапуска приложения.
```
import UIKit

// 1. Определение доступных тем
enum AppTheme: Int, CaseIterable {
    case light, dark, blue
    
    var backgroundColor: UIColor {
        switch self {
        case .light: return .white
        case .dark: return .black
        case .blue: return UIColor(red: 0.9, green: 0.95, blue: 1.0, alpha: 1.0)
        }
    }
    
    var textColor: UIColor {
        switch self {
        case .light: return .black
        case .dark: return .white
        case .blue: return UIColor(red: 0.0, green: 0.2, blue: 0.5, alpha: 1.0)
        }
    }
    
    var cellBackgroundColor: UIColor {
        switch self {
        case .light: return .systemGroupedBackground
        case .dark: return .darkGray
        case .blue: return .white
        }
    }
}

// 2. Менеджер для сохранения и синхронизации темы
class ThemeManager {
    static let shared = ThemeManager()
    static let themeChangedNotification = Notification.Name("ThemeChanged")
    
    private let themeKey = "selectedAppTheme"
    
    var currentTheme: AppTheme {
        get {
            let savedRawValue = UserDefaults.standard.integer(forKey: themeKey)
            return AppTheme(rawValue: savedRawValue) ?? .light
        }
        set {
            UserDefaults.standard.set(newValue.rawValue, forKey: themeKey)
            NotificationCenter.default.post(name: ThemeManager.themeChangedNotification, object: nil)
        }
    }
}
```

2. Слой Core Data и Модели (Задача 2)

```
import CoreData

class CoreDataService {
    static let shared = CoreDataService()
    
    lazy var persistentContainer: NSPersistentContainer = {
        let container = NSPersistentContainer(name: "VKAppModel") // Укажите имя вашего файла xcdatamodeld
        container.loadPersistentStores { _, error in
            if let error = error { fatalError("Core Data error: \(error)") }
        }
        return container
    }()
    
    var context: NSManagedObjectContext { persistentContainer.viewContext }
    
    // Сохранение/Обновление друзей в Core Data
    func saveFriends(_ friends: [FriendModel]) {
        context.perform {
            // Удаляем старый кэш перед записью нового
            let deleteFetch = NSFetchRequest<NSFetchRequestResult>(entityName: "CachedFriend")
            let deleteRequest = NSBatchDeleteRequest(fetchRequest: deleteFetch)
            _ = try? self.context.execute(deleteRequest)
            
            for friend in friends {
                let cached = CachedFriend(context: self.context)
                cached.id = Int64(friend.id)
                cached.name = friend.name
                cached.avatarUrl = friend.avatarUrl
                cached.syncDate = Date() // Фиксируем время обновления информации
            }
            try? self.context.save()
        }
    }
    
    // Извлечение кэшированных данных
    func fetchFriends() -> [CachedFriend] {
        let fetchRequest: NSFetchRequest<CachedFriend> = CachedFriend.fetchRequest()
        return (try? context.fetch(fetchRequest)) ?? []
    }
}

// Простая структура для сетевого ответа API
struct FriendModel {
    let id: Int
    let name: String
    let avatarUrl: String
}
```

3. Основной экран: Таблица друзей с поддержкой кэша и Pull-to-Refresh (Задачи 2, 3, 4, 5)
   - Интегрируем UIRefreshControl (для жеста свайпа сверху вниз), логику последовательного вывода данных и переход в профиль по тапу.

```
import UIKit

class FriendsListViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    private let tableView = UITableView()
    private let refreshControl = UIRefreshControl()
    
    private var friends: [CachedFriend] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupTableView()
        setupObservers()
        applyTheme()
        
        // Шаг 1: Сначала мгновенно показываем кэш из Core Data
        loadCachedData()
        
        // Шаг 2: Автоматически запрашиваем актуальные данные из сети
        loadDataFromNetwork()
    }
    
    private func setupTableView() {
        view.addSubview(tableView)
        tableView.frame = view.bounds
        tableView.dataSource = self
        tableView.delegate = self
        tableView.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        
        // Настройка Pull-to-Refresh (Задача 3 и 4)
        refreshControl.addTarget(self, action: #selector(handleRefresh), for: .valueChanged)
        tableView.refreshControl = refreshControl
    }
    
    private func setupObservers() {
        NotificationCenter.default.addObserver(self, selector: #selector(applyTheme), name: ThemeManager.themeChangedNotification, object: nil)
    }
    
    @objc private func applyTheme() {
        let theme = ThemeManager.shared.currentTheme
        view.backgroundColor = theme.backgroundColor
        tableView.backgroundColor = theme.backgroundColor
        tableView.reloadData()
    }
    
    private func loadCachedData() {
        self.friends = CoreDataService.shared.fetchFriends()
        self.tableView.reloadData()
    }
    
    @objc private func handleRefresh() {
        loadDataFromNetwork()
    }
    
    private func loadDataFromNetwork() {
        // Если обновление инициировано кодом (не жестом), включаем анимацию индикатора
        if !refreshControl.isRefreshing {
            refreshControl.beginRefreshing()
        }
        
        // Имитация сетевого запроса к VK API
        FakeNetworkService.fetchFriends { [weak self] result in
            DispatchQueue.main.async {
                self?.refreshControl.endRefreshing() // Выключение индикатора (Задача 4)
                
                switch result {
                case .success(let networkFriends):
                    // Сохраняем новые данные в Core Data и обновляем интерфейс
                    CoreDataService.shared.saveFriends(networkFriends)
                    self?.loadCachedData()
                    
                case .failure(let error):
                    // Обработка ошибки сети (Задача 2)
                    self?.showErrorAlert(error: error)
                }
            }
        }
    }
    
    private func showErrorAlert(error: Error) {
        let lastSyncDate = friends.first?.syncDate ?? Date()
        let formatter = DateFormatter()
        formatter.dateFormat = "dd.MM HH:mm"
        let dateString = formatter.string(from: lastSyncDate)
        
        let alert = UIAlertController(
            title: "Ошибка сети",
            message: "\(error.localizedDescription)\nПоказаны сохраненные данные, актуальные на: \(dateString)",
            preferredStyle: .alert
        )
        alert.addAction(UIAlertController.Action(title: "OK", style: .default))
        present(alert, animated: true)
    }
    
    // MARK: - UITableView Display
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return friends.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withReuseIdentifier: "Cell", for: indexPath)
        let friend = friends[indexPath.row]
        let theme = ThemeManager.shared.currentTheme
        
        cell.textLabel?.text = friend.name
        cell.textLabel?.textColor = theme.textColor
        cell.backgroundColor = theme.cellBackgroundColor
        return cell
    }
    
    // Навигация к профилю друга (Задача 5)
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        let selectedFriend = friends[indexPath.row]
        
        let profileVC = ProfileViewController()
        profileVC.friendName = selectedFriend.name
        profileVC.isOwnProfile = false // Флаг: отключает селектор тем для друга
        
        navigationController?.pushViewController(profileVC, animated: true)
    }
}
```

4. Универсальный экран профиля (Задача 1 и 5)
   - Использует один и тот же дизайн, динамически скрывая/показывая элементы переключения тем.

```
import UIKit

class ProfileViewController: UIViewController {
    
    var isOwnProfile: Bool = true // true - свой профиль, false - профиль друга
    var friendName: String?
    
    private let nameLabel = UILabel()
    private let themeSegmentedControl = UISegmentedControl(items: ["Light", "Dark", "Blue"])
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupUI()
        setupObservers()
        applyTheme()
    }
    
    private func setupUI() {
        view.addSubview(nameLabel)
        nameLabel.translatesAutoresizingMaskIntoConstraints = false
        nameLabel.text = isOwnProfile ? "Мой Профиль" : (friendName ?? "Имя друга")
        nameLabel.font = .systemFont(ofSize: 24, weight: .bold)
        
        NSLayoutConstraint.activate([
            nameLabel.centerYAnchor.constraint(equalTo: view.centerYAnchor, constant: -50),
            nameLabel.centerXAnchor.constraint(equalTo: view.centerXAnchor)
        ])
        
        // Показываем выбор тем только если это собственный профиль (Задача 1 и 5)
        if isOwnProfile {
            view.addSubview(themeSegmentedControl)
            themeSegmentedControl.translatesAutoresizingMaskIntoConstraints = false
            themeSegmentedControl.selectedSegmentIndex = ThemeManager.shared.currentTheme.rawValue
            themeSegmentedControl.addTarget(self, action: #selector(themeChanged(_:)), for: .valueChanged)
            
            NSLayoutConstraint.activate([
                themeSegmentedControl.topAnchor.constraint(equalTo: nameLabel.bottomAnchor, constant: 30),
                themeSegmentedControl.centerXAnchor.constraint(equalTo: view.centerXAnchor),
                themeSegmentedControl.widthAnchor.constraint(equalToConstant: 250)
            ])
        }
    }
    
    private func setupObservers() {
        NotificationCenter.default.addObserver(self, selector: #selector(applyTheme), name: ThemeManager.themeChangedNotification, object: nil)
    }
    
    @objc private func applyTheme() {
        let theme = ThemeManager.shared.currentTheme
        view.backgroundColor = theme.backgroundColor
        nameLabel.textColor = theme.textColor
        themeSegmentedControl.selectedSegmentTintColor = theme.cellBackgroundColor
    }
    
    @objc private func themeChanged(_ sender: UISegmentedControl) {
        if let newTheme = AppTheme(rawValue: sender.selectedSegmentIndex) {
            ThemeManager.shared.currentTheme = newTheme
        }
    }
}
```

5. Вспомогательный класс заглушки сети
    - Для имитации ответов сервера во время тестирования функционала:

```
class FakeNetworkService {
    static func fetchFriends(completion: @escaping (Result<[FriendModel], Error>) -> Void) {
        DispatchQueue.global().asyncAfter(deadline: .now() + 2.0) {
            // Для теста ошибки поменяйте на false
            let isSuccess = true 
            
            if isSuccess {
                let mock = [
                    FriendModel(id: 1, name: "Иван Иванов", avatarUrl: ""),
                    FriendModel(id: 2, name: "Алексей Петров", avatarUrl: "")
                ]
                completion(.success(mock))
            } else {
                let error = NSError(domain: "Network", code: -1, userInfo: [NSLocalizedDescriptionKey: "Превышено время ожидания ответа от сервера VK."])
                completion(.failure(error))
            }
        }
    }
}
```
