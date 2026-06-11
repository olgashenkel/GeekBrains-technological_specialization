import React from 'react';
import './EventCard.css'; // Импорт стилей

// Деструктуризируем пропсы: title, date, location
function EventCard({ title, date, location }) {
  return (
    <div className="event-card">
      <h3 className="event-title">{title}</h3>
      <div className="event-details">
        <p className="event-info">
          <strong>Дата:</strong> {date}
        </p>
        <p className="event-info">
          <strong>Место:</strong> {location}
        </p>
      </div>
    </div>
  );
}

export default EventCard;
