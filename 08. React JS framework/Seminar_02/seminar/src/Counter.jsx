import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div style={{ textAlign: 'center', margin: '20px auto', padding: '20px', border: '1px solid #ccc', borderRadius: '8px', maxWidth: '200px' }}>
      <h2>{count}</h2>
      <button 
        style={{ padding: '10px 20px', fontSize: '16px', cursor: 'pointer' }} 
        onClick={() => setCount(count + 1)}
      >
        Увеличить
      </button>
    </div>
  );
}

export default Counter;
