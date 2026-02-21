package com.joaocuculo.favoritemovies.dto;

import java.util.List;

public record MovieResponseDTO(
    String imdbId,
    String title,
    String year,
    String rated,
    String released,
    String runtime,
    String genre,
    String director,
    String writer,
    String actors,
    String language,
    String country,
    String awards,
    List<MovieRatingsDTO> ratings,
    String metascore,
    String imdbRating,
    String imdbVotes,
    String boxOffice,
    String type,
    String poster,
    String plot
) {}
