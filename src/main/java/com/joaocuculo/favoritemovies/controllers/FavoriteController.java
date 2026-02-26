package com.joaocuculo.favoritemovies.controllers;

import com.joaocuculo.favoritemovies.dto.FavoriteRequestDTO;
import com.joaocuculo.favoritemovies.dto.FavoriteResponseDTO;
import com.joaocuculo.favoritemovies.entities.User;
import com.joaocuculo.favoritemovies.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService service;

    @GetMapping
    public ResponseEntity<Page<FavoriteResponseDTO>> findByUserId(@AuthenticationPrincipal User user, Pageable pageable) {
        Page<FavoriteResponseDTO> favorites = service.findByUserId(user.getId(), pageable);
        return ResponseEntity.ok().body(favorites);
    }

    @PostMapping
    public ResponseEntity<Void> addFavorite(@AuthenticationPrincipal User user, @RequestBody FavoriteRequestDTO favoriteRequestDTO) {
        FavoriteResponseDTO favorite = service.addFavorite(user.getId(), favoriteRequestDTO.movieImdbId());
        return ResponseEntity.ok().build();
    }
}
