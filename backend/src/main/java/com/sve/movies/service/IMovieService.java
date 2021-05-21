package com.sve.movies.service;

import com.sve.movies.dto.MovieDTO;
import com.sve.movies.dto.MovieGetDTO;

import java.util.Date;
import java.util.List;

public interface IMovieService {
    List<MovieGetDTO> getMoviesByDate(Date date);
    void saveMovies(List<MovieDTO> movieDTOs);
}
