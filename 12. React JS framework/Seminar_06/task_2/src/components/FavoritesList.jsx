import 'react';
import { useSelector, useDispatch } from 'react-redux';
import { removeFromFavorites } from '../store/favoritesSlice';

export const FavoritesList = () => {
  const favoriteItems = useSelector((state) => state.favorites.items);
  const dispatch = useDispatch();

  return (
    <div style={{ flex: 1, padding: '10px', backgroundColor: '#f9f9f9', borderRadius: '5px' }}>
      <h2>Избранное ({favoriteItems.length})</h2>
      {favoriteItems.length === 0 ? (
        <p>Список избранного пуст.</p>
      ) : (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
          {favoriteItems.map((item) => (
            <div key={item.id} style={{ border: '1px solid #ffc107', padding: '15px', borderRadius: '5px', backgroundColor: '#fff' }}>
              <h3>{item.name}</h3>
              <p>{item.description}</p>
              <p style={{ fontWeight: 'bold' }}>Цена: {item.price} руб.</p>
              <button
                onClick={() => dispatch(removeFromFavorites(item.id))}
                style={{
                  padding: '8px 12px',
                  backgroundColor: '#dc3545',
                  color: 'white',
                  border: 'none',
                  borderRadius: '3px',
                  cursor: 'pointer',
                }}
              >
                Удалить из избранного
              </button>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};
