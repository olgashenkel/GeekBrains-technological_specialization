"use strict";

// const buttonEl = document.querySelector(".button");
// let count = 0;

// buttonEl.onclick = function (){
//     console.log('Click JS button');
//     count++;
//     console.log(`Кликов по кнопке ${count}`);
// }

// buttonEl.addEventListener('click', function (e) {
//     console.log('click add');
// });

// const click = function () {
//   console.log("Click JS button");
//   count++;
//   console.log(`Кликов по кнопке ${count}`);
// };

// buttonEl.addEventListener('click', click);

// const buttonsEls = document.querySelectorAll(".button");

// buttonsEls.forEach((element) => {
//   element.addEventListener("click", function (event) {
//     // console.log(event.target);
//     const target = event.target;
//     console.log(target);
//   });
// });

// const menuEl = document.querySelector('.menu');

// const nameFunction = (e) => {
//     console.log(e.target, e.currentTarget);
// }

// menuEl.addEventListener('click', nameFunction);

// // ******************** Обработчик событий: Проверка на полную загрузку страницы и ее контента ********************
// document.addEventListener('DOMContentLoaded', function (e) {
//     console.log('loaded');
// });

// window.addEventListener('load', function (e) {
//     console.log('Всё загрузилось');
// });

// // ******************** Обработчик событий: наведение мышки на контент (без нажатия на кнопку мыши) ********************
// const buttonEl = document.querySelectorAll(".button");

// buttonEl.forEach((element) => {
//   element.addEventListener("mouseover", function (e) {
//     console.log("Не нужно наводить, ты лучше нажми");
//   });
// });

// // ******************** Обработчик событий (без нажатия на кнопку мыши): mouseleave в JavaScript — это событие, которое срабатывает, когда курсор мыши покидает границы элемента, включая его дочерние элементы ********************
// buttonEl.forEach((element) => {
//   element.addEventListener("mouseleave", function (e) {
//     console.log("Не нужно убегать");
//   });
// });

// // ******************** Обработчик событий: клавиатура ********************

// window.addEventListener("keydown", function (e) {
//   console.log(e);
//   console.log(e.key);
// });

// // ******************** Обработчик событий: работа с блокировкой действия (приостановка события) ********************
// const linkEl = document.querySelector(".link");

// linkEl.addEventListener("click", function (e) {
//   e.preventDefault();
//   console.log("Hello, link!");
// });

// // ******************** Обработчик событий: копирование ********************

// document.addEventListener("copy", function (e) {
//   const pElem = document.getSelection().toString();
//   console.log(pElem);
// });

// // ******************** Обработчик событий: resize - это механизм, который реагирует на изменение размеров окна браузера (viewport) пользователем. Он вешается на объект window и позволяет перестраивать интерфейс, пересчитывать стили или скрывать элементы при изменении ширины/высоты экрана, что критично для адаптивной верстки ********************

// window.addEventListener("resize", function (e) {

//   console.log('resize');
// });

// // ******************** Обработчик событий: input - это функция, запускаемая браузером немедленно при любом изменении значения в текстовом поле (<input>, <textarea>). В отличие от change, он реагирует мгновенно на каждое нажатие клавиши, вставку или удаление текста, что идеально подходит для валидации в реальном времени или поиска ********************

// const inputEl = document.querySelector("input");
// inputEl.addEventListener("input", function (e) {
//   //   console.log(e.target.value);

//   if (Number(e.target.value) === 123) {
//     console.log("True");
//   } else {
//     console.log("False");
//   }
// });



// // ******************** Обработчик событий: submit — это функция, запускаемая при попытке отправки HTML-формы (нажатие Enter или кнопки <button type="submit">). Он используется для валидации данных, предотвращения перезагрузки страницы (через event.preventDefault()) и асинхронной отправки данных на сервер. ********************

const inputText = document.querySelector('input');
const formRun = document.querySelector('form');
const errorEl = document.querySelector('.error');

formRun.addEventListener('submit', function (e) {
    if (inputText.value === ''){
        e.preventDefault();
        errorEl.textContent = 'Поле не должно быть пустым'
    }
});