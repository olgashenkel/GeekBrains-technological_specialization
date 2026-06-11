import 'react';

const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer__subscribe">
        <div className="footer__subscribe__left">
          <img className="footer__subscribe__image" src="img/footer/Intersect.png" alt="Intersect" />
          <div className="footer__subscribe__left__text">
            “Vestibulum quis porttitor dui! Quisque viverra nunc mi, <i>a pulvinar purus condimentum</i>“
          </div>
        </div>
        <div className="footer__subscribe__right">
          <div className="footer__subscribe__right__text-head">
            SUBSCRIBE <br /><span className="footer__subscribe__right__text">FOR OUR NEWLETTER AND PROMOTION</span>
          </div>
          <div className="footer__subscribe__right__form">
            <input type="text" className="footer__subscribe__right__form_email" placeholder="Enter Your Email" />
            <button className="footer__subscribe__right__form_button">Subscribe</button>
          </div>
        </div>
      </div>
      <div className="footer__copyright">
        <div className="footer__copyright__left">
          <div className="footer__copyright_text">© 2023 Brand All Rights Reserved.</div>
        </div>
        <div className="footer__copyright__right">
          <div className="footer__copyright__box"><a href="#"><img className="footer__copyright__box_SocialIcon" src="img/footer/facebook.png" alt="facebook" /></a></div>
          <div className="footer__copyright__box footer__copyright__box-instagram"><a href="#"><img className="footer__copyright__box_SocialIcon-instagram" src="img/footer/instagram.png" alt="instagram" /></a></div>
          <div className="footer__copyright__box"><a href="#"><img className="footer__copyright__box_SocialIcon" src="img/footer/pinterest.png" alt="pinterest" /></a></div>
          <div className="footer__copyright__box"><a href="#"><img className="footer__copyright__box_SocialIcon" src="img/footer/twitter.png" alt="twitter" /></a></div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
