# Топ-10 Кинопоиска, актуальный на определенную дату
Java, Retrofit, Jsoup

## Как попробовать онлайн:
Зайти на [сайт](https://sve.my.to/movies).

## Как попробовать локально:
1) Скачать данный репозиторий:
```sh
$ git clone https://github.com/svtkrp/Movies.git
```
Находясь в директории backend, поменять в src/main/resources/application.properties путь к БД и другие свойства на:
```sh
spring.datasource.url=jdbc:h2:file:/путь/к/бд/имя_файлов_бд
spring.h2.console.enabled=true
spring.h2.console.path=/h2
spring.jpa.hibernate.ddl-auto=create-drop
```
Находясь в директории backend, собрать jar:
```sh
mvn clean package
```
И запустить его.

2) Скачать и 1+ раз запустить movies-console-1.jar для парсинга фильмов с Кинопоиска.
   Скачать архив movie-frontend-1, извлечь файлы и папки.
   Затем открыть в браузере public/index.html.
   