// 5. APPLICATION ENTRY POINT (index.js / main.js)

import React from 'react';
import ReactDOM from 'react-dom/client';
import { Provider } from 'react-redux';
import { store } from './store'; 
import { BuyButton } from './BuyButton'; 

// Корневой рендеринг приложения с подключенным Store
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Provider store={store}>
      <div style={{ padding: '20px' }}>
        <BuyButton />
      </div>
    </Provider>
  </React.StrictMode>
);