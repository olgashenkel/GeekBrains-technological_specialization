import { useContext } from 'react';
import { CartContext } from '../context/CartContext';

const Cart = () => {
  const { cart, updateQuantity, removeFromCart, grandTotal } = useContext(CartContext);

  return (
    <div class="shopping">
      <div style={{ flex: '1' }}>
        {cart.length === 0 ? (
          <h2 class="shopping__left__content-head">Your Cart is Empty</h2>
        ) : (
          cart.map(item => (
            <div key={item.id} class="shopping__left__box">
              <img class="shopping__left__img" src={item.img} alt={item.name} />
              <div class="shopping__left__content">
                <h3 class="shopping__left__content-head">{item.name}</h3>
                <p class="shopping__left__content-text">Price: <span class="shopping__left__content-price">${item.price}</span></p>
                <p class="shopping__left__content-text">Size: {item.size}</p>
                <p class="shopping__left__content-text">
                  Quantity: 
                  <input 
                    type="number" 
                    class="shopping__left__content-quantityBox" 
                    value={item.quantity} 
                    onChange={(e) => updateQuantity(item.id, parseInt(e.target.value) || 0)}
                    min="0"
                  />
                </p>
              </div>
              <button class="close-btn" onClick={() => removeFromCart(item.id)} style={{ background: 'none', border: 'none', cursor: 'pointer' }}>
                <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://w3.org">
                  <path d="M11.2453 9L17.5302 2.71511C18.1566 2.08877 18.1566 1.07111 17.5302 0.444778C16.9039 -0.181556 15.8862 -0.181556 15.2599 0.444778L8.97494 6.72967L2.69005 0.444778C2.06371 -0.181556 1.04605 -0.181556 0.419711 0.444778C-0.20663 1.07111 -0.20663 2.08877 0.419711 2.71511L6.7046 9L0.419711 15.2849C-0.20663 15.9112 -0.20663 16.9289 0.419711 17.5552C1.04605 18.1816 2.06371 18.1816 2.69005 17.5552L8.97494 11.2703L15.2599 17.5552C15.8862 18.1816 16.9039 18.1816 17.5302 17.5552C18.1566 16.9289 18.1566 15.9112 17.5302 15.2849L11.2453 9Z" fill="#575757"/>
                </svg>
              </button>
            </div>
          ))
        )}
      </div>

      <div class="shopping__right">
        <div class="shopping__right__checkoutBox">
          <p class="shopping__right__checkoutBox_subTotal">SUB TOTAL ${grandTotal}</p>
          <h3 class="shopping__right__checkoutBox_grandTotal">
            GRAND TOTAL <span class="shopping__right__checkoutBox_text-padding shopping__right__checkoutBox_text">${grandTotal}</span>
          </h3>
          <hr style={{ margin: '20px 0', border: '0.5px solid #E2E2E2' }} />
          <button class="shopping__right__checkoutBox_button">PROCEED TO CHECKOUT</button>
        </div>
      </div>
    </div>
  );
};

export default Cart;
