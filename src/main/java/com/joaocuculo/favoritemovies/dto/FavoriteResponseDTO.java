package com.joaocuculo.favoritemovies.dto;

import java.io.Serializable;
import java.time.Instant;

public class FavoriteResponseDTO implements Serializable {

    private Long id;
    private String imdbId;
    private String title;
    private String poster;
    private Double imdbRating;
    private Instant favoritedAt;

    public FavoriteResponseDTO() {
    }

    public FavoriteResponseDTO(Long id, String imdbId, String title, String poster, Double imdbRating, Instant favoritedAt) {
        this.id = id;
        this.imdbId = imdbId;
        this.title = title;
        this.poster = poster;
        this.imdbRating = imdbRating;
        this.favoritedAt = favoritedAt;
    }

    public Long getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public Instant getFavoritedAt() {
        return favoritedAt;
    }
}
