package com.joaocuculo.favoritemovies.dto;

import java.io.Serializable;
import java.util.List;

public class MovieResponseDTO implements Serializable {

    private String imdbId;
    private String title;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String language;
    private String country;
    private String awards;
    private List<MovieRatingsDTO> ratings;
    private String metascore;
    private String imdbRating;
    private String imdbVotes;
    private String boxOffice;
    private String type;
    private String poster;
    private String plot;

    public MovieResponseDTO() {
    }

    public MovieResponseDTO(String imdbId, String title, String year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String language, String country, String awards, List<MovieRatingsDTO> ratings, String metascore, String imdbRating, String imdbVotes, String boxOffice, String type, String poster, String plot) {
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.ratings = ratings;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.boxOffice = boxOffice;
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

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public List<MovieRatingsDTO> getRatings() {
        return ratings;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getBoxOffice() {
        return boxOffice;
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
