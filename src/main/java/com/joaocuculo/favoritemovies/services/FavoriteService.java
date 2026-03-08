package com.joaocuculo.favoritemovies.services;

import com.joaocuculo.favoritemovies.client.OmdbClient;
import com.joaocuculo.favoritemovies.dto.FavoriteResponseDTO;
import com.joaocuculo.favoritemovies.dto.OmdbMovieResponseDTO;
import com.joaocuculo.favoritemovies.entities.Favorite;
import com.joaocuculo.favoritemovies.entities.Movie;
import com.joaocuculo.favoritemovies.entities.User;
import com.joaocuculo.favoritemovies.exceptions.MovieAlreadyFavoritedException;
import com.joaocuculo.favoritemovies.repositories.FavoriteRepository;
import com.joaocuculo.favoritemovies.repositories.MovieRepository;
import com.joaocuculo.favoritemovies.repositories.UserRepository;
import com.joaocuculo.favoritemovies.exceptions.DatabaseException;
import com.joaocuculo.favoritemovies.exceptions.ForbiddenException;
import com.joaocuculo.favoritemovies.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found."));
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
                            parseRating(newMovieDto.imdbRating()),
                            parseBoxOffice(newMovieDto.boxOffice())
                    );

                    return movieRepository.save(newMovie);
                });

        if (repository.existsByUserIdAndMovieId(user.getId(), movie.getId())) {
            throw new MovieAlreadyFavoritedException("This movie has already been favorited.");
        }

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

    public void removeFavorite(Long userId, Long favoriteId) {
        Favorite favorite = repository.findById(favoriteId)
                .orElseThrow(() -> new ResourceNotFoundException(favoriteId));

        if (!favorite.getUser().getId().equals(userId)) {
            throw new ForbiddenException("You are not allowed to delete this favorite.");
        }

        try {
            repository.delete(favorite);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private Double parseRating(String rating) {
        try {
            return Double.parseDouble(rating);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private Long parseBoxOffice(String boxOffice) {
        try {
            if (boxOffice == null || boxOffice.isBlank()) return 0L;
            return Long.parseLong(boxOffice.substring(1).replace(",", ""));
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
