package com.joaocuculo.favoritemovies.services;

import com.joaocuculo.favoritemovies.dto.FavoriteResponseDTO;
import com.joaocuculo.favoritemovies.entities.Favorite;
import com.joaocuculo.favoritemovies.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository repository;

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
}
