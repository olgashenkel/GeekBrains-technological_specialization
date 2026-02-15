// // const productNew = {
// //     name: 'Стол',
// //     price: 2000,
// //     count: 0,
// //     userRegistered: false,
// //     registered: function (){
// //         this.userRegistered = true;
// //     },
// //     countProduct: function () {
// //         if (this.count > 0) {
// //             console.log('Вы можете купить данный товар');
// //         } else {
// //             console.log('Данный товар нельзя добавить в корзину');
// //         }
// //     },
// //     buyProduct: function (){
// //         if (this.userRegistered) {
// //             console.log('Данный товар добавлен в корзину');
// //         } else {
// //             console.log('Для продолжения Вам необходимо зарегистрироваться (выполнить действие product.registered())');
// //         }
// //     }
// // };

// // // console.log(product);
// // // product.link = 'product/linkname.html';
// // // console.log(product);
// // // product.link = 'catalog/linkname.html';

// // // let productSale = product;
// // // console.log(productSale);
// // // productSale.price = 1500;
// // // console.log(productSale);
// // // console.log(product);

// // productNew.buyProduct();
// // productNew.registered();
// // productNew.buyProduct();

// const productTest = {
//   text: "hello",
//   price: 1000,
// };

// for (const key in productTest) {
//   console.log(key);
// }

// for (const key in productTest) {
//   console.log(productTest.key);
// }

// for (const key in productTest) {
//   console.log(productTest[key]);
// }

// console.log(productTest['text']);

const array = [1, 5, 6, 8, 14];
console.log(array);

console.log(array.map((item) => item * 2));

const arrayUp = array.map((item) => item * 2);
console.log(arrayUp);

console.log(array.filter((item) => item >= 10));

console.log(array.some((item) => item >= 10));

console.log(array.reduce((a, b) => a + b)/array.length);
