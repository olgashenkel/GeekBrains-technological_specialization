
# Урок  4. Семинар: Функции, опционалы, перечисления

## План урока

- Получаем задание 
- Выполняем задание определенное время
- Проверяем правильность выполнения
- Переходим к новому заданию


## Домашняя работа ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/09.%20Swift%20Language%20Basics/02.%20Seminar_02/homework.md))


## Практическая работа с семинара


### Задание 1.

Задачи:
1. Создать перечисление, которое имеет в виде кейсов два вида чая: `зеленый` и `черный`
2. Задать для кейсов названия `“Black tea”` и `“Green tea”`
3. Написать внутри перечисления функцию, которая будет возвращать цвет чая в строковом формате, то есть, если это `blackTea`, то `black`, а если `greenTea`, то `green`
4. Создать переменную с типом созданного перечисления, а затем при помощи `print` вывести цвет чая
5. Написать функцию, которая на вход принимает параметр типа `Tea`, но который является опционалом. Функция должна печатать название чая, если значение есть и `“Данный вид чая не найден”`, если значение `nil`. Написать функцию нужно в 2 вариантах: используя `guard let`, используя `if let`.



***Результат выполнения Задания № 1:***
```
enum Tea: String {
  case BlackTea = "Black tea"
  case GreenTea = "Green tea"

  func printTea () -> String {
    switch self {
      case .BlackTea:
        return "black"
      case .GreenTea:
        return "green"
    }
  }
}

// 1. Работа с enum
var colorTea: Tea
colorTea = .BlackTea
print(colorTea)
print(colorTea.rawValue)

colorTea = Tea.GreenTea
print(colorTea)
print(colorTea.rawValue)

// 2. функция if let
func checkTeaIfLet(tea: Tea?) {
    if let tea = tea {
        print(tea.rawValue)
    } else {
        print("Данный вид чая не найден")
    }
}

// 3. функция guard
func checkTeaGuard(tea: Tea?) {
    guard let tea = tea else {
        print("Данный вид чая не найден")
        return
    }
    print(tea.rawValue)
}

// Проверка функций
checkTeaGuard(tea: .GreenTea) 
checkTeaIfLet(tea: .BlackTea)

checkTeaGuard(tea: nil) 
checkTeaIfLet(tea: nil)
```


### Задание 2.

Задачи: 
1. Написать функцию, которая на вход принимает число типа `Int`, а возвращает, является ли число четным
2. Написать функцию, которая на вход принимает 3 числа: `a, b, c` и возвращает результат вычисления `b^2 - 4 * a * c`
3. Написать функцию, которая рассчитает площадь прямоугольника. На вход два параметра: `длина и ширина`, на выход: `площадь`
4. Напишите функции, которая на вход принимает целое положительное число, а возвращает сумму всех чисел от 1 до переданного числа
5. Создать опционал с типом `Int` и создать еще одну переменную, которая содержит значение первой переменной, но не является опционалом. Сделать это необходимо 2 способами: при помощи `force unwrapping`,  `nil coalescing`



***Результат выполнения Задания № 2:***
```
// Задание № 1 (Проверка на четность)
 func isEven(_ number: Int) -> Bool {
    return number % 2 == 0
}
print(isEven(5))


// Задание № 2 (Вычисление дискриминанта)
func calculateDiscriminant(a: Double, b: Double, c: Double) -> Double {
    return b * b - 4 * a * c
}
print(calculateDiscriminant(a: 3.2, b: 4.1, c: 5.3))


// Задание № 3 (Площадь прямоугольника)
func rectangleArea(width: Double, height: Double) -> Double {
    return width * height
}
print(rectangleArea(width: 2.2, height: 1.8))

// Задание № 4 (Сумма чисел от 1 до N)
func sumUpTo(_ n: Int) -> Int {
    return n * (n + 1) / 2
}
print(sumUpTo(10))


// Задание № 5 (Работа с Optional)
let optionalValue: Int? = 10

// Способ 1: Force unwrapping 
let forcedValue: Int = optionalValue!

// Способ 2: Nil coalescing 
let coalescedValue: Int = optionalValue ?? 0
```
