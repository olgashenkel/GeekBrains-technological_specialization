import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchTasks, toggleTask } from './store/tasksSlice';

export default function App() {
  const dispatch = useDispatch();
  const { items, loading, error } = useSelector((state) => state.tasks);

  useEffect(() => {
    // Запускаем имитацию загрузки только если список задач еще пуст
    if (items.length === 0) {
      dispatch(fetchTasks());
    }
  }, [dispatch, items.length]);

  return (
    <div style={{ padding: '30px', fontFamily: 'sans-serif', maxWidth: '500px' }}>
      <h1>Список задач (Thunk + Persist)</h1>

      {loading && <p style={{ color: 'blue' }}>⏳ Синхронизация с сервером...</p>}
      {error && <p style={{ color: 'red' }}>⚠️ Ошибка: {error}</p>}

      <ul style={{ listStyle: 'none', padding: 0 }}>
        {items.map((task) => (
          <li 
            key={task.id} 
            style={{ 
              padding: '10px', 
              borderBottom: '1px solid #eee',
              display: 'flex',
              alignItems: 'center',
              gap: '10px'
            }}
          >
            <input 
              type="checkbox" 
              checked={task.completed} 
              onChange={() => dispatch(toggleTask(task.id))}
            />
            <span style={{ textDecoration: task.completed ? 'line-through' : 'none', color: task.completed ? '#aaa' : '#000' }}>
              {task.title}
            </span>
          </li>
        ))}
      </ul>

      {items.length > 0 && (
        <p style={{ fontSize: '12px', color: 'green', marginTop: '20px' }}>
          ✓ Данные успешно зафиксированы в LocalStorage. Попробуйте обновить страницу!
        </p>
      )}
    </div>
  );
}
