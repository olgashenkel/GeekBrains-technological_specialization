import 'react';
import { useDispatch } from 'react-redux';

export const UsersButton = () => {
  const dispatch = useDispatch();

  const handleFetchUsers = () => {
    // Отправляем текстовый экшен, который перехватит watcher saga
    dispatch({ type: 'FETCH_USERS_REQUEST' });
  };

  return (
    <button 
      onClick={handleFetchUsers}
      style={{
        padding: '8px 16px',
        fontSize: '16px',
        cursor: 'pointer',
        borderRadius: '4px',
        border: '1px solid #767676',
        backgroundColor: '#efefef',
        fontFamily: 'Arial, sans-serif',
        marginLeft: '10px'
      }}
    >
      Загрузить пользователей
    </button>
  );
};
