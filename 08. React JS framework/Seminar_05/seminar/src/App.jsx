import 'react';
import { UserProvider } from './context/UserContext';
import { ThemeProvider, useTheme } from './context/ThemeContext';
import Header from './components/Header';
import Profile from './components/Profile';
import Footer from './components/Footer';

// Внутренний макет, который имеет доступ к ThemeProvider
function AppContent() {
  const { theme } = useTheme();

  const appStyle = {
    fontFamily: 'Arial, sans-serif',
    minHeight: '100vh',
    padding: '20px',
    transition: 'background-color 0.3s ease',
    backgroundColor: theme === 'светлая' ? '#fafafa' : '#1a1a1a',
  };

  return (
    <div style={appStyle}>
      <Header />
      <main style={{ maxWidth: '600px', margin: '0 auto' }}>
        <Profile />
      </main>
      <Footer />
    </div>
  );
}

// Главный компонент оборачивает всё приложение в провайдеры контекста
export default function App() {
  return (
    <UserProvider>
      <ThemeProvider>
        <AppContent />
      </ThemeProvider>
    </UserProvider>
  );
}
