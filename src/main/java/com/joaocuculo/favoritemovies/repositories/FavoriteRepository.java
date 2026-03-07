package com.joaocuculo.favoritemovies.repositories;

import com.joaocuculo.favoritemovies.entities.Favorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    Page<Favorite> findByUserId(Long userId, Pageable pageable);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);
}
