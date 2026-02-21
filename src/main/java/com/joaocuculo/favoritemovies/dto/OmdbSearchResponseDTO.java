package com.joaocuculo.favoritemovies.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OmdbSearchResponseDTO(
    @JsonProperty("Search") List<OmdbMovieSearchItemDTO> search,
    @JsonProperty("totalResults") String totalResults,
    @JsonProperty("Response") String response
) {}
