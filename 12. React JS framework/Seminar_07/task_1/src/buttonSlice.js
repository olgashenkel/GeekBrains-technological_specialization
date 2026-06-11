// 2. REDUX SLICE / REDUCER (buttonSlice.js)
import { createSlice } from '@reduxjs/toolkit';

const buttonSlice = createSlice({
  name: 'button', // Префикс для экшена (получится 'button/click')
  initialState: {
    clicked: false, // Начальное состояние, как в образце
  },
  reducers: {
    click: (state) => {
      state.clicked = true; // Меняем флаг при клике на кнопку
    },
  },
});

// Экспортируем экшен для компонента и редьюсер для хранилища
export const { click } = buttonSlice.actions;
export default buttonSlice.reducer;
