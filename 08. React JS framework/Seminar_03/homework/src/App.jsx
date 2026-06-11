import TemperatureConverter from './components/TemperatureConverter';
import TodoList from './components/TodoList';
import './App.css';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1 style={{ textAlign: 'center' }}>Домашнее задание № 3</h1>
      <h2 style={{ textAlign: 'center' }}>Урок 3. Virtual DOM. Подключение библиотеки UI-компонентов</h2>
      
      {/* Задание 1 */}
      <TemperatureConverter />
      
      <hr style={{ margin: '40px 0', borderColor: '#ccc' }} />
      
      {/* Задание 2 */}
      <TodoList />
    </div>
  );
}

export default App;
