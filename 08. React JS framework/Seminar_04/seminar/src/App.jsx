import 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

// import Box from './components/Box';
// import List from './components/List';

// import HomePage from './components/HomePage';
// import AboutPage from './components/AboutPage';

import ListPage from './components/ListPage';
import DetailPage from './components/DetailPage';

// Простой сторонний компонент для демонстрации
// const UserProfile = () => (
//   <div>
//     <h3>Иван Иванов</h3>
//     <p>Роль: Администратор</p>
//   </div>
// );

// const App = () => {
//   return (
//     <div style={{ maxWidth: '600px', margin: '0 auto', padding: '20px' }}>
//       <h2>Урок 4. Children. Роутинг в React</h2>
//       <h3 style={{ color: '#da4e0d', fontFamily: 'sans-serif' }}>Задание № 1</h3>
      

//       {/* Пример 1: Обертка для обычного текста */}
//       <Box>
//         <p><strong>Пример 1: Простой текст.</strong> Этот абзац находится внутри рамки с отступами, которую сгенерировал наш универсальный компонент Box.</p>
//       </Box>

//       {/* Пример 2: Обертка для изображения */}
//       <Box>
//         <div style={{ textAlign: 'center' }}>
//           <img 
//             src="" 
//             alt="Пример" 
//             style={{ borderRadius: '4px' }}
//           />
//           <p style={{ margin: '10px 0 0 0', color: '#666' }}>Пример 2: Изображение внутри Box</p>
//         </div>
//       </Box>

//       {/* Пример 3: Обертка для другого React-компонента */}
//       <Box>
//         <UserProfile />
//       </Box>
//     </div>
//   );
// };

// const App = () => {
//   // Данные для первого списка (Задачи)
//   const todoList = [
//     { id: 1, text: 'Купить молоко', completed: true },
//     { id: 2, text: 'Написать код на React', completed: false },
//     { id: 3, text: 'Сходить на тренировку', completed: false },
//   ];

//   // Данные для второго списка (Уведомления)
//   const notifications = [
//     { id: 'a', type: 'error', message: 'Сбой подключения к серверу!' },
//     { id: 'b', type: 'success', message: 'Данные успешно сохранены.' },
//     { id: 'c', type: 'warning', message: 'Заканчивается свободное место.' },
//   ];

//   return (
//     <div style={{ maxWidth: '500px', margin: '0 auto', padding: '20px' }}>
//       <h2>Урок 4. Children. Роутинг в React</h2>
//       <h3 style={{ color: '#da4e0d', fontFamily: 'sans-serif' }}>Задание № 2</h3>

//       <h2>Список задач (Условные стили)</h2>
//       <List 
//         items={todoList} 
//         renderItem={(todo) => (
//           <li 
//             key={todo.id} 
//             style={{
//               padding: '10px',
//               margin: '5px 0',
//               backgroundColor: '#f0f2f5',
//               borderRadius: '4px',
//               // Динамический стиль в зависимости от статуса задачи
//               textDecoration: todo.completed ? 'line-through' : 'none',
//               color: todo.completed ? '#888' : '#000'
//             }}
//           >
//             {todo.completed ? '✓ ' : '○ '} {todo.text}
//           </li>
//         )} 
//       />

//       <h2>Лента уведомлений (Уникальный дизайн типов)</h2>
//       <List 
//         items={notifications} 
//         renderItem={(notification) => {
//           // Определяем цвет рамки в зависимости от типа уведомления
//           const colors = {
//             error: '#ff4d4f',
//             success: '#52c41a',
//             warning: '#faad14'
//           };

//           return (
//             <li 
//               key={notification.id} 
//               style={{
//                 padding: '12px',
//                 margin: '8px 0',
//                 borderLeft: `5px solid ${colors[notification.type]}`,
//                 backgroundColor: '#fff',
//                 boxShadow: '0 2px 4px rgba(0,0,0,0.1)',
//                 fontWeight: notification.type === 'error' ? 'bold' : 'normal'
//               }}
//             >
//               <strong>[{notification.type.toUpperCase()}]</strong> {notification.message}
//             </li>
//           );
//         }} 
//       />

//     </div>
//   );
// };


// const App = () => {
//   return (
 
//     <BrowserRouter>
//       <h2>Урок 4. Children. Роутинг в React</h2>
//       <h3 style={{ color: '#da4e0d', fontFamily: 'sans-serif' }}>Задание № 3</h3>
//       <Routes>
//         {/* Главный маршрут */}
//         <Route path="/" element={<HomePage />} />
        
//         {/* Маршрут страницы "О нас" */}
//         <Route path="/about" element={<AboutPage />} />
//       </Routes>
//     </BrowserRouter>
//   );
// };

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        {/* Главная страница со списком */}
        <Route path="/" element={<ListPage />} />
        
        {/* Страница деталей с динамическим параметром :id */}
        <Route path="/article/:id" element={<DetailPage />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;