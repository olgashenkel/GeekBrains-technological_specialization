import React, { useState } from 'react';

function CommentsList() {
  // Инициализируем состояние начальным массивом комментариев
  const [comments, setComments] = useState([
    { id: 1, text: "Это первый комментарий" },
    { id: 2, text: "Это второй комментарий" },
    { id: 3, text: "Это третий комментарий" }
  ]);

  // Функция для удаления комментария по его id
  const handleDelete = (id) => {
    // Фильтруем массив, оставляя только те элементы, id которых не равен удаляемому
    const updatedComments = comments.filter(comment => comment.id !== id);
    // Обновляем состояние новым массивом
    setComments(updatedComments);
  };

  return (
    <div style={{ margin: '20px auto', padding: '20px', border: '1px solid #ccc', borderRadius: '8px', maxWidth: '400px' }}>
      <h3 style={{ textAlign: 'center' }}>Список комментариев</h3>
      
      {/* Проверка: если комментариев нет, выводим заглушку */}
      {comments.length === 0 ? (
        <p style={{ color: '#888', textAlign: 'center' }}>Комментариев пока нет</p>
      ) : (
        <ul style={{ listStyleType: 'none', padding: 0 }}>
          {comments.map((comment) => (
            <li 
              key={comment.id} 
              style={{ 
                display: 'flex', 
                justifyContent: 'space-between', 
                alignItems: 'center', 
                padding: '10px', 
                borderBottom: '1px solid #eee',
                gap: '10px'
              }}
            >
              <span style={{ wordBreak: 'break-word' }}>{comment.text}</span>
              {/* Передаем id комментария в функцию удаления при клике */}
              <button 
                onClick={() => handleDelete(comment.id)}
                style={{ 
                  backgroundColor: '#ff4d4f', 
                  color: 'white', 
                  border: 'none', 
                  borderRadius: '4px', 
                  padding: '5px 10px', 
                  cursor: 'pointer' 
                }}
              >
                Удалить
              </button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default CommentsList;
