# Урок 8. Семинар: Многопоточность

## Домашняя работа

1. У нас уже реализованы запросы на получение списка друзей, групп и фотографий. Отобразите эту информацию на экранах.

2. Добавьте возможность на экране со списком друзей видеть онлайн друг или нет.

Подробности в файле ["Домашнее задание"](https://gbcdn.mrgcdn.ru/uploads/asset/5384883/attachment/3fcafedfaff2f8e044b550edc3b16203.pdf)

---

***Результат выполнения Домашней работы:***

1. Подготовка моделей данных (Codable)
    - Чтобы отобразить информацию и статус онлайн, необходимо добавить поле online в модель друга
```
import Foundation

// Модель для Друзей
struct FriendsResponse: Codable {
    let response: FriendsResponseItems
}
struct FriendsResponseItems: Codable {
    let items: [Friend]
}
struct Friend: Codable {
    let id: Int
    let firstName: String
    let lastName: String
    let photo50: String
    let online: Int // 1 - онлайн, 0 - оффлайн

    enum CodingKeys: String, CodingKey {
        case id, online
        case firstName = "first_name"
        case lastName = "last_name"
        case photo50 = "photo_50"
    }
}

// Модель для Групп
struct GroupsResponse: Codable {
    let response: GroupsResponseItems
}
struct GroupsResponseItems: Codable {
    let items: [Group]
}
struct Group: Codable {
    let id: Int
    let name: String
    let photo50: String

    enum CodingKeys: String, CodingKey {
        case id, name
        case photo50 = "photo_50"
    }
}

// Модель для Фотографий
struct PhotosResponse: Codable {
    let response: PhotosResponseItems
}
struct PhotosResponseItems: Codable {
    let items: [Photo]
}
struct Photo: Codable {
    let id: Int
    let sizes: [PhotoSize]
}
struct PhotoSize: Codable {
    let url: String
    let type: String
}
```

2. Задача 1 и 2. Экран списка друзей с индикатором Онлайн
```
import UIKit

class FriendsViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    private let tableView = UITableView()
    private var friends: [Friend] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupTableView()
        loadFriendsData()
    }
    
    private func setupTableView() {
        view.addSubview(tableView)
        tableView.frame = view.bounds
        tableView.dataSource = self
        tableView.delegate = self
        tableView.register(UITableViewCell.self, forCellReuseIdentifier: "FriendCell")
    }
    
    private func loadFriendsData() {
        // Запрашиваем поле online в параметрах
        VKNetworkService.shared.makeRequest(method: "friends.get", parameters: ["fields": "photo_50,online"]) { [weak self] data in
            guard let data = data else { return }
            do {
                let decoded = try JSONDecoder().decode(FriendsResponse.self, from: data)
                self?.friends = decoded.response.items
                DispatchQueue.main.async {
                    self?.tableView.reloadData()
                }
            } catch {
                print("Ошибка парсинга: \(error)")
            }
        }
    }
    
    // MARK: - UITableViewDataSource
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return friends.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withReuseIdentifier: "FriendCell", for: indexPath)
        let friend = friends[indexPath.row]
        
        // Настройка текста
        let status = friend.online == 1 ? "● Онлайн" : "Оффлайн"
        cell.textLabel?.text = "\(friend.firstName) \(friend.lastName) (\(status))"
        cell.textLabel?.textColor = friend.online == 1 ? .systemGreen : .systemGray
        
        // Загрузка аватарки
        if let url = URL(string: friend.photo50) {
            DispatchQueue.global().async {
                if let data = try? Data(contentsOf: url) {
                    DispatchQueue.main.async {
                        cell.imageView?.image = UIImage(data: data)
                        cell.setNeedsLayout()
                    }
                }
            }
        }
        return cell
    }
}
```

3. Экран списка групп
   - Реализуется аналогично списку друзей через `UITableView`

```
class GroupsViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    private let tableView = UITableView()
    private var groups: [Group] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupTableView()
        loadGroupsData()
    }
    
    private func setupTableView() {
        view.addSubview(tableView)
        tableView.frame = view.bounds
        tableView.dataSource = self
        tableView.register(UITableViewCell.self, forCellReuseIdentifier: "GroupCell")
    }
    
    private func loadGroupsData() {
        VKNetworkService.shared.makeRequest(method: "groups.get", parameters: ["extended": "1"]) { [weak self] data in
            guard let data = data else { return }
            do {
                let decoded = try JSONDecoder().decode(GroupsResponse.self, from: data)
                self?.groups = decoded.response.items
                DispatchQueue.main.async {
                    self?.tableView.reloadData()
                }
            } catch {
                print(error)
            }
        }
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return groups.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withReuseIdentifier: "GroupCell", for: indexPath)
        let group = groups[indexPath.row]
        cell.textLabel?.text = group.name
        return cell
    }
}
```


4. Экран фотографий пользователяДля сетки картинок

```
class PhotosViewController: UIViewController, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout {
    
    private var collectionView: UICollectionView!
    private var photos: [Photo] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupCollectionView()
        loadPhotosData()
    }
    
    private func setupCollectionView() {
        let layout = UICollectionViewFlowLayout()
        layout.itemSize = CGSize(width: view.frame.width / 3 - 4, height: view.frame.width / 3 - 4)
        layout.minimumInteritemSpacing = 2
        layout.minimumLineSpacing = 2
        
        collectionView = UICollectionView(frame: view.bounds, collectionViewLayout: layout)
        view.addSubview(collectionView)
        collectionView.dataSource = self
        collectionView.register(UICollectionViewCell.self, forCellWithReuseIdentifier: "PhotoCell")
    }
    
    private func loadPhotosData() {
        guard let ownerID = VKSession.shared.userID else { return }
        VKNetworkService.shared.makeRequest(method: "photos.getAll", parameters: ["owner_id": ownerID]) { [weak self] data in
            guard let data = data else { return }
            do {
                let decoded = try JSONDecoder().decode(PhotosResponse.self, from: data)
                self?.photos = decoded.response.items
                DispatchQueue.main.async {
                    self?.collectionView.reloadData()
                }
            } catch {
                print(error)
            }
        }
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return photos.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "PhotoCell", for: indexPath)
        cell.backgroundColor = .systemGray6
        
        // Берём первый доступный размер урла
        if let photoUrlString = photos[indexPath.item].sizes.first?.url, let url = URL(string: photoUrlString) {
            DispatchQueue.global().async {
                if let data = try? Data(contentsOf: url), let image = UIImage(data: data) {
                    DispatchQueue.main.async {
                        let imageView = UIImageView(image: image)
                        imageView.contentMode = .scaleAspectFill
                        imageView.clipsToBounds = true
                        cell.backgroundView = imageView
                    }
                }
            }
        }
        return cell
    }
}
```


