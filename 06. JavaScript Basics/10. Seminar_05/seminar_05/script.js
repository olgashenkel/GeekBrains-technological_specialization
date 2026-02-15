// /* **************** Задание № 1 **************** */

// //           ****** Задание № 1-1 ******
// console.log(`****** Задание № 1-1 ******`);

// const daysWeek = {
//   1: "Понедельник",
//   2: "Вторник",
//   3: "Среда",
//   4: "Четверг",
//   5: "Пятница",
//   6: "Суббота",
//   7: "Воскресенье",
// };

// console.log(daysWeek[2]);

// //           ****** Задание № 1-2 ******
// console.log(`\n****** Задание № 1-2 ******`);
// const user = {
//     name: 'Ivan',
//     surname: 'Ivanov',
//     age: 30
// }

// console.log(`${user.surname}-${user.name}-${user.age}`);

// //           ****** Задание № 1-3 ******
// console.log(`\n****** Задание № 1-3 ******`);
// const user = {
//     name: 'Ivan',
//     surname: 'Ivanov',
//     patronymic: prompt('Введите Ваше отчество'),
//     age: 30
// }

// console.log(`${user.surname}-${user.name}-${user.patronymic}-${user.age}`);

// //           ****** Задание № 1-4 ******
// console.log(`\n****** Задание № 1-4 ******`);
// const user = {
//     name: 'Ivan',
//     surname: 'Ivanov',
//     patronymic: prompt('Введите Ваше отчество'),
//     age: 30
// }

// delete user.surname;
// console.log(`${user.surname}-${user.name}-${user.patronymic}-${user.age}`);
// console.log(`${user.name}-${user.patronymic}-${user.age}`);

// /* **************** Задание № 2 **************** */

// //           ****** Задание № 2-1 ******
// console.log(`****** Задание № 2-1 ******`);

// const arr1 = ['пн', 'вт', 'ср', 'чт', 'пт', 'сб', 'вс'];
// const arr2 = [1, 2, 3, 4, 5, 6, 7];
// const daysWeek = {};

// for (let index = 0; index < arr1.length; index++) {
//     daysWeek[arr2[index]] = arr1[index];
// }

// console.log(daysWeek);

// //           ****** Задание № 2-2 ******
// console.log(`\n****** Задание № 2-2 ******`);
// const obj = { x: 1, y: 2, z: 3 };

// for (let item in obj) {
//   obj[item] **= 2;
// }

// console.log(obj);

// /* **************** Задание № 3 **************** */
// const obj = {
//   key1: {
//     key1: 1,
//     key2: 2,
//     key3: 3,
//   },
//   key2: {
//     key1: 4,
//     key2: 5,
//     key3: 6,
//   },
//   key3: {
//     key1: 7,
//     key2: 8,
//     key3: 9,
//   },
// };

// function sumObject(obj) {
//   let sum = 0;

//   for (let key in obj) {
//     if (typeof obj[key] === "object" && obj[key] !== null) {
//       // Если это объект, вызываем функцию рекурсивно
//       sum += sumObject(obj[key]);
//     } else if (typeof obj[key] === "number") {
//       // Если это число, прибавляем к сумме
//       sum += obj[key];
//     }
//   }
//   return sum;
// }

// console.log(sumObject(obj));

// // !!!!!!! Решение с семинара:
// let sum = 0;
// for (const key1 in obj) {
//     for (const key2 in obj[key1]) {
//         sum += obj[key1][key2];
//             }
// }
// console.log(sumObject(obj));

/* **************** Задание № 4 **************** */
console.log(`****** Задание № 4 ******`);

const riddles = {
  question: "Летит, а не птица, шумит, а не ветер",
  answer: ["самолет", "самолёт"],
  askQuestion: function () {
    let userAnswer = prompt(
      `Отгадайте загадку: \n"${this.question}" \nВаш ответ:`,
    );

    if (this.answer.includes(userAnswer.toLowerCase().trim()) === true) {
      alert("Поздравляем! Вы выиграли!");
      console.log("Поздравляем! Вы выиграли!");
    } else {
      prompt(`Увы! Ответ неверный!\nПодсказка № 1: С крыльями, а не птица.\n${userAnswer}`);
      if (this.answer.includes(userAnswer.toLowerCase().trim()) === true) {
        alert("Поздравляем! Вы выиграли!");
        console.log("Поздравляем! Вы выиграли!");
      } else {
        prompt(
          `Увы! Ответ неверный!\nПодсказка № 2: В слове 7 букв, первая буква "С".\n${userAnswer}`,
        );
        if (this.answer.includes(userAnswer.toLowerCase().trim()) === true) {
          alert("Поздравляем! Вы выиграли!");
          console.log("Поздравляем! Вы выиграли!");
        } else {
          alert("К сожалению, Вы проиграли!");
          console.log("К сожалению, Вы проиграли!");
        }
      }
    }
  },
};

console.log(riddles.askQuestion());

// //           ****** Задание № 4-2 ******
// console.log(`\n****** Задание № 4-2 ******`);

// //           ****** Задание № 4-3 ******
// console.log(`\n****** Задание № 4-3 ******`);

// //           ****** Задание № 4-4 ******
// console.log(`\n****** Задание № 4-4 ******`);
