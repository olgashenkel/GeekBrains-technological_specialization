# Урок 12. Семинар: ARC и управление памятью


## Домашняя работа + Промежуточная аттестация

1. Создать структуру работника пиццерии. В ней должны быть такие свойства, как имя, зарплата и должность. Должностей пока может быть две: или кассир, или повар. Добавить в класс пиццерии массив с работниками

2. Создать класс столика, в нем должны быть свойство, в котором содержится количество мест и функция, которая на вход принимает количество гостей, которое хотят посадить, а возвращает `true`, если места хватает и `false`, если места не хватает. Изначальное количество мест задается в инициализаторе

3. Добавить в класс пиццерии свойство, в котором хранится массив столиков. У класса столика добавить свойство, в котором хранится пиццерия, в которой стоит столик. Столики создаются сразу в инициализаторе, не передаются туда в качестве параметра



***Результат выполнения Домашней работы:***
```
import Foundation

// 1. Структура работника пиццерии
struct PizzeriaEmployee {
    enum Position {
        case cashier // Кассир
        case baker   // Повар
    }
    
    let name: String
    let salary: Double
    let position: Position
}

// 2. Класс столика
class Table {
    let capacity: Int 
    
    weak var pizzeria: Pizzeria?
    
    init(capacity: Int, pizzeria: Pizzeria) {
        self.capacity = capacity
        self.pizzeria = pizzeria
    }
    
    func canSeat(guestsCount: Int) -> Bool {
        return guestsCount <= capacity
    }
}

protocol MenuPosition {
    var name: String { get }
    var cost: Double { get }
}

class Pizzeria {
    private var menu: [MenuPosition]
    
    var employees: [PizzeriaEmployee] = []
    
    var tables: [Table] = []
    
    init(initialMenu: [MenuPosition] = []) {
        self.menu = initialMenu
        
        self.tables = [
            Table(capacity: 2, pizzeria: self),
            Table(capacity: 4, pizzeria: self),
            Table(capacity: 4, pizzeria: self),
            Table(capacity: 8, pizzeria: self)
        ]
    }
    
    func addEmployee(_ employee: PizzeriaEmployee) {
        employees.append(employee)
    }
    
    func addPosition(_ newPosition: MenuPosition) {
        menu.append(newPosition)
    }
}
```

