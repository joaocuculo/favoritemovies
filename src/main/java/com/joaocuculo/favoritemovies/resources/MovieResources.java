package com.joaocuculo.favoritemovies.resources;

import com.joaocuculo.favoritemovies.dto.MovieResponseDTO;
import com.joaocuculo.favoritemovies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieResources {

    @Autowired
    private MovieService service;

    @GetMapping(value = "/{imdbId}")
    public ResponseEntity<MovieResponseDTO> findByImdbId(@PathVariable String imdbId) {
        MovieResponseDTO movie = service.findByImdbId(imdbId);
        return ResponseEntity.ok().body(movie);
    }
}
