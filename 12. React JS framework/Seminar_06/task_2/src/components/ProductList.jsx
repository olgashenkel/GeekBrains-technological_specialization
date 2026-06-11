import 'react';
import { useDispatch, useSelector } from 'react-redux';
import { addToFavorites } from '../store/favoritesSlice';

// Имитация базы данных товаров
const DUMMY_PRODUCTS = [
  { id: 1, name: 'Смартфон', description: 'Флагманский экран 120 Гц', price: 59990 },
  { id: 2, name: 'Беспроводные наушники', description: 'Активное шумоподавление', price: 12990 },
  { id: 3, name: 'Умные часы', description: 'Мониторинг пульса и сна', price: 17990 },
];

export const ProductList = () => {
  const dispatch = useDispatch();
  // Получаем текущие избранные товары для проверки дубликатов в UI
  const favoriteItems = useSelector((state) => state.favorites.items);

  return (
    <div style={{ flex: 1, padding: '10px' }}>
      <h2>Каталог товаров</h2>
      <div style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
        {DUMMY_PRODUCTS.map((product) => {
          const isFavorite = favoriteItems.some((item) => item.id === product.id);

          return (
            <div key={product.id} style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '5px' }}>
              <h3>{product.name}</h3>
              <p>{product.description}</p>
              <p style={{ fontWeight: 'bold' }}>Цена: {product.price} руб.</p>
              <button
                onClick={() => dispatch(addToFavorites(product))}
                disabled={isFavorite}
                style={{
                  padding: '8px 12px',
                  backgroundColor: isFavorite ? '#ccc' : '#007bff',
                  color: 'white',
                  border: 'none',
                  borderRadius: '3px',
                  cursor: isFavorite ? 'not-allowed' : 'pointer',
                }}
              >
                {isFavorite ? 'В избранном' : 'Добавить в избранное'}
              </button>
            </div>
          );
        })}
      </div>
    </div>
  );
};
