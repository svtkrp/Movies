package com.sve.movies.controller;

import com.sve.movies.dto.MovieDTO;
import com.sve.movies.dto.MovieGetDTO;
import com.sve.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
public class MoviesController {

    @Autowired
    IMovieService service;

    @CrossOrigin
    @GetMapping("/movies")
    public List<MovieGetDTO> getMovies(@RequestParam(value = "date", defaultValue = "") String dateStr) {
        Date date = null;
        if (dateStr != null && !dateStr.equals("")) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                df.setTimeZone(TimeZone.getTimeZone("GMT"));
                date = df.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return service.getMoviesByDate(date);
    }

    @PostMapping("/movies")
    public void saveMovies(@RequestBody List<MovieDTO> movies) {
        service.saveMovies(movies);
    }
}
