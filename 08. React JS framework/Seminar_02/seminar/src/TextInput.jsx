import React, { useState } from 'react';

function TextInput() {
  const [text, setText] = useState('');

  const handleChange = (event) => {
    setText(event.target.value); 
  };

  return (
    <div style={{ textAlign: 'center', margin: '20px auto', padding: '20px', border: '1px solid #ccc', borderRadius: '8px', maxWidth: '300px' }}>
      <input 
        type="text" 
        value={text} 
        onChange={handleChange} 
        placeholder="Введите текст..."
        style={{ padding: '8px', width: '90%', fontSize: '16px', marginBottom: '15px' }}
      />
      
      <p style={{ minHeight: '24px', fontWeight: 'bold', wordBreak: 'break-word' }}>
        Вы ввели: {text}
      </p>
    </div>
  );
}

export default TextInput;
