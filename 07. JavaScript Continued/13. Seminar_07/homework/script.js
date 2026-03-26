"use strict";
const url = "./data.json";
const productListUlEl = document.getElementById("product-list");
const cartListEl = document.getElementById("cart-list");


// Получение данных из JSON-файла
async function getData(url) {
  try {
    const response = await fetch(url);
    const data = await response.json();
    return data
  } catch (error) {
    console.error('Ошибка загрузки:', error.message);
  }
};




document.addEventListener("DOMContentLoaded", async (e) => {
  const data = await getData(url);


  // Отрисовка товаров для основной страницы
  data.forEach((element) => {
    const productListLiEl = document.createElement("li");
    productListLiEl.classList.add("productIndex-box");
    productListLiEl.insertAdjacentHTML(
      "beforeend",
      `
      <div class="productIndex">
        <img class="productIndex__img" src="${element.image}" alt="${element.title}">
        <div class="productIndex__img_blackout">
          <button class="productIndex__img_blackout_button" data-id="${element.id}">
              <img class="productIndex__img_blackout_button_img" src="img/Vector/Cart_Vector.png"
                  alt="shopping cart">
              <p class="productIndex__img_blackout_button_text">Add to Cart</p>
          </button>
        </div>

        <div class="productIndex__content">
          <a href="#" class="productIndex__name">${element.title}</a>
          <p class="productIndex__text">${element.description}</p>
          <p class="productIndex__price">$${element.price.toFixed(2)}</p>
        </div>
      </div>
    `);
    productListUlEl.appendChild(productListLiEl);
  });


  // Добавление товара в корзину при клике по кнопке
  productListUlEl.addEventListener('click', (e) => {
    // Проверяем, кликнули ли мы по кнопке или по тексту/иконке внутри неё
    const btn = e.target.closest('.productIndex__img_blackout_button');

    if (btn) {
      const productId = btn.dataset.id; // Получаем ID из атрибута data-id
      // Находим данные этого товара в массиве data
      const productData = data.find(item => item.id == productId);

      if (productData) {
        renderCartItem(productData);
      }
    }
  });


});


// Функция добавления товара в корзину и отрисовка карточки товара
function renderCartItem({
  title,
  image,
  price,
  color,
  size
}) {
  const cartItem = document.createElement("li");
  cartItem.classList.add("cart");

  cartItem.innerHTML = `
    <div class="card">
      <img src="${image}" alt="${title}" />
      <div class="description">
        <h2>${title}</h2>
        <div class="list">
          <p>Price: <span class="red">$${price}</span></p>
          <p>Color: <span class="grey">${color}</span></p>
          <p>Size: <span class="grey">${size}</span></p>
          <p>Quantity: <input id="inputIdCartItem" class="inputCount" type="number" value="1" /></p>
        </div>
      </div>

    <button class="delete">
      <svg
        width="18"
        height="18"
        viewBox="0 0 18 18"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M11.2453 9L17.5302 2.71516C17.8285 2.41741 17.9962 2.01336 17.9966 1.59191C17.997 1.17045 17.8299 0.76611 17.5322 0.467833C17.2344 0.169555 16.8304 0.00177586 16.4089 0.00140366C15.9875 0.00103146 15.5831 0.168097 15.2848 0.465848L9 6.75069L2.71516 0.465848C2.41688 0.167571 2.01233 0 1.5905 0C1.16868 0 0.764125 0.167571 0.465848 0.465848C0.167571 0.764125 0 1.16868 0 1.5905C0 2.01233 0.167571 2.41688 0.465848 2.71516L6.75069 9L0.465848 15.2848C0.167571 15.5831 0 15.9877 0 16.4095C0 16.8313 0.167571 17.2359 0.465848 17.5342C0.764125 17.8324 1.16868 18 1.5905 18C2.01233 18 2.41688 17.8324 2.71516 17.5342L9 11.2493L15.2848 17.5342C15.5831 17.8324 15.9877 18 16.4095 18C16.8313 18 17.2359 17.8324 17.5342 17.5342C17.8324 17.2359 18 16.8313 18 16.4095C18 15.9877 17.8324 15.5831 17.5342 15.2848L11.2453 9Z"
          fill="#575757"
        />
      </svg>
    </button>

    </div>
  `;
  cartListEl.appendChild(cartItem);

  // Удаляем карточку при клике на кнопку
  cartItem.addEventListener("click", (e) => {
    if (e.target.closest(".delete")) {
      const card = e.target.closest(".card");
      if (card) {
        cartItem.remove(card);
      }
    }
  });
}