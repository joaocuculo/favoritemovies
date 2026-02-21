package com.joaocuculo.favoritemovies.controllers;

import com.joaocuculo.favoritemovies.dto.UserRequestDTO;
import com.joaocuculo.favoritemovies.dto.UserResponseDTO;
import com.joaocuculo.favoritemovies.entities.User;
import com.joaocuculo.favoritemovies.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        List<UserResponseDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        UserResponseDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
