/* **************** Задание № 1 **************** */

// console.log(`****** Задание № 1 ******`);

// const divBlockEl = document.querySelector('.block');

// const divItemEl = document.createElement('div');
// divItemEl.className = 'item';
// divItemEl.textContent = 'Элемент внутри';

// divItemEl.style.color = 'blue';
// divItemEl.style.border = '1px solid black';
// divItemEl.style.backgroundColor = '#f8f8f8';
// divItemEl.style.padding = '16px';
// divItemEl.setAttribute('class', 'item item_1');

// divBlockEl.appendChild(divItemEl);
// console.log(divBlockEl);

/* **************** Задание № 2 **************** */

// console.log(`\n****** Задание № 2 ******`);

// const pElText = document.querySelector('.text');
// const imgEl = document.querySelector('img');
// const parentContentEl = document.querySelector('.content');
// const parentElemEl = document.querySelector('.elem');

// console.log(pElText);
// console.log(pElText.previousElementSibling);

// console.log(pElText.parentNode);
// // или
// console.log(parentContentEl);

// console.log(imgEl);
// // Решение с семинара:
// console.log(pElText.parentElement.previousElementSibling);

// console.log(parentContentEl.parentElement);

/* **************** Задание № 3 **************** */

// console.log(`\n****** Задание № 3 ******`);

// const h2El = document.querySelector('h2');

// if (h2El) {
//     let parentEl = h2El.parentElement;

//     while (parentEl) {
//         console.log(parentEl);
//         parentEl = parentEl.parentElement;
//     }
// } else {
//     console.log('Элемент h2 не найден');
// }

/* **************** Задание № 4 **************** */

console.log(`\n****** Задание № 4 ******`);

const btn = document.querySelector(".btn");
const inputEl = document.querySelector("input");

const errorHeader = document.createElement("h2");
errorHeader.textContent = "Вы не заполнили поле ввода";


btn.addEventListener("click", () => {
  if (inputEl.value.trim() === "") {
    inputEl.classList.add("error-border");
    document.body.appendChild(errorHeader);
  } else {
    inputEl.classList.remove("error-border");
    errorHeader.remove();
  }
}); 


// /* **************** Задание № 5 **************** */

// console.log(`\n****** Задание № 5 ******`);
