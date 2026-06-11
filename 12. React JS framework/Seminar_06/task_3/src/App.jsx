import 'react';
import { AddProductForm } from './components/AddProductForm';
import { ProductList } from './components/ProductList';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif', maxWidth: '1000px', margin: '0 auto' }}>
      <h1 style={{ textAlign: 'center', marginBottom: '30px' }}>Панель управления каталогом</h1>
      <div style={{ display: 'grid', gridTemplateColumns: '300px 1fr', gap: '30px' }}>
        <div>
          <AddProductForm />
        </div>
        <div>
          <ProductList />
        </div>
      </div>
    </div>
  );
}

export default App;
