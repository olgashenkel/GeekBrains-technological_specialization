/* **************** Задание № 1 **************** */
// let age = parseInt(prompt('Укажите Ваш возраст: '));
// console.log(`Вам ${age} лет`);

// let userName = prompt('Укажите Ваше имя: ');
// console.log(`Добро пожаловать на сайт, ${userName}`);



/* **************** Задание № 2 **************** */
// Задание № 2-1
// let a = 13;
// let b = 5;
// console.log(a % b);     //  3

// Задание № 2-2
// let c;
// alert(c);   // undefined

// Задание № 2-3
// alert('abc' * 3);   //NaN

// Задание № 2-4
// alert( 1 / 0);  // Infinity
// alert(-1 / 0);  // -Infinity

// Задание № 2-5
// alert('2' * '3');   // 6



/* **************** Задание № 3 **************** */
// // Задание № 3-1
// // let a = 13;
// // let b = 5;
// // console.log(a 0 b);

// // Задание № 3-2
// let a = '2';
// let b = '3';
// console.log(a + b);

// // Задание № 3-3
// let num1 = parseInt(prompt('Введите первое число: '));
// let num2 = parseInt(prompt('Введите второе число: '));
// console.log(`Введенные числа '${num1}' и '${num2}'`);
// console.log(`Сумма чисел равна ${num1 + num2}`);
// console.log(`Разность чисел равна ${num1 - num2}`);
// console.log(`Произведение чисел равно ${num1 * num2}`);
// console.log(`Частное чисел равно ${num1 / num2}`);
// console.log(`Остаток от деления чисел равен ${num1 % num2}`);



/* **************** Задание № 5 **************** */
// Задание № 5-1
let num = parseInt(prompt('Введите любое число: '));
if (num > 5) {
    console.log('Введенное число больше 5');
} else if (num < 5) {
    console.log('Введенное число меньше 5');
} else if (num === 5) {
    console.log('Введенное число равно 5');
} else {
    console.log('Введенное значение мне не известно ');
}


// Задание № 5-2
let test1 = prompt('Введите любое значение для переменной "test1": ');
let test2 = prompt('Введите любое значение для переменной "test2": ');

if (test1 === test2) {
    console.log('Введенные значения переменных равны между собой');
    console.log(`test1 = ${test1}`);
    console.log(`test2 = ${test2}`);
} else if (test1 !== test2) {
    console.log('Введенные значения переменных между собой НЕ равны');
    console.log(`test1 = ${test1}`);
    console.log(`test2 = ${test2}`);
} else {
    console.log('Введенные значения мне не известны ');
}


// Задание № 5-3
let numbr1 = parseInt(prompt('Введите любое число: '));
let numbr2 = parseInt(prompt('Введите любое число: '));

if (numbr1 < numbr2) {
    console.log(`Первое число = ${numbr1} - является минимальным`);
    console.log(`Второе число = ${numbr2}`);
} else if (numbr2 < numbr1) {
    console.log(`Первое число = ${numbr1}`);
    console.log(`Второе число = ${numbr2} - является минимальным`);
} else if (numbr2 === numbr1) {
    console.log(`Введенные числа '${numbr1}' и '${numbr2}' между собой равны`);
} else {
    console.log('Введенные значения мне не известны ');
}


// Задание № 5-4
let numb = parseInt(prompt('Введите любое число: '));

if (numb < 15 && numb > 0) {
    console.log(`Введенное число "${numb}" - больше 0 и меньше 15`);
} else if (numb >= 15) {
    console.log(`Введенное число "${numb}" - больше или равно 15`);
} else if (numb <= 0) {
    console.log(`Введенное число "${numb}" - меньше или равно 0`);
} else {
    console.log('Введенное значение мне не известно ');
}

