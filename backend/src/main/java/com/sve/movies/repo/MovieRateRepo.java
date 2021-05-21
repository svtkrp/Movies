package com.sve.movies.repo;

import com.sve.movies.entity.MovieRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MovieRateRepo extends CrudRepository<MovieRate, Long> {

    @Query("select mr.id as id, mr.movieId as movieId, mr.date as date, " +
            "m.nameRussian as nameRussian, m.nameOriginal as nameOriginal, m.year as year, " +
            "mr.position as position, mr.value as value, mr.count as count " +
            "from Movie m join MovieRate mr on m.id = mr.movieId " +
            "where mr.date = (select max(date) from MovieRate where date <= :date)")
    List<Map<String, Object>> findMovieRatesWithMovieByDate(@Param("date") Date date);

    @Query("select case when count(t) > 0 then true else false end " +
            "from MovieRate t " +
            "where t.date = :date and t.movieId = :movieId")
    boolean existsByDateAndMovieId(@Param("date") Date date, @Param("movieId") Long movieId);
}