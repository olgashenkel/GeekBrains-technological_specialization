
# Урок  4. Семинар: Функции, опционалы, перечисления

## Домашняя работа

1. Написать функцию, которая на вход принимает число: сумма, которую пользователь хочет положить на вклад, следующий аргумент это годовой процент, третий аргумент это срок Функция возвращает сколько денег получит пользователь по итогу.

2. Создать перечисление, которое содержит 3 вида пиццы и создать переменные с каждым видом пиццы.

3. Добавить возможность получения названия пиццы через rawValue


***Результат выполнения Домашней работы:***
```
//Задание № 1
func calculateYield(amount: Double, annualRate: Double, years: Int) -> Double {
    let profit = amount * (annualRate / 100) * Double(years)
    return amount + profit
}

// Пример: 
let finalAmount = 120000.0
print("Итого: \(finalAmount.formatted(.currency(code: "RUB")))") 


//Задание № 2

enum PizzaType: String {
    case margherita = "Маргарита"
    case pepperoni = "Пепперони"
    case fourCheese = "Четыре сыра"
}

// Создание переменных с каждым видом
let firstPizza = PizzaType.margherita
let secondPizza = PizzaType.pepperoni
let thirdPizza = PizzaType.fourCheese

//Задание № 3
// Получение названия через rawValue
print("Вы выбрали: \(thirdPizza.rawValue)") 
```