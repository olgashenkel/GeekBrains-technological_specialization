/* *************** Задание № 1 *************** */
// console.log(`****** Задание № 1 ******`);

// const inputFromEl = document.getElementById("from");
// const spanEl = document.querySelector("span");
// console.log(inputFromEl);
// console.log(spanEl);

// inputFromEl.addEventListener("input", (e) => {
//   spanEl.textContent = inputFromEl.value;
// });

/* *************** Задание № 2 *************** */
// console.log(`****** Задание № 2 ******`);

// const messageBtnEl = document.querySelector(".messageBtn");
// console.log(messageBtnEl);
// const messageEl = document.querySelector(".message");
// console.log(messageEl);

// messageBtnEl.addEventListener("click", (e) => {
//   messageEl.classList.add("animate_animated", "animate_fadeInLeftBig");
//   messageEl.style.visibility = "visible";
//   console.log(messageEl);
// });

/* *************** Задание № 3 *************** */
console.log(`****** Задание № 3 ******`);

const formEl = document.querySelector("form");
console.log(formEl);

const inputEl = formEl.querySelectorAll(".form-control");
console.log(inputEl);

formEl.addEventListener("submit", (e) => {
  let valid = true;
  inputEl.forEach((input) => {
    if (input.value.trim() === "") {
      input.classList.add("error");
      valid = false;
    }
  });
  if (!valid) {
    e.preventDefault(); // Предотвращаем отправку формы, если есть ошибки
  }
});
inputEl.forEach((input) => {
  input.addEventListener("input", () => {
    if (input.value.trim() === "") {
      input.classList.add("error");
    } else {
      input.classList.remove("error");
    }
  });
});
