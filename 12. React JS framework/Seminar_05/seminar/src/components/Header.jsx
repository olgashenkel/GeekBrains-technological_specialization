import 'react';
import { useUser } from '../context/UserContext';
import { useTheme } from '../context/ThemeContext';

export default function Header() {
  const { username, setUsername } = useUser();
  const { theme } = useTheme();

  const headerStyle = {
    padding: '15px',
    borderBottom: '2px solid',
    backgroundColor: theme === 'светлая' ? '#f0f0f0' : '#333',
    color: theme === 'светлая' ? '#000' : '#fff',
    borderColor: theme === 'светлая' ? '#ccc' : '#444',
  };

  return (
    <header style={headerStyle}>
      <h2>Привет, {username}! 👋</h2>
      <label style={{ marginRight: '10px' }}>Изменить имя: </label>
      <input
        type="text"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
        style={{ padding: '5px', borderRadius: '4px', border: '1px solid #ccc' }}
      />
    </header>
  );
}
