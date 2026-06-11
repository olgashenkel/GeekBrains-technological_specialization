import { useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { deleteProduct, toggleAvailability } from '../store/productsSlice';
import { EditProductForm } from './EditProductForm';

export const ProductList = () => {
  const products = useSelector((state) => state.products.items);
  const dispatch = useDispatch();
  
  // Локальный стейт для отслеживания редактируемого продукта
  const [editingId, setEditingId] = useState(null);

  return (
    <div>
      <h3>Список продуктов</h3>
      {products.length === 0 ? <p>Каталог пуст</p> : (
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(280px, 1fr))', gap: '20px' }}>
          {products.map((product) => (
            <div key={product.id} style={{ border: '1px solid #ddd', padding: '15px', borderRadius: '8px', backgroundColor: product.available ? '#fff' : '#f0f0f0' }}>
              {editingId === product.id ? (
                <EditProductForm product={product} onCancel={() => setEditingId(null)} />
              ) : (
                <>
                  <h4>{product.name}</h4>
                  <p style={{ color: '#555' }}>{product.description}</p>
                  <p><b>Цена:</b> {product.price} руб.</p>
                  <p><b>Статус:</b> {product.available ? <span style={{ color: 'green' }}>В наличии</span> : <span style={{ color: 'red' }}>Нет на складе</span>}</p>
                  
                  <div style={{ display: 'flex', gap: '5px', flexWrap: 'wrap', marginTop: '10px' }}>
                    <button onClick={() => dispatch(toggleAvailability(product.id))} style={{ padding: '5px 8px', cursor: 'pointer' }}>
                      {product.available ? 'Снять с продажи' : 'Вернуть в продажу'}
                    </button>
                    <button onClick={() => setEditingId(product.id)} style={{ padding: '5px 8px', backgroundColor: '#007bff', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}>
                      Редактировать
                    </button>
                    <button onClick={() => dispatch(deleteProduct(product.id))} style={{ padding: '5px 8px', backgroundColor: '#dc3545', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}>
                      Удалить
                    </button>
                  </div>
                </>
              )}
            </div>
          ))}
        </div>
      )}
    </div>
  );
};
