import logo from './logo.svg';
import './App.css';
import Greeting from './Greeting'; 
import CurrentTime from './CurrentTime';
import EventCard from './EventCard';

function App() {
  return (
    <div className="App" style={{ textAlign: 'center', padding: '50px' }}>
      <h1>Урок 1. Знакомство с React и первые компоненты. Работа с JSX</h1>
      <Greeting /> 

      <h1>Добро пожаловать в приложение!</h1>
      <CurrentTime />
    
          
      <h2 style={{ fontFamily: 'sans-serif', color: '#333', marginTop: '40px' }}>
        Предстоящие события
      </h2>
      
      {/* Список карточек с разными пропсами */}
      <div className="events-list" style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
        <EventCard 
          title="Концерт классической музыки" 
          date="15 Июня, 19:00" 
          location="Большой филармонический зал" 
        />
        <EventCard 
          title="Выставка современного искусства" 
          date="22 Июня, 12:00" 
          location="Галерея «Арт-Пространство»" 
        />
        <EventCard 
          title="IT-Конференция «React Today»" 
          date="05 Июля, 10:00" 
          location="Технопарк, Конференц-зал №1" 
        />
      </div>

    </div>
  );
}

export default App;
