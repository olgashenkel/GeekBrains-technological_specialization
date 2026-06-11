import { useContext, useState } from 'react';
import { CartContext } from '../context/CartContext';
import ProductCard from '../components/ProductCard';

const Catalog = () => {
  const { products } = useContext(CartContext);
  const [sizeFilter, setSizeFilter] = useState('ALL');

  const filteredProducts = sizeFilter === 'ALL' 
    ? products 
    : products.filter(p => p.size === sizeFilter);

  return (
    <div className="box-content">
      <div className="productIndex-title" style={{ paddingTop: '40px' }}>
        <h1 class="productIndex-title-head">Featured Items</h1>
        <p class="productIndex-title-text">Shop for items based on what we featured in this week</p>
        
        {/* Интерактивный фильтр размеров */}
        <div style={{ margin: '20px 0', display: 'flex', gap: '15px', alignItems: 'center' }}>
          <span style={{color: '#6F6E6E', fontSize: '14px'}}>FILTER BY SIZE:</span>
          {['ALL', 'XS', 'S', 'M', 'L'].map(size => (
            <button 
              key={size}
              onClick={() => setSizeFilter(size)}
              style={{
                padding: '5px 15px',
                border: sizeFilter === size ? '1px solid #f86478' : '1px solid #A4A4A4',
                backgroundColor: sizeFilter === size ? '#f86478' : '#FFF',
                color: sizeFilter === size ? '#FFF' : '#000',
                cursor: 'pointer'
              }}
            >
              {size}
            </button>
          ))}
        </div>
      </div>

      <div className="productIndex-box center">
        {filteredProducts.map(product => (
          <ProductCard key={product.id} product={product} />
        ))}
      </div>
    </div>
  );
};

export default Catalog;
