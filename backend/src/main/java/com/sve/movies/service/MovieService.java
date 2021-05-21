package com.sve.movies.service;

import com.sve.movies.dto.MovieDTO;
import com.sve.movies.dto.MovieGetDTO;
import com.sve.movies.entity.Movie;
import com.sve.movies.entity.MovieRate;
import com.sve.movies.repo.MovieRateRepo;
import com.sve.movies.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MovieService implements IMovieService {

    @Autowired
    MovieRepo movieRepo;
    @Autowired
    MovieRateRepo movieRateRepo;

    @Transactional
    @Override
    public List<MovieGetDTO> getMoviesByDate(Date date) {
        if (date == null) date = getCurrentDate();
        List<Map<String, Object>> rows = movieRateRepo.findMovieRatesWithMovieByDate(date);
        if (rows.isEmpty()) return new ArrayList<>();
        return new MovieServiceMapper(rows).toMoviesGet();
    }

    private static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    @Transactional
    @Override
    public void saveMovies(List<MovieDTO> movieDTOs) {
        for (MovieDTO md : movieDTOs) {
            if (!movieRateRepo.existsByDateAndMovieId(md.getDate(), md.getMovieId())) {
                movieRateRepo.save(movieDTOToMovieRate(md));
            }
            if (!movieRepo.existsById(md.getMovieId())) {
                movieRepo.save(movieDTOToMovie(md));
            }
        }
    }

    private MovieRate movieDTOToMovieRate(MovieDTO md) {
        return new MovieRate(md.getMovieId(), md.getDate(), md.getPosition(), md.getValue(), md.getCount());
    }

    private Movie movieDTOToMovie(MovieDTO md) {
        return new Movie(md.getMovieId(), md.getNameRussian(), md.getNameOriginal(), md.getYear());
    }
}