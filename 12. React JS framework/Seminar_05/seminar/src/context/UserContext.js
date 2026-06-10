import { createContext, useState, useContext } from 'react';

const UserContext = createContext(null);

export function UserProvider({ children }) {
  const [username, setUsername] = useState('Гость');

  return (
    <UserContext.Provider value={{ username, setUsername }}>
      {children}
    </UserContext.Provider>
  );
}

// Кастомный хук для быстрого и безопасного доступа к контексту пользователя
export function useUser() {
  const context = useContext(UserContext);
  if (!context) {
    throw new Error('useUser должен использоваться внутри UserProvider');
  }
  return context;
}
