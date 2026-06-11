import 'react';
import { useSelector, useDispatch } from 'react-redux';
import { deleteTask } from '../store/todoSlice';

export const TodoList = () => {
  const tasks = useSelector((state) => state.todos.tasks);
  const dispatch = useDispatch();

  if (tasks.length === 0) {
    return <p>Список задач пуст.</p>;
  }

  return (
    <ul style={{ listStyleType: 'none', padding: 0 }}>
      {tasks.map((task) => (
        <li
          key={task.id}
          style={{
            display: 'flex',
            justifyContent: 'space-between',
            alignItems: 'center',
            width: '350px',
            padding: '8px',
            borderBottom: '1px solid #ccc',
          }}
        >
          <span>{task.description}</span>
          <button
            onClick={() => dispatch(deleteTask(task.id))}
            style={{
              padding: '4px 8px',
              backgroundColor: '#ff4d4d',
              color: 'white',
              border: 'none',
              cursor: 'pointer',
            }}
          >
            Удалить
          </button>
        </li>
      ))}
    </ul>
  );
};
