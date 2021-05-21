package com.sve.movies.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class MovieRate {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long movieId;
    private Date date;
    private int position;
    private int value;
    private long count;

    protected MovieRate() {}

    public MovieRate(Long movieId, Date date, int position, int value, long count) {
        this.movieId = movieId;
        this.date = date;
        this.position = position;
        this.value = value;
        this.count = count;
    }

    @Override
    public String toString() {
        return "MovieRate{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", date=" + date +
                ", position=" + position +
                ", value=" + value +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieRate movieRate = (MovieRate) o;
        return position == movieRate.position && count == movieRate.count && value == movieRate.value
                && id.equals(movieRate.id) && movieId.equals(movieRate.movieId)
                && Objects.equals(date, movieRate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, date, position, value, count);
    }

    public Long getId() {
        return id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Date getDate() {
        return date;
    }

    public int getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public long getCount() {
        return count;
    }
}