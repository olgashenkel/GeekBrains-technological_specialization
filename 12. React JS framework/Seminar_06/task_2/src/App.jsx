import 'react';
import { ProductList } from './components/ProductList';
import { FavoritesList } from './components/FavoritesList';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif', maxWidth: '1200px', margin: '0 auto' }}>
      <h1 style={{ textAlign: 'center' }}>Магазин с Избранным</h1>
      <div style={{ display: 'flex', gap: '40px', marginTop: '30px' }}>
        <ProductList />
        <FavoritesList />
      </div>
    </div>
  );
}

export default App;
