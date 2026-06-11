import 'react';
import { Link } from 'react-router-dom';

const AboutPage = () => {
  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      {/* Навигационные ссылки */}
      <nav style={{ marginBottom: '20px' }}>
        <Link to="/" style={{ marginRight: '15px' }}>Главная</Link>
        <Link to="/about">О нас</Link>
      </nav>
      
      <h1>О нас</h1>
      <p>Здесь вы можете найти информацию о нашей компании.</p>
    </div>
  );
};

export default AboutPage;
