import React from 'react';
import './Greeting.css'; 

function Greeting() {
  const currentHour = new Date().getHours();
  let message = '';

   if (currentHour >= 4 && currentHour < 12) {
    message = 'Доброе утро';
  } else if (currentHour >= 12 && currentHour < 17) {
    message = 'Добрый день';
  } else if (currentHour >= 17 && currentHour < 23) {
    message = 'Добрый вечер';
  } else {
    message = 'Доброй ночи';
  }

  return (
    <div className="greeting-container">
      <h1 className="greeting-text">{message}!</h1>
    </div>
  );
}

export default Greeting;
