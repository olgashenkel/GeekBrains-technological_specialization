import React from 'react';
import './Message.css'; 

function Message({ text }) {
  return (
    <div className="message-box">
      <p className="message-content">{text}</p>
    </div>
  );
}

export default Message;
