package com.joaocuculo.favoritemovies.services;

import com.joaocuculo.favoritemovies.client.OmdbClient;
import com.joaocuculo.favoritemovies.dto.MovieResponseDTO;
import com.joaocuculo.favoritemovies.dto.OmdbMovieResponseDTO;
import com.joaocuculo.favoritemovies.dto.OmdbSearchResponseDTO;
import com.joaocuculo.favoritemovies.entities.Movie;
import com.joaocuculo.favoritemovies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private OmdbClient omdbClient;

    public List<MovieResponseDTO> search(String search) {
        OmdbSearchResponseDTO omdbDto = omdbClient.search(search);
        return omdbDto.getSearch()
                .stream()
                .map(movie -> new MovieResponseDTO(
                        movie.getImdbID(),
                        movie.getTitle(),
                        movie.getYear(),
                        movie.getType(),
                        movie.getPoster()))
                .collect(Collectors.toList());
    }

    public MovieResponseDTO findByImdbId(String imdbId) {
        OmdbMovieResponseDTO omdbDto = omdbClient.findByImdbId(imdbId);
        return new MovieResponseDTO(
                omdbDto.getImdbID(),
                omdbDto.getTitle(),
                omdbDto.getYear(),
                omdbDto.getType(),
                omdbDto.getPoster(),
                omdbDto.getPlot());
    }
}
