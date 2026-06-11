// 4. REACT COMPONENT (BuyButton.jsx)
import 'react';
import { useDispatch } from 'react-redux';
import { click } from './buttonSlice'; 

export const BuyButton = () => {
  const dispatch = useDispatch();

  const handleButtonClick = () => {
    // Отправляем экшен в Redux Store
    dispatch(click());
  };

  return (
    <button 
      onClick={handleButtonClick}
      style={{
        padding: '8px 16px',
        fontSize: '16px',
        cursor: 'pointer',
        borderRadius: '4px',
        border: '1px solid #767676',
        backgroundColor: '#efefef',
        fontFamily: 'Arial, sans-serif'
      }}
    >
      Купить
    </button>
  );
};
