import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  items: [
    { id: 1, name: 'Ноутбук', description: 'Мощный игровой ноутбук', price: 89990, available: true },
    { id: 2, name: 'Мышь', description: 'Беспроводная эргономичная мышь', price: 3500, available: false }
  ],
};

const productsSlice = createSlice({
  name: 'products',
  initialState,
  reducers: {
    // Добавление нового продукта
    addProduct: (state, action) => {
      state.items.push({
        id: Date.now(),
        ...action.payload,
        price: Number(action.payload.price) // Гарантируем тип number
      });
    },
    // Удаление по ID
    deleteProduct: (state, action) => {
      state.items = state.items.filter(item => item.id !== action.payload);
    },
    // Изменение доступности (переключатель)
    toggleAvailability: (state, action) => {
      const product = state.items.find(item => item.id === action.payload);
      if (product) {
        product.available = !product.available;
      }
    },
    // Обновление всех полей продукта
    updateProduct: (state, action) => {
      const index = state.items.findIndex(item => item.id === action.payload.id);
      if (index !== -1) {
        state.items[index] = {
          ...action.payload,
          price: Number(action.payload.price)
        };
      }
    }
  },
});

export const { addProduct, deleteProduct, toggleAvailability, updateProduct } = productsSlice.actions;
export default productsSlice.reducer;
