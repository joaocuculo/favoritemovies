package com.joaocuculo.favoritemovies.controllers;

import com.joaocuculo.favoritemovies.dto.MovieResponseDTO;
import com.joaocuculo.favoritemovies.dto.MovieSearchResponseDTO;
import com.joaocuculo.favoritemovies.security.SecurityConfig;
import com.joaocuculo.favoritemovies.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
@Tag(name = "movie", description = "Controlador de filme")
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    @Operation(summary = "Busca de filmes pelo título", description = "Método para buscar filmes pelo título")
    @ApiResponse(responseCode = "200", description = "Lista de filmes retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Filme não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<MovieSearchResponseDTO> search(@RequestParam String search, @RequestParam(defaultValue = "1") Integer page) {
        MovieSearchResponseDTO moviesSearch = service.search(search, page);
        return ResponseEntity.ok().body(moviesSearch);
    }

    @GetMapping(value = "/{imdbId}")
    @Operation(summary = "Busca de filmes por imdbId", description = "Método para buscar filmes pelo imdbId")
    @ApiResponse(responseCode = "200", description = "Lista de filmes retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Filme não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<MovieResponseDTO> findByImdbId(@PathVariable String imdbId) {
        MovieResponseDTO movie = service.findByImdbId(imdbId);
        return ResponseEntity.ok().body(movie);
    }
}
