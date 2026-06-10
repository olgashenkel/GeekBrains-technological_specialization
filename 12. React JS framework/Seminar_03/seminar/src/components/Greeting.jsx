import 'react';

// Компонент принимает объект props, из которого мы деструктуризируем свойство name
function Greeting({ name }) {
  return (
    <h2>Привет, {name}!</h2>
  );
}

export default Greeting;
