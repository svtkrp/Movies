package com.sve.movies;

import com.sve.movies.constants.ParseConstants;
import com.sve.movies.constants.Query;
import com.sve.movies.controller.AddMoviesController;
import com.sve.movies.dto.MovieDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(ParseConstants.URL)
                    .userAgent(ParseConstants.USER_AGENT)
                    .referrer(ParseConstants.REFERRER)
                    .get();
            List<MovieDTO> movieDTOs = createMovieDTOs(doc);
            new AddMoviesController().start(movieDTOs);
        } catch (Exception e) {
            if (e instanceof IOException) {
                System.out.println("Проверьте URL. " + e.toString());
            } else if (e instanceof IndexOutOfBoundsException) {
                System.out.println("По одному из cssQuery нашлось меньше ожидаемого. " + e.toString());
                for (StackTraceElement ste : e.getStackTrace()) System.out.println(ste);
            } else {
                System.out.println("Что-то пошло не так. " + e.toString());
                for (StackTraceElement ste : e.getStackTrace()) System.out.println(ste);
            }
        }
    }

    private static List<MovieDTO> createMovieDTOs(Document doc) {
        Date date = getCurrentDate();
        Element pane = doc.select(Query.PANE.get()).get(0);
        List<MovieDTO> movies = new ArrayList<MovieDTO>();
        for (int i = 0; i < 10; i++) {
            movies.add(createMovieDTO(i, pane, date));
        }
        return movies;
    }

    private static MovieDTO createMovieDTO(int i, Element pane, Date date) {
        MovieDTO movie = new MovieDTO();
        movie.setMovieId(getMovieId(pane.select(Query.MOVIE_ID.get()).get(i)));
        movie.setDate(date);
        movie.setNameRussian(pane.select(Query.NAME_RUSSIAN.get()).get(i).text());
        movie.setNameOriginal(getNameOriginal(pane.select(Query.NAME_ORIGINAL_YEAR.get()).get(i)));
        movie.setYear(getYear(pane.select(Query.NAME_ORIGINAL_YEAR.get()).get(i)));
        movie.setPosition(Integer.parseInt(pane.select(Query.POSITION.get()).get(i).text()));
        movie.setValue(getValue(pane.select(Query.VALUE.get()).get(i)));
        movie.setCount(getCount(pane.select(Query.COUNT.get()).get(i)));
        System.out.println(movie);
        return movie;
    }

    private static Long getMovieId(Element element) {
        String link = element.attr("href");
        Pattern pattern = Pattern.compile("(\\d)+");
        Matcher matcher = pattern.matcher(link);
        if (matcher.find()) {
            return Long.parseLong(matcher.group());
        }
        throw new IllegalArgumentException();
    }

    private static String getNameOriginal(Element element) {
        String text = element.text();
        if (text.length() < 7) return "";
        return text.substring(0, text.length() - 6);
    }

    private static int getYear(Element element) {
        String text = element.text();
        if (text.length() < 4) return -1;
        return Integer.parseInt(text.substring(text.length() - 4));
    }

    private static int getValue(Element element) {
        String text = element.text();
        text = text.replaceAll("\\.", "");
        return Integer.parseInt(text);
    }

    private static Long getCount(Element element) {
        String text = element.text();
        text = text.replaceAll(" ", "");
        return Long.parseLong(text);
    }

    private static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }
}
