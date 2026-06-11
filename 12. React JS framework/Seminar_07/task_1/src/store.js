// 3. REDUX STORE CONFIGURATION (store.js)
import { configureStore } from '@reduxjs/toolkit';
import { loggerMiddleware } from './loggerMiddleware';
import buttonReducer from './buttonSlice'; // Импортируем редьюсер кнопки

export const store = configureStore({
  reducer: {
    button: buttonReducer, // Состояние будет лежать в ветке store.button
  },
  // Подключаем наше логгирующее middleware к стандартным
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(loggerMiddleware),
});
