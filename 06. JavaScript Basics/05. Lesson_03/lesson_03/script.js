"use strict";

// let ageUser = parseInt(prompt("Сколько вам лет?"));

/* 1-ый вариант объявления функции */
// function upAge(age) {
//   let ageNew = age + 5;
//   console.log(`Через 5 лет вам будет ${ageNew}`);
// }

// upAge(parseInt(prompt("Сколько вам лет?")));

/* 2-ой вариант объявления функции */
// const upAge = age => console.log(`Через 5 лет вам будет ${age + 5}`);

// upAge(parseInt(prompt("Сколько вам лет?")));

// const userAnswer = prompt('Зимой и летом одним цветом?');

function mystery(question, answer) {
  const userAnswer = prompt(question);

  if (userAnswer.toLowerCase().trim() === answer) {
    alert("Поздравляем! Ваш ответ верный!");
  } else {
    alert("Увы! Ошибка!");
  }
}

function puzzle() {
  mystery("Зимой и летом одним цветом?", "ёлка");
  mystery("Сидит девица в темнице, а коса на улице?", "морковь");
}
