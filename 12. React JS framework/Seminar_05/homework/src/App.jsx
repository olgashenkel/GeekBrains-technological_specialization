import 'react';
import { useSelector } from 'react-redux';
import ThemeToggler from './components/ThemeToggler';

export default function App() {
  // Подписываемся на состояние темы в Redux
  const theme = useSelector((state) => state.mode);

  const appStyle = {
    fontFamily: 'Arial, sans-serif',
    minHeight: '100vh',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    transition: 'background-color 0.3s ease, color 0.3s ease',
    // Динамические стили на основе состояния
    backgroundColor: theme === 'light' ? '#ffffff' : '#121212',
    color: theme === 'light' ? '#000000' : '#ffffff',
  };

  return (
    <div style={appStyle}>
      <ThemeToggler />
    </div>
  );
}
