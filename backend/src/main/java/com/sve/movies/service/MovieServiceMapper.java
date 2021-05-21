package com.sve.movies.service;

import com.sve.movies.dto.MovieDTO;
import com.sve.movies.dto.MovieGetDTO;

import java.util.*;

public class MovieServiceMapper {
    private final Map<String, Object> row;
    private final List<Map<String, Object>> rows;

    public MovieServiceMapper(Map<String, Object> row) {
        this.row = row;
        this.rows = Collections.singletonList(row);
    }

    public MovieServiceMapper(List<Map<String, Object>> rows) {
        this.row = rows.get(0);
        this.rows = rows;
    }

    public MovieServiceMapper() {
        this(new HashMap<>());
    }

    public MovieDTO toMovie() {
        return new MovieDTO(
                (Long) row.get("movieId"),
                (Date) row.get("date"),
                (String) row.get("nameRussian"),
                (String) row.get("nameOriginal"),
                (int) row.get("year"),
                (int) row.get("position"),
                (int) row.get("value"),
                (long) row.get("count")
        );
    }

    public List<MovieDTO> toMovies() {
        Map<Long, MovieDTO> movieMap = new HashMap<>();
        for (Map<String, Object> row : rows) {
            Long id = (Long) row.get("id");
            MovieDTO movieDTO = movieMap.get(id);
            if (movieDTO == null) movieDTO = new MovieDTO(
                    (Long) row.get("movieId"),
                    (Date) row.get("date"),
                    (String) row.get("nameRussian"),
                    (String) row.get("nameOriginal"),
                    (int) row.get("year"),
                    (int) row.get("position"),
                    (int) row.get("value"),
                    (long) row.get("count")
            );
            movieMap.put(id, movieDTO);
        }

        return new ArrayList<>(movieMap.values());
    }

    public MovieGetDTO toMovieGet() {
        return new MovieGetDTO(
                (String) row.get("nameRussian"),
                (String) row.get("nameOriginal"),
                (int) row.get("year"),
                (int) row.get("position"),
                (int) row.get("value"),
                (long) row.get("count")
        );
    }

    public List<MovieGetDTO> toMoviesGet() {
        Map<Long, MovieGetDTO> movieMap = new HashMap<>();
        for (Map<String, Object> row : rows) {
            Long id = (Long) row.get("id");
            MovieGetDTO movieGetDTO = movieMap.get(id);
            if (movieGetDTO == null) movieGetDTO = new MovieGetDTO(
                    (String) row.get("nameRussian"),
                    (String) row.get("nameOriginal"),
                    (int) row.get("year"),
                    (int) row.get("position"),
                    (int) row.get("value"),
                    (long) row.get("count")
            );
            movieMap.put(id, movieGetDTO);
        }

        return new ArrayList<>(movieMap.values());
    }
}
