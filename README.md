# Топ-10 Кинопоиска, актуальный на определенную дату
backend - maven проект, backend (spring boot, hibernate, h2, tomcat) + СХЕМА БД.
console - maven проект, клиент, посылающий POST-запросы с помощью retrofit со списком фильмов, которые парсит с Кинопоиска с помощью jsoup.
frontend - react веб-приложение, посылающее GET-запросы с помошью axios с датой, в ответ получает самый актуальный на эту дату спарсенный список фильмов.

## Как попробовать онлайн:
Зайти на сайт [SVE.MY.TO](https://sve.my.to/movies).

## Как попробовать локально:
1) Скачать jar-файлы, запустить movies-backend.jar, 1+ раз запустить movies-console.jar для парсинга фильмов с Кинопоиска.

2) Скачать данный репозиторий:
```sh
$ git clone https://github.com/svtkrp/Movies.git
```
Находясь в директории frontend, выполнить:
```sh
$ npm install
$ npm run-script build
```
Или скачать архив movie-frontend, извлечь файлы и папки.

Затем открыть в браузере public/index.html.
