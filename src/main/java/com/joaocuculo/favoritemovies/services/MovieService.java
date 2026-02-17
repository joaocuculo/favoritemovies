package com.joaocuculo.favoritemovies.services;

import com.joaocuculo.favoritemovies.client.OmdbClient;
import com.joaocuculo.favoritemovies.dto.MovieResponseDTO;
import com.joaocuculo.favoritemovies.dto.OmdbMovieResponseDTO;
import com.joaocuculo.favoritemovies.entities.Movie;
import com.joaocuculo.favoritemovies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private OmdbClient omdbClient;

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public MovieResponseDTO findByImdbId(String imdbId) {
        OmdbMovieResponseDTO omdbDto = omdbClient.findByImdbId(imdbId);
        return new MovieResponseDTO(omdbDto.getImdbID(), omdbDto.getTitle(), omdbDto.getYear(), omdbDto.getType(), omdbDto.getPoster(), omdbDto.getPlot());
    }
}
