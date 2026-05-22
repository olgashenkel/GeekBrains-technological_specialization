# Урок 10. Семинар: Анимация

## Домашняя работа

1. На экране с друзьями в `navigationBar` добавить кнопку. По клику на эту кнопку будем переходить в профиль.

2. Реализовать экран профиля. На нем должно содержаться имя пользователя и фото.

3. Реализовать свою анимацию перехода от `UITabBarController` к экрану профиля.

4. Создать новый проект (это будет проект 3), в котором будем разрабатывать интерфейс с помощью `SwiftUI`.

5. Необходимо реализовать два экрана. На первом только текст или кнопка или ссылка. По клику на текст/кнопку/ссылку необходимо перейти на следующий экран. На следующем экране должна отображаться таблица (после загрузки данных из сети), в которой содержатся новости. В ячейке должно быть название новости и дата публикации. Внешний вид на ваше усмотрение.

Для получения новостей изучите api: https://docs.kudago.com/api/#page:новости,header:новости-список-новостей/api/#page:новости,header:новости-список-новостей

Подробности в файле ["Домашнее задание"](https://gbcdn.mrgcdn.ru/uploads/asset/5384936/attachment/9c035b53a2e82726941b71057cf1cb7f.pdf)

---

***Результат выполнения Домашней работы:***

Часть 1: Доработки UIKit приложения (VK API)

1.1. Добавление кнопки перехода и экрана профиля

```
import UIKit

// 1. Экран бесед/чатов
class ConversationsViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Беседы"
        
        // Добавляем кнопку в Navigation Bar
        let profileButton = UIBarButtonItem(
            image: UIImage(systemName: "person.crop.circle"),
            style: .plain,
            target: self,
            action: #selector(profileButtonTapped)
        )
        navigationItem.rightBarButtonItem = profileButton
    }
    
    @objc private func profileButtonTapped() {
        let profileVC = ProfileViewController()
        
        // Устанавливаем кастомный делегат анимации перехода
        profileVC.transitioningDelegate = self
        profileVC.modalPresentationStyle = .custom
        
        present(profileVC, animated: true)
    }
}

// 2. Экран профиля
class ProfileViewController: UIViewController {
    private let avatarImageView = UIImageView()
    private let nameLabel = UILabel()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .systemBackground
        setupUI()
        fetchProfileData()
    }
    
    private func setupUI() {
        avatarImageView.translatesAutoresizingMaskIntoConstraints = false
        avatarImageView.contentMode = .scaleAspectFill
        avatarImageView.layer.cornerRadius = 60
        avatarImageView.clipsToBounds = true
        avatarImageView.backgroundColor = .systemGray5
        
        nameLabel.translatesAutoresizingMaskIntoConstraints = false
        nameLabel.font = .systemFont(ofSize: 22, weight: .bold)
        nameLabel.textAlignment = .center
        
        view.addSubview(avatarImageView)
        view.addSubview(nameLabel)
        
        NSLayoutConstraint.activate([
            avatarImageView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 40),
            avatarImageView.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            avatarImageView.widthAnchor.constraint(equalToConstant: 120),
            avatarImageView.heightAnchor.constraint(equalToConstant: 120),
            
            nameLabel.topAnchor.constraint(equalTo: avatarImageView.bottomAnchor, constant: 20),
            nameLabel.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 20),
            nameLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -20)
        ])
    }
    
    private func fetchProfileData() {
        // Запрос к VK API для получения имени и фото текущего пользователя
        VKNetworkService.shared.makeRequest(method: "users.get", parameters: ["fields": "photo_200"]) { [weak self] data in
            guard let data = data else { return }
            // Ниже схематичный парсинг структуры JSON VK
            if let json = try? JSONSerialization.jsonObject(with: data) as? [String: Any],
               let response = json["response"] as? [[String: Any]], let user = response.first {
                
                let firstName = user["first_name"] as? String ?? ""
                let lastName = user["last_name"] as? String ?? ""
                let photoUrl = user["photo_200"] as? String ?? ""
                
                DispatchQueue.main.async {
                    self?.nameLabel.text = "\(firstName) \(lastName)"
                    self?.loadAvatar(from: photoUrl)
                }
            }
        }
    }
    
    private func loadAvatar(from urlString: String) {
        guard let url = URL(string: urlString) else { return }
        URLSession.shared.dataTask(with: url) { data, _, _ in
            if let data = data {
                DispatchQueue.main.async { self.avatarImageView.image = UIImage(data: data) }
            }
        }.resume()
    }
}
```

1.2. Кастомная анимация перехода (Custom Transition)
   - Реализация аниматора перехода от текущего контекста к экрану профиля.

```
// Аниматор кастомного перехода
class ProfileTransitionAnimator: NSObject, UIViewControllerAnimatedTransitioning {
    let isPresenting: Bool
    
    init(isPresenting: Bool) {
        self.isPresenting = isPresenting
    }
    
    func transitionDuration(using transitionContext: UIViewControllerContextTransitioning?) -> TimeInterval {
        return 0.5
    }
    
    func animateTransition(using transitionContext: UIViewControllerContextTransitioning) {
        guard let toVC = transitionContext.viewController(forKey: .to),
              let fromVC = transitionContext.viewController(forKey: .from) else { return }
        
        let containerView = transitionContext.containerView
        
        if isPresenting {
            containerView.addSubview(toVC.view)
            toVC.view.frame = containerView.bounds
            toVC.view.transform = CGAffineTransform(translationX: 0, y: containerView.frame.height)
            toVC.view.alpha = 0
            
            UIView.animate(withDuration: transitionDuration(using: transitionContext), delay: 0, dampingRatio: 0.8, initialVelocity: 0, options: [], animations: {
                toVC.view.transform = .identity
                toVC.view.alpha = 1
            }) { finished in
                transitionContext.completeTransition(finished)
            }
        } else {
            UIView.animate(withDuration: transitionDuration(using: transitionContext), animations: {
                fromVC.view.transform = CGAffineTransform(translationX: 0, y: containerView.frame.height)
                fromVC.view.alpha = 0
            }) { finished in
                fromVC.view.removeFromSuperview()
                transitionContext.completeTransition(finished)
            }
        }
    }
}

// Расширяем первый контроллер для поддержки делегата анимации
extension ConversationsViewController: UIViewControllerTransitioningDelegate {
    func animationController(forPresented presented: UIViewController, presenting: UIViewController, source: UIViewController) -> UIViewControllerAnimatedTransitioning? {
        return ProfileTransitionAnimator(isPresenting: true)
    }
    
    func animationController(forDismissed dismissed: UIViewController) -> UIViewControllerAnimatedTransitioning? {
        return ProfileTransitionAnimator(isPresenting: false)
    }
}
```

Часть 2: Новый проект на SwiftUI (KudaGo API)

2.1. Модели данных и два экрана приложения
- Реализуем модели структуры JSON для KudaGo API, сетевой слой и представление экранов.

```
import SwiftUI

// 1. Модели данных для KudaGo API Новости
struct KudaGoNewsResponse: Codable {
    let results: [NewsItem]
}

struct NewsItem: Codable, Identifiable {
    let id: Int
    let title: String
    let publicationDate: Double
    
    enum CodingKeys: String, CodingKey {
        case id, title
        case publicationDate = "publication_date"
    }
    
    // Форматированная дата для отображения в ячейке
    var formattedDate: String {
        let date = Date(timeIntervalSince1970: publicationDate)
        let formatter = DateFormatter()
        formatter.dateFormat = "dd.MM.yyyy"
        return formatter.string(from: date)
    }
}

// 2. ViewModel для загрузки данных по сети
class NewsViewModel: ObservableObject {
    @Published var news: [NewsItem] = []
    
    func fetchNews() {
        guard let url = URL(string: "https://kudago.com") else { return }
        
        URLSession.shared.dataTask(with: url) { data, _, error in
            if let data = data {
                do {
                    let decodedData = try JSONDecoder().decode(KudaGoNewsResponse.self, from: data)
                    DispatchQueue.main.async {
                        self.news = decodedData.results
                    }
                } catch {
                    print("Ошибка декодирования: \(error)")
                }
            }
        }.resume()
    }
}

// 3. Главный Контейнер (Точка входа)
@main
struct KudaGoNewsApp: App {
    var body: some Scene {
        WindowGroup {
            FirstView()
        }
    }
}

// 4. Первый экран (Кнопка для перехода)
struct FirstView: View {
    var body: some View {
        NavigationView {
            VStack(spacing: 20) {
                Text("Добро пожаловать в Новостной Портал!")
                    .font(.title)
                    .multilineTextAlignment(.center)
                    .padding()
                
                NavigationLink(destination: NewsListView()) {
                    Text("Читать новости")
                        .font(.headline)
                        .foregroundColor(.white)
                        .padding()
                        .frame(maxWidth: .infinity)
                        .background(Color.blue)
                        .cornerRadius(10)
                        .padding(.horizontal, 40)
                }
            }
            .navigationTitle("Главная")
        }
    }
}

// 5. Второй экран (Список новостей из сети)
struct NewsListView: View {
    @StateObject private var viewModel = NewsViewModel()
    
    var body: some View {
        List(viewModel.news) { item in
            VStack(alignment: .leading, spacing: 5) {
                Text(item.title)
                    .font(.headline)
                    .lineLimit(2)
                
                Text(item.formattedDate)
                    .font(.subheadline)
                    .foregroundColor(.secondary)
            }
            .padding(.vertical, 4)
        }
        .navigationTitle("Новости KudaGo")
        .onAppear {
            viewModel.fetchNews()
        }
    }
}
```

