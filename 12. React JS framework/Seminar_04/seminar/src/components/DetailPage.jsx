import 'react';
import { useParams, Link } from 'react-router-dom';
import { articles } from './data';

const DetailPage = () => {
  // Извлекаем параметр id из URL-адреса
  const { id } = useParams();

  // Ищем нужную статью в массиве данных по полученному id
  const article = articles.find((item) => item.id === id);

  // Если статья с таким ID не найдена, выводим сообщение об ошибке
  if (!article) {
    return (
      <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
        <h2>Статья не найдена</h2>
        <Link to="/">Вернуться к списку</Link>
      </div>
    );
  }

  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif', maxWidth: '600px' }}>
      <Link to="/" style={{ color: '#8c8c8c', textDecoration: 'none' }}>← Назад к списку</Link>
      <h1 style={{ marginTop: '20px' }}>{article.title}</h1>
      <p style={{ lineHeight: '1.6', fontSize: '16px', color: '#333' }}>{article.content}</p>
      <small style={{ color: '#aaaaaa' }}>ID статьи: {id}</small>
    </div>
  );
};

export default DetailPage;
