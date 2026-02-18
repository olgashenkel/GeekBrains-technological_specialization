// /* *************** Задание № 1 *************** */
// console.log(`****** Задание № 1 ******`);

// const idElement = document.getElementById('super_link');
// console.log(idElement);


// /* *************** Задание № 2 *************** */
// console.log(`****** Задание № 2 ******`);

// const idElement = document.querySelectorAll('.card-link');
// console.log(idElement);

// idElement.forEach(element => {
//     // console.log(element.textContent);
//     element.textContent = 'Ссылка';
//     console.log(element.textContent);
// });


// /* *************** Задание № 3 *************** */
// console.log(`****** Задание № 3 ******`);

// const cardBodyElement = document.querySelector('.card-body');
// console.log(cardBodyElement);
// const cardLinkElement = cardBodyElement.querySelectorAll('.card-link');
// console.log(cardLinkElement);



// /* *************** Задание № 4 *************** */
// console.log(`****** Задание № 4 ******`);

// const dataNumberElem = document.querySelector('[data-number="50"]');
// console.log(dataNumberElem);



// /* *************** Задание № 5 *************** */
// console.log(`****** Задание № 5 ******`);

// const titleTeg = document.querySelector('title');
// console.log(titleTeg);



// /* *************** Задание № 6 *************** */
// console.log(`****** Задание № 6 ******`);

// const cardTitleElem = document.querySelector('.card-title');
// console.log(cardTitleElem.nodeName);
// console.log(cardTitleElem.parentNode);




/* *************** Задание № 7 *************** */
// console.log(`****** Задание № 7 ******`);

// const elementP = document.createElement('p');
// elementP.textContent = 'Привет';
// // console.log(elementP);

// document.querySelector('.card').prepend(elementP);
// console.log(elementP);


/* *************** Задание № 8 *************** */
console.log(`****** Задание № 8 ******`);

const h6Element = document.querySelectorAll('h6');
console.log(h6Element);
h6Element.forEach(element => {
    element.remove();
});
