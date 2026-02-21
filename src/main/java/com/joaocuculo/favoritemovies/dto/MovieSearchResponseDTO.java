package com.joaocuculo.favoritemovies.dto;

import java.util.List;

public record MovieSearchResponseDTO(
    List<MovieSearchDTO> movies,
    Integer page,
    Integer totalResults,
    Integer totalPages
) {}
