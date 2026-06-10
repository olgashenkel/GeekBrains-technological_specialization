import 'react';

function Content({ theme }) {
  // Определяем стили в зависимости от текущей темы
  const isDark = theme === 'dark';
  
  const contentStyle = {
    backgroundColor: isDark ? '#222222' : '#ffffff',
    color: isDark ? '#ffffff' : '#000000',
    padding: '30px',
    borderRadius: '8px',
    marginTop: '20px',
    boxShadow: '0 4px 6px rgba(0,0,0,0.1)',
    transition: 'all 0.3s ease', // Плавный переход при смене темы
    textAlign: 'center'
  };

  return (
    <div style={contentStyle}>
      <h2>Компонент Content</h2>
      <p>Сейчас активна <b>{isDark ? 'Тёмная' : 'Светлая'}</b> тема интерфейса.</p>
      <p>Этот блок динамически меняет цвет фона и текста через пропсы.</p>
    </div>
  );
}

export default Content;
