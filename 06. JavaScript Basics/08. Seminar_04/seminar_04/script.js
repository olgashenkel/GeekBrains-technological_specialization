"use strict";

// /* **************** Задание № 1 **************** */
// //           ****** Задание № 1-1 ******
// const array = [1, 2, 3];

// array.forEach(arr => console.log(arr));

// //           ****** Задание № 1-2 ******
// const array = [5, 8, 'dfghdf', 'uioui', 9, 56, 'sfgh'];

// console.log(array.length);

// //           ****** Задание № 1-3 ******
// const array = ["a", "b", "c"];
// console.log(`Исходный массив: [${array}]`);

// for (let index = 0; index < array.length; index++) {
//   array[index] = index + 1;
//   console.log(`Изменение массива по индексу [${index}]: [${array}]`);
// }

// console.log(`Измененный массив: [${array}]`);

/* **************** Задание № 2 **************** */

//           ****** Задание № 2-1 ******
// console.log(`****** Задание № 2-1 ******`);
// const array = [1, 2, 3];
// console.log(`Исходный массив: [${array}]`);
// for (let index = 0; index < array.length; index++) {
//     array[index]++;
// }
// console.log(`Измененный массив: [${array}]`);

//           ****** Задание № 2-2 ******
// console.log(`\n****** Задание № 2-2 ******`);
// const arr = [];
// arr[3] = 'a';
// arr[8] = 'b';
// console.log(`Длина массива = ${arr.length} элементов`);

//           ****** Задание № 2-3 ******
// console.log(`\n****** Задание № 2-3 ******`);
// const arr = [1, 2, 3];
// console.log(arr);
// arr.push(4);
// console.log(arr);
// arr.push(5);
// console.log(arr);

//           ****** Задание № 2-4 ******
// console.log(`\n****** Задание № 2-4 ******`);
// const array = [5, 7, 5, 19, 100];
// console.log(`Исходный массив [${array}]`);
// console.log(`Удаляем следующие элементы массива [${array.splice(2, 2)}]`);
// console.log(`Итоговый массив [${array}]`);
// console.log(`Длина массива = ${array.length}`);

/* **************** Задание № 3 **************** */

//           ****** Задание № 3-1 ******
// console.log(`****** Задание № 3-1 ******`);
// const array = [];

// for (let index = 11; index < 33; index++) {
//     array.push(index);
// }

// console.log(array);

//           ****** Задание № 3-2 ******
// console.log(`\n****** Задание № 3-2 ******`);
// const array = [];

// for (let index = 1; index < 99; index++) {
//     if (index % 2 !== 0) {
//         array.push(index);
//     }
// }

// console.log(array);

//           ****** Задание № 3-3 ******
// console.log(`\n****** Задание № 3-3 ******`);
// const array = [];

// for (let index = 100; index > 0; index--) {
//         array.push(index);
// }

// console.log(array);

//           ****** Задание № 3-4 ******
// console.log(`\n****** Задание № 3-4 ******`);

// let num = parseInt(prompt('Введите любое число от 1 до 1000'));
// let count = 0;

// if (num > 0 && num < 1000) {
//     for (let index = num; index <= 1000; index *= 3) {
//         count++;

//     }
// } else {
//     alert(`Ошибка! Введено значение "${num}", не удовлетворяющее условию!`)
// }

// console.log(`При значении "${num}" количество итераций = ${count}`);

// /* **************** Задание № 4 **************** */

// //           ****** Задание № 4-1 ******
// console.log(`****** Задание № 4-1 ******`);
// const arr = [2, 5, 9, 15, 1, 4];
// let count = 0;

// for (let index = 0; index < arr.length; index++) {
//   if (arr[index] > 3 && arr[index] < 10) {
//     console.log(arr[index]);
//     count++;
//   }
// }
// if (count === 0) {
//   console.log("Элементов массива, удовлетворяющих условию, нет");
// }

// //           ****** Задание № 4-2 ******
// console.log(`\n****** Задание № 4-2 ******`);
// let sum = 0;

// for (let index = 2; index <= 100; index++) {
//   if (index % 2 === 0) {
//     sum += index;
//   }
// }
// console.log(`Сумма четных чисел от 2 до 100 = ${sum}`);

// //           ****** Задание № 4-3 ******
// console.log(`\n****** Задание № 4-3 ******`);
// const array = [2, 5, 9, 3, 1, 4];
// let sum = 0;

// for (let index = 0; index < array.length; index++) {
//       sum += array[index];
// }
// console.log(`Сумма элементов массива [${array}] = ${sum}`);

// //           ****** Задание № 4-4 ******
// console.log(`\n****** Задание № 4-4 ******`);
// let str = '-';
// for (let index = 1; index <= 9; index++) {
//        str += index + '-';
// }
// console.log(str);

// //           ****** Задание № 4-5 ******
// console.log(`\n****** Задание № 4-5 ******`);
// const array = [2, 5, 9, 0, 3, 1, 4];

// for (let index = 0; index < array.length; index++) {
//   console.log(array[index]);
//   if (array[index] === 0) {
//     break;
//   }
// }

// /* **************** Задание № 5 **************** */

// //           ****** Задание № 5-1 ******
// console.log(`****** Задание № 5-1 ******`);
// const min = 1;
// const max = 100;
// const length = 10;

// const array = Array.from(
//   { length },
//   () => Math.floor(Math.random() * (max - min + 1)) + min,
// );

// console.log(`Исходный массив: [${array}]`);

// const arraySquare = [];
// const arrayCube = [];

// for (let index = 0; index < array.length; index++) {
//   if (array[index] % 2 === 0) {
//     console.log(`${array[index]} ^ 2 = ${array[index] ** 2}`);
//     arraySquare.push(array[index] ** 2);
//   } else if (array[index] % 3 === 0) {
//     console.log(`${array[index]} ^ 3 = ${array[index] ** 3}`);
//     arrayCube.push(array[index] ** 3);
//   }
// }

// console.log(`Числа массива, которые делятся на 2 и возведенные во 2-ю степень:\n${arraySquare}`);
// console.log(`Числа массива, которые делятся на 3 и возведенные во 3-ю степень:\n${arrayCube}`);

// //           ****** Задание № 5-2 ******
// console.log(`\n****** Задание № 5-2 ******`);
// const arr = [1, 2, 3, 2, 4, 3, 5, 6, 3, 2, 3];
// let count = 0;

// for (let index = 0; index < arr.length; index++) {
//     if (arr[index] === 3) {
//         count++;
//     }
// }

// console.log(`Количество цифр 3 в массиве [${arr}] = ${count}`);

// //           ****** Задание № 5-3 ******
// console.log(`\n****** Задание № 5-3 ******`);
// const array = [1, 2, 3, 4, 5];

// console.log(`Исходный массив [${array}]`);
// array.splice(1, 2);
// console.log(`Измененный массив [${array}]`);
