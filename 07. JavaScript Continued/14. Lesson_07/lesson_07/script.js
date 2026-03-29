"use strict";

// /*
// ****************** Геолокация ******************

// Чтобы получить текущее местоположения пользователя, надо вызвать метод
// getCurrentPosition().*/

// navigator.geolocation.getCurrentPosition((position) => {

//     console.log(position);
//     const {
//         latitude,
//         longitude
//     } = position.coords
//     console.log('Географические координаты устройства', latitude, longitude)
// });


// /*
// Если мы хотим следить за изменениями местоположения устройства, это делается с помощью функции watchPosition(), которая имеет три входных параметра, похожих на getCurrentPosition(). Переданные ей в параметрах callback-функции вызываются много раз, позволяя браузеру обновлять данные о текущей локации либо во время движения, либо после получения более точной информации о местоположении после применения более точных
// методов позиционирования.
// */
// let watchId = navigator.geolocation.watchPosition(({
//     coords
// }) => {
//     console.log('Устройство обновило местоположение', coords.latitude,
//         coords.longitude)
// });

// /*
// Обработка ошибок
// Callback-функция обработки ошибок, если она была передана в getCurrentPosition() или watchPosition(), ожидает экземпляр объекта GeolocationPositionError в качестве первого аргумента.

// Он будет содержать два свойства:
// ● code — условное обозначение ошибки, которая произошла;
// ● message — понятное для человека описание ошибки, названной в поле code.*/

// const handlePositionError = (error) => {
//     switch (error.code) {
//         case 1:
//             console.log('Пользователь ограничил доступ к местоположению')
//             break
//         case 2:
//             console.log('Ошибка устройства определения местоположения')
//             break
//         case 3:
//             console.log('Достигнут тайм-аут')
//             break
//         default:
//             console.log('Извините, местоположение недоступно', error)
//             break
//     }
// }



/*
Использование Drag and Drop API
*/
const items = document.querySelectorAll('.container .box')
const handleDragStart = ({
    target
}) => {
    target.style.opacity = '0.4'
}
const handleDragEnd = ({
    target
}) => {
    target.style.opacity = '1'
    items.forEach((item) => {
        item.classList.remove('over')
    })
}
const handleDragOver = (event) => {
    if (event.cancelable) {
        event.preventDefault()
    }
    return false
}
const handleDragEnter = ({
    target
}) => {
    target.classList.add('over')
}
const handleDragLeave = ({
    target
}) => {
    target.classList.remove('over')
}
items.forEach((item) => {
    item.addEventListener('dragstart', handleDragStart)
    item.addEventListener('dragover', handleDragOver)
    item.addEventListener('dragenter', handleDragEnter)
    item.addEventListener('dragleave', handleDragLeave)
    item.addEventListener('dragend', handleDragEnd)
})