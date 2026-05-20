
# Урок 8. Семинар: Классы и структуры

## План урока

- Получаем задание 
- Выполняем задание определенное время
- Проверяем правильность выполнения
- Переходим к новому заданию



## Домашняя работа ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/09.%20Swift%20Language%20Basics/04.%20Seminar_04/homework.md))



## Практическая работа с семинара


### Задачи:


1. Сделать тип чая вложенным типом для структуры чая.
2. Сделать так, чтобы в структуре чая можно было получить стоимость только через функцию getCost, то есть чтобы извне функции не было доступа к переменной со стоимостью чая.
3. Создать класс `Person`, внутри которого должна быть структура `Activity`, внутри которой должно быть перечисление `TypeOfActivity` (тип активности) с тремя кейсами: `pupil`, `student`, `employee`. Создать переменную и явно указать ей тип `“тип активности”`.
4. Добавить в класс `Cafe` функцию, которая на основе типа активности, предложенной суммы и возможной скидки возвращает доступный чая. Чай выбирается по следующим критериям: если это `pupil`, то доступен и черный, и зеленый, и фруктовый чай. Если это `student`, то только черный, а если `employee`, то черный и фруктовый. Если предложенной суммы хватает на все доступные виды чая, то вернуть самый дорогой. Если суммы хватает только на один, то вернуть его. Если суммы хватает на несколько доступных  видов чая, но у них одинаковая стоимость, то вернуть любой из них. Если суммы не хватает ни на один вид чая, то вернуть `nil`.


***Результат выполнения Практической работы:***

```
// Структура чая с вложенным типом и инкапсуляцией стоимости
struct Tea {
    // Вложенный тип чая
    enum TeaType {
        case black
        case green
        case fruit
    }
    
    let type: TeaType
    
    // Приватное свойство, недоступное снаружи структуры
    private let cost: Double
    
    init(type: TeaType, cost: Double) {
        self.type = type
        self.cost = cost
    }
    
    // Публичный метод для получения стоимости
    func getCost() -> Double {
        return self.cost
    }
}

// Класс Person со вложенными структурами и перечислениями
class Person {
    struct Activity {
        enum TypeOfActivity {
            case pupil
            case student
            case employee
        }
    }
}

// Создание переменной с явным указанием вложенного типа "тип активности"
let currentActivity: Person.Activity.TypeOfActivity = .student

// Класс Cafe с логикой подбора чая
class Cafe {
    // Меню доступного в кафе чая
    let menu: [Tea] = [
        Tea(type: .black, cost: 100.0),
        Tea(type: .green, cost: 120.0),
        Tea(type: .fruit, cost: 150.0)
    ]
    
    func chooseTea(for activity: Person.Activity.TypeOfActivity, money: Double, discount: Double = 0.0) -> Tea? {
        // Расчет доступного бюджета с учетом скидки (например, discount = 20.0 означает скидку в 20 денежных единиц)
        let budget = money + discount
        
        // 1. Фильтрация меню по типу активности
        let allowedTeas: [Tea]
        switch activity {
        case .pupil:
            allowedTeas = menu // Доступны все виды
        case .student:
            allowedTeas = menu.filter { $0.type == .black } // Только черный
        case .employee:
            allowedTeas = menu.filter { $0.type == .black || $0.type == .fruit } // Черный и фруктовый
        }
        
        // 2. Фильтрация по бюджету (сколько хватает денег)
        let affordableTeas = allowedTeas.filter { $0.getCost() <= budget }
        
        // 3. Выбор чая на основе условий (возвращаем самый дорогой из доступных по карману)
        // Сортируем по убыванию цены. Самый дорогой окажется первым.
        let sortedTeas = affordableTeas.sorted { $0.getCost() > $1.getCost() }
        
        return sortedTeas.first
    }
}
```
