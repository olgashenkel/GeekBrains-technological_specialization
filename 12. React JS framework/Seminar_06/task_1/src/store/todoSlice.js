import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  tasks: [],
};

const todoSlice = createSlice({
  name: 'todos',
  initialState,
  reducers: {
    // Действие для добавления новой задачи
    addTask: (state, action) => {
      state.tasks.push({
        id: Date.now(), // Уникальный идентификатор
        description: action.payload, // Описание от пользователя
        isCompleted: false, // Изначальный статус
      });
    },
    // Действие для удаления задачи по id
    deleteTask: (state, action) => {
      state.tasks = state.tasks.filter(task => task.id !== action.payload);
    },
  },
});

export const { addTask, deleteTask } = todoSlice.actions;
export default todoSlice.reducer;
