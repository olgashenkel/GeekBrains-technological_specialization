import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  items: [], // Массив для хранения избранных товаров
};

const favoritesSlice = createSlice({
  name: 'favorites',
  initialState,
  reducers: {
    // Добавление товара в избранное
    addToFavorites: (state, action) => {
      const itemExists = state.items.some(item => item.id === action.payload.id);
      // Добавляем товар только если его еще нет в списке
      if (!itemExists) {
        state.items.push(action.payload);
      }
    },
    // Удаление товара по id
    removeFromFavorites: (state, action) => {
      state.items = state.items.filter(item => item.id !== action.payload);
    },
  },
});

export const { addToFavorites, removeFromFavorites } = favoritesSlice.actions;
export default favoritesSlice.reducer;
