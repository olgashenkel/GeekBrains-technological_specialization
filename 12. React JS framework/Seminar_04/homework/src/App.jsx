import 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import HomePage from './components/HomePage';
import AboutPage from './components/AboutPage';

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        {/* Главный маршрут */}
        <Route 
          path="/" 
          element={
            <Layout>
              <HomePage />
            </Layout>
          } 
        />
        
        {/* Маршрут "О нас" */}
        <Route 
          path="/about" 
          element={
            <Layout>
              <AboutPage />
            </Layout>
          } 
        />
      </Routes>
    </BrowserRouter>
  );
};

export default App;
