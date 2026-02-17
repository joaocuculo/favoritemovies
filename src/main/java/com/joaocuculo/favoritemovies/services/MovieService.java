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

        List<MovieSearchDTO> movieList = omdbDto.getSearch()
                .stream()
                .map(movie -> new MovieSearchDTO(
                        movie.getTitle(),
                        movie.getYear(),
                        movie.getImdbID(),
                        movie.getType(),
                        movie.getPoster()
                )).toList();

        int totalResults = Integer.parseInt(omdbDto.getTotalResults());
        int totalPages = (int) Math.ceil(totalResults / 10.0);

        return new MovieSearchResponseDTO(movieList, page, totalResults, totalPages);
    }

    public MovieResponseDTO findByImdbId(String imdbId) {
        OmdbMovieResponseDTO omdbDto = omdbClient.findByImdbId(imdbId);
        return new MovieResponseDTO(
                omdbDto.getImdbID(),
                omdbDto.getTitle(),
                omdbDto.getYear(),
                omdbDto.getRated(),
                omdbDto.getReleased(),
                omdbDto.getRuntime(),
                omdbDto.getGenre(),
                omdbDto.getDirector(),
                omdbDto.getWriter(),
                omdbDto.getActors(),
                omdbDto.getLanguage(),
                omdbDto.getCountry(),
                omdbDto.getAwards(),
                omdbDto.getRatings(),
                omdbDto.getMetascore(),
                omdbDto.getImdbRating(),
                omdbDto.getImdbVotes(),
                omdbDto.getBoxOffice(),
                omdbDto.getType(),
                omdbDto.getPoster(),
                omdbDto.getPlot());
    }
}
