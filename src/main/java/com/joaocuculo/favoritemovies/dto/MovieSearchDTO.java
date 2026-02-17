package com.joaocuculo.favoritemovies.dto;

import java.io.Serializable;

public class MovieSearchDTO implements Serializable {

    private String title;
    private String year;
    private String imdbID;
    private String type;
    private String poster;

    public MovieSearchDTO() {
    }

    public MovieSearchDTO(String title, String year, String imdbID, String type, String poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }
}
