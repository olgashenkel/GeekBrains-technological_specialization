# Урок 14. Семинар: Архитектуры и тестирование

## Домашняя работа

1. Выбрать архитектурный паттерн. Переписать свой проект с друзьями, группами и фото с использованием этого паттерна.

2. Провести рефакторинг кода. Постарайтесь сделать так, чтобы в вашем коде соблюдались основные принципы. Также проверьте, что у вас используются понятные названия, название классов с большой буквы, функций с маленькой и так далее.

3. Подключить SwiftLint к проекту. Избавиться от ошибок и предупреждений.

4. Покрыть свой код unit и ui-тестами.


---

***Результат выполнения Домашней работы:***

Для выполнения этого домашнего задания выбран архитектурный паттерн MVP (Model-View-Presenter). Он идеально подходит для рефакторинга UIKit-приложений, так как позволяет полностью разгрузить ViewController (избавиться от Massive View Controller), изолировать бизнес-логику для Unit-тестирования и сохранить четкое разделение обязанностей (Solid).

1. 1 & 2. Архитектурный паттерн MVP и Рефакторинг кода
   - Применение паттерна MVP на примере экрана списка друзей. Бизнес-логика (работа с сетью и Core Data) выносится в Presenter, а ViewController становится пассивным отображением (View), который общается с презентером через протоколы.
   - Протоколы (Contracts):

```
import Foundation

// Протокол для управления UI (View)
protocol FriendsViewProtocol: AnyObject {
    func reloadData()
    func showLoading()
    func hideLoading()
    func showError(message: String)
}

// Протокол для бизнес-логики (Presenter)
protocol FriendsPresenterProtocol: AnyObject {
    init(view: FriendsViewProtocol, networkService: VKNetworkServiceProtocol, coreDataService: CoreDataServiceProtocol)
    var friendsCount: Int { get }
    func getFriend(at index: Int) -> CachedFriend
    func loadData()
    func didSelectFriend(at index: Int)
}
```

2. Презентер (Presenter)

```
import Foundation

class FriendsPresenter: FriendsPresenterProtocol {
    private weak var view: FriendsViewProtocol?
    private let networkService: VKNetworkServiceProtocol
    private let coreDataService: CoreDataServiceProtocol
    
    private var friends: [CachedFriend] = []
    
    var friendsCount: Int {
        return friends.count
    }
    
    required init(view: FriendsViewProtocol, networkService: VKNetworkServiceProtocol, coreDataService: CoreDataServiceProtocol) {
        self.view = view
        self.networkService = networkService
        self.coreDataService = coreDataService
    }
    
    func getFriend(at index: Int) -> CachedFriend {
        return friends[index]
    }
    
    func loadData() {
        // 1. Сначала загружаем локальный кэш
        fetchLocalData()
        
        // 2. Показываем лоадер и идем в сеть
        view?.showLoading()
        
        networkService.fetchFriends { [weak self] result in
            guard let self = self else { return }
            self.view?.hideLoading()
            
            switch result {
            case .success(let networkFriends):
                self.coreDataService.saveFriends(networkFriends)
                self.fetchLocalData()
                
            case .failure(let error):
                let lastSync = self.friends.first?.syncDate ?? Date()
                let formatter = DateFormatter()
                formatter.dateFormat = "dd.MM HH:mm"
                let dateString = formatter.string(from: lastSync)
                
                self.view?.showError(message: "\(error.localizedDescription)\nДанные от: \(dateString)")
            }
        }
    }
    
    func didSelectFriend(at index: Int) {
        let friend = friends[index]
        // Логика координации/перехода на профиль друга
    }
    
    private func fetchLocalData() {
        self.friends = coreDataService.fetchFriends()
        self.view?.reloadData()
    }
}
```

3. Представление (View / ViewController)
   - Контроллер теперь отвечает только за отрисовку интерфейса и передачу действий пользователя презентеру.

