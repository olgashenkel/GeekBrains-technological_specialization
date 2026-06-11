import 'react';

function MessagesList() {
  // Массив объектов с сообщениями. У каждого есть уникальный id и текст.
  const messages = [
    { id: 1, text: 'Привет! Добро пожаловать в React.' },
    { id: 2, text: 'Не забывайте использовать уникальные ключи (key).' },
    { id: 3, text: 'Vite обеспечивает очень быструю сборку проекта!' },
    { id: 4, text: 'Изучение списков и ключей завершено успешно.' }
  ];

  return (
    <div style={{ maxWidth: '500px', margin: '20px auto', textAlign: 'left' }}>
      <h3>Список сообщений:</h3>
      <ul>
        {/* Перебираем массив с помощью метода map */}
        {messages.map((message) => (
          <li key={message.id} style={{ marginBottom: '8px', fontSize: '16px' }}>
            {message.text}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default MessagesList;
