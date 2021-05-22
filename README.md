# Топ-10 Кинопоиска, актуальный на определенную дату
backend - maven проект, собственно backend (Spring Boot, Hibernate, H2, Ehcache, Tomcat) + СХЕМА БД.

console - maven проект, клиент, посылающий POST-запросы с помощью retrofit со списком фильмов, которые парсит с Кинопоиска с помощью jsoup.

frontend - react веб-приложение, посылающее GET-запросы с помошью axios с датой, в ответ получает самый актуальный на эту дату спарсенный список фильмов.

## Как попробовать онлайн:
Зайти на [сайт](http://sve.my.to/movies).

## Как попробовать локально:
1) Скачать данный репозиторий:
```sh
$ git clone https://github.com/svtkrp/Movies.git
```
Находясь в директории backend, поменять в src/main/resources/application.properties путь к БД на:
```sh
spring.datasource.url=jdbc:h2:file:/путь/к/бд/имя_файлов_бд
```
Находясь в директории backend, собрать jar:
```sh
mvn clean package
```
И запустить его.

2) Скачать и 1+ раз запустить movies-console-1.jar для парсинга фильмов с Кинопоиска.

Скачать архив movie-frontend-1, извлечь файлы и папки.
В js/indexApp.js найти "sve.my.to" в одном месте (в src это в DateMovies.js) и поменять на "localhost" (если использовать localhost, на андроиде почему-то "Failed to load resource: net::ERR CONNECTION REFUSED" во всех браузерах).

Затем открыть в браузере public/index.html.
