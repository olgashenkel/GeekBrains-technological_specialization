import { useState } from 'react';
import Content from './Content';
// Button можно импортировать из Material UI:
import Button from '@mui/material/Button';

function ThemeSwitcher() {
  // Храним состояние текущей темы (по умолчанию "light")
  const [theme, setTheme] = useState('light');

  // Логика переключения между light и dark
  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  return (
    <div style={{ maxWidth: '500px', margin: '20px auto', textAlign: 'center' }}>
      {/* Кнопка переключения темы */}
      <Button 
        variant="contained" 
        color={theme === 'light' ? 'secondary' : 'default'} 
        onClick={toggleTheme}
      >
        Переключить на {theme === 'light' ? 'тёмную' : 'светлую'} тему
      </Button>

      {/* Передаем текущую тему в виде пропса в компонент Content */}
      <Content theme={theme} />
    </div>
  );
}

export default ThemeSwitcher;