```
import UIKit

class FriendsViewController: UIViewController, FriendsViewProtocol {
    
    var presenter: FriendsPresenterProtocol!
    private let tableView = UITableView()
    private let activityIndicator = UIActivityIndicatorView(style: .medium)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupTableView()
        setupLayout()
        
        // Инициализация MVP-связки 
        self.presenter = FriendsPresenter(
            view: self,
            networkService: VKNetworkService.shared,
            coreDataService: CoreDataService.shared
        )
        
        presenter.loadData()
    }
    
    private func setupTableView() {
        view.addSubview(tableView)
        tableView.frame = view.bounds
        tableView.dataSource = self
        tableView.delegate = self
        tableView.register(UITableViewCell.self, forCellReuseIdentifier: "FriendCell")
    }
    
    private func setupLayout() {
        view.addSubview(activityIndicator)
        activityIndicator.center = view.center
    }
    
    // MARK: - FriendsViewProtocol
    func reloadData() {
        tableView.reloadData()
    }
    
    func showLoading() {
        activityIndicator.startAnimating()
    }
    
    func hideLoading() {
        activityIndicator.stopAnimating()
    }
    
    func showError(message: String) {
        let alert = UIAlertController(title: "Ошибка", message: message, preferredStyle: .alert)
        alert.addAction(UIAlertController.Action(title: "OK", style: .default))
        present(alert, animated: true)
    }
}

// MARK: - UITableViewDataSource
extension FriendsViewController: UITableViewDataSource, UITableViewDelegate {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return presenter.friendsCount
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withReuseIdentifier: "FriendCell", for: indexPath)
        let friend = presenter.getFriend(at: indexPath.row)
        cell.textLabel?.text = friend.name
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        presenter.didSelectFriend(at: indexPath.row)
    }
}
```

4. Подключение 
   - SwiftLintSwiftLint автоматически следит за кодстайлом проекта (проверяет именование, длину функций, отступы)

```
// **************** bash ****************

if which swiftlint >/dev/null; then
  swiftlint
else
  echo "warning: SwiftLint not installed, download from https://github.com"
fi
```

```
// **************** yaml ****************

disabled_rules:
  - trailing_whitespace
excluded:
  - Pods
  - DerivedData
line_length:
  warning: 150
  error: 200
```

5. Покрытие кода тестами (Unit & UI Tests)
   - Благодаря паттерну MVP, появляется возможность протестировать FriendsPresenter изолированно от интерфейса iOS, используя Mock-объекты.
   - Написание Unit-теста (Проверка бизнес-логики)

```
import XCTest
@testable import YourVKAppProject 

// 1. Создаем мок для View, чтобы проверять вызовы методов интерфейса
class MockFriendsView: FriendsViewProtocol {
    var isReloadDataCalled = false
    var isShowLoadingCalled = false
    var isHideLoadingCalled = false
    
    func reloadData() { isReloadDataCalled = true }
    func showLoading() { isShowLoadingCalled = true }
    func hideLoading() { isHideLoadingCalled = true }
    func showError(message: String) {}
}

// 2. Тест-кейс
class FriendsPresenterTests: XCTestCase {
    
    var presenter: FriendsPresenter!
    var mockView: MockFriendsView!
    
    override func setUp() {
        super.setUp()
        mockView = MockFriendsView()
        // Инициализируем презентер с моковыми сервисами сети и базы данных
        presenter = FriendsPresenter(
            view: mockView,
            networkService: MockNetworkService(), 
            coreDataService: MockCoreDataService()
        )
    }
    
    func testLoadDataCallsShowLoadingAndReload() {
        // Act (Выполнение действия)
        presenter.loadData()
        
        // Assert (Проверка результатов)
        XCTAssertTrue(mockView.isShowLoadingCalled, "Презентер должен запускать индикатор загрузки")
        XCTAssertTrue(mockView.isReloadDataCalled, "Презентер должен обновлять таблицу при получении данных")
    }
}
```

6. Написание UI-теста (Проверка интерфейса и переходов)
```
import XCTest

class VKAppUITests: XCTestCase {

    override func setUpWithError() throws {
        continueAfterFailure = false
        XCUIApplication().launch()
    }

    func testNavigationToProfile() throws {
        let app = XCUIApplication()
        
        // Находим таблицу друзей
        let tableView = app.tables.firstMatch
        XCTAssertTrue(tableView.waitForExistence(timeout: 5.0))
        
        // Находим первую ячейку с другом и нажимаем на нее
        let firstCell = tableView.cells.element(boundBy: 0)
        XCTAssertTrue(firstCell.exists)
        firstCell.tap()
        
        // Проверяем, что совершился переход и на экране появился лейбл профиля
        let profileNameLabel = app.staticTexts["Иван Иванов"] 
        XCTAssertTrue(profileNameLabel.exists, "Экран профиля друга не отобразился после тапа на ячейку")
    }
}
```

