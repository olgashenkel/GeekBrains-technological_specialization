
# Урок 10. Семинар: Протоколы, классы и расширения


## Домашняя работа

1. В рамках прошлого дз был создан класс пиццерии с переменной, в которой хранится пицца, удалите ее. Необходимо создать структуру картошки фри, в которой будет стоимость и размер картошки и сделать так, чтобы в классе пиццерии была одна переменная, в которую можно было бы класть и пиццу, и картошку фри.

2. Добавьте в класс пиццерии функцию, которая будет добавлять новую позицию в меню.

3. Создайте протокол, в котором будут содержаться функции открытия и закрытия.

4. Написать расширение для класса пиццерии, в котором будет реализован протокол из пункта 3.

5. Написать функцию, в которой происходит вычитание одного числа из другого. Функция должна работать и с `Int`, и с `Double`. Функция должна возвращать результат вычитания.


***Результат выполнения Домашней работы:***
```
import Foundation

// 3. Протокол для управления состоянием пиццерии
protocol PizzeriaLifecycle {
    func open()
    func close()
}

// Протокол-родитель для всех позиций в меню пиццерии
protocol MenuPosition {
    var name: String { get }
    var cost: Double { get }
}

// Структура Пиццы (из прошлого ДЗ)
struct Pizza: MenuPosition {
    enum PizzaType: String {
        case margarita = "Маргарита"
        case pepperoni = "Пепперони"
        case fourCheese = "Четыре сыра"
    }
    
    let type: PizzaType
    let cost: Double
    let isThickCrust: Bool
    
    var name: String { return "Пицца \(type.rawValue)" }
}

// 1. Структура Картошки Фри
struct FrenchFries: MenuPosition {
    enum Size: String {
        case small = "Маленькая"
        case medium = "Средняя"
        case large = "Большая"
    }
    
    let size: Size
    let cost: Double
    
    var name: String { return "Картошка фри (\(size.rawValue))" }
}

// 1. Обновленный класс Пиццерии
class Pizzeria {
    // Единый массив, куда можно класть и Pizza, и FrenchFries
    private var menu: [MenuPosition]
    
    init(initialMenu: [MenuPosition] = []) {
        self.menu = initialMenu
    }
    
    // 2. Функция для добавления новой позиции (и пиццы, и картошки) в меню
    func addPosition(_ newPosition: MenuPosition) {
        menu.append(newPosition)
    }
    
    // Вспомогательный метод для просмотра всего меню
    func printMenu() {
        print("--- Меню пиццерии ---")
        for item in menu {
            print("\(item.name) — \(item.cost) руб.")
        }
    }
}

// 4. Расширение для класса пиццерии с реализацией протокола открытия/закрытия
extension Pizzeria: PizzeriaLifecycle {
    func open() {
        print("Пиццерия открыта! Ждем вас за вкусной пиццей и фри.")
    }
    
    func close() {
        print("Пиццерия закрыта. До новых встреч!")
    }
}


// 5. Функция вычитания для любых числовых типов
func subtract<T: Numeric>(_ firstNumber: T, _ secondNumber: T) -> T {
    return firstNumber - secondNumber
}


// --- Тест пиццерии ---
let myPizzeria = Pizzeria()

// Проверяем работу протокола из расширения
myPizzeria.open()

// Создаем разные позиции меню
let pepperoniPizza = Pizza(type: .pepperoni, cost: 550.0, isThickCrust: false)
let largeFries = FrenchFries(size: .large, cost: 150.0)

// Добавляем их в одну и ту же переменную (массив menu) через функцию
myPizzeria.addPosition(pepperoniPizza)
myPizzeria.addPosition(largeFries)

// Смотрим результат
myPizzeria.printMenu()
myPizzeria.close()

print("\n-----------------------\n")

// --- Тест функции вычитания ---
// Работа с Int
let intResult = subtract(10, 4)
print("Результат Int: \(intResult)") // Выведет: 6

// Работа с Double
let doubleResult = subtract(15.5, 3.2)
print("Результат Double: \(doubleResult)") // Выведет: 12.3
```
