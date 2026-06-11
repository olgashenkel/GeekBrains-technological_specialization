import React from 'react';
import Message from './Message';
import './App.css';

function App() {
  return (
    <div className="App" style={{ padding: '40px 20px', textAlign: 'center' }}>
      <h1>Урок 1. Знакомство с React и первые компоненты.<br></br>Работа с JSX</h1>
      <h1>Домашняя работа</h1>
      
      <Message text="Добро пожаловать в React-приложение!" />
      <Message text="Проект был успешно развернут с помощью утилиты create-react-app." />
      <Message text="Компонент принимает данный текст через обычные props." />
    </div>
  );
}

export default App;
