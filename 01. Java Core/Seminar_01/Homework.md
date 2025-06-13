
## Урок 1. Компиляция и интерпретация кода

Создать docker-контейнер для формирования полной документации по проекту.

1. Создание Dockerfile:
В корне проекта создайте файл Dockerfile, который будет содержать инструкции по созданию образа контейнера. В нем можно указать базовый образ (например, java:11-openjdk-11), установить необходимые инструменты для генерации документации (например, Javadoc), указать точку входа (например, команду для запуска генерации документации). 

```
# Используем базовый образ с JDK 11
FROM openjdk:11

# Копируем исходный код в контейнер
COPY ./src /usr/app/src

# Создаем директории для выходных файлов и документации
RUN mkdir -p /usr/app/out /usr/app/doc

# Компилируем исходный код и создаем javadoc
RUN javac -d /usr/app/out /usr/app/src/ru/gb/seminar/*.java /usr/app/src/ru/gb/seminar/*.java \
&& javadoc -d /usr/app/doc /usr/app/src/ru/gb/seminar/*.java /usr/app/src/ru/gb/seminar/*.java

# Устанавливаем рабочую директорию
WORKDIR /usr/app

# Запускаем Java приложение и открываем страницу javadoc в браузере
CMD ["sh", "-c", "java -classpath /usr/app/out ru.gb.seminar.Main && cat /usr/app/doc/index.html"]
```

2. Создание образа Docker:
С помощью команды (в терминале) docker build -t <имя_образа> . создается образ контейнера из Dockerfile. 
 
`docker build -t jc_seminar01_dz .`
 
3. Запуск контейнера:
Используйте команду docker run -it <имя_образа> для запуска контейнера в интерактивном режиме или docker run -d <имя_образа> для запуска контейнера в режиме демона. 
 
`docker run jc_seminar01_dz`