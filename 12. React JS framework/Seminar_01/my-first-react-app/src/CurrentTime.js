import React, { useState, useEffect } from 'react';
import './CurrentTime.css'; 

function CurrentTime() {
  const [time, setTime] = useState(new Date());

  useEffect(() => {
    const timerId = setInterval(() => {
      setTime(new Date());
    }, 1000);

    return () => clearInterval(timerId);
  }, []);

  const formattedTime = time.toLocaleTimeString([], {
    hour: '2-digit',
    minute: '2-digit'
  });

  return (
    <div className="time-container">
      <h2>Текущее время: <span className="time-highlight">{formattedTime}</span></h2>
    </div>
  );
}

export default CurrentTime;
