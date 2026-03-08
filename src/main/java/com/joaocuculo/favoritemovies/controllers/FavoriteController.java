package com.joaocuculo.favoritemovies.controllers;

import com.joaocuculo.favoritemovies.dto.FavoriteRequestDTO;
import com.joaocuculo.favoritemovies.dto.FavoriteResponseDTO;
import com.joaocuculo.favoritemovies.entities.User;
import com.joaocuculo.favoritemovies.security.SecurityConfig;
import com.joaocuculo.favoritemovies.services.FavoriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/favorites")
@Tag(name = "favorite", description = "Controlador de favoritos")
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class FavoriteController {

    @Autowired
    private FavoriteService service;

    @GetMapping
    @Operation(summary = "Lista todos favoritos por usuário", description = "Método para listar todos os favoritos do usuário autenticado.")
    @ApiResponse(responseCode = "200", description = "Lista de favoritos retornada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Page<FavoriteResponseDTO>> findByUserId(@AuthenticationPrincipal User user, Pageable pageable) {
        Page<FavoriteResponseDTO> favorites = service.findByUserId(user.getId(), pageable);
        return ResponseEntity.ok().body(favorites);
    }

    @PostMapping
    @Operation(summary = "Adiciona um favorito", description = "Método para adicionar um favorito")
    @ApiResponse(responseCode = "201", description = "Adicionado favorito com sucesso")
    @ApiResponse(responseCode = "409", description = "Filme já adicionado como favorito")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<FavoriteResponseDTO> addFavorite(@AuthenticationPrincipal User user, @RequestBody @Valid FavoriteRequestDTO favoriteRequestDTO) {
        FavoriteResponseDTO favorite = service.addFavorite(user.getId(), favoriteRequestDTO.movieImdbId());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(favorite.id()).toUri();
        return ResponseEntity.created(uri).body(favorite);
    }

    @DeleteMapping(value = "/{favoriteId}")
    @Operation(summary = "Remove favorito", description = "Método para remover um favorito")
    @ApiResponse(responseCode = "204", description = "Favorito removido com sucesso")
    @ApiResponse(responseCode = "400", description = "Favorito não encontrado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> removeFavorite(@AuthenticationPrincipal User user, @PathVariable Long favoriteId) {
        service.removeFavorite(user.getId(), favoriteId);
        return ResponseEntity.noContent().build();
    }
}
