// alert("hello");
// prompt('Сколько Вам лет?', 30);
// confirm();


/* ****************** Загадка для пользователя ****************** */

// let userAnswer = prompt("Зимой и летом одним цветом?");

// userAnswer = userAnswer.toLowerCase().trim();

// if (userAnswer === "") {
//   console.log("Нет ответа");
// } else if (userAnswer === "ёлка" || userAnswer === "елка") {
//   alert("Ответ верный!");
// } else {
//   alert("Ошибка!");
// }


// (userAnswer.toLowerCase().trim() === "ёлка" || userAnswer.toLowerCase().trim() === "елка") ? alert("Ответ верный!") : alert("Ошибка!");

// alert((userAnswer.toLowerCase().trim() === "ёлка" || userAnswer.toLowerCase().trim() === "елка") ? "Ответ верный!" : "Ошибка!");



/* ****************** Проверка пароля ****************** */
// let pass = prompt('Введите пароль');
// pass = Number(pass);
// pass = String(pass);
// if (pass === 123) {
//     alert('Далее...')
// } else {
//     alert('Ошибка!')
// }


// или:

let pass = Number(prompt('Введите пароль'));
alert((pass === 123) ? 'Далее...' : 'Ошибка!');
