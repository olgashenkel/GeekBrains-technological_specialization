import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addTask } from '../store/todoSlice';

export const AddTask = () => {
  const [text, setText] = useState('');
  const dispatch = useDispatch();

  const handleAdd = (e) => {
    e.preventDefault();
    if (text.trim() === '') return; // Защита от пустых задач

    dispatch(addTask(text));
    setText(''); // Очистка поля ввода
  };

  return (
    <form onSubmit={handleAdd} style={{ marginBottom: '20px' }}>
      <input
        type="text"
        value={text}
        onChange={(e) => setText(e.target.value)}
        placeholder="Введите описание задачи..."
        style={{ padding: '8px', marginRight: '10px', width: '250px' }}
      />
      <button type="submit" style={{ padding: '8px 12px' }}>
        Добавить
      </button>
    </form>
  );
};
