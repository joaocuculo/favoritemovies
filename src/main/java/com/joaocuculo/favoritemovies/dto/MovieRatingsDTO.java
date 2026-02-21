package com.joaocuculo.favoritemovies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MovieRatingsDTO(
    @JsonProperty("Source") String source,
    @JsonProperty("Value") String value
) {}
