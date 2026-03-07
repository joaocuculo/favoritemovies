package com.joaocuculo.favoritemovies.exceptions;

public class MovieAlreadyFavoritedException extends RuntimeException {
    public MovieAlreadyFavoritedException(String message) {
        super(message);
    }
}
