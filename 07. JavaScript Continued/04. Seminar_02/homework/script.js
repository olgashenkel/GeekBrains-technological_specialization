// /* *************** Задание № 1 *************** */
// console.log(`****** Задание № 1 ******`);

// const dropdownItemEl = document.querySelectorAll('.dropdown-item');
// console.log(dropdownItemEl);

// dropdownItemEl.forEach(element => {
//     element.classList.add('super-dropdown');
// });



// /* *************** Задание № 2 *************** */
// console.log(`****** Задание № 2 ******`);

// const btnElement = document.querySelector(".btn");
// console.log(btnElement.classList);

// for (const btnSecondEl of btnElement.classList) {

//   if (btnSecondEl === "btn-secondary") {
//     btnElement.classList.remove("btn-secondary");
//   } else {
//     btnElement.classList.add("btn-secondary");
//   }
// }
// console.log(btnElement.classList);




// /* *************** Задание № 3 *************** */
// console.log(`****** Задание № 3 ******`);

// const menuElement = document.querySelector('.menu');
// console.log(menuElement);

// if (menuElement !== null) {
//     menuElement.classList.remove('dropdown-menu');
//     console.log(menuElement.classList);
// } else {
//     console.log('Элемент, содержащий класс "menu", отсутствует');
// }



// /* *************** Задание № 4 *************** */
// console.log(`****** Задание № 4 ******`);

// const divDropDownEl = document.querySelector("div.dropdown");
// console.log(divDropDownEl);

// divDropDownEl.insertAdjacentHTML('afterend', '<a href="#">link</a>')
// console.log(divDropDownEl.nextElementSibling);




// /* *************** Задание № 5 *************** */
// console.log(`****** Задание № 5 ******`);

// const idElement = document.querySelector('#dropdownMenuButton');
// console.log(idElement);

// idElement.setAttribute('id', 'superDropdown');
// console.log(idElement);



// /* *************** Задание № 6 *************** */
// console.log(`****** Задание № 6 ******`);

// const  ariaLabelledbyAtr = document.querySelector('[aria-labelledby="dropdownMenuButton"]');
// console.log(ariaLabelledbyAtr);

// ariaLabelledbyAtr.setAttribute('data-dd', '3');



/* *************** Задание № 7 *************** */
console.log(`****** Задание № 7 ******`);

const  dropdownToggleClass = document.querySelector('.dropdown-toggle');
console.log(dropdownToggleClass);

dropdownToggleClass.removeAttribute('type');

