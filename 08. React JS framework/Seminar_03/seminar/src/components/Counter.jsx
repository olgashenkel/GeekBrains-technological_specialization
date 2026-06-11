import { useState } from 'react';
// Импортируем компонент кнопки из Material UI
import Button from '@mui/material/Button'; 

function Counter() {
  // Инициализируем состояние счётчика со значением 0
  const [count, setCount] = useState(0);

  return (
    <div style={{ textAlign: 'center', marginTop: '20px' }}>
      {/* Отображаем текущее число */}
      <h2>Текущее значение: {count}</h2>

      {/* Кнопка уменьшения значения (минус) */}
      <Button 
        variant="contained" 
        color="error" 
        onClick={() => setCount(count - 1)}
        style={{ marginRight: '10px' }}
      >
        Уменьшить (-1)
      </Button>

      {/* Кнопка увеличения значения (плюс) */}
      <Button 
        variant="contained" 
        color="success" 
        onClick={() => setCount(count + 1)}
      >
        Увеличить (+1)
      </Button>
    </div>
  );
}

export default Counter;
