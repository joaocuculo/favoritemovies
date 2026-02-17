package com.joaocuculo.favoritemovies.resources;

import com.joaocuculo.favoritemovies.dto.MovieResponseDTO;
import com.joaocuculo.favoritemovies.dto.MovieSearchResponseDTO;
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
    public ResponseEntity<MovieSearchResponseDTO> search(@RequestParam String search, @RequestParam(defaultValue = "1") Integer page) {
        MovieSearchResponseDTO moviesSearch = service.search(search, page);
        return ResponseEntity.ok().body(moviesSearch);
    }

    @GetMapping(value = "/{imdbId}")
    public ResponseEntity<MovieResponseDTO> findByImdbId(@PathVariable String imdbId) {
        MovieResponseDTO movie = service.findByImdbId(imdbId);
        return ResponseEntity.ok().body(movie);
    }
}
