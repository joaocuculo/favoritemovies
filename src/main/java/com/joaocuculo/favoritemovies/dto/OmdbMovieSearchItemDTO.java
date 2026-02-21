package com.joaocuculo.favoritemovies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OmdbMovieSearchItemDTO(
    @JsonProperty("Title") String title,
    @JsonProperty("Year") String year,
    @JsonProperty("imdbID") String imdbID,
    @JsonProperty("Type") String type,
    @JsonProperty("Poster") String poster
) {}
