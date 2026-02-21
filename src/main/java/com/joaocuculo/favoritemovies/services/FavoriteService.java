package com.joaocuculo.favoritemovies.services;

import com.joaocuculo.favoritemovies.client.OmdbClient;
import com.joaocuculo.favoritemovies.dto.FavoriteResponseDTO;
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

import java.util.List;

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

    /*
    public Favorite insert(Long userId, Long movieId) {
        User user = userRepository.findById(userId);
        Movie movie = movieRepository.findById(movieId)
                .orElseGet(() -> {
                    Movie newMovie = omdbClient.
                })
        return repository.save(new Favorite(user, movie));
    }

     */

    //VERIFICAR ESSA QUESTÃO DE SALVAR FILME FAVORITO
}
