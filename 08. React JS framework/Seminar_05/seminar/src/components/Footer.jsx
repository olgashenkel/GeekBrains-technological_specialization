import 'react';
import { useTheme } from '../context/ThemeContext';

export default function Footer() {
  const { theme } = useTheme();
  const currentYear = new Date().getFullYear();

  const footerStyle = {
    padding: '15px',
    textAlign: 'center',
    marginTop: '20px',
    backgroundColor: theme === 'светлая' ? '#e0e0e0' : '#111',
    color: theme === 'светлая' ? '#666' : '#999',
  };

  return (
    <footer style={footerStyle}>
      <p>&copy; {currentYear} Ваша Компания. Все права защищены.</p>
    </footer>
  );
}
