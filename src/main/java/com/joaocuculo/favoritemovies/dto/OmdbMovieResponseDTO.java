package com.joaocuculo.favoritemovies.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbMovieResponseDTO implements Serializable {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Rated")
    private String rated;

    @JsonProperty("Released")
    private String released;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Writer")
    private String writer;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Awards")
    private String awards;

    @JsonProperty("Ratings")
    private List<RatingsDTO> ratings;

    @JsonProperty("Metascore")
    private String metascore;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("imdbVotes")
    private String imdbVotes;

    @JsonProperty("BoxOffice")
    private String boxOffice;

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

    public OmdbMovieResponseDTO(String title, String year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String language, String country, String awards, List<RatingsDTO> ratings, String metascore, String imdbRating, String imdbVotes, String boxOffice, String imdbID, String type, String plot, String poster, String response) {
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

    public List<RatingsDTO> getRatings() {
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
