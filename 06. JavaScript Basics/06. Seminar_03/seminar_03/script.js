"use strict";

/* **************** Задание № 1 **************** */
// // Задание № 1-1

// function userName(name, lastName, age) {
//     console.log(`Привет, ${name} ${lastName} с возрастом ${age}`);
// }

// userName(prompt('Ваше имя?'), prompt('Ваша фамилия?'), parseInt(prompt('Укажите возраст')));

// // Задание № 1-2

// function square(num) {
//     num = num ** 2;
//     return num;
// }

// console.log(square(prompt('Введите любое число:')));

// // Задание № 1-3
// function number(num) {

//     if (num > 0)    return '+++'
//     else if (num < 0)   return '---'
//     return 'Введено значение, не удовлетворяющее условию'
// }

// console.log(number(prompt('Введите любое число кроме 0:')));

/* **************** Задание № 2 **************** */
// // Задание № 2-1

// let input = prompt("Введите три числа через пробел:");
// let nums = input.split(" ").map(Number);

// function sumNumber(num) {
//   let sum = 0;
//   let value = [];

//   if (num.length === 3) {
//     for (const item of num) {
//       sum += item;
//       value.push(item);
//     }
//     console.log(`Сумма чисел (${value.join(" + ")}) равна ${sum}`);
//   } else {
//     console.log('Ошибка! Не выполнены условия ввода данных');
//   }
// }
// sumNumber(nums);

// // Задание № 2-2

// let param1 = 1;
// let param2 = 2;
// let param3 = 3;

// function sum(a, b, c) {
//   let sum = a + b + c;
//   console.log(`Сумма чисел ${a}, ${b}, ${c} равна ${sum}`);
// }

// sum(param1, param2, param3);

// // Задание № 2-3

// function func(num = 5) {
//   console.log(num * num);
// }

// func(2);    // 4
// func(3);    // 9
// func();     // 25

/* **************** Задание № 3 **************** */
// // Задание № 3-1
// function square(num) {

//   // 1-ый вариант
//   // let numSqrt = Math.sqrt(num);

//   // 2-ой (альтернативный) вариант
//   let numSqrt = num ** 0.5;

//   return numSqrt;
// }

// let num1 = 3;
// let num2 = 4;

// console.log(`Корень числа ${num1} = ${square(num1)}`);
// console.log(`Корень числа ${num2} = ${square(num2)}`);
// console.log(
//   `Сумма полученных значений '${square(num1)}' и '${square(num2)}' равна ${square(num1) + square(num2)}`,
// );

// // Задание № 3-2

// let input = prompt("Введите два числа через пробел:");
// let nums = input.split(" ").map(Number);

// function minimum(num) {
//   if (num.length === 2) {
//       if (num[0] > num[1]) {
//         console.log(`Число ${num[0]} больше ${num[1]}`);
//       } else if (num[0] < num[1]) {
//         console.log(`Число ${num[0]} меньше ${num[1]}`);
//       } else if (num[0] === num[1]) {
//         console.log(`Числа ${num[0]} и ${num[1]} равны`);
//       } else {
//         console.log("Ошибка! Не выполнены условия ввода данных");
//       }
//   } else {
//     console.log("Ошибка! Не выполнены условия ввода данных");
//   }
// }

// minimum(nums);

/* **************** Задание № 4 **************** */
// // Задание № 4-1

// let nums = parseInt(prompt("Введите число от 1 до 7:"));

// function dayWeek(num) {
//   switch (num) {
//     case 1:
//       console.log("Понедельник");
//       break;
//     case 2:
//       console.log("Вторник");
//       break;
//     case 3:
//       console.log("Среда");
//       break;
//     case 4:
//       console.log("Четверг");
//       break;
//     case 5:
//       console.log("Пятница");
//       break;
//     case 6:
//       console.log("Суббота");
//       break;
//     case 7:
//       console.log("Воскресенье");
//       break;
//     default:
//       console.log("Ошибка! Не выполнены условия ввода данных");
//       break;
//   }
// }

// dayWeek(nums);


// Задание № 4-2
const nameUser = prompt("Как Вас зовут?");
const hour = new Date().getHours();
let greetings;

function timesOfDay(name) {
  if (hour < 6) {
    greetings = "Доброй ночи";
  } else if (hour < 12) {
    greetings = "Доброе утро";
  } else if (hour < 18) {
    greetings = "Добрый день";
  } else {
    greetings = "Добрый вечер";
  }

  return `${greetings}, ${name}!`;
}

console.log(timesOfDay(nameUser));
