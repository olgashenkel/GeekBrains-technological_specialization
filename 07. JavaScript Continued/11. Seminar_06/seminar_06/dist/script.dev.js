"use strict";

var url = "./data.json";

function getData(url) {
  var response, data;
  return regeneratorRuntime.async(function getData$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          _context.prev = 0;
          _context.next = 3;
          return regeneratorRuntime.awrap(fetch(url));

        case 3:
          response = _context.sent;
          _context.next = 6;
          return regeneratorRuntime.awrap(response.json());

        case 6:
          data = _context.sent;
          return _context.abrupt("return", data);

        case 10:
          _context.prev = 10;
          _context.t0 = _context["catch"](0);
          console.log(_context.t0.message);

        case 13:
        case "end":
          return _context.stop();
      }
    }
  }, null, null, [[0, 10]]);
} // Получаем данные из JSON и отрисовываем карточки


document.addEventListener("DOMContentLoaded", function _callee(e) {
  var data, listClass;
  return regeneratorRuntime.async(function _callee$(_context2) {
    while (1) {
      switch (_context2.prev = _context2.next) {
        case 0:
          _context2.next = 2;
          return regeneratorRuntime.awrap(getData(url));

        case 2:
          data = _context2.sent;
          listClass = document.querySelector(".cards");
          data.forEach(function (element) {
            listClass.insertAdjacentHTML("beforeend", "\n  <div class=\"card\">\n          <img src=\"".concat(element.img, "\" alt=\"").concat(element.title, "\" />\n          <div class=\"description\">\n            <h2>").concat(element.title, "</h2>\n            <div class=\"list\">\n              <p>Price: <span class=\"red\">$").concat(element.price, "</span></p>\n              <p>Color: <span class=\"grey\">").concat(element.color, "</span></p>\n              <p>Size: <span class=\"grey\">").concat(element.size, "</span></p>\n              <p>Quantity: <input id=\"inputCount\" type=\"number\" value=\"").concat(element.count, "\" /></p>\n            </div>\n          </div>\n\n          <button class=\"delete\">\n            <svg\n              width=\"18\"\n              height=\"18\"\n              viewBox=\"0 0 18 18\"\n              fill=\"none\"\n              xmlns=\"http://www.w3.org/2000/svg\"\n            >\n              <path\n                d=\"M11.2453 9L17.5302 2.71516C17.8285 2.41741 17.9962 2.01336 17.9966 1.59191C17.997 1.17045 17.8299 0.76611 17.5322 0.467833C17.2344 0.169555 16.8304 0.00177586 16.4089 0.00140366C15.9875 0.00103146 15.5831 0.168097 15.2848 0.465848L9 6.75069L2.71516 0.465848C2.41688 0.167571 2.01233 0 1.5905 0C1.16868 0 0.764125 0.167571 0.465848 0.465848C0.167571 0.764125 0 1.16868 0 1.5905C0 2.01233 0.167571 2.41688 0.465848 2.71516L6.75069 9L0.465848 15.2848C0.167571 15.5831 0 15.9877 0 16.4095C0 16.8313 0.167571 17.2359 0.465848 17.5342C0.764125 17.8324 1.16868 18 1.5905 18C2.01233 18 2.41688 17.8324 2.71516 17.5342L9 11.2493L15.2848 17.5342C15.5831 17.8324 15.9877 18 16.4095 18C16.8313 18 17.2359 17.8324 17.5342 17.5342C17.8324 17.2359 18 16.8313 18 16.4095C18 15.9877 17.8324 15.5831 17.5342 15.2848L11.2453 9Z\"\n                fill=\"#575757\"\n              />\n            </svg>\n          </button>\n        </div>\n    "));
          }); // Удаляем карточку при клике на кнопку

          listClass.addEventListener("click", function (e) {
            if (e.target.closest(".delete")) {
              var card = e.target.closest(".card");

              if (card) {
                card.remove();
              }
            }
          });

        case 6:
        case "end":
          return _context2.stop();
      }
    }
  });
});
/*
Ключевые моменты:
e.target — указывает на элемент, по которому кликнули (крестик).
e.target.closest('.card') — поднимается вверх по DOM-дереву от крестика, чтобы найти элемент с классом .card.
.remove() — удаляет найденный элемент из HTML.
*/