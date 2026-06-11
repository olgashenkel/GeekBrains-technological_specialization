import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addProduct } from '../store/productsSlice';

export const AddProductForm = () => {
  const dispatch = useDispatch();
  const [formData, setFormData] = useState({ name: '', description: '', price: '', available: true });

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!formData.name || !formData.price) return alert('Заполните название и цену!');
    
    dispatch(addProduct(formData));
    setFormData({ name: '', description: '', price: '', available: true }); // Сброс
  };

  return (
    <form onSubmit={handleSubmit} style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '8px', marginBottom: '20px' }}>
      <h3>Добавить продукт</h3>
      <div style={{ marginBottom: '10px' }}>
        <input type="text" placeholder="Название" value={formData.name} onChange={e => setFormData({...formData, name: e.target.value})} style={{ width: '100%', padding: '5px' }} />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <textarea placeholder="Описание" value={formData.description} onChange={e => setFormData({...formData, description: e.target.value})} style={{ width: '100%', padding: '5px' }} />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <input type="number" placeholder="Цена" value={formData.price} onChange={e => setFormData({...formData, price: e.target.value})} style={{ width: '100%', padding: '5px' }} />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <label>
          <input type="checkbox" checked={formData.available} onChange={e => setFormData({...formData, available: e.target.checked})} /> Доступен для заказа
        </label>
      </div>
      <button type="submit" style={{ padding: '8px 15px', backgroundColor: '#28a745', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}>Создать</button>
    </form>
  );
};
