import { createContext, useState, useContext } from 'react';

const ThemeContext = createContext(null);

export function ThemeProvider({ children }) {
  const [theme, setTheme] = useState('светлая');

  const toggleTheme = () => {
    setTheme((prev) => (prev === 'светлая' ? 'темная' : 'светлая'));
  };

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      {children}
    </ThemeContext.Provider>
  );
}

// Кастомный хук для быстрого и безопасного доступа к контексту темы
export function useTheme() {
  const context = useContext(ThemeContext);
  if (!context) {
    throw new Error('useTheme должен использоваться внутри ThemeProvider');
  }
  return context;
}
