// /* **************** Задание № 1 **************** */

// //           ****** Задание № 1-1 ******
// console.log(`****** Задание № 1-1 ******`);

// const idBlock = document.getElementById('block');
// const idBlockP = idBlock.querySelector('p');
// console.log(idBlock);
// console.log(idBlockP);
// console.log(idBlockP.textContent);

// // Решение с семинара:
// const p1El = document.querySelector('#block p:first-child');
// console.log(p1El);

// //           ****** Задание № 1-2 ******
// console.log(`\n****** Задание № 1-2 ******`);

// const classWWW = document.querySelector('.www');
// console.log(classWWW);
// console.log(classWWW.textContent);

// // Решение с семинара:
// const wwwClass = document.querySelector('.www:first-of-type');
// console.log(wwwClass);

// /* **************** Задание № 2 **************** */

// //           ****** Задание № 2-1 ******
// console.log(`\n****** Задание № 2-1 ******`);
// const linkClass = document.querySelector('.link');
// linkClass.textContent = 'link text js';
// linkClass.href = 'https://share.google/SCbylEcn05zxXUO9i';
// console.log(linkClass);

// //           ****** Задание № 2-2 ******
// console.log(`\n****** Задание № 2-2 ******`);

// const photoClass = document.querySelector('.photo');
// photoClass.src = 'https://img.freepik.com/free-photo/beautiful-spring-landscape_23-2151917219.jpg?semt=ais_hybrid&w=740&q=80';
// photoClass.alt = 'Долгожданная весна';
// photoClass.width = 400;
// console.log(photoClass);

// /* **************** Задание № 3 **************** */

// console.log(`\n****** Задание № 3 ******`);

// const elemP = document.createElement('p');
// elemP.textContent = 'Новый текстовый элемент';

// const elemDivContent = document.querySelector('.content');

// elemDivContent.appendChild(elemP);
// console.log(elemDivContent);
// console.log(elemP);

// // elemDivContent.removeChild(elemP);
// elemP.remove();
// // console.log(elemP);

// /* **************** Задание № 4 **************** */

// console.log(`\n****** Задание № 4 ******`);

// const elemDivCont = document.querySelector(".content");
// const buttonDivContent = document.createElement("button");
// buttonDivContent.textContent = "Нажми меня";

// elemDivCont.appendChild(buttonDivContent);
// console.log(elemDivCont);
// console.log(buttonDivContent);

// let count = 0;

// buttonDivContent.addEventListener("click", () => {
//   count++;
//   buttonDivContent.textContent = 'На меня нажали ' + count + ' раз(а)';
//   console.log(`Кнопка нажата: ${count} раз(а)`);
//   if (count === 5) {
//     buttonDivContent.textContent = 'Всё!!! Я устала считать!!! 😎';
//     console.log('Всё!!! Я устала считать!!! 😎');
//     count = 0;
//   }
// });



/* **************** Задание № 5 **************** */

console.log(`\n****** Задание № 5 ******`);

const elemDivContent = document.querySelector('.content');
const buttonDivContent = document.createElement('button');
buttonDivContent.textContent = 'Отправить';

elemDivContent.appendChild(buttonDivContent);
console.log(elemDivContent);
console.log(buttonDivContent);

buttonDivContent.addEventListener('click', () => {
    buttonDivContent.textContent = 'Текст отправлен';
    console.log(buttonDivContent.textContent);
});
