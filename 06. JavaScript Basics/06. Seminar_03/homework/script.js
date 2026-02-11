"use strict";

/* **************** Задание № 1 **************** */
// function cubDegree(num) {
//   return num ** 3;
// }

// console.log(cubDegree(2) + cubDegree(3));

/* **************** Задание № 2 **************** */
// function salary() {
//   let input = prompt("Введите размер заработной платы:");
//   if (input === null || input.trim() === "" || isNaN(Number(input))) {
//     alert("Ошибка: неверное значение. Пожалуйста, введите число.");
//   } else {
//     console.log(`Размер заработной платы за вычетом налогов равен ${input * 0.87} денежных единиц`);
//   }
// }

// salary();

/* **************** Задание № 3 **************** */
// let input = prompt("Введите 3 числа через пробел:");
// let numbers = input.split(" ").map(Number);

// function maximum(num) {
//   return Math.max(...num);
// }

// console.log(`Вы ввели числа ${numbers.join(', ')}. Максимальное число среди них равно ${maximum(numbers)}`);

/* **************** Задание № 4 **************** */
function sum(num1 = 5, num2 = 2) {
  let sum = num1 + num2;
  console.log(`Сумма чисел ${num1} и ${num2} равна ${sum}`);
  return sum;
}


function subtract(num1 = 5, num2 = 2) {
  let subtract = num1 + num2;
  console.log(`Разность чисел ${num1} и ${num2} равна ${subtract}`);
  return subtract;
}


function multiplication(num1 = 5, num2 = 2) {
  let multiplication = num1 * num2;
  console.log(`Произведение чисел ${num1} и ${num2} равно ${multiplication}`);
  return multiplication;
}

function division(num1 = 5, num2 = 2) {
  let division = num1 / num2;
  console.log(`Деление чисел ${num1} и ${num2} равно ${division}`);
  return division;
}

sum();
subtract();
multiplication();
division();