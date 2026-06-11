import 'react';
import { AddTask } from './components/AddTask';
import { TodoList } from './components/TodoList';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h1>Менеджер задач</h1>
      <AddTask />
      <TodoList />
    </div>
  );
}

export default App;