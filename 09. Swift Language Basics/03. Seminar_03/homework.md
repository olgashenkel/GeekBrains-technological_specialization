
# Урок 6. Семинар: Коллекции и замыкания


## Домашняя работа

1. Есть словарь с видами чая и их стоимостью. Есть очередь людей, которые хотят заказать чай (можно представить её в виде массива видов чая, которые хотят заказать).
Необходимо последовательно выводить в консоль сколько заплатит покупатель (необходимо вывести его номер по порядку, чай, который он заказал, и стоимость).

2. Есть массив [-4, 5, 10, nil, 4, nil, 25, 0, nil, 16, 75, -20, -7, 15, 0, nil].
Необходимо создать новый массив, который будет состоять из элементов старого, но не должно быть nil, не должно быть 0 и 4, а также массив должен быть отсортирован по возрастанию.

3. Написать функцию, которая на вход принимает целое число, а возвращает массив, который сформирован по следующим правилам: количество элементов соответствует переданному числу, массив начинается с 1, каждый последующий элемент больше предыдущего в 2 раза.


***Результат выполнения Домашней работы:***
```
// ****************** Задание № 1 ******************

enum TeaType {
    case green
    case black
    case fruit
}

let teaPrices: [TeaType: Double] = [
    .green: 30.0,
    .black: 40.0,
    .fruit: 50.0
]

let queue: [TeaType] = [.black, .fruit, .green, .black]

func processTeaQueue(queue: [TeaType], prices: [TeaType: Double]) {
    for (index, tea) in queue.enumerated() {
        let buyerNumber = index + 1 
        
        if let price = prices[tea] {
            print("Покупатель № \(buyerNumber) заказал \(tea), стоимость: \(price) руб.")
        } else {
            print("Покупатель №\(buyerNumber): К сожалению, такого чая нет в меню.")
        }
    }
}

processTeaQueue(queue: queue, prices: teaPrices)
```

```
// ****************** Задание № 2 ******************

let sourceArray: [Int?] = [-4, 5, 10, nil, 4, nil, 25, 0, nil, 16, 75, -20, -7, 15, 0, nil]

let filteredAndSortedArray = sourceArray
    .compactMap { $0 } 
    .filter { $0 != 0 && $0 != 4 } 
    .sorted() 

print(filteredAndSortedArray)
```

```
// ****************** Задание № 3 ******************

func generateDoubleSequence(count: Int) -> [Int] {
    guard count > 0 else { return [] }
    
    var result = [1] 
    
    for _ in 1..<count {
        if let lastElement = result.last {
            result.append(lastElement * 2)
        }
    }    
    return result
}

print(generateDoubleSequence(count: 5))  
print(generateDoubleSequence(count: 10)) 
print(generateDoubleSequence(count: 0))  
```

