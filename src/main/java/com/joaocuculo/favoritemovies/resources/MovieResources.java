package com.joaocuculo.favoritemovies.resources;

import com.joaocuculo.favoritemovies.dto.MovieResponseDTO;
import com.joaocuculo.favoritemovies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieResources {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>> search(@RequestParam String search) {
        List<MovieResponseDTO> movieList = service.search(search);
        return ResponseEntity.ok().body(movieList);
    }

    @GetMapping(value = "/{imdbId}")
    public ResponseEntity<MovieResponseDTO> findByImdbId(@PathVariable String imdbId) {
        MovieResponseDTO movie = service.findByImdbId(imdbId);
        return ResponseEntity.ok().body(movie);
    }
}
