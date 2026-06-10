import 'react';

// Компонент-обертка Box
const Box = ({ children }) => {
  const boxStyle = {
    border: '2px solid #4A90E2',
    borderRadius: '8px',
    padding: '20px',
    margin: '15px 0',
    backgroundColor: '#f9f9f9',
    boxShadow: '0 4px 6px rgba(0,0,0,0.05)',
  };

  return <div style={boxStyle}>{children}</div>;
};

export default Box;
