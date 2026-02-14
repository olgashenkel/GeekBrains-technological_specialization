/* **************** Задание № 1 **************** */

// console.log(`****** Задание № 1 ******`);

// for (let index = 0; index <= 11; index++) {
//     if (index === 0) {
//         console.log(`${index} - это ноль`);
//     } else if (index % 2 !== 0) {
//         console.log(`${index} - нечетное число`);
//     } else {
//         console.log(`${index} - четное число`);
//     }
// }

/* **************** Задание № 2 **************** */

// console.log(`****** Задание № 2 ******`);

// const array = [1, 2, 3, 4, 5, 6, 7];
// console.log(`Исходный массив [${array}]`);
// console.log(`Удаление [${array.splice(3, 2)}] элементов из массива`);
// console.log(`Измененный массив [${array}]`);

// /* **************** Задание № 3 **************** */
// console.log(`****** Задание № 3 ******`);
// const min = 0;
// const max = 9;
// const length = 10;

// // Заполнение массива случайными числами
// const array = Array.from(
//   { length },
//   () => Math.floor(Math.random() * (max - min + 1)) + min,
// );
// console.log(`Исходный массив: \n[${array}]`);

// let sum = 0;
// let count = 0;
// let arrayMinNum = Math.min(...array);
// let arrayThreeIndex = [];

// for (let index = 0; index < array.length; index++) {
//   sum += array[index];

//   // Определить, есть ли в массиве число 3
//   if (array[index] === 3) {
//     arrayThreeIndex.push(index);
//     count++;
//   }
// }

// console.log(`Сумма элементов массива = ${sum}`);
// console.log(`Минимальное число массива = ${arrayMinNum}`);

// // сообщение для вывода в консоль о нахождении/отсутствии числа "3" в массиве
// if (count === 0) {
//   console.log("Массив не содержит число '3'");
// } else {
//     console.log(`Массив содержит число '3' под индексом ${arrayThreeIndex}`);
// }

/* **************** Задание № 4 **************** */
console.log(`****** Задание № 4 ******`);

for (let index = 0; index <= 20; index++) {
  console.log("x".repeat(index));
}
