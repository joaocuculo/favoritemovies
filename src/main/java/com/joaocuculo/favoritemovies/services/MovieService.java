package com.joaocuculo.favoritemovies.services;

import com.joaocuculo.favoritemovies.client.OmdbClient;
import com.joaocuculo.favoritemovies.dto.*;
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

    public MovieSearchResponseDTO search(String search, Integer page) {
        OmdbSearchResponseDTO omdbDto = omdbClient.search(search, page);

        List<MovieSearchDTO> movieList = omdbDto.search()
                .stream()
                .map(movie -> new MovieSearchDTO(
                        movie.title(),
                        movie.year(),
                        movie.imdbID(),
                        movie.type(),
                        movie.poster()
                )).toList();

        int totalResults = Integer.parseInt(omdbDto.totalResults());
        int totalPages = (int) Math.ceil(totalResults / 10.0);

        return new MovieSearchResponseDTO(movieList, page, totalResults, totalPages);
    }

    public MovieResponseDTO findByImdbId(String imdbId) {
        OmdbMovieResponseDTO omdbDto = omdbClient.findByImdbId(imdbId);
        return new MovieResponseDTO(
                omdbDto.imdbID(),
                omdbDto.title(),
                omdbDto.year(),
                omdbDto.rated(),
                omdbDto.released(),
                omdbDto.runtime(),
                omdbDto.genre(),
                omdbDto.director(),
                omdbDto.writer(),
                omdbDto.actors(),
                omdbDto.language(),
                omdbDto.country(),
                omdbDto.awards(),
                omdbDto.ratings(),
                omdbDto.metascore(),
                omdbDto.imdbRating(),
                omdbDto.imdbVotes(),
                omdbDto.boxOffice(),
                omdbDto.type(),
                omdbDto.poster(),
                omdbDto.plot());
    }
}
