import { createContext, useState } from 'react';

// eslint-disable-next-line react-refresh/only-export-components
export const CartContext = createContext();

export const CartProvider = ({ children }) => {
  // Набор базовых товаров из вашей разметки с назначенными размерами
  const [products] = useState([
    { id: 1, name: "ELLERY X M'O CAPSULE", price: 52, size: 'S', img: 'img/product/Index/product_1.jpg', text: 'Known for her sculptural takes on traditional tailoring, Australian arbiter of cool Kym Ellery teams up with Moda Operandi.' },
    { id: 2, name: "ELLERY X M'O CAPSULE", price: 62, size: 'XS', img: 'img/product/Index/product_2.jpg', text: 'Known for her sculptural takes on traditional tailoring, Australian arbiter of cool Kym Ellery teams up with Moda Operandi.' },
    { id: 3, name: "ELLERY X M'O CAPSULE", price: 72, size: 'M', img: 'img/product/Index/product_3.jpg', text: 'Known for her sculptural takes on traditional tailoring, Australian arbiter of cool Kym Ellery teams up with Moda Operandi.' },
    { id: 4, name: "ELLERY X M'O CAPSULE", price: 52, size: 'L', img: 'img/product/Index/product_4.jpg', text: 'Known for her sculptural takes on traditional tailoring, Australian arbiter of cool Kym Ellery teams up with Moda Operandi.' },
    { id: 5, name: "ELLERY X M'O CAPSULE", price: 82, size: 'M', img: 'img/product/Index/product_5.jpg', text: 'Known for her sculptural takes on traditional tailoring, Australian arbiter of cool Kym Ellery teams up with Moda Operandi.' },
    { id: 6, name: "ELLERY X M'O CAPSULE", price: 92, size: 'S', img: 'img/product/Index/product_6.jpg', text: 'Known for her sculptural takes on traditional tailoring, Australian arbiter of cool Kym Ellery teams up with Moda Operandi.' },
  ]);

  const [cart, setCart] = useState([]);

  const addToCart = (product) => {
    setCart((prevCart) => {
      const existing = prevCart.find((item) => item.id === product.id);
      if (existing) {
        return prevCart.map((item) =>
          item.id === product.id ? { ...item, quantity: item.quantity + 1 } : item
        );
      }
      return [...prevCart, { ...product, quantity: 1 }];
    });
  };

  const updateQuantity = (id, quantity) => {
    if (quantity <= 0) {
      setCart((prevCart) => prevCart.filter((item) => item.id !== id));
    } else {
      setCart((prevCart) =>
        prevCart.map((item) => (item.id === id ? { ...item, quantity } : item))
      );
    }
  };

  const removeFromCart = (id) => {
    setCart((prevCart) => prevCart.filter((item) => item.id !== id));
  };

  const grandTotal = cart.reduce((sum, item) => sum + item.price * item.quantity, 0);
  const totalItems = cart.reduce((sum, item) => sum + item.quantity, 0);

  return (
    <CartContext.Provider value={{ products, cart, addToCart, updateQuantity, removeFromCart, grandTotal, totalItems }}>
      {children}
    </CartContext.Provider>
  );
};
