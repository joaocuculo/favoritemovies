package com.joaocuculo.favoritemovies.controllers;

import com.joaocuculo.favoritemovies.dto.FavoriteResponseDTO;
import com.joaocuculo.favoritemovies.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users/{userId}/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService service;

    @GetMapping
    public ResponseEntity<Page<FavoriteResponseDTO>> findByUserId(@PathVariable Long userId, Pageable pageable) {
        Page<FavoriteResponseDTO> favorites = service.findByUserId(userId, pageable);
        return ResponseEntity.ok().body(favorites);
    }
}
