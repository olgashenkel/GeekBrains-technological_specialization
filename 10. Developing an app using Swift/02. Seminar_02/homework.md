
# Урок 4. Семинар: Разработка интерфейса


## Домашняя работа

1. В проект без сториборд добавить новый экран. На экране должно отображаться 5 ячеек. Раздел всего один. Ячейка должна соответствовать схеме (см. файл по ссылке)
2. По клику на кнопку “Войти” переходить к контроллеру из 1 пункта.
3. По клику на ячейку из пункта 1 должен быть переход на экран, напоминающий экран переписки. Экран должен быть приближен к схеме.

Схемы находятся в файле ["Домашнее задание"](https://gbcdn.mrgcdn.ru/uploads/asset/5384868/attachment/52249c89ca368f13b2274e00b7ca38d4.pdf)

***Результат выполнения Домашней работы:***

1. Настройка перехода по кнопке «Войти» (Задача 2)
    - В исходном контроллере обработчик нажатия кнопки должен менять корневой контроллер окна (rootViewController), чтобы полностью переключить контекст на вкладки.
```
@objc private func loginButtonTapped() {
    let tabBarController = MainTabBarController()
    
    if let windowScene = UIApplication.shared.connectedScenes.first as? UIWindowScene,
       let window = windowScene.windows.first {
        window.rootViewController = tabBarController
        UIView.transition(with: window, duration: 0.3, options: .transitionCrossDissolve, animations: nil)
    }
}
```

2. Создание главного UITabBarController (Задача 1)   
   - Этот контроллер инициализирует три экрана, оборачивает каждый в UINavigationController (для отображения верхней панели навигации со схем) и настраивает вкладки.

```
import UIKit

class MainTabBarController: UITabBarController {
    override func viewDidLoad() {
        super.viewDidLoad()
        setupTabs()
        view.backgroundColor = .systemBackground
    }
    
    private func setupTabs() {
        let friendsVC = UINavigationController(rootViewController: FriendsViewController())
        friendsVC.tabBarItem = UITabBarItem(title: "Friends", image: UIImage(systemName: "person.2"), tag: 0)
        
        let groupsVC = UINavigationController(rootViewController: GroupsViewController())
        groupsVC.tabBarItem = UITabBarItem(title: "Groups", image: UIImage(systemName: "person.3"), tag: 1)
        
        let photosVC = UINavigationController(rootViewController: PhotosViewController())
        photosVC.tabBarItem = UITabBarItem(title: "Photos", image: UIImage(systemName: "photo.on.rectangle"), tag: 2)
        
        viewControllers = [friendsVC, groupsVC, photosVC]
    }
}
```

3. Экран «Friends» (Кастомная ячейка + Таблица из 5 элементов)
    - Кастомная ячейка для друзей

```
import UIKit

class FriendCell: UITableViewCell {
    static let reuseIdentifier = "FriendCell"
    
    let avatarView: UIView = {
        let view = UIView()
        view.backgroundColor = .systemGray5
        view.layer.cornerRadius = 25
        view.clipsToBounds = true
        return view
    }()
    
    let nameLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 18, weight: .medium)
        return label
    }()
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        setupLayout()
    }
    
    required init?(coder: NSCoder) { fatalError("init(coder:) has not been implemented") }
    
    private func setupLayout() {
        [avatarView, nameLabel].forEach {
            $0.translatesAutoresizingMaskIntoConstraints = false
            contentView.addSubview($0)
        }
        
        NSLayoutConstraint.activate([
            avatarView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            avatarView.centerYAnchor.constraint(equalTo: contentView.centerYAnchor),
            avatarView.widthAnchor.constraint(equalTo: avatarView.heightAnchor),
            avatarView.heightAnchor.constraint(equalToConstant: 50),
            
            nameLabel.leadingAnchor.constraint(equalTo: avatarView.trailingAnchor, constant: 16),
            nameLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16),
            nameLabel.centerYAnchor.constraint(equalTo: contentView.centerYAnchor)
        ])
    }
}
```

- Контроллер таблицы друзей
  
```
class FriendsViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    private let tableView = UITableView()
    private let friends = ["Алексей", "Мария", "Иван", "Ольга", "Дмитрий"] // Строго 5 элементов
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Friends"
        setupTableView()
    }
    
    private func setupTableView() {
        view.addSubview(tableView)
        tableView.frame = view.bounds
        tableView.dataSource = self
        tableView.delegate = self
        tableView.rowHeight = 70
        tableView.register(FriendCell.self, forCellReuseIdentifier: FriendCell.reuseIdentifier)
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return friends.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withReuseIdentifier: FriendCell.reuseIdentifier, for: indexPath) as? FriendCell else {
            return UITableViewCell()
        }
        cell.nameLabel.text = friends[indexPath.row]
        return cell
    }
}
```

1. Экран «Groups» (Кастомная ячейка с описанием + Таблица из 5 элементов)   
   - Кастомная ячейка для групп
```
class GroupCell: UITableViewCell {
    static let reuseIdentifier = "GroupCell"
    
    let groupImageView: UIView = {
        let view = UIView()
        view.backgroundColor = .systemGray4
        view.layer.cornerRadius = 25
        return view
    }()
    
    let titleLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 16, weight: .bold)
        return label
    }()
    
    let descriptionLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 14)
        label.textColor = .secondaryLabel
        return label
    }()
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        setupLayout()
    }
    
    required init?(coder: NSCoder) { fatalError("init(coder:) has not been implemented") }
    
    private func setupLayout() {
        let textStack = UIStackView(arrangedSubviews: [titleLabel, descriptionLabel])
        textStack.axis = .vertical
        textStack.spacing = 4
        
        [groupImageView, textStack].forEach {
            $0.translatesAutoresizingMaskIntoConstraints = false
            contentView.addSubview($0)
        }
        
        NSLayoutConstraint.activate([
            groupImageView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            groupImageView.centerYAnchor.constraint(equalTo: contentView.centerYAnchor),
            groupImageView.widthAnchor.constraint(equalToConstant: 50),
            groupImageView.heightAnchor.constraint(equalToConstant: 50),
            
            textStack.leadingAnchor.constraint(equalTo: groupImageView.trailingAnchor, constant: 16),
            textStack.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16),
            textStack.centerYAnchor.constraint(equalTo: contentView.centerYAnchor)
        ])
    }
}
```

   - Контроллер таблицы групп
```
class GroupsViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    private let tableView = UITableView()
    private let groups = [
        ("iOS Разработчики", "Сообщество Swift программистов"),
        ("Дизайн & Интерфейсы", "Обсуждение UI/UX трендов"),
        ("Спорт и Здоровье", "Фитнес, бег и правильное питание"),
        ("Киноманы", "Обзоры новинок кино и сериалов"),
        ("Путешествия", "Лайфхаки и красивые места мира")
    ]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Groups"
        setupTableView()
    }
    
    private func setupTableView() {
        view.addSubview(tableView)
        tableView.frame = view.bounds
        tableView.dataSource = self
        tableView.delegate = self
        tableView.rowHeight = 80
        tableView.register(GroupCell.self, forCellReuseIdentifier: GroupCell.reuseIdentifier)
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return groups.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withReuseIdentifier: GroupCell.reuseIdentifier, for: indexPath) as? GroupCell else {
            return UITableViewCell()
        }
        let group = groups[indexPath.row]
        cell.titleLabel.text = group.0
        cell.descriptionLabel.text = group.1
        return cell
    }
}
```

1. Экран «Photos» (Коллекция из 6 картинок в 2 колонки)
   - Ячейка для фото
```
class PhotoCell: UICollectionViewCell {
    static let reuseIdentifier = "PhotoCell"
    
    let photoView: UIView = {
        let view = UIView()
        view.backgroundColor = .systemGray3
        view.layer.borderWidth = 1
        view.layer.borderColor = UIColor.systemGray4.cgColor
        return view
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        contentView.addSubview(photoView)
        photoView.frame = contentView.bounds
    }
    
    required init?(coder: NSCoder) { fatalError("init(coder:) has not been implemented") }
}
```

   - Контроллер коллекции фотографий
```
class PhotosViewController: UIViewController, UICollectionViewDataSource {
    private var collectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Photos"
        setupCollectionView()
    }
    
    private func setupCollectionView() {
        let layout = UICollectionViewFlowLayout()
        layout.scrollDirection = .vertical
        layout.minimumLineSpacing = 16
        layout.minimumInteritemSpacing = 16
        
        let padding: CGFloat = 16
        let availableWidth = view.frame.width - (padding * 3)
        let itemWidth = availableWidth / 2 // Две колонки по схеме
        layout.itemSize = CGSize(width: itemWidth, height: itemWidth)
        layout.sectionInset = UIEdgeInsets(top: padding, left: padding, bottom: padding, right: padding)
        
        collectionView = UICollectionView(frame: view.bounds, collectionViewLayout: layout)
        collectionView.backgroundColor = .systemBackground
        collectionView.dataSource = self
        collectionView.register(PhotoCell.self, forCellWithReuseIdentifier: PhotoCell.reuseIdentifier)
        
        view.addSubview(collectionView)
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 6 // Строго 6 картинок по условию
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: PhotoCell.reuseIdentifier, for: indexPath)
        return cell
    }
}
```

