package com.joaocuculo.favoritemovies.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OmdbMovieResponseDTO(
    @JsonProperty("Title") String title,
    @JsonProperty("Year") String year,
    @JsonProperty("Rated") String rated,
    @JsonProperty("Released") String released,
    @JsonProperty("Runtime") String runtime,
    @JsonProperty("Genre") String genre,
    @JsonProperty("Director") String director,
    @JsonProperty("Writer") String writer,
    @JsonProperty("Actors") String actors,
    @JsonProperty("Language") String language,
    @JsonProperty("Country") String country,
    @JsonProperty("Awards") String awards,
    @JsonProperty("Ratings") List<MovieRatingsDTO> ratings,
    @JsonProperty("Metascore") String metascore,
    @JsonProperty("imdbRating") String imdbRating,
    @JsonProperty("imdbVotes") String imdbVotes,
    @JsonProperty("BoxOffice") String boxOffice,
    @JsonProperty("imdbID") String imdbID,
    @JsonProperty("Type") String type,
    @JsonProperty("Plot") String plot,
    @JsonProperty("Poster") String poster,
    @JsonProperty("Response") String response
) {}
