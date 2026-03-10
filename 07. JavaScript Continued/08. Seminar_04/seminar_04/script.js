"use strict";

/* **************** Задание № 1 **************** */
// console.log(`****** Задание № 1 ******`);

// const formEl = document.querySelector(".form");
// const inputCheckEl = formEl.querySelector(".inputCheck");
// const errorDivEl = formEl.querySelector(".error");

// inputCheckEl.addEventListener("click", function (e) {
//   const target = e.target;
//   console.log(target.value);
//   console.log(target.checked);
// });

// formEl.addEventListener("submit", function (e) {
//   if (inputCheckEl.checked) {
//     console.log("Форма отправлена");
//   } else {
//     console.log('Необходимо выбрать "Согласен с условиями"');
//     errorDivEl.textContent = 'Необходимо выбрать "Согласен с условиями"';
//     formEl.classList.add("errorDivEl");
//     inputCheckEl.classList.add("error-check");
//     e.preventDefault();
//   }
// });

/* **************** Задание № 2 **************** */
// console.log(`\n****** Задание № 2 ******`);

// const formEl = document.querySelector(".form");
// const buttonEl = formEl.querySelector(".button");

// buttonEl.addEventListener("click", function (e) {
//     e.preventDefault();

//   const selectDrink = formEl.querySelector('input[name="hotDrinks"]:checked');

//   if (!selectDrink) {
//     alert("Вы ничего не выбрали");
//     console.log("Вы ничего не выбрали");
//   } else if (selectDrink.id === "Coffee") {
//     alert("Кофе закончился");
//     console.log("Кофе закончился");
//   } else if (selectDrink.id === "Tea") {
//     alert("Чай закончился");
//     console.log("Чай закончился");
//   }
// });

/* **************** Задание № 3 **************** */
// console.log(`\n****** Задание № 3 ******`);

// const passwordCode = "пароль";
// document.getElementById("passwordInput").onchange = validateField;
// document.getElementById("passwordForm").onsubmit = finalCheck;

// function removeAlert() {
//   // Функция для удаления всех предупреждений независимо от их значения
//   var msg = document.getElementById("msg");
//   if (msg) {
//     document.body.removeChild(msg);
//   }
// }

// function resetField(elem) {
//   elem.parentNode.setAttribute("style", "background-color: #ffffff");
//   var valid = elem.getAttribute("aria-invalid");
//   if (valid) {
//     elem.removeAttribute("aria-invalid");
//   }
// }

// function badField(elem) {
//   elem.setAttribute("aria-invalid", "true");
// }

// function goodField(elem) {
//   elem.setAttribute("style", "border: 3px solid green");
// }

// function generateAlert(txt) {
//   // Создаем новые текстовые элементы и элементы div,
//   // присваиваем им значения атрибутов role, class и id

//   var txtNd = document.createTextNode(txt);
//   var msg = document.createElement("div");
//   msg.setAttribute("role", "alert");
//   msg.setAttribute("id", "msg");
//   msg.setAttribute("class", "alert");

//   // Прикрепляем текстовый элемент к div, а div - к document
//   msg.appendChild(txtNd);
//   document.body.appendChild(msg);
// }

// function validateField() {
//   // Функция для проверки корректности введенных данных в поле ввода
//   // Удаляем все предупреждения независимо от их значения с помощью функции:
//   removeAlert();

//   // Проверяем, является ли введенное значение верным:
//   if (this.value === passwordCode) {
//     resetField(this);
//     this.setAttribute("style", "border: 3px solid green");
//   } else {
//     badField(this);
//     generateAlert("Пароль неверный!");
//   }
// }

// function finalCheck() {
//   //Функция для проверки корректности введенных данных при отправке формы
//   // Удаляем все предупреждения независимо от их значения с помощью функции:
//   removeAlert();

//   var fields = document.querySelectorAll("[aria-invalid='true']");
//   if (fields.length > 0) {
//     generateAlert("Пароль неверный!");
//     return false;
//   }
// }

/* **************** Задание № 4 **************** */
console.log(`\n****** Задание № 4 ******`);

const inputEl = document.getElementById("input");
const h1El = document.querySelector(".title");


inputEl.addEventListener("input", (e) => {
  h1El.innerText = inputEl.value;
});
