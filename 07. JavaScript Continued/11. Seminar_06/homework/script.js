"use strict";

const url = "./data.json";

async function getData(url) {
  try {
    const response = await fetch(url);
    const data = await response.json();
    return data;
  } catch (error) {
    console.log(error.message);
  }
}

// Получаем данные из JSON и отрисовываем карточки
document.addEventListener("DOMContentLoaded", async (e) => {
  const data = await getData(url);
  const productIndexClass = document.querySelector(".productIndex-box");
  data.forEach((element) => {
    productIndexClass.insertAdjacentHTML(
      "beforeend",
      `
      <div class="productIndex">
        <img class="productIndex__img" src="${element.image}" alt="${element.title}">
        <div class="productIndex__img_blackout">
          <button class="productIndex__img_blackout_button">
              <img class="productIndex__img_blackout_button_img" src="img/Vector/Сart_Vector.png"
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

    `,
    );
  });

  // Добавляем товар в корзину

  // Инициализация корзины из localStorage или создание пустого массива
  let cart = JSON.parse(localStorage.getItem("cart")) || [];

  // Находим все кнопки "Добавить в корзину"
  const buttons = document.querySelectorAll(
    ".productIndex__img_blackout_button",
  );

  buttons.forEach((button) => {
    button.addEventListener("click", (e) => {
      // Получаем родительский элемент товара
      const productElement = e.target.closest(".productIndex");

      // Формируем объект товара
      const product = {
        id: productElement.dataset.id,
        title: productElement.dataset.title,
        price: productElement.dataset.price,
        count: 1,
      };

      // Проверяем, есть ли товар уже в корзине
      const existingProduct = cart.find((item) => item.id === product.id);

      if (existingProduct) {
        existingProduct.count++; // Если есть, увеличиваем количество
        console.log(existingProduct.count);
      } else {
        cart.push(product); // Если нет, добавляем новый
      }

      // Сохраняем обновленную корзину в localStorage
      localStorage.setItem("cart", JSON.stringify(cart));

      alert("Товар добавлен в корзину!");
    });
  });
});

/*
Ключевые моменты:
e.target — указывает на элемент, по которому кликнули.
e.target.closest('.productIndex') — поднимается вверх по DOM-дереву от крестика, чтобы найти элемент с классом .card.
localStorage: позволяет сохранять состояние корзины даже после перезагрузки страницы.
*/
