import 'react';
// import Greeting from './components/Greeting'; 
// import Counter from './components/Counter';
// import MessagesList from './components/MessagesList';
// import TextDisplayForm from './components/TextDisplayForm';
import ThemeSwitcher from './components/ThemeSwitcher';


import './App.css';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h2>Урок 3. Virtual DOM. Подключение библиотеки UI-компонентов</h2>
      {/* <h3 style={{ color: '#da4e0d', fontFamily: 'sans-serif' }}>Задание № 1</h3>
      
      <Greeting name="Алексей" />
      <Greeting name="Мария" />
      <Greeting name="Иван" /> */}

      {/* <h3 style={{ color: '#da4e0d', fontFamily: 'sans-serif' }}>Задание № 2</h3>
      <Counter /> */}

      {/* <h3 style={{ color: '#da4e0d', fontFamily: 'sans-serif' }}>Задание № 3</h3>
      <MessagesList /> */}

      {/* <h3 style={{ color: '#da4e0d', fontFamily: 'sans-serif' }}>Задание № 4</h3>
      <TextDisplayForm /> */}


      <h3 style={{ color: '#da4e0d', fontFamily: 'sans-serif' }}>Задание № 5*</h3>
      <ThemeSwitcher />

    </div>
  );
}

export default App;
