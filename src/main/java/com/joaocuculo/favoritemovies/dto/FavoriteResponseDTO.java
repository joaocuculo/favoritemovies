package com.joaocuculo.favoritemovies.dto;

import java.time.Instant;

public record FavoriteResponseDTO(
    Long id,
    String imdbId,
    String title,
    String poster,
    Double imdbRating,
    Instant favoritedAt
) {}
