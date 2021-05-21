package com.sve.movies.constants;

public enum Query {
    PANE("div.selection-list"),
    MOVIE_ID("a.selection-film-item-meta__link"),

    NAME_RUSSIAN("p.selection-film-item-meta__name"),
    NAME_ORIGINAL_YEAR("p.selection-film-item-meta__original-name"),

    POSITION("span.film-item-rating-position__position"),
    VALUE("span.rating__value"),
    COUNT("span.rating__count");

    private String query;

    Query(String query){
        this.query = query;
    }

    public String get() {
        return query;
    }
}
