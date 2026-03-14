// Функция для добавления данных в контент в список Ul и Li:
function addElementsToUl(containerID, dataJSON) {
  // Поиск элемента по ID
  const productListEl = document.getElementById(containerID);

  // Перебор данных, полученных из JSON  файла, создание и добавление новых данных для карточки товара:
  dataJSON.forEach((dataEl) => {
    // Создание элемента Li
    const productLiEl = document.createElement("li");
    productLiEl.classList.add("product_card");

    // Добавление рисунка в карточку
    const productImg = document.createElement("img");
    productImg.classList.add("product__img");
    productImg.src = dataEl.image;
    productImg.alt = dataEl.title;

    // Добавление заголовка в карточку
    const productTitle = document.createElement("h2");
    productTitle.classList.add("product__title");
    productTitle.textContent = dataEl.title;

    // Добавление описания в карточку
    const productDescription = document.createElement("p");
    productDescription.classList.add("product__description");
    productDescription.textContent = dataEl.description;

    // Добавление цены в карточку
    const productPrice = document.createElement("p");
    productPrice.classList.add("product__price");
    productPrice.textContent = `Price: ${dataEl.price.toFixed(2)}`;

    // Добавление кнопки “Add to Cart” в карточку
    const productButton = document.createElement("button");
    productButton.classList.add("product__button");
    productButton.setAttribute('data-id', dataEl.id);
    productButton.textContent = 'Add to Cart';

    // Добавление всех элементов в карточку товара Li
    productLiEl.append(productImg, productTitle, productDescription, productPrice, productButton);

    // Добавление карточки товара в основной раздел UL
    productListEl.append(productLiEl);
  });
}

addElementsToUl("product-list", data);
