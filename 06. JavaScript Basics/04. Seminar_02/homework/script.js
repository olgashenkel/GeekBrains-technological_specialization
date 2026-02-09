/* **************** Задание № 1 **************** */
// let num1 = parseInt(prompt('Введите число, которое меньше или равно 1: '));
// let num2 = parseInt(prompt('Введите число, которое больше или равно 3: '));

// if (num1 <= 1 && num2 >= 3) {
//     console.log(`Введенные значения '${num1}' и '${num2}' удовлетворяют заданным условиям`);
// } else {
//     console.log(`Введенные значения '${num1}' и '${num2}' НЕ удовлетворяют заданным условиям`);
// }

/* **************** Задание № 2 **************** */
// let test = true;
// console.log((test === true) ? '+++' : '---');

// test = false;
// console.log((test === true) ? '+++' : '---');

/* **************** Задание № 3 **************** */
// let day = parseInt(prompt("Введите число от 1 до 31: "));
// if (day >= 1 && day <= 10) {
//   console.log(`Введенное число '${day}' соответствует первой декаде месяца`);
// } else if (day >= 11 && day <= 20) {
//   console.log(`Введенное число '${day}' соответствует второй декаде месяца`);
// } else if (day >= 21 && day <= 31) {
//   console.log(`Введенное число '${day}' соответствует третьей декаде месяца`);
// } else {
//   console.log(`Введенное значение '${day}' НЕ удовлетворяет заданным условиям`);
// }

/* **************** Задание № 4 **************** */
let number = parseInt(prompt("Введите любое число от 0 до 1000: "));
let finalNumber = Math.abs(number);

if (finalNumber >= 100 && finalNumber <= 1000) {
  console.log(
    `Введенное число '${number}' содержит: ${parseInt(finalNumber / 100)} сотен, ${parseInt((finalNumber % 100) / 10)} десятков, ${(finalNumber % 100) % 10} единиц`,
  );
} else if (finalNumber >= 10 && finalNumber <= 100) {
  console.log(
    `Введенное число '${number}' содержит: ${parseInt(finalNumber / 10)} десятков, ${finalNumber % 10} единиц`,
  );
} else if (finalNumber < 10) {
  console.log(`Введенное число '${number}' содержит: ${finalNumber} единиц`);
} else {
  console.log(
    "Введенное значение НЕ удовлетворяет заданным условиям или не поддается моему анализу",
  );
}
