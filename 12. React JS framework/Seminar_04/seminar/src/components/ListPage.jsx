import 'react';
import { Link } from 'react-router-dom';
import { articles } from './data';

const ListPage = () => {
  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif', maxWidth: '600px' }}>
      <h1>Список статей</h1>
      <ul style={{ listStyle: 'none', padding: 0 }}>
        {articles.map((article) => (
          <li key={article.id} style={{ margin: '15px 0', padding: '10px', backgroundColor: '#f0f2f5', borderRadius: '6px' }}>
            {/* Формируем динамическую ссылку по ID статьи */}
            <Link to={`/article/${article.id}`} style={{ textDecoration: 'none', color: '#1890ff', fontSize: '18px', fontWeight: 'bold' }}>
              {article.title}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListPage;
