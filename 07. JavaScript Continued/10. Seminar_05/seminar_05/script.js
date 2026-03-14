"use strict";

let divEl = document.createElement("div");
let bodyEl = document.querySelector("body");
let parseData = JSON.parse(data);

bodyEl.appendChild(divEl);
console.log(parseData);

parseData.message.forEach((element) => {
  divEl.insertAdjacentHTML(
    "beforeend",
    `
    <figure>
  <img src="${element}"
    alt="Elephant at sunset" />
  <figcaption>An elephant at sunset</figcaption>
</figure>`,
  );
});

let urlEl = "https://jsonplaceholder.typicode.com/users";
async function getData(urlEl) {
  const response = await fetch(urlEl);
  const jsonEl = await response.json();
  return jsonEl;
}

try {
  const myData = await getData(urlEl);
  console.log(myData);
  myData.forEach(element => {
    divEl.insertAdjacentHTML("beforeend", `
      <h2>${element.name}</h2>
      <p>${element.email}</p>`)
  })
} catch (error) {
  console.log(error.message);
}