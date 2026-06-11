// 1. LOGGER MIDDLEWARE (loggerMiddleware.js)
export const loggerMiddleware = (store) => (next) => (action) => {
  // Выводим текущее действие в консоль
  console.log('Действие:', action);

  // Выводим состояние ДО выполнения действия
  console.log('Состояние ДО выполнения:', store.getState());

  // Передаем действие дальше редьюсеру
  const result = next(action);

  // Выводим состояние ПОСЛЕ выполнения действия
  console.log('Состояние ПОСЛЕ выполнения:', store.getState());

  // Возвращаем результат для корректной работы цепочки Redux
  return result;
};