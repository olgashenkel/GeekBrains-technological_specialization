import 'react';
import { Link } from 'react-router-dom';

const HomePage = () => {
  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      {/* Навигационные ссылки */}
      <nav style={{ marginBottom: '20px' }}>
        <Link to="/" style={{ marginRight: '15px' }}>Главная</Link>
        <Link to="/about">О нас</Link>
      </nav>
      
      <h1>Главная страница</h1>
      <p>Добро пожаловать на наш сайт!</p>
    </div>
  );
};

export default HomePage;
