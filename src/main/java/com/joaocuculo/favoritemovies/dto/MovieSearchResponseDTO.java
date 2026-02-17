package com.joaocuculo.favoritemovies.dto;

import java.io.Serializable;
import java.util.List;

public class MovieSearchResponseDTO implements Serializable {

    private List<MovieSearchDTO> movies;
    private Integer page;
    private Integer totalResults;
    private Integer totalPages;

    public MovieSearchResponseDTO() {
    }

    public MovieSearchResponseDTO(List<MovieSearchDTO> movies, Integer page, Integer totalResults, Integer totalPages) {
        this.movies = movies;
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }

    public List<MovieSearchDTO> getMovies() {
        return movies;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }
}
