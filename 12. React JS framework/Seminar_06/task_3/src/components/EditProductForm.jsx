import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { updateProduct } from '../store/productsSlice';

export const EditProductForm = ({ product, onCancel }) => {
  const dispatch = useDispatch();
  const [formData, setFormData] = useState({ ...product });

  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch(updateProduct(formData));
    onCancel(); // Закрываем режим редактирования
  };

  return (
    <form onSubmit={handleSubmit} style={{ border: '1px solid #ffc107', padding: '15px', borderRadius: '8px', backgroundColor: '#fff9e6' }}>
      <h4>Редактирование: {product.name}</h4>
      <div style={{ marginBottom: '10px' }}>
        <input type="text" value={formData.name} onChange={e => setFormData({...formData, name: e.target.value})} style={{ width: '100%', padding: '5px' }} />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <textarea value={formData.description} onChange={e => setFormData({...formData, description: e.target.value})} style={{ width: '100%', padding: '5px' }} />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <input type="number" value={formData.price} onChange={e => setFormData({...formData, price: e.target.value})} style={{ width: '100%', padding: '5px' }} />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <label>
          <input type="checkbox" checked={formData.available} onChange={e => setFormData({...formData, available: e.target.checked})} /> Доступен
        </label>
      </div>
      <button type="submit" style={{ marginRight: '10px', padding: '5px 10px', backgroundColor: '#ffc107', border: 'none', borderRadius: '4px', cursor: 'pointer' }}>Сохранить</button>
      <button type="button" onClick={onCancel} style={{ padding: '5px 10px', backgroundColor: '#6c757d', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}>Отмена</button>
    </form>
  );
};
