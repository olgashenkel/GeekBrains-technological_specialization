import { useContext } from 'react';
import { Link } from 'react-router-dom';
import { CartContext } from '../context/CartContext';

const Header = () => {
  const { totalItems } = useContext(CartContext);

  return (
    <header className="header center">
      <div className="header__left">
        <Link to="/" className="logo"><img src="img/header/logo.svg" alt="logo" /></Link>
        <svg width="26" height="27" viewBox="0 0 26 27" fill="none" xmlns="http://w3.org">
          <path d="M18.0616 17.415C19.6732 15.6549 20.6302 13.3938 20.7717 11.0115C20.9133 8.62924 20.2308 6.27079 18.8389 4.33224C17.447 2.39369 15.4304 0.993102 13.1279 0.365682C10.8254 -0.261738 8.37705 -0.0777777 6.19412 0.886668C4.01119 1.85111 2.22658 3.53731 1.13999 5.66209C0.0534004 7.78686 -0.268993 10.2208 0.226949 12.5552C0.722891 14.8896 2.00696 16.9823 3.86353 18.4818C5.7201 19.9813 8.03609 20.7963 10.4226 20.79C12.6749 20.7931 14.8665 20.059 16.6626 18.7L24.4106 26.507C24.4961 26.596 24.5985 26.6671 24.7118 26.7161C24.8252 26.765 24.9471 26.7908 25.0706 26.792C25.1943 26.7924 25.3167 26.7673 25.4303 26.7182C25.5438 26.6692 25.6461 26.5973 25.7306 26.507C25.9045 26.3261 26.0016 26.0849 26.0016 25.834C26.0016 25.583 25.9045 25.3418 25.7306 25.161L18.0616 17.415ZM1.88858 10.29C1.90141 8.60469 2.41289 6.96093 3.35854 5.56591C4.30419 4.1709 5.64168 3.08707 7.20239 2.45106C8.7631 1.81505 10.4772 1.65533 12.1285 1.99204C13.7799 2.32875 15.2946 3.14682 16.4817 4.3431C17.6688 5.53939 18.4752 7.06035 18.7991 8.71425C19.1231 10.3681 18.9502 12.0809 18.3022 13.6367C17.6542 15.1925 16.5601 16.5216 15.1578 17.4564C13.7555 18.3913 12.1079 18.8901 10.4226 18.89C8.15112 18.8791 5.97677 17.9675 4.37679 16.3551C2.77681 14.7427 1.88193 12.5614 1.88858 10.29Z" fill="#E8E8E8" />
        </svg>
      </div>
      <div class="header__right">
        <label htmlFor="burger"><img src="img/header/burger-menu.svg" alt="burger-menu" /></label>
        <input id="burger" type="checkbox" defaultChecked style={{ display: 'none' }} />
        
        <Link to="#" className="header__right_profile"><img src="img/header/profile.png" alt="profile" /></Link>
        <Link to="/cart" className="header__right_basket">
          <img src="img/header/basket.png" alt="basket" />
          {totalItems > 0 && <span class="header__right_basket-count">{totalItems}</span>}
        </Link>
      </div>
    </header>
  );
};

export default Header;
