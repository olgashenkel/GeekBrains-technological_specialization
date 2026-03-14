"use strict";


// // Создание переменной productName (первый вариант для создания страницы товаров):
// // // let productName = 'Новое название';

// // Меняем значение productName на массив данных (второй вариант для создания страницы товаров):
// // const productName = ['Новое название', 'Новое название 2'];

// // Меняем значение productName на Объект данных (третий вариант для создания страницы товаров):
// // const productData = {
// //   name: "Название товара obj",
// //   price: 80
// // };

// // Меняем значение productName на массив Объектов данных (четвертый вариант для создания страницы товаров):
// const productData = [
//   {
//     name: "Название товара obj 1",
//     price: 80,
//   },
//   {
//     name: "Название товара obj 2",
//     price: 50,
//   },
// ];

// let productPrice = 70;

// const productNameLink = document.querySelector(".product__name");
// const productsPrice = document.querySelector(".product__price");

// // 1-3 вариант для создания страницы товаров
// // productNameLink.textContent = productName;
// // productsPrice.textContent = productPrice;

// // 3 вариант для создания страницы товаров
// // productNameLink.textContent = productData.name;
// // productsPrice.textContent = productData.price;

// // 4 вариант для создания страницы товаров
// productNameLink.textContent = productData[0].name;
// productsPrice.textContent = productData[0].price;

// /* --------- Наполнение шаблона (1-ый вариант): --------- */
// const productData = {
//   src: "img.png",
//   alt: "img obj data",
//   name: "Название из objData",
//   link: "product.html",
//   desc: 'Описание товара из objData',
//   price: 21_000,
// };

/* --------- Наполнение шаблона в массивом Объектов (2-ой вариант): --------- */
const productsData = [
  {
    src: "img.png",
    alt: "img obj data",
    name: "Название из objData",
    link: "product.html",
    desc: "Описание товара из objData",
    price: 21_000,
  },
  {
    src: "img2.png",
    alt: "img obj data NEW Photo",
    name: "Название НОВОГО ТОВАРА из objData",
    link: "product2.html",
    desc: "Описание НОВОГО товара из objData",
    price: 11_000,
  },
    {
    src: "img3.png",
    alt: "img obj data NEW Photo 3",
    name: "Название НОВОГО ТОВАРА 3 из objData",
    link: "product3.html",
    desc: "Описание НОВОГО товара 3 из objData",
    price: 1_000,
  },
];

// /* --------- Шаблонизация продукта по следующему типу данных: ---------
// <div class="product-box">
//       <div class="product">
//       <img class="product__img" src="photo.jpg" alt="photo" />
//       <div class="product__content">
//         <a class="product__name" href="product.html">Продукт из HTML</a>
//         <p class="product__text">
//           Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quisquam, veritatis?
//         </p>
//         <p class="product__price">55</p>
//       </div>
// </div>
// */
// const productBox = document.querySelector(".product-box");

// const productEl = document.createElement("div");
// productEl.classList.add("product");

// const productImg = document.createElement("img");
// productImg.classList.add("product__img");

// // productImg.setAttribute('alt', 'photo js');
// // productImg.src = 'photo2.jpg';

// // Замена данных на значение Объекта productData:
// productImg.setAttribute("alt", productData.alt);
// productImg.src = productData.src;

// const productContent = document.createElement("div");
// productContent.classList.add("product__content");

// const productLink = document.createElement("a");
// // productLink.href = "product.html";
// // productLink.textContent = 'Название товара из JS';
// // Замена данных на значение Объекта productData:
// productLink.href = productData.link;
// productLink.textContent = productData.name;

// const productText = document.createElement("p");
// productText.classList.add("product__text");
// // productText.textContent = "Описание товара из JS";
// // Замена данных на значение Объекта productData:
// productText.textContent = productData.desc;

// const productPrice = document.createElement("p");
// productPrice.classList.add("product__price");
// // productPrice.textContent = 22_000;
// // Замена данных на значение Объекта productData:
// productPrice.textContent = productData.price;

// productEl.appendChild(productImg);
// productEl.appendChild(productContent);
// productContent.appendChild(productLink);
// productContent.appendChild(productText);
// productContent.appendChild(productPrice);

// productBox.appendChild(productEl);



/* --------- Шаблонизация продукта с помощью цикла ForEach: --------- */
const productBox = document.querySelector(".product-box");

productsData.forEach(productData => {
  const productEl = document.createElement("div");
  productEl.classList.add("product");

  const productImg = document.createElement("img");
  productImg.classList.add("product__img");

  // productImg.setAttribute('alt', 'photo js');
  // productImg.src = 'photo2.jpg';

  // Замена данных на значение Объекта productData:
  productImg.setAttribute("alt", productData.alt);
  productImg.src = productData.src;

  const productContent = document.createElement("div");
  productContent.classList.add("product__content");

  const productLink = document.createElement("a");
  // productLink.href = "product.html";
  // productLink.textContent = 'Название товара из JS';
  // Замена данных на значение Объекта productData:
  productLink.href = productData.link;
  productLink.textContent = productData.name;

  const productText = document.createElement("p");
// Пример замены блока P на заголовок H2 для всех товаров одновременно
// const productText = document.createElement("h2");
  productText.classList.add("product__text");
  // productText.textContent = "Описание товара из JS";
  // Замена данных на значение Объекта productData:
  productText.textContent = productData.desc;

  const productPrice = document.createElement("p");
  productPrice.classList.add("product__price");
  // productPrice.textContent = 22_000;
  // Замена данных на значение Объекта productData:
  productPrice.textContent = productData.price;

  productEl.appendChild(productImg);
  productEl.appendChild(productContent);
  productContent.appendChild(productLink);
  productContent.appendChild(productText);
  productContent.appendChild(productPrice);

  productBox.appendChild(productEl);
});
