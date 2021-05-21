package com.sve.movies.dto;

public class MovieGetDTO {
    private String nameRussian;
    private String nameOriginal;
    private int year;
    private int position;
    private int value;
    private long count;

    public MovieGetDTO() {}

    public MovieGetDTO(String nameRussian, String nameOriginal, int year,
                       int position, int value, long count) {
        this.nameRussian = nameRussian;
        this.nameOriginal = nameOriginal;
        this.year = year;
        this.position = position;
        this.value = value;
        this.count = count;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                ", nameRussian='" + nameRussian + '\'' +
                ", nameOriginal='" + nameOriginal + '\'' +
                ", year=" + year +
                ", position=" + position +
                ", value=" + value +
                ", count=" + count +
                '}';
    }

    public String getNameRussian() {
        return nameRussian;
    }

    public void setNameRussian(String nameRussian) {
        this.nameRussian = nameRussian;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}