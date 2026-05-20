
# Урок 10. Семинар: Протоколы, классы и расширения

## План урока

- Получаем задание 
- Выполняем задание определенное время
- Проверяем правильность выполнения
- Переходим к новому заданию


## Домашняя работа ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/09.%20Swift%20Language%20Basics/05.%20Seminar_05/homework.md))




## Практическая работа с семинара


### Задачи:

1. Создать две структуры: лимонад и салат. Сделать так, чтобы и то и то можно добавить в меню кафе.
2. Добавить в класс кафе функцию, которая возвращает все позиции
меню
3. Добавить в класс кафе функцию, которая на основе цены
возвращает массив позиции которые можно купить (Например, есть черный чай за 50, зеленый за 60, лимонад за 100 и салат за 150. Функция получает 90, значит она должна вернуть черный чай и зеленый чай)
4. Задать переменной с меню в классе `Cafe` уровень `fileprivate` 
5. Добавить в класс автомата с едой функцию, которая на основе полученного номера (номер элемента в массиве) и денег возвращает товар под необходимым номером, если денег хватает и `nil`, если денег не хватает. Если товар не найден, тоже вернуть `піl` 
6. Создать протокол, в котором будет содержаться две функции: `start` и `final`.
7. Для класса автомата с едой создать расширение, в котором будут содержаться функции из протокола из пункта 6 (класс должен быть подписан на протокол). В функции `start` должно печататься о начале работы автомата, а в `final` о завершении.



***Результат выполнения Практической работы:***

```
import Foundation

// 6. Протокол для управления жизненным циклом автомата
protocol VendingMachineLifecycle {
    func start()
    func final()
}

// 1. Протокол для всех позиций меню, чтобы их можно было объединить в один массив
protocol MenuItem {
    var name: String { get }
    func getCost() -> Double
}

// Переиспользуем структуру Tea из первого задания, подписав её на протокол MenuItem
struct Tea: MenuItem {
    enum TeaType: String {
        case black = "Черный чай"
        case green = "Зеленый чай"
        case fruit = "Фруктовый чай"
    }
    let type: TeaType
    private let cost: Double
    
    var name: String { return type.rawValue }
    
    init(type: TeaType, cost: Double) {
        self.type = type
        self.cost = cost
    }
    
    func getCost() -> Double {
        return self.cost
    }
}

// 1. Структура Лимонад
struct Lemonade: MenuItem {
    let name: String
    private let cost: Double
    
    init(name: String, cost: Double) {
        self.name = name
        self.cost = cost
    }
    
    func getCost() -> Double {
        return self.cost
    }
}

// 1. Структура Салат
struct Salad: MenuItem {
    let name: String
    private let cost: Double
    
    init(name: String, cost: Double) {
        self.name = name
        self.cost = cost
    }
    
    func getCost() -> Double {
        return self.cost
    }
}

// Класс Кафе с обновленным меню
class Cafe {
    // 4. Переменная с меню имеет уровень доступа fileprivate (доступна в рамках этого файла)
    fileprivate var menu: [MenuItem] = [
        Tea(type: .black, cost: 50.0),
        Tea(type: .green, cost: 60.0),
        Lemonade(name: "Домашний лимонад", cost: 100.0),
        Salad(name: "Цезарь", cost: 150.0)
    ]
    
    // 2. Функция, которая возвращает все позиции меню
    func getAllItems() -> [MenuItem] {
        return menu
    }
    
    // 3. Функция возвращает массив позиций, стоимость которых не превышает указанную сумму
    func getAffordableItems(for budget: Double) -> [MenuItem] {
        return menu.filter { $0.getCost() <= budget }
    }
}

// 5. Класс автомата с едой
class FoodVendingMachine {
    // Автомат может содержать товары из меню кафе
    private var items: [MenuItem]
    
    init(items: [MenuItem]) {
        self.items = items
    }
    
    // 5. Функция выдачи товара по номеру (индексу) и сумме денег
    func purchaseItem(at index: Int, with money: Double) -> MenuItem? {
        // Проверяем, существует ли товар под таким индексом
        guard index >= 0 && index < items.count else {
            print("Товар под номером \(index) не найден.")
            return nil
        }
        
        let item = items[index]
        
        // Проверяем, хватает ли денег
        if money >= item.getCost() {
            return item
        } else {
            print("Недостаточно средств для покупки \(item.name).")
            return nil
        }
    }
}

// 7. Расширение для автомата, реализующее протокол VendingMachineLifecycle
extension FoodVendingMachine: VendingMachineLifecycle {
    func start() {
        print("Автомат с едой запущен и готов к работе.")
    }
    
    func final() {
        print("Работа автомата завершена. Спасибо за покупку!")
    }
}

// --- Проверка работы кода ---

let myCafe = Cafe()
let machine = FoodVendingMachine(items: myCafe.getAllItems())

// Демонстрация работы протокола жизненного цикла (Пункт 7)
machine.start()

// Проверка фильтрации по бюджету (Пункт 3)
let budget = 90.0
let affordable = myCafe.getAffordableItems(for: budget)
print("\nНа сумму \(budget) можно купить:")
affordable.forEach { print("- \($0.name) (\($0.getCost()) руб.)") }

// Проверка покупки в автомате (Пункт 5)
print("\nПопытка купить товар №1 (Зеленый чай) за 100 рублей:")
if let boughtItem = machine.purchaseItem(at: 1, with: 100.0) {
    print("Успешно куплено: \(boughtItem.name)")
}

machine.final()
```