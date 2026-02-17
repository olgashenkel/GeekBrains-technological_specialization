const heading2 = document.getElementById("heading");
const heading3 = document.querySelector("#heading");

const listElem = document.getElementsByClassName("list");
const listElemQS = document.querySelectorAll(".list");

const heading = document.querySelector(".title");
const text = document.querySelectorAll(".text");

const headingEl = document.createElement("h3");
headingEl.textContent = "Мой первый заголовок из js";

const titleEl = document.querySelector(".title");
titleEl.textContent = "Заголовок уже из js";

const headingDel = document.querySelector("#heading");
headingDel.remove();




const buttonEl = document.querySelector(".btn");
// console.log(buttonEl);
// buttonEl.onclick = function () {
//   buttonEl.textContent = "Товар добавлен в корзину";
// };

const contentEl = document.querySelector('.content');

const textEl = document.createElement('p');
textEl.textContent = 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam dicta perspiciatis exercitationem dolores, rem incidunt recusandae praesentium culpa amet cupiditate.';

buttonEl.onclick = function () {
  buttonEl.textContent = "Товар добавлен в корзину";
  contentEl.appendChild(textEl);
};


const imgEl = document.querySelector('.img');
imgEl.onclick = function () {
    imgEl.src = 'https://cdn-edge.kwork.ru/pics/t3/26/46439323-690f772b25d15.jpg'
}


// for (let index = 0; index < text.length; index++) {
//     console.log(text[index]);
// }

// text.forEach(element => {
//     console.log(element);
// });

// console.log(heading);
// console.log(text);
// console.log(heading2);
// console.log(heading3);
// console.log(listElem);
// console.log(listElemQS);
// console.log(headingEl);
