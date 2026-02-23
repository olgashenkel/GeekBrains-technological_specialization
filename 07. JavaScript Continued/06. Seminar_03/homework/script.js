/* *************** Задание № 1 *************** */
// console.log(`****** Задание № 1 ******`);

// window.addEventListener('DOMContentLoaded', function (e) {
//     console.log('Все теги прогрузились');
// });

/* *************** Задание № 2 *************** */
// console.log(`****** Задание № 2 ******`);

// window.addEventListener('load', function (e) {
//     console.log('Страница загрузилась');
// });

/* *************** Задание № 3 *************** */
// console.log(`****** Задание № 3 ******`);

// document.body.addEventListener("click", (event) => {
//   const target = event.target;
//   const tagName = target.tagName.toLowerCase();
//   const hasSuperClass = target.classList.contains("super_element");

//   if (hasSuperClass) {
//     console.log(`Класс "super_element" присутствует в элементе "${tagName}".`);
//   } else {
//     console.log(`Класс "super_element" отсутствует в элементе "${tagName}".`);
//   }
// });

/* *************** Задание № 4 *************** */
// console.log(`****** Задание № 4 ******`);

// const textAreaEl = document.querySelector('textarea');

// document.addEventListener('mouseenter', function (e) {

//         console.log('Вы навели на textarea.');

// });

/* *************** Задание № 5 *************** */
// console.log(`****** Задание № 5 ******`);

// const ulElem = document.querySelector('ul');

// ulElem.addEventListener('click', function (e) {
//     if (e.target.tagName === 'BUTTON') {
//         console.log(e.target.textContent);
//     }
// });

// /* *************** Задание № 6 *************** */
// console.log(`****** Задание № 6 ******`);
/*
Когда мы нажимаем на какой-либо элемент на странице и генерируется событие нажатия, то это событие может распространяться от элемента к элементу, т.е. происходит распространение события.

Виды форм распространения событий:
1) Восходящие (bubbling) - событие распространяется вверх по дереву DOM от дочерних узлов к родительским. В JavaScript обработчики событий по умолчанию работают именно в таком порядке;
2) Нисходящие (capturing) - событие распространяется низ по дереву DOM от родительских узлов к дочерним, пока не достигнет того элемента, на котором это событие и возникло.

В данном случае используется форма - ВОСХОДЯЩЕГО события (bubbling).
*/

/* *************** Задание № 7 *************** */
// console.log(`****** Задание № 7 ******`);

// // // 1-ый способ:
// // const liElem = document.querySelectorAll("li");

// // for (let index = 1; index < liElem.length; index += 2) {
// //   liElem[index].style.backgroundColor = 'aqua';
// //   console.log(liElem[index].style.backgroundColor);
// // }


// // 2-ой способ:
const liElem = document.querySelectorAll("li:nth-child(even)");

liElem.forEach(element => {
    element.style.backgroundColor = 'aqua';
    console.log(element.style.backgroundColor);
});