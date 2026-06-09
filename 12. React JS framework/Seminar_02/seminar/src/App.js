import React from 'react';
import Counter from './Counter'; 
import TextInput from './TextInput'; 
import TodoList from './TodoList'; 
import Timer from './Timer';


function App() {
  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '40px' }}>
      <h1 style={{ textAlign: 'center' }}>Урок 2. State, Props. <br></br>Жизненный цикл react компонента. Хуки</h1>
        
      {/* Компонент Счетчика */}
      {/* <Counter />  */}
      
      {/* Компонент Текстового ввода */}
      {/* <TextInput /> */}

      {/* Компонент Списка дел */}
      {/* <TodoList /> */}

      {/* Компонент Таймера */}
      <Timer />
    </div>
  );
}

export default App;
