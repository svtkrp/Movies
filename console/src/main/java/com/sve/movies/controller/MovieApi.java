package com.sve.movies.controller;

import com.sve.movies.dto.MovieDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MovieApi {
    @POST("movies/")
    Call<Void> addMovies(@Body List<MovieDTO> movies);
}
