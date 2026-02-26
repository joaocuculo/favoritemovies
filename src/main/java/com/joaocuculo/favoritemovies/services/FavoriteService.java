package com.joaocuculo.favoritemovies.services;

import com.joaocuculo.favoritemovies.client.OmdbClient;
import com.joaocuculo.favoritemovies.dto.FavoriteResponseDTO;
import com.joaocuculo.favoritemovies.dto.OmdbMovieResponseDTO;
import com.joaocuculo.favoritemovies.entities.Favorite;
import com.joaocuculo.favoritemovies.entities.Movie;
import com.joaocuculo.favoritemovies.entities.User;
import com.joaocuculo.favoritemovies.repositories.FavoriteRepository;
import com.joaocuculo.favoritemovies.repositories.MovieRepository;
import com.joaocuculo.favoritemovies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private OmdbClient omdbClient;

    public Page<FavoriteResponseDTO> findByUserId(Long userId, Pageable pageable) {
        Page<Favorite> favorites = repository.findByUserId(userId, pageable);
        return favorites
                .map(favs -> new FavoriteResponseDTO(
                        favs.getId(),
                        favs.getMovie().getImdbId(),
                        favs.getMovie().getTitle(),
                        favs.getMovie().getPoster(),
                        favs.getMovie().getImdbRating(),
                        favs.getFavoritedAt()
                ));
    }


    public FavoriteResponseDTO addFavorite(Long userId, String movieImdbId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found."));
        Movie movie = movieRepository.findByImdbId(movieImdbId)
                .orElseGet(() -> {
                    OmdbMovieResponseDTO newMovieDto = omdbClient.findByImdbId(movieImdbId);
                    Movie newMovie = new Movie(
                            newMovieDto.imdbID(),
                            newMovieDto.title(),
                            newMovieDto.year(),
                            newMovieDto.type(),
                            newMovieDto.poster(),
                            newMovieDto.plot(),
                            Double.parseDouble(newMovieDto.imdbRating()),
                            Long.parseLong(newMovieDto.boxOffice().substring(1).replace(",", ""))
                    );

                    return movieRepository.save(newMovie);
                });

        Favorite newFavorite = new Favorite(user, movie);

        repository.save(newFavorite);

        return new FavoriteResponseDTO(
                newFavorite.getId(),
                newFavorite.getMovie().getImdbId(),
                newFavorite.getMovie().getTitle(),
                newFavorite.getMovie().getPoster(),
                newFavorite.getMovie().getImdbRating(),
                newFavorite.getFavoritedAt());
    }
}
