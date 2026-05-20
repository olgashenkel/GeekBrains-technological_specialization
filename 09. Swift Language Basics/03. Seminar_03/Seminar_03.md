
# Урок 6. Семинар: Коллекции и замыкания

## План урока

- Получаем задание 
- Выполняем задание определенное время
- Проверяем правильность выполнения
- Переходим к новому заданию


## Домашняя работа ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/09.%20Swift%20Language%20Basics/03.%20Seminar_03/homework.md))



## Практическая работа с семинара

### Задание 1.

Создать перечисление, которое имеет в виде кейсов три вида чая: зеленый, черный и фруктовый. Затем создать словарь, в котором ключ - это вид чая, а значение  - это стоимость. Заполнить этот словарь.


***Результат выполнения Задания № 1:***
```
enum TeaType {
    case green
    case black
    case fruit
}

var teaPrices: [TeaType: Double] = [
    .green: 30.0,
    .black: 10.0,
    .fruit: 50.0
]

if let greenTeaPrice = teaPrices[.green] {
    print("Стоимость зеленого чая: \(greenTeaPrice) руб.")
}
```



### Задание 2.

Написать функцию, которая на вход принимает такой же словарь, как в задании № 1, а возвращает новый, который создан по следующим правилам: у фруктового чая стоимость должна быть увеличена на 30%, у черного уменьшена в 1.6 раза, а у зеленого уменьшена на 9.5%.


***Результат выполнения Задания № 2:***
```
func updateTeaPrices(sourcePrices: [TeaType: Double]) -> [TeaType: Double] {
    var updatedPrices = sourcePrices
    
    if let fruitPrice = updatedPrices[.fruit] {
        updatedPrices[.fruit] = fruitPrice * 1.3
    }
    
    if let blackPrice = updatedPrices[.black] {
        updatedPrices[.black] = blackPrice / 1.6
    }
    
    if let greenPrice = updatedPrices[.green] {
        updatedPrices[.green] = greenPrice * 0.905
    }
    
    return updatedPrices
}

let newPrices = updateTeaPrices(sourcePrices: teaPrices)
print(newPrices)
```


### Задание 3.

Написать функцию, которая на вход принимает два целочисленных массива, которые содержат координаты начала и конца отрезка соответственно. Первый элемент массива это `x`, а второй - `y`. Функция должная вернуть массив, который содержит координаты середины отрезка.

***Результат выполнения Задания № 3:***
```
func findMiddlePoint(start: [Int], end: [Int]) -> [Double] {
    guard start.count == 2, end.count == 2 else {
        return []
    }
    

    let midX = Double(start[0] + end[0]) / 2.0
    let midY = Double(start[1] + end[1]) / 2.0
    
    return [midX, midY]
}

let pointA = [1, 2] // x1 = 1, y1 = 2
let pointB = [4, 6] // x2 = 4, y2 = 6

let middle = findMiddlePoint(start: pointA, end: pointB)
print(middle)
```


### Задание 4.

Написать функцию, которая на вход принимает массив из 4 целых чисел (если чисел меньше или больше должно вернуться nil). Функция возвращает новый массив, который состоит из 3-х элементов: 
- первый элемент - это первый элемент переданного массива, 
- второй элемент - это сумма второго и третьего элемента (индексы 1 и 2) переданного массива, последний элемент - это последний элемент переданного массива. Также этот массив должен быть отсортирован по убыванию.

***Результат выполнения Задания № 4:***
```
func transformAndSortArray(_ input: [Int]) -> [Int]? {
    // 1. Проверяем, что в массиве ровно 4 элемента. Если нет — возвращаем nil.
    guard input.count == 4 else {
        return nil
    }
    
    // 2. Создаем новый массив по заданным правилам
    let first = input[0]
    let middleSum = input[1] + input[2]
    let last = input[3]
    
    let newArray = [first, middleSum, last]
    
    // 3. Сортируем полученный массив по убыванию и возвращаем его
    return newArray.sorted(by: >)
}

// Примеры использования:
if let result1 = transformAndSortArray([10, 5, 3, 1]) {
    print(result1) // Выведет: [10, 8, 1] (так как элементы 10, 8, 1 отсортированы по убыванию)
}

let result2 = transformAndSortArray([1, 2, 3])
print(result2) // Выведет: nil (массив слишком короткий)
```

### Задание 5.

Создайте массив, который состоит из всех целых чисел от 1 до 50.

***Результат выполнения Задания № 5:***
```
var a = Array(1...50)
```

### Задание 6.

Напишите замыкание, которое принимает на вход два целых числа и возвращает их сумму, затем вызовите это замыкание.

***Результат выполнения Задания № 6:***
```
let sumClosure: (Int, Int) -> Int = { (a: Int, b: Int) -> Int in
    return a + b
}

let result = sumClosure(5, 7)
print("Результат сложения: \(result)") 
```


### Задание 7.

Напишите функцию, которая на вход будет принимать замыкание, которое на вход принимает целое число, но ничего не возвращает. Функция также не должная ничего возвращать. Внутри функции должен печататься тип замыкания.

***Результат выполнения Задания № 7:***
```
func printClosureType(action: (Int) -> Void) {
    print("Тип переданного замыкания: \(type(of: action))")
}

let myClosure: (Int) -> Void = { number in
    print("Получено число: \(number)")
}

printClosureType(action: myClosure)
```


### Задание 8.

Создать массив и при помощи forEach вывести в консоль все значения.

***Результат выполнения Задания № 7:***
```
var a = [5, 6, 7]
a.forEach { print($0) }
```

