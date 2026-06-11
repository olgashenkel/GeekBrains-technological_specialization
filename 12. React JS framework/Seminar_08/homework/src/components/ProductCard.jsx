import { useContext } from 'react';
import { CartContext } from '../context/CartContext';

const ProductCard = ({ product }) => {
  const { addToCart } = useContext(CartContext);

  return (
    <div className="productIndex">
      <img className="productIndex__img" src={product.img} alt={product.name} />
      <div className="productIndex__img_blackout">
        <button className="productIndex__img_blackout_button" onClick={() => addToCart(product)}>
          <img className="productIndex__img_blackout_button_img" src="img/Vector/Сart_Vector.png" alt="shopping cart" />
          <p className="productIndex__img_blackout_button_text">Add to Cart</p>
        </button>
      </div>
      <div className="productIndex__content">
        <a href="#" className="productIndex__name">{product.name} (Size: {product.size})</a>
        <p className="productIndex__text">{product.text}</p>
        <p className="productIndex__price">${product.price}.00</p>
      </div>
    </div>
  );
};

export default ProductCard;
