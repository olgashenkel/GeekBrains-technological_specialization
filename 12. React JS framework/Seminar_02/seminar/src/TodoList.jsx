import React, { useState } from 'react';

function TodoList() {
  // Состояние для списка дел (массив)
  const [todos, setTodos] = useState([]);
  // Состояние для текущего текста в поле ввода
  const [inputValue, setInputValue] = useState('');

  // Функция добавления нового дела
  const handleAddTodo = (e) => {
    e.preventDefault(); // Предотвращаем перезагрузку страницы при отправке формы
    
    if (inputValue.trim() === '') return; // Проверка на пустую строку

    // Добавляем новое дело в массив и очищаем поле ввода
    setTodos([...todos, inputValue.trim()]);
    setInputValue('');
  };

  return (
    <div style={{ textAlign: 'center', margin: '20px auto', padding: '20px', border: '1px solid #ccc', borderRadius: '8px', maxWidth: '350px' }}>
      <h3>Список дел</h3>
      
      {/* Форма для ввода и отправки */}
      <form onSubmit={handleAddTodo} style={{ marginBottom: '15px' }}>
        <input 
          type="text" 
          value={inputValue}
          onChange={(e) => setInputValue(e.target.value)}
          placeholder="Что нужно сделать?"
          style={{ padding: '8px', width: '65%', marginRight: '5px', fontSize: '14px' }}
        />
        <button type="submit" style={{ padding: '8px 12px', fontSize: '14px', cursor: 'pointer' }}>
          Добавить
        </button>
      </form>

      {/* Вывод списка дел */}
      <ul style={{ textAlign: 'left', paddingLeft: '20px', listStyleType: 'square' }}>
        {todos.map((todo, index) => (
          <li key={index} style={{ margin: '5px 0', wordBreak: 'break-word' }}>
            {todo}
          </li>
        ))}
      </ul>

      {/* Сообщение, если список пуст */}
      {todos.length === 0 && <p style={{ color: '#888', fontSize: '14px' }}>Список пока пуст</p>}
    </div>
  );
}

export default TodoList;
