import 'react';
import { useUser } from '../context/UserContext';
import { useTheme } from '../context/ThemeContext';

export default function Profile() {
  const { username } = useUser();
  const { theme, toggleTheme } = useTheme();

  const profileStyle = {
    padding: '20px',
    margin: '20px 0',
    borderRadius: '8px',
    backgroundColor: theme === 'светлая' ? '#ffffff' : '#222222',
    color: theme === 'светлая' ? '#333' : '#f0f0f0',
    boxShadow: '0 4px 6px rgba(0,0,0,0.1)',
  };

  return (
    <div style={profileStyle}>
      <h3>Профиль пользователя</h3>
      <p><strong>Логин в системе:</strong> {username}</p>
      <p><strong>Текущий статус:</strong> Активен</p>
      <button 
        onClick={toggleTheme}
        style={{
          padding: '8px 12px',
          cursor: 'pointer',
          backgroundColor: theme === 'светлая' ? '#333' : '#f0f0f0',
          color: theme === 'светлая' ? '#fff' : '#333',
          border: 'none',
          borderRadius: '4px'
        }}
      >
        Переключить на {theme === 'светлая' ? 'темную' : 'светлую'} тему
      </button>
    </div>
  );
}
