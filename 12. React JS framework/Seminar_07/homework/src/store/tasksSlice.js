import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { mockTasks } from '../data/tasks';

// Асинхронный Thunk-экшен для "загрузки" данных
export const fetchTasks = createAsyncThunk(
  'tasks/fetchTasks',
  async () => { // <--- Просто удалите второй аргумент, если не обрабатываете им ошибки
    return await new Promise((resolve) => {
      setTimeout(() => resolve(mockTasks), 1500);
    });
  }
);

const tasksSlice = createSlice({
  name: 'tasks',
  initialState: {
    items: [],
    loading: false,
    error: null,
  },
  reducers: {
     toggleTask: (state, action) => {
      const task = state.items.find(t => t.id === action.payload);
      if (task) task.completed = !task.completed;
    }
  },
  extraReducers: (builder) => {
    builder
      .addCase(fetchTasks.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchTasks.fulfilled, (state, action) => {
        state.loading = false;
        state.items = action.payload;
      })
      .addCase(fetchTasks.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
      });
  },
});

export const { toggleTask } = tasksSlice.actions;
export default tasksSlice.reducer;
