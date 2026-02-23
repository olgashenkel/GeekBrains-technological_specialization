"use strict";

/* **************** Задание № 1 **************** */
// console.log(`****** Задание № 1 ******`);

// window.addEventListener("load", () =>
//   console.log("Страница загрузилась"),
// );

// const buttonEl = document.querySelector(".button");
// buttonEl.addEventListener("click", function () {
//   console.log("Событие addEventListener");
// });

/* **************** Задание № 2 **************** */
// console.log(`\n****** Задание № 2 ******`);

// const buttonsEl = document.querySelectorAll(".buttons");

// let countClick = 0;

// function btnClickName(e) {
//   if (Number(e.target.innerText) < buttonsEl.length - 1) {
//     console.log(`Вы нажали на кнопку "${e.target.innerText}"`);
//   } else if (Number(e.target.innerText) === buttonsEl.length - 1) {
//     console.log(`Количество нажатий на кнопку "${buttonsEl.length - 1}" = ${++countClick}`);
//   } else if (Number(e.target.innerText) === buttonsEl.length) {
//     e.target.innerText = "Вы нажали на эту кнопку";
//   }
// }

// buttonsEl.forEach((btn) => {
//   btn.addEventListener("click", btnClickName);
// });

/* **************** Задание № 3 **************** */
// console.log(`\n****** Задание № 3 ******`);

// const buttonThree1El = document.querySelector(".buttonThree1");
// const buttonThree2El = document.querySelector(".buttonThree2");
// const buttonThree3El = document.querySelector(".buttonThree3");

// const header = document.createElement("h1");
// header.textContent = "Новый заголовок";

// let timer;

// buttonThree1El.addEventListener("click", () => {
//   document.body.appendChild(header);
// });

// buttonThree2El.addEventListener("click", () => {
//   if (document.querySelector("h1")) {
//     document.body.removeChild(header);
//   } else {
//     alert("Элемент уже удален или не существует!");
//     console.log("Элемент уже удален или не существует!");
//   }
// });

// buttonThree3El.addEventListener("mouseenter", () => {
//   console.log("Вы навели на данную кнопку");
//   buttonThree3El.textContent = "Вы навели на данную кнопку";
// });

// buttonThree3El.addEventListener("mouseleave", () => {
//   console.log("Наведения на кнопку больше нет");
//   buttonThree3El.textContent = "Наведения на кнопку больше нет";
//   clearTimeout(timer);

//   // Возвращаем текст через 2 секунды (2000 мс)
//   timer = setTimeout(() => {
//     buttonThree3El.textContent = "Особенная кнопка";
//   }, 1500);
// });

/* **************** Задание № 4 **************** */
console.log(`\n****** Задание № 4 ******`);

const buttonAddTextEl = document.querySelector(".buttonAddText");
const buttonRemoveTextEl = document.querySelector(".buttonRemoveText");
const buttonAddClassEl = document.querySelector(".buttonAddClass");

const listEl = document.querySelector(".list");

console.log(buttonAddTextEl);
console.log(buttonRemoveTextEl);
console.log(buttonAddClassEl);

console.log(listEl);

buttonAddTextEl.addEventListener("click", () => {
  const liEl = document.createElement("li");
  liEl.textContent = "Новый элемент списка";
  listEl.appendChild(liEl);
});

buttonRemoveTextEl.addEventListener("click", () => {
  if (listEl.firstElementChild) {
    listEl.removeChild(listEl.firstElementChild);
  } else {
    alert("Все элементы уже удалены!");
    console.log("Все элементы удалены!");
  }
});

// buttonAddClassEl.addEventListener("click", () => {
//   if (!buttonAddClassEl.classList.contains('click')) {
//     buttonAddClassEl.classList = buttonAddClassEl.classList + " click";
//     console.log(buttonAddClassEl);
//     console.log('Класс "click" успешно добавлен');
//   } else {
//     alert('Класс "click" уже добавлен');
//     console.log('Класс "click" уже добавлен');
//   }
// });

// Решение с семинара:
buttonAddClassEl.addEventListener('click', function (e) {
  const target = e.target;
  target.classList.add('click');
  console.log(buttonAddClassEl);
});
