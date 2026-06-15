FROM php:8.2-fpm
RUN docker-php-ext-install pdo_mysql \
    && apt-get update && apt-get install -y $PHPIZE_DEPS \
    && pecl install xdebug \
    && docker-php-ext-enable xdebug
