package com.sve.movies.repo;

import com.sve.movies.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, Long> {}