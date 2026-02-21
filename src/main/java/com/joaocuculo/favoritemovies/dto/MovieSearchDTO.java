package com.joaocuculo.favoritemovies.dto;

public record MovieSearchDTO(
    String title,
    String year,
    String imdbID,
    String type,
    String poster
) {}
