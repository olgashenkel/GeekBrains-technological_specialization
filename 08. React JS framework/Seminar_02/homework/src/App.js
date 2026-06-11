import React from 'react';
import CommentsList from './CommentsList'; 

function App() {
  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '40px' }}>
      <h1 style={{ textAlign: 'center' }}>Урок 2. State, Props. <br></br>Жизненный цикл react компонента. Хуки</h1>
            <h2 style={{ textAlign: 'center' }}>Домашняя работа</h2>
            
      {/* Компонент Списка комментариев с удалением */}
      <CommentsList />
    </div>
  );
}

export default App;
