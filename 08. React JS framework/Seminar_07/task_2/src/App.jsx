import 'react';
import { Provider } from 'react-redux';
import store from './store'; // путь к вашему store.js
import UsersList from './components/UsersList';

export default function App() {
  return (
    <Provider store={store}>
      <div className="App">
        <h2>Урок 7. Redux middlewares. Redux persist</h2>
        <h2 style={{color: '#db4242'}}>Redux-Saga Приложение</h2>
        <UsersList />
      </div>
    </Provider>
  );
}
