"use strict";

// // ***************** Прерывание распространения события *****************
// const form = document.forms[0];
// const list = document.querySelector("ul");
// list.addEventListener(
//   "click",
//   (e) => {
//     console.log("В первом UL в фазе захвата");
//     const propagationControlMethodName =
//       form.elements["propagation-control"].value;
//     if (propagationControlMethodName) {
//       e[propagationControlMethodName]();
//     }
//   },
//   true,
// );
// list.addEventListener(
//   "click",
//   () => {
//     console.log("Во втором UL в фазе захвата");
//   },
//   true,
// );
// list.addEventListener("click", () => {
//   console.log("В первом UL в фазе всплытия");
// });
// Array.from(list.children).forEach((child) => {
//   child.addEventListener("click", () => {
//     console.log("В каждом LI в фазе всплытия");
//   });
// });

// ***************** Действия по умолчанию и отменяемые события *****************
// const inputEl = document.querySelector('.check');
// const formEl = document.querySelector('.form');
// const errorEl = formEl.querySelector('.error');
// const errorId = formEl.querySelector('#checkbox');

// inputEl.addEventListener('click', function (e) {
//     const target = e.target;
//     console.log(target.value);
//     console.log(target.checked);
// });

// formEl.addEventListener('submit', function (e) {
//     if (inputEl.checked) {
//         console.log('Молодец');
//     } else {
//         console.log('Забыл поставить галочку!');
//         errorEl.textContent = 'Необходимо выбрать "Согласен с условиями"';
//         formEl.classList.add('errorId');
//         inputEl.classList.add('error-check');
//         e.preventDefault();
//     }

// });


// // ***************** Генерация событий, пользовательские события *****************

// const eventOptions = { bubbles: true, cancelable: true };
// const event = new Event("click", eventOptions);
// event.view = window;
// const mouseEvent = new MouseEvent("click", {
//   ...eventOptions,
//   view: window,
// });

// document.addEventListener("click", (event) => {
//   console.log(event.isTrusted);
// });

// const button = document.querySelector("button");
// button.dispatchEvent(event);
// button.dispatchEvent(mouseEvent);
// button.click();


// // ***************** Создание макета (Layout), Растеризация (Painting) *****************


/* ***************** Выбор города ***************** */

const formEl = document.querySelector('.form');
const selectEl = formEl.querySelector('.select');
const buttonEl = formEl.querySelector('.button');

document.addEventListener('click', function (e) {
    console.log(selectEl.value);
    e.preventDefault();

    if (selectEl.value === 'city') {
        selectEl.classList.add('select__error');
    } else {
        selectEl.classList.remove('select__error');
        return;
    }
});

