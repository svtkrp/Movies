package com.sve.movies.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable("cache")
public class Movie {
    @Id
    private Long id;
    private String nameRussian;
    private String nameOriginal;
    private int year;

    protected Movie() {}

    public Movie(Long id, String nameRussian, String nameOriginal, int year) {
        this.id = id;
        this.nameRussian = nameRussian;
        this.nameOriginal = nameOriginal;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id.equals(movie.id) && year == movie.year
                && Objects.equals(nameRussian, movie.nameRussian)
                && Objects.equals(nameOriginal, movie.nameOriginal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameRussian, nameOriginal, year);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nameRussian='" + nameRussian + '\'' +
                ", nameOriginal='" + nameOriginal + '\'' +
                ", year=" + year +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNameRussian() {
        return nameRussian;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public int getYear() {
        return year;
    }
}