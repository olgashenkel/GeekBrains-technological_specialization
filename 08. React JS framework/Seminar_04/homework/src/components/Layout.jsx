import 'react';
import { Link } from 'react-router-dom';

const Layout = ({ children }) => {
  const navStyle = {
    padding: '15px',
    backgroundColor: '#f0f2f5',
    borderBottom: '1px solid #d9d9d9',
    marginBottom: '20px'
  };

  const linkStyle = {
    marginRight: '15px',
    textDecoration: 'none',
    color: '#1890ff',
    fontWeight: 'bold'
  };

  return (
    <div style={{ fontFamily: 'sans-serif' }}>
      {/* Общая навигационная панель */}
      <nav style={navStyle}>
        <Link to="/" style={linkStyle}>Главная</Link>
        <Link to="/about" style={linkStyle}>О нас</Link>
      </nav>

      {/* Место, куда будут подставляться наши страницы */}
      <div style={{ padding: '0 15px' }}>
        {children}
      </div>
    </div>
  );
};

export default Layout;
