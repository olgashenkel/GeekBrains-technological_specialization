
# Урок 8. Семинар: Классы и структуры


## Домашняя работа

1. Создать перечисление с видами пиццы (хотя бы 4 - 5 кейсов)

2. Создать структуру пиццы, она должна содержать стоимость, вид пиццы, толстое или тонкое тесто и добавки (например, дополнительно добавить пепперони, помидоры, сыр). Вид пиццы должен быть вложенным типом для структуры пиццы. Подсказка: добавки лучше также сделать перечислением.

3. Создать класс пиццерии, добавить массив с возможными пиццами. Переменная с массивом должна быть приватной. Массив задается в инициализаторе.

4. Написать в классе пиццерии функции для добавления новой пиццы и для получения всех доступных пицц.

5. Создать экземпляр класса пиццерии и добавить в него несколько пицц.

***Результат выполнения Домашней работы:***

```
// Структура Пиццы со вложенными типами
struct Pizza {
    // Вложенное перечисление с видами пиццы
    enum PizzaType {
        case margarita
        case pepperoni
        case fourCheese
        case hawaiian
        case vegetarian
    }
    
    // Вложенное перечисление с добавками
    enum Topping {
        case extraCheese
        case tomatoes
        case pepperoni
        case mushrooms
        case jalapeno
    }
    
    // Свойства структуры
    let type: PizzaType
    let cost: Double
    let isThickCrust: Bool // true — толстое тесто, false — тонкое
    let toppings: [Topping]
}

// Класс Пиццерии
class Pizzeria {
    // Приватный массив пицц, недоступный для изменения извне напрямую
    private var pizzas: [Pizza]
    
    // Инициализатор для заполнения начального ассортимента
    init(pizzas: [Pizza]) {
        self.pizzas = pizzas
    }
    
    // Функция для добавления новой пиццы
    func addPizza(_ newPizza: Pizza) {
        pizzas.append(newPizza)
    }
    
    // Функция для получения всех доступных пицц
    func getAllPizzas() -> [Pizza] {
        return pizzas
    }
}

// Создание экземпляра пиццерии и добавление пицц

// Создаем начальный список пицц
let initialMenu = [
    Pizza(type: .margarita, cost: 450.0, isThickCrust: false, toppings: [.tomatoes]),
    Pizza(type: .pepperoni, cost: 550.0, isThickCrust: true, toppings: [.extraCheese])
]

// Инициализируем пиццерию
let myPizzeria = Pizzeria(pizzas: initialMenu)

// Создаем и добавляем новые пиццы через функцию
let hawaiianPizza = Pizza(type: .hawaiian, cost: 600.0, isThickCrust: false, toppings: [])
let customFourCheese = Pizza(type: .fourCheese, cost: 650.0, isThickCrust: true, toppings: [.extraCheese, .jalapeno])

myPizzeria.addPizza(hawaiianPizza)
myPizzeria.addPizza(customFourCheese)

// Проверяем результат: получаем все пиццы из пиццерии
let currentMenu = myPizzeria.getAllPizzas()
print("В пиццерии сейчас доступно видов пиццы: \(currentMenu.count)")
```

