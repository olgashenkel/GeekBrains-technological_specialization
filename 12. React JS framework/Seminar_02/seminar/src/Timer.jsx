import React, { useState, useEffect } from 'react';

function Timer() {
  // Состояние для хранения количества секунд
  const [seconds, setSeconds] = useState(0);

  useEffect(() => {
    // Создаем интервал, который срабатывает каждую 1000 мс (1 секунду)
    const intervalId = setInterval(() => {
      // Используем функцию-колбэк, чтобы всегда работать с актуальным состоянием
      setSeconds((prevSeconds) => prevSeconds + 1);
    }, 1000);

    // ВАЖНО: Возвращаем функцию очистки
    // Она сработает, когда компонент удалится со страницы (размонтируется)
    return () => {
      clearInterval(intervalId);
    };
  }, []); // Пустой массив зависимостей означает, что эффект запустится только 1 раз при старте компонента

  return (
    <div style={{ textAlign: 'center', margin: '20px auto', padding: '20px', border: '1px solid #ccc', borderRadius: '8px', maxWidth: '250px' }}>
      <h3>Прошло времени:</h3>
      <h2 style={{ fontSize: '32px', margin: '10px 0', color: '#007bff' }}>
        {seconds} сек.
      </h2>
    </div>
  );
}

export default Timer;
