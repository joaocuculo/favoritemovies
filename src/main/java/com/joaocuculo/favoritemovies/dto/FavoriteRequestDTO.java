package com.joaocuculo.favoritemovies.dto;

import jakarta.validation.constraints.NotBlank;

public record FavoriteRequestDTO (@NotBlank String movieImdbId) {
}
