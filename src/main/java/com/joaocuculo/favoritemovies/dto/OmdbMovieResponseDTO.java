package com.joaocuculo.favoritemovies.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbMovieResponseDTO {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Response")
    private String response;

    public OmdbMovieResponseDTO() {
    }

    public OmdbMovieResponseDTO(String title, String year, String imdbID, String type, String plot, String poster, String response) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.plot = plot;
        this.poster = poster;
        this.response = response;
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

    public String getPlot() {
        return plot;
    }

    public String getPoster() {
        return poster;
    }

    public String getResponse() {
        return response;
    }
}
