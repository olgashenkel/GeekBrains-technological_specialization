import { TOGGLE_THEME } from './actionTypes';

// Начальное состояние приложения — светлая тема
const initialState = {
  mode: 'light', 
};

export const themeReducer = (state = initialState, action) => {
  switch (action.type) {
    case TOGGLE_THEME:
      return {
        ...state,
        // Если была светлая — ставим темную, и наоборот
        mode: state.mode === 'light' ? 'dark' : 'light',
      };
    default:
      return state;
  }
};
