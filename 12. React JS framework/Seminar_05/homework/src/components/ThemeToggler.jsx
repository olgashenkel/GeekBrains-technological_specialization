import 'react';
import { useSelector, useDispatch } from 'react-redux';
import { toggleTheme } from '../store/actions';

export default function ThemeToggler() {
  const theme = useSelector((state) => state.mode);
  const dispatch = useDispatch();

  const buttonStyle = {
    padding: '10px 20px',
    fontSize: '16px',
    cursor: 'pointer',
    borderRadius: '20px',
    border: '2px solid',
    transition: 'all 0.3s ease',
    backgroundColor: theme === 'light' ? '#333' : '#fff',
    color: theme === 'light' ? '#fff' : '#333',
    borderColor: theme === 'light' ? '#333' : '#fff',
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '40px' }}>
      <h1>Текущая тема: {theme === 'light' ? '☀️ Светлая' : '🌙 Темная'}</h1>
      <button style={buttonStyle} onClick={() => dispatch(toggleTheme())}>
        Переключить на {theme === 'light' ? 'темную' : 'светлую'}
      </button>
    </div>
  );
}
