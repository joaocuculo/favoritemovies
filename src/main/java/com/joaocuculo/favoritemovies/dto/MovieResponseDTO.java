package com.joaocuculo.favoritemovies.dto;

import java.io.Serializable;

public class MovieResponseDTO implements Serializable {

    private String imdbId;
    private String title;
    private String year;
    private String type;
    private String poster;
    private String plot;

    public MovieResponseDTO() {
    }

    public MovieResponseDTO(String imdbId, String title, String year, String type, String poster, String plot) {
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
        this.type = type;
        this.poster = poster;
        this.plot = plot;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }

    public String getPlot() {
        return plot;
    }
}
